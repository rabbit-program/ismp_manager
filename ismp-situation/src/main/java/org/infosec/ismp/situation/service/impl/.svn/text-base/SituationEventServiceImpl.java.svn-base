package org.infosec.ismp.situation.service.impl;

import java.util.List;

import org.infosec.ismp.situation.dao.SituationEventDao;
import org.infosec.ismp.situation.model.SituationEvent;
import org.infosec.ismp.situation.service.SituationEventService;

public class SituationEventServiceImpl implements SituationEventService {

	private SituationEventDao situationEventDao;

	public void setSituationEventDao(SituationEventDao situationEventDao) {
		this.situationEventDao = situationEventDao;
	}

	@Override
	public void save(SituationEvent situationEvent) {
		situationEventDao.saveObject(situationEvent);
	}

	@Override
	public void save(List<SituationEvent> situationEvents) {
		if(null != situationEvents && situationEvents.size() > 0){
			situationEventDao.save(situationEvents);
		}
	}
	
	
}
