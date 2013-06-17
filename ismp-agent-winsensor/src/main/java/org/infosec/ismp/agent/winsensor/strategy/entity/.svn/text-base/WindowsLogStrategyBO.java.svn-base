package org.infosec.ismp.agent.winsensor.strategy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:14:59 PM
 * 
 */
@Entity
@Table(name="windows_log_strategy")
public class WindowsLogStrategyBO extends BaseStrategy {

	private static final long serialVersionUID = 9202998969292066082L;

	@Column(name="send_url", length=255)
	private String url;		//上报地址
	
	@Column(name="send_interval")
	private int interval;		//上报周期
	
	@Column(name="send_system")
	private Boolean system;			//是否采集系统日志
	
	@Column(name="send_application")
	private Boolean application;			//是否采集应用程序日志
	
	@Column(name="send_security")
	private Boolean security;			//是否采集安全日志
	
	@Column(name="information")
	private Boolean information;			//是否采集消息
	
	@Column(name="send_warning")
	private Boolean warning;			//是否采集警告
	
	@Column(name="send_error")
	private Boolean error;			//是否采集错误
	
	@Column(name="send_a_success")
	private Boolean aSuccess;			//是否采集成功审核
	
	@Column(name="send_a_failure")
	private Boolean aFailure;			//是否采集失败审核

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

	public Boolean getSystem() {
		return system;
	}

	public void setSystem(Boolean system) {
		this.system = system;
	}

	public Boolean getApplication() {
		return application;
	}

	public void setApplication(Boolean application) {
		this.application = application;
	}

	public Boolean getSecurity() {
		return security;
	}

	public void setSecurity(Boolean security) {
		this.security = security;
	}

	public Boolean getInformation() {
		return information;
	}

	public void setInformation(Boolean information) {
		this.information = information;
	}

	public Boolean getWarning() {
		return warning;
	}

	public void setWarning(Boolean warning) {
		this.warning = warning;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public Boolean getASuccess() {
		return aSuccess;
	}

	public void setASuccess(Boolean success) {
		aSuccess = success;
	}

	public Boolean getAFailure() {
		return aFailure;
	}

	public void setAFailure(Boolean failure) {
		aFailure = failure;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof WindowsLogStrategyBO)) {
			return false;
		}
		
		WindowsLogStrategyBO windowsLogStrategy = (WindowsLogStrategyBO) obj;
		if (windowsLogStrategy.getIp().equals(getIp()) && windowsLogStrategy.getSensorId().equals(getSensorId()) 
				&& (windowsLogStrategy.getIssued() == getIssued()) && (windowsLogStrategy.getCovered() == getCovered())) {
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
