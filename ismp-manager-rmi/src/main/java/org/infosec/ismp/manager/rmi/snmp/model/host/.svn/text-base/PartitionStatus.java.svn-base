package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
public class PartitionStatus  implements Serializable {

	private static final long serialVersionUID = -5127714555678433575L;

	public PartitionStatus() {

	}

	private Long m_size;

	private Long m_used;

	private String m_label;

	/**
	 * @return 分区容量，单位为KByte
	 */
	public Long getSize() {
		return m_size;
	}

	/**
	 * @return 分区已使用容量，单位为KByte
	 */
	public Long getUsed() {
		return m_used;
	}

	/**
	 * @return 分区标识符或卷标
	 */
	public String getLabel() {
		return m_label;
	}

	public void setSize(Long size) {
		m_size = size;
	}

	public void setUsed(Long used) {
		m_used = used;
	}

	public void setLabel(String label) {
		m_label = label;
	}
	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"size", m_size).append("used", m_used).append("label", m_label).toString();
	}
}
