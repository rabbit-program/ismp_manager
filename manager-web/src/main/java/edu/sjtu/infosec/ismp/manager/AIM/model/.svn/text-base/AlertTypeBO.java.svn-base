package edu.sjtu.infosec.ismp.manager.AIM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="aim_type")
@org.hibernate.annotations.Entity(dynamicUpdate=true)
public class AlertTypeBO implements Serializable {
      
	@Id//主键ID 唯一标示数据
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;	
	//类别
	@Column(name="category")
	private String category;	
	//类型名称
	@Column(name="alert_type_name")
	private String typeName;
	
	//类型标示（1代表告警类型2代表子类型）
	@Column(name="alert_marker")
	private Integer typeMarker;
	
	//子类型所属的父类
	@Column(name="parentId")
	private Integer parentId;

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("category",
				category).append("typeName", typeName).append("typeMarker",
				typeMarker).append("parentId", parentId).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AlertTypeBO))
			return false;
		AlertTypeBO castOther = (AlertTypeBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(category,
				castOther.category).append(typeName, castOther.typeName)
				.append(typeMarker, castOther.typeMarker).append(parentId,
						castOther.parentId).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(category).append(
				typeName).append(typeMarker).append(parentId).toHashCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeMarker() {
		return typeMarker;
	}

	public void setTypeMarker(Integer typeMarker) {
		this.typeMarker = typeMarker;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	
	
	
}
