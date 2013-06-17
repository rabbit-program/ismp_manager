package org.infosec.ismp.situation.service.impl;

import java.util.List;

import org.infosec.ismp.situation.dao.MachineCabinetSituationDao;
import org.infosec.ismp.situation.model.MachineCabinetSituation;
import org.infosec.ismp.situation.service.MachineCabinetSituationService;

public class MachineCabinetSituationServiceImpl implements MachineCabinetSituationService {

	private MachineCabinetSituationDao machineCabinetSituationDao;

	public void setMachineCabinetSituationDao(
			MachineCabinetSituationDao machineCabinetSituationDao) {
		this.machineCabinetSituationDao = machineCabinetSituationDao;
	}

	public void save(MachineCabinetSituation machineCabinetSituation) {
		if (machineCabinetSituation.getMachineCabinet().getId() != null
				&& machineCabinetSituation.getMachineCabinet().getId() > 0
				&& machineCabinetSituation.getMachineCabinetName()!= null
				&& machineCabinetSituation.getMachineCabinetName().length() > 0
				&& machineCabinetSituation.getTime() != null
				&& machineCabinetSituation.getWholeSituation() > 0) {
			machineCabinetSituationDao.save(machineCabinetSituation);
		}
	}

	public void save(List<MachineCabinetSituation> machineCabinetSituations) {
		if (machineCabinetSituations != null && machineCabinetSituations.size() >0) {
			machineCabinetSituationDao.save(machineCabinetSituations);
		}

	}

}
