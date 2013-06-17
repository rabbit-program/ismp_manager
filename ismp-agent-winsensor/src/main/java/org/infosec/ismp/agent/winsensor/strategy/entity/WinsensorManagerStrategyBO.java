package org.infosec.ismp.agent.winsensor.strategy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:17:33 PM
 * 
 */
@Entity
@Table(name="winsensor_manager_strategy")
public class WinsensorManagerStrategyBO extends BaseStrategy {

	private static final long serialVersionUID = -3094835854773151768L;

	@Column(name="auto_update_url", length=255)
	private String autoUpdateUrl;		//自动更新地址
	
	@Column(name="auto_update_interval")
	private int interval;		//自动更新周期
	
	@Column(name="local_interval")
	private int localInterval;		//本地自动更新周期
	
	@Column(name="entry_point", length=255)
	private String entryPoint;		//更新后的入口点
	
	@Column(name="manager_port")
	private int managerPort;		//管理端口
	
	@Column(name="open_time", length=80)
	private String openTime;		//端口开放时间
	
	@Column(name="is_able_to_stop_sensor")
	private Boolean isAbleToStopSensor;		//是否允许用户关闭Winsensor
	
	@Column(name="is_able_to_stop_service")
	private Boolean isAbleToStopService;		//是否允许用户关闭WinsensorService
	
	@Column(name="is_show_the_icon")
	private Boolean isShowTheIcon;		//是否显示Winsensor小图标

	public String getAutoUpdateUrl() {
		return autoUpdateUrl;
	}

	public void setAutoUpdateUrl(String autoUpdateUrl) {
		this.autoUpdateUrl = autoUpdateUrl;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getLocalInterval() {
		return localInterval;
	}

	public void setLocalInterval(int localInterval) {
		this.localInterval = localInterval;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public int getManagerPort() {
		return managerPort;
	}

	public void setManagerPort(int managerPort) {
		this.managerPort = managerPort;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public Boolean getIsAbleToStopSensor() {
		return isAbleToStopSensor;
	}

	public void setIsAbleToStopSensor(Boolean isAbleToStopSensor) {
		this.isAbleToStopSensor = isAbleToStopSensor;
	}

	public Boolean getIsAbleToStopService() {
		return isAbleToStopService;
	}

	public void setIsAbleToStopService(Boolean isAbleToStopService) {
		this.isAbleToStopService = isAbleToStopService;
	}

	public Boolean getIsShowTheIcon() {
		return isShowTheIcon;
	}

	public void setIsShowTheIcon(Boolean isShowTheIcon) {
		this.isShowTheIcon = isShowTheIcon;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof WinsensorManagerStrategyBO)) {
			return false;
		}
		
		WinsensorManagerStrategyBO winsensorManagerStrategy = (WinsensorManagerStrategyBO) obj;
		if (winsensorManagerStrategy.getIp().equals(getIp()) && winsensorManagerStrategy.getSensorId().equals(getSensorId()) 
				&& (winsensorManagerStrategy.getIssued() == getIssued()) && (winsensorManagerStrategy.getCovered() == getCovered())) {
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
