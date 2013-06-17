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
 * asset_software的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_software")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetSoftwareBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "software_type")
	private String softwareType;

	@Column(name = "name")
	private String name;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "version")
	private String version;

	@Column(name = "description", length=5000)
	private String description;

	@Column(name = "user")
	private String user;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "unit")
	private String unit;

	@Column(name = "department")
	private String department;

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
	
	
	public Integer getLocationId() {
		return locationId;
	}



	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}



	public AssetSoftwareBO() {
		super();
	}



	public AssetSoftwareBO(String department, String description,
			String manufacturer, String name, Timestamp registrationTime,
			String singleCode, String softwareType, Integer status,
			Timestamp stockTime, String telephone, String unit, String user,
			Integer validityPeriod, String version) {
		super();
		this.department = department;
		this.description = description;
		this.manufacturer = manufacturer;
		this.name = name;
		this.registrationTime = registrationTime;
		this.singleCode = singleCode;
		this.softwareType = softwareType;
		this.status = status;
		this.stockTime = stockTime;
		this.telephone = telephone;
		this.unit = unit;
		this.user = user;
		this.validityPeriod = validityPeriod;
		this.version = version;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getSoftwareType() {
		return softwareType;
	}



	public void setSoftwareType(String softwareType) {
		this.softwareType = softwareType;
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
				"softwareType", softwareType).append("name", name).append(
				"manufacturer", manufacturer).append("version", version)
				.append("description", description).append("user", user)
				.append("telephone", telephone).append("unit", unit).append(
						"department", department).append("status", status)
				.append("stockTime", stockTime).append("validityPeriod",
						validityPeriod).append("registrationTime",
						registrationTime).append("singleCode", singleCode)
				.toString();
	}



	public boolean equals(final Object other) {
		if (!(other instanceof AssetSoftwareBO))
			return false;
		AssetSoftwareBO castOther = (AssetSoftwareBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(
				softwareType, castOther.softwareType).append(name,
				castOther.name).append(manufacturer, castOther.manufacturer)
				.append(version, castOther.version).append(description,
						castOther.description).append(user, castOther.user)
				.append(telephone, castOther.telephone).append(unit,
						castOther.unit)
				.append(department, castOther.department).append(status,
						castOther.status)
				.append(stockTime, castOther.stockTime).append(validityPeriod,
						castOther.validityPeriod).append(registrationTime,
						castOther.registrationTime).append(singleCode,
						castOther.singleCode).isEquals();
	}



	public int hashCode() {
		return new HashCodeBuilder().append(id).append(softwareType).append(
				name).append(manufacturer).append(version).append(description)
				.append(user).append(telephone).append(unit).append(department)
				.append(status).append(stockTime).append(validityPeriod)
				.append(registrationTime).append(singleCode).toHashCode();
	}

 
}
