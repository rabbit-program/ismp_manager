package edu.sjtu.infosec.ismp.manager.AM.model;

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
 * asset_to_hardware的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_to_hardware")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetToHardwareBO{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "asset_id")
	private Integer assetId;

	@Column(name = "hardware_id")
	private Integer hardwareId;

	@Column(name = "description")
	private String description;
	
	@Column(name = "single_code",unique=true)
	private String singleCode; 
	
	public AssetToHardwareBO() {
		super();
	}
	

	public AssetToHardwareBO(Integer assetId, String description,
			Integer hardwareId, Integer id, String singleCode) {
		super();
		this.assetId = assetId;
		this.description = description;
		this.hardwareId = hardwareId;
		this.id = id;
		this.singleCode = singleCode;
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


	public Integer getHardwareId() {
		return hardwareId;
	}


	public void setHardwareId(Integer hardwareId) {
		this.hardwareId = hardwareId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSingleCode() {
		return singleCode;
	}


	public void setSingleCode(String singleCode) {
		this.singleCode = singleCode;
	}


	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("assetId",
				assetId).append("hardwareId", hardwareId).append("description",
				description).append("singleCode", singleCode).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetToHardwareBO))
			return false;
		AssetToHardwareBO castOther = (AssetToHardwareBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(assetId,
				castOther.assetId).append(hardwareId, castOther.hardwareId)
				.append(description, castOther.description).append(singleCode,
						castOther.singleCode).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(assetId).append(
				hardwareId).append(description).append(singleCode).toHashCode();
	}
 
}
