package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 拓扑设备类型实体
 * @author 肖高峰
 *
 */
@Entity
@Table(name = "tm_topo_node_type")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class NodeTypeEntity  implements Serializable {
	
	private static final long serialVersionUID = 5072318700327271555L;
	
	/**
	 * 节点ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private Integer typeId;
	/**
	 * 节点类型名称
	 */ 
	@Column(name="name", length=20)
	private String name;
	
	/**
     * 英文标记
     */
	@Column(name="english_name", length=20)
    private String  englishTag;
	
	/**
	 * 未激活灰色小图标路径
	 */
	@Column(name="unActive_gray_small_image", length=100)
	private String unActiveGraySmallImage;

	/**
	 * 未激活灰色大图标路径
	 */
	@Column(name="unActive_gray_big_image", length=100)
	private String unActiveGrayBigImage;
	
	/**
	 * 已激活小图标路径
	 */
	@Column(name="active_small_image", length=100)
	private String activeSmallImage;
	
	/**
	 * 已激活大图标路径
	 */
	@Column(name="active_big_image", length=100)
	private String activeBigImage;
	
	/**
	 * 已激活并未在线的小图标路径
	 */
	@Column(name="active_unLine_small_image", length=100)
	private String activeUnLineSmallImage;
	
	/**
	 * 已激活并未在线的大图标路径
	 */
	@Column(name="active_unLine_big_image", length=100)
	private String activeUnLineBigImage;
    
	/**
	 * 类型对象
	 */
	@Column(name="type_object", length=100)
    private String typeObject;
    

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEnglishTag() {
		return englishTag;
	}

	public void setEnglishTag(String englishTag) {
		this.englishTag = englishTag;
	}

	public String getUnActiveGraySmallImage() {
		return unActiveGraySmallImage;
	}

	public void setUnActiveGraySmallImage(String unActiveGraySmallImage) {
		this.unActiveGraySmallImage = unActiveGraySmallImage;
	}

	public String getUnActiveGrayBigImage() {
		return unActiveGrayBigImage;
	}

	public void setUnActiveGrayBigImage(String unActiveGrayBigImage) {
		this.unActiveGrayBigImage = unActiveGrayBigImage;
	}

	public String getActiveSmallImage() {
		return activeSmallImage;
	}

	public void setActiveSmallImage(String activeSmallImage) {
		this.activeSmallImage = activeSmallImage;
	}

	public String getActiveBigImage() {
		return activeBigImage;
	}

	public void setActiveBigImage(String activeBigImage) {
		this.activeBigImage = activeBigImage;
	}

	public String getActiveUnLineSmallImage() {
		return activeUnLineSmallImage;
	}

	public void setActiveUnLineSmallImage(String activeUnLineSmallImage) {
		this.activeUnLineSmallImage = activeUnLineSmallImage;
	}

	public String getActiveUnLineBigImage() {
		return activeUnLineBigImage;
	}

	public void setActiveUnLineBigImage(String activeUnLineBigImage) {
		this.activeUnLineBigImage = activeUnLineBigImage;
	}

	public String getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(String typeObject) {
		this.typeObject = typeObject;
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof NodeTypeEntity)) {
			return false;
		}
		NodeTypeEntity another = (NodeTypeEntity) o;
		return new EqualsBuilder().append(typeId, another.typeId)
		                          .append(name, another.name)
		                          .append(englishTag, another.englishTag)
		                          .append(unActiveGraySmallImage, another.unActiveGraySmallImage)
		                          .append(unActiveGrayBigImage, another.unActiveGrayBigImage)
		                          .append(activeSmallImage, another.activeSmallImage)
		                          .append(activeBigImage, another.activeBigImage)
		                          .append(activeUnLineSmallImage, another.activeUnLineSmallImage)
		                          .append(activeUnLineBigImage, another.activeUnLineBigImage)
		                          .append(typeObject, another.typeObject)
		                      	  .isEquals();
	}

	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(typeId)
							        .append(name)
							        .append(englishTag)
							        .append(unActiveGraySmallImage)
							        .append(unActiveGrayBigImage)
							        .append(activeSmallImage)
							        .append(activeBigImage)
							        .append(activeUnLineSmallImage)
							        .append(activeUnLineBigImage)
							        .append(typeObject)
							    	.hashCode();
	}

	@Override
	public final String toString() {
		return name;
	}
   
}
