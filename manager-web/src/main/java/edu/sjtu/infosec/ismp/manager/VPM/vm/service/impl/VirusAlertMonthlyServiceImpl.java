package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertMonthlyDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsMonthly;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertMonthlyService;

public class VirusAlertMonthlyServiceImpl implements VirusAlertMonthlyService {
	
	private VirusAlertMonthlyDao virusAlertsMonthlyDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusAlertsMonthlyDao(VirusAlertMonthlyDao virusAlertsMonthlyDao) {
		this.virusAlertsMonthlyDao = virusAlertsMonthlyDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly)
			throws Exception {
		virusAlertsMonthlyDao.addVirusAlertMonthly(virusAlertMonthly);
	}
	public void deleteVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly)
			throws Exception {
		virusAlertsMonthlyDao.deleteVirusAlertMonthly(virusAlertMonthly);
	}
	public void updateVirusAlertMonthly(VirusAlertsMonthly virusAlertMonthly)
			throws Exception {
		virusAlertsMonthlyDao.updateVirusAlertMonthly(virusAlertMonthly);
	}
	public List<VirusAlertsMonthly> findAllVirusAlertMonthly() throws Exception {
		List<VirusAlertsMonthly> list = virusAlertsMonthlyDao.findAllVirusAlertMonthly();
		return list;
	}
	public VirusAlertsMonthly findVirusAlertMonthlyById(int id) throws Exception {
		VirusAlertsMonthly virusAlertMonthly = virusAlertsMonthlyDao.findVirusAlertMonthlyById(id);
		return virusAlertMonthly;
	}
	public List<VirusAlertsMonthly> findAllVirusAlertMonthly(int startResult,
			int maxResult) throws Exception {
		List<VirusAlertsMonthly> list = virusAlertsMonthlyDao.findAllVirusAlertMonthly(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return virusAlertsMonthlyDao.findAllNum();
	}

}
