package edu.sjtu.infosec.ismp.manager.BSAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.sjtu.infosec.ismp.security.Domain;


/**
 * 机房表类.
 * Author：cchang
 * 2010-10-21 15:27:50
 */
@Entity
@Table(name = "bsam_machine_room")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class MachineRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3435396693538071983L;

	/**
     * 主键id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    /**
     * 机房名
     **/
    @Column(name="machine_room_name", length = 100, nullable = false)
    private String machineRoomName;
	
    /**
     * 所在安全域
     **/
    @ManyToOne 
    @JoinColumn(name="security_area_id")
    private Domain domain;
    
    /**
     * 所在安全域name
     **/
    @Column(name="security_area_name")
    private String securityAreaName;
    
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
