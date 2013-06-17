package org.infosec.ismp.manager.sitecheck;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.commons.httpclient.HttpStatus;
import org.infosec.ismp.manager.agent.sitecheck.SiteCheckLocator;
import org.infosec.ismp.manager.model.SiteCheckResultEntity;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SiteCheckMessageListener implements MessageListener {
	
	private SiteCheckLocator locator;
	
	private SiteCheckResultService serivce;
	@Autowired(required=true)
	public void setLocator(SiteCheckLocator locator) {
		this.locator = locator;
	}
	@Autowired(required=true)
	public void setSerivce(SiteCheckResultService serivce) {
		this.serivce = serivce;
	}
	@Override
	public void onMessage(Message message) {
		MapMessage map = (MapMessage)message;
		try {
			String nodeid = map.getString("nodeid");
			String url = map.getString("url");
			String pingStatus = map.getString("pingStatus");
			double responseTime = map.getDouble("responseTime");
			String siteCheckStatus = map.getString("siteCheckStatus");
			String siteCheckTime = map.getString("pingTime");
			boolean isReset = map.getBoolean("isReset");
			String domain = locator.getDomainByNodeid(nodeid);			
			if(null!=domain){
				SiteCheckResultEntity entity = new SiteCheckResultEntity();
				entity.setDomain(domain);
				entity.setNodeid(nodeid);
				entity.setPingStatus(pingStatus);
				entity.setResponseTime(responseTime);
				entity.setSiteCheckStatus(siteCheckStatus);
				entity.setSiteCheckTime(siteCheckTime);
				entity.setUrl(url);
				entity.setReset(isReset);
				serivce.save(entity);
				locator.setSiteCheckResult(nodeid,entity);
			}else{
				log().warn("该siteCheck结果没有找到对应的域，抛弃，该nodeid:"+nodeid);
			}
//			System.out.println("SiteCheckMessageListener===================");
//			System.out.println(nodeid);
//			System.out.println(url);
//			System.out.println(pingStatus);
//			System.out.println(responseTime);
//			System.out.println(siteCheckStatus);
//			System.out.println(pingTime);
//			System.out.println(isReset);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
