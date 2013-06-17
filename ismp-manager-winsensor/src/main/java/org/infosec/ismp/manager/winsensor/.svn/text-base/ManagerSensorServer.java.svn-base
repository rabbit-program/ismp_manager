package org.infosec.ismp.manager.winsensor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.agent.comm.winsensor.model.CommThreshold;
import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.agent.comm.winsensor.model.status.RegisterOfflineStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.RegisterOnlineStatus;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommBaseStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommWindowsLogStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.windowslog.WindowsLog;
import org.infosec.ismp.agent.rmi.winsensor.service.AgentWinsensorService;
import org.infosec.ismp.manager.winsensor.alert.HostResourceAlertGenerator;
import org.infosec.ismp.manager.winsensor.entity.AgentBO;
import org.infosec.ismp.manager.winsensor.entity.ManagerWinsensorDeviceBO;
import org.infosec.ismp.manager.winsensor.history.service.HostResourceHistoryService;
import org.infosec.ismp.manager.winsensor.operation.entity.ManagerProblemBO;
import org.infosec.ismp.manager.winsensor.operation.service.DutyManagerSentHistoryService;
import org.infosec.ismp.manager.winsensor.operation.service.DutyManagerService;
import org.infosec.ismp.manager.winsensor.operation.service.ManagerProblemService;
import org.infosec.ismp.manager.winsensor.patch.service.PatchClientService;
import org.infosec.ismp.manager.winsensor.service.AgentService;
import org.infosec.ismp.manager.winsensor.service.ManagerWinsensorDeviceService;
import org.infosec.ismp.manager.winsensor.service.ThresholdService;
import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogBO;
import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogSourceBO;
import org.infosec.ismp.manager.winsensor.windowslog.service.PcLogService;
import org.infosec.ismp.manager.winsensor.windowslog.service.PcLogSourceService;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @author Rocky
 * @version create time：Dec 17, 2010 3:23:02 PM
 * 
 */
public class ManagerSensorServer {

	private static Log log = LogFactory.getLog(ManagerSensorServer.class);
	
	private AgentService agentService;		//Loading by Spring.
	
	private ManagerWinsensorDeviceService deviceService;	//Loading by Spring.
	
	private PcLogSourceService pcLogSourceService;		//Loading by Spring.
	
	private PcLogService pcLogService;		//Loading by Spring.
	
	private PatchClientService patchClientService;		//Loading by Spring.
	
	private ThresholdService thresholdService;		//Loading by Spring.
	
	private HostResourceHistoryService hostResourceHistoryService;		//Loading by Spring.
	
	private HostResourceAlertGenerator hostResourceAlertGenerator;		//Loading by Spring.

	private DutyManagerService dutyManagerService;		//Loading by Spring.
	
	private DutyManagerSentHistoryService dutyManagerSentHistoryService;		//Loading by Spring.
	
	private ManagerProblemService managerProblemService;
	
	/*
	 * 定时启动HostResource状态执行器的周期
	 */
	private int hostResourceStatusScheduledInterval;		//Loading by Spring.
	
	/*
	 * HostResource状态缓存的时间，为0则永远缓存。单位：毫秒。
	 */
	private long hostResourceCacheTime;		//Loading by Spring.
	
	/*
	 * Agent RMI registry port.
	 */
	private String registryPort;		//Loading by Spring.
	
	/*
	 * Agent winsensor service name.
	 */
	private String agentWinsensorServiceName;		//Loading by Spring.
	
	/*
	 * 默认的定时启动HostResource状态执行器的周期
	 */
	private static final int DEFAL_HOST_RESOURCE_STATUS_SCHEDULED_INTERVAL = 30;
	
	/*
	 * All legal agents's info, include identify and ip address.
	 */
	private List<AgentBO> allAgents = new ArrayList<AgentBO>();
	
	/*
	 * All legal device, include all online and off-line device.
	 */
	private List<ManagerWinsensorDeviceBO> allManagerWinsensorDevices = new ArrayList<ManagerWinsensorDeviceBO>();
	
	/*
	 * All current monitoring commDevice.
	 */
	private List<CommWinsensorDevice> allCurrentMonitoringDevices = new ArrayList<CommWinsensorDevice>();
	
