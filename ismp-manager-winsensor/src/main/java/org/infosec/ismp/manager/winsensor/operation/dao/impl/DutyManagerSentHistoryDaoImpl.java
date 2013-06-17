package org.infosec.ismp.manager.winsensor.operation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.winsensor.operation.dao.DutyManagerSentHistoryDao;
import org.infosec.ismp.manager.winsensor.operation.entity.DutyManagerSentHistoryBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 6:52:11 PM
 *
 */
public class DutyManagerSentHistoryDaoImpl extends HibernateDaoSupport implements DutyManagerSentHistoryDao {

	@Override
	public void addSentHistory(DutyManagerSentHistoryBO sentHistory) {
		getHibernateTemplate().save(sentHistory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DutyManagerSentHistoryBO findSentHistory(String dutyManagerId,
			String agentId) {
		Criteria criteria = getSession().createCriteria(DutyManagerSentHistoryBO.class);
		criteria.add(Restrictions.eq("dutyManagerId", dutyManagerId));
		criteria.add(Restrictions.eq("agentId", agentId));
		criteria.addOrder(Order.desc("createTime"));
		
		List<DutyManagerSentHistoryBO> sentHistories = criteria.list();
		if (sentHistories.size() > 0) {
			return sentHistories.get(0);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DutyManagerSentHistoryBO> findSentHistory(String dutyManagerId) {
		Criteria criteria = getSession().createCriteria(DutyManagerSentHistoryBO.class);
		criteria.add(Restrictions.eq("dutyManagerId", dutyManagerId));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUnSentDutyManagerAgentId() {
		Criteria criteria = getSession().createCriteria(DutyManagerSentHistoryBO.class);
		criteria.add(Restrictions.eq("isSent", false));
		criteria.add(Restrictions.eq("expired",	 false));
		criteria.add(Restrictions.eq("isRemoved", false));
		criteria.addOrder(Order.desc("createTime"));
		
		List<DutyManagerSentHistoryBO> sentHistories = criteria.list();
		List<String> agentIds = new ArrayList<String>();
		
		for (DutyManagerSentHistoryBO sentHistory : sentHistories) {
			if (!agentIds.contains(sentHistory.getAgentId())) {
				agentIds.add(sentHistory.getAgentId());
			}
		}
		
		return agentIds;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUnsentDutyManagerId(String agentId, boolean expired) {
		Criteria criteria = getSession().createCriteria(DutyManagerSentHistoryBO.class);
		criteria.add(Restrictions.eq("agentId", agentId));
		criteria.add(Restrictions.eq("expired", expired));
		criteria.add(Restrictions.eq("isSent", false));
		criteria.add(Restrictions.eq("isRemoved", false));
		
		List<DutyManagerSentHistoryBO> sentHistories = criteria.list();
		List<String> dutyManagerIds = new ArrayList<String>();
		for (DutyManagerSentHistoryBO sentHistory : sentHistories) {
			dutyManagerIds.add(sentHistory.getDutyManagerId());
		}
		return dutyManagerIds;
	}
	
	@Override
	public void updateSentHistory(DutyManagerSentHistoryBO sentHistory) {
		getHibernateTemplate().update(sentHistory);
	}
}
