package edu.sjtu.infosec.ismp.manager.VPM.vm.web.form;

import org.apache.struts.action.ActionForm;

public class VirusClientsORMModifyForm extends ActionForm {
	/**
	 * 病毒客户端ID
	 */
	private String virusClientId;
	/**
	 * 病毒客户端的名字
	 */
	private String virusClientName;
	/**
	 * 病毒客户端的ID
	 */
	private String assetDevice;
	/**
	 * 病毒客户端的录入时间
	 */
	private String department;
	
	
	
	
	public String getVirusClientId() {
		return virusClientId;
	}
	public void setVirusClientId(String virusClientId) {
		this.virusClientId = virusClientId;
	}
	public String getVirusClientName() {
		return virusClientName;
	}
	public void setVirusClientName(String virusClientName) {
		this.virusClientName = virusClientName;
	}
	public String getAssetDevice() {
		return assetDevice;
	}
	public void setAssetDevice(String assetDevice) {
		this.assetDevice = assetDevice;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
