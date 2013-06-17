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
 * asset_to_position的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_to_position")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetToPositionBO  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "asset_id")
	private Integer assetId;

	@Column(name = "position_id")
	private Integer positionId;
	
	@Column(name = "single_code", unique = true)
	private String singleCode;

	@Column(name = "description")
	private String description;

	public AssetToPositionBO() {
		super();
	}
	
	

	public AssetToPositionBO(Integer assetId, String description,
			Integer positionId, String singleCode) {
		super();
		this.assetId = assetId;
		this.description = description;
		this.positionId = positionId;
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



	public Integer getPositionId() {
		return positionId;
	}



	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}



	public String getSingleCode() {
		return singleCode;
	}



	public void setSingleCode(String singleCode) {
		this.singleCode = singleCode;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("assetId",
				assetId).append("positionId", positionId).append("singleCode",
				singleCode).append("description", description).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetToPositionBO))
			return false;
		AssetToPositionBO castOther = (AssetToPositionBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(assetId,
				castOther.assetId).append(positionId, castOther.positionId)
				.append(singleCode, castOther.singleCode).append(description,
						castOther.description).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(assetId).append(
				positionId).append(singleCode).append(description).toHashCode();
	}

}
