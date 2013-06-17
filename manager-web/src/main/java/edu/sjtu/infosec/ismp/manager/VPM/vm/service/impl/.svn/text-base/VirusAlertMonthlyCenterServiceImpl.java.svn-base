package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertMonthlyCenterDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsMonthlyCenter;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertMonthlyCenterService;

public class VirusAlertMonthlyCenterServiceImpl implements VirusAlertMonthlyCenterService {
	
	private VirusAlertMonthlyCenterDao virusAlertsMonthlyCenterDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusAlertsMonthlyCenterDao(VirusAlertMonthlyCenterDao virusAlertsMonthlyCenterDao) {
		this.virusAlertsMonthlyCenterDao = virusAlertsMonthlyCenterDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirusAlertMonthlyCenter(
			VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception {
		virusAlertsMonthlyCenterDao.addVirusAlertMonthlyCenter(virusAlertMonthlyCenter);
	}
	public void deleteVirusAlertMonthlyCenter(
			VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception {
		virusAlertsMonthlyCenterDao.deleteVirusAlertMonthlyCenter(virusAlertMonthlyCenter);
	}
	public void updateVirusAlertMonthlyCenter(
			VirusAlertsMonthlyCenter virusAlertMonthlyCenter) throws Exception {
		virusAlertsMonthlyCenterDao.updateVirusAlertMonthlyCenter(virusAlertMonthlyCenter);
	}
	public List<VirusAlertsMonthlyCenter> findAllVirusAlertMonthlyCenter()
			throws Exception {
		List<VirusAlertsMonthlyCenter> list = virusAlertsMonthlyCenterDao.findAllVirusAlertMonthlyCenter();
		return list;
	}
	public VirusAlertsMonthlyCenter findVirusAlertMonthlyCenterById(int id)
			throws Exception {
		VirusAlertsMonthlyCenter virusAlertMonthlyCenter = virusAlertsMonthlyCenterDao.findVirusAlertMonthlyCenterById(id);
		return virusAlertMonthlyCenter;
	}
	public List<VirusAlertsMonthlyCenter> findAllVirusAlertMonthlyCenter(
			int startResult, int maxResult) throws Exception {
		List<VirusAlertsMonthlyCenter> list = virusAlertsMonthlyCenterDao.findAllVirusAlertMonthlyCenter(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return virusAlertsMonthlyCenterDao.findAllNum();
	}

}
