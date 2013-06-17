package org.infosec.ismp.manager.winsensor.service.impl;

import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.manager.rmi.sensor.service.WinsensorBasicInfoService;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Dec 24, 2010 1:33:30 PM
 *
 */
public class WinsensorBasicInfoServiceImpl implements WinsensorBasicInfoService {

	private ManagerSensorServer managerSensorServer;
	
	@Override
	public HostResource getHostResource(String nodeId) {
		return managerSensorServer.getHostResource(nodeId);
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
