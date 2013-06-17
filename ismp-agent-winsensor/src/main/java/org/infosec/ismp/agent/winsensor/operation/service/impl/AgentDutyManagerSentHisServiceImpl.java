package org.infosec.ismp.agent.winsensor.operation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;
import org.infosec.ismp.agent.winsensor.operation.dao.AgentDutyManagerSentHisDao;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerSentHisBO;
import org.infosec.ismp.agent.winsensor.operation.service.AgentDutyManagerSentHisService;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 9:59:52 PM
 *
 */
public class AgentDutyManagerSentHisServiceImpl implements
		AgentDutyManagerSentHisService {
	private AgentDutyManagerSentHisDao dao;
	
	@Override
	public List<String> addSentHistory(List<DutyManager> dutyManagers,
			List<WinsensorDeviceBO> devices) {
		List<String> sensorIds = new ArrayList<String>();
		
		for (DutyManager dutyManager : dutyManagers) {
			
			for (WinsensorDeviceBO device : devices) {
				if (dutyManager.getDomainId().equals(device.getDomainId())) {
					AgentDutyManagerSentHisBO sentHistory = new AgentDutyManagerSentHisBO();
					sentHistory.setSensorId(device.getSensorId());
					sentHistory.setCreateTime(new Date());
					sentHistory.setDutyManagerId(dutyManager.getId());
					sentHistory.setExpired(false);
					sentHistory.setIsSent(false);
					sentHistory.setIsRemoved(false);
					
					dao.addSentHistory(sentHistory);
					sensorIds.add(device.getSensorId());
				}
			}
		}
		
		return sensorIds;
	}
	
	@Override
	public List<String> getAllUnsentDutySensorId(List<String> allLegalSensorIds) {
		List<String> allSensorIds = dao.getAllUnsentDutySensorId();
		List<String> sensorIds = new ArrayList<String>();
		
		//Filter duplicate sensorId and illegal sensorId.
		for (String sensorId : allSensorIds) {
			if (allLegalSensorIds.contains(sensorId) && (!sensorIds.contains(sensorId))) {
				sensorIds.add(sensorId);
			}
		}
		
		return sensorIds;
	}
	
	@Override
	public List<AgentDutyManagerSentHisBO> getAllUnsentDutyManager(String sensorId) {
		return dao.getAllUnsentDutyManager(sensorId);
	}
	
	@Override
	public void cleanUpExpiredSentHistory(List<String> dutyManagerIds) {
		for (String dutyManagerId : dutyManagerIds) {
			List<AgentDutyManagerSentHisBO> sentHistories = dao.findSentHistory(dutyManagerId);
			
			for (AgentDutyManagerSentHisBO sentHistory : sentHistories) {
				sentHistory.setExpired(true);
				dao.updateSentHistory(sentHistory);
			}
		}
	}
	
	@Override
	public List<String> getAllUnsentDutyManager(
			List<AgentDutyManagerBO> allCurrentUsedDutyManager) {
		List<String> dutyManagerIds = new ArrayList<String>();
		
		for (AgentDutyManagerBO dutyManager : allCurrentUsedDutyManager) {
			dutyManagerIds.add(String.valueOf(dutyManager.getId()));
		}
		
		return dao.getAllUnsentDutyManager(dutyManagerIds);
	}
	
	@Override
	public List<String> deleteDutyManager(String dutyManagerId, List<String> allSensorIds) {
		List<AgentDutyManagerSentHisBO> sentHistories = dao.findSentHistory(dutyManagerId);
		List<String> sensorIds = new ArrayList<String>();
		
		for (AgentDutyManagerSentHisBO sentHistory : sentHistories) {
			sentHistory.setIsRemoved(true);
			dao.updateSentHistory(sentHistory);
			
			if (allSensorIds.contains(sentHistory.getSensorId())) {
				sensorIds.add(sentHistory.getSensorId());
			}
		}
		
		return sensorIds;
	}
	
	@Override
	public List<String> getAllUnremovedDutySensorId(List<String> allLegalSensorIds) {
		List<String>allSensorIds = dao.getAllUnremovedDutySensorId();
		List<String> sensorIds = new ArrayList<String>();
		
		for (String sensorId : allSensorIds) {
			if (allLegalSensorIds.contains(sensorId)) {
				sensorIds.add(sensorId);
			}
		}
		
		return sensorIds;
	}
	
	@Override
	public void updateSendSuccessHistory(String dutyManagerId, String sensorId) {
			AgentDutyManagerSentHisBO sentHistory = dao.findSentHistory(dutyManagerId, sensorId);
			
			if (sentHistory != null) {
				sentHistory.setIsSent(true);
				sentHistory.setSendTime(new Date());
				dao.updateSentHistory(sentHistory);
			}
	}
	
	@Override
	public void updateRemovedSuccessHistory(String sensorId) {
		AgentDutyManagerSentHisBO sentHistory = dao.findRemovedHistory(sensorId);
		
		if (sentHistory != null) {
			sentHistory.setRemovedTime(new Date());
			dao.updateSentHistory(sentHistory);
		}
	}
	
	public void setDao(AgentDutyManagerSentHisDao dao) {
		this.dao = dao;
	}
}
