package org.infosec.ismp.agent.winsensor.strategy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:09:38 PM
 * 
 */
@Entity
@Table(name="software_update_strategy")
public class SoftwareUpdateStrategyBO extends BaseStrategy {

	private static final long serialVersionUID = 4874328692253842882L;

	@Column(name="d_ip", length=50)
	private String dIp;		//下载服务器IP
	
	@Column(name="d_port")
	private int dPort;		//端口号
	
	@Column(name="d_interval")
	private int DInterval;		//下载周期
	
	@Column(name="r_ip", length=50)
	private String rIp;		//上报服务器IP
	
	@Column(name="r_port")
	private int rPort;		//端口号
	
	@Column(name="r_interval")
	private int rInterval;		//上报周期

	public String getDIp() {
		return dIp;
	}

	public void setDIp(String ip) {
		dIp = ip;
	}

	public int getDPort() {
		return dPort;
	}

	public void setDPort(int port) {
		dPort = port;
	}

	public int getDInterval() {
		return DInterval;
	}

	public void setDInterval(int interval) {
		DInterval = interval;
	}

	public String getRIp() {
		return rIp;
	}

	public void setRIp(String ip) {
		rIp = ip;
	}

	public int getRPort() {
		return rPort;
	}

	public void setRPort(int port) {
		rPort = port;
	}

	public int getRInterval() {
		return rInterval;
	}

	public void setRInterval(int interval) {
		rInterval = interval;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof SoftwareUpdateStrategyBO)) {
			return false;
		}
		
		SoftwareUpdateStrategyBO softwareUpdateStrategy = (SoftwareUpdateStrategyBO) obj;
		if (softwareUpdateStrategy.getIp().equals(getIp()) && softwareUpdateStrategy.getSensorId().equals(getSensorId()) 
				&& (softwareUpdateStrategy.getIssued() == getIssued()) && (softwareUpdateStrategy.getCovered() == getCovered())) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int constant = 37;
		int total = 17;
		
		total = constant * total + ((getIp() == null) ? 0 : getIp().hashCode());
		total = constant * total + ((getSensorId() == null) ? 0 : getSensorId().hashCode());
		total = constant * total + getIssued();
		total = constant * total + getCovered();
		
		return total;
	}
	
	@Override
	public String toString() {
		StringBuffer value = new StringBuffer(this.getClass().toString());
		
		value.append(" sensorId: " + getSensorId());
		value.append(" ipAddress: " + getIp());
		value.append(" Issued: " + getIssued());
		value.append("covered: " + getCovered());
		
		return value.toString();
	}
}
