package org.infosec.ismp.manager.winsensor.operation.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.manager.winsensor.entity.AgentBO;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 6:52:41 PM
 *
 */
public interface DutyManagerSentHistoryService {

	public void addSentHistory(List<DutyManager> dutyManagers, List<AgentBO> agents);

	public void updateSendSuccessHistory(List<DutyManager> dutyManagers, String agentId);

	public List<String> getAllUnSentDutyManagerAgentId();

	public List<String> getAllUnsentDutyManagerId(String agentId, boolean expired);

	public void deleteDutyManager(String dutyManagerId);

}
