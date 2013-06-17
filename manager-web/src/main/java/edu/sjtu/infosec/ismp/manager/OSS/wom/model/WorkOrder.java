package edu.sjtu.infosec.ismp.manager.OSS.wom.model;

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

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 派工单
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "oss_wom_work_order")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class WorkOrder implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属域
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
	/**
	 * 所属问题
	 */
    @ManyToOne 
    @JoinColumn(name="question_id")
	private ClientQuestion question;
	/**
	 * 编号
	 */
    @Column(name="sn")
	private String sn;
	/**
	 * 处理人
	 */
    @ManyToOne 
    @JoinColumn(name="operator_id")
	private Roster operator;
	/**
	 * 紧急程度
	 * 1、高
	 * 2、中
	 * 3、低
	 */
    @Column(name="level")
	private int level;
	/**
	 * 工单状态
	 * 1、未处理
	 * 2、处理中（通知相关处理人后，状态为处理中）
	 * 3、已处理（处理结束，并确认后，状态为已处理）
	 * 4、已关闭
	 * 5、未知
	 */
    @Column(name="state")
	private int state;
	/**
	 * 通知方式
	 * 1、短信
	 * 2、e_mail
	 * 3、短信和e_mail同时通知
	 */
    @Column(name="notice_way")
	private int noticeWay;
	/**
	 * 派工时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 结束时间
	 */
    @Column(name="end_time")
	private Timestamp endTime;
	/**
	 * 备注（保留字段，暂时不用）
	 */
    @Column(name="remark")
	private String remark;
    
    
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
	public ClientQuestion getQuestion() {
		return question;
	}
	public void setQuestion(ClientQuestion question) {
		this.question = question;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Roster getOperator() {
		return operator;
	}
	public void setOperator(Roster operator) {
		this.operator = operator;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getNoticeWay() {
		return noticeWay;
	}
	public void setNoticeWay(int noticeWay) {
		this.noticeWay = noticeWay;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
