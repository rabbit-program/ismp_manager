package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertDailyCenterDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsDailyCenter;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertDailyCenterService;

public class VirusAlertDailyCenterServiceImpl implements VirusAlertDailyCenterService {
	
	private VirusAlertDailyCenterDao virusAlertsDailyCenterDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusAlertsDailyCenterDao(VirusAlertDailyCenterDao virusAlertsDailyCenterDao) {
		this.virusAlertsDailyCenterDao = virusAlertsDailyCenterDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirusAlertDailyCenter(
			VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception {
		virusAlertsDailyCenterDao.addVirusAlertDailyCenter(virusAlertDailyCenter);
	}
	public void deleteVirusAlertDailyCenter(
			VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception {
		virusAlertsDailyCenterDao.deleteVirusAlertDailyCenter(virusAlertDailyCenter);
	}
	public void updateVirusAlertDailyCenter(
			VirusAlertsDailyCenter virusAlertDailyCenter) throws Exception {
		virusAlertsDailyCenterDao.updateVirusAlertDailyCenter(virusAlertDailyCenter);
	}
	public List<VirusAlertsDailyCenter> findAllVirusAlertDailyCenter()
			throws Exception {
		List<VirusAlertsDailyCenter> list = virusAlertsDailyCenterDao.findAllVirusAlertDailyCenter();
		return list;
	}
	public VirusAlertsDailyCenter findVirusAlertDailyCenterById(int id)
			throws Exception {
		VirusAlertsDailyCenter virusAlertDailyCenter = virusAlertsDailyCenterDao.findVirusAlertDailyCenterById(id);
		return virusAlertDailyCenter;
	}
	public List<VirusAlertsDailyCenter> findAllVirusAlertDailyCenter(
			int startResult, int maxResult) throws Exception {
		List<VirusAlertsDailyCenter> list = virusAlertsDailyCenterDao.findAllVirusAlertDailyCenter(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return virusAlertsDailyCenterDao.findAllNum();
	}

}
