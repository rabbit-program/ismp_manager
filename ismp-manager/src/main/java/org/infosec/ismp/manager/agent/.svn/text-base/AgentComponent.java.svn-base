package org.infosec.ismp.manager.agent;

import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.infosec.ismp.manager.agent.servicecheck.AgentRemoveServiceCheckTask;
import org.infosec.ismp.manager.agent.servicecheck.ServiceCheckNode;
import org.infosec.ismp.manager.agent.sitecheck.AgentRemoveSiteCheckTask;
import org.infosec.ismp.manager.agent.sitecheck.AgentResetSiteCheckTask;
import org.infosec.ismp.manager.agent.sitecheck.SiteCheckNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
import org.infosec.ismp.manager.db.task.AgentRemoveDatabaseTask;
import org.infosec.ismp.manager.db.task.DatabaseNode;
import org.infosec.ismp.manager.ping.AgentRemovePingTask;
import org.infosec.ismp.manager.ping.PingNode;
import org.infosec.ismp.manager.snmp.task.AgentRemoveSnmpDeviceTask;
import org.infosec.ismp.manager.snmp.task.SnmpDeviceNode;
import org.infosec.ismp.manager.snmpTrap.AgentRemoveSnmpTrapTask;
import org.infosec.ismp.manager.syslog.task.AgentRemoveSyslogTask;
import org.infosec.ismp.manager.syslog.task.SyslogNode;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 代表远程的Agent对象,不使用Spring管理，因为该对象需要根据Agent对象动态创建,因此 需要手工注入管理Agent对象数据库操作对象。
 * 
 * @author lianglin
 * 
 */
public class AgentComponent {

	private boolean active = false;

	// Agent的唯一标识
	private final String agentId;
	// 标识Agent是否重启，重启后uuid不一样
	private String uuid;
	// 激活时间
	private long activeTime;

	private Set<AgentTaskNode> m_taskNodes = new HashSet<AgentTaskNode>();

	// /**
	// * 所有的Ping任务
	// */
	// private Set<PingNode> m_pingNodes = new HashSet<PingNode>();
	// /**
	// * 所有的Syslog任务
	// */
	// private Set<SyslogNode> m_syslogNodes = new HashSet<SyslogNode>();
	//
	// /**
	// * 所有的网页安全检查任务
	// */
	// private Set<SiteCheckNode> m_siteCheckNodes = new
	// HashSet<SiteCheckNode>();
	//
	//
	// /**
	// * 所有的服务检查任务
	// */
	// private Set<ServiceCheckNode> m_serviceCheckNodes = new
	// HashSet<ServiceCheckNode>();
	//
	// /**
	// * 所有的Snmp任务
	// */
	// private Set<SnmpCollectdNode> m_snmpCollectdNodes = new
	// HashSet<SnmpCollectdNode>();
	//
	// /**
	// * 所有的JDBC任务
	// */
	// private Set<JdbcCollectdNode> m_jdbcCollectdNodes = new
	// HashSet<JdbcCollectdNode>();

	private PropertyChangeSupport m_support = new PropertyChangeSupport(this);

	/**
	 * 代表有个对应的远程Agent存在或者曾经存在
	 */
	private AgentCompSnapShot m_snapShot;

	/**
	 * 任务数
	 */
	private int nodeCount = 0;

	/**
	 * 序列化文件
	 */
	private File tempFile;

	/**
	 * 创建一个新的AgentComponent
	 */
	public AgentComponent(String agentId) {
		this.agentId = agentId;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		boolean newValue = active;
		boolean oldValue = this.active;
		if (newValue != oldValue) {
			this.active = active;
			m_support.firePropertyChange("active", oldValue, newValue);
		}
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agent的AgentId是： " + agentId);
		// builder.append("; Agent的ipaddr是: "+ipAddr);
		builder.append("; agent的uuid是: " + uuid);
		// builder.append("; agent的port是"+port);
		return builder.toString();
	}

	/**
	 * 返回该Agent的所有任务数
	 * 
	 * @return
	 */
	public int getAllNodeCount() {
		return this.nodeCount;
	}

