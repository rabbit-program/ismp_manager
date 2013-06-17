package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author guoxianwei
 * @date 2010-12-20 下午04:27:51
 * 
 */
public class HostDeviceStatus implements Serializable {

	private static final long serialVersionUID = 6705628550336228265L;

	private String nodeid;
	private String domain;
	private String ipAddr;
	private boolean active;
	private NetworkStatus networkStatus;
	private MemoryStatus memoryStatus;
	private CPUStatus cpuStatus;
	private HardDiskStatus hardDiskStatus;
	private ProcessesStatus processesStatus;

	public String getDomain() {
		return domain;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getNodeid() {
		return nodeid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public HardDiskStatus getHardDiskStatus() {
		return hardDiskStatus;
	}

	public ProcessesStatus getProcessesStatus() {
		return processesStatus;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
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

	public void setHardDiskStatus(HardDiskStatus hardDiskStatus) {
		this.hardDiskStatus = hardDiskStatus;
	}

	public void setProcessesStatus(ProcessesStatus processesStatus) {
		this.processesStatus = processesStatus;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE).appendSuper(super.toString()).append(
				"nodeid", nodeid).append("active", active).append(
				"networkStatus", networkStatus.toString()).append(
				"memoryStatus", memoryStatus.toString()).append("cpuStatus",
				cpuStatus.toString()).append("hardDiskStatus",
				hardDiskStatus.toString()).append("processesStatus",
				processesStatus.toString()).toString();
	}

}
