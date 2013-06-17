package org.infosec.ismp.situation.model;

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
 * 主机态势表类.
 * Author：cchang
 * 2010-9-21 下午02:22:46
 */
@Entity
@Table(name = "bsam_machine_situation")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class MachineSituation implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8431438429857422102L;

	/**
     * 主键id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    /**
     * 时间
     **/
    @Column(name="time", nullable = false)
    private Timestamp time;
	
    /**
     * 主机IP
     **/
    @Column(name="ip", length = 100, nullable = false)
    private String ip;
    
    /**
     * 主机
     **/
    @ManyToOne 
    @JoinColumn(name="machine_id", nullable = false)
    private Machine machine;
    
    /**
     * 攻击威胁
     **/
    @Column(name="attack_threat")
    private Float attackThreat;
    
    /**
     * 病毒疫情
     **/
    @Column(name="virus_condition")
    private Float virusCondition;
    
    /**
     * 非法连接
     **/
    @Column(name="invalid_connection")
    private Float invalidConnection;
    
    /**
     * 整体态势
     **/
    @Column(name="whole_situation")
    private Float wholeSituation;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Float getAttackThreat() {
		return attackThreat;
	}

	public void setAttackThreat(Float attackThreat) {
		this.attackThreat = attackThreat;
	}

	public Float getVirusCondition() {
		return virusCondition;
	}

	public void setVirusCondition(Float virusCondition) {
		this.virusCondition = virusCondition;
	}

	public Float getInvalidConnection() {
		return invalidConnection;
	}

	public void setInvalidConnection(Float invalidConnection) {
		this.invalidConnection = invalidConnection;
	}

	public Float getWholeSituation() {
		return wholeSituation;
	}

	public void setWholeSituation(Float wholeSituation) {
		this.wholeSituation = wholeSituation;
	}

}
