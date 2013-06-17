package org.infosec.ismp.manager.agent.sitecheck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.infosec.ismp.manager.ComponentLocator;
import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.manager.model.SiteCheckNodeEntity;
import org.infosec.ismp.manager.model.SiteCheckResultEntity;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 页面检测Locator
 * @author jiel
 *
 */
@Component
public class SiteCheckLocator implements ComponentLocator {
	/**
	 * nodeid<->domain
	 */
	private Map<String, DomainComponent> nodeidMaps = new HashMap<String, DomainComponent>();
	private DomainLocator m_domainLocator;
	private SiteCheckNodeEntityService m_siteCheckService;
	private boolean isReset = false;
	@Autowired(required=true)
	public void setSiteCheckService(SiteCheckNodeEntityService siteCheckService) {
		m_siteCheckService = siteCheckService;
	}

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("SiteCheck Locator 开始初始化");
		Assert.state(m_siteCheckService != null, "m_siteCheckService不能为空，请检查");
		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
		distruteAllSiteCheckNode();
	}
	
	/**
	 * 初始化SiteCheckNode任务
	 */
	public void distruteAllSiteCheckNode() {
		List<SiteCheckNodeEntity> entities = getAllSiteCheckNode();
		for (SiteCheckNodeEntity entity : entities) {
			String domain = entity.getDomain();
			addSiteCheckNodeToDomain(domain, entity.getNodeid(), entity.getUrl(),
					entity.getInterval());
		}
	}
	/**
	 * 新增siteCheck服务
	 * @param domain
	 * @param nodeid
	 * @param url
	 * @param interval
	 */
	public void addSiteCheckNode(String domain, String nodeid,
			String url, long interval){		
		addSiteCheckNodeToDb(domain,nodeid,url,interval*1000);
		addSiteCheckNodeToDomain(domain,nodeid,url,interval*1000);
	}
	/**
	 * 删除sitecheck服务
	 * @param nodeid
	 */
	public void removeSiteCheckNode(String nodeid){
		removeSiteCheckNodeFromDb(nodeid);
		removeSiteCheckNodeFromDomain(nodeid);
		nodeidMaps.remove(nodeid);
	}
	/**
	 * 重置sitecheck服务
	 * @param nodeid
	 */
	public void resetSiteCheckNode(String nodeid){
		resetSiteCheckNodeFromDomain(nodeid);
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {// 立刻改变检测的返回结果为正常
			SiteCheckResultEntity entity= domainComp.getSiteCheckResult(nodeid);
			if("Up".equalsIgnoreCase(entity.getPingStatus())){
				entity.setSiteCheckStatus("NORMAL");
			}
		}
		isReset = true;
	}
	/**
	 * 获取DB中所有sitecheckNode任务Entity
	 * @return
	 */
	public List<SiteCheckNodeEntity> getAllSiteCheckNode() {
		return m_siteCheckService.getAll();
	}
	
	/**
	 * 将siteCheck任务添加到domainComponent
	 * @param domain
	 * @param nodeid
	 * @param ipaddr
	 * @param interval
	 * @param halfFlag
	 */
	private void addSiteCheckNodeToDomain(String domain, String nodeid,
			String url, long interval) {
		DomainComponent domainComp = m_domainLocator
				.createDomainIfNessary(domain);
		nodeidMaps.put(nodeid, domainComp);
		SiteCheckNode node = createSiteCheckNode(nodeid, url, interval);
		domainComp.addSiteCheckNode(node);
	}
	/**
	 * 将sitecheck任务添加到数据库中
	 * @param domain
	 * @param nodeid
	 * @param url
	 * @param interval
	 */
	private void addSiteCheckNodeToDb(String domain, String nodeid,
			String url, long interval){
		SiteCheckNodeEntity entity = new SiteCheckNodeEntity();
		entity.setDomain(domain);
		entity.setNodeid(nodeid);
		entity.setUrl(url);
		entity.setInterval(interval);
		m_siteCheckService.save(entity);
	}
	/**
	 * 创建一个SiteCheckNode
	 * @param nodeid
	 * @param url
	 * @param interval
	 * @return
	 */
	private SiteCheckNode createSiteCheckNode(String nodeid,String url,long interval){
		SiteCheckNode node = new SiteCheckNode();
		node.setNodeid(nodeid);
		node.setUrl(url);
		node.setInterval(interval);
		return node;
	}
	/**
	 * 从domainComponent中删除一个siteCheckNode任务
	 * @param nodeid
	 */
	private void removeSiteCheckNodeFromDomain(String nodeid){
		DomainComponent domainComp =nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.removeSiteCheckNode(nodeid);
			domainComp.RemoveSiteCheckResult(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug("removeSiteCheckNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}		
	}
	/**
	 * 从DB中删除一个siteCheckNode
	 * @param nodeid
	 */
	private void removeSiteCheckNodeFromDb(String nodeid){
		m_siteCheckService.removeSiteCheckNodeByNodeId(nodeid);
	}
	/**
	 * 从domainComponent中重置一个siteCheckNode任务
	 * @param nodeid
	 */
	private void resetSiteCheckNodeFromDomain(String nodeid){
		DomainComponent domainComp =nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.resetSiteCheckNode(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug("resetSiteCheckNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}	
	}
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	/**
	 * 根据nodeid获取相应的域ID
	 * @param nodeid
	 * @return
	 */
	public String getDomainByNodeid(String nodeid) {
		DomainComponent domainComp =nodeidMaps.get(nodeid);
		log().debug("nodeidMaps.size():"+nodeidMaps.size());
		if (domainComp != null) {
			return domainComp.getDomainId();
		} else {
			if (log().isDebugEnabled()) {
				log().debug("SiteCheckLocator.getDomainByNodeid没有找到该nodeId：" + nodeid + "对应的域 ");
			}
			return null;
		}
	}

	/**
	 * 用于设置某个nodeid的状态
	 * @param nodeid
	 * @param entity
	 */
	public void setSiteCheckResult(String nodeid, SiteCheckResultEntity entity) {
		if(isReset){//如果做重置操作，则将返回的状态结果更改为：正常-NORMAL，直到后台程序重置后的真实结果返回时
			if("Up".equalsIgnoreCase(entity.getPingStatus())){
				entity.setSiteCheckStatus("NORMAL");
			}
			if(true==entity.isReset()){
				isReset=false;
			}
		}
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.putSiteCheckResult(nodeid,entity);
		}
	}
	/**
	 * 获得某个nodeid的状态
	 * @param nodeid
	 * @return
	 */
	public SiteCheckResultEntity getSiteCheckResult(String nodeid){
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			return domainComp.getSiteCheckResult(nodeid);
		}
		return null;
	}

}
