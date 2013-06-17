package org.infosec.ismp.manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * siteCheck 结果实体类
 * @author jiel
 *
 */
@Entity
@Table(name="sitecheck_result_entity")
public class SiteCheckResultEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sitecheck_result_id;
	private String domain;
	private String nodeid;
	private String url;
	private String pingStatus;
	private String siteCheckStatus;
	private Double responseTime; 
	private String siteCheckTime;
	@Transient
	private Boolean isReset;
	public Long getSitecheck_result_id() {
		return sitecheck_result_id;
	}
	public void setSitecheck_result_id(Long sitecheck_result_id) {
		this.sitecheck_result_id = sitecheck_result_id;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPingStatus() {
		return pingStatus;
	}
	public void setPingStatus(String pingStatus) {
		this.pingStatus = pingStatus;
	}
	public String getSiteCheckStatus() {
		return siteCheckStatus;
	}
	public void setSiteCheckStatus(String siteCheckStatus) {
		this.siteCheckStatus = siteCheckStatus;
	}
	public Double getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Double responseTime) {
		this.responseTime = responseTime;
	}
	public String getSiteCheckTime() {
		return siteCheckTime;
	}
	public void setSiteCheckTime(String siteCheckTime) {
		this.siteCheckTime = siteCheckTime;
	}
	public Boolean isReset() {
		return isReset;
	}
	public void setReset(Boolean isReset) {
		this.isReset = isReset;
	}
	
}
