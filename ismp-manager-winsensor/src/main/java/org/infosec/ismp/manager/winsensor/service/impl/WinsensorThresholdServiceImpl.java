package org.infosec.ismp.manager.winsensor.service.impl;

import org.infosec.ismp.agent.comm.winsensor.model.CommThreshold;
import org.infosec.ismp.manager.rmi.sensor.service.WinsensorThresholdService;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 3:46:51 PM
 *
 */
public class WinsensorThresholdServiceImpl implements WinsensorThresholdService {
	
	private ManagerSensorServer managerSensorServer;

	@Override
	public void addThreshold(CommThreshold commThreshold) {
		managerSensorServer.addThreshold(commThreshold);
	}

	@Override
	public void updateThreshold(Long id, Integer level, Long size) {
		managerSensorServer.updateThreshold(id, level, size);		
	}

	@Override
	public void deleteThresholdByNodeId(String nodeId) {
		managerSensorServer.deleteThresholdByNodeId(nodeId);
	}

	@Override
	public void deleteThresholdById(Long id) {
		managerSensorServer.deleteThresholdById(id);		
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
