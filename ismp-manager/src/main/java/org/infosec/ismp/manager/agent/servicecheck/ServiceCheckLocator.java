package org.infosec.ismp.manager.agent.servicecheck;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.infosec.ismp.manager.ComponentLocator;
import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.manager.model.ServiceCheckNodeEntity;
import org.infosec.ismp.manager.model.ServiceCheckNodeParamEntity;
import org.infosec.ismp.manager.model.ServiceCheckResultEntity;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
/**
 * 服务检测Locator
 * @author jiel
 *
 */
@Component
public class ServiceCheckLocator implements ComponentLocator {
	/**
	 * nodeid<->domain
	 */
	private Map<String, DomainComponent> nodeidMaps = new HashMap<String, DomainComponent>();
	private DomainLocator m_domainLocator;
	private ServiceCheckNodeEntityService m_serviceCheckNodeService;
	
	@Autowired(required = true)
	public void setServiceCheckNodeService(
			ServiceCheckNodeEntityService serviceCheckNodeService) {
		m_serviceCheckNodeService = serviceCheckNodeService;
	}

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("ServiceCheck Locator 开始初始化");
		
		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
		distruteAllServiceCheckNode();
	}
	/**
	 * 初始化ServiceCheckNode任务
	 */
	public void distruteAllServiceCheckNode() {
		List<ServiceCheckNodeEntity> entities = getAllServiceCheckNode();
		for (ServiceCheckNodeEntity entity : entities) {
			String domain = entity.getDomain();
			
			Map<String,String> parameters = new HashMap<String,String>();			
			List<ServiceCheckNodeParamEntity> paramList = entity.getParam();
			if(paramList!=null){
				for (ServiceCheckNodeParamEntity serviceCheckNodeParamEntity : paramList) {
					parameters.put(serviceCheckNodeParamEntity.getParmName(), serviceCheckNodeParamEntity.getValue());				
				}
			}
			addServiceCheckNodeToDomain(domain, entity.getNodeid(),entity.getServiceType(), entity.getIpAddr(),
					entity.getInterval(),parameters);
		}
	}
	
	/**
	 * 从DB中获取所有ServiceCheckNode任务entity
	 * @return
	 */
	public List<ServiceCheckNodeEntity> getAllServiceCheckNode() {		
		return m_serviceCheckNodeService.getAll();
	}
	/**
	 * 添加一个ServiceCheckNode任务
	 * @param domain
	 * @param nodeid
	 * @param serviceType
	 * @param ipAddr
	 * @param interval
	 * @param parameters
	 */
	public void addServiceCheckNode(String domain,String nodeid,String serviceType,String ipAddr,long interval,Map<String,String> parameters){
		serviceType=serviceType.toLowerCase();
		addServiceCheckNodeToDb(domain,nodeid,serviceType,ipAddr, interval,parameters);
		addServiceCheckNodeToDomain(domain,nodeid,serviceType,ipAddr, interval,parameters);
	}
	/**
	 * 删除一个ServiceCheckNode任务
	 * @param nodeid
	 */
	public void removeServiceCheckNode(String nodeid){
		removeServiceCheckNodeFromDb(nodeid);
		removeServiceCheckNodeFromDomain(nodeid);
		nodeidMaps.remove(nodeid);
	}
	/**
	 * 将ServiceCheckNode任务添加到domainComponent
	 * @param domain
	 * @param nodeid
	 * @param serviceType
	 * @param ipAddr
	 * @param interval
	 * @param parameters
	 */
	private void addServiceCheckNodeToDomain(String domain,String nodeid,String serviceType,String ipAddr,long interval,Map<String,String> parameters) {
		DomainComponent domainComp = m_domainLocator
				.createDomainIfNessary(domain);
		nodeidMaps.put(nodeid, domainComp);
		ServiceCheckNode node = createServiceCheckNode(nodeid,serviceType, ipAddr, interval,parameters);
		domainComp.addServiceCheckNode(node);
	}
	
	/**
	 * 将ServiceCheckNode任务添加到Db
	 * @param domain
	 * @param nodeid
	 * @param serviceType
	 * @param ipAddr
	 * @param interval
	 * @param parameters
	 */
	private void addServiceCheckNodeToDb(String domain,String nodeid,String serviceType,String ipAddr,long interval,Map<String,String> parameters){
		ServiceCheckNodeEntity entity = createServiceCheckNodeEntity(domain, nodeid, serviceType, ipAddr, interval, parameters);
		m_serviceCheckNodeService.addServiceCheckNode(entity);
	}
	/**
	 * 根据nodeid从domainComponent中删除一个ServiceCheckNode任务
	 * @param nodeid
	 */
	private void removeServiceCheckNodeFromDomain(String nodeid){
		DomainComponent domainComp =nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.removeServiceCheckNode(nodeid);
			domainComp.RemoveServiceCheckResult(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug("removeServiceCheckNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}	
	}
	/**
	 * 根据nodeid从DB中删除一个ServiceCheckNode任务
	 * @param nodeid
	 */
	private void removeServiceCheckNodeFromDb(String nodeid){
		m_serviceCheckNodeService.removeServiceCheckNode(nodeid);
	}
	
	/**
	 * 创建一个ServiceCheckNode
	 * @param nodeid
	 * @param serviceType
	 * @param ipAddr
	 * @param interval
	 * @param parameters
	 * @return
	 */
	private ServiceCheckNode createServiceCheckNode(String nodeid,String serviceType,String ipAddr,long interval,Map<String,String> parameters){
		ServiceCheckNode node = new ServiceCheckNode();		
		node.setNodeid(nodeid);
		node.setIpAddr(ipAddr);
		node.setInterval(interval);
		node.setServiceType(serviceType);
		node.setParamMap(parameters);
		return node;
	}
	/**
	 * 创建一个ServiceCheckNodeEntity
	 * @param domain
	 * @param nodeid
	 * @param serviceType
	 * @param ipAddr
	 * @param interval
	 * @param parameters
	 * @return
	 */
	private ServiceCheckNodeEntity createServiceCheckNodeEntity(String domain,String nodeid,String serviceType,String ipAddr,long interval,Map<String,String> parameters){
		ServiceCheckNodeEntity entity = new ServiceCheckNodeEntity();
		entity.setDomain(domain);
		entity.setNodeid(nodeid);
		entity.setIpAddr(ipAddr);
		entity.setInterval(interval);
		entity.setServiceType(serviceType);
		List<ServiceCheckNodeParamEntity> paramList = entity.getParam();
		Set<String> paramKey = parameters.keySet();		
		for (Iterator<String> iterator = paramKey.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			ServiceCheckNodeParamEntity paramEntity = new ServiceCheckNodeParamEntity();
			paramEntity.setParmName(key);
			paramEntity.setValue(parameters.get(key));
			paramList.add(paramEntity);
		}
		return entity;
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
		if (domainComp != null) {
			return domainComp.getDomainId();
		} else {
			if (log().isDebugEnabled()) {
				log().debug("ServiceCheckLocator.getDomainByNodeid没有找到该nodeId：" + nodeid + "对应的域 ");
			}
			return null;
		}
	}

	/**
	 * 用于设置某个nodeid的状态
	 * @param nodeid
	 * @param entity
	 */
	public void setServiceCheckResult(String nodeid,
			ServiceCheckResultEntity entity) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.putServiceCheckResult(nodeid,entity);
		}
	}
	/**
	 * 获得某个nodeid的状态
	 * @param nodeid
	 * @return
	 */
	public ServiceCheckResultEntity getServiceCheckResult(String nodeid){
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			return domainComp.getServiceCheckResult(nodeid);
		}
		return null;
	}
}
