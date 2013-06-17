package org.infosec.ismp.manager.winsensor.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.manager.rmi.sensor.operation.service.WinsensorOperationDutyManagerService;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Dec 24, 2010 1:36:17 PM
 *
 */
public class WinsensorOperationDutyManagerServiceImpl implements
		WinsensorOperationDutyManagerService {
	
	private ManagerSensorServer managerSensorServer;

	@Override
	public void publishDutyManager(List<DutyManager> dutyManagers) {
		if (dutyManagers != null && (dutyManagers.size() > 0)) {
			managerSensorServer.publishDutyManager(dutyManagers);
		} 
	}

	@Override
	public void deleteDutyManager(String dutyManagerId) {
		if (!StringUtils.isBlank(dutyManagerId)) {
			managerSensorServer.deleteDutyManager(dutyManagerId);
		}
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
