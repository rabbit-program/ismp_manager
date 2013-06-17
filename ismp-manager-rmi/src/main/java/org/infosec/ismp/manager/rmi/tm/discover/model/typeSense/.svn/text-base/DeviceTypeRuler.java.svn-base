package org.infosec.ismp.manager.rmi.tm.discover.model.typeSense;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;

/**
 *拓扑发现--型别侦测规则
 * 
 * @author Wu Guojie
 * @date 2009-6-6
 * 
 */
@Entity
@Table(name = "tm_find_device_types_ruler")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class DeviceTypeRuler implements Serializable {
	/**
	 * 规则ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 设备名称
	 */ 
    @Column(name="name")
	private String name;
	/**
	 * 对应mib库中的节点标识
	 */ 
    @Column(name="oid")
	private String oid;
	/**
	 * 在mib中返回的信息中包含的信息字符串
	 */ 
    @Column(name="key_chars")
	private String keyChars;
	/**
	 * 侦测级别
	 */ 
    @Column(name="level")
	private Integer level;
	/**
	 * 设备类型
	 */
    @ManyToOne 
    @JoinColumn(name="type")
	private NodeType nodeType;
	/**
	 * 设备信息描述
	 */
    @Column(name="description")
	private String description;
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
	 * @return the oid
	 */
	public String getOid() {
		return oid;
	}

	/**
	 * @param oid
	 * the oid to set
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * @return the keyChars
	 */
	public String getKeyChars() {
		return keyChars;
	}

	/**
	 * @param keyChars
	 * the keyChars to set
	 */
	public void setKeyChars(String keyChars) {
		this.keyChars = keyChars;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level
	 * the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the nodeType
	 */
	public NodeType getNodeType() {
		return nodeType;
	}

	/**
	 * @param nodeType
	 * the nodeType to set
	 */
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
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
	 * 比较是否相等
	 * 
	 * @param o
	 *            另一条规则
	 * 
	 * @return true/false
	 * */
	public final boolean equals(Object o) {
		if (!(o instanceof DeviceTypeRuler)) {
			return false;
		}
		DeviceTypeRuler another = (DeviceTypeRuler) o;
		return new EqualsBuilder().append(id, another.id)
		                          .append(name, another.name)
		                          .append(oid, another.oid)
		                          .append(keyChars, another.keyChars)
		                          .append(level, another.level)
		                          .append(nodeType, another.nodeType)
		                          .append(description, another.description)
		                          .append(addDate, another.addDate)
		                          .append(updateDate, another.updateDate)
		                          .append(remarks,another.remarks)
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
							        .append(oid)
							        .append(keyChars)
							        .append(level)
							        .append(nodeType)
							        .append(description)
							        .append(addDate)
							        .append(updateDate)
							        .append(remarks)
							    	.hashCode();
	}

	/**
	 * 链接toString
	 * 
	 * @return 属性字符串
	 * */
	public String toString() {
		return new ToStringBuilder(this).append(id)
								        .append(name)
								        .append(oid)
								        .append(keyChars)
								        .append(level)
								        .append(nodeType)
								        .append(description)
								        .append(addDate)
								        .append(updateDate)
								        .append(remarks)
										.toString();
	}
}
