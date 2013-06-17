package org.infosec.ismp.manager.rmi.snmp.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author guoxianwei
 * @date 2010-12-14 下午04:31:25
 * 
 */
public class SnmpDeviceRmiBean implements Serializable {
	
	private static final long serialVersionUID = 2342135942373746672L;
	
	private String m_domain;
	private String m_nodeid;
	private Long m_interval;
	private String m_ipAddr;
	private Integer m_port;
	private String m_deviceType;
	private String m_brand;//品牌
	private String m_version;
	private String m_community;
	
	private Boolean m_halfWhenDown;
	
	public String getBrand() {
		return m_brand;
	}

	public void setBrand(String brand) {
		m_brand = brand;
	}
	public String getDomain() {
		return m_domain;
	}

	public String getNodeid() {
		return m_nodeid;
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

	public String getVersion() {
		return m_version;
	}

	public String getCommunity() {
		return m_community;
	}

	public Boolean getHalfWhenDown() {
		return m_halfWhenDown;
	}

	public void setDomain(String domain) {
		m_domain = domain;
	}

	public void setNodeid(String nodeid) {
		m_nodeid = nodeid;
	}

	public void setInterval(Long interval) {
		m_interval = interval;
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

	public void setVersion(String version) {
		m_version = version;
	}

	public void setCommunity(String community) {
		m_community = community;
	}

	public void setHalfWhenDown(Boolean halfWhenDown) {
		m_halfWhenDown = halfWhenDown;
	}

	public boolean equals(Object other) {
		if (!(other instanceof SnmpDeviceRmiBean)) {
			return false;
		}
		SnmpDeviceRmiBean rhs = (SnmpDeviceRmiBean) other;
		return new EqualsBuilder().appendSuper(super.equals(other)).append(
				m_nodeid, rhs.m_nodeid).append(m_ipAddr, rhs.m_ipAddr).append(m_port,
				rhs.m_port).append(m_deviceType, rhs.m_deviceType).append(m_community,
				rhs.m_community).append(m_version, rhs.m_version).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
				.append(m_nodeid).append(m_ipAddr).append(m_port).append(m_deviceType)
				.append(m_community).append(m_version).toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"m_nodeid", m_nodeid).append("m_ipAddr", m_ipAddr).append("m_port",
				m_port).append("m_deviceType", m_deviceType).append("m_community",
						m_community).append("m_version", m_version).toString();
	}
}

