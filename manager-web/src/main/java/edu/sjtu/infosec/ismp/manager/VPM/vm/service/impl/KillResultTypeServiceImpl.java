package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.KillResultTypeDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.KillResultType;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.KillResultTypeService;

public class KillResultTypeServiceImpl implements KillResultTypeService {
	
	private KillResultTypeDao killResultTypeDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setKillResultTypeDao(KillResultTypeDao killResultTypeDao) {
		this.killResultTypeDao = killResultTypeDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addKillResultType(KillResultType killResultType)
			throws Exception {
		killResultTypeDao.addKillResultType(killResultType);
	}
	public void deleteKillResultType(KillResultType killResultType)
			throws Exception {
		killResultTypeDao.deleteKillResultType(killResultType);
	}
	public void updateKillResultType(KillResultType killResultType)
			throws Exception {
		killResultTypeDao.updateKillResultType(killResultType);
	}
	public List<KillResultType> findAllKillResultType() throws Exception {
		List<KillResultType> list = killResultTypeDao.findAllKillResultType();
		return list;
	}
	public KillResultType findKillResultTypeById(int id) throws Exception {
		KillResultType killResultType = killResultTypeDao.findKillResultTypeById(id);
		return killResultType;
	}
	public List<KillResultType> findAllKillResultType(int startResult,
			int maxResult) throws Exception {
		List<KillResultType> list = killResultTypeDao.findAllKillResultType(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return killResultTypeDao.findAllNum();
	}

}
