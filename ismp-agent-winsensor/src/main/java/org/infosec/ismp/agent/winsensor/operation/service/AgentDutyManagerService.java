package org.infosec.ismp.agent.winsensor.operation.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerSentHisBO;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 7:57:56 PM
 *
 */
public interface AgentDutyManagerService {
	
	public void addDutyManager(List<DutyManager> dutyManagers);
	
	public void deleteDutyManager(String dutyManagerId);

	public List<AgentDutyManagerBO> getAllUnsentDutyManager(List<AgentDutyManagerSentHisBO> sentHistories);
	
	public AgentDutyManagerBO getCurrentUsedDutyManager(List<AgentDutyManagerSentHisBO> sentHistories);

	public List<String> cleanUpExpiredDutyManagers();

	public List<AgentDutyManagerBO> getAllCurrentUsedDutyManager();
}
