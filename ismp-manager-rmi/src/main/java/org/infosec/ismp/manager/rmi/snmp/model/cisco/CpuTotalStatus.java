package org.infosec.ismp.manager.rmi.snmp.model.cisco;

import java.io.Serializable;

/**
 * @author guoxianwei
 * @date 2010-12-23 下午04:02:18
 * 
 */
public class CpuTotalStatus implements Serializable {

	private static final long serialVersionUID = 784007458653084701L;
	private String index;
	private String cpuTotal5sec;//每5秒的CPU繁忙度
	private String cpuTotal1min;//每1分的CPU繁忙度
	private String cpuTotal5min;//每5分的CPU繁忙度
	private String cpuMonInterval;//监控周期
	private String cpuTotalMonIntervalValue;//监控周期内CPU繁忙度
	//被中断后，最新一次监控周期CPU的繁忙度
	private String cpuInterruptMonIntervalValue;//
	
	public String getIndex() {
		return index;
	}
	public String getCpuTotal5sec() {
		return cpuTotal5sec;
	}
	public String getCpuTotal1min() {
		return cpuTotal1min;
	}
	public String getCpuTotal5min() {
		return cpuTotal5min;
	}
	public String getCpuMonInterval() {
		return cpuMonInterval;
	}
	public String getCpuTotalMonIntervalValue() {
		return cpuTotalMonIntervalValue;
	}
	public String getCpuInterruptMonIntervalValue() {
		return cpuInterruptMonIntervalValue;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public void setCpuTotal5sec(String cpuTotal5sec) {
		this.cpuTotal5sec = cpuTotal5sec;
	}
	public void setCpuTotal1min(String cpuTotal1min) {
		this.cpuTotal1min = cpuTotal1min;
	}
	public void setCpuTotal5min(String cpuTotal5min) {
		this.cpuTotal5min = cpuTotal5min;
	}
	public void setCpuMonInterval(String cpuMonInterval) {
		this.cpuMonInterval = cpuMonInterval;
	}
	public void setCpuTotalMonIntervalValue(String cpuTotalMonIntervalValue) {
		this.cpuTotalMonIntervalValue = cpuTotalMonIntervalValue;
	}
	public void setCpuInterruptMonIntervalValue(String cpuInterruptMonIntervalValue) {
		this.cpuInterruptMonIntervalValue = cpuInterruptMonIntervalValue;
	}


}
