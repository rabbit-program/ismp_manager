package org.infosec.ismp.manager.domains;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.infosec.ismp.manager.agent.AgentComponent;
import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.servicecheck.ServiceCheckNode;
import org.infosec.ismp.manager.agent.sitecheck.SiteCheckNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
import org.infosec.ismp.manager.db.task.DatabaseNode;
import org.infosec.ismp.manager.model.PingResultEntity;
import org.infosec.ismp.manager.model.ServiceCheckResultEntity;
import org.infosec.ismp.manager.model.SiteCheckResultEntity;
import org.infosec.ismp.manager.model.db.DatabaseResultEntity;
import org.infosec.ismp.manager.ping.PingNode;
import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.cisco.CiscoDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.HostDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicDeviceStatus;
import org.infosec.ismp.manager.snmp.task.SnmpDeviceNode;
import org.infosec.ismp.manager.snmpTrap.SnmpTrapNode;
import org.infosec.ismp.manager.syslog.task.SyslogNode;

/**
 * 代表一个域对象,管理域中的设备、应用程序等被管理对象的状态， 决定域本身是否有告警信息等,不使用Spring管理
 * 
 * @author lianglin
 * 
 */
public class DomainComponent {
	/**
	 * 域唯一标识
	 */
	private final String m_domainId;

	/**
	 * 该域对应的Agent
	 */
	private Set<AgentComponent> m_agentComps = new HashSet<AgentComponent>();

	/**
	 * 存放nodeid和AgentComponent之间的映射关系
	 */
	private Map<NodeIdAndTypePair, AgentComponent> agentMaps = new HashMap<NodeIdAndTypePair, AgentComponent>();

    /**
     * 存放所有的Ping的结果
     */
	private StatusComponent<PingResultEntity> m_pingResult = new StatusComponent<PingResultEntity>();
	
    /**
     * 存放所有的database的结果
     */
	private StatusComponent<DatabaseResultStatus> m_databaseResult = new StatusComponent<DatabaseResultStatus>();
	
	/**
     * 存放所有的ServiceCheck的结果
     */
	private StatusComponent<ServiceCheckResultEntity> m_serviceCheckResult = new StatusComponent<ServiceCheckResultEntity>();
	
	/**
     * 存放所有的SiteCheck的结果
     */
	private StatusComponent<SiteCheckResultEntity> m_siteCheckResult = new StatusComponent<SiteCheckResultEntity>();
	
	
	/**
	 * put all status
	 */
	private StatusComponent<Serializable> m_statusResults = new StatusComponent<Serializable>();
	
	
	private Set<AgentTaskNode> m_taskNodes = new HashSet<AgentTaskNode>();
	
     /**
     * 存放所有的SnmpDeviceStatus的结果
     */
	private StatusComponent<SnmpDeviceStatus> m_snmpDeviceResult = new StatusComponent<SnmpDeviceStatus>();
	
	public DomainComponent(String domainId) {
		m_domainId = domainId;
	}

