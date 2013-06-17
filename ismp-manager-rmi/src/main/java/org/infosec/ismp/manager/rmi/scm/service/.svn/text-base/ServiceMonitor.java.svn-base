package org.infosec.ismp.manager.rmi.scm.service;

import java.util.Map;

import org.infosec.ismp.manager.rmi.scm.model.PollStatus;


/**
 * @author guoxianwei
 * @date 2010-12-7 上午09:44:41
 * 
 */
public interface ServiceMonitor {
	
	//注册一个检测服务：
	public void registerServiceMonitor(String domain,String nodeid,String serviceType,String ipAddr,long interval,Map<String,String> parameters);
	
	//暂停一个服务检测
	public void pauseServiceMonitor(String nodeId);
	
	//返回服务检测结果状态
	public PollStatus getServiceMonitorState(String nodeId);
	
	//删除一个检测服务：
	public void removeServiceMonitor(String nodeId);
}

