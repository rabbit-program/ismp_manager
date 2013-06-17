package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.sjtu.infosec.ismp.security.Domain;

/**
 * asset_device的BO类
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "am_asset_device")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetDeviceBO implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属域
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;

	@Column(name = "sn")
	private String sn;

	@Column(name = "name")
	private String name;

	@Column(name = "asset_type")
	private Integer assetType;

	@Column(name = "ip")
	private String ip;

	@Column(name = "agent_ip")
	private String agentIp;

	@Column(name = "check_available")
	private Boolean checkAvailable = true;

	@Column(name = "mac")
	private String mac;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "model")
	private String model;

	@Column(name = "descr", length = 5000)
	private String description;

	@Column(name = "user")
	private String user;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "unit")
	private String unit;

	@Column(name = "dep")
	private String department;

	@Column(name = "community_name", length = 2000)
	private String communityName;

	@Column(name = "status")
	private Integer status;

	@Column(name = "stock_time")
	private Timestamp stockTime;

	@Column(name = "validity_period")
	private Integer validityPeriod;

	@Column(name = "registration_time")
	private Timestamp registrationTime;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "location_id")
	private Integer locationId;

	@Column(name = "single_code", unique = true)
	private String singleCode;

	@Column(name = "device_type")
	private String deviceType;

	@Column(name = "monitor_status")
	private Integer monitorStatus = new Integer(0);

	@Column(name = "node_id")
	private String nodeId;
	
	public AssetDeviceBO() {

	}

	public AssetDeviceBO(String agentIp, Integer assetType,
			Boolean checkAvailable, String communityName, String department,
			String description, String ip, Integer locationId, String mac,
			String manufacturer, String model, String name, Integer priority,
			Timestamp registrationTime, String singleCode, String sn,
			Integer status, Timestamp stockTime, String telephone, String unit,
			String user, Integer validityPeriod) {
		this.agentIp = agentIp;
		this.assetType = assetType;
		this.checkAvailable = checkAvailable;
		this.communityName = communityName;
		this.department = department;
		this.description = description;
		this.ip = ip;
		this.locationId = locationId;
		this.mac = mac;
		this.manufacturer = manufacturer;
		this.model = model;
		this.name = name;
		this.priority = priority;
		this.registrationTime = registrationTime;
		this.singleCode = singleCode;
		this.sn = sn;
		this.status = status;
		this.stockTime = stockTime;
		this.telephone = telephone;
		this.unit = unit;
		this.user = user;
		this.validityPeriod = validityPeriod;
	}

	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAssetType() {
		return assetType;
	}

	public void setAssetType(Integer assetType) {
		this.assetType = assetType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAgentIp() {
		return agentIp;
	}

	public void setAgentIp(String agentIp) {
		this.agentIp = agentIp;
	}

	public Boolean getCheckAvailable() {
		return checkAvailable;
	}

	public void setCheckAvailable(Boolean checkAvailable) {
		this.checkAvailable = checkAvailable;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getStockTime() {
		return stockTime;
	}

	public void setStockTime(Timestamp stockTime) {
		this.stockTime = stockTime;
	}

	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Timestamp getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getSingleCode() {
		return singleCode;
	}

	public void setSingleCode(String singleCode) {
		this.singleCode = singleCode;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getMonitorStatus() {
		return monitorStatus;
	}

	public void setMonitorStatus(Integer monitorStatus) {
		this.monitorStatus = monitorStatus;
	}
	
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	
}
