package edu.sjtu.infosec.ismp.manager.BSAM.web.form;

import org.apache.struts.action.ActionForm;

public class MachineForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6880144291722634018L;
	
	private Integer id;
	/**
     * 主机ip
     **/
    private String ip;
    /**
     * 主机名称
     */
    private String machineName;
    /**
     * 上级物理位置类型
     */
    private String parentType;
    
    /**
     * 所在机柜Id
     **/
    private Integer machineCabinetId;
    
    /**
     * 所在机柜Name
     */
    private String machineCabinetName;
    
    /**
     * 所在机房Id
     **/
    private Integer machineRoomId;
    
    /**
     * 所在机房Name
     */
    private String machineRoomName;
    
    /**
     * 所在安全域Id
     **/
    private Integer securityAreaId;
    
    /**
     * 所在安全域Name
     **/
    private String securityAreaName;
    
    /**
     * 权重
     **/
    private Integer weight;
    
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public Integer getMachineCabinetId() {
		return machineCabinetId;
	}

	public void setMachineCabinetId(Integer machineCabinetId) {
		this.machineCabinetId = machineCabinetId;
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

	public String getSecurityAreaName() {
		return securityAreaName;
	}

	public void setSecurityAreaName(String securityAreaName) {
		this.securityAreaName = securityAreaName;
	}

	public Integer getSecurityAreaId() {
		return securityAreaId;
	}

	public void setSecurityAreaId(Integer securityAreaId) {
		this.securityAreaId = securityAreaId;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
