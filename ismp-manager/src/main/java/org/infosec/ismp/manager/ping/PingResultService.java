package org.infosec.ismp.manager.ping;

import org.infosec.ismp.manager.model.PingResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PingResultService {
	private PingResultDao m_pingResultDao;

	@Autowired(required = true)
	public void setPingResultDao(PingResultDao pingResultDao) {
		m_pingResultDao = pingResultDao;
	}

	@Transactional
	public void savePingResult(PingResultEntity entity) {
		m_pingResultDao.save(entity);
	}
}
