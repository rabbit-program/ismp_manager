package org.infosec.ismp.agent.comm.winsensor.model;

import java.io.Serializable;

/**
 * @author Rocky
 * @version create time：Oct 19, 2010 10:50:13 AM
 * 
 */
public class CommWinsensorDevice implements Serializable {

	private static final long serialVersionUID = -2544682552757706356L;

	private String ip;
	
	private String mac;
	
	private String sensorId;
	
	private String nodeId;
	
	private long timeout;
	
	private int retries;
	
	private String agentId;
	
	private String agentAddress;
	
	private String domainId;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public int getRetries() {
		return retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentAddress() {
		return agentAddress;
	}

	public void setAgentAddress(String agentAddress) {
		this.agentAddress = agentAddress;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof CommWinsensorDevice)) {
			return false;
		}
		
		CommWinsensorDevice device = (CommWinsensorDevice) obj;
		if (device.getIp().equals(ip) && device.getMac().equals(mac) 
				&& device.getSensorId().equals(sensorId)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int constant = 37;
		int total = 17;
		
		total = constant * total + ((getIp() == null) ? 0 : getIp().hashCode());
		total = constant * total + ((getMac() == null) ? 0 : getMac().hashCode());
		total = constant * total + ((getSensorId() == null) ? 0 : getSensorId().hashCode());
		
		return total;
	}
	
	@Override
	public String toString() {
		StringBuffer value = new StringBuffer(this.getClass().toString());
		
		value.append(" sensorId: " + getSensorId());
		value.append(" ip: " + getIp());
		value.append(" mac: " + getMac());
		
		return value.toString();
	}
}
