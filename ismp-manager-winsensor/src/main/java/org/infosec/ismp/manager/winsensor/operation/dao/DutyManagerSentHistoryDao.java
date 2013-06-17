package org.infosec.ismp.manager.winsensor.operation.dao;

import java.util.List;

import org.infosec.ismp.manager.winsensor.operation.entity.DutyManagerSentHistoryBO;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 6:51:36 PM
 *
 */
public interface DutyManagerSentHistoryDao {

	public void addSentHistory(DutyManagerSentHistoryBO sentHistory);

	public DutyManagerSentHistoryBO findSentHistory(String dutyManagerId, String agentId);

	public void updateSentHistory(DutyManagerSentHistoryBO sentHistory);

	public List<String> getAllUnSentDutyManagerAgentId();

	public List<String> getAllUnsentDutyManagerId(String agentId, boolean expired);

	public List<DutyManagerSentHistoryBO> findSentHistory(String dutyManagerId);
}
