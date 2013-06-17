package org.infosec.ismp.manager.rmi.snmp.model;

import java.io.Serializable;

import org.infosec.ismp.manager.rmi.snmp.model.host.HostDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicDeviceStatus;

/**
 * @author guoxianwei
 * @date 2011-1-5 上午10:16:00
 * 
 */
public class SnmpDeviceStatus implements Serializable {

	private static final long serialVersionUID = 7820100025911105688L;
    
	private HostDeviceStatus m_hostDeviceStatus;
	
	private WeblogicDeviceStatus m_weblogicDeviceStatus;
	
	private NetworkDeviceStatus m_networkDeviceStatus;

	public HostDeviceStatus getHostDeviceStatus() {
		return m_hostDeviceStatus;
	}

	public WeblogicDeviceStatus getWeblogicDeviceStatus() {
		return m_weblogicDeviceStatus;
	}

	public NetworkDeviceStatus getNetworkDeviceStatus() {
		return m_networkDeviceStatus;
	}

	public void setHostDeviceStatus(HostDeviceStatus hostDeviceStatus) {
		m_hostDeviceStatus = hostDeviceStatus;
	}

	public void setWeblogicDeviceStatus(WeblogicDeviceStatus weblogicDeviceStatus) {
		m_weblogicDeviceStatus = weblogicDeviceStatus;
	}

	public void setNetworkDeviceStatus(NetworkDeviceStatus networkDeviceStatus) {
		m_networkDeviceStatus = networkDeviceStatus;
	}

}

