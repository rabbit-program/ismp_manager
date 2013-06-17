package edu.sjtu.infosec.ismp.manager.VPM.vm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 病毒信息
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_vm_virus")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Virus implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 病毒名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 病毒类型
	 */
    @ManyToOne 
    @JoinColumn(name="typeid")
	private VirusType type;
	/**
	 * 首次发现时间
	 */
    @Column(name="first_find_time")
	private Timestamp firstFindTime;
	/**
	 * 末次发现时间
	 */
    @Column(name="last_find_time")
	private Timestamp lastFindTime;
	/**
	 * 病毒所在客户端
	 */
    @ManyToOne 
    @JoinColumn(name="virus_clients_id")
	private VirusClients virusClients;
	/**
	 * 备注
	 */
    @Column(name="remarks")
	private String remarks;
    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VirusType getType() {
		return type;
	}

	public void setType(VirusType type) {
		this.type = type;
	}

	public Timestamp getFirstFindTime() {
		return firstFindTime;
	}

	public void setFirstFindTime(Timestamp firstFindTime) {
		this.firstFindTime = firstFindTime;
	}

	public Timestamp getLastFindTime() {
		return lastFindTime;
	}

	public void setLastFindTime(Timestamp lastFindTime) {
		this.lastFindTime = lastFindTime;
	}

	public VirusClients getVirusClients() {
		return virusClients;
	}

	public void setVirusClients(VirusClients virusClients) {
		this.virusClients = virusClients;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
