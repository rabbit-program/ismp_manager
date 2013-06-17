package org.infosec.ismp.agent.winsensor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.agent.comm.jms.ObjectSender;
import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.agent.comm.winsensor.model.status.RegisterOfflineStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.RegisterOnlineStatus;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommBaseStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.windowslog.WindowsLog;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerSentHisBO;
import org.infosec.ismp.agent.winsensor.operation.entity.ProblemBO;
import org.infosec.ismp.agent.winsensor.operation.service.AgentDutyManagerSentHisService;
import org.infosec.ismp.agent.winsensor.operation.service.AgentDutyManagerService;
import org.infosec.ismp.agent.winsensor.operation.service.ProblemService;
import org.infosec.ismp.agent.winsensor.register.WinsensorRegisterInfo;
import org.infosec.ismp.agent.winsensor.service.WinsensorDeviceService;
import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;
import org.infosec.ismp.agent.winsensor.strategy.service.StrategyService;
import org.infosec.ismp.agent.winsensor.util.CollectionsUtil;

/**
 * 1，提供添加hostResources基本信息接口； 
 * 2，利用事件模块来上传hostResources基本信息，由接口来触发上传动作；
 * 3，提供sensor client注册接口，上报IP等； 
 * 4，处理客户端的注册动作，首次注册，触发事件并上传；
 * 5，提供对设备进行监控的各种操作，开始、暂停、停止； 6，提供查询设备状态； 
 * 7，单独线程侦测设备的状态，轮询设备是否在线；
 * 8，提供sensor日志接口； 
 * 9，处理sensor日志信息；
 * 
 * @author Rocky
 * @version create time：Sep 30, 2010 9:39:18 AM
 * 
 */
public class SensorServer {
	
	private static Log log = LogFactory.getLog(SensorServer.class);
	
	private static Log hostResourceLogger = LogFactory.getLog("hostResourceLog");
	
	private static Log windowsLogger = LogFactory.getLog("windowsLog");
	
	private static Log registerBasicInfo = LogFactory.getLog("registerBasicInfo");
	
	public static final int DEFAL_CLIENT_STATE_SCHEDULE_TIME = 30;		//轮询间隔时间，单位：秒

	private WinsensorDeviceService winsensorDeviceService;
	
	private StrategyService strategyService;
	
	private ObjectSender windowsLogSender;
	
	private ObjectSender hostResourceSender;
	
	private ObjectSender registerOnlineStatusSender;
	
	private ObjectSender registerOfflineStatusSender;
	
	private ObjectSender operationProblemSender;
	
	private String agentId;		//Agent sensor identify.
	
	private String agentAddress;
	
	private AgentDutyManagerService agentDutyManagerService;
	
	private AgentDutyManagerSentHisService agentDutyManagerSentHisService;
	
	private ProblemService problemService;

	/*
	 * All monitoring devices can be legally.
	 */
	private List<WinsensorDeviceBO> allLegalMonitorDevices = new ArrayList<WinsensorDeviceBO>();

	/*
	 * All monitoring devices's ipAddress can be legally.
	 */
	private List<String> allLegalMonitorDevicesSensorIdList = new ArrayList<String>();

	/*
	 * All current monitoring devices info.
	 */
	private Hashtable<WinsensorDeviceBO, WinsensorClient> allCurrentMonitoringWinsensorClient = 
		new Hashtable<WinsensorDeviceBO, WinsensorClient>();

	/*
	 * All current monitoring devices's sensorId.
	 */
	private List<String> allCurrentMonitoringDevicesSensorIdList = new ArrayList<String>();

	/*
	 * All devices's ipAddress that not monitoring, but could be monitor. In
	 * other words, the sensor client is connected to the server, but did not
	 * monitor it.
	 */
	private List<String> allCouldMonitorButNotDevicesSensorIdList = new ArrayList<String>();

	/*
	 * All current registering sensor client info.
	 */
	private Hashtable<CommWinsensorDevice, RegisterClient> allCouldMonitorButNotRegisterClient = 
		new Hashtable<CommWinsensorDevice, RegisterClient>();
	
	/*
	 * Store hostResources info. first-in-first-out
	 */
	private LinkedBlockingQueue<HostResource> hostResourcesContainer = new LinkedBlockingQueue<HostResource>(1000);
	
	private LinkedBlockingQueue<List<WindowsLog>> windowsLogContainner = new LinkedBlockingQueue<List<WindowsLog>>(1000);
	
	/*
	 * All not issued strategy assort by sensorId.
	 */
	private Map<String, List<BaseStrategy>> allUnissuedStrategyAssortBySensorId = new HashMap<String, List<BaseStrategy>>();
	
	private Set<String> sensorIdsNeedRefreshStrategy = new HashSet<String>();
	
	private Set<String> sensorIdsNeedRefreshDuty = new HashSet<String>();
	
	private Set<String> sensorIdsNeedRemovedCurrentDuty = new HashSet<String>();
	
	private Set<String> sensorIdsNeedRefreshProblemStatus = new HashSet<String>();
	
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
	
	/*
	 * Sensor client state schedule interval time. 
	 */
	private int clientStateScheduleTime;
	
	/*
	 * How long it clean up duty status.
	 */
	private int dutyStatusScheduleTime;
	
	/*
	 * How long it clean up workOrders status.
	 */
	private int workOrdersStatusScheduleTime;
	
	private long hostResourcesCount = 0;
	
	private long windowsLogsCount = 0;
	
