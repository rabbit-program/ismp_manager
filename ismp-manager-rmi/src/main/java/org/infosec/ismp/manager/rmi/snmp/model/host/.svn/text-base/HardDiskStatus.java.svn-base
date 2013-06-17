package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
@SuppressWarnings("unchecked")
public class HardDiskStatus  implements Serializable  {

	private static final long serialVersionUID = 4439787466189008846L;

	/**
	 * 构造方法
	 * 
	 * @param vDevice
	 */
	public HardDiskStatus() {

	}
	private List<PartitionStatus> m_partitionStatuses = Collections.EMPTY_LIST;

	private Long m_size;
	private Long m_used;

	/**
	 * @return 硬盘容量，单位为KBytes
	 */
	public Long getSize() {
		return m_size;
	}

	/**
	 * @return 硬盘已使用容量，单位为KBytes
	 */
	public Long getUsed() {
		return m_used;
	}

	/**
	 * @return 硬盘分区状态信息数组。数组长度表示分区数，数组每个元素是一个分区的状态信息
	 */
	public PartitionStatus[] getPartitionStatus() {
		return m_partitionStatuses.toArray(new PartitionStatus[]{});
	}

	public void setSize(Long size) {
		m_size = size;
	}

	public void setUsed(Long used) {
		m_used = used;
	}

	public void setPartitionStatus(List<PartitionStatus> vPartitionStatus) {
		m_partitionStatuses = vPartitionStatus;
	}
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		builder.append("size", m_size).append("used", m_used);
		for (PartitionStatus status : m_partitionStatuses) {
			builder.append("PartitionStatus", status.toString());
		}

		return builder.toString();
	}
}
