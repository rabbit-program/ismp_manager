package org.infosec.ismp.agent.winsensor.entity;

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

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;

/**
 * @author Rocky
 * @version create time：Sep 30, 2010 9:42:42 AM
 * 
 * 监控之Winsensor设备
 */
@Entity
@Table(name="winsensor_device")
public class WinsensorDeviceBO implements Serializable {

	private static final long serialVersionUID = 2249118620260225460L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;		//主键 

	@Column(name="ip_address", length=50)
	private String ipAddress;		//Ip地址
	
	@Column(name="mac_address", length=50)
	private String macAddress;		//mac地址
	
	@Column(name="sensor_id", length=100)
	private String sensorId;		//winsensor客户端唯一标识
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;		//创建时间
	
	@Column(name="flag")
	private int flag;		//监控启用标识,0：不监控；1：监控；2：暂停监控；
	
	@Column(name="node_id", length=100)
	private String nodeId;	//各种监控类型设备唯一标识，包括SNMP等设备
	
	@Column(name="domain_id", length=100)
	private String domainId;		//设备的所在域Id
	
	@Column(name="time_out")
	private long timeout;		//设置客户端超时时间，超过超时时间*次数则认为设备不在线；
	
	@Column(name="retries")
	private int retries;		//超时次数

	public CommWinsensorDevice getCommDevice() {
		CommWinsensorDevice commDevice = new CommWinsensorDevice();
		
		commDevice.setIp(getIpAddress());
		commDevice.setMac(getMacAddress());
		commDevice.setNodeId(getNodeId());
		commDevice.setRetries(getRetries());
		commDevice.setSensorId(getSensorId());
		commDevice.setTimeout(getTimeout());
		
		return commDevice;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public int getRetries() {
		return retries;
	}

	public void setRetries(int retries) {
		this.retries = retries;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof WinsensorDeviceBO)) {
			return false;
		}
		
		WinsensorDeviceBO device = (WinsensorDeviceBO) obj;
		if (device.getSensorId().equals(getSensorId()) 
				&& device.getIpAddress().equals(getIpAddress()) 
				&& (device.getNodeId() == getNodeId())) {
			return true;
		}

		return false;
	}
	
	@Override
	public int hashCode() {
		final int constant = 37;
		int total = 17;
		
		total = constant * total + ((getSensorId() == null) ? 0 : getSensorId().hashCode() ); 
		total = constant * total + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
		total = constant * total + ((getNodeId() == null) ? 0 : getNodeId().hashCode());
		
		return total;
	}
	
	@Override
	public String toString() {
		StringBuffer value = new StringBuffer(this.getClass().toString());
		
		value.append(" sensorId: " + getSensorId());
		value.append(" ipAddress: " + getIpAddress());
		value.append(" nodeId: " + getNodeId());
		
		return value.toString();
	}
}
