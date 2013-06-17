package org.infosec.ismp.manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * servicecheck结果实体类
 * @author jiel
 *
 */
@Entity
@Table(name="servicecheck_result_entity")
public class ServiceCheckResultEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long servicecheck_result_id;
	private String domain;
	private String nodeid;
	private String ipAddr;
	private String serviceCheckStatus;
	private Double responseTime;//返回响应时间
	private String serviceType;
	private String serviceCheckTime;//检测时间
	
	public Long getServicecheck_result_id() {
		return servicecheck_result_id;
	}
	public void setServicecheck_result_id(Long servicecheck_result_id) {
		this.servicecheck_result_id = servicecheck_result_id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getNodeid() {
		return nodeid;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public Double getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Double responseTime) {
		this.responseTime = responseTime;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceCheckTime() {
		return serviceCheckTime;
	}
	public void setServiceCheckTime(String serviceCheckTime) {
		this.serviceCheckTime = serviceCheckTime;
	}
	public String getServiceCheckStatus() {
		return serviceCheckStatus;
	}
	public void setServiceCheckStatus(String serviceCheckStatus) {
		this.serviceCheckStatus = serviceCheckStatus;
	}

}
