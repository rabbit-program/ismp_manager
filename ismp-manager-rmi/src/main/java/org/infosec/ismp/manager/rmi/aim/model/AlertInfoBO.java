package org.infosec.ismp.manager.rmi.aim.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "aim_alert")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AlertInfoBO  implements Serializable{
	
	private static final long serialVersionUID = 7353900337905541816L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; //主键ID 唯一标示数据
	
	@Column(name="time")
	private Timestamp time;//告警时间
	
	@Column(name="nodeid")//节点
	private Long nodeid;
	
	@Column(name="type")	//模块名
	private String type;
	
	@Column(name="level")
	private Integer level;//优先级、告警级别
	
	@Column(name="alerttype")
	private String alertType; //告警类型：设备告警，阈值告警，服务检测，事件告警，Syslog告警
	
	@Column(name="alertsubtype")//告警子类型
	private String alertSubType;	// CPU,MEMORY,HARDDISK,INTERFACE
	
	@Column(name="alertreason")
	private String alertReason;//告警原因
	
	@Column(name="srcip")
	private String srcIP;//源IP
	
	
	//告警内容 原始信息
	@Column(name="rawcontent" ,length=5000)
	private String rawContent; 
	
	@Column(name="status")
	private Integer status;
	//所触发的告警规则ID
	@Column(name="rule")
	private String rule;
	//是否归并
	@Column(name="fusion")
    private String fusioin;
    //标示是否为新创建
    @Column(name="ifnew")
    private Integer ifnew;
    
    @Column(name="alertIdentity")
	private String alertIdentity;
    //部门ID、域
    @Column(name="domain_id")
	private Integer domain_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Long getNodeid() {
		return nodeid;
	}
	public void setNodeid(Long nodeid) {
		this.nodeid = nodeid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getAlertType() {
		return alertType;
	}
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}
	public String getAlertSubType() {
		return alertSubType;
	}
	public void setAlertSubType(String alertSubType) {
		this.alertSubType = alertSubType;
	}
	public String getAlertReason() {
		return alertReason;
	}
	public void setAlertReason(String alertReason) {
		this.alertReason = alertReason;
	}
	public String getSrcIP() {
		return srcIP;
	}
	public void setSrcIP(String srcIP) {
		this.srcIP = srcIP;
	}
	public String getRawContent() {
		return rawContent;
	}
	public void setRawContent(String rawContent) {
		this.rawContent = rawContent;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getFusioin() {
		return fusioin;
	}
	public void setFusioin(String fusioin) {
		this.fusioin = fusioin;
	}
	public Integer getIfnew() {
		return ifnew;
	}
	public void setIfnew(Integer ifnew) {
		this.ifnew = ifnew;
	}
	public String getAlertIdentity() {
		return alertIdentity;
	}
	public void setAlertIdentity(String alertIdentity) {
		this.alertIdentity = alertIdentity;
	}
	public Integer getDomain_id() {
		return domain_id;
	}
	public void setDomain_id(Integer domainId) {
		domain_id = domainId;
	}
	
}
