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
 * asset_raw_availability的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_raw_availability")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetRawAvailabilityBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "asset_id")
	private Integer assetId;

	@Column(name = "availability_type")
	private Integer availabilityType;

	@Column(name = "online")
	private Boolean online;

	@Column(name = "total_quantity")
	private Long totalQuantity;

	@Column(name = "used_quantity")
	private Long usedQuantity;

	@Column(name = "used_percent")
	private Integer usedPercent;

	@Column(name = "time")
	private Timestamp time;

	public AssetRawAvailabilityBO() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param vId
	 *            the id to set
	 */
	public void setId(Integer vId) {
		id = vId;
	}

	/**
	 * @return the assetId
	 */
	public Integer getAssetId() {
		return assetId;
	}

	/**
	 * @param vAssetId
	 *            the assetId to set
	 */
	public void setAssetId(Integer vAssetId) {
		assetId = vAssetId;
	}

	/**
	 * @return the availabilityType
	 */
	public Integer getAvailabilityType() {
		return availabilityType;
	}

	/**
	 * @param vAvailabilityType
	 *            the availabilityType to set
	 */
	public void setAvailabilityType(Integer vAvailabilityType) {
		availabilityType = vAvailabilityType;
	}

	/**
	 * @return the online
	 */
	public Boolean getOnline() {
		return online;
	}

	/**
	 * @param vOnline
	 *            the online to set
	 */
	public void setOnline(Boolean vOnline) {
		online = vOnline;
	}

	/**
	 * @return the totalQuantity
	 */
	public Long getTotalQuantity() {
		return totalQuantity;
	}

	/**
	 * @param vTotalQuantity
	 *            the totalQuantity to set
	 */
	public void setTotalQuantity(Long vTotalQuantity) {
		totalQuantity = vTotalQuantity;
	}

	/**
	 * @return the usedQuantity
	 */
	public Long getUsedQuantity() {
		return usedQuantity;
	}

	/**
	 * @param vUsedQuantity
	 *            the usedQuantity to set
	 */
	public void setUsedQuantity(Long vUsedQuantity) {
		usedQuantity = vUsedQuantity;
	}

	/**
	 * @return the usedPercent
	 */
	public Integer getUsedPercent() {
		return usedPercent;
	}

	/**
	 * @param vUsedPercent
	 *            the usedPercent to set
	 */
	public void setUsedPercent(Integer vUsedPercent) {
		usedPercent = vUsedPercent;
	}

	/**
	 * @return the time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @param vTime
	 *            the time to set
	 */
	public void setTime(Timestamp vTime) {
		time = vTime;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("assetId",
				assetId).append("availabilityType", availabilityType).append(
				"online", online).append("totalQuantity", totalQuantity)
				.append("usedQuantity", usedQuantity).append("usedPercent",
						usedPercent).append("time", time).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetRawAvailabilityBO))
			return false;
		AssetRawAvailabilityBO castOther = (AssetRawAvailabilityBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(assetId,
				castOther.assetId).append(availabilityType,
				castOther.availabilityType).append(online, castOther.online)
				.append(totalQuantity, castOther.totalQuantity).append(
						usedQuantity, castOther.usedQuantity).append(
						usedPercent, castOther.usedPercent).append(time,
						castOther.time).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(assetId).append(
				availabilityType).append(online).append(totalQuantity).append(
				usedQuantity).append(usedPercent).append(time).toHashCode();
	}

}
