package org.infosec.ismp.manager.rmi.tm.discover.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 拓扑发现-节点间连接
 * @author Wu Guojie
 * @date 2009-6-6
 * @version 1.0
 */
@Entity
@Table(name = "tm_find_lines")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Line implements Serializable {
	/**
	 * 线ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 线名称
	 */
    @Column(name="name")
	private String name;

	/**
	 * 节点描述
	 */
    @Column(name="description")
	private String description;

	/**
	 * 自节点
	 */
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "node_self")
	private Node nodeSelf;
	/**
	 * 目的节点
	 */
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "node_dest")
	private Node nodeDest;
	/**
	 * 添加时间
	 */
    @Column(name="add_date")
	private Date addDate;
	/**
	 * 更新时间
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
	 * @return the nodeDest
	 */
	public Node getNodeDest() {
		return nodeDest;
	}

	/**
	 * @param nodeDest
	 * the nodeDest to set
	 */
	public void setNodeDest(Node nodeDest) {
		this.nodeDest = nodeDest;
	}

	/**
	 * @return the nodeSelf
	 */
	public Node getNodeSelf() {
		return nodeSelf;
	}

	/**
	 * @param nodeSelf
	 * the nodeSelf to set
	 */
	public void setNodeSelf(Node nodeSelf) {
		this.nodeSelf = nodeSelf;
	}

	/**
	 * 比较是否相等
	 * 
	 * @param o
	 *            另一个线
	 * 
	 * @return true/false
	 * */
	public final boolean equals(Object o) {
		if (!(o instanceof Line)) {
			return false;
		}
		Line another = (Line) o;
		return new EqualsBuilder().append(id, another.id)
									.append(name, another.name)
									.append(addDate, another.addDate)
									.append(nodeSelf, another.nodeSelf)
									.append(nodeDest, another.nodeDest)
									.append(remarks, another.remarks)
									.append(updateDate, another.updateDate)
									.append(description, another.description)
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
									.append(addDate)
									.append(nodeSelf)
									.append(nodeDest)
									.append(remarks)
									.append(updateDate)
									.append(description)
									.hashCode();
	}

	/**
	 * 链接toString
	 * 
	 * @return 属性字符串
	 * */
	public final String toString() {
		return new ToStringBuilder(this).append(id)
										.append(name)
										.append(addDate)
										.append(nodeSelf)
										.append(nodeDest)
										.append(remarks)
										.append(updateDate)
										.append(description)
										.toString();
	}

}
