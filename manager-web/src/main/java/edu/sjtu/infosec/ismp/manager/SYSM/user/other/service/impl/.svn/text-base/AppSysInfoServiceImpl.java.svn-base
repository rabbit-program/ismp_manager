package edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.impl;

import java.sql.Timestamp;
import java.util.List;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.dao.AppSysInfoDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysInfo;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.AppSysInfoService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;

public class AppSysInfoServiceImpl implements AppSysInfoService {
	private AppSysInfoDao appSysInfoDao;
	public void setAppSysInfoDao(AppSysInfoDao appSysInfoDao) {
		this.appSysInfoDao = appSysInfoDao;
	}
	public List<AppSysInfo> findConditionsInfo(AppSysInfo syInfo,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
		return appSysInfoDao.findConditionsInfo(syInfo, domainList, page, startRecordTime, endRecordTime);
	}
	public void add(AppSysInfo appSysInfo) throws Exception {
		 appSysInfoDao.add(appSysInfo);
	}
	public void delete(AppSysInfo appSysInfo) throws Exception {
		 appSysInfoDao.delete(appSysInfo);
	}
	public void update(AppSysInfo appSysInfo) throws Exception {
		 appSysInfoDao.update(appSysInfo);
	}
	public AppSysInfo findById(int id) throws Exception {
		return appSysInfoDao.findById(id);
	}
	public List<AppSysInfo> findAll() throws Exception {
		return appSysInfoDao.findAll();
	}
	public List<AppSysInfo> findAllByDomain(List<Domain> domainList)
			throws Exception {
		return appSysInfoDao.findAllByDomain(domainList);
	}

	
 

}