	/*
	 * Load all legal monitor device.
	 * Load all legal monitor device's strategy
	 */
	public void init() {
		log.info("Sensor server init.");
		
		//Load all monitored device.
		allLegalMonitorDevices = winsensorDeviceService.getAllMonitorDevices();
		
		//Load all monitored device's sensorId.
		for (WinsensorDeviceBO device : allLegalMonitorDevices) {
			allLegalMonitorDevicesSensorIdList.add(device.getSensorId());
			
			log.debug("Load legal monitor device, Ip: " + device.getIpAddress() 
					+ " sensorId: " + device.getSensorId() );
		}
		
		//Load all un-issued strategy and sensorId mapping.
		allUnissuedStrategyAssortBySensorId = strategyService.getAllTypeUnissuedStrategy(allLegalMonitorDevicesSensorIdList);
		//Load all sensorId that need refresh strategy.
		sensorIdsNeedRefreshStrategy = allUnissuedStrategyAssortBySensorId.keySet();
		log.debug("Load sensorIdsNeedRefreshStrategy include: " 
				+ CollectionsUtil.mergeAllElements(sensorIdsNeedRefreshStrategy));
		
		//Load all sensorId that need publish new duty.
		sensorIdsNeedRefreshDuty.addAll(
				agentDutyManagerSentHisService.getAllUnsentDutySensorId(allLegalMonitorDevicesSensorIdList));
		
		//Load all sensorId that need removed current duty.
		sensorIdsNeedRemovedCurrentDuty.addAll(
				agentDutyManagerSentHisService.getAllUnremovedDutySensorId(allLegalMonitorDevicesSensorIdList));
		
		start();
		
		log.info("Sensor server init finish.");
	}
	
	/*
	 * Start winsensor server.
	 */
	public void start() {
		HostResourceClient hostResourceClient = new HostResourceClient();
		new Thread(hostResourceClient, "hostResource info handle thread").start();
		
		WindowsLogClient windowsLogClient = new WindowsLogClient();
		new Thread(windowsLogClient, "windowLog handle thread").start();
		
		DeviceStatusScheduledExecutor deviceStatusScheduledExecutor = new DeviceStatusScheduledExecutor();
		service.scheduleAtFixedRate(new Thread(deviceStatusScheduledExecutor, "监控设备状态管理执行器"),
				100, ((getClientStateScheduleTime() <= 0) ? DEFAL_CLIENT_STATE_SCHEDULE_TIME : getClientStateScheduleTime()), 
				TimeUnit.SECONDS);
		
		RegisterStatusScheduledExecutor registerStatusScheduledExecutor = new RegisterStatusScheduledExecutor();
		service.scheduleAtFixedRate(new Thread(registerStatusScheduledExecutor, "注册设备状态管理执行器"), 
				100, ((getClientStateScheduleTime() <= 0) ? DEFAL_CLIENT_STATE_SCHEDULE_TIME : getClientStateScheduleTime()), 
				TimeUnit.SECONDS);
		
		DutyStatusScheduledExecutor dutyStatusScheduledExecutor = new DutyStatusScheduledExecutor();
		service.scheduleAtFixedRate(new Thread(dutyStatusScheduledExecutor, "值班分配管理执行器"), 
				100, (getDutyStatusScheduleTime() <= 0) ? 3600 : getDutyStatusScheduleTime(), TimeUnit.SECONDS);
		
		WorkOrdersStatusScheduledExecutor workOrdersStatusScheduledExecutor = new WorkOrdersStatusScheduledExecutor();
		service.scheduleAtFixedRate(new Thread(workOrdersStatusScheduledExecutor, "工单状态管理执行器"), 
				100, (getWorkOrdersStatusScheduleTime() <= 0) ? 3600 : getWorkOrdersStatusScheduleTime(), 
						TimeUnit.SECONDS);
	}

	/*
	 * Winsensor client register to server.
	 */
	public List<BaseStrategy> registerWinsensorClientInfo(WinsensorRegisterInfo registerInfo) {
		String ipAddress = registerInfo.getIp();
		String sensorId = registerInfo.getSensorId();
		List<BaseStrategy> strategy = new ArrayList<BaseStrategy>();
		
		log.debug("Sensor client register to Sensor server, ip: " + ipAddress + " sensorId: " + sensorId);
		
		if (null == ipAddress || ipAddress.equals("") || null == sensorId || sensorId.equals("")) {
			return strategy;
		}

		if (allCurrentMonitoringDevicesSensorIdList.contains(sensorId)
				|| allCouldMonitorButNotDevicesSensorIdList.contains(sensorId)) {
			// Registered
			// Refresh monitoring device online status time.
			if (allCurrentMonitoringDevicesSensorIdList.contains(sensorId)) {
				WinsensorDeviceBO device = findDeviceFromLegalMonitorListBySensorId(sensorId);
				if (device != null) {
					WinsensorClient winsensorClient = allCurrentMonitoringWinsensorClient.get(device);
					if (winsensorClient != null) {
						winsensorClient.setLastRegisterTime(System.currentTimeMillis());
					}
					
					//Return strategy when has new strategy.
					if (sensorIdsNeedRefreshStrategy.contains(sensorId)) {
						strategy = allUnissuedStrategyAssortBySensorId.get(sensorId);
						log.debug("sensorId: " + sensorId + " ip: " + ipAddress + " issued new strategy");
					}
				}
			} else if (allCouldMonitorButNotDevicesSensorIdList.contains(sensorId)) {
				//Refresh registering device online status time, the device have not monitored.
				CommWinsensorDevice commDevice = findCommDeviceFromRegisterListBySensorId(sensorId);
				if (commDevice != null) {
					RegisterClient registerClient = allCouldMonitorButNotRegisterClient.get(commDevice);
					if (registerClient != null) {
						registerClient.setLastRegisterTime(System.currentTimeMillis());
					}
				}
			}
		} else {
			// First register, refresh ipAddress list.
			if (allLegalMonitorDevicesSensorIdList.contains(sensorId)) {
				//Handle legal monitor devices.
				log.info("Sensor client Ip address: " + ipAddress + " sensorId: " + sensorId + " on-line.");
				
				allCurrentMonitoringDevicesSensorIdList.add(sensorId);
				
				WinsensorDeviceBO device = findDeviceFromLegalMonitorListBySensorId(sensorId);
				WinsensorClient client = new WinsensorClient();
				
				allCurrentMonitoringWinsensorClient.remove(device);
				allCurrentMonitoringWinsensorClient.put(device, client);
				
				//Upload legal monitor devices online status when first register.
				RegisterOnlineStatus onlineStatus = new RegisterOnlineStatus();
				onlineStatus.setCommDevice(device.getCommDevice());
				onlineStatus.setRegisterTime(new Date());
				
				uploadOnlineStatus(onlineStatus);
			} else {
				//Handle illegal devices.
				log.info("Sensor client Ip address: " + ipAddress + " sensorId: " + sensorId + " mac: " + registerInfo.getMac() + " register.");
				registerBasicInfo.debug("Sensor client Ip address: " + ipAddress + " sensorId: " + sensorId 
						+ " mac: " + registerInfo.getMac() + " register.");
				
				allCouldMonitorButNotDevicesSensorIdList.add(sensorId);
				
				CommWinsensorDevice commDevice = new CommWinsensorDevice();
				commDevice.setIp(ipAddress);
				commDevice.setSensorId(sensorId);
				commDevice.setMac(registerInfo.getMac());
				
				RegisterClient client = new RegisterClient();
				
				allCouldMonitorButNotRegisterClient.remove(commDevice);
				allCouldMonitorButNotRegisterClient.put(commDevice, client);
				
				// Upload illegal monitor devices online status when first register.
				RegisterOnlineStatus onlineStatus = new RegisterOnlineStatus();
				onlineStatus.setCommDevice(commDevice);
				onlineStatus.setRegisterTime(new Date());
				
				uploadOnlineStatus(onlineStatus);
			}
		}
		
		return strategy;
	}
	
