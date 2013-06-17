package org.infosec.ismp.agent.comm.winsensor.model.status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rocky
 * @version create time：Oct 13, 2010 9:48:06 AM
 * 
 */
public class HardDiskStatus implements Serializable {

	private static final long serialVersionUID = -5721629318130119138L;

	/*
	 * 硬盘型号
	 */
	private String model;
	
	/*
	 * 接口类型
	 */
	private String interfaceType;
	
	/*
	 * 硬盘容量
	 */
	private Long size;
	
	/*
	 * 已使用容量
	 */
	private Long used;
	
	/*
	 * 分区情况
	 */
	private List<PartitionStatus> partitionStatus = new ArrayList<PartitionStatus>();

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getUsed() {
		return used;
	}

	public void setUsed(Long used) {
		this.used = used;
	}

	public List<PartitionStatus> getPartitionStatus() {
		return partitionStatus;
	}

	public void setPartitionStatus(List<PartitionStatus> partitionStatus) {
		this.partitionStatus = partitionStatus;
	}
}
