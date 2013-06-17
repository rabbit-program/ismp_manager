package org.infosec.ismp.ping;

import java.io.Serializable;
import java.net.InetAddress;
public class PingdModel implements Serializable {	
	private String uuid;
	private String nodeid;
	private String ipAddr;
	private Long  responseTime;
	private String pingFlag;
	private InetAddress ipInetAddr;
	public InetAddress getIpInetAddr() {
		return ipInetAddr;
	}
	public void setIpInetAddr(InetAddress ipInetAddr) {
		this.ipInetAddr = ipInetAddr;
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
	public Long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}
	public String getPingFlag() {
		return pingFlag;
	}
	public void setPingFlag(String pingFlag) {
		this.pingFlag = pingFlag;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