	/*
	 * When strategies send successful, call back this method. 
	 * Modify strategies issue status in database, and remove cache from memory.
	 */
	public void strategySendSuccess(WinsensorRegisterInfo registerInfo, List<BaseStrategy> strategies) {
		String sensorId = registerInfo.getSensorId();
		
		if (sensorIdsNeedRefreshStrategy.contains(sensorId)) {
			for (BaseStrategy strategy : strategies) {
				strategy.setIssued(1);
				strategy.setIssueTime(new Date());
			}
			strategyService.updateStrategy(strategies);
			
			synchronized (sensorIdsNeedRefreshStrategy) {
				sensorIdsNeedRefreshStrategy.remove(sensorId);
			}
			
			synchronized (allUnissuedStrategyAssortBySensorId) {
				allUnissuedStrategyAssortBySensorId.remove(sensorId);
			}
			
			log.debug("Sensor client ip: " + registerInfo.getIp() + " sensorId: " + sensorId + " refresh strategy success.");
		}
	}
	
	/*
	 * Inserts the specified hostResource at the tail of the queue. provided to
	 * the external use.
	 */
	public void addHostResource(HostResource hostResource) {
		if (allCurrentMonitoringDevicesSensorIdList.contains(hostResource.getWinsensorClientStatus().getSensorId())) {
			WinsensorDeviceBO device = findDeviceFromLegalMonitorListBySensorId(hostResource.getWinsensorClientStatus().getSensorId());
			
			if (null == device) {
				log.warn("Warn while add a hostResource, device not found. device sensorId: " 
						+ hostResource.getWinsensorClientStatus().getSensorId());
				return;
			}
			
			hostResource.setDevice(device.getCommDevice());
			
			synchronized (hostResourcesContainer) {
				hostResourcesContainer.offer(hostResource);
				hostResourcesContainer.notifyAll();
			}
			
			log.debug("Winsensor client add a hostResource info, client ip: " + hostResource.getDevice().getIp() + " nodeId: " 
					+ hostResource.getDevice().getNodeId());
		} else {
			log.debug("Discard a hostResource is not allowed, client sensorId: " + hostResource.getWinsensorClientStatus().getSensorId());
		}
	}

	public void addWindowsLog(List<WindowsLog> windowsLogs) {
		if ((windowsLogs.size() > 0) && allCurrentMonitoringDevicesSensorIdList.contains(windowsLogs.get(0).getSensorId())) {
			synchronized (windowsLogContainner) {
				windowsLogContainner.offer(windowsLogs);
				windowsLogContainner.notifyAll();
			}
			
			log.debug("Sensor client ip: " + windowsLogs.get(0).getSensorIp() + " sensorId: " 
					+ windowsLogs.get(0).getSensorId() + " add " + windowsLogs.size() + " windowsLog.");
		}
	}
	

	public AgentDutyManagerBO getNewDutyInfo(String sensorId) {
		if (sensorIdsNeedRefreshDuty.contains(sensorId)) {
			List<AgentDutyManagerSentHisBO> sentHistories = agentDutyManagerSentHisService.getAllUnsentDutyManager(sensorId);
			
			return agentDutyManagerService.getCurrentUsedDutyManager(sentHistories);
		}
		
		return null;
	}
	

	public void commitOperationProblems(List<Problem> problems) {
		//Charge if sent, if not, Saved it. Otherwise, do nothing.
		for (Problem problem : problems) {
			Boolean isNewProblem = problemService.addProblem(problem);
			
			if (isNewProblem) {
				//Upload problems, if send success, update problem sent status.
				if (uploadProblem(problem)) {
					problemService.updateUploadSuccessInfo(problem.getProblemId());
				}
			}
		}
	}

	public Boolean uploadProblem(Problem problem) {
		operationProblemSender.sendSerializableObject(problem);
		
		return true;
	}
	
	public List<ProblemBO> getOperationWorkOrdersInfo(String sensorId) {
		List<ProblemBO> problems = null;
		if (sensorIdsNeedRefreshProblemStatus.contains(sensorId)) {
			problems = problemService.findBySensorId(sensorId);
		}
		
		return problems;
	}
	
