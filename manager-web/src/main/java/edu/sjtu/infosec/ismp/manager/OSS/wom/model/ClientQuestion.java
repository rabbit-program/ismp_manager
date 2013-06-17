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

import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 客户端问题
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "oss_wom_client_question")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ClientQuestion implements Serializable {
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
	 * 是否为后台传过来的问题
	 * 0、不是
	 * 1、是
	 */
    @Column(name="is_new")
	private Integer isNew;
	/**
	 * 编号
	 */
    @Column(name="sn")
	private String sn;
	/**
	 * sensorId
	 */
    @Column(name="sensor_id")
	private String sensorId;
	/**
	 * 问题标题
	 */
    @Column(name="name")
	private String name;
	/**
	 * 问题描述
	 */
    @Column(name="description")
	private String desc;
	/**
	 * 问题来源
	 */
    @Column(name="question_source")
	private String source;
	/**
	 * 服务地址
	 */
    @Column(name="server_url")
	private String serverUrl;
	/**
	 * 问题提交人
	 */
    @Column(name="linkman")
	private String linkman;
	/**
	 * 问题提交人联系方式
	 */
    @Column(name="contact_info")
	private String contactInfo;
	/**
	 * 问题状态
	 * 1、未处理
	 * 2、处理中
	 * 3、已处理
	 * 4、已关闭
	 * 5、未知
	 */
    @Column(name="state")
	private int state;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 备注
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
	public Integer getIsNew() {
		return isNew;
	}
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getSensorId() {
		return sensorId;
	}
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
