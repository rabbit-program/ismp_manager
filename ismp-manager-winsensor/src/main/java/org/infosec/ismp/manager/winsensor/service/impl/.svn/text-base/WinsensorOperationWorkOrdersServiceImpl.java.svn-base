package org.infosec.ismp.manager.winsensor.service.impl;

import org.infosec.ismp.manager.rmi.sensor.operation.service.WinsensorOperationWorkOrdersService;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Dec 24, 2010 1:36:51 PM
 *
 */
public class WinsensorOperationWorkOrdersServiceImpl implements
		WinsensorOperationWorkOrdersService {
	
	private ManagerSensorServer managerSensorServer;

	@Override
	public void closeProblem(String problemId) {
		managerSensorServer.closeOperationProblem(problemId);
	}

	@Override
	public void generateWorkOrders(String problemId, String workOrdersId) {
		managerSensorServer.generateWorkOrders(problemId, workOrdersId);
	}

	@Override
	public void closeWorkOrders(String problemId, String workOrdersId) {
		managerSensorServer.closeWorkOrders(problemId, workOrdersId);
	}

	@Override
	public void completeWorkOrders(String problemId, String workOrdersId) {
		managerSensorServer.completeWorkOrders(problemId, workOrdersId);
	}

	public ManagerSensorServer getManagerSensorServer() {
		return managerSensorServer;
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
