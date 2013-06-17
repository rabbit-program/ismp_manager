package org.infosec.ismp.manager.winsensor.operation.service.impl;

import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.manager.winsensor.entity.AgentBO;
import org.infosec.ismp.manager.winsensor.operation.dao.DutyManagerSentHistoryDao;
import org.infosec.ismp.manager.winsensor.operation.entity.DutyManagerSentHistoryBO;
import org.infosec.ismp.manager.winsensor.operation.service.DutyManagerSentHistoryService;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 6:53:06 PM
 *
 */
public class DutyManagerSentHistoryServiceImpl implements DutyManagerSentHistoryService {

	private DutyManagerSentHistoryDao dao;
	
	@Override
	public void addSentHistory(List<DutyManager> dutyManagers,
			List<AgentBO> agents) {
		for (DutyManager dutyManager : dutyManagers) {
			for (AgentBO agent : agents) {
				DutyManagerSentHistoryBO sentHistory = new DutyManagerSentHistoryBO();
				sentHistory.setAgentId(agent.getAgentId());
				sentHistory.setCreateTime(new Date());
				sentHistory.setDutyManagerId(dutyManager.getId());
				sentHistory.setExpired(false);
				sentHistory.setIsSent(false);
				sentHistory.setIsRemoved(false);
				
				dao.addSentHistory(sentHistory);
			}
		}
	}
	
	@Override
	public void updateSendSuccessHistory(List<DutyManager> dutyManagers,
			String agentId) {
		for (DutyManager dutyManager : dutyManagers) {
			DutyManagerSentHistoryBO sentHistory = dao.findSentHistory(dutyManager.getId(), agentId);
			
			if (sentHistory != null) {
				sentHistory.setIsSent(true);
				sentHistory.setSendTime(new Date());
				dao.updateSentHistory(sentHistory);
			}
		}
	}
	
	@Override
	public List<String> getAllUnsentDutyManagerId(String agentId, boolean expired) {
		return dao.getAllUnsentDutyManagerId(agentId, false);
	}
	
	@Override
	public List<String> getAllUnSentDutyManagerAgentId() {
		return dao.getAllUnSentDutyManagerAgentId();
	}
	
	@Override
	public void deleteDutyManager(String dutyManagerId) {
		List<DutyManagerSentHistoryBO> sentHistories = dao.findSentHistory(dutyManagerId);
		
		for (DutyManagerSentHistoryBO sentHistory : sentHistories) {
			sentHistory.setIsRemoved(true);
			dao.updateSentHistory(sentHistory);
		}
	}

	public void setDao(DutyManagerSentHistoryDao dao) {
		this.dao = dao;
	}
}
