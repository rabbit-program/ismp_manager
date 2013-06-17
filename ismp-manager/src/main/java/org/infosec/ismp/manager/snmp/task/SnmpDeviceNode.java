package org.infosec.ismp.manager.snmp.task;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;

public class SnmpDeviceNode implements AgentTaskNode {

	private static final long serialVersionUID = -57284319158347534L;

	private String m_nodeid;
	private String m_ipAddr;
	private Integer m_port;
	private String m_deviceType;
	private String m_brand;
	private String m_version;
	private Long m_interval;
	private String m_community;
	private Boolean m_halfWhenDown;

	@Override
	public AgentTodoTask convertToTask() {
		return new AgentAddSnmpDeviceTask(this);
	}

	@Override
	public String getNodeid() {
		return m_nodeid;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SNMP;
	}

	public String getBrand() {
		return m_brand;
	}

	public void setBrand(String brand) {
		m_brand = brand;
	}

	public String getVersion() {
		return m_version;
	}

	public Long getInterval() {
		return m_interval;
	}

	public String getIpAddr() {
		return m_ipAddr;
	}

	public Integer getPort() {
		return m_port;
	}

	public String getDeviceType() {
		return m_deviceType;
	}

	public String getCommunity() {
		return m_community;
	}

	public Boolean getHalfWhenDown() {
		return m_halfWhenDown;
	}

	public void setIpAddr(String ipAddr) {
		m_ipAddr = ipAddr;
	}

	public void setPort(Integer port) {
		m_port = port;
	}

	public void setDeviceType(String deviceType) {
		m_deviceType = deviceType;
	}

	public void setCommunity(String community) {
		m_community = community;
	}

	public Boolean isHalfWhenDown() {
		return m_halfWhenDown;
	}

	public void setHalfWhenDown(Boolean halfWhenDown) {
		m_halfWhenDown = halfWhenDown;
	}

	public void setNodeid(String nodeid) {
		m_nodeid = nodeid;
	}

	public void setVersion(String version) {
		m_version = version;
	}

	public void setInterval(Long interval) {
		m_interval = interval;
	}

	public boolean equals(Object other) {
		if (!(other instanceof SnmpDeviceNode)) {
			return false;
		}
		SnmpDeviceNode rhs = (SnmpDeviceNode) other;
		return new EqualsBuilder().appendSuper(super.equals(other)).append(
				m_nodeid, rhs.m_nodeid).append(m_ipAddr, rhs.m_ipAddr).append(
				m_port, rhs.m_port).append(m_deviceType, rhs.m_deviceType)
				.append(m_brand, rhs.m_brand).append(m_community,
						rhs.m_community).append(m_version, rhs.m_version)
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
				.append(m_nodeid).append(m_ipAddr).append(m_port).append(m_deviceType)
				.append(m_brand).append(m_community).append(m_version).toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"m_nodeid", m_nodeid).append("m_ipAddr", m_ipAddr).append(
				"m_port", m_port).append("m_deviceType", m_deviceType).append(
				"brand", m_brand).append("m_community", m_community).append(
				"m_version", m_version).toString();
	}

}
