package org.infosec.ismp.agent.winsensor.service.impl;

import java.util.List;

import org.infosec.ismp.agent.winsensor.dao.WinsensorDeviceDao;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;
import org.infosec.ismp.agent.winsensor.service.WinsensorDeviceService;

/**
 * @author Rocky
 * @version create time：Oct 12, 2010 10:22:00 AM
 * 
 */
public class WinsensorDeviceServiceImpl implements WinsensorDeviceService {
	
	private WinsensorDeviceDao dao;

	@Override
	public void addDevice(WinsensorDeviceBO device) {
		//TODO If delete old device that has same sensorId before add a new one.
		dao.addDevice(device);
	}

	@Override
	public void addDevices(List<WinsensorDeviceBO> devices) {
		dao.addDevices(devices);
	}

	@Override
	public void deleteDevice(WinsensorDeviceBO device) {
		dao.deleteDevice(device);
	}

	@Override
	public void deleteDevices(List<WinsensorDeviceBO> device) {
		dao.deleteDevices(device);
	}

	@Override
	public WinsensorDeviceBO findDeviceBySensorId(String sensorId) {
		return dao.findDeviceBySensorId(sensorId);
	}
	
	@Override
	public WinsensorDeviceBO findDeviceByNodeId(String nodeId) {
		return dao.findDeviceByNodeId(nodeId);
	}

	@Override
	public List<WinsensorDeviceBO> getAllMonitorDevices() {
		return dao.getAllMonitorDevices();
	}

	@Override
	public void pauseDevice(WinsensorDeviceBO device) {
		//TODO not just to update database status, also must to stop monitor the device.
		dao.pauseDevice(device);
	}

	@Override
	public void pauseDevices(List<WinsensorDeviceBO> devices) {
		//TODO not just to update database status, also must to stop monitor the device.
		dao.pauseDevices(devices);
	}

	@Override
	public void updateDevice(WinsensorDeviceBO device) {
		dao.updateDevice(device);
	}

	@Override
	public void updateDevices(List<WinsensorDeviceBO> devices) {
		dao.updateDevices(devices);
	}

	public WinsensorDeviceDao getDao() {
		return dao;
	}

	public void setDao(WinsensorDeviceDao dao) {
		this.dao = dao;
	}
}
