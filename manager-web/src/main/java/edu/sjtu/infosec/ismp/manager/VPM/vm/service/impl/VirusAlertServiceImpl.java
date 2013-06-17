package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlerts;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertService;

public class VirusAlertServiceImpl implements VirusAlertService {
	
	private VirusAlertDao virusAlertsDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusAlertsDao(VirusAlertDao virusAlertsDao) {
		this.virusAlertsDao = virusAlertsDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirusAlert(VirusAlerts virusAlert) throws Exception {
		virusAlertsDao.addVirusAlert(virusAlert);
	}
	public void deleteVirusAlert(VirusAlerts virusAlert) throws Exception {
		virusAlertsDao.deleteVirusAlert(virusAlert);
	}
	public void updateVirusAlert(VirusAlerts virusAlert) throws Exception {
		virusAlertsDao.updateVirusAlert(virusAlert);
	}
	public List<VirusAlerts> findAllVirusAlert() throws Exception {
		List<VirusAlerts> list = virusAlertsDao.findAllVirusAlert();
		return list;
	}
	public VirusAlerts findVirusAlertById(int id) throws Exception {
		VirusAlerts virusAlert = virusAlertsDao.findVirusAlertById(id);
		return virusAlert;
	}
	public List<VirusAlerts> findAllVirusAlert(int startResult, int maxResult)
			throws Exception {
		List<VirusAlerts> list = virusAlertsDao.findAllVirusAlert(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return virusAlertsDao.findAllNum();
	}

}
