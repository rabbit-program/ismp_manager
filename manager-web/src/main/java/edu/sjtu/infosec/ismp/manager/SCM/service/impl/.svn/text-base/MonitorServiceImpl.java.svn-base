package edu.sjtu.infosec.ismp.manager.SCM.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.infosec.ismp.manager.rmi.scm.service.ServiceMonitor;

import edu.sjtu.infosec.ismp.manager.SCM.dao.MonitorDao;
import edu.sjtu.infosec.ismp.manager.SCM.model.Monitor;
import edu.sjtu.infosec.ismp.manager.SCM.service.MonitorService;
import edu.sjtu.infosec.ismp.security.Domain;

public class MonitorServiceImpl implements MonitorService {
	
	private static Logger logger = Logger.getLogger(MonitorServiceImpl.class); 
	
	private MonitorDao monitorDao;
	
	private ServiceMonitor monitorServiceClient;///RMI
	
	private Map<String, String> hm = new HashMap<String, String>();
	
	public MonitorDao getMonitorDao() {
		return monitorDao;
	}

	public void setMonitorDao(MonitorDao monitorDao) {
		this.monitorDao = monitorDao;
	}
	
	public ServiceMonitor getMonitorServiceClient() {
		return monitorServiceClient;
	}

	public void setMonitorServiceClient(ServiceMonitor monitorServiceClient) {
		this.monitorServiceClient = monitorServiceClient;
	}

	@SuppressWarnings("unchecked")
	public List getMonitorList() {
		return monitorDao.getMonitorList();
	}
	
	@SuppressWarnings("unchecked")
	public List getMonitorList(int startResult, int maxResult) {
		return monitorDao.getMonitorList(startResult, maxResult);
	}
	
	@SuppressWarnings("unchecked")
	public List getMonitorListByDomain(List<Domain> userDomainList,int startResult, int maxResult) {
		return monitorDao.getMonitorListByDomain(userDomainList, startResult, maxResult);
	}
	
	public void deleteMonitorById(Integer id) {
		monitorDao.removeObject(Monitor.class, id);
	}

	public Monitor getMonitorById(Integer id) {
		return (Monitor) monitorDao.getObject(Monitor.class, id);
	}
	
	public void saveOrUpdateMonitor(Monitor monitor) {
		monitorDao.saveOrUpdateMonitor(monitor);
	}
	
	public int getCount() {
		return monitorDao.getCount();
	}

	public int getCountByDomain(List<Domain> userDomainList) {
		return monitorDao.getCountByDomain(userDomainList);
	}
	
	public Integer getMonitorStates(String nodeId,Integer timeOut) {
		
		int statesFlag = -1;
//		Monitor monitor = monitorDao.getMonitorByNodeId(nodeId);
//		HashMap<String, String> hashMap = new HashMap<String, String>();
		PollStatus pollStatus = null;
		try {
			long start =System.currentTimeMillis();///远程调用之前系统时间
			
			/** RMI调用：根据 nodeid 从后台取得监控机状态类 **/
			pollStatus = monitorServiceClient.getServiceMonitorState(nodeId);///RMI：从后台返回检测状态
			
			long end =System.currentTimeMillis();///远程调用之后系统时间
			if(null != pollStatus && !"".equals(pollStatus)){
				//yes:超时     no:未超时
				if ((start - end) * 0.001 >= timeOut) {
					hm.put(nodeId, "yes");
				}else{
					hm.put(nodeId, "no");
				}
				statesFlag = pollStatus.getStatusCode();
			}
		} catch (Exception e) {
			logger.error("后台返回状态失败！！");
			hm.put(nodeId, "yes");
//			e.printStackTrace();
		}
		return statesFlag;
	}
	
	/**
	 * 获取状态是否超时
	 */
	public String getMonitorOverStates(String nodeId){
		String state = hm.get(nodeId);
		return state;
	}

}