	/*
	 * All sensorId of PcLogSource that sensor basic info was not synchronized.
	 */
	private List<String> allUnSynchronizedSensorIdsOfPcLogSource = new ArrayList<String>();
	
	/*
	 * Store all current effective host resources. 
	 * key: monitoring device's nodeId(identify in system).
	 */
	private Hashtable<String, HostResourceClient> allCurrentEffectiveHostResources = new Hashtable<String, HostResourceClient>(2500);
	
	/*
	 * Store all agentId of agent that contains not send dutyManagers.
	 */
	private List<String> allAgentIdsContainUnsendDutyManager = new ArrayList<String>();
	
	private LinkedBlockingQueue<HostResource> hostResourceContainer = new LinkedBlockingQueue<HostResource>(2500);
	
	private LinkedBlockingQueue<List<WindowsLog>> windowsLogContainer = new LinkedBlockingQueue<List<WindowsLog>>(2500);
	
	private LinkedBlockingQueue<RegisterOnlineStatus> registerOnlineStatusContainer = new LinkedBlockingQueue<RegisterOnlineStatus>(2500);
	
	private LinkedBlockingQueue<RegisterOfflineStatus> registerOfflineStatusContainer = new LinkedBlockingQueue<RegisterOfflineStatus>(2500);
	
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
	
	
	public void init() {
		log.info("Manager sensor server init starting.");
		
		//Load all agent info.
		allAgents = agentService.getAllAgent();
		
		//Load all legal  monitor device.
		allManagerWinsensorDevices = deviceService.getAllDevice();
		
		//Load all pcLogSource that not synchronized sensor basic info.
		List<PcLogSourceBO> pcLogSources = pcLogSourceService.getAllUnSynchronizedSource();
		for (PcLogSourceBO pcLogSource : pcLogSources) {
			allUnSynchronizedSensorIdsOfPcLogSource.add(pcLogSource.getSensorId());
		}
		
		hostResourceHistoryService.init();
		hostResourceAlertGenerator.init();
		
		//Load all agentId contains unSend dutyManager.
		allAgentIdsContainUnsendDutyManager = dutyManagerSentHistoryService.getAllUnSentDutyManagerAgentId();
		
		start();
		
		log.info("Manager sensor server init finish.");
	}
	
	public void start() {
		OnlineStatusProcessor onlineStatusProcessor = new OnlineStatusProcessor();
		new Thread(onlineStatusProcessor, "online status processor thread").start();
		
		HostResourceProcessor hostResourceProcessor = new HostResourceProcessor();
		new Thread(hostResourceProcessor, "hostResource processor thread").start();
		
		WindowsLogProcessor windowsLogProcessor = new WindowsLogProcessor();
		new Thread(windowsLogProcessor, "windowsLog processor thread").start();
		
		OfflineStatusProcessor offlineStatusProcessor = new OfflineStatusProcessor();
		new Thread(offlineStatusProcessor, "offline status processor thread").start();
		
		if (getHostResourceCacheTime() > 0) {
			HostResourceStatusScheduledExecutor hostResourceStatusScheduledExecutor = new HostResourceStatusScheduledExecutor();
			service.scheduleAtFixedRate(new Thread(hostResourceStatusScheduledExecutor, "基本信息状态管理执行器"), 
					100, (getHostResourceStatusScheduledInterval() <= 0) ? DEFAL_HOST_RESOURCE_STATUS_SCHEDULED_INTERVAL :
						getHostResourceStatusScheduledInterval(), TimeUnit.SECONDS);
		}
	}
	
	/*
	 * Get all current online devices, including monitored and not monitor device.
	 * Provided to the topology discovery module calls.
	 */
	public List<CommWinsensorDevice> getAllTopoDiscoveryDevices() {
		return allCurrentMonitoringDevices;
	}
	
	/*
	 * Add the monitor device.
	 */
	public void addMonitorDevice(CommWinsensorDevice commDevice) {
		ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(commDevice.getSensorId());
		AgentWinsensorService service = getRmiAgentWinsensorService(device);
		
		if (service != null) {
			//Rmi add monitor device into agent server.
			service.addMonitorDevice(commDevice);
			
			//Update device info(the informations generate by topo manager) in manager server.
			device.setNodeId(commDevice.getNodeId());
			device.setStartMonitorTime(new Date());
			device.setDomainId(commDevice.getDomainId());
			deviceService.updateDevice(device);
			
			//Add pcLogSource.
			pcLogSourceService.addSource(Integer.valueOf(commDevice.getDomainId()), commDevice.getSensorId(), 
					commDevice.getIp(), commDevice.getMac());
			allUnSynchronizedSensorIdsOfPcLogSource.add(commDevice.getSensorId());
			
			//Add patchClient.
			patchClientService.addClient(commDevice.getSensorId(), commDevice.getIp(), commDevice.getMac(), 
					Integer.valueOf(commDevice.getDomainId()));
		}
	}
	
