package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class AssetDeviceVO implements Serializable {

	private String name;

	private Integer assetType;

	private String ip;

	private String manufacturer;

	public Timestamp getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}

	private String model;

	private String description;

	private Timestamp registrationTime;

	private Integer validityPeriod;

	private String location;

	private Integer availHardware;

	private Integer availNetwork;

	private Integer capability;
	
	private Integer used_parent;

	public Integer getUsed_parent() {
		return used_parent;
	}

	public void setUsed_parent(Integer usedParent) {
		used_parent = usedParent;
	}

	public Integer getAvailHardware() {
		return availHardware;
	}

	public void setAvailHardware(Integer availHardware) {
		this.availHardware = availHardware;
	}

	public Integer getAvailNetwork() {
		return availNetwork;
	}

	public void setAvailNetwork(Integer availNetwork) {
		this.availNetwork = availNetwork;
	}

	public Integer getCapability() {
		return capability;
	}

	public void setCapability(Integer capability) {
		this.capability = capability;
	}

	public AssetDeviceVO() {

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

 

	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
