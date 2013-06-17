package org.infosec.ismp.manager.rmi.snmp.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.infosec.ismp.manager.rmi.snmp.model.host.CPUStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.MemoryStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus;

/**
 * @author guoxianwei
 * @date 2011-1-5 下午04:32:14
 * 
 */
public class NetworkDeviceStatus implements Serializable {

	private static final long serialVersionUID = 4262138423479903948L;
	private String nodeid;
	private String domain;
	private String ipAddr;
	private boolean active;
	private NetworkStatus networkStatus;
	private MemoryStatus memoryStatus;
	private CPUStatus cpuStatus;

	public String getNodeid() {
		return nodeid;
	}

	public String getDomain() {
		return domain;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public boolean isActive() {
		return active;
	}

	public NetworkStatus getNetworkStatus() {
		return networkStatus;
	}

	public MemoryStatus getMemoryStatus() {
		return memoryStatus;
	}

	public CPUStatus getCpuStatus() {
		return cpuStatus;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setNetworkStatus(NetworkStatus networkStatus) {
		this.networkStatus = networkStatus;
	}

	public void setMemoryStatus(MemoryStatus memoryStatus) {
		this.memoryStatus = memoryStatus;
	}

	public void setCpuStatus(CPUStatus cpuStatus) {
		this.cpuStatus = cpuStatus;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).appendSuper(super.toString()).append(
				"nodeid", nodeid).append("active", active).append(
				"networkStatus", networkStatus.toString()).append(
				"memoryStatus", memoryStatus.toString()).append("cpuStatus",
				cpuStatus.toString()).append("hardDiskStatus").toString();
	}
}