	public void removeSyslogSourceNode(String nodeId) {
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeId, AgentTodoType.SYSLOG);
		AgentComponent agent = agentMaps.get(key);
		if (agent != null) {
			agent.removeSyslogNode(nodeId);
			agentMaps.remove(key);
		}
	}

	/**
	 * 添加Syslog节点
	 * @param node
	 */
	public void addSyslogNode(SyslogNode node){
		addTaskNode(node);
	}
	

	

	public void removePingNode(String nodeid) {
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, AgentTodoType.PING);
		AgentComponent agent = agentMaps.get(key);
		if (agent != null) {
			agent.removePingNode(nodeid);
			agentMaps.remove(key);
		}
	}

	public void addPingNode(PingNode node) {
		addTaskNode(node);
	}

	private void addTaskNode(AgentTaskNode node) {
//		m_taskNodes.add(node);
		AgentComponent agent = findRightAgentComp();
     	agentMaps.put(new NodeIdAndTypePair(node.getNodeid(), node.getType()),
				agent);
     	
     	//TODO Check agent whether  is null.
     	if (agent != null) {
     		agent.addAgentTaskNode(node);
     	}
	}

	/**
	 * 添加网页检测节点
	 * @param node
	 */
	public void addSiteCheckNode(SiteCheckNode node){
		addTaskNode(node);
	}
	
	/**
	 * 重置网页检测节点
	 * @param node
	 */
	public void resetSiteCheckNode(String nodeid){
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, AgentTodoType.SITECHECK);
		AgentComponent agent = agentMaps.get(key);
		if (agent != null) {
			agent.resetSiteCheck(nodeid);
		}
	}
	/**
	 * 添加服务检测节点
	 * @param node
	 */
	public void addServiceCheckNode(ServiceCheckNode node) {
		addTaskNode(node);
	}
	
	/**
	 * 添加JDBc采集节点
	 * @param node
	 */

	public void addJdbcNode(DatabaseNode node){
		addTaskNode(node);
	}
	/**
	 * 添加Snmp采集节点
	 * @param node
	 */
	public void addSnmpCollectdNode(SnmpDeviceNode node){
		addTaskNode(node);
	}

	/**
	 * 删除服务检测节点
	 * @param nodeid
	 */
	public void removeServiceCheckNode(String nodeid) {
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, AgentTodoType.SERVICECHECK);
		AgentComponent agent = agentMaps.get(key);
		if (agent != null) {
			agent.removeServiceCheckNode(nodeid);
			agentMaps.remove(key);
		}
	}
	
	/**
	 * 删除网页检测节点
	 * @param nodeid
	 */
	public void removeSiteCheckNode(String nodeid){
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, AgentTodoType.SITECHECK);
		AgentComponent agent = agentMaps.get(key);
		if (agent != null) {
			agent.removeSiteCheckNode(nodeid);
			agentMaps.remove(key);
		}
	}
	
	/**
	 * 删除一个jdbc节点
	 * @param nodeid
	 */
	public void removeDatabaseCollectionNode(String nodeid){
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, AgentTodoType.JDBC);
		AgentComponent agent = agentMaps.get(key);
		if (agent != null) {
			agent.removeJdbcCollectdNode(nodeid);
			agentMaps.remove(key);
		}
	}
	
	/**
	 * 删除一个Snmp采集节点
	 * @param nodeid
	 */
	public void removeSnmpCollectdNode(String nodeid){
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, AgentTodoType.SNMP);
		AgentComponent agent = agentMaps.get(key);
		
		if (agent != null) {
			agent.removeSnmpCollectdNode(nodeid);
			agentMaps.remove(key);
		}
	}

	/**
	 * 设置该domain对应的Agent
	 * 
	 * @param agentComponents
	 */
	public void setAgentComponents(List<AgentComponent> agentComponents) {
		m_agentComps.addAll(agentComponents);
	}

	/**
	 * 找到一个负载最小的Agent
	 * 
	 * @return
	 */
	protected AgentComponent findRightAgentComp() {
		AgentComponent reAgent = null;
		int max = Integer.MAX_VALUE;
		Iterator<AgentComponent> agentIt = m_agentComps.iterator();
		while (agentIt.hasNext()) {
			AgentComponent agent = agentIt.next();
			if (agent.getAllNodeCount() < max) {
				max = agent.getAllNodeCount();
				reAgent = agent;
			}
		}
		return reAgent;
	}

	private static class NodeIdAndTypePair {
		String nodeid;
		AgentTodoType type;

		public NodeIdAndTypePair(final String nodeid, final AgentTodoType type) {
			this.nodeid = nodeid;
			this.type = type;
		}

		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this);
		}

		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(obj, this);
		}

	}
	
	public static void main(String[] args) {
	
		Map<NodeIdAndTypePair,String> testMap = new HashMap<NodeIdAndTypePair,String>();
		String nodeid="123";
		testMap.put(new NodeIdAndTypePair(nodeid, AgentTodoType.SERVICECHECK) , "test1");
		
		String pp=testMap.get(new NodeIdAndTypePair(nodeid, AgentTodoType.SERVICECHECK));
		System.out.println(pp);
	}

	/**
	 * 设置ping的状态
	 * @param nodeid
	 * @param entity
	 */
	public void putPingResult(String nodeid, PingResultEntity entity) {
		m_pingResult.setStatus(nodeid,StatusType.PING, entity);
		
	}

	public PingResultEntity getPingResult(String nodeid) {
		return m_pingResult.getStatus(nodeid,StatusType.PING);
	}

	/**
	 * 删除ping的状态
	 * @param nodeid
	 */
	public void RemovePingResult(String nodeid){
		m_pingResult.removeStatus(nodeid,StatusType.PING);
	}
	/**
	 * 设置ping的状态
	 * @param nodeid
	 * @param entity
	 */
	public void putDatabaseResult(String nodeid, DatabaseResultStatus status) {
		m_databaseResult.setStatus(nodeid,StatusType.DATABASE, status);
		
	}
	
    /**
     * 获取数据库状态信息
     */
	public DatabaseResultStatus getDatabaseResult(String nodeid) {
		return m_databaseResult.getStatus(nodeid,StatusType.DATABASE);
	}
	
	/**
	 * 设置serviceCheck的状态
	 * @param nodeid
	 * @param entity
	 */
	public void putServiceCheckResult(String nodeid, ServiceCheckResultEntity entity) {
		m_serviceCheckResult.setStatus(nodeid, StatusType.SERVICE_CHECK,entity);
		
	}
	
	/**
	 * 获取serviceCheck的状态
	 * @param nodeid
	 * @param entity
	 */
	public ServiceCheckResultEntity getServiceCheckResult(String nodeid) {
		return m_serviceCheckResult.getStatus(nodeid,StatusType.SERVICE_CHECK);
	}
	/**
	 * 删除servicecheck的状态
	 * @param nodeid
	 */
	public void RemoveServiceCheckResult(String nodeid){
		m_serviceCheckResult.removeStatus(nodeid,StatusType.SERVICE_CHECK);
	}
	/**
	 * 设置siteCheck的状态
	 * @param nodeid
	 * @param entity
	 */
	public void putSiteCheckResult(String nodeid, SiteCheckResultEntity entity) {
		m_siteCheckResult.setStatus(nodeid,StatusType.SITE_CHECK, entity);
		
	}
	
	/**
	 * 获取siteCheck的状态
	 * @param nodeid
	 * @param entity
	 */
	public SiteCheckResultEntity getSiteCheckResult(String nodeid) {
		return m_siteCheckResult.getStatus(nodeid,StatusType.SITE_CHECK);
	}
	/**
	 * 删除sitecheck的状态
	 * @param nodeid
	 */
	public void RemoveSiteCheckResult(String nodeid){
		m_siteCheckResult.removeStatus(nodeid,StatusType.SITE_CHECK);
	}

	public String getDomainId() {
		return this.m_domainId;
	}
	
	/**
	 * set status
	 * @param nodeid
	 * @param type
	 * @param status
	 */
	public void putStatus(String nodeid,StatusType type,Serializable status){
		m_statusResults.setStatus(nodeid,type, status);
	}
	
	/**
	 * get status
	 * @param nodeid
	 * @param type
	 * @return
	 */
	public Serializable getStatus(String nodeid,StatusType type){
		return m_statusResults.getStatus(nodeid,type);
	}
	
	/**
	 * remove status
	 * @param nodeid
	 * @param type
	 */
	public void removeStatus(String nodeid,StatusType type){
		m_statusResults.removeStatus(nodeid, type);
	}

	public AgentComponent getRightAgent() {
		return findRightAgentComp();
	}

	/**
	 * 存储SNMP设备信息
	*/
	
	public void cacheSnmpDeviceResult(String nodeid, SnmpDeviceStatus status) {
		m_snmpDeviceResult.setStatus(nodeid, StatusType.SNMP, status);

	}
    /**
     * 获取SNMP设备信息
     */
	public SnmpDeviceStatus getSnmpDeviceStatus(String nodeid){
		return m_snmpDeviceResult.getStatus(nodeid, StatusType.SNMP);
	}
	/**
	 * 添加SnmpTrap节点任务
	 * @param node
	 */
	public void addSnmpTrapNode(SnmpTrapNode node) {
		addTaskNode(node);
	}

	/**
	 * 删除snmpTrap任务节点
	 * @param nodeid
	 */
	public void removeSnmpTrapNodeByNodeId(String nodeid) {
		NodeIdAndTypePair key = new NodeIdAndTypePair(nodeid, AgentTodoType.SNMPTRAP);
		AgentComponent agent = agentMaps.get(key);
		if (agent != null) {
			agent.removeSnmpTrapNode(nodeid);
			agentMaps.remove(key);
		}
	}
}
