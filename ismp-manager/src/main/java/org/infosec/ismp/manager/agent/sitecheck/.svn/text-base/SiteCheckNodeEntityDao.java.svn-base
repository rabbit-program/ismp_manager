package org.infosec.ismp.manager.agent.sitecheck;

import java.util.List;

import org.infosec.ismp.manager.model.SiteCheckNodeEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * 
 * @author jiel
 *
 */
@Component
public class SiteCheckNodeEntityDao extends HibernateDao<SiteCheckNodeEntity, Integer> {
	/**
	 * 根据AgentId返回所有该Agent的SiteCheckNodeEntity对象
	 * 
	 * @param agentId
	 * @return
	 */
	public List<SiteCheckNodeEntity> getAllSiteCheckNodeByAgentId(String agentId) {
		String hql = "from SiteCheckNodeEntity site where site.agentId=?";
		return findBy(hql, agentId);
	}

	/**
	 * 根据nodeid删除对应的SiteCheckNodeEntity
	 * 
	 * @param nodeid
	 */
	public void removeSiteCheckNodeByNodeId(String nodeid) {
		String hql = "delete from SiteCheckNodeEntity site where site.nodeid=?";
		batchExecute(hql, nodeid);
	}
}
