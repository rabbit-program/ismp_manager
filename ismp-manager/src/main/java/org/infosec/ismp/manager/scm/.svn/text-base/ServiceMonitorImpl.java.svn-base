package org.infosec.ismp.manager.scm;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.infosec.ismp.manager.agent.servicecheck.ServiceCheckLocator;
import org.infosec.ismp.manager.model.ServiceCheckResultEntity;
import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.infosec.ismp.manager.rmi.scm.service.ServiceMonitor;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author geilivable
 * @date 2010-12-7 上午09:56:14
 * 
 *  服务检测默认实现类，客户端可通过此实现类来注册一个检测服务。 
 *  如：HTTP SERVICE,POP3 SERVICE.
 *  <code>Status</code> 用于存储服务检测响应结果集，返回给调用的客户端程序。
 */
@Component
public class ServiceMonitorImpl implements ServiceMonitor {
	
	private ServiceCheckLocator serviceCheckLocator;
	
	@Autowired(required=true)
	public void setServiceCheckLocator(ServiceCheckLocator serviceCheckLocator) {
		this.serviceCheckLocator = serviceCheckLocator;
	}



	@Override
	public void removeServiceMonitor(String nodeid) {
		if(log().isDebugEnabled())
        log().info("sart MonitorService remove args:"+nodeid);
		
		serviceCheckLocator.removeServiceCheckNode(nodeid);
		log().debug("ServiceCheck注册成功！");
		log().debug("nodeid:"+nodeid);
	}

	
    
	public ThreadCategory log(){
		return ThreadCategory.getInstance(getClass());
	}

	@Override
	public PollStatus getServiceMonitorState(String nodeId) {

		ServiceCheckResultEntity entity = serviceCheckLocator.getServiceCheckResult(nodeId);
		
		if(entity==null){
			return PollStatus.unknown();
		}else{
			if ("Up".equalsIgnoreCase(entity.getServiceCheckStatus())){
				return PollStatus.available((double)entity.getResponseTime());
			}else{
				return PollStatus.unavailable();
			}
		}
	}

	@Override
	public void pauseServiceMonitor(String nodeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerServiceMonitor(String domain, String nodeid,
			String serviceType, String ipAddr, long interval,
			Map<String, String> parameters) {
		if(log().isDebugEnabled())
	        log().info("sart MonitorService remove args:"+nodeid);
		
		serviceCheckLocator.addServiceCheckNode(domain, nodeid, serviceType, ipAddr, interval, parameters);
		log().debug("ServiceCheck注册成功！");
		log().debug("domain:"+domain);
		log().debug("nodeid:"+nodeid);
		log().debug("serviceType:"+serviceType);
		log().debug("ipAddr："+ipAddr);
		log().debug("interval："+interval);
		Set<String> keyset = parameters.keySet();
		int i =1;
		for (Iterator<String> iterator = keyset.iterator(); iterator.hasNext();) {
			String key =  iterator.next();
			log().debug("parameters "+i+" key:"+key );
			log().debug("parameters "+i+" value:"+parameters.get(key) );
			i++;			
		}
	}

}

