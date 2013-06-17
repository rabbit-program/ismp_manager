package org.infosec.ismp.situation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *  主机表类.
 * Author：cchang
 * 2010-9-21 下午02:22:46
 */
@Entity
@Table(name = "bsam_machine")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class Machine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7805870028918704268L;

	/**
     * 主键id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    /**
     * 主机名称
     **/
    @Column(name="machine_name", length = 100)
    private String machineName;
    
    /**
     * 主机ip
     **/
    @Column(name="ip", length = 100, nullable = false)
    private String ip;
    
    /**
     * 上级物理位置类型
     **/
    @Column(name="parent_type", length = 100)
    private String parentType;
    
    /**
     * 所在机柜
     **/
    @ManyToOne 
    @JoinColumn(name="machine_cabinet_id")
    private MachineCabinet machineCabinet;
    
    /**
     * 所在机柜Name
     **/
    @Column(name="machine_cabinet_name")
    private String machineCabinetName;
    
    /**
     * 所在机房
     **/
    @ManyToOne 
    @JoinColumn(name="machine_room_id")
    private MachineRoom machineRoom;
    
    /**
     * 所在机房Name
     **/
    @Column(name="machine_room_name")
    private String machineRoomName;
    
    /**
     * 所在安全域
     **/
    @ManyToOne 
    @JoinColumn(name="security_area_id")
    private Domain domain;
    
    /**
     * 所在安全域Name
     **/
    @Column(name="security_area_name")
    private String securityAreaName;
    
    /**
     * 权重
     **/
    @Column(name="weight", nullable = false)
    private Integer weight;
    
    /**
     * 描述
     **/
    @Column(name="description")
    private String description;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
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
	
	public MachineCabinet getMachineCabinet() {
		return machineCabinet;
	}

	public void setMachineCabinet(MachineCabinet machineCabinet) {
		this.machineCabinet = machineCabinet;
	}

	public String getMachineCabinetName() {
		return machineCabinetName;
	}

	public void setMachineCabinetName(String machineCabinetName) {
		this.machineCabinetName = machineCabinetName;
	}
	
	public MachineRoom getMachineRoom() {
		return machineRoom;
	}

	public void setMachineRoom(MachineRoom machineRoom) {
		this.machineRoom = machineRoom;
	}

	public String getMachineRoomName() {
		return machineRoomName;
	}

	public void setMachineRoomName(String machineRoomName) {
		this.machineRoomName = machineRoomName;
	}
	
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public String getSecurityAreaName() {
		return securityAreaName;
	}

	public void setSecurityAreaName(String securityAreaName) {
		this.securityAreaName = securityAreaName;
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
