package edu.sjtu.infosec.ismp.manager.EM.web.form;

import org.apache.struts.validator.ValidatorForm;

/**
 * 
 * @version 1.0 2009-06-06
 * @author yli
 */
public class EventSelectConditionForm extends ValidatorForm{

	private String begin;

	private String end;
	
	private String beginDate;
	
	private String endDate;
	/**
	 * 事件源IP地址
	 */
	private String src_ip;

	/**
	 * 事件源端口
	 */
	private Integer src_port;

	/**
	 * 事件目的端口
	 */
	private Integer dest_port;

	/**
	 * 事件的威胁等级
	 */
	private Integer thre_rank;

	/**
	 * 安全设备类型
	 */
	private String faci_type;

	/**
	 * 事件类型
	 */
	private String event_type;

	private String IPAddress;

	private String eventTypes;
	
	private Integer bureauId;
	
	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
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

	public String getSrc_ip() {
		return src_ip;
	}

	public void setSrc_ip(String src_ip) {
		this.src_ip = src_ip;
	}

	public Integer getSrc_port() {
		return src_port;
	}

	public void setSrc_port(Integer src_port) {
		this.src_port = src_port;
	}

	public Integer getDest_port() {
		return dest_port;
	}

	public void setDest_port(Integer dest_port) {
		this.dest_port = dest_port;
	}

	public Integer getThre_rank() {
		return thre_rank;
	}

	public void setThre_rank(Integer thre_rank) {
		this.thre_rank = thre_rank;
	}

	public String getFaci_type() {
		return faci_type;
	}

	public void setFaci_type(String faci_type) {
		this.faci_type = faci_type;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getIPAddress() {
		return IPAddress;
	}

	public void setIPAddress(String address) {
		IPAddress = address;
	}

	public String getEventTypes() {
		return eventTypes;
	}

	public void setEventTypes(String eventTypes) {
		this.eventTypes = eventTypes;
	}

	public Integer getBureauId() {
		return bureauId;
	}

	public void setBureauId(Integer bureauId) {
		this.bureauId = bureauId;
	}
}
