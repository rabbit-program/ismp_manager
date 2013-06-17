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
 * asset_monthly_availability的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_monthly_availability")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetMonthlyAvailabilityBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "asset_id")
	private Integer assetId;

	@Column(name = "availability_type")
	private Integer availabilityType;

	@Column(name = "used_percent")
	private Integer usedPercent;

	@Column(name = "time")
	private Timestamp time;

	@Column(name = "single_code", unique = true)
	private String singleCode;

	public AssetMonthlyAvailabilityBO() {
		super();
	}

	public AssetMonthlyAvailabilityBO(Integer assetId,
			Integer availabilityType, String singleCode, Timestamp time,
			Integer usedPercent) {
		super();
		this.assetId = assetId;
		this.availabilityType = availabilityType;
		this.singleCode = singleCode;
		this.time = time;
		this.usedPercent = usedPercent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Integer getAvailabilityType() {
		return availabilityType;
	}

	public void setAvailabilityType(Integer availabilityType) {
		this.availabilityType = availabilityType;
	}

	public Integer getUsedPercent() {
		return usedPercent;
	}

	public void setUsedPercent(Integer usedPercent) {
		this.usedPercent = usedPercent;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getSingleCode() {
		return singleCode;
	}

	public void setSingleCode(String singleCode) {
		this.singleCode = singleCode;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("assetId",
				assetId).append("availabilityType", availabilityType).append(
				"usedPercent", usedPercent).append("time", time).append(
				"singleCode", singleCode).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetMonthlyAvailabilityBO))
			return false;
		AssetMonthlyAvailabilityBO castOther = (AssetMonthlyAvailabilityBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(assetId,
				castOther.assetId).append(availabilityType,
				castOther.availabilityType).append(usedPercent,
				castOther.usedPercent).append(time, castOther.time).append(
				singleCode, castOther.singleCode).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(assetId).append(
				availabilityType).append(usedPercent).append(time).append(
				singleCode).toHashCode();
	}

}
