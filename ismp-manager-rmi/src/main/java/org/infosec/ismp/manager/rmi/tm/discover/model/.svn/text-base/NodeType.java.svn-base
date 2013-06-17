package org.infosec.ismp.manager.rmi.tm.discover.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
/**
 * 拓扑发现-节点类型
 * @author Wu Guojie
 * @date 2009-6-6
 * @version 1.0
 */
@Entity
@Table(name = "tm_find_node_types")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class NodeType implements Serializable {
	/**
	 * 节点ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 节点类型名称
	 */ 
    @Column(name="name")
	private String name;
	/**
	 * 节点类型描述
	 */
    @Column(name="description")
	private String description;
	/**
     * 英文标记
     */
    @Column(name="english_tag")
    private String  englishTag;
    /**
	 * 类全名
	 */
    @Column(name="fullclass_name")
	private String fullclassName;
    /**
     * 图标
     */
     @Column(name="ico_path")
     private String icoPath;
     
     /**
      * 显示图片
      */
     @Column(name="image_path")
     private String imagePath;
	/**
	 * 添加时间
	 */
    @Column(name="add_date")
	private Date addDate;
	/**
	 * 修改时间
	 */
    @Column(name="update_date")
	private Date updateDate; 
	/**
	 * 备注
	 */
    @Column(name="remarks")
	private String remarks;
    
    
    
    public String getIcoPath() {
		return icoPath;
	}

	public void setIcoPath(String icoPath) {
		this.icoPath = icoPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 * the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the englishTag
	 */
	public String getEnglishTag() {
		return englishTag;
	}

	/**
	 * @param englishTag
	 * the englishTag to set
	 */
	public void setEnglishTag(String englishTag) {
		this.englishTag = englishTag;
	}

	/**
	 * @return the fullclassName
	 */
	public String getFullclassName() {
		return fullclassName;
	}

	/**
	 * @param fullclassName
	 * the fullclassName to set
	 */
	public void setFullclassName(String fullclassName) {
		this.fullclassName = fullclassName;
	}

	/**
	 * @return the addDate
	 */
	public Date getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate
	 * the addDate to set
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 * the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 * the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 * the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	/**
	 * 比较是否相等
	 * 
	 * @param o
	 *            另一个设备节点类型
	 * 
	 * @return true/false
	 * */
	public final boolean equals(Object o) {
		if (!(o instanceof NodeType)) {
			return false;
		}
		NodeType another = (NodeType) o;
		return new EqualsBuilder().append(id, another.id)
		                          .append(name, another.name)
		                          .append(description, another.description)
		                          .append(englishTag, another.englishTag)
		                          .append(fullclassName, another.fullclassName)
		                          .append(addDate, another.addDate)
		                          .append(updateDate, another.updateDate)
		                          .append(remarks, another.remarks)
		                      	  .isEquals();
	}

	/**
	 * 获取哈希值
	 * 
	 * @return 哈希值
	 * */
	public final int hashCode() {
		return new HashCodeBuilder().append(id)
							        .append(name)
							        .append(description)
							        .append(englishTag)
							        .append(fullclassName)
							        .append(addDate)
							        .append(updateDate)
							        .append(remarks)
							    	.hashCode();
	}

	/**
	 * 链接toString
	 * 
	 * @return 类型名
	 * */
	public final String toString() {
		return name;
	}
   

}
