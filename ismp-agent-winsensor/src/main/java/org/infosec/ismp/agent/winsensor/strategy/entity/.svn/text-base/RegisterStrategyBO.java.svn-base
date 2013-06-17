package org.infosec.ismp.agent.winsensor.strategy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 4:58:21 PM
 * 
 */
@Entity
@Table(name="register_strategy")
public class RegisterStrategyBO extends BaseStrategy {

	private static final long serialVersionUID = 1891296517892078321L;

	/*
	 * Sensor client register URL.
	 */
	@Column(name="send_url", length=255)
	private String url;
	
	/*
	 * Sensor client register interval. Unit: second.
	 */
	@Column(name="send_interval")
	private int interval;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof RegisterStrategyBO)) {
			return false;
		}
		
		RegisterStrategyBO registerStrategy = (RegisterStrategyBO) obj;
		if (registerStrategy.getIp().equals(getIp()) && registerStrategy.getSensorId().equals(getSensorId()) 
				&& (registerStrategy.getIssued() == getIssued()) && (registerStrategy.getCovered() == getCovered())) {
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
