package org.infosec.ismp.manager.winsensor.history.entity;

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
 * @version create time: Dec 31, 2010 10:37:02 AM
 *
 */
@Entity
@Table(name="host_resource_history")
public class HostResourceHistoryBO implements Serializable {

	private static final long serialVersionUID = -3712671875402307441L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="node_id", length=100)
	private String nodeId;
	
	@Column(name="domain_id", length=100)
	private String domainID;
	
	@Column(name="ip", length=50)
	private String ip;		//Sensor IP.
	
	@Column(name="res_type", length=50)
	private String type;		//CPU, Memory, Network, HardDisk.
	
	@Column(name="res_sub_type", length=50)
	private String subType;		//HardDisk: C, D, E; Network: receive bytes, send bytes, and so on
	
	@Column(name="res_index", length=50)
	private String index;		//HardDisk 1, 2, 3; Network: 1, 2, 3 and so on.
	
	@Column(name="total_size")
	private long totalSize;		//Total size.
	
	@Column(name="current_used_size")
	private long currentUsedSize;		//Current used size.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;		//Create time.

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

	public String getDomainID() {
		return domainID;
	}

	public void setDomainID(String domainID) {
		this.domainID = domainID;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public long getCurrentUsedSize() {
		return currentUsedSize;
	}

	public void setCurrentUsedSize(long currentUsedSize) {
		this.currentUsedSize = currentUsedSize;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
