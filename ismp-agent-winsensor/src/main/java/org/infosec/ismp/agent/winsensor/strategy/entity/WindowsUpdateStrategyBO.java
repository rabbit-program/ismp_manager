package org.infosec.ismp.agent.winsensor.strategy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 7:26:55 PM
 * 
 */
@Entity
@Table(name="windows_update_strategy")
public class WindowsUpdateStrategyBO extends BaseStrategy {

	private static final long serialVersionUID = -4098474151372163117L;

	/*
	 * Config file URL
	 */
	@Column(name="send_url", length=255)
	private String url;
	
	/*
	 * Update strategy interval.
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
		
		if (!(obj instanceof WindowsUpdateStrategyBO)) {
			return false;
		}
		
		WindowsUpdateStrategyBO windowsUpdateStrategy = (WindowsUpdateStrategyBO) obj;
		if (windowsUpdateStrategy.getIp().equals(getIp()) && windowsUpdateStrategy.getSensorId().equals(getSensorId()) 
				&& (windowsUpdateStrategy.getIssued() == getIssued()) && (windowsUpdateStrategy.getCovered() == getCovered())) {
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