	public void addMonitorDevice(List<CommWinsensorDevice> commDevices) {
		for (CommWinsensorDevice commDevice : commDevices) {
			addMonitorDevice(commDevice);
		}
	}
	
	/*
	 * Starting monitor device.
	 */
	public void startingMonitor(String nodeId) {
		ManagerWinsensorDeviceBO device = getDeviceFromAllDeviceByNodeId(nodeId);
		AgentWinsensorService service = getRmiAgentWinsensorService(device);
		
		if (service != null) {
			service.startingMonitor(nodeId);
			
			pcLogSourceService.startMonitorSource(device.getSensorId());
		}
	}
	
	public void startingMonitor(List<String> nodeIds) {
		for (String nodeId : nodeIds) {
			startingMonitor(nodeId);
		}
	}
	
	/*
	 * Pause monitor device.
	 */
	public void pauseMonitor(String nodeId) {
		ManagerWinsensorDeviceBO device = getDeviceFromAllDeviceByNodeId(nodeId);
		AgentWinsensorService service = getRmiAgentWinsensorService(device);
		
		if (service != null) {
			service.pauseMonitor(nodeId);
			
			pcLogSourceService.pauseMonitorSource(device.getSensorId());
		}
	} 
	
	public void pauseMonitor(List<String> nodeIds) {
		for (String nodeId : nodeIds) {
			pauseMonitor(nodeId);
		}
	}
	
	/*
	 * Stop monitor device.
	 */
	public void deleteMonitorDevice(String nodeId) {
		ManagerWinsensorDeviceBO device = getDeviceFromAllDeviceByNodeId(nodeId);
		AgentWinsensorService service = getRmiAgentWinsensorService(device);
		
		if (service != null) {
			service.stopMonitor(nodeId);
			
			deviceService.deleteDevice(device);
			allManagerWinsensorDevices.remove(device);
			
			pcLogSourceService.deleteSource(device.getSensorId());
		}
	}
	
	public void deleteMonitorDevice(List<String> nodeIds) {
		for (String nodeId : nodeIds) {
			deleteMonitorDevice(nodeId);
		}
	}
	
	/*
	 * Get monitoring device's current host resource.
	 * return null if nodeId is not exist.
	 */
	public HostResource getHostResource(String nodeId) {
		if (allCurrentEffectiveHostResources.get(nodeId) != null) {
			return allCurrentEffectiveHostResources.get(nodeId).getHostResource();
		}
		
		return null;
	}
	
	/*
	 * Update various of strategy.
	 */
	public void updateStrategy(ManagerWinsensorDeviceBO device, CommBaseStrategy strategy) {
		AgentWinsensorService service = getRmiAgentWinsensorService(device);
		
		if (service != null) {
			List<CommBaseStrategy> strategies = new ArrayList<CommBaseStrategy>();
			strategies.add(strategy);
			service.updateStrategy(strategies);
		}
	}
	
	/*
	 * Add pcLogSource.
	 */
	public void addPcLogSource(Map<String, Long> sensors) {
		Set<String> sensorIdsSet = sensors.keySet();
		Object[] sensorIds = sensorIdsSet.toArray();
		for (int i = 0; i < sensorIds.length; i++) {
			String sensorId = (String) sensorIds[i];
			ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(sensorId);
			if (device != null) {
				CommWindowsLogStrategy strategy = new CommWindowsLogStrategy();
				
				strategy.setAFailure(true);
				strategy.setApplication(true);
				strategy.setASuccess(true);
				strategy.setCreateTime(new Date());
				strategy.setError(true);
				strategy.setInformation(true);
				strategy.setInterval(sensors.get(sensorId).intValue());
				strategy.setIp(device.getSensorIp());
				strategy.setRemoteId(0);
				strategy.setSecurity(true);
				strategy.setSensorId(sensorId);
				strategy.setSystem(true);
				strategy.setWarning(true);
				//URL not set.
				updateStrategy(device, strategy);
			}
		}
	}
	
