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
 * asset_to_software的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_to_software")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetToSoftwareBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "asset_id")
	private Integer assetId;

	@Column(name = "software_id")
	private Integer softwareId;

	@Column(name = "description")
	private String description;
	
	@Column(name = "single_code",unique=true)
	private String singleCode;

	public AssetToSoftwareBO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public AssetToSoftwareBO(Integer assetId, String description,
			String singleCode, Integer softwareId) {
		super();
		this.assetId = assetId;
		this.description = description;
		this.singleCode = singleCode;
		this.softwareId = softwareId;
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


	public Integer getSoftwareId() {
		return softwareId;
	}


	public void setSoftwareId(Integer softwareId) {
		this.softwareId = softwareId;
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
				assetId).append("softwareId", softwareId).append("description",
				description).append("singleCode", singleCode).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetToSoftwareBO))
			return false;
		AssetToSoftwareBO castOther = (AssetToSoftwareBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(assetId,
				castOther.assetId).append(softwareId, castOther.softwareId)
				.append(description, castOther.description).append(singleCode,
						castOther.singleCode).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(assetId).append(
				softwareId).append(description).append(singleCode).toHashCode();
	}

	
	
 
}
