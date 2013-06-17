package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

/**
 * asset_device的BO类
 * @author xiaogaofeng
 * @date 2010-08-06
 * @version 1.0
 */
public class AssetDevice implements Serializable {
	
	private Integer id;

	private String sn;

	private String name;

	private Integer assetType;

	private String ip;

	private String agentIp;

	private Boolean checkAvailable = true;

	private String mac;

	private String manufacturer;

	private String model;

	private String description;

	private String user;

	private String telephone;

	private String unit;

	private String department;

	private String communityName;

	private Integer status;

	private Timestamp stockTime;

	private Integer validityPeriod;

	private Timestamp registrationTime;

	private Integer priority;

	private Integer locationId;

	private String singleCode;

	private String deviceType;

	private Integer monitorStatus = new Integer(0);

	private String nodeId;
	
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
}
