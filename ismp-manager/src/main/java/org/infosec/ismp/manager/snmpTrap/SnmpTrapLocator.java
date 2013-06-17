package org.infosec.ismp.manager.snmpTrap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.infosec.ismp.manager.ComponentLocator;
import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.manager.model.SnmpTrapNodeEntity;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class SnmpTrapLocator implements ComponentLocator {
	/**
	 * nodeid<->domain
	 */
	private Map<String, DomainComponent> nodeidMaps = new HashMap<String, DomainComponent>();
	private DomainLocator m_domainLocator;
	private SnmpTrapNodeEntityService m_snmpTrapService;
	
	@Autowired(required = true)
	public void setSnmpTrapService(SnmpTrapNodeEntityService snmpTrapService) {
		m_snmpTrapService = snmpTrapService;
	}

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}

	@PostConstruct
	public void init() {
		System.out.println("SnmpTrap Locator 开始初始化");
		Assert.state(m_snmpTrapService != null, "m_pingDao不能为空，请检查");
		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
		distruteAllSnmpTrapNode();
	}
	/**
	 * 初始化snmpTrapNode任务
	 */
	public void distruteAllSnmpTrapNode() {
		List<SnmpTrapNodeEntity> entities = getAllSnmpTrapNode();
		for (SnmpTrapNodeEntity entity : entities) {
			String domain = entity.getDomain();
			addSnmpTrapNodeToDomain(domain,entity.getNodeid()
					,entity.getSnmpTrapType(),entity.getSnmpTrapAddress());
		}
	}
	/**
	 * 从DB中获取所有snmpTrapNode任务entity
	 * @return
	 */
	public List<SnmpTrapNodeEntity> getAllSnmpTrapNode() {		
		return m_snmpTrapService.getAll();
	}
	
	/**
	 * 新增snmpTrap服务
	 * @param domain
	 * @param nodeid
	 * @param url
	 * @param interval
	 */
	public void addSnmpTrapNode(String domain, String nodeid,
			String snmpTrapType, String snmpTrapAddress){		
		addSnmpTrapNodeToDb(domain,nodeid,snmpTrapType,snmpTrapAddress);
		addSnmpTrapNodeToDomain(domain,nodeid,snmpTrapType,snmpTrapAddress);
	}
	/**
	 * 将snmpTrap任务添加到domainComponent
	 * @param domain
	 * @param nodeid
	 * @param ipaddr
	 * @param interval
	 * @param halfFlag
	 */
	private void addSnmpTrapNodeToDomain(String domain, String nodeid,
			String snmpTrapType, String snmpTrapAddress) {
		DomainComponent domainComp = m_domainLocator
				.createDomainIfNessary(domain);
		nodeidMaps.put(nodeid, domainComp);
		SnmpTrapNode node = createSnmpTrapNode(nodeid,snmpTrapType,snmpTrapAddress);
		domainComp.addSnmpTrapNode(node);
	}
	/**
	 * 将sitecheck任务添加到数据库中
	 * @param domain
	 * @param nodeid
	 * @param url
	 * @param interval
	 */
	private void addSnmpTrapNodeToDb(String domain, String nodeid,
			String snmpTrapType, String snmpTrapAddress){
		SnmpTrapNodeEntity entity = new SnmpTrapNodeEntity();
		entity.setDomain(domain);
		entity.setNodeid(nodeid);
		entity.setSnmpTrapAddress(snmpTrapAddress);
		entity.setSnmpTrapType(snmpTrapType);
		m_snmpTrapService.addSnmpTrapNode(entity);
	}
	
	/**
	 * 删除sitecheck服务
	 * @param nodeid
	 */
	public void removeSnmpTrapNode(String nodeid){
		removeSnmpTrapNodeFromDb(nodeid);
		removeSnmpTrapNodeFromDomain(nodeid);
		nodeidMaps.remove(nodeid);
	}
	
	/**
	 * 创建一个SnmpTrapNode
	 * @param nodeid
	 * @param url
	 * @param interval
	 * @return
	 */
	private SnmpTrapNode createSnmpTrapNode(String nodeid,String snmpTrapType, String snmpTrapAddress){
		SnmpTrapNode node = new SnmpTrapNode();
		node.setNodeid(nodeid);
		node.setSnmpTrapAddress(snmpTrapAddress);
		node.setSnmpTrapType(snmpTrapType);
		return node;
	}
	/**
	 * 从domainComponent中删除一个snmpTrapNode任务
	 * @param nodeid
	 */
	private void removeSnmpTrapNodeFromDomain(String nodeid){
		DomainComponent domainComp =nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.removeSnmpTrapNodeByNodeId(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug("removeSnmpTrapNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}		
	}
	/**
	 * 从DB中删除一个snmpTrapNode
	 * @param nodeid
	 */
	private void removeSnmpTrapNodeFromDb(String nodeid){
		m_snmpTrapService.removeSnmpTrapNodeByNodeId(nodeid);
	}
	
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	public String getDomainByNodeId(String nodeid) {
		DomainComponent dc  = nodeidMaps.get(nodeid);
		if(dc!=null)
			return dc.getDomainId();
		return null;
	}
}
