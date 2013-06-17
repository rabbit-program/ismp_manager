package org.infosec.ismp.manager.rmi.snmp.model.cisco;

import java.io.Serializable;


/**
 * @author guoxianwei
 * @date 2010-10-20 下午04:02:30
 * 
 */
public class CpmProcessExtRevStatus  implements Serializable {
	
	private static final long serialVersionUID = -6532928290972104050L;
	private String cpmProcessPID;
	private String cpmProcExtMemAllocatedRev;
	private String cpmProcExtMemFreedRev;
	private String cpmProcExtInvokedRev;
	private String cpmProcExtRuntimeRev;
	private String cpmProcExtUtil5SecRev;
	private String cpmProcExtUtil1MinRev;
	private String cpmProcExtUtil5MinRev;
	private String cpmProcExtPriorityRev;

	public String getCpmProcessPID() {
		return cpmProcessPID;
	}

	public void setCpmProcessPID(String cpmProcessPID) {
		this.cpmProcessPID = cpmProcessPID;
	}

	public String getCpmProcExtMemAllocatedRev() {
		return cpmProcExtMemAllocatedRev;
	}

	public String getCpmProcExtMemFreedRev() {
		return cpmProcExtMemFreedRev;
	}

	public String getCpmProcExtInvokedRev() {
		return cpmProcExtInvokedRev;
	}

	public String getCpmProcExtRuntimeRev() {
		return cpmProcExtRuntimeRev;
	}

	public String getCpmProcExtUtil5SecRev() {
		return cpmProcExtUtil5SecRev;
	}

	public String getCpmProcExtUtil1MinRev() {
		return cpmProcExtUtil1MinRev;
	}

	public String getCpmProcExtUtil5MinRev() {
		return cpmProcExtUtil5MinRev;
	}

	public String getCpmProcExtPriorityRev() {
		return cpmProcExtPriorityRev;
	}

	public void setCpmProcExtMemAllocatedRev(String cpmProcExtMemAllocatedRev) {
		this.cpmProcExtMemAllocatedRev = cpmProcExtMemAllocatedRev;
	}

	public void setCpmProcExtMemFreedRev(String cpmProcExtMemFreedRev) {
		this.cpmProcExtMemFreedRev = cpmProcExtMemFreedRev;
	}

	public void setCpmProcExtInvokedRev(String cpmProcExtInvokedRev) {
		this.cpmProcExtInvokedRev = cpmProcExtInvokedRev;
	}

	public void setCpmProcExtRuntimeRev(String cpmProcExtRuntimeRev) {
		this.cpmProcExtRuntimeRev = cpmProcExtRuntimeRev;
	}

	public void setCpmProcExtUtil5SecRev(String cpmProcExtUtil5SecRev) {
		this.cpmProcExtUtil5SecRev = cpmProcExtUtil5SecRev;
	}

	public void setCpmProcExtUtil1MinRev(String cpmProcExtUtil1MinRev) {
		this.cpmProcExtUtil1MinRev = cpmProcExtUtil1MinRev;
	}

	public void setCpmProcExtUtil5MinRev(String cpmProcExtUtil5MinRev) {
		this.cpmProcExtUtil5MinRev = cpmProcExtUtil5MinRev;
	}

	public void setCpmProcExtPriorityRev(String cpmProcExtPriorityRev) {
		this.cpmProcExtPriorityRev = cpmProcExtPriorityRev;
	}

}

