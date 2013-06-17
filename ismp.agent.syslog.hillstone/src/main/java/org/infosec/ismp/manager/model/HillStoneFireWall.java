package org.infosec.ismp.manager.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用于存放HillStoneFireWall的解析后日志
 * @author 林超
 *
 */
@Entity
@Table(name = "lm_dlog_syslog_hillstone_firewall")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class HillStoneFireWall implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4772328947423299978L;
	
	/**
	 * 业务ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 时间
	 */
	@Column(name="timestamp")
	private Timestamp timestamp;
	
	/**
	 * 设备名
	 */
	@Column(name="hostname")
	private String hostname;
	
	/**
	 * 设备IP
	 */
	@Column(name="ipaddr")
	private String ipaddr;
	
	/**
	 * 消息类型:FLOW--网络流量
	 */
	@Column(name="messageType")
	private String messageType;
	
	/**
	 * 源IP
	 */
	@Column(name="srcip")
	private String srcip;
	
	/**
	 * 源端口
	 */
	@Column(name="srcport")
	private String srcport;
	
	/**
	 * 目标IP
	 */
	@Column(name="destip")
	private String destip;
	
	/**
	 * 目标端口
	 */
	@Column(name="destport")
	private String destport;
	
	/**
	 * 协议类型
	 */
	@Column(name="protocol")
	private String protocol;
	
	/**
	 * 消息内容)----放无法分析的部分
	 */
	@Column(name="msg",length=2000)
	private String msg;
	
	/**
	 * 域
	 */
	@Column(name="domain")
	private String domain;
	
	/**
	 * 严重性
	 */
	@Column(name="severity")
	private Integer severity;
	
	/**
	 * 日志所产生的模块
	 */

	@Column(name="facility")
	private Integer facility;
	
	/**
	 * 日志源唯一标识
	 */
	@Column(name="log_sourcese_quence")
	private String logSourceseQuence;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSrcip() {
		return srcip;
	}

	public void setSrcip(String srcip) {
		this.srcip = srcip;
	}

	public String getSrcport() {
		return srcport;
	}

	public void setSrcport(String srcport) {
		this.srcport = srcport;
	}

	public String getDestip() {
		return destip;
	}

	public void setDestip(String destip) {
		this.destip = destip;
	}

	public String getDestport() {
		return destport;
	}

	public void setDestport(String destport) {
		this.destport = destport;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getLogSourceseQuence() {
		return logSourceseQuence;
	}

	public void setLogSourceseQuence(String logSourceseQuence) {
		this.logSourceseQuence = logSourceseQuence;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public Integer getFacility() {
		return facility;
	}

	public void setFacility(Integer facility) {
		this.facility = facility;
	}
	
}
