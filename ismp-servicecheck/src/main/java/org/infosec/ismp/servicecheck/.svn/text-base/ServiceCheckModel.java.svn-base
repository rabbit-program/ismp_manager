package org.infosec.ismp.servicecheck;

import java.io.Serializable;
import java.util.Map;

import org.infosec.ismp.model.poller.ServiceMonitor;

public class ServiceCheckModel implements Serializable {
	private String nodeid;
	private String type;
	private String ipAddr;
	private String pingStatus;
	private double responseTime;
	private ServiceMonitor monitor;
	private Map parameters;
	public String getPingStatus() {
		return pingStatus;
	}

	public void setPingStatus(String pingStatus) {
		this.pingStatus = pingStatus;
	}

	public double getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public ServiceMonitor getMonitor() {
		return monitor;
	}

	public void setMonitor(ServiceMonitor monitor) {
		this.monitor = monitor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
}
