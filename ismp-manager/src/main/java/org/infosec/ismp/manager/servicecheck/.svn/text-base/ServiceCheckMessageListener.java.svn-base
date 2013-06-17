package org.infosec.ismp.manager.servicecheck;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.infosec.ismp.manager.agent.servicecheck.ServiceCheckLocator;
import org.infosec.ismp.manager.model.ServiceCheckResultEntity;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceCheckMessageListener implements MessageListener {

	private ServiceCheckLocator locator;
	private ServiceCheckResultService service;
	
	@Autowired(required=true)
	public void setLocator(ServiceCheckLocator locator) {
		this.locator = locator;
	}
	@Autowired(required=true)
	public void setService(ServiceCheckResultService service) {
		this.service = service;
	}
	@Override
	public void onMessage(Message message) {
		MapMessage map = (MapMessage)message;
		try {
			String nodeid = map.getString("nodeid");
			String ipAddr = map.getString("ipAddr");
			String serviceCheckStatus = map.getString("pingStatus");//检测结果状态
			double responseTime = map.getDouble("responseTime");//检测响应时间
			String serviceType = map.getString("serviceType");
			String serviceCheckTime = map.getString("pingTime");//检测记录时间
			
			String domain = locator.getDomainByNodeid(nodeid);
			if(null!=domain){
				ServiceCheckResultEntity entity = new ServiceCheckResultEntity();
				entity.setDomain(domain);
				entity.setNodeid(nodeid);
				entity.setIpAddr(ipAddr);
				entity.setServiceCheckStatus(serviceCheckStatus);
				entity.setServiceType(serviceType);
				entity.setResponseTime(responseTime);
				entity.setServiceCheckTime(serviceCheckTime);
				service.save(entity);
				locator.setServiceCheckResult(nodeid,entity);
			}else
			{
				log().warn("该serviceCheck结果没有找到对应的域，抛弃，该nodeid:"+nodeid);
			}
//			System.out.println("ServiceCheckMessageListener===================");
//			System.out.println(nodeid);
//			System.out.println(ipAddr);
//			System.out.println(pingStatus);
//			System.out.println(responseTime);
//			System.out.println(serviceType);
//			System.out.println(pingTime);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}


}