	protected void increaseNodeCount() {
		this.nodeCount += 1;
	}

	protected void decreaseNodeCount() {
		this.nodeCount -= 1;
	}

	protected void addAgentTodoTask(AgentTodoTask task) {
		// m_todoNodes.add(task);
		if (m_snapShot != null) {
			m_snapShot.addAgentTask(task);
		}
	}

	protected void addTaskNodeDo(AgentTaskNode node) {
		m_taskNodes.add(node);

	}

	/**
	 * 添加Syslog节点
	 * 
	 * @param node
	 */
	public void addSyslogNode(SyslogNode node) {
		// increaseNodeCount();
		// addTaskNodeDo(node);
		// AgentTodoTask task = node.convertToTask();
		// addAgentTodoTask(task);
		addAgentTaskNode(node);
	}

	/**
	 * 添加Ping任务
	 */
	public void addPingNode(PingNode pingNode) {
		addAgentTaskNode(pingNode);
	}

	public void addAgentTaskNode(AgentTaskNode pingNode) {
		increaseNodeCount();
		addTaskNodeDo(pingNode);
		AgentTodoTask task = pingNode.convertToTask();
		addAgentTodoTask(task);
	}

	/**
	 * 删除Syslog节点
	 * 
	 * @param nodeid
	 */
	public void removeSyslogNode(String nodeid) {
		AgentTaskNode node = findTaskNode(nodeid, AgentTodoType.SYSLOG);
		if (node != null) {
			removeTaskNodeDo(node);
			decreaseNodeCount();
			AgentRemoveSyslogTask task = new AgentRemoveSyslogTask(nodeid);
			addAgentTodoTask(task);
		}
	}

	private void removeTaskNodeDo(AgentTaskNode node) {
		m_taskNodes.remove(node);

	}

	protected AgentTaskNode findTaskNode(String nodeid, AgentTodoType type) {
		AgentTaskNode rev = null;
		if(m_taskNodes != null){
			for (AgentTaskNode node : m_taskNodes) {
				if (nodeid.equals(node.getNodeid()) && node.getType() == type) {
					rev = node;
					break;
				}
			}
		}
		return rev;
	}

	/**
	 * 添加snmp采集
	 * 
	 * @param node
	 */
	public void addSnmpCollectdNode(SnmpDeviceNode node) {
		addAgentTaskNode(node);
	}

	/**
	 * 删除snmp采集
	 * 
	 * @param nodeid
	 */
	public void removeSnmpCollectdNode(String nodeid) {
		AgentTaskNode node = findTaskNode(nodeid, AgentTodoType.SNMP);
		if (node != null) {
			removeTaskNodeDo(node);
			decreaseNodeCount();
			AgentRemoveSnmpDeviceTask task = new AgentRemoveSnmpDeviceTask(
					nodeid);
			addAgentTodoTask(task);
		}
	}

	/**
	 * 添加jdbc采集
	 * 
	 * @param node
	 */
	public void addJdbcCollectdNode(DatabaseNode node) {
		addAgentTaskNode(node);
	}

	/**
	 * 删除jdbc采集
	 * 
	 * @param nodeid
	 */
	public void removeJdbcCollectdNode(String nodeid) {
		AgentTaskNode node = findTaskNode(nodeid, AgentTodoType.JDBC);
		if (node != null) {
			removeTaskNodeDo(node);
			decreaseNodeCount();
			AgentRemoveDatabaseTask task = new AgentRemoveDatabaseTask(nodeid);
			addAgentTodoTask(task);
		}
	}

	/**
	 * 添加网页检测
	 * 
	 * @param node
	 */
	public void addSiteCheckNode(SiteCheckNode node) {
		addAgentTaskNode(node);
	}

	/**
	 * 删除网页检测
	 * 
	 * @param nodeid
	 */
	public void removeSiteCheckNode(String nodeid) {
		AgentTaskNode node = findTaskNode(nodeid, AgentTodoType.SITECHECK);
		if (node != null) {
			removeTaskNodeDo(node);
			decreaseNodeCount();
			AgentRemoveSiteCheckTask task = new AgentRemoveSiteCheckTask(nodeid);
			addAgentTodoTask(task);
		}
	}

