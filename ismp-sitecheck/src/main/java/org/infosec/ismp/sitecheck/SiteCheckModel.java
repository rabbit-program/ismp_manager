package org.infosec.ismp.sitecheck;

import java.io.Serializable;
import java.net.InetAddress;

public class SiteCheckModel implements Serializable {
	private String nodeid;
	private String url;
	private long responseTime;
	private String pingStatus;
	private String siteCheckStatus;
	private boolean isReset;
	public long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
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
	public boolean isReset() {
		return isReset;
	}
	public void setReset(boolean isReset) {
		this.isReset = isReset;
	}
}
