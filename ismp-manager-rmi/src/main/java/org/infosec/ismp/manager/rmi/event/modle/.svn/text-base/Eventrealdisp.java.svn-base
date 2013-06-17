package org.infosec.ismp.manager.rmi.event.modle;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Eventmoni entity.
 * 
 * 事件实时显示表，表中记录来自安全设备的经过预处理后的事件，每个元组是对一个事件信息的记录。
 * 
 * 	**设备类型必不可少**
 * @author 林超 2010-11-18
 */
@Entity
@Table(name = "em_event_real_disp")
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class Eventrealdisp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -901827982620986301L;

	/**
	 * 记录编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 事件时间
	 */
	@Column(name = "event_time", nullable = false)
	private Timestamp eventTime;

	/**
	 * 事件源IP地址
	 */
	@Column(name = "src_ip", length = 20, nullable = false)
	private String srcIp;

	/**
	 * 事件源端口
	 */
	@Column(name = "src_port", length = 4)
	private Integer srcPort;

	/**
	 * 事件目的IP
	 */
	@Column(name = "dest_ip", length = 20, nullable = false)
	private String destIp;

	/**
	 * 事件目的端口
	 */
	@Column(name = "dest_port", length = 4)
	private Integer destPort;

	/**
	 * 事件的威胁等级
	 */
	@Column(name = "thre_rank", length = 1, nullable = false)
	private Integer threRank;

	/**
	 * 安全设备IP，唯一标识一个设备
	 */
	@Column(name = "faci_ip", length = 20, nullable = false)
	private String faciIp;

	/**
	 * 安全设备类型
	 */
	@Column(name = "faci_type", length = 10, nullable = false)
	private String faciType;

	/**
	 * 事件类型
	 */
	@Column(name = "event_type", length = 10, nullable = false)
	private String eventType;

	/**
	 * 协议类型
	 */
	@Column(name = "prot_type", length = 10)
	private String protType;

	/**
	 * 事件描述
	 */
	@Column(name = "descrip", length = 1024)
	private String descrip;

	/**
	 * 域 
	 */
	@Column(name="domain")
	private String domain;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getEventTime() {
		return eventTime;
	}

	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
	}

	public String getSrcIp() {
		return srcIp;
	}

	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}

	public Integer getSrcPort() {
		return srcPort;
	}

	public void setSrcPort(Integer srcPort) {
		this.srcPort = srcPort;
	}

	public String getDestIp() {
		return destIp;
	}

	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}

	public Integer getDestPort() {
		return destPort;
	}

	public void setDestPort(Integer destPort) {
		this.destPort = destPort;
	}

	public Integer getThreRank() {
		return threRank;
	}

	public void setThreRank(Integer threRank) {
		this.threRank = threRank;
	}

	public String getFaciIp() {
		return faciIp;
	}

	public void setFaciIp(String faciIp) {
		this.faciIp = faciIp;
	}

	public String getFaciType() {
		return faciType;
	}

	public void setFaciType(String faciType) {
		this.faciType = faciType;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public String getProtType() {
		return protType;
	}

	public void setProtType(String protType) {
		this.protType = protType;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
