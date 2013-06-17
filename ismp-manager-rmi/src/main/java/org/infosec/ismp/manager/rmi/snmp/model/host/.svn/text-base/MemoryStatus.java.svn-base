package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
public class MemoryStatus  implements Serializable {

	private static final long serialVersionUID = 7675064810259501910L;

	/**
	 * 构造方法
	 * 
	 */
	public MemoryStatus() {

	}

	private Long m_size;

	private Long m_used;
	
	private Long m_units;

	/**
	 * @return 内存容量，单位为KByte
	 */
	public Long getSize() {
		return m_size;
	}

	/**
	 * @return 内存已使用容量，单位为KByte
	 */
	public Long getUsed() {
		return m_used;
	}

	public Long getUnits() {
		return m_units/1024;
	}

	public void setSize(Long size) {
		m_size = size;
	}

	public void setUsed(Long used) {
		m_used = used;
	}

	public void setUnits(Long units) {
		m_units = units;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"size", m_size).append("used", m_used)
				.append("units", m_units).toString();
	}
}
