package org.infosec.ismp.manager.winsensor.service.impl;

import java.util.List;

import org.infosec.ismp.manager.winsensor.dao.ManagerWinsensorDeviceDao;
import org.infosec.ismp.manager.winsensor.entity.ManagerWinsensorDeviceBO;
import org.infosec.ismp.manager.winsensor.service.ManagerWinsensorDeviceService;

/**
 * @author Rocky
 * @version create time: Dec 23, 2010 4:32:23 PM
 *
 */
public class ManagerWinsensorDeviceServiceImpl implements
		ManagerWinsensorDeviceService {
	
	private ManagerWinsensorDeviceDao dao;

	@Override
	public void addDevice(ManagerWinsensorDeviceBO device) {
		dao.addDevice(device);
	}

	@Override
	public void updateDevice(ManagerWinsensorDeviceBO device) {
		dao.updateDevice(device);
	}

	@Override
	public void deleteDevice(ManagerWinsensorDeviceBO device) {
		dao.deleteDevice(device);
	}

	@Override
	public ManagerWinsensorDeviceBO findDeviceBySensorId(String sensorId) {
		return dao.findDeviceBySensorId(sensorId);
	}

	@Override
	public ManagerWinsensorDeviceBO findDeviceByNodeId(String nodeId) {
		return dao.findDeviceByNodeId(nodeId);
	}

	@Override
	public List<ManagerWinsensorDeviceBO> getAllDevice() {
		return dao.getAllDevice();
	}

	public ManagerWinsensorDeviceDao getDao() {
		return dao;
	}

	public void setDao(ManagerWinsensorDeviceDao dao) {
		this.dao = dao;
	}
}