	public Boolean ifRemovedCurrentDutyInfo(String sensorId) {
		if (sensorIdsNeedRemovedCurrentDuty.contains(sensorId)) {
			return true;
		}
		
		return false;
	}
	
	public void removedCurrentDutySuccess(String sensorId) {
		agentDutyManagerSentHisService.updateRemovedSuccessHistory(sensorId);
		sensorIdsNeedRemovedCurrentDuty.remove(sensorId);
	}
	
	public void dutySendSuccess(String sensorId, String dutyManagerId) {
		agentDutyManagerSentHisService.updateSendSuccessHistory(dutyManagerId, sensorId);
		sensorIdsNeedRefreshDuty.remove(sensorId);
	}
	
	/*
	 * Accept dutyManager from manager.
	 */
	public void publishDutyManager(List<DutyManager> dutyManagers) {
		//Saved dutyManagers to the database.
		agentDutyManagerService.addDutyManager(dutyManagers);
		
		//Create mapping about dutyManager and sensorId by domain.
		List<String> sensorIds = agentDutyManagerSentHisService.addSentHistory(dutyManagers, getAllLegalMonitorDevices());
		
		//Cache all sensorId that need refresh duty.
		sensorIdsNeedRefreshDuty.addAll(sensorIds);
	}
	
	/*
	 * Delete published dutyManager.
	 */
	public void deleteDutyManager(String dutyManagerId) {
		agentDutyManagerService.deleteDutyManager(dutyManagerId);
		List<String> sensorIds = agentDutyManagerSentHisService.deleteDutyManager(dutyManagerId, allLegalMonitorDevicesSensorIdList);
		sensorIdsNeedRemovedCurrentDuty.addAll(sensorIds);
	}

	public void receivedOperationProblem(String problemId) {
		ProblemBO problem = problemService.findByProblemId(problemId);
		if (problem != null) {
			problemService.receivedOperationProblem(problem);
		}
	}

	public void closeOperationProblem(String problemId) {
		ProblemBO problem = problemService.findByProblemId(problemId);
		if (problem != null) {
			problemService.closeOperationProblem(problem);
		}
	}

	public void generateWorkOrders(String problemId, String workOrdersId) {
		ProblemBO problem = problemService.findByProblemId(problemId);
		if (problem != null) {
			problemService.generateWorkOrders(problem, workOrdersId);
		}
	}

	public void closeWorkOrders(String problemId, String workOrdersId) {
		ProblemBO problem = problemService.findByProblemId(problemId);
		if (problem != null && problem.getWorkOrdersId().equals(workOrdersId)) {
			problemService.closeWorkOrders(problem);
		}
	}

	public void completeWorkOrders(String problemId, String workOrdersId) {
		ProblemBO problem = problemService.findByProblemId(problemId);
		if (problem != null && problem.getWorkOrdersId().equals(workOrdersId)) {
			problemService.completeWorkOrders(problem);
		}
	}

	public void workOrdersStatusSendSuccess(List<ProblemBO> problems) {
		if (problems != null ) {
			for (ProblemBO problem : problems) {
				if ((problem.getIfProblemClosed() != null) && (problem.getIfProblemClosed() == true) 
						&& (problem.getIfSendProbClosed() != null) && (problem.getIfSendProbClosed() == false)) {
					problemService.sendProblemClosedSuccess(problem);
				}
				
				if ((problem.getIfGeneratedWorkOrders() != null) && (problem.getIfGeneratedWorkOrders() == true) 
						&& (problem.getIfSendGeneWorkOrders() != null) && (problem.getIfSendGeneWorkOrders() == false)) {
					problemService.sendOrdersGeneratedSuccess(problem);
				}
				
				if ((problem.getIfWorkOrdersClosed() != null) && (problem.getIfWorkOrdersClosed() == true) 
						&& (problem.getIfSendWorkOrdersClosed() != null) && (problem.getIfSendWorkOrdersClosed() == false)) {
					problemService.sendOrdersClosedSuccess(problem);
				}
				
				if ((problem.getIfWorkOrdersComplete() != null) && (problem.getIfWorkOrdersComplete() == true) 
						&& (problem.getIfSendOrdersCompleted() != null) && (problem.getIfSendOrdersCompleted() == false)) {
					problemService.sendOrdersCompleteSuccess(problem);
				}
			}
		}
	}
	
	/*
	 * Find device from memory(allLegalMonitorDevices) by sensorId, avoid frequent operational database.
	 */
	public WinsensorDeviceBO findDeviceFromLegalMonitorListBySensorId(String sensorId) {
		WinsensorDeviceBO device = null;
		
		if (null == sensorId || sensorId.trim().equals("")) {
			return device;
		}
		
		for (int i = 0; i < allLegalMonitorDevices.size(); i++) {
			if (sensorId.equals(allLegalMonitorDevices.get(i).getSensorId())) {
				device = allLegalMonitorDevices.get(i);
			}
		}

		return device;
	}

	/*
	 * Find device from memory(allLegalMonitorDevices) by nodeId, avoid frequent operational database.
	 */
	public WinsensorDeviceBO findDeviceFromLegalMonitorListByNodeId(String nodeId) {
		WinsensorDeviceBO device = null;
		
		if (null == nodeId || nodeId.trim().equals("")) {
			return device;
		}
		
		for (int i = 0; i < allLegalMonitorDevices.size(); i++) {
			if (nodeId.equals(allLegalMonitorDevices.get(i).getNodeId())) {
				device = allLegalMonitorDevices.get(i);
				break;
			}
		}
		
		return device;
	}
	
