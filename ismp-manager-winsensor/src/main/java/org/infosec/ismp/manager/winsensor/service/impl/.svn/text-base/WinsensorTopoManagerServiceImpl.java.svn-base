package org.infosec.ismp.manager.winsensor.service.impl;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.manager.rmi.sensor.service.WinsensorTopoManagerService;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Dec 24, 2010 1:34:46 PM
 *
 */
public class WinsensorTopoManagerServiceImpl implements
		WinsensorTopoManagerService {
	
	private ManagerSensorServer managerSensorServer;

	@Override
	public void addSensorDevice(CommWinsensorDevice commDevice) {
		managerSensorServer.addMonitorDevice(commDevice);
	}

	@Override
	public void addSensorDevices(List<CommWinsensorDevice> commDevices) {
		managerSensorServer.addMonitorDevice(commDevices);
	}

	@Override
	public void startMonitorSensorDevice(String nodeId) {
		managerSensorServer.startingMonitor(nodeId);
	}

	@Override
	public void startMonitorSensorDevices(List<String> nodeIds) {
		managerSensorServer.startingMonitor(nodeIds);
	}

	@Override
	public void pauseMonitorSensorDevice(String nodeId) {
		managerSensorServer.pauseMonitor(nodeId);
	}

	@Override
	public void pauseMonitorSensorDevices(List<String> nodeIds) {
		managerSensorServer.pauseMonitor(nodeIds);
	}

	@Override
	public void deleteSensorDevice(String nodeId) {
		managerSensorServer.deleteMonitorDevice(nodeId);
	}

	@Override
	public void deleteSensorDevices(List<String> nodeIds) {
		managerSensorServer.deleteMonitorDevice(nodeIds);
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
