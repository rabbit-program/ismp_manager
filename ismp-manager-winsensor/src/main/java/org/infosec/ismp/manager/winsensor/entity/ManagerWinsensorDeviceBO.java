package org.infosec.ismp.manager.winsensor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Rocky
 * @version create time: Dec 23, 2010 2:09:24 PM
 *
 */
@Entity
@Table(name="manager_winsensor_device")
public class ManagerWinsensorDeviceBO implements Serializable {

	private static final long serialVersionUID = 1147934814065217825L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="sensor_id", length=100)
	private String sensorId;
	
	@Column(name="domain_id", length=100)
	private String domainId;
	
	@Column(name="agent_id", length=100)
	private String agentId;
	
	@Column(name="node_id", length=100)
	private String nodeId;
	
	@Column(name="sensor_ip", length=50)
	private String sensorIp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="register_time")
	private Date registerTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_monitor_time")
	private Date startMonitorTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getSensorIp() {
		return sensorIp;
	}

	public void setSensorIp(String sensorIp) {
		this.sensorIp = sensorIp;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getStartMonitorTime() {
		return startMonitorTime;
	}

	public void setStartMonitorTime(Date startMonitorTime) {
		this.startMonitorTime = startMonitorTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (null == obj) {
			return false;
		}
		
		if (!(obj instanceof ManagerWinsensorDeviceBO)) {
			return false;
		}
		
		ManagerWinsensorDeviceBO device = (ManagerWinsensorDeviceBO) obj;
		if (device.getSensorId().equals(getSensorId())) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int constant = 37;
		int total = 17;
		
		total = constant * total + ((getSensorId() == null) ? 0 : getSensorId().hashCode());
		
		return total;
	}
}
