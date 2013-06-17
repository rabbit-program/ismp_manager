package org.infosec.ismp.model.poller.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 代表一个需要检测的服务，包括服务参数。
 * 
 * @author lianglin
 * 
 */
public class Service implements Serializable {
	private String svcLabel;
	private String ipAddr;
	private String svcName;// 服务类型
	private long interval;// 检测间隔；
	
	
	private List<ServiceParameter> serviceParameters = new ArrayList<ServiceParameter>();


	public String getSvcName() {
		return svcName;
	}


	public void setSvcName(String svcName) {
		this.svcName = svcName;
	}


	public long getInterval() {
		return interval;
	}


	public void setInterval(long interval) {
		this.interval = interval;
	}


	public ServiceParameter[] getServiceParameters(){
		return (ServiceParameter[])serviceParameters.toArray(new ServiceParameter[0]);
	}


	public void setServiceParameters(List<ServiceParameter> serviceParameters) {
		this.serviceParameters = serviceParameters;
	}


	public String getIpAddr() {
		return ipAddr;
	}


	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	
	

}
