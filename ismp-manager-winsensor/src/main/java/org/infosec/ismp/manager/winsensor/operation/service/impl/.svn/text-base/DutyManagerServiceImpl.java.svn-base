package org.infosec.ismp.manager.winsensor.operation.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.Duty;
import org.infosec.ismp.agent.comm.winsensor.model.operation.DutyManager;
import org.infosec.ismp.manager.winsensor.operation.dao.DutyManagerDao;
import org.infosec.ismp.manager.winsensor.operation.entity.DutyBO;
import org.infosec.ismp.manager.winsensor.operation.entity.DutyManagerBO;
import org.infosec.ismp.manager.winsensor.operation.service.DutyManagerService;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 2:10:30 PM
 *
 */
public class DutyManagerServiceImpl implements DutyManagerService {
	
	private DutyManagerDao dao;

	@Override
	public void addDutyManager(List<DutyManager> dutyManagers) {
		for (DutyManager dutyManager : dutyManagers) {
			List<Duty> duties = dutyManager.getDuties();
			DutyManagerBO dutyManagerBO = new DutyManagerBO();
			List<DutyBO> dutyBOs = new ArrayList<DutyBO>();
			
			for (Duty duty : duties) {
				DutyBO dutyBO = new DutyBO();
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
	public List<DutyManager> getAllDutyManagerById(List<String> dutyManagerIds) {
		List<DutyManagerBO> dutyManagerBOs = dao.getAllDutyManagerById(dutyManagerIds);
		List<DutyManager> dutyManagers = new ArrayList<DutyManager>();
		
		for (DutyManagerBO dutyManagerBO : dutyManagerBOs) {
			DutyManager dutyManager = new DutyManager();
			dutyManager.setBeginDate(dutyManagerBO.getBeginDate());
			dutyManager.setComplaintNumber(dutyManagerBO.getComplaintNumber());
			dutyManager.setCreateTime(new Timestamp(dutyManagerBO.getCreateTime().getTime()));
			List<DutyBO> dutyBOs = dutyManagerBO.getDuties();
			List<Duty> dutys = new ArrayList<Duty>();
			for (DutyBO dutyBO : dutyBOs) {
				Duty duty = new Duty();
				duty.setCreateTime(new Timestamp(dutyBO.getCreateTime().getTime()));
				duty.setEmail(dutyBO.getEmail());
				duty.setId(dutyBO.getRemoteDutyId());
				duty.setIsManager(dutyBO.getIsManager());
				duty.setMobilePhone(dutyBO.getMobilePhone());
				duty.setName(dutyBO.getName());
				duty.setPhone(dutyBO.getPhone());
				duty.setResponsibility(dutyBO.getResponsibility());
				duty.setSex(dutyBO.getSex());
				
				dutys.add(duty);
			}
			dutyManager.setDuties(dutys);
			dutyManager.setDomainId(dutyManagerBO.getDomainId());
			dutyManager.setEndDate(dutyManagerBO.getEndDate());
			dutyManager.setId(String.valueOf(dutyManagerBO.getId()));
			
			dutyManagers.add(dutyManager);
		}
		
		return dutyManagers;
	}

	@Override
	public void deleteDutyManager(String dutyManagerId) {
		dao.deleteDutyManager(dutyManagerId);
	}

	public DutyManagerDao getDao() {
		return dao;
	}

	public void setDao(DutyManagerDao dao) {
		this.dao = dao;
	}
}
