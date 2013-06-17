package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
public class NetworkStatus  implements Serializable  {

	private static final long serialVersionUID = -305369757032791563L;

	public NetworkStatus() {

	}

	private InterfaceStatus[] m_interfaceStatus;

	/**
	 * @return 网络接口状态信息数组。数组长度表示设备网络接口数，数组每个元素表示一个网络接口状态信息
	 */
	public InterfaceStatus[] getInterfaceStatus() {
		return m_interfaceStatus;
	}

	public void setInterfaceStatus(InterfaceStatus[] interfaceStatus) {
		m_interfaceStatus = interfaceStatus;
	}
    @Override
    public String toString() {
    	ToStringBuilder builder = new ToStringBuilder(this);
    	builder.appendSuper(super.toString());
    	for(InterfaceStatus status: m_interfaceStatus){
    		builder.append("InterfaceStatus",status.toString());
    	}
		return builder.toString();
	}
}
