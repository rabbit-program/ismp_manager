package org.infosec.ismp.model.poller;

import java.io.Serializable;

/**
 * 包装测试设备和服务是否联通信息的封装类，为了通过jms传递信息。
 * 
 * @author lianglin
 * 
 */
public class PollStatusWrapper implements Serializable {
	/**
	 * 服务或者设备的id号（唯一确定设备或者服务的标识）
	 */
	private int id;//
	/**
	 * 服务或者设备的名称
	 */
	private String label;
	/**
	 * 在检测服务时，需要指定服务的类型
	 */
	private String type;
	
	/**
	 * 设备地址或者服务所在设备地址
	 */
	private String address;
	/**
	 * 相应时间,设备或者服务不可达时时间为NULL
	 */
	private Double responseTime;
	/**
	 * 标识设备是否可达,0 代表未知，1代表可达，2代表不可达
	 */
	
	private int status;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Double responseTime) {
		this.responseTime = responseTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


	
	
	
}