	public void deletePclogSource(String sensorId) {
		if (StringUtils.isBlank(sensorId)) {
			return;
		}
		
		ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(sensorId);
		if (device != null) {
			CommWindowsLogStrategy strategy = new CommWindowsLogStrategy();
			
			strategy.setAFailure(false);
			strategy.setApplication(false);
			strategy.setASuccess(false);
			strategy.setCreateTime(new Date());
			strategy.setError(false);
			strategy.setInformation(false);
			strategy.setInterval(0);
			strategy.setIp(device.getSensorIp());
			strategy.setRemoteId(0);
			strategy.setSecurity(false);
			strategy.setSensorId(sensorId);
			strategy.setSystem(false);
			strategy.setWarning(false);
			//URL not set.
			updateStrategy(device, strategy);
		}
	}
	
	/*
	 * Add new threshold.
	 */
	public void addThreshold(CommThreshold commThreshold) {
		thresholdService.addThreshold(commThreshold);
		hostResourceAlertGenerator.reloadThresholds();
	}
	
	/*
	 * Update the threshold.
	 */
	public void updateThreshold(Long id, Integer level, Long size) {
		thresholdService.updateThreshold(id, level, size);
		hostResourceAlertGenerator.reloadThresholds();
	}
	
	/*
	 * Delete threshold by nodeId.
	 */
	public void deleteThresholdByNodeId(String nodeId) {
		thresholdService.deleteThresholdByNodeId(nodeId);
		hostResourceAlertGenerator.reloadThresholds();
	}
	
	/*
	 * Delete threshold by id.
	 */
	public void deleteThresholdById(Long id) {
		thresholdService.deleteThresholdById(id);
	}
	
	/*
	 * Publish DutyManager
	 */
	public void publishDutyManager(List<DutyManager> dutyManagers) {
		//Saved dutyManagers to the database.
		dutyManagerService.addDutyManager(dutyManagers);
		
		//Create dutyManagers history to all agent(exist in system).
		dutyManagerSentHistoryService.addSentHistory(dutyManagers, allAgents);
		
		//Sent dutyManagers to all agent, 
		//when sent successful, then refresh dutyManagers history and mark it sent successful.
		for (AgentBO agent : allAgents) {
			AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(agent.getAgentId());
			
			if (agentWinsensorService != null) {
				agentWinsensorService.publishDutyManager(dutyManagers);
				dutyManagerSentHistoryService.updateSendSuccessHistory(dutyManagers, agent.getAgentId());
			} else {
				allAgentIdsContainUnsendDutyManager.add(agent.getAgentId());
			}
		}
	}
	
	public void republishDutyManager(List<DutyManager> dutyManagers, String agentId) {
		AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(agentId);
		if (agentWinsensorService != null) {
			agentWinsensorService.publishDutyManager(dutyManagers);
			dutyManagerSentHistoryService.updateSendSuccessHistory(dutyManagers, agentId);
			allAgentIdsContainUnsendDutyManager.remove(agentId);
		}
	}
	
	/*
	 * Delete DutyManager
	 */
	public void deleteDutyManager(String dutyManagerId) {
		dutyManagerService.deleteDutyManager(dutyManagerId);
		dutyManagerSentHistoryService.deleteDutyManager(dutyManagerId);
		
		for (AgentBO agent : allAgents) {
			AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(agent.getAgentId());
			
			if (agentWinsensorService != null) {
				agentWinsensorService.deleteDutyManager(dutyManagerId);
			} 
		}
	}
	
	/*
	 * Locate agent sensor ipAddress
	 */
	public String locateAgentIpByNodeId(ManagerWinsensorDeviceBO device) {
		if (null == device) {
			return "";
		}
		
		AgentBO agent = getAgentByAgentId(device.getAgentId());
		
		return ((agent == null) ? "" : agent.getIpAddress());
	}
	
	/*
	 * Get remote AgentWinsensorService
	 */
	public AgentWinsensorService getRmiAgentWinsensorService(ManagerWinsensorDeviceBO device) {
		if (device != null) {
			String ip = locateAgentIpByNodeId(device);
			return generateRmiAgentWinsensorService(ip);
		}
		
		return null;
	}
	
