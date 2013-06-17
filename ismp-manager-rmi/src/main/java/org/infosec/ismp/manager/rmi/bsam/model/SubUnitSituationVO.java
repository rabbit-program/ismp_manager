package org.infosec.ismp.manager.rmi.bsam.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 子单位态势表VO类.
 * Author：cchang
 * 2010-9-21 下午02:22:46
 */
public class SubUnitSituationVO implements Serializable {

	private static final long serialVersionUID = 2354594485086190589L;

	private Integer id;
    
    /**
     * 时间
     **/
    private Timestamp time;
	
    /**
     * 名称
     **/
    private String name;
    
    /**
     * 类型
     **/
    private String type;
    
    /**
     * 攻击威胁
     **/
    private Float attackThreat;
    
    /**
     * 病毒疫情
     **/
    private Float virusCondition;
    
    /**
     * 非法连接
     **/
    private Float invalidConnection;
    
    /**
     * 整体态势
     **/
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
