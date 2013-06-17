package org.infosec.ismp.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "snmp_node_entity")
public class SnmpDeviceNodeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String domain;
	private String nodeid;

	@Column(name = "snmp_interval")
	private Long interval;
	private String ipAddr;
	private Integer port;
	private String deviceType;
	private String brand;
	private String version;
	private String community;
	private Boolean halfWhenDown;
	
	public Integer getId() {
		return id;
	}
	public String getDomain() {
		return domain;
	}
	public String getNodeid() {
		return nodeid;
	}
	public Long getInterval() {
		return interval;
	}

	public Integer getPort() {
		return port;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVersion() {
		return version;
	}

	public Boolean getHalfWhenDown() {
		return halfWhenDown;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public String getCommunity() {
		return community;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setHalfWhenDown(Boolean halfWhenDown) {
		this.halfWhenDown = halfWhenDown;
	}
	


}
