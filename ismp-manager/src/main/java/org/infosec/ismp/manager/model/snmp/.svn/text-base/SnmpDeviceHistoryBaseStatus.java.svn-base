package org.infosec.ismp.manager.model.snmp;

import java.io.Serializable;

import org.infosec.ismp.manager.rmi.snmp.model.NetworkDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.HostDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicDeviceStatus;

/**
 * @author guoxianwei
 * @date 2010-12-28 上午10:19:02
 * 
 *       汇总处理主机，WEBLOGIC,CISCO 等设备状态信息
 */
public class SnmpDeviceHistoryBaseStatus implements Serializable {

	private static final long serialVersionUID = -4697282824774161243L;

	private HostDeviceStatus m_hostDeviceStatus;

	private WeblogicDeviceStatus m_weblogicDeviceStatus;

	private NetworkDeviceStatus m_networkDeviceStatus;
    //持久化类 用于入库操作
	private SnmpDeviceHistoryBaseEntity m_snmpDeviceHistoryBaseEntity;

	public HostDeviceStatus getHostDeviceStatus() {
		return m_hostDeviceStatus;
	}

	public WeblogicDeviceStatus getWeblogicDeviceStatus() {
		return m_weblogicDeviceStatus;
	}

	public SnmpDeviceHistoryBaseEntity getSnmpDeviceHistoryBaseEntity() {
		return m_snmpDeviceHistoryBaseEntity;
	}

	public void setHostDeviceStatus(HostDeviceStatus hostDeviceStatus) {
		m_hostDeviceStatus = hostDeviceStatus;
	}

	public NetworkDeviceStatus getNetworkDeviceStatus() {
		return m_networkDeviceStatus;
	}

	public void setNetworkDeviceStatus(NetworkDeviceStatus networkDeviceStatus) {
		m_networkDeviceStatus = networkDeviceStatus;
	}

	public void setWeblogicDeviceStatus(
			WeblogicDeviceStatus weblogicDeviceStatus) {
		m_weblogicDeviceStatus = weblogicDeviceStatus;
	}

	public void setSnmpDeviceHistoryBaseEntity(
			SnmpDeviceHistoryBaseEntity snmpDeviceHistoryBaseEntity) {
		m_snmpDeviceHistoryBaseEntity = snmpDeviceHistoryBaseEntity;
	}

}
