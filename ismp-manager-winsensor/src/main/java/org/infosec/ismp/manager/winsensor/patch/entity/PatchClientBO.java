package org.infosec.ismp.manager.winsensor.patch.entity;

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

/**
 * @author Rocky
 * @version create time: Dec 29, 2010 4:19:30 PM
 *
 */
@Entity
@Table(name="vpm_pm_sensor_clients")
public class PatchClientBO implements Serializable {

	private static final long serialVersionUID = -5115830577890508267L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="sensor_id")
	private String sensorId;
	
	@Column(name="sensor_ip")
	private String sensorIp;
	
	@Column(name="sensor_mac")
	private String sensorMac;
	
	@Column(name="domain_id")
	private Integer domainId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

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

	public String getSensorMac() {
		return sensorMac;
	}

	public void setSensorMac(String sensorMac) {
		this.sensorMac = sensorMac;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
