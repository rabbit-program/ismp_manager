package org.infosec.ismp.manager.db.dao;

import org.infosec.ismp.manager.model.DatabaseNodeEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class DatabaseNodeEntityDao extends HibernateDao<DatabaseNodeEntity, Integer> {
	/**
	 * 根据AgentId返回所有该Agent的DatabaseNodeEntity对象
	 * 
	 * @param agentId
	 * @return
	 */
//	public List<DatabaseNodeEntity> getAllDatabaseNodeByAgentId(String agentId) {
//		String hql = "from DatabaseNodeEntity db where db.agentId=?";
//		return findBy(hql, agentId);
//	}

	/**
	 * 根据nodeid删除对应的DatabaseNode
	 * 
	 * @param nodeid
	 */
	public void removeDatabaseNodeByNodeId(String nodeid) {
		String hql = "delete from DatabaseNodeEntity db where db.nodeid=?";
		batchExecute(hql, nodeid);
	}

}
