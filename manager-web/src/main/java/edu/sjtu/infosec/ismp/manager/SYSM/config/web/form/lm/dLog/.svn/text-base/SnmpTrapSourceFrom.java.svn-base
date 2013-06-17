package edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.lm.dLog;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SnmpTrapSourceFrom extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3090545422587526033L;
	
	/**
	 * 日志源 名称
	 */
	private String sourceName;
	
	/**
	 * 日志源类型：与lm_dlog_snmptrap_source_type表 ID 对应
	 */
	private Integer sourceType;
	
	/**
	 * 设备IP
	 */
	private String deviceIP;

	/**
	 * 日志源所在的域
	 */
	private String domain;

	/**
	 * 日志采集的开始开关 :true 表示采集 false:表示不采集
	 */
	private Boolean startCollectSwitch;
	
	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getDeviceIP() {
		return deviceIP;
	}

	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
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

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.sourceName = null;
		this.sourceType = null;
		this.deviceIP = null;
		this.domain = null;
		this.startCollectSwitch = null;
	}

}
