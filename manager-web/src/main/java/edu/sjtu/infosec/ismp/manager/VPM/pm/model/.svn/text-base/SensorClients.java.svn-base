package edu.sjtu.infosec.ismp.manager.VPM.pm.model;

import java.io.Serializable;
import java.sql.Date;

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

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * Sensor客户端
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_pm_sensor_clients")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SensorClients implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * Sensor客户端自定义名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * SensorID
	 */
    @Column(name="sensor_id")
	private String sensorID;
	/**
	 * SensorIP
	 */
    @Column(name="sensor_ip")
	private String sensorIP;
	/**
	 * SensorMAC
	 */
    @Column(name="sensor_mac")
	private String sensorMAC;
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
	 * 补丁策略
	 */
    @ManyToOne 
    @JoinColumn(name="patch_update_tactics_id")
	private PatchUpdateTactics patchUpdateTactics;
	/**
	 * 关联时间
	 */
    @Column(name="operate_time")
	private Date operateTime;
	/**
	 * 已更新补丁数
	 */
    @Column(name="patch_ok_num")
	private int patchOkNum;
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
	public String getSensorID() {
		return sensorID;
	}
	public void setSensorID(String sensorID) {
		this.sensorID = sensorID;
	}
	public String getSensorIP() {
		return sensorIP;
	}
	public void setSensorIP(String sensorIP) {
		this.sensorIP = sensorIP;
	}
	public String getSensorMAC() {
		return sensorMAC;
	}
	public void setSensorMAC(String sensorMAC) {
		this.sensorMAC = sensorMAC;
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
	public PatchUpdateTactics getPatchUpdateTactics() {
		return patchUpdateTactics;
	}
	public void setPatchUpdateTactics(PatchUpdateTactics patchUpdateTactics) {
		this.patchUpdateTactics = patchUpdateTactics;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public int getPatchOkNum() {
		return patchOkNum;
	}
	public void setPatchOkNum(int patchOkNum) {
		this.patchOkNum = patchOkNum;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public SensorClients(Domain domain)
	{
		this.department=domain;
	}
	public SensorClients(){} 
}
