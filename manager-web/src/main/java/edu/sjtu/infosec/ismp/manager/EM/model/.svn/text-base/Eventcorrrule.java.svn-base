package edu.sjtu.infosec.ismp.manager.EM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "em_event_corr_rule")
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class Eventcorrrule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9188166105530813898L;

	/**
	 * 记录编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 关联规则名称
	 */
	@Column(name = "rule_name", length = 50, nullable = false)
	private String rule_name;

	/**
	 * 关联类型
	 */
	@Column(name = "corr_type", length = 1, nullable = false)
	private Byte corr_type;

	/**
	 * 协议规则，可能是一系列协议的组合
	 */
	@Column(name = "prot_rule", length = 100, nullable = false)
	private String prot_rule;

	/**
	 * 源IP规则，可能是一系列IP的组合
	 */
	@Column(name = "src_ip", length = 100, nullable = false)
	private String src_ip;

	/**
	 * 目的IP规则，可能是一系列IP的组合
	 */
	@Column(name = "dest_ip", length = 100, nullable = false)
	private String dest_ip;

	/**
	 * 目的端口规则，可能是一系列端口的组合
	 */
	@Column(name = "dest_port", length = 100, nullable = false)
	private String dest_port;

	/**
	 * 操作，如编辑、删除等，不同的数字表示不同的操作
	 */
	@Column(name = "operation", length = 1)
	private Byte operation;
	
	/**
	 * 用户
	 */
	@Column(name = "user_name", length = 20)
	private String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRule_name() {
		return rule_name;
	}

	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}

	public Byte getCorr_type() {
		return corr_type;
	}

	public void setCorr_type(Byte corr_type) {
		this.corr_type = corr_type;
	}

	public String getProt_rule() {
		return prot_rule;
	}

	public void setProt_rule(String prot_rule) {
		this.prot_rule = prot_rule;
	}

	public String getSrc_ip() {
		return src_ip;
	}

	public void setSrc_ip(String src_ip) {
		this.src_ip = src_ip;
	}

	public String getDest_ip() {
		return dest_ip;
	}

	public void setDest_ip(String dest_ip) {
		this.dest_ip = dest_ip;
	}

	public String getDest_port() {
		return dest_port;
	}

	public void setDest_port(String dest_port) {
		this.dest_port = dest_port;
	}

	public Byte getOperation() {
		return operation;
	}

	public void setOperation(Byte operation) {
		this.operation = operation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	} 
	
}
