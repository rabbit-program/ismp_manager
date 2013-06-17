package org.infosec.ismp.agent.comm.winsensor.model;

import java.io.Serializable;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 3:24:24 PM
 *
 */
public class CommThreshold implements Serializable {

	private static final long serialVersionUID = 6910561368175079095L;

	private String nodeId;
	
	private String type;		//Memory, HardDisk, Network, CPU
	
	private String subType;			//HardDisk: C, D, E; Network: receive bytes, send bytes.
	
	private String index;		//HardDisk index: 1, 2, 3...; Network index: 1, 2, 3...
	
	private Integer level;	//Important level.
	
	private long size;		//Threshold size.

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
}
