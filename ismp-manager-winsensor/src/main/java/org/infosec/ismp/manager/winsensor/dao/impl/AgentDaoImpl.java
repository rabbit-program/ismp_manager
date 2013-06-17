package org.infosec.ismp.manager.winsensor.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.winsensor.dao.AgentDao;
import org.infosec.ismp.manager.winsensor.entity.AgentBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Dec 23, 2010 4:26:03 PM
 *
 */
public class AgentDaoImpl extends HibernateDaoSupport implements AgentDao {

	@Override
	public void addAgent(AgentBO agent) {
		getHibernateTemplate().save(agent);
	}

	@Override
	public void updateAgent(AgentBO agent) {
		getHibernateTemplate().update(agent);
	}

	@Override
	public void deleteAgent(AgentBO agent) {
		getHibernateTemplate().delete(agent);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgentBO> getAllAgent() {
		Criteria criteria = getSession().createCriteria(AgentBO.class);
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AgentBO findByAgentId(String agentId) {
		if (StringUtils.isBlank(agentId)) {
			return null;
		}
		
		Criteria criteria = getSession().createCriteria(AgentBO.class);
		criteria.add(Restrictions.eq("agentId", agentId));
		criteria.addOrder(Order.desc("createTime"));
		List<AgentBO> agents = criteria.list();
		
		if (agents.size() > 0) {
			return agents.get(0);
		}
		
		return null;
	}
}
