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
 * asset_position的BO类
 * 
 * @author zjiajie
 * 
 */
@Entity
@Table(name = "am_position")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetPositionBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "parent_id")
	private Integer parentId;

	@Column(name = "description", length=5000)
	private String description;
	
	@Column(name = "position_id")
	private Integer positionId;

	@Column(name = "single_code", unique = true)
	private String singleCode;

	public AssetPositionBO() {
		super();
	} 
 

	public AssetPositionBO(String description, Integer parentId,
			Integer positionId, String singleCode) {
		super();
		this.description = description;
		this.parentId = parentId;
		this.positionId = positionId;
		this.singleCode = singleCode;
	}
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getParentId() {
		return parentId;
	}


	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public boolean equals(final Object other) {
		if (!(other instanceof AssetPositionBO))
			return false;
		AssetPositionBO castOther = (AssetPositionBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(parentId,
				castOther.parentId).append(description, castOther.description)
				.append(positionId, castOther.positionId).append(singleCode,
						castOther.singleCode).isEquals();
	}


	public int hashCode() {
		return new HashCodeBuilder().append(id).append(parentId).append(
				description).append(positionId).append(singleCode).toHashCode();
	}


	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("parentId",
				parentId).append("description", description).append(
				"positionId", positionId).append("singleCode", singleCode)
				.toString();
	}
 
	 



	 
 

}