	public AgentWinsensorService generateRmiAgentWinsensorService(String ip) {
		if (!StringUtils.isBlank(ip)) {
			String serviceUrl = generateAgentWinsensorServiceUrl(ip);
			
			try {
				RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
				rmiProxyFactoryBean.setServiceInterface(AgentWinsensorService.class);
				rmiProxyFactoryBean.setServiceUrl(serviceUrl);
				rmiProxyFactoryBean.afterPropertiesSet();
				
				return (AgentWinsensorService) rmiProxyFactoryBean.getObject();
			} catch (Exception e) {
				//TODO log
				return null;
			}
		}
		
		return null;
	}
	
	public AgentWinsensorService getRmiAgentWinsensorService(String agentId) {
		AgentBO agent = getAgentByAgentId(agentId);
		
		if (agent != null) {
			return generateRmiAgentWinsensorService(agent.getIpAddress());
		}
		
		return null;
	}
	
	/*
	 * Generate remote agent sensor service URL
	 */
	public String generateAgentWinsensorServiceUrl(String ip) {
		String registryPort  = (StringUtils.isBlank(getRegistryPort())) ? "1199" : getRegistryPort();
		
		String serviceName = (StringUtils.isBlank(getAgentWinsensorServiceName())) ? 
				"AgentWinsensorService" : getAgentWinsensorServiceName();
		
		return "rmi://" + ip + ":" + registryPort + "/" + serviceName;
	}
	
	public ManagerWinsensorDeviceBO getDeviceFromAllDevicesBySensorId(String sensorId) {
		if (StringUtils.isBlank(sensorId)) {
			return null;
		}
		
		for (ManagerWinsensorDeviceBO device : allManagerWinsensorDevices) {
			if (device.getSensorId().equals(sensorId)) {
				return device;
			}
		}
		
		return null;
	}
	
	public ManagerWinsensorDeviceBO getDeviceFromAllDeviceByNodeId(String nodeId) {
		if (StringUtils.isBlank(nodeId)) {
			return null;
		}
		
		for (ManagerWinsensorDeviceBO device : allManagerWinsensorDevices) {
			if (device.getNodeId() != null && device.getNodeId().equals(nodeId)) {
				return device;
			}
		}
		
		return null;
	} 
	
	public AgentBO getAgentByAgentId(String agentId) {
		if (StringUtils.isBlank(agentId)) {
			return null;
		}
		
		for (AgentBO agent : allAgents) {
			if (agent.getAgentId().equals(agentId)) {
				return agent;
			}
		}
		
		return null;
	}
	
	/*
	 * Add host resource info.
	 */
	public void addHostResource(HostResource hostResource) {
		synchronized (hostResourceContainer) {
			hostResourceContainer.offer(hostResource);
			hostResourceContainer.notifyAll();
		}
	}
	
	/*
	 * Add windows log.
	 */
	public void addWindowsLog(List<WindowsLog> windowsLogs) {
		synchronized (windowsLogContainer) {
			windowsLogContainer.offer(windowsLogs);
			windowsLogContainer.notifyAll();
		}
	}
	
	/*
	 * Add register online status.
	 */
	public void addRegisterOnlineStatus(RegisterOnlineStatus onlineStatus) {
		synchronized (registerOnlineStatusContainer) {
			registerOnlineStatusContainer.offer(onlineStatus);
			registerOnlineStatusContainer.notifyAll();
		}
	}
	
	/*
	 * Add register off-line status.
	 */
	public void addRegisterOfflineStatus(RegisterOfflineStatus offlineStatus) {
		synchronized (registerOfflineStatusContainer) {
			registerOfflineStatusContainer.offer(offlineStatus);
			registerOfflineStatusContainer.notifyAll();
		}
	}
	
	/*
	 * Commit operation problem.
	 */
	public void commitOperationProblem(Problem problem) {
		if (problem != null) {
			ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(problem.getSensorId());
			
			if (device != null) {
				if (managerProblemService.addProblem(problem, device.getDomainId())) {
					AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(device);
					
					if (agentWinsensorService != null) {
						agentWinsensorService.receivedOperationProblem(problem.getProblemId());
					}
				}
			}
		}
	}