	public void addServiceCheck(ServiceCheckNode node) {
		addAgentTaskNode(node);
	}

	public void removeServiceCheckNode(String nodeid) {
		AgentTaskNode node = findTaskNode(nodeid, AgentTodoType.SERVICECHECK);
		if (node != null) {
			removeTaskNodeDo(node);
			decreaseNodeCount();
			AgentRemoveServiceCheckTask task = new AgentRemoveServiceCheckTask(
					nodeid);
			addAgentTodoTask(task);
		}
	}

	// ///////////////////////////////////////ping
	// //////////////////////////////////////////////////

	/**
	 * 删除一个Ping任务
	 * 
	 * @param nodeid
	 */
	public void removePingNode(String nodeid) {
		AgentTaskNode node = findTaskNode(nodeid, AgentTodoType.PING);
		if (node != null) {
			removeTaskNodeDo(node);
			decreaseNodeCount();
			AgentRemovePingTask task = new AgentRemovePingTask(nodeid);
			addAgentTodoTask(task);
		}
	}

	// public void removeTaskNode(String nodeid,AgentTodoType type){
	//
	// }

	public void setTempFile(File file) {
		this.tempFile = file;

	}

	/**
	 * 每次收到注册事件时调用接口
	 * 
	 * @param uuid
	 * @param ipaddr
	 * @param port
	 */
	public void register(String uuid, String ipaddr, int port) {
		activeTime = System.currentTimeMillis();
		setActive(true);
		if (m_snapShot == null) {// 第一次注册
			m_snapShot = new AgentCompSnapShot(this, tempFile);
		}
		m_snapShot.register(uuid, ipaddr, port);
	}

	/**
	 * 返回注册时间
	 * 
	 * @return
	 */
	public long getRegisterTime() {
		return activeTime;
	}

	/**
	 * 将Agent至于不在线状态
	 */
	public void unactive() {
		setActive(false);
		if (m_snapShot != null) {
			m_snapShot.setActive(false);
		}
	}

	public String getAgentId() {
		return agentId;
	}

	public static void main(String[] args) {
		AgentComponent agent = new AgentComponent("test");
		agent.setTempFile(new File("test.ser"));
		agent.register("xxxx", "192.168.9.254", 192);
		// agent.save();
		System.out.println("agent is : " + agent);

		agent = new AgentComponent("test");
		agent.setTempFile(new File("test.ser"));
		// agent.init();
		System.out.println("agent is : " + agent);
	}

	public List<AgentTaskNode> getAllTaskNodes() {
		List<AgentTaskNode> tasks = new LinkedList<AgentTaskNode>();
		tasks.addAll(m_taskNodes);
		return tasks;
	}

	public void resetSiteCheck(String nodeid) {
		//FIXME BUG WHEN Agent is offline
		AgentResetSiteCheckTask task = new AgentResetSiteCheckTask(nodeid);
		addAgentTodoTask(task);

	}

	public int getAgentPort() {
		if(m_snapShot!=null)return m_snapShot.getAgentPort();
		return -1;
	}

	public String getAgentAddress() {
		if(m_snapShot!=null)return m_snapShot.getAgentAddress();
		return null;
	}
	
	/**
	 * 删除snmpTrap任务节点
	 * @param nodeid
	 */
	public void removeSnmpTrapNode(String nodeid) {
		AgentTaskNode node = findTaskNode(nodeid, AgentTodoType.SNMPTRAP);
		if (node != null) {
			removeTaskNodeDo(node);
			decreaseNodeCount();
			AgentRemoveSnmpTrapTask task = new AgentRemoveSnmpTrapTask(nodeid);
			addAgentTodoTask(task);
		}
	}

	// public void init() {
	// if(tempFile.exists()){
	// m_snapShot = new AgentCompSnapShot(this, tempFile);
	// m_snapShot.read();
	// log().info("从快照中恢复Agent,快照文件位置是:"+tempFile+",AgentId is : "+agentId);
	// }else{
	// log().info("该Agent没有快照,Agent is : "+agentId);
	// }
	//
	// }
}
