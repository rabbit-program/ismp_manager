package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 负责存储、读取Sensor基本信息
 * @author 肖高峰
 */

@Entity
@Table(name = "tm_topo_manager_sensor")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SensorEntity implements  Serializable{

	private static final long serialVersionUID = -1858617269359493691L;
	
	/**
	 * 主键ID
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    /**
     * MAC地址
     */
	private String mac;
	
	/**
	 * sensor_id 标识
	 */
    @Column(name="sensor_id")
	private String sensorId;
	
    /**
     * node_id 标识
     */
    @OneToOne
	@JoinColumn(name = "node_id")
	private NodeEntity node;
	
    /**
     * 超时
     */
	private Long timeout;
	
	private Integer retries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	

	public NodeEntity getNode() {
		return node;
	}

	public void setNode(NodeEntity node) {
		this.node = node;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Integer getRetries() {
		return retries;
	}

	public void setRetries(Integer retries) {
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
		
		if (!(obj instanceof SensorEntity)) {
			return false;
		}
		
		SensorEntity device = (SensorEntity) obj;
		if (device.getMac().equals(mac) 
				&& device.getSensorId().equals(sensorId) && (device.getNode() == node)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int constant = 37;
		int total = 17;
		
		total = constant * total + ((getMac() == null) ? 0 : getMac().hashCode());
		total = constant * total + ((getSensorId() == null) ? 0 : getSensorId().hashCode());
		total = constant * total +  getNode().hashCode();
		
		return total;
	}
	
	@Override
	public String toString() {
		StringBuffer value = new StringBuffer(this.getClass().toString());
		value.append(" sensorId: " + getSensorId());
		value.append(" mac: " + getMac());
		value.append("nodeId: " + getNode());
		
		return value.toString();
	}

}
