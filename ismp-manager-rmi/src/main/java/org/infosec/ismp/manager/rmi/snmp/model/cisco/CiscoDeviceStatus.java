package org.infosec.ismp.manager.rmi.snmp.model.cisco;

import java.io.Serializable;
import java.util.List;

/**
 * @author guoxianwei
 * @date 2010-12-28 下午04:05:58
 * 
 */
public class CiscoDeviceStatus implements Serializable {

	private static final long serialVersionUID = -6006630938723198968L;

	private String nodeid;
	private Boolean active;
	private List<CpuTotalStatus> ciscoCpmCpuTotalStatus;
	private List<MemoryPoolStatus> ciscoMemoryPoolStatus;
	private List<CpmProcessStatus> cpmProcessStatus;

	public String getNodeid() {
		return nodeid;
	}

	public Boolean getActive() {
		return active;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<CpuTotalStatus> getCiscoCpmCpuTotalStatus() {
		return ciscoCpmCpuTotalStatus;
	}

	public List<MemoryPoolStatus> getCiscoMemoryPoolStatus() {
		return ciscoMemoryPoolStatus;
	}

	public List<CpmProcessStatus> getCpmProcessStatus() {
		return cpmProcessStatus;
	}

	public void setCiscoCpmCpuTotalStatus(
			List<CpuTotalStatus> ciscoCpmCpuTotalStatus) {
		this.ciscoCpmCpuTotalStatus = ciscoCpmCpuTotalStatus;
	}

	public void setCiscoMemoryPoolStatus(
			List<MemoryPoolStatus> ciscoMemoryPoolStatus) {
		this.ciscoMemoryPoolStatus = ciscoMemoryPoolStatus;
	}

	public void setCpmProcessStatus(List<CpmProcessStatus> cpmProcessStatus) {
		this.cpmProcessStatus = cpmProcessStatus;
	}

}

