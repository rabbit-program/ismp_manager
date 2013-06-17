package edu.sjtu.infosec.ismp.manager.AM.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * asset_hardware的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_hardware")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetHardwareBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "hardware_type")
	private String hardwareType;

	@Column(name = "name")
	private String name;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "version")
	private String version;

	@Column(name = "capacity")
	private String capacity;

	@Column(name = "description", length=5000)
	private String description;

	@Column(name = "status")
	private Integer status;

	@Column(name = "stock_time")
	private Timestamp stockTime;

	@Column(name = "validity_period")
	private Integer validityPeriod;

	@Column(name = "registration_time")
	private Timestamp registrationTime;
	
	@Column(name = "single_code",unique=true)
	private String singleCode;
	
	@Column(name = "location_id")
	private Integer locationId;


	public AssetHardwareBO() {
		super();
	}

	 

	public Integer getLocationId() {
		return locationId;
	}



	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}



	public AssetHardwareBO(String capacity, String description,
			String hardwareType, String manufacturer, String name,
			Timestamp registrationTime, String singleCode, Integer status,
			Timestamp stockTime, Integer validityPeriod, String version) {
		super();
		this.capacity = capacity;
		this.description = description;
		this.hardwareType = hardwareType;
		this.manufacturer = manufacturer;
		this.name = name;
		this.registrationTime = registrationTime;
		this.singleCode = singleCode;
		this.status = status;
		this.stockTime = stockTime;
		this.validityPeriod = validityPeriod;
		this.version = version;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getHardwareType() {
		return hardwareType;
	}



	public void setHardwareType(String hardwareType) {
		this.hardwareType = hardwareType;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getManufacturer() {
		return manufacturer;
	}



	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public String getCapacity() {
		return capacity;
	}



	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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



	public String getSingleCode() {
		return singleCode;
	}



	public void setSingleCode(String singleCode) {
		this.singleCode = singleCode;
	}



	public String toString() {
		return new ToStringBuilder(this).append("id", id).append(
				"hardwareType", hardwareType).append("name", name).append(
				"manufacturer", manufacturer).append("version", version)
				.append("capacity", capacity)
				.append("description", description).append("status", status)
				.append("stockTime", stockTime).append("validityPeriod",
						validityPeriod).append("registrationTime",
						registrationTime).append("singleCode", singleCode)
				.toString();
	}



	public boolean equals(final Object other) {
		if (!(other instanceof AssetHardwareBO))
			return false;
		AssetHardwareBO castOther = (AssetHardwareBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(
				hardwareType, castOther.hardwareType).append(name,
				castOther.name).append(manufacturer, castOther.manufacturer)
				.append(version, castOther.version).append(capacity,
						castOther.capacity).append(description,
						castOther.description).append(status, castOther.status)
				.append(stockTime, castOther.stockTime).append(validityPeriod,
						castOther.validityPeriod).append(registrationTime,
						castOther.registrationTime).append(singleCode,
						castOther.singleCode).isEquals();
	}



	public int hashCode() {
		return new HashCodeBuilder().append(id).append(hardwareType).append(
				name).append(manufacturer).append(version).append(capacity)
				.append(description).append(status).append(stockTime).append(
						validityPeriod).append(registrationTime).append(
						singleCode).toHashCode();
	}
 

}
