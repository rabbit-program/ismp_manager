package edu.sjtu.infosec.ismp.manager.VPM.vm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统中心端
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_vm_sys_center")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysCenter implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * centerID
	 */
    @Column(name="center_id")
	private String centerID;
	/**
	 * 父centerID
	 */
    @Column(name="parent_center_id")
	private String parentCenterID;
	/**
	 * center版本
	 */
    @Column(name="center_ver")
	private String centerVer;
	/**
	 * centerIP
	 */
    @Column(name="center_ip")
	private String centerIP;
	/**
	 * centerPort
	 */
    @Column(name="center_port")
	private int centerPort;
	/**
	 * 发送IP
	 */
    @Column(name="sender_ip")
	private String senderIP;
	/**
	 * 发送Port
	 */
    @Column(name="sender_port")
	private int senderPort;
	/**
	 * 接收IP
	 */
    @Column(name="receiver_ip")
	private String receiverIP;
	/**
	 * 接收Port
	 */
    @Column(name="receiver_port")
	private int receiverPort;
	/**
	 * 最后注册时间
	 */
    @Column(name="last_register")
	private Timestamp lastRegister;
	/**
	 * 未知
	 */
    @Column(name="active")
	private int active;
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
	public String getCenterID() {
		return centerID;
	}
	public void setCenterID(String centerID) {
		this.centerID = centerID;
	}
	public String getParentCenterID() {
		return parentCenterID;
	}
	public void setParentCenterID(String parentCenterID) {
		this.parentCenterID = parentCenterID;
	}
	public String getCenterVer() {
		return centerVer;
	}
	public void setCenterVer(String centerVer) {
		this.centerVer = centerVer;
	}
	public String getCenterIP() {
		return centerIP;
	}
	public void setCenterIP(String centerIP) {
		this.centerIP = centerIP;
	}
	public int getCenterPort() {
		return centerPort;
	}
	public void setCenterPort(int centerPort) {
		this.centerPort = centerPort;
	}
	public String getSenderIP() {
		return senderIP;
	}
	public void setSenderIP(String senderIP) {
		this.senderIP = senderIP;
	}
	public int getSenderPort() {
		return senderPort;
	}
	public void setSenderPort(int senderPort) {
		this.senderPort = senderPort;
	}
	public String getReceiverIP() {
		return receiverIP;
	}
	public void setReceiverIP(String receiverIP) {
		this.receiverIP = receiverIP;
	}
	public int getReceiverPort() {
		return receiverPort;
	}
	public void setReceiverPort(int receiverPort) {
		this.receiverPort = receiverPort;
	}
	public Timestamp getLastRegister() {
		return lastRegister;
	}
	public void setLastRegister(Timestamp lastRegister) {
		this.lastRegister = lastRegister;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
