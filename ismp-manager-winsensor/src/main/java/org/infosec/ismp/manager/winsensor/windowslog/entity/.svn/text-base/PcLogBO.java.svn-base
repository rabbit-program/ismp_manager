package org.infosec.ismp.manager.winsensor.windowslog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.infosec.ismp.agent.comm.winsensor.model.windowslog.WindowsLog;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 10:57:57 AM
 * PC日志，通过sensor客户端采集上来.
 * 与Manager-Web共用一张表，后端负责数据的录入，前端负责展示。
 */
@Entity
@Table(name="lm_dlog_pc")
public class PcLogBO implements Serializable {

	private static final long serialVersionUID = -4038591043561566450L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="sensor_sequence")
	private String sensorId;		//Sensor 客户端唯一标识
	
	@Column(name="source_ip")
	private String sensorIp;		//Sensor客户端Ip
	
	@Column(name="event_name")
	private String logCatigory;		//日志种类：系统日志、程序日志、安全日志
	
	@Column(name="event_type")
	private String type;			//类型
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="event_time")
	private Date date;			//日期
	
	@Column(name="event_source")
	private String source;			//来源
	
	@Column(name="event_category")
	private String catigories;		//分类
	
	@Column(name="event_id")
	private Integer eventId;		//事件ID
	
	@Column(name="user_name")
	private String users;		//用户
	
	@Column(name="computer_name")
	private String computer;		//计算机
	
	@Column(name = "event_description", length = 3000)
	private String message;		//内容

	public static PcLogBO convert(WindowsLog windowsLog) {
		PcLogBO pcLog = new PcLogBO();
		pcLog.setSensorId(windowsLog.getSensorId());
		pcLog.setSensorIp(windowsLog.getSensorIp());
		pcLog.setLogCatigory(windowsLog.getLogCatigory());
		pcLog.setType(windowsLog.getType());
		pcLog.setDate(windowsLog.getDate());
		pcLog.setSource(windowsLog.getSource());
		pcLog.setCatigories(windowsLog.getCatigories());
		pcLog.setEventId(Integer.valueOf(windowsLog.getId()));
		pcLog.setUsers(windowsLog.getUsers());
		pcLog.setComputer(windowsLog.getComputer());
		pcLog.setMessage(windowsLog.getMessage());
		
		return pcLog;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorIp() {
		return sensorIp;
	}

	public void setSensorIp(String sensorIp) {
		this.sensorIp = sensorIp;
	}

	public String getLogCatigory() {
		return logCatigory;
	}

	public void setLogCatigory(String logCatigory) {
		this.logCatigory = logCatigory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCatigories() {
		return catigories;
	}

	public void setCatigories(String catigories) {
		this.catigories = catigories;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
