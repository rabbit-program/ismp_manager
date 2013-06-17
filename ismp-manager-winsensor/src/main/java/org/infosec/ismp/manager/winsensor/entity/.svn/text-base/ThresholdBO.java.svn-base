package org.infosec.ismp.manager.winsensor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 11:11:22 AM
 *
 */
@Entity
@Table(name="threshold")
public class ThresholdBO implements Serializable {

	private static final long serialVersionUID = -3049532218849768851L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="node_id", length=100)
	private String nodeId;
	
	@Column(name="threshold_type", length=50)
	private String type;		//Memory, HardDisk, Network, CPU
	
	@Column(name="sub_type", length=50)
	private String subType;			//HardDisk: C, D, E; Network: receive bytes, send bytes.
	
	@Column(name="threshold_index", length=50)
	private String index;		//HardDisk index: 1, 2, 3...; Network index: 1, 2, 3...
	
	@Column(name="threshold_level")
	private Integer level;	//Important level.
	
	@Column(name="size")
	private long size;		//Threshold size.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
