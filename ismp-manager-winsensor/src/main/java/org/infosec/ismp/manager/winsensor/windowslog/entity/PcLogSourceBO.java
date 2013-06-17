package org.infosec.ismp.manager.winsensor.windowslog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 11:03:14 AM
 *	Sensor日志源
 */
@Entity
@Table(name="lm_dlog_pc_sensor")
public class PcLogSourceBO implements Serializable {

	private static final long serialVersionUID = -8936505338736031595L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	/*
	 * 委办局id
	 */
	@Column(name="domain")
	private Integer domainId;
	
	/*
	 * 日志轮询采集间隔
	 */
	@Column(name="interval_collect_time")
	private long interval;
	
	/*
	 * 该日志源是否启用：true 启用， false 不启用。
	 * 对应于拓扑管理中的添加/删除设备。
	 */
	@Column(name="sensor_is_exist")
	private Boolean enable;
	
	/*
	 * 该日志源是否开启监控：true 开启，false 不启用。
	 * 对应于拓扑管理中的开启/暂停监控。
	 */
	@Column(name="start_monitor_switch")
	private Boolean startMonitor;

	/*
	 * 是否采集日志信息：true 采集，false 不采集。
	 */
	@Column(name="start_collect_switch")
	private Boolean startCollectSwitch;
	
	/*
	 * Sensor unique identify.
	 */
	@Column(name="sensor_sequence")
	private String sensorId;
	
	/*
	 * Sensor client ip address.
	 */
	@Column(name="sensor_ip")
	private String sensorIp;
	
	/*
	 * Sensor client mac address.
	 */
	@Column(name="sensor_mac")
	private String sensorMac;
	
	/*
	 * Sensor client computer name.
	 */
	@Column(name="computer_name")
	private String computerName;
	
	/*
	 * Sensor client computer OS type.
	 */
	@Column(name="computer_os_type")
	private String computerOSType;
	
	/*
	 * Sensor client info must be synchronized, example computer name, computer OS type.
	 * Synchronized: true, else false.
	 */
	@Column(name="is_synchronized")
	private Boolean isSynchronized;
	
	/*
	 * PcLogSource create time.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getStartMonitor() {
		return startMonitor;
	}

	public void setStartMonitor(Boolean startMonitor) {
		this.startMonitor = startMonitor;
	}

	public Boolean getStartCollectSwitch() {
		return startCollectSwitch;
	}

	public void setStartCollectSwitch(Boolean startCollectSwitch) {
		this.startCollectSwitch = startCollectSwitch;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getSensorIp() {
		return sensorIp;
	}

	public void setSensorIp(String sensorIp) {
		this.sensorIp = sensorIp;
	}

	public String getSensorMac() {
		return sensorMac;
	}

	public void setSensorMac(String sensorMac) {
		this.sensorMac = sensorMac;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public String getComputerOSType() {
		return computerOSType;
	}

	public void setComputerOSType(String computerOSType) {
		this.computerOSType = computerOSType;
	}

	public Boolean getIsSynchronized() {
		return isSynchronized;
	}

	public void setIsSynchronized(Boolean isSynchronized) {
		this.isSynchronized = isSynchronized;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
