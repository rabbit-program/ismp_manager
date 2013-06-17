package edu.sjtu.infosec.ismp.manager.VPM.pm.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.dao.PatchTacticsDao;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateTactics;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.PatchTacticsService;

public class PatchTacicsServiceImpl implements PatchTacticsService {

	private PatchTacticsDao patchTactics;
	public void setPatchTactics(PatchTacticsDao patchTactics) {
		this.patchTactics = patchTactics;
	}
	public void delPatchUpdateTactics(int stId) {
		patchTactics.delPatchUpdateTactics(stId);		
	}
	public List<PatchUpdateTactics> getAllPachStrategy() {
		return patchTactics.getAllPachStrategy();
	}
	public String getDefAddress() {
		return patchTactics.getDefAddress();
	}
	public String getGlobalPatchUpdateTactics() {
		return patchTactics.getGlobalPatchUpdateTactics();
	}
	public PatchUpdateTactics getPachStrategyById(int pachStrategyId) {
		return patchTactics.getPachStrategyById(pachStrategyId);
	}
	public void saveOrUpdatePatchUpdateTactics(
			PatchUpdateTactics patchUpdateTactics) {
		patchTactics.saveOrUpdatePatchUpdateTactics(patchUpdateTactics);
		
	}
	public void setGlobalPatchUpdateTactics(int patchUpdateTacticsId) {
		patchTactics.setGlobalPatchUpdateTactics(patchUpdateTacticsId);
	}
	public LinkedList getTacticsInfos(PatchUpdateTactics patchTactic,
			Integer startResult, Integer maxResult, Date startDate, Date endDate) {
	 return	patchTactics.getTacticsInfos(patchTactic, startResult, maxResult, startDate, endDate);
	}




}