	public void closeOperationProblem(String problemId) {
		ManagerProblemBO problem = managerProblemService.findByProblemId(problemId);
		if (problem != null) {
			managerProblemService.closeOperationProblem(problem);
			ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(problem.getSensorId());
			
			if (device != null) {
				AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(device);
				
				if (agentWinsensorService != null) {
					//RMI call agent and close problem.
					agentWinsensorService.closeOperationProblem(problemId);
					//Refresh database state.
					managerProblemService.sendProblemClosed(problem);
				}
			}
		}
	}

	public void generateWorkOrders(String problemId, String workOrdersId) {
		ManagerProblemBO problem = managerProblemService.findByProblemId(problemId);
		if (problem != null) {
			managerProblemService.generateWorkOrders(problem, workOrdersId);
			ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(problem.getSensorId());
			
			if (device != null) {
				AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(device);
				
				if (agentWinsensorService != null) {
					agentWinsensorService.generateWorkOrders(problemId, workOrdersId);
					managerProblemService.sendGenerateWorkOrders(problem);
				}
			}
		}
	}

	public void closeWorkOrders(String problemId, String workOrdersId) {
		ManagerProblemBO problem = managerProblemService.findByProblemId(problemId);
		if (problem != null) {
			managerProblemService.closeWorkOrders(problem, workOrdersId);
			ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(problem.getSensorId());
			
			if (device != null) {
				AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(device);
				
				if (agentWinsensorService != null) {
					agentWinsensorService.closeWorkOrders(problemId, workOrdersId);
					managerProblemService.sendWorkOrdersClosed(problem);
				}
			}
		}
	}

	public void completeWorkOrders(String problemId, String workOrdersId) {
		ManagerProblemBO problem = managerProblemService.findByProblemId(problemId);
		if (problem != null) {
			managerProblemService.completeWorkOrders(problem, workOrdersId);
			ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(problem.getSensorId());
			
			if (device != null) {
				AgentWinsensorService agentWinsensorService = getRmiAgentWinsensorService(device);
				
				if (agentWinsensorService != null) {
					agentWinsensorService.completeWorkOrders(problemId, workOrdersId);
					managerProblemService.sendWorkOrdersCompleted(problem);
				}
			}
		}
	}
	
	private RegisterOnlineStatus getNextRegisterOnlineStatus() {
		return registerOnlineStatusContainer.poll();
	}
	
	private HostResource getNextHostResource() {
		return hostResourceContainer.poll();
	}
	
	private List<WindowsLog> getNextWindowsLog() {
		return windowsLogContainer.poll();
	}
	
	private RegisterOfflineStatus getNextRegisterOfflineStatus() {
		return registerOfflineStatusContainer.poll();
	}
	
