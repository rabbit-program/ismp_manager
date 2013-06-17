package org.infosec.ismp.manager.rmi.snmp.service;

import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceRmiBean;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.InterfaceStatus;

/**
 * @author guoxianwei
 * @date 2010-12-14 下午04:32:09 
 * 
 *   SNMP设备监控和web远程交互接口
 *   
 */
public interface SnmpDeviceMonitorRmi {
	/**
	 * 添加需要收集设备监控
	 * 
	 * @param 参数bean
	 */
	public void addSnmpDeviceMonitor(SnmpDeviceRmiBean rmiBean);

	/**
	 * 移除收集设备监控
	 * 
	 * @param 设备节点ID
	 */
	public void removeSnmpDeviceMonitor(String nodeid);

	/**
	 * 获取主机设备信息
	 * 
	 * @param 设备节点ID
	 */
	public SnmpDeviceStatus getSnmpDeviceStatus(String nodeid);
	
	/**
	 * 获取主机设备信息
	 * 
	 * @param 设备节点ID
	 */
	public InterfaceStatus[] getInterfaceStatus(String nodeid);
}
