package org.infosec.ismp.agent.comm.winsensor.model.windowslog;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rocky
 * @version create time：Oct 29, 2010 2:35:10 PM
 * 
 */
public class WindowsLog implements Serializable {

	private static final long serialVersionUID = -8547413918820311613L;

	private String sensorId;		//Sensor 客户端唯一标识
	
	private String sensorIp;		//Sensor客户端Ip
	
	private String logCatigory;		//日志种类：系统日志、程序日志、安全日志
	
	private String type;			//类型
	
	private Date date;			//日期
	
	private String source;			//来源
	
	private String catigories;		//分类
	
	private String id;		//事件ID
	
	private String users;		//用户
	
	private String computer;		//计算机
	
	private String message;		//内容

	public String getWindowsLogInfo() {
		StringBuffer buffer = new StringBuffer();
		
		//Base info
		buffer.append("WindowsLog info, device ip: " + getSensorIp() + " sensorId: " + getSensorId());
		buffer.append(" logCatigory: " + getLogCatigory());
		buffer.append(" type: " + getType());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		buffer.append(" date: " + format.format(getDate()));
		buffer.append(" source: " + getSource());
		buffer.append(" catigories: " + getCatigories());
		buffer.append(" id: " + getId());
		buffer.append(" users: " + getUsers());
		buffer.append(" computer: " + getComputer());
		buffer.append(" message: " + getMessage());
		
		return buffer.toString();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
