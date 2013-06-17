package org.infosec.ismp.manager.db.dao;

import java.util.List;

import org.infosec.ismp.manager.model.DatabaseNodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DatabaseNodeEntityService {
	private DatabaseNodeEntityDao m_databaseNodeEntityDao;

	@Autowired(required = true)
	public void setDatabaseNodeEntityDao(DatabaseNodeEntityDao databaseNodeEntityDao) {
		m_databaseNodeEntityDao = databaseNodeEntityDao;
	}

	@Transactional
	public List<DatabaseNodeEntity> getAll() {
		return m_databaseNodeEntityDao.getAll();
	}
	@Transactional
	public void save(DatabaseNodeEntity entity) {
		m_databaseNodeEntityDao.save(entity);
		
	}
	@Transactional
	public void removeDatabaseNodeByNodeId(String nodeid) {
		m_databaseNodeEntityDao.removeDatabaseNodeByNodeId(nodeid);
	}
}
