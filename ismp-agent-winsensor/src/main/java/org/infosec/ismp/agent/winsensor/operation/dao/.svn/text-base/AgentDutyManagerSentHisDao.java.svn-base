package org.infosec.ismp.agent.winsensor.operation.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerSentHisBO;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 9:58:24 PM
 *
 */
public interface AgentDutyManagerSentHisDao {

	public void addSentHistory(AgentDutyManagerSentHisBO sentHistory);

	public AgentDutyManagerSentHisBO findSentHistory(String dutyManagerId, String sensorId);

	public void updateSentHistory(AgentDutyManagerSentHisBO sentHistory);
	
	public List<String> getAllUnsentDutySensorId();

	public List<AgentDutyManagerSentHisBO> getAllUnsentDutyManager(String sensorId);

	public List<AgentDutyManagerSentHisBO> findSentHistory(String dutyManagerId);

	public List<String> getAllUnsentDutyManager(List<String> dutyManagerIds);

	public List<String> getAllUnremovedDutySensorId();

	public AgentDutyManagerSentHisBO findRemovedHistory(String sensorId);

}
