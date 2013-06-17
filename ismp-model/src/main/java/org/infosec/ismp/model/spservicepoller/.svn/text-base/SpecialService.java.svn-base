package org.infosec.ismp.model.spservicepoller;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.model.poller.Parameter;

/**
 * 代表一个被监控的特别服务。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class SpecialService {

	private int serviceId;

	private String name;

	private long interval;

	private boolean hasInterval;

	private String status;

	private String svcName;//icmp,http

	private String ipAddr;

	private List<Parameter> parameters = new ArrayList<Parameter>();

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public boolean isHasInterval() {
		return hasInterval;
	}

	public void setHasInterval(boolean hasInterval) {
		this.hasInterval = hasInterval;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSvcName() {
		return svcName;
	}

	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}

	public Parameter[] getParameters() {
		return (Parameter[]) parameters.toArray(new Parameter[0]);
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

}
