package edu.sjtu.infosec.ismp.manager.SYSM.bbs.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.sjtu.infosec.ismp.security.User;

/**
 * 系统配置-BBS-
 * @author Wu Guojie
 * @date 2011-4-2
 * @version 1.0
 */
@Entity
@Table(name = "bbs_questions")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Questions {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 发帖人
	 */
    @ManyToOne 
    @JoinColumn(name="user_id")
	private User sender;
	/**
	 * 标题
	 */
    @Column(name="q_title")
	private String q_title;
	/**
	 * 内容
	 */
    @Column(name="q_details")
	private String q_details;
	/**
	 * IP
	 */
    @Column(name="ip")
	private String ip;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 最后修改时间
	 */
    @Column(name="update_time")
	private Timestamp updateTime;
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
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_details() {
		return q_details;
	}
	public void setQ_details(String q_details) {
		this.q_details = q_details;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
