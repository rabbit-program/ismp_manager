package org.infosec.ismp.agent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.infosec.ismp.util.BaseObject;

/**
 * @author guoxianwei
 * @date 2010-9-20 下午04:09:42
 * 
 */
@Entity
@Table(name="agent_config")
public class AgentConfig extends BaseObject {
	
	private static final long serialVersionUID = 8675679847893095951L;
	
	private int id;
	private String agentName;
	private int syslogdPort;
	private int specialPollerThread;
	private int pollerThread;
	private int trapdPort;
	private int receiveEventPort;
	private String agentAddr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	@Column(name="agent_name",length=128)
	public String getAgentName() {
		return agentName;
	}
	@Column(name="syslogd_port",length=128)
	public int getSyslogdPort() {
		return syslogdPort;
	}
	@Column(name="special_poller_thread",length=128)
	public int getSpecialPollerThread() {
		return specialPollerThread;
	}
	@Column(name="poller_thread",length=128)
	public int getPollerThread() {
		return pollerThread;
	}
	@Column(name="trapd_port",length=128)
	public int getTrapdPort() {
		return trapdPort;
	}
	@Column(name="receive_event_port",length=128)
	public int getReceiveEventPort() {
		return receiveEventPort;
	}
	@Column(name="agent_addr",length=128)
	public String getAgentAddr() {
		return agentAddr;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public void setSyslogdPort(int syslogdPort) {
		this.syslogdPort = syslogdPort;
	}

	public void setSpecialPollerThread(int specialPollerThread) {
		this.specialPollerThread = specialPollerThread;
	}

	public void setPollerThread(int pollerThread) {
		this.pollerThread = pollerThread;
	}

	public void setTrapdPort(int trapdPort) {
		this.trapdPort = trapdPort;
	}

	public void setReceiveEventPort(int receiveEventPort) {
		this.receiveEventPort = receiveEventPort;
	}

	public void setAgentAddr(String agentAddr) {
		this.agentAddr = agentAddr;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}