	/*
	 * Find commDevice from memory(allCouldMonitorButNotRegisterClient) by sensorId.
	 */
	public CommWinsensorDevice findCommDeviceFromRegisterListBySensorId(String sensorId) {
		CommWinsensorDevice commDevice = null;
		
		if (null == sensorId || sensorId.trim().equals("")) {
			return commDevice;
		}
		
		synchronized (allCouldMonitorButNotRegisterClient) {
			Set<CommWinsensorDevice> commDevices = allCouldMonitorButNotRegisterClient.keySet();
			for (CommWinsensorDevice device : commDevices) {
				if (sensorId.equals(device.getSensorId())) {
					commDevice = device;
					break;
				}
			}
		}
		
		return commDevice;
	}
	
	/*
	 * Obtain the first hostResource in the queue and removed it from the queue.
	 * If the queue is no data, returns null.
	 */
	private HostResource getNextHostResource() {
		return hostResourcesContainer.poll();
	}
	
	/*
	 * Obtain the first windowsLogs in the queue and removed it from the queue.
	 * If the queue is no data, returns null.
	 */
	private List<WindowsLog>	getNextWindowsLog() {
		return windowsLogContainner.poll();
	}

	/*
	 * Upload online status, when first up for the sensor client.
	 */
	public void uploadOnlineStatus(RegisterOnlineStatus onlineStatus) {
		packageAgentBaseInfo(onlineStatus.getCommDevice());
		registerOnlineStatusSender.sendSerializableObject(onlineStatus);
	}
	
	/*
	 * Upload off-line status, when sensor client was not registered in some time.
	 */
	public void uploadOfflineStatus(RegisterOfflineStatus offlineStatus) {
		registerOfflineStatusSender.sendSerializableObject(offlineStatus);
	}
	
	/*
	 * Upload hostResource info, use common event module.
	 */
	public void uploadHostResource(HostResource hostResource) {
		hostResourceLogger.debug(hostResource.getHostResourceInfo());
		
		hostResourceSender.sendSerializableObject(hostResource);
		
		// TODO
		log.debug("Upload hostResource info, sensor client (ip: " + hostResource.getDevice().getIp() + " nodeId: " 
				+ hostResource.getDevice().getNodeId() + "). all upload size: " + (++hostResourcesCount) );
	}

	public void uploadWindowsLog(List<WindowsLog> windowsLogs) {
		for (WindowsLog windowsLog : windowsLogs) {
			windowsLogger.debug(windowsLog.getWindowsLogInfo());
		}
		
		windowsLogSender.sendSerializableObject((ArrayList<WindowsLog>) windowsLogs);
		
		// TODO
		log.debug("Sensor server upload sensor client (ip: " + windowsLogs.get(0).getSensorIp() + " sensorId: " 
				+ windowsLogs.get(0).getSensorId() + ") windowsLog. all upload times: " + (++windowsLogsCount) );
	}
	
	/*
	 * Package Agent base info, including agent id and ipAddress.
	 */
	public void packageAgentBaseInfo(CommWinsensorDevice commDevice) {
		commDevice.setAgentId(getAgentId());
		commDevice.setAgentAddress(getAgentAddress());
	}
	
	//********************External interface********************
	
	/*
	 * Add the monitor device.
	 */
	public Boolean addMonitorDevice(CommWinsensorDevice commDevice) {
		if (null == commDevice) {
			log.warn("Warn while adding a device, this device is null");
			return false;
		}
		
		if (commDevice.getNodeId().trim().equals("") || commDevice.getIp().trim().equals("") 
				|| commDevice.getSensorId().trim().equals("") || commDevice.getMac().trim().equals("")) {
			log.warn("Warn while adding a device, please check properties. device ip: " + commDevice.getIp() 
					+ " nodeId: " + commDevice.getNodeId() + " sensorId: " + commDevice.getSensorId() 
					+ " mac: " + commDevice.getMac());
			return false;
		}
		
		WinsensorDeviceBO device = new WinsensorDeviceBO();
		device.setIpAddress(commDevice.getIp());
		device.setMacAddress(commDevice.getMac());
		device.setSensorId(commDevice.getSensorId());
		device.setNodeId(commDevice.getNodeId());
		device.setDomainId(commDevice.getDomainId());
		device.setCreateTime(new Date());
		device.setFlag(WinsensorConstant.DEVICE_NOT_MONITOR_STATUS);
		device.setTimeout((commDevice.getTimeout() <= 0) ? WinsensorConstant.DEVICE_DEFAULT_TIMEOUT : commDevice.getTimeout());
		device.setRetries((commDevice.getRetries() <= 0) ? WinsensorConstant.DEVICE_DEFAULT_RETRIES : commDevice.getRetries());
		
		winsensorDeviceService.addDevice(device);
		
		log.info("Add a monitor device, ip: " + device.getIpAddress() + " sensorId: " + device.getSensorId() 
				+ " nodeId: " + device.getNodeId());
		return true;
	}
	
	/*
	 * Update the device info.
	 */
	public Boolean updateMonitorDevice(CommWinsensorDevice commDevice) {
		if (null == commDevice) {
			log.warn("Warn while update a device, this device is null");
			return false;
		}
		
		WinsensorDeviceBO device = findDeviceFromLegalMonitorListByNodeId(commDevice.getNodeId());
		if (null == device) {
			log.warn("Warn while update a device, the device is not found. device nodeId: " + commDevice.getNodeId());
			return false;
		}
		
		device.setTimeout((commDevice.getTimeout() <= 0) ? WinsensorConstant.DEVICE_DEFAULT_TIMEOUT : commDevice.getTimeout());
		device.setRetries((commDevice.getRetries() <= 0) ? WinsensorConstant.DEVICE_DEFAULT_RETRIES : commDevice.getRetries());
		winsensorDeviceService.updateDevice(device);
		
		log.info("Update a monitor device info, ip: " + device.getIpAddress() + " nodeId: " + device.getNodeId() 
				+ ". and timeout changed to " + device.getTimeout() + ", retries changed to " + device.getRetries());
		return true;
	}

