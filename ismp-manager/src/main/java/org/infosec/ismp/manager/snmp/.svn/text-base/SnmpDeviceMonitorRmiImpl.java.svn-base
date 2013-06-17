package org.infosec.ismp.manager.snmp;

import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceRmiBean;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.InterfaceStatus;
import org.infosec.ismp.manager.rmi.snmp.service.SnmpDeviceMonitorRmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoxianwei
 * @date 2010-12-14 下午04:35:55
 * 
 */
@Component
public class SnmpDeviceMonitorRmiImpl implements SnmpDeviceMonitorRmi {

	
	private SnmpDeviceLocator m_snmpDeviceLocator;
	
	@Override
	public void addSnmpDeviceMonitor(SnmpDeviceRmiBean rmiBean) {
		m_snmpDeviceLocator.addSnmpDeviceNode(rmiBean);
	}

	@Override
	public void removeSnmpDeviceMonitor(String nodeid) {
		m_snmpDeviceLocator.removeSnmpDeviceNode(nodeid);
	}

	@Autowired(required=true)
	public void setSnmpDeviceLocator(SnmpDeviceLocator snmpDeviceLocator) {
		m_snmpDeviceLocator = snmpDeviceLocator;
	}

	@Override
	public SnmpDeviceStatus getSnmpDeviceStatus(String nodeid) {
		return m_snmpDeviceLocator.getSnmpDeviceStatus(nodeid);
	}

	@Override
	public InterfaceStatus[] getInterfaceStatus(String nodeid) {
		return m_snmpDeviceLocator.getInterfaceStatus(nodeid);
	}

}

