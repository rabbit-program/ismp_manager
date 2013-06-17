package org.infosec.ismp.situation.dao;

import java.util.List;

import org.infosec.ismp.situation.common.BaseDao;
import org.infosec.ismp.situation.model.MachineCabinetSituation;

public interface MachineCabinetSituationDao extends BaseDao {
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
