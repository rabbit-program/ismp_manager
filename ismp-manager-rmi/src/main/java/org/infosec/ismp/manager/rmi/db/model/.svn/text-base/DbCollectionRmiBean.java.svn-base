package org.infosec.ismp.manager.rmi.db.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * @author guoxianwei
 * @date 2010-12-14 下午03:05:05
 * 远程接口参数BEAN
 */
public class DbCollectionRmiBean implements Serializable {

	private static final long serialVersionUID = -3272961073338077297L;

	private String m_domain;
	private String m_nodeid;
	private String m_url;
	private Integer m_port;
	private String m_username;
	private String m_password;
	private String m_driver;
	private String m_dbtype;
	private String m_version;
	private Long m_interval;
	private String m_dbname;
	private Boolean m_halfWhenDown;

	public String getDomain() {
		return m_domain;
	}

	public String getNodeid() {
		return m_nodeid;
	}

	public String getUrl() {
		return m_url;
	}

	public Integer getPort() {
		return m_port;
	}

	public String getUsername() {
		return m_username;
	}

	public String getPassword() {
		return m_password;
	}

	public String getDriver() {
		return m_driver;
	}

	public String getDbtype() {
		return m_dbtype;
	}

	public String getVersion() {
		return m_version;
	}

	public Long getInterval() {
		return m_interval;
	}

	public String getDbname() {
		return m_dbname;
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

	public void setUrl(String url) {
		m_url = url;
	}

	public void setPort(Integer port) {
		m_port = port;
	}

	public void setUsername(String username) {
		m_username = username;
	}

	public void setPassword(String password) {
		m_password = password;
	}

	public void setDriver(String driver) {
		m_driver = driver;
	}

	public void setDbtype(String dbtype) {
		m_dbtype = dbtype;
	}

	public void setVersion(String version) {
		m_version = version;
	}

	public void setInterval(Long interval) {
		m_interval = interval;
	}

	public void setDbname(String dbname) {
		m_dbname = dbname;
	}

	public void setHalfWhenDown(Boolean halfWhenDown) {
		m_halfWhenDown = halfWhenDown;
	}

	public boolean equals(Object other) {
		if (!(other instanceof DbCollectionRmiBean)) {
			return false;
		}
		DbCollectionRmiBean rhs = (DbCollectionRmiBean) other;
		return new EqualsBuilder().appendSuper(super.equals(other)).append(
				m_domain, rhs.m_domain).append(m_nodeid, rhs.m_nodeid)
				.append(m_url, rhs.m_url).append(m_port, rhs.m_port).append(
						m_dbname, rhs.m_dbname).append(m_dbtype, rhs.m_dbtype)
				.append(m_version, rhs.m_version).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
				.append(m_domain).append(m_nodeid).append(m_url).append(
						m_port).append(m_dbname).append(m_dbtype).append(
						m_version).toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"domainid", m_domain).append("nodeid", m_nodeid).append(
				"url", m_url).append("port", m_port).append("dbname", m_dbname)
				.append("dbtype", m_dbtype).append("version", m_version)
				.toString();
	}
}

