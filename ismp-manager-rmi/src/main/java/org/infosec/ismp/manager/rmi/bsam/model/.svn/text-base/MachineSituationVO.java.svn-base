package org.infosec.ismp.manager.rmi.bsam.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 主机态势表VO类.
 * Author：cchang
 * 2010-9-21 下午02:22:46
 */
public class MachineSituationVO implements Serializable {

	private static final long serialVersionUID = 563805876004465829L;

    private Integer id;
    
    /**
     * 时间
     **/
    private Timestamp time;
	
    /**
     * 主机IP
     **/
    private String ip;
    
    /**
     * 主机名称
     **/
    private String machineName;
    
    /**
     * 主机描述
     */
    private String machineDescription;
    
    /**
     * 上级物理位置类型
     */
    private String parentType;
    
    /**
     * 上级物理位置
     */
    private String parentName;
    
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getMachineDescription() {
		return machineDescription;
	}

	public void setMachineDescription(String machineDescription) {
		this.machineDescription = machineDescription;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
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
    
	///重写equals方法    IP和machineName相同就表示此对象相同。
	///为了在取前20名态势时去除重复的.(List的contains方法自动调用)
	public boolean equals(final Object other) {
		if (!(other instanceof MachineSituationVO))
			return false;
		MachineSituationVO castOther = (MachineSituationVO) other;
		return new EqualsBuilder().append(ip, castOther.ip).append(machineName, castOther.machineName).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(ip).append(machineName).toHashCode();
	}
}
