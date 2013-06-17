package org.infosec.ismp.manager.winsensor.service.impl;

import java.util.Map;

import org.infosec.ismp.manager.rmi.sensor.SensorController;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Dec 24, 2010 1:35:43 PM
 *
 */
public class SensorControllerImpl implements SensorController {
	
	private ManagerSensorServer managerSensorServer;

	@Override
	public void addSensor(Map<String, Long> sensorMap) {
		managerSensorServer.addPcLogSource(sensorMap);
		System.out.println("addSensor:");
	}

	@Override
	public void deleteSensor(String sensorId) {
		managerSensorServer.deletePclogSource(sensorId);
		System.out.println("deleteSensor: " + sensorId);
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
