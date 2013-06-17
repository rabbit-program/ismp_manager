package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertDailyDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsDaily;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertDailyService;

public class VirusAlertDailyServiceImpl implements VirusAlertDailyService {
	
	private VirusAlertDailyDao virusAlertsDailyDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusAlertsDailyDao(VirusAlertDailyDao virusAlertsDailyDao) {
		this.virusAlertsDailyDao = virusAlertsDailyDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirusAlertDaily(VirusAlertsDaily virusAlertDaily)
			throws Exception {
		virusAlertsDailyDao.addVirusAlertDaily(virusAlertDaily);
	}
	public void deleteVirusAlertDaily(VirusAlertsDaily virusAlertDaily)
			throws Exception {
		virusAlertsDailyDao.deleteVirusAlertDaily(virusAlertDaily);
	}
	public void updateVirusAlertDaily(VirusAlertsDaily virusAlertDaily)
			throws Exception {
		virusAlertsDailyDao.updateVirusAlertDaily(virusAlertDaily);
	}
	public List<VirusAlertsDaily> findAllVirusAlertDaily() throws Exception {
		List<VirusAlertsDaily> list = virusAlertsDailyDao.findAllVirusAlertDaily();
		return list;
	}
	public VirusAlertsDaily findVirusAlertDailyById(int id) throws Exception {
		VirusAlertsDaily virusAlertDaily = virusAlertsDailyDao.findVirusAlertDailyById(id);
		return virusAlertDaily;
	}
	public List<VirusAlertsDaily> findAllVirusAlertDaily(int startResult,
			int maxResult) throws Exception {
		List<VirusAlertsDaily> list = virusAlertsDailyDao.findAllVirusAlertDaily(startResult, maxResult);
		return list;
	}
	public long findAllNum() throws Exception {
		return virusAlertsDailyDao.findAllNum();
	}

}
