package edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.lm.dLog;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class PcSourceFrom extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3090545422587526033L;
	
	/**
	 * 计算机 名称
	 */
	private String computerName;
	/**
	 * 设备IP
	 */
	private String sensorIp;

	/**
	 * 日志源所在的域
	 */
	private String domain;

	/**
	 * 日志采集的开始开关 :true 表示采集 false:表示不采集
	 */
	private Boolean startCollectSwitch;
	
	private long intervalCollectTime;

	public String getComputerName() {
		return computerName;
	}



	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}



	public String getSensorIp() {
		return sensorIp;
	}



	public void setSensorIp(String sensorIp) {
		this.sensorIp = sensorIp;
	}



	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}



	public Boolean getStartCollectSwitch() {
		return startCollectSwitch;
	}



	public void setStartCollectSwitch(Boolean startCollectSwitch) {
		this.startCollectSwitch = startCollectSwitch;
	}



	public long getIntervalCollectTime() {
		return intervalCollectTime;
	}



	public void setIntervalCollectTime(long intervalCollectTime) {
		this.intervalCollectTime = intervalCollectTime;
	}



	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.computerName = null;
		this.intervalCollectTime = 0;
		this.sensorIp = null;
		this.domain = null;
		this.startCollectSwitch = null;
	}

}
