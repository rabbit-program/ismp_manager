package org.infosec.ismp.manager.snmp;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.infosec.ismp.manager.ComponentLocator;
import org.infosec.ismp.manager.domains.DomainComponent;
import org.infosec.ismp.manager.domains.DomainLocator;
import org.infosec.ismp.manager.model.SnmpDeviceNodeEntity;
import org.infosec.ismp.manager.rmi.snmp.model.NetworkDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceRmiBean;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.InterfaceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus;
import org.infosec.ismp.manager.snmp.dao.SnmpDeviceNodeEntityService;
import org.infosec.ismp.manager.snmp.task.SnmpDeviceNode;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 是添加SnmpDevice任务的入口类
 * 
 * @author lianglin
 * 
 */
@Component
public class SnmpDeviceLocator implements ComponentLocator {

	/**
	 * nodeid<->domain
	 */
	private static Map<String, DomainComponent> nodeidMaps = new HashMap<String, DomainComponent>();

	private SnmpDeviceNodeEntityService m_snmpDeviceService;
	private DomainLocator m_domainLocator;

	@Autowired(required = true)
	public void setSnmpDeviceService(
			SnmpDeviceNodeEntityService snmpDeviceService) {
		m_snmpDeviceService = snmpDeviceService;
	}

	@Autowired(required = true)
	public void setDomainLocator(DomainLocator domainLocator) {
		m_domainLocator = domainLocator;
	}

	public SnmpDeviceLocator() {
	}

	@PostConstruct
	public void init() {
		System.out.println("SnmpDevice Locator 开始初始化");
		Assert.state(m_snmpDeviceService != null, "m_SnmpDeviceDao不能为空，请检查");
		Assert.state(m_domainLocator != null, "m_domainLocator不能为空，请检查");
		distruteAllSnmpDeviceNode();
	}

	public List<SnmpDeviceNodeEntity> getAllSnmpDeviceNode() {
		List<SnmpDeviceNodeEntity> entites = m_snmpDeviceService.getAll();
		return entites;
	}

	public void distruteAllSnmpDeviceNode() {
		List<SnmpDeviceNodeEntity> entities = getAllSnmpDeviceNode();
		for (SnmpDeviceNodeEntity entity : entities) {
			addSnmpDeviceNodeToDomain(entity);
		}
	}

	public void addSnmpDeviceNode(SnmpDeviceRmiBean rmiBean) {
		SnmpDeviceNodeEntity entity = new SnmpDeviceNodeEntity();
		copySnmpDeviceNodeProperties(entity, rmiBean);
		addSnmpDeviceNodeToDb(entity);

		addSnmpDeviceNodeToDomain(entity);
	}

	/**
	 * 将SnmpDevice任务添加到domainComponent
	 * 
	 * @param SnmpDeviceNodeEntity
	 */
	private void addSnmpDeviceNodeToDomain(SnmpDeviceNodeEntity entity) {
		DomainComponent domainComp = m_domainLocator
				.createDomainIfNessary(entity.getDomain());
		nodeidMaps.put(entity.getNodeid(), domainComp);
		SnmpDeviceNode node = createSnmpDeviceNode(entity);

		domainComp.addSnmpCollectdNode(node);
	}

	protected SnmpDeviceNode createSnmpDeviceNode(SnmpDeviceNodeEntity entity) {
		SnmpDeviceNode node = new SnmpDeviceNode();
		copySnmpDeviceNodeProperties(node, entity);
		return node;
	}

	private void addSnmpDeviceNodeToDb(SnmpDeviceNodeEntity entity) {

		m_snmpDeviceService.save(entity);
	}

	public void removeSnmpDeviceNode(String nodeid) {
		removeSnmpDeviceNodeFromDb(nodeid);
		removeSnmpDeviceNodeFromDomain(nodeid);
	}

	private void removeSnmpDeviceNodeFromDomain(String nodeid) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {

			domainComp.removeSnmpCollectdNode(nodeid);
		} else {
			if (log().isDebugEnabled()) {
				log().debug(
						"removeSnmpDeviceNode没有找到该nodeId：" + nodeid + "对应的域 ");
			}
		}
	}
	//根据nodeid获得域ID
    public static String getDomainId(String nodeid){
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			return domainComp.getDomainId();
		}else{
			return null;
		}
    }
	private void copySnmpDeviceNodeProperties(Object dest, Object orig) {
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			log()
					.debug(
							"SnmpDeviceLocator : the caller does not have access to the property accessor method",
							e);
		} catch (InvocationTargetException e) {
			log()
					.debug(
							"SnmpDeviceLocator : the type of SnmpDeviceNodeEntity property is diffent from SnmpDeviceNode",
							e);
		}
	}

	private void removeSnmpDeviceNodeFromDb(String nodeid) {
		m_snmpDeviceService.removeSnmpDeviceNodeByNodeId(nodeid);
	}


	/**
	 * 用nodeid做索引存储SnmpDeviceStatus采集结果到内存域中。
	 */
	public void cacheSnmpDeviceResult(String nodeid, SnmpDeviceStatus status) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			domainComp.cacheSnmpDeviceResult(nodeid, status);
		}
	}
	public SnmpDeviceStatus getSnmpDeviceStatus(String nodeid) {
		DomainComponent domainComp = nodeidMaps.get(nodeid);
		if (domainComp != null) {
			return domainComp.getSnmpDeviceStatus(nodeid);
		}
		return null;
	}
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	/**
	*  获得网络接口进出口流量
	*/
	
	public InterfaceStatus[] getInterfaceStatus(String nodeid) {
		SnmpDeviceStatus snmpDevice = getSnmpDeviceStatus(nodeid);
		if(snmpDevice ==null)return null;
		NetworkDeviceStatus networkDevice = snmpDevice.getNetworkDeviceStatus();
		if(networkDevice ==null)return null;
		NetworkStatus networkStatus = networkDevice.getNetworkStatus();
		if(networkStatus ==null)return null;
		InterfaceStatus[] InterfaceStatus = networkStatus.getInterfaceStatus();
		return InterfaceStatus;
	}
}
