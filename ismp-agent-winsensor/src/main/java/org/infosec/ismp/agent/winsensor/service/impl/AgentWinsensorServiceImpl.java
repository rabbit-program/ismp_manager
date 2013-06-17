package org.infosec.ismp.agent.winsensor.service.impl;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommBaseStrategy;
import org.infosec.ismp.agent.rmi.winsensor.service.AgentWinsensorService;
import org.infosec.ismp.agent.winsensor.SensorServer;
import org.infosec.ismp.agent.winsensor.util.WinsensorDeviceUtil;

/**
 * @author Rocky
 * @version create time：Dec 6, 2010 4:14:55 PM
 * 
 */
public class AgentWinsensorServiceImpl implements AgentWinsensorService {
	
	private SensorServer sensorServer;

	public void addMonitorDevice(CommWinsensorDevice commDevice) {
		sensorServer.addMonitorDevice(commDevice);
	}

	public void addMonitorDevice(List<CommWinsensorDevice> commDevices) {
		sensorServer.addMonitorDevice(commDevices);
	}

	public void updateMonitorDevice(CommWinsensorDevice commDevice) {
		sensorServer.updateMonitorDevice(commDevice);
	}
	
	public void pauseMonitor(String nodeId) {
		sensorServer.pauseMonitor(nodeId);
	}
	
	public void pauseMonitor(List<String> nodeIds) {
		sensorServer.pauseMonitor(nodeIds);
	}
	
	public void startingMonitor(String nodeId) {
		sensorServer.startingMonitor(nodeId);
	}
	
	public void startingMonitor(List<String> nodeIds) {
		sensorServer.startingMonitor(nodeIds);
	}
	
	public void stopMonitor(String nodeId) {
		sensorServer.stopMonitor(nodeId);
	}
	
	public void stopMonitor(List<String> nodeIds) {
		sensorServer.stopMonitor(nodeIds);
	}

	public void updateStrategy(List<CommBaseStrategy> strategies) {
		sensorServer.updateStrategy(strategies);
	}

	public List<CommWinsensorDevice> getAllMonitoredDevices() {
		return WinsensorDeviceUtil.getCommWinsensorDevice(sensorServer.getAllLegalMonitorDevices());
	}

	public List<CommWinsensorDevice> getAllOnlineMonitoredDevices() {
		return WinsensorDeviceUtil.getCommWinsensorDevice(sensorServer.getAllCurrentMonitoringWinsensorClient().keySet());
	}

	public List<CommWinsensorDevice> getAllRegisteringAndNotMonitoredDevices() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void publishDutyManager(List<DutyManager> dutyManagers) {
		sensorServer.publishDutyManager(dutyManagers);
	}
	
	@Override
	public void deleteDutyManager(String dutyManagerId) {
		sensorServer.deleteDutyManager(dutyManagerId);
	}
	
	@Override
	public void receivedOperationProblem(String problemId) {
		sensorServer.receivedOperationProblem(problemId);
	}
	
	@Override
	public void closeOperationProblem(String problemId) {
		sensorServer.closeOperationProblem(problemId);
	}
	
	@Override
	public void generateWorkOrders(String problemId, String workOrdersId) {
		sensorServer.generateWorkOrders(problemId, workOrdersId);
	}
	
	@Override
	public void closeWorkOrders(String problemId, String workOrdersId) {
		sensorServer.closeWorkOrders(problemId, workOrdersId);
	}
	
	@Override
	public void completeWorkOrders(String problemId, String workOrdersId) {
		sensorServer.completeWorkOrders(problemId, workOrdersId);
	}
	
	public SensorServer getSensorServer() {
		return sensorServer;
	}
	
	public void setSensorServer(SensorServer sensorServer) {
		this.sensorServer = sensorServer;
	}
}
