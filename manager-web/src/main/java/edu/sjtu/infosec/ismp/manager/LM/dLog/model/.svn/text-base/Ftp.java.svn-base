package edu.sjtu.infosec.ismp.manager.LM.dLog.model;

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
 * Ftp 日志
 * @author Lin Chao
 * @date 2010-10-18
 * @version 1.0
 */
@Entity
@Table(name = "lm_dlog_ftp")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Ftp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2836626052111120953L;

	/** 编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 事件时间
	 */
	@Column(name = "event_time")
	private Timestamp eventTime;

	/**
	 * IP
	 */
	@Column(name = "cs_ip")
	private String csIp;

	/**
	 * 请求方法
	 */
	@Column(name = "cs_method")
	private String csMethod;

	/**
	 * 请求文件
	 */
	@Column(name = "cs_uri_stem")
	private String csUriStem;

	/**
	 * 状态
	 */
	@Column(name = "sc_status")
	private String scStatus;

	/**
	 * 采集代理到manager层注册的id
	 */
	@Column(name = "agent_id")
	private Integer agentId;
	
	/**
	 * 关联的部门的名字
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;

	/**
	 * 日志所属源IP
	 */
	@Column(name = "ftp_collect_source_ip")
	private String ftpCollectSourceIp;

	/**
	 * 对应的采集源的sequence
	 */
	@Column(name = "log_source_sequence")
	private String logSourceSequence;

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

	public String getCsIp() {
		return csIp;
	}

	public void setCsIp(String csIp) {
		this.csIp = csIp;
	}

	public String getCsMethod() {
		return csMethod;
	}

	public void setCsMethod(String csMethod) {
		this.csMethod = csMethod;
	}

	public String getCsUriStem() {
		return csUriStem;
	}

	public void setCsUriStem(String csUriStem) {
		this.csUriStem = csUriStem;
	}

	public String getScStatus() {
		return scStatus;
	}

	public void setScStatus(String scStatus) {
		this.scStatus = scStatus;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getFtpCollectSourceIp() {
		return ftpCollectSourceIp;
	}

	public void setFtpCollectSourceIp(String ftpCollectSourceIp) {
		this.ftpCollectSourceIp = ftpCollectSourceIp;
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
