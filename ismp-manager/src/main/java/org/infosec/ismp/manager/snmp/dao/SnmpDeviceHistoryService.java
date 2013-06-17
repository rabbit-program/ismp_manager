package org.infosec.ismp.manager.snmp.dao;

import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guoxianwei
 * @date 2010-12-24 上午10:11:38
 * 
 */
@Component
public class SnmpDeviceHistoryService {

	private SnmpDeviceHistoryEntityDao m_hitoryDao;

	@Autowired(required = true)
	public void setHitoryDao(SnmpDeviceHistoryEntityDao hitoryDao) {
		m_hitoryDao = hitoryDao;
	}

	@Transactional
	public void saveSnmpDeviceHistory(SnmpDeviceHistoryBaseEntity historyEntity) {
		if (historyEntity != null) {
			m_hitoryDao.save(historyEntity);
		}
	}
}

