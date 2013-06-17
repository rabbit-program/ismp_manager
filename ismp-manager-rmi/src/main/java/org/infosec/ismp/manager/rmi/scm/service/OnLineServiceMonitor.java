package org.infosec.ismp.manager.rmi.scm.service;

import org.infosec.ismp.manager.rmi.scm.model.PollStatus;

/**
 * 提供设备是否在线的监控
 * 
 * @author lianglin
 * 
 */
public interface OnLineServiceMonitor {
	/**
	 * 添加设备监控
	 * @param domainId
	 * @param nodeid
	 * @param ipaddr
	 * @param interval
	 * @param flag
	 */
	public void addDevice(String domainId, String nodeid, String ipaddr,
			long interval, boolean flag);
	
	/**
	 * 删除服务监控
	 * @param nodeid
	 */
	public void removeDevice(String nodeid);
	
	/**
	 * 返回Ping的状态
	 * @param nodeid
	 * @return
	 */
	public PollStatus getPingStatus(String nodeid);
	
	/**
	 * 即时获取目标地址PING状态
	 * @param ipAddr IP地址
	 * @return
	 */
	public PollStatus getDirectPingStauts(String domain,String ipAddr);
	
	/**
	 * 即时获取目标地址available状态
	 * @param domain
	 * @param ipAddr
	 * @param port
	 * @param community
	 * @param version
	 * @return
	 */
	public boolean isSnmpAvailable(String domain,String ipAddr,int port,String community,int version);
}
