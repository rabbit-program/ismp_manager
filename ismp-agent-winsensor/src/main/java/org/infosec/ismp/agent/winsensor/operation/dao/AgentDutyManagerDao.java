package org.infosec.ismp.agent.winsensor.operation.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 7:57:03 PM
 *
 */
public interface AgentDutyManagerDao {

	public void addDutyManager(AgentDutyManagerBO dutyManagerBO);
	
	public void deleteDutyManager(String dutyManagerId);
	
	public AgentDutyManagerBO findDutyManagerById(String dutyManagerId);
	
	public AgentDutyManagerBO findDutyManagerById(String dutyManagerId, boolean expired);

	public List<AgentDutyManagerBO> getAllUnsentDutyManager(boolean expired);

	public void updateDutyManager(AgentDutyManagerBO dutyManager);
}
