package org.infosec.ismp.agent.winsensor.operation.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.operation.dao.AgentDutyManagerDao;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 7:57:39 PM
 *
 */
public class AgentDutyManagerDaoImpl extends HibernateDaoSupport implements AgentDutyManagerDao {

	@Override
	public void addDutyManager(AgentDutyManagerBO dutyManagerBO) {
		getHibernateTemplate().save(dutyManagerBO);
	}

	@Override
	public void deleteDutyManager(String dutyManagerId) {
		AgentDutyManagerBO dutyManagerBO = findDutyManagerById(dutyManagerId);
		if (dutyManagerBO != null) {
			getHibernateTemplate().delete(dutyManagerBO);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public AgentDutyManagerBO findDutyManagerById(String dutyManagerId) {
		if (StringUtils.isBlank(dutyManagerId)) {
			return null;
		}
		Criteria criteria = getSession().createCriteria(AgentDutyManagerBO.class);
		criteria.add(Restrictions.eq("id", Long.parseLong(dutyManagerId)));
		
		List<AgentDutyManagerBO> dutyManagerBOs = criteria.list();
		if (dutyManagerBOs.size() > 0) {
			return dutyManagerBOs.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AgentDutyManagerBO findDutyManagerById(String dutyManagerId,
			boolean expired) {
		if (StringUtils.isBlank(dutyManagerId)) {
			return null;
		}
		Criteria criteria = getSession().createCriteria(AgentDutyManagerBO.class);
		criteria.add(Restrictions.eq("id", Long.valueOf(dutyManagerId)));
		criteria.add(Restrictions.eq("expired", expired));
		
		List<AgentDutyManagerBO> dutyManagerBOs = criteria.list();
		if (dutyManagerBOs.size() > 0) {
			return dutyManagerBOs.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgentDutyManagerBO> getAllUnsentDutyManager(boolean expired) {
		Criteria criteria = getSession().createCriteria(AgentDutyManagerBO.class);
		criteria.add(Restrictions.eq("expired", false));
		
		return criteria.list();
	}

	@Override
	public void updateDutyManager(AgentDutyManagerBO dutyManager) {
		getHibernateTemplate().update(dutyManager);
	}
}
