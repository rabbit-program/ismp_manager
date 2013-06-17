package edu.sjtu.infosec.ismp.manager.VPM.vm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 病毒客户端
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_vm_rav_clients")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class VirusClients implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 病毒客户端自定义名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 病毒客户端主机名称
	 */
    @Column(name="client_name")
	private String clientName;
	/**
	 * 病毒客户端ID
	 */
    @Column(name="client_id")
	private String clientID;
	/**
	 * 病毒客户端IP
	 */
    @Column(name="client_ip")
	private String clientIP;
	/**
	 * 病毒客户端端口
	 */
    @Column(name="client_port")
	private int clientPort;
	/**
	 * 病毒客户端版本
	 */
    @Column(name="client_version")
	private String clientVersion;
	/**
	 * 病毒客户端状态
	 */
    @Column(name="client_state")
	private int clientState;
	/**
	 * 病毒客户端最近注册时间
	 */
    @Column(name="client_last_register_time")
	private Timestamp clientLastRegisterTime;
	/**
	 * 录入时间
	 */
    @Column(name="record_time")
	private Timestamp recordTime;
	/**
	 * 关联的资产
	 */
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "asset_device_id")
	private AssetDeviceBO assetDevice;
	/**
	 * 关联的部门
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain department;
	/**
	 * 备注
	 */
    @Column(name="remarks")
	private String remarks;
	
	//非数据库字段，临时使用
	@Transient
	private String groupName;
	
	@Transient
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
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
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientIP() {
		return clientIP;
	}
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	public int getClientPort() {
		return clientPort;
	}
	public void setClientPort(int clientPort) {
		this.clientPort = clientPort;
	}
	public String getClientVersion() {
		return clientVersion;
	}
	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}
	public int getClientState() {
		return clientState;
	}
	public void setClientState(int clientState) {
		this.clientState = clientState;
	}
	public Timestamp getClientLastRegisterTime() {
		return clientLastRegisterTime;
	}
	public void setClientLastRegisterTime(Timestamp clientLastRegisterTime) {
		this.clientLastRegisterTime = clientLastRegisterTime;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
	public AssetDeviceBO getAssetDevice() {
		return assetDevice;
	}
	public void setAssetDevice(AssetDeviceBO assetDevice) {
		this.assetDevice = assetDevice;
	}
	public Domain getDepartment() {
		return department;
	}
	public void setDepartment(Domain department) {
		this.department = department;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
