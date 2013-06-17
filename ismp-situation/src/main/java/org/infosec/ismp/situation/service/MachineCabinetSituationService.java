package org.infosec.ismp.situation.service;

import java.util.List;
import org.infosec.ismp.situation.model.MachineCabinetSituation;

public interface MachineCabinetSituationService {
	
	/**
	 * 存入一个机柜态势信息
	 * @param alarm
	 */
	void save(MachineCabinetSituation machineCabinetSituation);
	
	/**
	 * 存入多个机柜态势信息
	 * @param alarms
	 */
	void save(List<MachineCabinetSituation> machineCabinetSituations);
	

}
