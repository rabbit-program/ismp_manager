package org.infosec.ismp.situation.service.impl;

import java.util.List;

import org.infosec.ismp.situation.dao.MachineSituationDao;
import org.infosec.ismp.situation.model.MachineSituation;
import org.infosec.ismp.situation.service.MachineSituationService;

public class MachineSituationServiceImpl implements MachineSituationService {

	private MachineSituationDao machineSituationDao;

	public void setMachineSituationDao(MachineSituationDao machineSituationDao) {
		this.machineSituationDao = machineSituationDao;
	}

	public void save(MachineSituation machineSituation) {
		if (machineSituation.getAttackThreat() > 0
				&& machineSituation.getInvalidConnection() > 0
				&& machineSituation.getIp() != null
				&& machineSituation.getIp().length() > 0
				&& machineSituation.getMachine().getId() > 0
				&& machineSituation.getTime() != null
				&& machineSituation.getVirusCondition() > 0
				&& machineSituation.getWholeSituation() > 0) {
			machineSituationDao.save(machineSituation);
		}
	}

	public void save(List<MachineSituation> machineSituations) {
		if (machineSituations != null && machineSituations.size() >0) {
			machineSituationDao.save(machineSituations);
		}
	}

}
