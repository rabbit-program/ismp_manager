package org.infosec.ismp.situation.service.impl;

import java.util.List;

import org.infosec.ismp.situation.dao.MachineRoomSituationDao;
import org.infosec.ismp.situation.model.MachineRoomSituation;
import org.infosec.ismp.situation.service.MachineRoomSituationService;

public class MachineRoomSituationServiceImpl implements MachineRoomSituationService {

	private MachineRoomSituationDao machineRoomSituationDao;

	public void setMachineRoomSituationDao(MachineRoomSituationDao machineRoomSituationDao) {
		this.machineRoomSituationDao = machineRoomSituationDao;
	}

	public void save(MachineRoomSituation machineRoomSituation) {
		if (machineRoomSituation.getMachineRoom().getId() != null
				&& machineRoomSituation.getMachineRoom().getId() > 0
				&& machineRoomSituation.getTime() != null
				&& machineRoomSituation.getWholeSituation() > 0) {
			machineRoomSituationDao.save(machineRoomSituation);
		}
	}

	public void save(List<MachineRoomSituation> machineRoomSituations) {
		if (machineRoomSituations != null && machineRoomSituations.size() >0) {
			machineRoomSituationDao.save(machineRoomSituations);
		}
	}
}
