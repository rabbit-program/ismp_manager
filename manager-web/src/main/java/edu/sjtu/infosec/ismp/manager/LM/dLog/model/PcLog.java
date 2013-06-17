package edu.sjtu.infosec.ismp.manager.LM.dLog.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lm_dlog_pc")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class PcLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249317403130825007L;

	/** 编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 事件名称 :应用程序日志,安全性日志,系统日志
	 */
	@Column(name = "event_name")
	private String eventName;

	/**
	 * 事件类型:个人主机系统日志各个子类型中的单条记录的类型: 警告,信息,错误,成功审核,失败审核
	 */
	@Column(name = "event_type")
	private String eventType;

	/**
	 * 事件时间
	 */
//	@Temporal(TemporalType.TIMESTAMP)		//设备默认添加时间
	@Column(name = "event_time")
	private Timestamp eventTime;

	/**
	 * 事件来源
	 */
	@Column(name = "event_source")
	private String eventSource;

	/**
	 * 事件分类
	 */
	@Column(name = "event_category")
	private String eventCategory;

	/**
	 * 事件id
	 */
	@Column(name = "event_id")
	private Integer eventId;

	/**
	 * 事件用户名
	 */
	@Column(name = "user_name")
	private String userName;

	/**
	 * 计算机名
	 */
	@Column(name = "computer_name")
	private String computerName;

	/**
	 * 事件描述
	 */
	@Column(name = "event_description", length = 3000)
	private String eventDescription;

	/**
	 * 日志采集源的ip
	 */
	@Column(name = "source_ip")
	private String sourceIp;

	/**
	 * sensor自己产生的唯一标示符
	 */
	@Column(name = "sensor_sequence")
	private String sensorSequence;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Timestamp getEventTime() {
		return eventTime;
	}

	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventSource() {
		return eventSource;
	}

	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getSensorSequence() {
		return sensorSequence;
	}

	public void setSensorSequence(String sensorSequence) {
		this.sensorSequence = sensorSequence;
	}
	
}
