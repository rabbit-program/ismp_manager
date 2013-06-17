package org.infosec.ismp.manager.rmi.snmp.model.weblogic;

import java.util.List;

/**
 * @author guoxianwei
 * @date 2010-12-23 下午02:31:05
 * 
 *  weblogic 综合信息，提供前台调用
 *  
 */
public class WeblogicDeviceStatus {

	private String nodeid;

	private boolean active;

	private String domain;
	
	private String ipAddr;
	
	private List<WeblogicJdbcConnectionPoolStatus> m_jdbcConnectionPoolStatus;

	private List<WeblogicJvmStatus> m_jvmStatus;

	private List<WeblogicThreadPoolStatus> m_threadPoolStatus;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public String getDomain() {
		return domain;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public List<WeblogicJdbcConnectionPoolStatus> getJdbcConnectionPoolStatus() {
		return m_jdbcConnectionPoolStatus;
	}

	public List<WeblogicJvmStatus> getJvmStatus() {
		return m_jvmStatus;
	}

	public List<WeblogicThreadPoolStatus> getThreadPoolStatus() {
		return m_threadPoolStatus;
	}

	public void setJdbcConnectionPoolStatus(
			List<WeblogicJdbcConnectionPoolStatus> jdbcConnectionPoolStatus) {
		m_jdbcConnectionPoolStatus = jdbcConnectionPoolStatus;
	}

	public void setJvmStatus(List<WeblogicJvmStatus> jvmStatus) {
		m_jvmStatus = jvmStatus;
	}

	public void setThreadPoolStatus(
			List<WeblogicThreadPoolStatus> threadPoolStatus) {
		m_threadPoolStatus = threadPoolStatus;
	}

}

