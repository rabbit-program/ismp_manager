package edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog;

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

@Entity
@Table(name = "lm_dlog_pc_sensor")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Sensor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8515371956525995421L;

	/** 编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 委办局唯一标示
	 */
	@ManyToOne 
	@JoinColumn(name="domain")
	private Domain domain;
	
	/**
	 * 轮循采集时间间隔: 秒
	 */
	@Column(name = "interval_collect_time")
	private long intervalCollectTime;
	
	/**
	 * 该Sensor在TOPO上是否存在 :true 表示存在 false:表示不存在
	 */
	@Column(name="sensor_is_exist")
	private Boolean sensorIsExist;
	
	/**
	 * 该Sensor在TOPO上存在,但是否监听 :true 表示监听 false:表示不监听
	 */
	@Column(name="start_monitor_switch")
	private Boolean startMonitorSwitch;

	/**
	 * 该Sensor在TOPO上存在并监听,是否开始采集开关 :true 表示采集 false:表示不采集
	 */
	@Column(name="start_collect_switch")
	private Boolean startCollectSwitch;
	
	
//////////////////此以下都须manager-server提供/////////////////////////////	
	/**
	 * sensor自己产生的唯一标示符
	 */
	@Column(name = "sensor_sequence")
	private String sensorSequence;

	///////////////下面是Sensor所带的PC信息//////////////
	/**
	 * sensor_mac
	 */
	@Column(name = "sensor_mac")
	private String sensorMac;
	/**
	 * sensor_ip
	 */
	@Column(name = "sensor_ip")
	private String sensorIp;

	/**
	 * computer_name
	 */
	@Column(name = "computer_name")
	private String computerName;
	/**
	 * OS type
	 */
	@Column(name = "computer_os_type")
	private String computerOSType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getSensorSequence() {
		return sensorSequence;
	}
	public void setSensorSequence(String sensorSequence) {
		this.sensorSequence = sensorSequence;
	}
	public String getSensorMac() {
		return sensorMac;
	}
	public void setSensorMac(String sensorMac) {
		this.sensorMac = sensorMac;
	}
	public String getSensorIp() {
		return sensorIp;
	}
	public void setSensorIp(String sensorIp) {
		this.sensorIp = sensorIp;
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
	public long getIntervalCollectTime() {
		return intervalCollectTime;
	}
	public void setIntervalCollectTime(long intervalCollectTime) {
		this.intervalCollectTime = intervalCollectTime;
	}
	public Boolean getStartCollectSwitch() {
		return startCollectSwitch;
	}
	public void setStartCollectSwitch(Boolean startCollectSwitch) {
		this.startCollectSwitch = startCollectSwitch;
	}
	public Boolean getSensorIsExist() {
		return sensorIsExist;
	}
	public void setSensorIsExist(Boolean sensorIsExist) {
		this.sensorIsExist = sensorIsExist;
	}
	public Boolean getStartMonitorSwitch() {
		return startMonitorSwitch;
	}
	public void setStartMonitorSwitch(Boolean startMonitorSwitch) {
		this.startMonitorSwitch = startMonitorSwitch;
	}

}