	/*
	 * Batch add the monitor devices.
	 */
	public void addMonitorDevice(List<CommWinsensorDevice> commDevices) {
		for (CommWinsensorDevice commDevice : commDevices) {
			addMonitorDevice(commDevice);
		}
	}

	/*
	 * Starting monitor the device.
	 */
	public Boolean startingMonitor(String nodeId) {
		WinsensorDeviceBO device = winsensorDeviceService.findDeviceByNodeId(nodeId);
		
		if (null == device) {
			log.warn("Warn while starting monitor a device, the device is not found. device nodeId: " + nodeId);
			return false;
		}
		
		device.setFlag(WinsensorConstant.DEVICE_MONITORING_STATUS);
		winsensorDeviceService.updateDevice(device);
		
		allLegalMonitorDevicesSensorIdList.add(device.getSensorId());
		allLegalMonitorDevices.add(device);
		allCouldMonitorButNotDevicesSensorIdList.remove(device.getSensorId());
		
		log.info("Starting monitor device, ip: " + device.getIpAddress() + " nodeId: " + nodeId);
		return true;
	}

	/*
	 * Batch starting the monitor devices.
	 */
	public void startingMonitor(List<String> nodeIds) {
		for (String nodeId : nodeIds) {
			startingMonitor(nodeId);
		}
	}

	/*
	 * Pause the monitoring device, include off-line device.
	 */
	public Boolean pauseMonitor(String nodeId) {
		WinsensorDeviceBO device = findDeviceFromLegalMonitorListByNodeId(nodeId);
		
		if (null == device) {
			log.warn("Warn while pause monitor a device, the device is not found. device nodeId: " + nodeId);
			return false;
		}
		
		device.setFlag(WinsensorConstant.DEVICE_MONITOR_PAUSE_STATUS);
		winsensorDeviceService.updateDevice(device);
		
		allLegalMonitorDevicesSensorIdList.remove(device.getSensorId());
		allLegalMonitorDevices.remove(device);
		if (allCurrentMonitoringDevicesSensorIdList.contains(device.getSensorId())) {
			allCurrentMonitoringDevicesSensorIdList.remove(device.getSensorId());
			allCurrentMonitoringWinsensorClient.remove(device);
			allCouldMonitorButNotDevicesSensorIdList.add(device.getSensorId());
		}
		
		log.info("Pause monitor device, ip: " + device.getIpAddress() + " nodeId: " + device.getNodeId());
		return true;
	}

	/*
	 * Batch pause the monitoring devices.
	 */
	public void pauseMonitor(List<String> nodeIds) {
		for (String nodeId : nodeIds) {
			pauseMonitor(nodeId);
		}
	}

	/*
	 * Stop the monitoring device, include off-line device.
	 * remove device from database.
	 */
	public Boolean stopMonitor(String nodeId) {
		WinsensorDeviceBO device = findDeviceFromLegalMonitorListByNodeId(nodeId);
		
		if (null == device) {
			log.warn("Warn while stop monitor a device, the device is not found. device nodeId: " + nodeId);
			return false;
		}
		
		allLegalMonitorDevicesSensorIdList.remove(device.getSensorId());
		allLegalMonitorDevices.remove(device);
		if (allCurrentMonitoringDevicesSensorIdList.contains(device.getSensorId())) {
			allCurrentMonitoringDevicesSensorIdList.remove(device.getSensorId());
			allCurrentMonitoringWinsensorClient.remove(device);
			allCouldMonitorButNotDevicesSensorIdList.add(device.getSensorId());
		}
		
		winsensorDeviceService.deleteDevice(device);
		
		log.info("Sensor server stopped monitor device, ip: " + device.getIpAddress() + " sensorId: " + device.getSensorId());
		return true;
	}

	/*
	 * Batch stop the monitoring devices, include off-line devices. 
	 * remove devices from database.
	 */
	public void stopMonitor(List<String> nodeIds) {
		for (String nodeId : nodeIds) {
			stopMonitor(nodeId);
		}
	}

	/*
	 * Add new strategies.
	 * First, add all new strategies to database. and clear all strategy info in memory, 
	 * then reload all strategies info from database.
	 */
	public void updateStrategy(List<CommBaseStrategy> strategies) {
		if (strategies.isEmpty()) {
			return;
		}
		
		strategyService.addStrategy(strategies);
		
		synchronized (allUnissuedStrategyAssortBySensorId) {
			allUnissuedStrategyAssortBySensorId.clear();
			sensorIdsNeedRefreshStrategy.clear();
			allUnissuedStrategyAssortBySensorId = strategyService.getAllTypeUnissuedStrategy(allLegalMonitorDevicesSensorIdList);
			sensorIdsNeedRefreshStrategy = allUnissuedStrategyAssortBySensorId.keySet();
		}
	}

	private class DeviceStatusScheduledExecutor implements Runnable{

