package org.infosec.ismp.agent.winsensor.operation.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.comm.util.OperationConstant;
import org.infosec.ismp.agent.comm.winsensor.model.operation.Duty;
import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.agent.winsensor.operation.dao.AgentDutyManagerDao;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerSentHisBO;
import org.infosec.ismp.agent.winsensor.operation.service.AgentDutyManagerService;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 7:58:23 PM
 *
 */
public class AgentDutyManagerServiceImpl implements AgentDutyManagerService {
	
	private AgentDutyManagerDao dao;
	
	@Override
	public void addDutyManager(List<DutyManager> dutyManagers) {
		for (DutyManager dutyManager : dutyManagers) {
			List<Duty> duties = dutyManager.getDuties();
			AgentDutyManagerBO dutyManagerBO = new AgentDutyManagerBO();
			List<AgentDutyBO> dutyBOs = new ArrayList<AgentDutyBO>();
			
			for (Duty duty : duties) {
				AgentDutyBO dutyBO = new AgentDutyBO();
				dutyBO.setRemoteDutyId(duty.getId());
				dutyBO.setCreateTime(new Date());
				dutyBO.setEmail(duty.getEmail());
				dutyBO.setIsManager(duty.getIsManager());
				dutyBO.setMobilePhone(duty.getMobilePhone());
				dutyBO.setName(duty.getName());
				dutyBO.setPhone(duty.getPhone());
				dutyBO.setResponsibility(duty.getResponsibility());
				dutyBO.setSex(duty.getSex());
				
				dutyBOs.add(dutyBO);
			}
			
			dutyManagerBO.setId(Long.valueOf(dutyManager.getId()));
			dutyManagerBO.setDuties(dutyBOs);
			dutyManagerBO.setDomainId(dutyManager.getDomainId());
			dutyManagerBO.setBeginDate(dutyManager.getBeginDate());
			dutyManagerBO.setEndDate(dutyManager.getEndDate());
			dutyManagerBO.setComplaintNumber(dutyManager.getComplaintNumber());
			dutyManagerBO.setExpired(false);
			dutyManagerBO.setCreateTime(new Date());
			
			dao.addDutyManager(dutyManagerBO);
		}
	}
	
	@Override
	public List<AgentDutyManagerBO> getAllUnsentDutyManager(
			List<AgentDutyManagerSentHisBO> sentHistories) {
		List<AgentDutyManagerBO> dutyManagers = new ArrayList<AgentDutyManagerBO>();
		
		for (AgentDutyManagerSentHisBO sentHistory : sentHistories) {
			String dutyManagerId = sentHistory.getDutyManagerId();
			AgentDutyManagerBO dutyManager = dao.findDutyManagerById(dutyManagerId, false);
			
			//Expired dutyManager, except.
			if (dutyManager != null) {
				dutyManagers.add(dutyManager);
			}
		}
		
		return dutyManagers;
	}
	
	@Override
	public AgentDutyManagerBO getCurrentUsedDutyManager(
			List<AgentDutyManagerSentHisBO> sentHistories) {
		List<AgentDutyManagerBO> dutyManagers = getAllUnsentDutyManager(sentHistories);
		for (AgentDutyManagerBO dutyManager : dutyManagers) {
			DateFormat dateFormat = new SimpleDateFormat(OperationConstant.DUTY_MANAGER_DATE_FORMAT);
			Date beginDate = null;
			Date endDate = null;
			Date now = new Date();
			
			try {
				beginDate = dateFormat.parse(dutyManager.getBeginDate());
				endDate = dateFormat.parse(dutyManager.getEndDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (now.after(beginDate) && now.before(endDate)) {
				return dutyManager;
			}
		}
		
		return null;
	}
	

	@Override
	public List<String> cleanUpExpiredDutyManagers() {
		List<AgentDutyManagerBO> dutyManagers = dao.getAllUnsentDutyManager(false);
		List<String> dutyManagerIds = new ArrayList<String>();
		
		for (AgentDutyManagerBO dutyManager : dutyManagers) {
			SimpleDateFormat format = new SimpleDateFormat(OperationConstant.DUTY_MANAGER_DATE_FORMAT);
			Date now = new Date();
			Date endDate = null;
			try {
				endDate = format.parse(dutyManager.getEndDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (endDate != null && now.after(endDate)) {
				dutyManager.setExpired(true);
				dao.updateDutyManager(dutyManager);
				dutyManagerIds.add(String.valueOf(dutyManager.getId()));
			}
		}
		
		return dutyManagerIds;
	}
	
	@Override
	public List<AgentDutyManagerBO> getAllCurrentUsedDutyManager() {
		List<AgentDutyManagerBO> allDutyManagers = dao.getAllUnsentDutyManager(false);
		List<AgentDutyManagerBO> dutyManagers = new ArrayList<AgentDutyManagerBO>();
		
		for (AgentDutyManagerBO dutyManager : allDutyManagers) {
			SimpleDateFormat format = new SimpleDateFormat(OperationConstant.DUTY_MANAGER_DATE_FORMAT);
			Date now = new Date();
			Date beginDate = null;
			Date endDate = null;
			try {
				beginDate = format.parse(dutyManager.getBeginDate());
				endDate = format.parse(dutyManager.getEndDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (now.after(beginDate) && now.before(endDate)) {
				dutyManagers.add(dutyManager);
			}
		}
		
		return dutyManagers;
	}
	
	@Override
	public void deleteDutyManager(String dutyManagerId) {
		dao.deleteDutyManager(dutyManagerId);
	}


	public void setDao(AgentDutyManagerDao dao) {
		this.dao = dao;
	}
}
