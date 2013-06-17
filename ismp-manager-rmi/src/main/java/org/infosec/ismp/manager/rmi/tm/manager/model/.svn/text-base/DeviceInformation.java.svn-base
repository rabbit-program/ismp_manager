package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;

/**
 * 所有设备的动态信息
 * @author 肖高峰
 *
 */
public class DeviceInformation implements Serializable{
	private static final long serialVersionUID = -8191761026854621393L;
	private String nodeId;
	private HostResource hostResource;//sensor动态信息
	private DatabaseResultStatus databaseResultStatus;//数据库信息
	private SnmpDeviceStatus snmpDeviceStatus; //其它设备信息

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public HostResource getHostResource() {
		return hostResource;
	}

	public void setHostResource(HostResource hostResource) {
		this.hostResource = hostResource;
	}

	public DatabaseResultStatus getDatabaseResultStatus() {
		return databaseResultStatus;
	}

	public void setDatabaseResultStatus(DatabaseResultStatus databaseResultStatus) {
		this.databaseResultStatus = databaseResultStatus;
	}

	public SnmpDeviceStatus getSnmpDeviceStatus() {
		return snmpDeviceStatus;
	}

	public void setSnmpDeviceStatus(SnmpDeviceStatus snmpDeviceStatus) {
		this.snmpDeviceStatus = snmpDeviceStatus;
	}
	
	
}
