package edu.sjtu.infosec.ismp.manager.OSS.wom.web.form;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.ClientQuestion;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 界面层 派工单表单类.
 */

public class WorkOrderForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Integer id;
	/**
	 * 所属域
	 */
	private Integer domain;
	/**
	 * 编号
	 */
	private String sn;
	/**
	 * 处理人
	 */
	private Integer operator;
	/**
	 * 紧急程度
	 * 1、高
	 * 2、中
	 * 3、低
	 */
	private int level;
	/**
	 * 工单状态
	 * 1、未处理
	 * 2、处理中（通知相关处理人后，状态为处理中）
	 * 3、已处理（处理结束，并确认后，状态为已处理）
	 * 4、已关闭
	 * 5、未知
	 */
	private int state;
	/**
	 * 通知方式
	 * 1、短信
	 * 2、e_mail
	 * 3、短信和e_mail同时通知
	 */
	private int[] noticeWays;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 问题标题
	 */
	private String name;
	/**
	 * 问题描述
	 */
	private String desc;
	/**
	 * 问题来源
	 */
	private String source;
	/**
	 * 服务地址
	 */
	private String serverUrl;
	/**
	 * 问题提交人
	 */
	private String linkman;
	/**
	 * 问题提交人联系方式
	 */
	private String contactInfo;
	/**
	 * 问题备注
	 */
	private String remark;
	/**
	 * 编号
	 */
	private String q_sn;
	/**
	 * sensorId
	 */
	private String sensorId;
	/**
	 * 是否为后台传过来的问题
	 * 0、不是
	 * 1、是
	 */
	private int isNew;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDomain() {
		return domain;
	}
	public void setDomain(Integer domain) {
		this.domain = domain;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
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

	public int[] getNoticeWays() {
		return noticeWays;
	}
	public void setNoticeWays(int[] noticeWays) {
		this.noticeWays = noticeWays;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getQ_sn() {
		return q_sn;
	}
	public void setQ_sn(String q_sn) {
		this.q_sn = q_sn;
	}
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	public int getIsNew() {
		return isNew;
	}
	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}
	
}
