package org.infosec.ismp.agent.winsensor.operation.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerSentHisBO;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 9:59:11 PM
 *
 */
public interface AgentDutyManagerSentHisService {

	public List<String> addSentHistory(List<DutyManager> dutyManagers, List<WinsensorDeviceBO> devices);

	public void updateSendSuccessHistory(String dutyManagerId, String sensorId);
	
	public List<String> getAllUnsentDutySensorId(List<String> allLegalSensorIds);

	public List<AgentDutyManagerSentHisBO> getAllUnsentDutyManager(String sensorId);

	public void cleanUpExpiredSentHistory(List<String> dutyManagerIds);

	public List<String> getAllUnsentDutyManager(
			List<AgentDutyManagerBO> allCurrentUsedDutyManager);

	public List<String> deleteDutyManager(String dutyManagerId, List<String> sensorIds);

	public List<String> getAllUnremovedDutySensorId(
			List<String> allLegalMonitorDevicesSensorIdList);

	public void updateRemovedSuccessHistory(String sensorId);
}
