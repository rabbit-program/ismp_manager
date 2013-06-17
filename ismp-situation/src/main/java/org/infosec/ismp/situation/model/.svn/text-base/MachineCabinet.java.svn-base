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
 * 机柜表.
 * Author：cchang
 * 2010-9-21 下午02:22:46
 */
@Entity
@Table(name = "bsam_machine_cabinet")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class MachineCabinet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8729885709978929985L;

	/**
     * 主键id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    /**
     * 机柜名
     **/
    @Column(name="machine_cabinet_name", length = 100, nullable = false)
    private String machineCabinetName;
	
    /**
     * 所在机房
     **/

    @ManyToOne
    @JoinColumn(name="machine_room_id")
    private MachineRoom machineRoom;
    
    /**
     * 所在机房name
     **/
    @Column(name="machine_room_name")
    private String machineRoomName;
    
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
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