		public void run() {
			log.debug("Schedule executor clear up current monitoring device status.");
			
			synchronized (allCurrentMonitoringWinsensorClient) {
				Set<WinsensorDeviceBO> devices = allCurrentMonitoringWinsensorClient.keySet();
				Iterator<WinsensorDeviceBO> iterator = devices.iterator();
				while (iterator.hasNext()) {
					WinsensorDeviceBO device = iterator.next();
					WinsensorClient client = allCurrentMonitoringWinsensorClient.get(device);
					
					log.debug("Current monitor device include: ip: " + device.getIpAddress() + " sensorId: " + device.getSensorId());
					
					//Determine the time-out, if device continuous timeout default times.
					//Each device have default timeout and retries.
					if ((client.getLastRegisterTime() - System.currentTimeMillis()) > (
							(device.getTimeout() <= 0L) ? WinsensorConstant.DEVICE_DEFAULT_TIMEOUT : device.getTimeout())) {
						client.setRegisterOfflineTimes(client.getRegisterOfflineTimes() + 1);
					} else {
						if (client.getRegisterOfflineTimes() != 0) {
							client.setRegisterOfflineTimes(0);
						}
					}
					if (client.getRegisterOfflineTimes() >= ((device.getRetries() <= 0) ? 
							WinsensorConstant.DEVICE_DEFAULT_RETRIES : device.getRetries())) {
						allCurrentMonitoringDevicesSensorIdList.remove(device.getSensorId());
						allCurrentMonitoringWinsensorClient.remove(device);
						
						//Upload legal device off-line.
						RegisterOfflineStatus offlineStatus = new RegisterOfflineStatus();
						offlineStatus.setCommDevice(device.getCommDevice());
						offlineStatus.setOfflineTime(new Date());		//Not exact time;
						
						uploadOfflineStatus(offlineStatus);
						
						log.info("Sensor device(ip: " + device.getIpAddress() + " sensorId: " + device.getSensorId() 
								+ ") continuous timeout " + device.getRetries() + " times, the default timeout is " + device.getTimeout() 
								+ ". And system determines the device is offline.");
					}
				}
			}
		}
	}
	
	private class RegisterStatusScheduledExecutor implements Runnable {
		
		public void run() {
			log.debug("Schedule executor clear up current registering device status.");
			
			synchronized (allCouldMonitorButNotRegisterClient) {
				Set<CommWinsensorDevice> commDevices = allCouldMonitorButNotRegisterClient.keySet();
				Iterator<CommWinsensorDevice> iterator = commDevices.iterator();
				while (iterator.hasNext()) {
					CommWinsensorDevice commDevice = iterator.next();
					RegisterClient client = allCouldMonitorButNotRegisterClient.get(commDevice);
					
					if ((client.getLastRegisterTime() - System.currentTimeMillis()) > WinsensorConstant.DEVICE_DEFAULT_TIMEOUT) {
						client.setRegisterOfflineTimes(client.getRegisterOfflineTimes() + 1);
					} else {
						if (client.getRegisterOfflineTimes() != 0) {
							client.setRegisterOfflineTimes(0);
						}
					}
					
					if (client.getRegisterOfflineTimes() >= WinsensorConstant.DEVICE_DEFAULT_RETRIES) {
						allCouldMonitorButNotDevicesSensorIdList.remove(commDevice.getSensorId());
						allCouldMonitorButNotRegisterClient.remove(commDevice);
						
						////Upload illegal device off-line.
						RegisterOfflineStatus offlineStatus = new RegisterOfflineStatus();
						offlineStatus.setCommDevice(commDevice);
						offlineStatus.setOfflineTime(new Date());
						
						uploadOfflineStatus(offlineStatus);
					}
				}
			}
		}
	}
	
	private class DutyStatusScheduledExecutor implements Runnable {

		@Override
		public void run() {
			synchronized (sensorIdsNeedRefreshDuty) {
				//Handle expired DutyManager.
				List<String> dutyManagerIds = agentDutyManagerService.cleanUpExpiredDutyManagers();
				agentDutyManagerSentHisService.cleanUpExpiredSentHistory(dutyManagerIds);
				List<AgentDutyManagerBO> allCurrentUsedDutyManager = agentDutyManagerService.getAllCurrentUsedDutyManager();
				if (allCurrentUsedDutyManager.size() > 0) {
					List<String> sensorIds = agentDutyManagerSentHisService.getAllUnsentDutyManager(allCurrentUsedDutyManager);
					sensorIdsNeedRefreshDuty.clear();
					sensorIdsNeedRefreshDuty.addAll(sensorIds);
				}
			}
		}
	}
	
	private class WorkOrdersStatusScheduledExecutor implements Runnable {

		@Override
		public void run() {
			//Upload problems that were not upload success.
			List<Problem> problems = problemService.getAllUnuploadProblem();
			for (Problem problem : problems) {
				if (uploadProblem(problem)) {
					problemService.updateUploadSuccessInfo(problem.getProblemId());
				}
			}
			
			//Find all sensor client that has operation workOrders state changed 
			//and unsent this info to sensor client.
			List<ProblemBO> stateChangedProblems = problemService.getAllStateChangedProblems();
			for (ProblemBO problemBO : stateChangedProblems) {
				sensorIdsNeedRefreshProblemStatus.add(problemBO.getSensorId());
			}
		}
		
	}
	
	/*
	 * Store monitoring device status.
	 *
	 */
	private class WinsensorClient {
		
		private int registerOfflineTimes;

		private long lastRegisterTime;

		public WinsensorClient() {
			setLastRegisterTime(System.currentTimeMillis());
			setRegisterOfflineTimes(0);
		}

		public int getRegisterOfflineTimes() {
			return registerOfflineTimes;
		}

		public void setRegisterOfflineTimes(int registerOfflineTimes) {
			this.registerOfflineTimes = registerOfflineTimes;
		}

		public long getLastRegisterTime() {
			return lastRegisterTime;
		}

		public void setLastRegisterTime(long lastRegisterTime) {
			this.lastRegisterTime = lastRegisterTime;
		}
	}

	/*
	 * Store registering sensor client status.
	 */
	private class RegisterClient {
		
		private int registerOfflineTimes;

		private long lastRegisterTime;
		
		public RegisterClient() {
			setRegisterOfflineTimes(0);
			setLastRegisterTime(System.currentTimeMillis());
		}

		public int getRegisterOfflineTimes() {
			return registerOfflineTimes;
		}

		public void setRegisterOfflineTimes(int registerOfflineTimes) {
			this.registerOfflineTimes = registerOfflineTimes;
		}

		public long getLastRegisterTime() {
			return lastRegisterTime;
		}

