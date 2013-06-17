package org.infosec.ismp.manager.rmi.sensor.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;

/**
 * @author Rocky
 * @version create time：Dec 16, 2010 2:48:41 PM
 * 拓扑面板针对Sensor客户端的一系列操作
 */
public interface WinsensorTopoManagerService {

	/**
	 * 添加监控一台Sensor客户端
	 * @param commDevice
	 */
	public void addSensorDevice(CommWinsensorDevice commDevice);
	
	/**
	 * 添加监控多台Sensor客户端
	 * @param commDevices
	 */
	public void addSensorDevices(List<CommWinsensorDevice> commDevices);
	
	/**
	 * 开启监控单台Sensor客户端
	 * @param nodeId 客户端在系统中的唯一标识nodeId
	 */
	public void startMonitorSensorDevice(String nodeId);
	
	/**
	 * 开启监控多台Sensor客户端
	 * @param nodeIds 客户端在系统中的唯一标识nodeId
	 */
	public void startMonitorSensorDevices(List<String> nodeIds);
	
	/**
	 * 暂停监控单台Sensor客户端
	 * @param nodeId 客户端在系统中的唯一标识nodeId
	 */
	public void pauseMonitorSensorDevice(String nodeId);
	
	/**
	 * 暂停监控多台Sensor客户端
	 * @param nodeIds 客户端在系统中的唯一标识nodeId
	 */
	public void pauseMonitorSensorDevices(List<String> nodeIds);
	
	/**
	 * 删除监控一台Sensor客户端
	 * @param nodeId 客户端在系统中的唯一标识nodeId
	 */
	public void deleteSensorDevice(String nodeId);
	
	/**
	 * 删除监控多台Sensor客户端
	 * @param nodeIds 客户端在系统中的唯一标识nodeId
	 */
	public void deleteSensorDevices(List<String> nodeIds);
}
