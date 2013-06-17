package edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.AppSysRoleDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysRole;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.AppSysRoleService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;

public class AppSysRoleServiceImpl implements AppSysRoleService {
	private AppSysRoleDao appSysRoleDao;
	public void setAppSysRoleDao(AppSysRoleDao appSysRoleDao) {
		this.appSysRoleDao = appSysRoleDao;
	}
//	private SystemLogService systemlogservice;
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	public void add(AppSysRole appSysRole) throws Exception {
		appSysRoleDao.add(appSysRole);
	}
	public void delete(AppSysRole appSysRole) throws Exception {
		appSysRoleDao.delete(appSysRole);
	}
	public AppSysRole findById(int id) throws Exception {
		return appSysRoleDao.findById(id);
	}
	public List<AppSysRole> findConditionsInfo(AppSysRole appSysRole,
			PMPage page, Timestamp startRecordTime, Timestamp endRecordTime) {
		return appSysRoleDao.findConditionsInfo(appSysRole, page, startRecordTime, endRecordTime);
	}
	public void update(AppSysRole appSysRole) throws Exception {
		appSysRoleDao.update(appSysRole);	
	}
	public List<AppSysRole> findAll() throws Exception {
		return appSysRoleDao.findAll();
	}
	public List<AppSysRole> findASIById(int asid) throws Exception {
		return appSysRoleDao.findASIById(asid);
	}
	
	
}
