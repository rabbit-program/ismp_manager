package edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition;

import java.util.Date;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;


/**
 * Eventmoniinfo的查询条件
 * @author wudengke 2009-6-29
 *
 */
public class EventmoniinfoCondition {
	
	//查询起始时间
	private Date startTime;
	
	//查询结束时间
	private Date endTime;
	
	//事件类型（指CPU、MEMORY、HARDDISK等等
	private String eventType;
	
	//设备IP地址
	private String ipAddress;
	
	//分页信息
	private Page page;
	
    private Integer bureauId;

	public Integer getBureauId() {
		return bureauId;
	}

	public void setBureauId(Integer bureauId) {
		this.bureauId = bureauId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
