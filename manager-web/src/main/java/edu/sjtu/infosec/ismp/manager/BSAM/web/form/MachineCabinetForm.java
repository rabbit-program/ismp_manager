package edu.sjtu.infosec.ismp.manager.BSAM.web.form;

import org.apache.struts.action.ActionForm;

public class MachineCabinetForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2908650604775184906L;

	/**
     * 主键id
     **/
    private Integer id;
    
    /**
     * 机柜名
     **/
    private String machineCabinetName;
	
    /**
     * 所在机房id
     **/
    private Integer machineRoomId;
    
    /**
     * 所在机房name
     */
    private String machineRoomName;
    
    /**
     * 描述
     **/
    private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMachineCabinetName() {
		return machineCabinetName;
	}

	public void setMachineCabinetName(String machineCabinetName) {
		this.machineCabinetName = machineCabinetName;
	}

	public Integer getMachineRoomId() {
		return machineRoomId;
	}

	public void setMachineRoomId(Integer machineRoomId) {
		this.machineRoomId = machineRoomId;
	}
	
	public String getMachineRoomName() {
		return machineRoomName;
	}

	public void setMachineRoomName(String machineRoomName) {
		this.machineRoomName = machineRoomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
