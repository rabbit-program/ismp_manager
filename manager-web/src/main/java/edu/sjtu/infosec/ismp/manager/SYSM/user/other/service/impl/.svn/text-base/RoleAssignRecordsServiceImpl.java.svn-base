package edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.RoleAssignRecordsDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.RoleAssignRecords;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.RoleAssignRecordsService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;

public class RoleAssignRecordsServiceImpl implements RoleAssignRecordsService {
	private RoleAssignRecordsDao roleAssignRecordsDao;
	public void setRoleAssignRecordsDao(RoleAssignRecordsDao roleAssignRecordsDao) {
		this.roleAssignRecordsDao = roleAssignRecordsDao;
	}
//	private SystemLogService systemlogservice;
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	public void add(RoleAssignRecords roleAssignRecords) throws Exception {
		roleAssignRecordsDao.add(roleAssignRecords);
	}
	public void delete(RoleAssignRecords roleAssignRecords) throws Exception {
		roleAssignRecordsDao.delete(roleAssignRecords);
	}
	public RoleAssignRecords findById(int id) throws Exception {
		return roleAssignRecordsDao.findById(id);
	}
	public List<RoleAssignRecords> findConditionsInfo(
			RoleAssignRecords roleAssignRecords, PMPage page,
			Timestamp startRecordTime, Timestamp endRecordTime) {
		return roleAssignRecordsDao.findConditionsInfo(roleAssignRecords, page, startRecordTime, endRecordTime);
	}
	public void update(RoleAssignRecords roleAssignRecords) throws Exception {
		roleAssignRecordsDao.update(roleAssignRecords);		
	}
	
	

}