		public void setLastRegisterTime(long lastRegisterTime) {
			this.lastRegisterTime = lastRegisterTime;
		}
	}
	
	/*
	 * A separate thread, waiting for hostResourcesContainer when it add element, upload it immediately.
	 */
	private class HostResourceClient implements Runnable {
		
		@Override
		public void run() {
			log.info("Sensor server start HostResourceClient.");
			
			while (true) {
				synchronized (hostResourcesContainer) {
					if (hostResourcesContainer.isEmpty()) {
						try {
							hostResourcesContainer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						for (int i = 0; i < hostResourcesContainer.size(); i++) {
							HostResource hostResource = getNextHostResource();
							uploadHostResource(hostResource);
							
							log.debug("hostResourceClient upload " + hostResource.getDevice().getIp() 
									+ " hostResource info.");
						}
					}
				}
			}
		}
	}
	
	/*
	 * A separate thread, waiting for windowsLogcontainer when it add element, upload it immediately.
	 */
	private class WindowsLogClient implements Runnable {
		
		@Override
		public void run() {
			log.info("Sensor server start WindowsLogClient.");
			
			while (true) {
				synchronized (windowsLogContainner) {
					if (windowsLogContainner.isEmpty()) {
						try {
							windowsLogContainner.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						for (int i = 0; i < windowsLogContainner.size(); i++) {
							List<WindowsLog> windowsLogs = getNextWindowsLog();
							uploadWindowsLog(windowsLogs);
							
							log.debug("WindowsLogClient upload " + windowsLogs.get(0).getSensorIp() 
									+" windowsLog info, size: " + windowsLogs.size());
						}
					}
				}
			}
		}

	}

	// ********************* GETTER SETTER METHOD *********************
	public WinsensorDeviceService getWinsensorDeviceService() {
		return winsensorDeviceService;
	}

	public void setWinsensorDeviceService(
			WinsensorDeviceService winsensorDeviceService) {
		this.winsensorDeviceService = winsensorDeviceService;
	}

	public List<WinsensorDeviceBO> getAllLegalMonitorDevices() {
		return allLegalMonitorDevices;
	}

	public List<String> getAllLegalMonitorDevicesSensorIdList() {
		return allLegalMonitorDevicesSensorIdList;
	}

	public List<String> getAllCurrentMonitoringDevicesSensorIdList() {
		return allCurrentMonitoringDevicesSensorIdList;
	}

	public List<String> getAllCouldMonitoringButNotDevicesSensorIdList() {
		return allCouldMonitorButNotDevicesSensorIdList;
	}

	public StrategyService getStrategyService() {
		return strategyService;
	}

	public void setStrategyService(StrategyService strategyService) {
		this.strategyService = strategyService;
	}

	public int getClientStateScheduleTime() {
		return clientStateScheduleTime;
	}

	public void setClientStateScheduleTime(int clientStateScheduleTime) {
		this.clientStateScheduleTime = clientStateScheduleTime;
	}

	public Hashtable<WinsensorDeviceBO, WinsensorClient> getAllCurrentMonitoringWinsensorClient() {
		return allCurrentMonitoringWinsensorClient;
	}

	public Hashtable<CommWinsensorDevice, RegisterClient> getAllCouldMonitoringButNotRegisterClient() {
		return allCouldMonitorButNotRegisterClient;
	}

	public ObjectSender getWindowsLogSender() {
		return windowsLogSender;
	}

	public void setWindowsLogSender(ObjectSender windowsLogSender) {
		this.windowsLogSender = windowsLogSender;
	}

	public ObjectSender getHostResourceSender() {
		return hostResourceSender;
	}

	public void setHostResourceSender(ObjectSender hostResourceSender) {
		this.hostResourceSender = hostResourceSender;
	}

	public ObjectSender getRegisterOnlineStatusSender() {
		return registerOnlineStatusSender;
	}

	public void setRegisterOnlineStatusSender(
			ObjectSender registerOnlineStatusSender) {
		this.registerOnlineStatusSender = registerOnlineStatusSender;
	}

	public ObjectSender getRegisterOfflineStatusSender() {
		return registerOfflineStatusSender;
	}

	public void setRegisterOfflineStatusSender(
			ObjectSender registerOfflineStatusSender) {
		this.registerOfflineStatusSender = registerOfflineStatusSender;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentAddress() {
		return agentAddress;
	}

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	public AgentDutyManagerService getAgentDutyManagerService() {
		return agentDutyManagerService;
	}

	public void setAgentDutyManagerService(
			AgentDutyManagerService agentDutyManagerService) {
		this.agentDutyManagerService = agentDutyManagerService;
	}

	public AgentDutyManagerSentHisService getAgentDutyManagerSentHisService() {
		return agentDutyManagerSentHisService;
	}

	public void setAgentDutyManagerSentHisService(
			AgentDutyManagerSentHisService agentDutyManagerSentHisService) {
		this.agentDutyManagerSentHisService = agentDutyManagerSentHisService;
	}

	public int getDutyStatusScheduleTime() {
		return dutyStatusScheduleTime;
	}

	public void setDutyStatusScheduleTime(int dutyStatusScheduleTime) {
		this.dutyStatusScheduleTime = dutyStatusScheduleTime;
	}

	public ProblemService getProblemService() {
		return problemService;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}

	public ObjectSender getOperationProblemSender() {
		return operationProblemSender;
	}

	public void setOperationProblemSender(ObjectSender operationProblemSender) {
		this.operationProblemSender = operationProblemSender;
	}

	public int getWorkOrdersStatusScheduleTime() {
		return workOrdersStatusScheduleTime;
	}

	public void setWorkOrdersStatusScheduleTime(int workOrdersStatusScheduleTime) {
		this.workOrdersStatusScheduleTime = workOrdersStatusScheduleTime;
	}
}
