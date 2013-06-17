package org.infosec.ismp.manager.db.dao;

import org.infosec.ismp.manager.model.db.DatabaseResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guoxianwei
 * @date 2010-12-15 下午07:03:30
 * 
 *  执行DB采集信息入库
 *  
 */
@Component
@Transactional
public class DatabaseResultService {

	private DatabaseResultDao m_databaseResultDao;

	@Autowired(required = true)
	public void setDatabaseResultDao(DatabaseResultDao databaseResultDao) {
		m_databaseResultDao = databaseResultDao;
	}

	@Transactional
	public void saveDatabaseResult(DatabaseResultEntity entity) {
		m_databaseResultDao.save(entity);
	}

}

