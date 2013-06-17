package edu.sjtu.infosec.ismp.manager.AIM.comm;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 封装alert查询条件VO
 * 
 * 作者:sxiaoquan
 * 
 * **/
public class AlertQueryVO implements Serializable {
	// 告警状态
	private Integer status;
	// 告警类型
	private String type;
	private String alertType;
	// 告警子类型
	private String alertSubType;
	/** ====================================================== **/
	// 告警开始ID 和结束ID
	private Integer beginId;
	private Integer endId;
	// 开始ID 和结束ID 界面用
	private String beginIdpage;
	private String endIdpage;
	/** ====================================================== **/

	// 告警开始结束时间
	private Timestamp beginDate;
	private Timestamp endDate;
	private String beginDatepage;
	private String endDatepage;

	// 告警优先级开始 到结束
	private Integer beginPriority;
	private Integer endPriority;
	private String beginPrioritypage;
	private String endPrioritypage;

	// NodeId
	private String nodeId;
	// 目标地址
//	private String target;
	// 源地址
	private String srcIp;	
	// 触发时间	
	private Timestamp touchoffDate;
	private String touchoffDatepage;
	// 原始内容
	private String rawContent;
	
	private String alertReason;
	
	//归并的时间差
	private String fusiontimepage;
	//时间分钟差
	private Long timedifference;
 
    //是否新告警信息
	private Integer ifnew;

	//登录时间用来判断检查这段时间内的告警信息
	private String logintime;

	
	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public Integer getIfnew() {
		return ifnew;
	}

	public void setIfnew(Integer ifnew) {
		this.ifnew = ifnew;
	}

	public String getFusiontimepage() {
		return fusiontimepage;
	}

	public void setFusiontimepage(String fusiontimepage) {
		if(fusiontimepage.equals("")){
			this.setTimedifference(null);			
		}else{
			this.setTimedifference(Long.parseLong(fusiontimepage));
		}
		this.fusiontimepage = fusiontimepage;
	}

	public Long getTimedifference() {
		return timedifference;
	}

	public void setTimedifference(Long timedifference) {
		this.timedifference = timedifference;
	}

	public String getTouchoffDatepage() {
		return touchoffDatepage;
	}

	public void setTouchoffDatepage(String touchoffDatepage) {
		if(touchoffDatepage.equals("")){
			this.setTouchoffDate(null);
		}else{
			this.setTouchoffDate(Timestamp.valueOf(touchoffDatepage));
		}
		this.touchoffDatepage = touchoffDatepage;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Integer getBeginId() {
		return beginId;
	}

	public void setBeginId(Integer beginId) {
		this.beginId = beginId;
	}

	public Integer getEndId() {
		return endId;
	}

	public void setEndId(Integer endId) {
		this.endId = endId;
	}

	public Integer getBeginPriority() {
		return beginPriority;
	}

	public void setBeginPriority(Integer beginPriority) {
		this.beginPriority = beginPriority;
	}

	public Integer getEndPriority() {
		return endPriority;
	}

	public void setEndPriority(Integer endPriority) {
		this.endPriority = endPriority;
	}

	public Timestamp getTouchoffDate() {
		return touchoffDate;
	}

	public void setTouchoffDate(Timestamp touchoffDate) {
		this.touchoffDate = touchoffDate;
	}

	public String getRawContent() {
		return rawContent;
	}

	public void setRawContent(String rawContent) {
		this.rawContent = rawContent;
	}

	public String getAlertReason() {
		return alertReason;
	}

	public void setAlertReason(String alertReason) {
		this.alertReason = alertReason;
	}

	public String getBeginIdpage() {
		return beginIdpage;
	}

	public void setBeginIdpage(String beginIdpage) {
		if (beginIdpage.equals("")) {
			this.setBeginId(null);
		} else {
			this.setBeginId(Integer.parseInt(beginIdpage));
		}
		this.beginIdpage = beginIdpage;
	}

	public String getEndIdpage() {
		return endIdpage;
	}

	public void setEndIdpage(String endIdpage) {
		if (endIdpage.equals("")) {
			this.setEndId(null);
		} else {
			this.setEndId(Integer.parseInt(endIdpage));
		}
		this.endIdpage = endIdpage;
	}

	public String getBeginDatepage() {
		return beginDatepage;
	}

	public void setBeginDatepage(String beginDatepage) {
		if (beginDatepage.equals("")) {
			this.setBeginDate(null);
		} else {
			this.setBeginDate(Timestamp.valueOf(beginDatepage));
		}
		this.beginDatepage = beginDatepage;
	}

	public Timestamp getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getEndDatepage() {
		return endDatepage;
	}

	public void setEndDatepage(String endDatepage) {
		if (endDatepage.equals("")) {
			this.setEndDate(null);
		} else {
			this.setEndDate(Timestamp.valueOf(endDatepage));
		}
		this.endDatepage = endDatepage;
	}

	public String getBeginPrioritypage() {
		return beginPrioritypage;
	}

	public void setBeginPrioritypage(String beginPrioritypage) {
		if (beginPrioritypage.equals("")) {
			this.setBeginPriority(null);
		} else {
			this.setBeginPriority(Integer.parseInt(beginPrioritypage));
		}
		this.beginPrioritypage = beginPrioritypage;
	}

	public String getEndPrioritypage() {
		return endPrioritypage;
	}

	public void setEndPrioritypage(String endPrioritypage) {
		if (endPrioritypage.equals("")) {
			this.setEndPriority(null);
		} else {
			this.setEndPriority(Integer.parseInt(endPrioritypage));
		}
		this.endPrioritypage = endPrioritypage;
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

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getSrcIp() {
		return srcIp;
	}

	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}
	
	

}
