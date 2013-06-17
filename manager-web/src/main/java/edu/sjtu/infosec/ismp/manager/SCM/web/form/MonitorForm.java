package edu.sjtu.infosec.ismp.manager.SCM.web.form;

import org.apache.struts.action.ActionForm;

public class MonitorForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4073799300081283760L;
	
	private Integer id;///主键
	
	private String type;///监控机类型
	
	private String subType;///监控机子类型
	
	private String name;///检测项目名称
	
	private String description;///检测项目描述
	
	private Integer domainId;///域id
	
	private String domainName;///域name
	
	private String admonitoryText;///告警附文
	
	private Integer timeout;///超时时间
	
	private Integer retry;///重试次数
	
	private String url;///监控地址

	private String ip;///IP地址
	
    private String port;//端口号
    
    private String userid;///用户名
    
    private String password;///密码
    
    private String version;///版本号
    
    private String community;///团体名
    
    private Integer intervalTime;///检测时间间隔
    
    private String isdaycheck;///是否日检测
    
    private String beginHour;///开始时间
    
    private String endHour;///结束时间
    
    private String isweekcheck;///是否周检测
    
    private String[] weekcheck;//周检测时段
    
    private Integer checkfailcount;///检测连续失败次数
    
    private String eventPriority;///告警优先级
    
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

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
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
	
	public String[] getWeekcheck() {
		return weekcheck;
	}

	public void setWeekcheck(String[] weekcheck) {
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
	
	public void reset() {
		this.isdaycheck = null;
		this.isweekcheck = null;
		this.weekcheck = null;
		this.beginHour = "00:00";
		this.endHour = "00:00";
	}
}
