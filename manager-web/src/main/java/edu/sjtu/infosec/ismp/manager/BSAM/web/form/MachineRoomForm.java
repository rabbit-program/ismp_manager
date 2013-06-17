package edu.sjtu.infosec.ismp.manager.BSAM.web.form;

import org.apache.struts.action.ActionForm;

public class MachineRoomForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8918255339574698550L;

	/**
     * 主键id
     **/
    private Integer id;
    
    /**
     * 机房名
     **/
    private String machineRoomName;
	
    /**
     * 所在安全域id
     **/
    private Integer securityAreaId;
    
    /**
     * 所在安全域Name
     */
    private String securityAreaName;
    
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

	public String getMachineRoomName() {
		return machineRoomName;
	}

	public void setMachineRoomName(String machineRoomName) {
		this.machineRoomName = machineRoomName;
	}

	public Integer getSecurityAreaId() {
		return securityAreaId;
	}

	public void setSecurityAreaId(Integer securityAreaId) {
		this.securityAreaId = securityAreaId;
	}
	
	public String getSecurityAreaName() {
		return securityAreaName;
	}

	public void setSecurityAreaName(String securityAreaName) {
		this.securityAreaName = securityAreaName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
