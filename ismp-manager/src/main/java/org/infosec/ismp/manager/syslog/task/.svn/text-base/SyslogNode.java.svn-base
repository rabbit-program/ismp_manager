package org.infosec.ismp.manager.syslog.task;

import java.io.Serializable;

import org.infosec.ismp.manager.agent.AgentTaskNode;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;

public class SyslogNode implements Serializable,AgentTaskNode {
	private String domain;
	private String nodeid;
	private String ipaddr;
	private String syslogType;
	
	

	@Override
	public AgentTodoTask convertToTask() {
		return new AgentAddSyslogTask(this);
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	

	public String getSyslogType() {
		return syslogType;
	}

	public void setSyslogType(String syslogType) {
		this.syslogType = syslogType;
	}

	@Override
	public AgentTodoType getType() {
		return AgentTodoType.SYSLOG;
	}

	

}
