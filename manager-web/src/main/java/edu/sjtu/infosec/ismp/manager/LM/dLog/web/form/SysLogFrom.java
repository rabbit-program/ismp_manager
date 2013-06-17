package edu.sjtu.infosec.ismp.manager.LM.dLog.web.form;

import org.apache.struts.action.ActionForm;

public class SysLogFrom extends ActionForm {

	/**
	 * sysLog映射，简单查询模型
	 */
	private static final long serialVersionUID = 543163896382718929L;
	/**
	 * 产生日志的程序模块
	 */
	private String facility;
	/**
	 * 严重性
	 */
	private String severity;
	/**
	 * 主机名或者IP
	 */
	private String hostname;
	/**
	 * 起始时间
	 */
	private String beginDate;
	/**
	 * 截止时间
	 */
	private String endDate;
	/**
	 *消息主体部分 
	 */
	private String message;
	/**
	 * 关联的部门的名字
	 */
	private String domain;
	/**
	 * IP
	 */
	private String deviceIP;
	/**
	 * 是否启用
	 */
	private Boolean startCollectSwitch;
	
	public Boolean getStartCollectSwitch() {
		return startCollectSwitch;
	}
	public void setStartCollectSwitch(Boolean startCollectSwitch) {
		this.startCollectSwitch = startCollectSwitch;
	}
	public String getDeviceIP() {
		return deviceIP;
	}
	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
