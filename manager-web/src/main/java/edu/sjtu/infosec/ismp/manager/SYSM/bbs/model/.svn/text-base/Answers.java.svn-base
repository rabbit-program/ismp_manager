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
@Table(name = "bbs_answers")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Answers {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 回帖人
	 */
    @ManyToOne 
    @JoinColumn(name="user_id")
	private User answerer;
	/**
	 * 所属帖子
	 */
    @ManyToOne 
    @JoinColumn(name="questions_id")
	private Questions questions;
	/**
	 * 回复内容
	 */
    @Column(name="a_details")
	private String a_details;
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
	public User getAnswerer() {
		return answerer;
	}
	public void setAnswerer(User answerer) {
		this.answerer = answerer;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	public String getA_details() {
		return a_details;
	}
	public void setA_details(String a_details) {
		this.a_details = a_details;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
