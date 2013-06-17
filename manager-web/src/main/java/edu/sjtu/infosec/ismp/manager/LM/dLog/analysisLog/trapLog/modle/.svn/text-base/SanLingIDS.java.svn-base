package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.modle;

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

import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 用于存放SanLingIDS的解析后日志
 * @author 林超
 *
 */
@Entity
@Table(name = "lm_dlog_snmptrap_sanling_ids")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SanLingIDS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 362332797132121580L;
	/** 编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 事件源IP地址
	 */
	@Column(name = "source_ip")
	private String sourceIp;

	/**
	 * 事件源端口
	 */
	@Column(name = "source_port")
	private Integer sourcePort;

	/**
	 * 事件目的IP
	 */
	@Column(name = "dest_ip")
	private String destIp; // 目的IP

//	/**
//	 * 安全设备类型
//	 */
//	@Column(name = "facilityType")
//	private String facilityType; // 设备类型

	/**
	 * 安全事件类型
	 */
	@Column(name = "event_type")
	private String eventType; // 事件类型

	/**
	 * 协议类型
	 */
	@Column(name = "protocol_type")
	private String protocolType; // 协议类型

	/**
	 * 对事件的描述
	 */
	@Column(name = "descrip", length = 2000)
	private String descrip; // 描述

	/**
	 * 事件目的端口
	 */
	@Column(name = "dest_port")
	private Integer destPort; // 目的端口

	/**
	 * 事件威胁等级
	 */
	@Column(name = "threaten_rank")
	public Integer threatenRank; // 事件威胁等级

	/**
	 * 事件时间
	 */
	@Column(name = "event_time")
	private Timestamp eventTime;

	/**
	 * 安全设备IP，唯一标识一个设备
	 */
	@Column(name = "facility_ip")
	private String facilityIp; // 设备IP

	/**
	 * 对应的采集源的sequence
	 */
	@Column(name = "log_source_sequence")
	private String logSourceSequence;
	
	@ManyToOne
	@JoinColumn(name="domain")
	private Domain domain;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public Integer getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(Integer sourcePort) {
		this.sourcePort = sourcePort;
	}

	public String getDestIp() {
		return destIp;
	}

	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}
//
//	public String getFacilityType() {
//		return facilityType;
//	}
//
//	public void setFacilityType(String facilityType) {
//		this.facilityType = facilityType;
//	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Integer getDestPort() {
		return destPort;
	}

	public void setDestPort(Integer destPort) {
		this.destPort = destPort;
	}

	public Integer getThreatenRank() {
		return threatenRank;
	}

	public void setThreatenRank(Integer threatenRank) {
		this.threatenRank = threatenRank;
	}

	public Timestamp getEventTime() {
		return eventTime;
	}

	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
	}

	public String getFacilityIp() {
		return facilityIp;
	}

	public void setFacilityIp(String facilityIp) {
		this.facilityIp = facilityIp;
	}

	public String getLogSourceSequence() {
		return logSourceSequence;
	}

	public void setLogSourceSequence(String logSourceSequence) {
		this.logSourceSequence = logSourceSequence;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	
}
