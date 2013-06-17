package org.infosec.ismp.manager.winsensor.service;

import java.util.List;

import org.infosec.ismp.manager.winsensor.entity.ManagerWinsensorDeviceBO;

/**
 * @author Rocky
 * @version create time: Dec 23, 2010 4:30:23 PM
 *
 */
public interface ManagerWinsensorDeviceService {
	
	public void addDevice(ManagerWinsensorDeviceBO device);
	
	public void updateDevice(ManagerWinsensorDeviceBO device);
	
	public void deleteDevice(ManagerWinsensorDeviceBO device);
	
	public ManagerWinsensorDeviceBO findDeviceBySensorId(String sensorId);
	
	public ManagerWinsensorDeviceBO findDeviceByNodeId(String nodeId);
	
	public List<ManagerWinsensorDeviceBO> getAllDevice();
}