	/*
	 * Handle hostResource sent by agent server.
	 */
	private class HostResourceProcessor implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (hostResourceContainer) {
					if (hostResourceContainer.isEmpty()) {
						try {
							hostResourceContainer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						for (int i = 0; i < hostResourceContainer.size(); i++) {
							HostResource hostResource = getNextHostResource();
							
							//Update pcLogSource sensor basic info.
							String sensorId = hostResource.getWinsensorClientStatus().getSensorId();
							if (allUnSynchronizedSensorIdsOfPcLogSource.contains(sensorId)) {
								pcLogSourceService.updateSourceBaseInfo(sensorId, hostResource.getLocalSystemlStatus().getComputerName(), 
										hostResource.getLocalSystemlStatus().getOsInfo());
								
								allUnSynchronizedSensorIdsOfPcLogSource.remove(sensorId);
							}
							
							//Handle hostResource history.
							hostResourceHistoryService.addHostResource(hostResource);
							
							//Handle hostResource threshold.
							hostResourceAlertGenerator.addHostResource(hostResource);
							
							HostResourceClient hostResourceClient = new HostResourceClient(hostResource);
							
							allCurrentEffectiveHostResources.remove(hostResource.getDevice().getNodeId());
							allCurrentEffectiveHostResources.put(hostResource.getDevice().getNodeId(), hostResourceClient);
						}
					}
				}
			}
		}
		
	}
	
	/*
	 * Handle windowsLog sent by agent server.
	 */
	private class WindowsLogProcessor implements Runnable {
		
		private long lastProcessTime;

		@Override
		public void run() {
			lastProcessTime = System.currentTimeMillis();
			
			while (true) {
				synchronized (windowsLogContainer) {
					if ((windowsLogContainer.size() < Constants.WINDOWS_LOG_BATCH_SAVE_MEMORY_SIZE) &&
							((System.currentTimeMillis() - lastProcessTime) < Constants.WINDOWS_LOG_BATCH_SAVE_INTERVAL)) {
						try {
							windowsLogContainer.wait(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						List<PcLogBO> pcLogs = new ArrayList<PcLogBO>();
						for (int i = 0; i < windowsLogContainer.size(); i++) {
							List<WindowsLog> windowsLogs = getNextWindowsLog();
							for (WindowsLog windowsLog : windowsLogs) {
								pcLogs.add(PcLogBO.convert(windowsLog));
							}
						}
						
						pcLogService.addLog(pcLogs);
						lastProcessTime = System.currentTimeMillis();
					}
				}
			}
		}
		
	}
	
	/*
	 * Handle online status sent by agent server.
	 */
	private class OnlineStatusProcessor implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (registerOnlineStatusContainer) {
					if (registerOnlineStatusContainer.isEmpty()) {
						try {
							registerOnlineStatusContainer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						for (int i = 0; i < registerOnlineStatusContainer.size(); i++) {
							RegisterOnlineStatus onlineStatus = getNextRegisterOnlineStatus();
							CommWinsensorDevice commDevice = onlineStatus.getCommDevice();
							
							//Add to cuurent monitoring devices list.
							if (!allCurrentMonitoringDevices.contains(commDevice)) {
								allCurrentMonitoringDevices.add(commDevice);
							}
							
							ManagerWinsensorDeviceBO device = getDeviceFromAllDevicesBySensorId(commDevice.getSensorId());
							//It will be saved to the database when first register. 
							if (device == null) {
								device = new ManagerWinsensorDeviceBO();
								device.setAgentId(commDevice.getAgentId());
								device.setRegisterTime(new Date());
								device.setSensorId(commDevice.getSensorId());
								device.setSensorIp(commDevice.getIp());
								
								deviceService.addDevice(device);
								allManagerWinsensorDevices.add(device);
							} else if (!device.getAgentId().equals(commDevice.getAgentId())) {
								//If device agentId is changed, update database.
								device.setAgentId(commDevice.getAgentId());
								deviceService.updateDevice(device);
							}
							
							AgentBO agent = getAgentByAgentId(commDevice.getAgentId());
							//Add agent info, when the agent is not exist.
							if (agent == null) {
								agent = new AgentBO();
								agent.setAgentId(commDevice.getAgentId());
								agent.setIpAddress(commDevice.getAgentAddress());
								agent.setCreateTime(new Date());
								
								agentService.addAgent(agent);
								allAgents.add(agent);
								allAgentIdsContainUnsendDutyManager.add(agent.getAgentId());
								//TODO Insert DutyManager and Agent mapping into database, 
								//And before that should be refresh DutyManager table and DutyManagerHistory table, 
								//update expired column when endDate large than current time.
							} else if (!agent.getIpAddress().equals(commDevice.getAgentAddress())) {
								//If agent ipAddress is changed, update database.
								agent.setIpAddress(commDevice.getAgentAddress());
								agent.setUpdateTime(new Date());
								agentService.updateAgent(agent);
							}
							
							//Handle operation dutyManager info that unsent to agent.
							if (allAgentIdsContainUnsendDutyManager.contains(agent.getAgentId())) {
								List<String> dutyManagerIds = dutyManagerSentHistoryService.getAllUnsentDutyManagerId(agent.getAgentId(), false);
								List<DutyManager> dutyManagers = dutyManagerService.getAllDutyManagerById(dutyManagerIds);
								republishDutyManager(dutyManagers, agent.getAgentId());
							}
						}
					}
				}
			}
		}
		
	}
	
	private class OfflineStatusProcessor implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (registerOfflineStatusContainer) {
					if (registerOfflineStatusContainer.isEmpty()) {
						try {
							registerOfflineStatusContainer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						for (int i = 0; i < registerOfflineStatusContainer.size(); i++) {
							RegisterOfflineStatus offlineStatus = getNextRegisterOfflineStatus();
							CommWinsensorDevice commDevice = offlineStatus.getCommDevice();
							
							allCurrentMonitoringDevices.remove(commDevice);
						}
					}
				}
			}
		}
		
	}
	
	private class HostResourceStatusScheduledExecutor implements Runnable {

		@Override
		public void run() {
			synchronized (allCurrentEffectiveHostResources) {
				Set<String> nodeIds = allCurrentEffectiveHostResources.keySet();
				Iterator<String> iterator = nodeIds.iterator();
				while (iterator.hasNext()) {
					String nodeId = iterator.next();
					HostResourceClient client = allCurrentEffectiveHostResources.get(nodeId);
					
					if ((client.getCreateTime() - System.currentTimeMillis()) > getHostResourceCacheTime()) {
						allCurrentEffectiveHostResources.remove(nodeId);
					}
				}
			} 
		}
	}
	
	private class HostResourceClient {
		private HostResource hostResource;
		private long createTime;
		
		public HostResourceClient(HostResource vHostResource) {
			this.hostResource = vHostResource;
			this.createTime = System.currentTimeMillis();
		}
		
		public HostResource getHostResource() {
			return hostResource;
		}
		
		public long getCreateTime() {
			return createTime;
		}
	}

	// ********************* GETTER SETTER METHOD *********************
	
	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public ManagerWinsensorDeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(ManagerWinsensorDeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public PcLogSourceService getPcLogSourceService() {
		return pcLogSourceService;
	}

	public void setPcLogSourceService(PcLogSourceService pcLogSourceService) {
		this.pcLogSourceService = pcLogSourceService;
	}

	public PcLogService getPcLogService() {
		return pcLogService;
	}

	public void setPcLogService(PcLogService pcLogService) {
		this.pcLogService = pcLogService;
	}

	public PatchClientService getPatchClientService() {
		return patchClientService;
	}

	public void setPatchClientService(PatchClientService patchClientService) {
		this.patchClientService = patchClientService;
	}

	public ThresholdService getThresholdService() {
		return thresholdService;
	}

	public void setThresholdService(ThresholdService thresholdService) {
		this.thresholdService = thresholdService;
	}

	public HostResourceHistoryService getHostResourceHistoryService() {
		return hostResourceHistoryService;
	}

	public void setHostResourceHistoryService(
			HostResourceHistoryService hostResourceHistoryService) {
		this.hostResourceHistoryService = hostResourceHistoryService;
	}

	public int getHostResourceStatusScheduledInterval() {
		return hostResourceStatusScheduledInterval;
	}

	public void setHostResourceStatusScheduledInterval(
			int hostResourceStatusScheduledInterval) {
		this.hostResourceStatusScheduledInterval = hostResourceStatusScheduledInterval;
	}

	public long getHostResourceCacheTime() {
		return hostResourceCacheTime;
	}

	public void setHostResourceCacheTime(long hostResourceCacheTime) {
		this.hostResourceCacheTime = hostResourceCacheTime;
	}

	public HostResourceAlertGenerator getHostResourceAlertGenerator() {
		return hostResourceAlertGenerator;
	}

	public void setHostResourceAlertGenerator(
			HostResourceAlertGenerator hostResourceAlertGenerator) {
		this.hostResourceAlertGenerator = hostResourceAlertGenerator;
	}

	public DutyManagerService getDutyManagerService() {
		return dutyManagerService;
	}

	public void setDutyManagerService(DutyManagerService dutyManagerService) {
		this.dutyManagerService = dutyManagerService;
	}

	public DutyManagerSentHistoryService getDutyManagerSentHistoryService() {
		return dutyManagerSentHistoryService;
	}

	public void setDutyManagerSentHistoryService(
			DutyManagerSentHistoryService dutyManagerSentHistoryService) {
		this.dutyManagerSentHistoryService = dutyManagerSentHistoryService;
	}

	public String getRegistryPort() {
		return registryPort;
	}

	public void setRegistryPort(String registryPort) {
		this.registryPort = registryPort;
	}

	public String getAgentWinsensorServiceName() {
		return agentWinsensorServiceName;
	}

	public void setAgentWinsensorServiceName(String agentWinsensorServiceName) {
		this.agentWinsensorServiceName = agentWinsensorServiceName;
	}

	public ManagerProblemService getManagerProblemService() {
		return managerProblemService;
	}

	public void setManagerProblemService(ManagerProblemService managerProblemService) {
		this.managerProblemService = managerProblemService;
	}
}
