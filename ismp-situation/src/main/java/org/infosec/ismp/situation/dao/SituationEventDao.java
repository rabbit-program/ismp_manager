package org.infosec.ismp.situation.dao;

import java.util.List;

import org.infosec.ismp.situation.common.BaseDao;
import org.infosec.ismp.situation.model.SituationEvent;

public interface SituationEventDao extends BaseDao{
	/**
	 * 存入一个对象
	 * @param alarm
	 */
	void save(SituationEvent situationEvent);
	
	/**
	 * 存入多个对象
	 * @param alarms
	 */
	void save(List<SituationEvent> situationEvents);
}
