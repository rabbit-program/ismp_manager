package org.infosec.ismp.situation.dao.impl;

import java.util.List;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.SituationEventDao;
import org.infosec.ismp.situation.model.SituationEvent;


public class SituationEventDaoImpl extends BaseDaoHibernate implements SituationEventDao {

	@Override
	public void save(SituationEvent situationEvent) {
		getHibernateTemplate().save(situationEvent);
		
	}

	@Override
	public void save(List<SituationEvent> situationEvents) {
		for (SituationEvent situationEvent : situationEvents) {
			getHibernateTemplate().save(situationEvent);
		}
		
	}
	
}