package org.infosec.ismp.manager.db.task;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
/**
 * 
* @author guoxianwei
* @date 2010-12-14 下午04:43:44
*    数据库信息采集服务节点信息
 */
public class DatabaseNode implements AgentTaskNode {

	private static final long serialVersionUID = -57284319158347534L;

	private String m_nodeid;
	private String m_url;//数据库URL
	private Integer m_port;
	private String m_username;
	private String m_password;
	private String m_dbtype;
	private String m_version;
	private Long m_interval;
	private String m_dbname;
	private Boolean m_halfWhenDown;

	@Override
	public AgentTodoTask convertToTask() {
		return new AgentAddDatabaseTask(this);
	}

	@Override
	public String getNodeid() {
		return m_nodeid;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.JDBC;
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



	public String getVersion() {
		return m_version;
	}

	public String getDbname() {
		return m_dbname;
	}

	public Long getInterval() {
		return m_interval;
	}

	public String getDbtype() {
		return m_dbtype;
	}

	public Boolean isHalfWhenDown() {
		return m_halfWhenDown;
	}

	public void setDbtype(String dbtype) {
		m_dbtype = dbtype;
	}

	public void setHalfWhenDown(Boolean halfWhenDown) {
		m_halfWhenDown = halfWhenDown;
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


	public void setVersion(String version) {
		m_version = version;
	}

	public void setDbname(String dbname) {
		m_dbname = dbname;
	}

	public void setInterval(Long interval) {
		m_interval = interval;
	}

	public boolean equals(Object other) {
		if (!(other instanceof DatabaseNode)) {
			return false;
		}
		DatabaseNode rhs = (DatabaseNode) other;
		return new EqualsBuilder().appendSuper(super.equals(other)).append(
				m_nodeid, rhs.m_nodeid).append(m_url, rhs.m_url).append(m_port,
				rhs.m_port).append(m_dbname, rhs.m_dbname).append(m_dbtype,
				rhs.m_dbtype).append(m_version, rhs.m_version).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(61, 15).appendSuper(super.hashCode())
				.append(m_nodeid).append(m_url).append(m_port).append(m_dbname)
				.append(m_dbtype).append(m_version).toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"m_nodeid", m_nodeid).append("m_url", m_url).append("m_port",
				m_port).append("m_dbname", m_dbname).append("m_dbtype",
				m_dbtype).append("m_version", m_version).toString();
	}

}
