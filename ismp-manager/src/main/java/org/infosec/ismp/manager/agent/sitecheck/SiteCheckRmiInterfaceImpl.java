package org.infosec.ismp.manager.agent.sitecheck;

import org.infosec.ismp.manager.model.SiteCheckResultEntity;
import org.infosec.ismp.manager.rmi.wsm.model.SiteCheckRmiModel;
import org.infosec.ismp.manager.rmi.wsm.service.SiteCheckRmiInterface;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SiteCheckRmiInterfaceImpl implements SiteCheckRmiInterface {
	
	private SiteCheckLocator locator;
	
	@Autowired(required=true)
	public void setLocator(SiteCheckLocator locator) {
		this.locator = locator;
	}

	/**
	 * 添加一个页面检测服务
	 */
	@Override
	public void addSiteCheck(String domainId, String nodeId, String url,
			long interval, long outTime) {
		locator.addSiteCheckNode(domainId, nodeId, url, interval);
		log().debug("SiteCheckRmiInterfaceImpl addSiteCheck方法");
		log().debug("domainId:"+domainId);
		log().debug("nodeId:"+nodeId);
		log().debug("url:"+url);
		log().debug("interval:"+interval);
		log().debug("outTime:"+outTime);
	}
	/**
	 * 获取一个页面检测服务信息
	 */
	@Override
	public SiteCheckRmiModel getSiteCheck(String nodeId) {
		log().debug("SiteCheckRmiInterfaceImpl getSiteCheck方法");
		log().debug("nodeId:"+nodeId);
		SiteCheckResultEntity entity = locator.getSiteCheckResult(nodeId);
		if(null!=entity){
		SiteCheckRmiModel model = new SiteCheckRmiModel();
		model.setNodeid(nodeId);
		model.setPingStatus(entity.getPingStatus());
		model.setResponseTime(entity.getResponseTime());
		model.setSiteCheckStatus(entity.getSiteCheckStatus());
		model.setSiteCheckTime(entity.getSiteCheckTime());
		model.setUrl(entity.getUrl());
		return model;
		}
		return null;
	}
	
	/**
	 * 删除一个页面检测服务
	 */
	@Override
	public void removeSiteCheck(String nodeId) {
		locator.removeSiteCheckNode(nodeId);
		log().debug("SiteCheckRmiInterfaceImpl removeSiteCheck方法");
		log().debug("nodeId:"+nodeId);

	}
	/**
	 * 	重置一个页面检测服务
	 */
	@Override
	public void resetSiteCheck(String nodeId) {
		locator.resetSiteCheckNode(nodeId);
		log().debug("SiteCheckRmiInterfaceImpl resetSiteChekc方法");
		log().debug("nodeId:"+nodeId);

	}
	/**
	 * 修改一个页面检测服务
	 */
	@Override
	public void updateSiteCheck(String nodeId, String url, long interval,
			long outTime) {
		String domain = locator.getDomainByNodeid(nodeId);
		if(null!=domain){
		locator.removeSiteCheckNode(nodeId);
		locator.addSiteCheckNode(domain, nodeId, url, interval);
		log().debug("SiteCheckRmiInterfaceImpl updateSiteCheck方法");
		log().debug("nodeId:"+nodeId);
		log().debug("url:"+url);
		log().debug("interval:"+interval);
		log().debug("outTime:"+outTime);
		}else
		{
			log().warn("该updateSiteCheck没有找到对应的域，抛弃，该nodeid:"+nodeId);
		}

	}
	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
