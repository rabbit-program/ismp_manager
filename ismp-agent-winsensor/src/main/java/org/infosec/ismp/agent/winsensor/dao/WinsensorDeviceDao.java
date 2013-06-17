package org.infosec.ismp.agent.winsensor.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;

/**
 * @author Rocky
 * @version create time：Sep 30, 2010 10:20:42 AM
 * 
 */
public interface WinsensorDeviceDao {
	public void addDevice(WinsensorDeviceBO device);
	
	public void addDevices(List<WinsensorDeviceBO> devices);
	
	public void deleteDevice(WinsensorDeviceBO device);
	
	public void deleteDevices(List<WinsensorDeviceBO> devices);
	
	public void pauseDevice(WinsensorDeviceBO device);
	
	public void pauseDevices(List<WinsensorDeviceBO> devices);
	
	public void updateDevice(WinsensorDeviceBO device);
	
	public void updateDevices(List<WinsensorDeviceBO> devices);
	
	public List<WinsensorDeviceBO> getAllMonitorDevices();
	
	public WinsensorDeviceBO findDeviceBySensorId(String sensorId);
	
	public WinsensorDeviceBO findDeviceByNodeId(String nodeId);
}
