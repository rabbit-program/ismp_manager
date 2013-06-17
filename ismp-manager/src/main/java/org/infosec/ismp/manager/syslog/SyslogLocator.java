package org.infosec.ismp.manager.syslog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.manager.model.syslog.SyslogNodeEntity;
import org.infosec.ismp.manager.syslog.task.SyslogNode;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * 管理所有的syslog节点，初始化时从数据库中加载
 * 
 * @author lianglin
 * 
 */
@Component
public class SyslogLocator {

	private SyslogNodeService m_syslogService;

	private DomainLocator m_domainLocator;

	private final static String UNKNOWN_SYSLOG_TYPE = "unknown_syslog_type";

	/**
	 * nodeid<->domainComponent
	 */
	private Map<String, DomainComponent> m_syslogNodeMaps = new HashMap<String, DomainComponent>();

	/**
	 * ip<->syslogType
	 */
	private Map<String, String> m_syslogTypes = new HashMap<String, String>();

	/**
	 * 添加syslog node
	 * 
	 * @param domain
	 * @param nodeId
	 * @param syslogType
	 * @param syslogAddress
	 */
	public void addSyslogNode(String domain, String nodeId, String syslogType,
			String syslogAddress) {
		boolean flag = findExistSyslogNode(nodeId);
		if (flag) {
			throw new RuntimeException("重复添加，该任务中nodeid:" + nodeId + "已经存在");
		}
		addSyslogToDb(domain, nodeId, syslogType, syslogAddress);
		addSyslogToDomain(domain, nodeId, syslogAddress, syslogType);

	}

	private boolean findExistSyslogNode(String nodeId) {
		return m_syslogService.findExistingNode(nodeId);
	}

	/**
	 * 删除syslog node
	 * 
	 * @param nodeid
	 */
	public void removeSyslogNode(String nodeid) {
		removeSyslogNodeFromDb(nodeid);
		removeSyslogNodeFromDomain(nodeid);

	}

	private void removeSyslogNodeFromDb(String nodeid) {
		m_syslogService.removeNodeByNodeId(nodeid);

	}

	public void removeSyslogNodeFromDomain(String nodeid) {
		DomainComponent domainComp = m_syslogNodeMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.removeSyslogSourceNode(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug("removeSyslogNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}
	}

	@Autowired(required = true)
	public void setSyslogService(SyslogNodeService syslogService) {
		m_syslogService = syslogService;
	}

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}

	@PostConstruct
	protected void onInit() {
		log().info("SyslogLocator开始初始化");
		Assert.state(m_syslogService != null, "m_syslogService不能为空，请检查");
		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
		distruteAllSyslogNode();

	}

	private void distruteAllSyslogNode() {
		List<SyslogNodeEntity> entities = m_syslogService.getAll();
		for (SyslogNodeEntity entity : entities) {
			addSyslogToDomain(entity.getDomain(), entity.getNodeid(),
					entity.getIpaddr(), entity.getSyslogType());
		}

	}

	private void addSyslogToDomain(String domain, String nodeid, String ipaddr,
			String syslogType) {
		DomainComponent domainComp = m_domainLocator
				.createDomainIfNessary(domain);
		m_syslogNodeMaps.put(nodeid, domainComp);
		SyslogNode node = createSyslogNode(nodeid, ipaddr, syslogType);
		domainComp.addSyslogNode(node);
		String oldType = m_syslogTypes.get(ipaddr);
		if (oldType == null) {
			m_syslogTypes.put(ipaddr, syslogType);
		} else {
			m_syslogTypes.put(ipaddr, UNKNOWN_SYSLOG_TYPE);
		}
	}

	private SyslogNode createSyslogNode(String nodeid, String ipaddr,
			String syslogType) {
		SyslogNode node = new SyslogNode();
		node.setNodeid(nodeid);
		node.setIpaddr(ipaddr);
		node.setSyslogType(syslogType);
		// FIXME
		return node;
	}

	/**
	 * save it to db
	 * 
	 * @param domain
	 * @param nodeId
	 * @param syslogType
	 * @param syslogAddress
	 */
	@Transactional(readOnly = false)
	public void addSyslogToDb(String domain, String nodeId, String syslogType,
			String syslogAddress) {
		SyslogNodeEntity entity = createSyslogEntity(domain, nodeId,
				syslogType, syslogAddress);
		m_syslogService.save(entity);
	}

	protected SyslogNodeEntity createSyslogEntity(String domain, String nodeId,
			String syslogType, String syslogAddress) {
		SyslogNodeEntity entity = new SyslogNodeEntity();
		entity.setDomain(domain);
		entity.setNodeid(nodeId);
		entity.setSyslogType(syslogType);
		entity.setIpaddr(syslogAddress);
		return entity;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	public boolean existSyslogType(String ip) {
		String type = m_syslogTypes.get(ip);
		if (type == null) {
			return false;
		} else if (UNKNOWN_SYSLOG_TYPE.equals(type)) {
			return false;
		} else {
			return true;
		}
	}
	
	public String getSyslogType(String ip){
		return m_syslogTypes.get(ip);
	}

	public String getSyslogDomain(String nodeid) {
		DomainComponent domainComp = m_syslogNodeMaps.get(nodeid);
		if(domainComp!=null){
			return domainComp.getDomainId();
		}
		return null;
	}

}
