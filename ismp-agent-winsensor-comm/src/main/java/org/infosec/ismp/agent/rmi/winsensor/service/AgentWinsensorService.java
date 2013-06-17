package org.infosec.ismp.agent.rmi.winsensor.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommBaseStrategy;

/**
 * @author Rocky
 * @version create time：Dec 6, 2010 2:17:40 PM
 * 
 */
public interface AgentWinsensorService {

	/**
	 * Add monitor sensor client.
	 * @param commDevice
	 */
	public void addMonitorDevice(CommWinsensorDevice commDevice);
	
	public void addMonitorDevice(List<CommWinsensorDevice> commDevices);
	
	/**
	 * Update monitor device's info.
	 * Now only able to modify the device's retries and timeout.
	 * @param commDevice
	 */
	public void updateMonitorDevice(CommWinsensorDevice commDevice);
	
	/**
	 * Start monitoring the device.
	 * @param nodeId
	 */
	public void startingMonitor(String nodeId);
	
	public void startingMonitor(List<String> nodeIds);
	
	/**
	 * Pause monitoring the device.
	 * @param nodeId
	 */
	public void pauseMonitor(String nodeId);
	
	public void pauseMonitor(List<String> nodeIds);
	
	/**
	 * Stop monitor the device and remove it from database.
	 * @param nodeId
	 */
	public void stopMonitor(String nodeId);
	
	public void stopMonitor(List<String> nodeIds);
	
	/**
	 * Issued to the sensor clients a variety of strategies.
	 * A strategy correspond to a device, but the device can contain multiple strategies.
	 * The strategies can contain multiple devices.
	 * @param strategies
	 */ 
	public void updateStrategy(List<CommBaseStrategy> strategies);
	
	/**
	 * Get all devices have been monitored.
	 */
	public List<CommWinsensorDevice> getAllMonitoredDevices();
	
	/**
	 * Get all online devices have been monitored.
	 */
	public List<CommWinsensorDevice> getAllOnlineMonitoredDevices();
	
	/**
	 * Get all registering devices have not been monitored.
	 */
	public List<CommWinsensorDevice> getAllRegisteringAndNotMonitoredDevices();
	
	/**
	 * Publish operation DutyManager.
	 */
	public void publishDutyManager(List<DutyManager> dutyManagers);

	/**
	 * Delete published operation DutyManager.
	 * @param dutyManagerId
	 */
	public void deleteDutyManager(String dutyManagerId);

	/**
	 * When manager server received the problem, call this method and notice agent server.
	 * @param problemId
	 */
	public void receivedOperationProblem(String problemId);

	public void closeOperationProblem(String problemId);

	public void generateWorkOrders(String problemId, String workOrdersId);

	public void closeWorkOrders(String problemId, String workOrdersId);

	public void completeWorkOrders(String problemId, String workOrdersId);
}
