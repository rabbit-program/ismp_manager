package org.infosec.ismp.manager.event;

import java.io.Serializable;

/**
 * 时间收集对象
 * @author jiel
 *
 */
public class EventModel implements Serializable {
	private String eventId;//事件的id
	private String srcMod;//事件产生模块信息
	private String eventTime;//事件产生时间
	private String eventType;//事件的类型(
	private String severity;//事件的严重程度
	private String targetAddr;//事件的目标地址
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getSrcMod() {
		return srcMod;
	}
	public void setSrcMod(String srcMod) {
		this.srcMod = srcMod;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getTargetAddr() {
		return targetAddr;
	}
	public void setTargetAddr(String targetAddr) {
		this.targetAddr = targetAddr;
	}

}
