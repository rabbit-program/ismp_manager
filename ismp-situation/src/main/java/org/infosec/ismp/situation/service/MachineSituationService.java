package org.infosec.ismp.situation.service;

import java.util.List;

import org.infosec.ismp.situation.model.MachineSituation;

public interface MachineSituationService {
	
	/**
	 * 存入一个对象
	 * @param alarm
	 */
	void save(MachineSituation machineSituation);
	
	/**
	 * 存入多个对象
	 * @param alarms
	 */
	void save(List<MachineSituation> machineSituations);

}
