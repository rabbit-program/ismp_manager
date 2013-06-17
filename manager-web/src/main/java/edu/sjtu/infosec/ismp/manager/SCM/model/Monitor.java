package edu.sjtu.infosec.ismp.manager.SCM.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.sjtu.infosec.ismp.security.Domain;

@Entity
@Table(name = "scm_monitor")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class Monitor  {
	
	/**
     * 主键id
     **/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id; 
	
	/**
     * 监控机类型
     **/
	@Column(name = "type", nullable = false)
	private String type;
	
	/**
	 * 监控机子类型
	 */
	@Column(name = "sub_type")
	private String subType;
	
	/**
	 * 检测项目名称
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * 检测项目描述
	 */
	@Column(name = "description")
	private String description;
	
	/**
	 * 所属域
	 */
	@ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
    
    /**
     * 所在域name
     **/
    @Column(name="domain_name")
    private String domainName;
    
    /**
	 * nodeId对应拓扑管理
	 */
    @Column(name="node_id",length = 500)
	private String nodeId;
    
    /**
     * 告警附文
     **/
    @Column(name="admonitory_text")
    private String admonitoryText;
    
    /**
     * 超时时间
     **/
    @Column(name="timeout")
    private Integer timeout;
    
    /**
     * 重试次数
     **/
    @Column(name="retry")
    private Integer retry;
    
    /**
     * 监控地址
     **/
    @Column(name="url")
    private String url;
    
    /**
     * IP地址
     **/
    @Column(name="ip")
    private String ip;
    
    /**
     * 端口
     **/
    @Column(name="port")
    private String port;
    
    /**
     * 用户名
     **/
    @Column(name="userid")
    private String userid;
    
    /**
     * 密码
     **/
    @Column(name="password")
    private String password;
    
    /**
     * 版本号
     **/
    @Column(name="version")
    private String version;
    
    /**
     * 团体名
     **/
    @Column(name="community")
    private String community;
    
    /**
     * 检测时间间隔
     **/
    @Column(name="interval_time")
    private Integer intervalTime;
    
    /**
     * 是否日检测
     **/
    @Column(name="isdaycheck")
    private String isdaycheck;
    
    /**
     * 开始时间
     **/
    @Column(name="begin_hour")
    private String beginHour;
    
    /**
     * 结束时间
     **/
    @Column(name="end_hour")
    private String endHour;
    
    /**
     * 是否周检测
     **/
    @Column(name="isweekcheck")
    private String isweekcheck;
    
    /**
     * 周检测时间
     **/
    @Column(name="weekcheck")
    private String weekcheck;
    
    /**
     * 检测连续失败次数
     **/
    @Column(name="checkfailcount")
    private Integer checkfailcount;
    
    /**
     * 告警优先级
     **/
    @Column(name="event_priority")
    private String eventPriority;
    
    /**
     * 创建时间
     **/
    @Column(name="create_time")
    private Timestamp createTime;
    
    /**
	 * 状态
	 * 0：失败
	 * 1：成功
	 */
    @Column(name="online_state")
	private Integer onlineState;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getAdmonitoryText() {
		return admonitoryText;
	}

	public void setAdmonitoryText(String admonitoryText) {
		this.admonitoryText = admonitoryText;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Integer getRetry() {
		return retry;
	}

	public void setRetry(Integer retry) {
		this.retry = retry;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public Integer getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Integer intervalTime) {
		this.intervalTime = intervalTime;
	}

	public String getIsdaycheck() {
		return isdaycheck;
	}

	public void setIsdaycheck(String isdaycheck) {
		this.isdaycheck = isdaycheck;
	}

	public String getBeginHour() {
		return beginHour;
	}

	public void setBeginHour(String beginHour) {
		this.beginHour = beginHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getIsweekcheck() {
		return isweekcheck;
	}

	public void setIsweekcheck(String isweekcheck) {
		this.isweekcheck = isweekcheck;
	}

	public String getWeekcheck() {
		return weekcheck;
	}

	public void setWeekcheck(String weekcheck) {
		this.weekcheck = weekcheck;
	}

	public Integer getCheckfailcount() {
		return checkfailcount;
	}

	public void setCheckfailcount(Integer checkfailcount) {
		this.checkfailcount = checkfailcount;
	}

	public String getEventPriority() {
		return eventPriority;
	}

	public void setEventPriority(String eventPriority) {
		this.eventPriority = eventPriority;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(Integer onlineState) {
		this.onlineState = onlineState;
	}
}