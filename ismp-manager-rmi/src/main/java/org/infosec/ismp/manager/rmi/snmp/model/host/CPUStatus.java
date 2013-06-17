package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class CPUStatus implements Serializable {

	private static final long serialVersionUID = -4180842109949023753L;
	private int[] m_loads;

	/**
	 * 构造方法
	 */
	public CPUStatus() {

	}

	/**
	 * @return 包含当前CPU负载值的数组，数组长度表示CPU数（核心数），数组每个元素是一个0到100的整数，表示一个核心的负载值
	 */
	public int[] getLoads() {

		return m_loads;

	}

	public void setLoads(int[] loads) {
		m_loads = loads;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		for (Integer status : m_loads) {
			builder.append("CPUStatus.Load", status);
		}

		return builder.toString();
	}

}
