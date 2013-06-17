package org.infosec.ismp.agent.winsensor.operation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.operation.dao.AgentDutyManagerSentHisDao;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerSentHisBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 9:58:50 PM
 *
 */
public class AgentDutyManagerSentHisDaoImpl extends HibernateDaoSupport implements
		AgentDutyManagerSentHisDao {
	
	@Override
	public void addSentHistory(AgentDutyManagerSentHisBO sentHistory) {
		getHibernateTemplate().save(sentHistory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AgentDutyManagerSentHisBO findSentHistory(String dutyManagerId, String sensorId) {
		Criteria criteria = getSession().createCriteria(AgentDutyManagerSentHisBO.class);
		criteria.add(Restrictions.eq("dutyManagerId", dutyManagerId));
		criteria.add(Restrictions.eq("sensorId", sensorId));
		criteria.addOrder(Order.desc("createTime"));
		
		List<AgentDutyManagerSentHisBO> sentHistories = criteria.list();
		if (sentHistories.size() > 0) {
			return sentHistories.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AgentDutyManagerSentHisBO findRemovedHistory(String sensorId) {
		Criteria criteria = getSession().createCriteria(AgentDutyManagerSentHisBO.class);
		criteria.add(Restrictions.eq("sensorId", sensorId));
		criteria.add(Restrictions.eq("isRemoved", true));
		criteria.add(Restrictions.eq("removedTime", null));
		criteria.addOrder(Order.desc("sendTime"));
		
		List<AgentDutyManagerSentHisBO> sentHistories = criteria.list();
		if (sentHistories.size() > 0) {
			return sentHistories.get(0);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUnsentDutySensorId() {
		//If the impact of the performance, use the HQL statement. 
		Criteria criteria = getSession().createCriteria(AgentDutyManagerSentHisBO.class);
		criteria.add(Restrictions.eq("isSent", false));
		criteria.add(Restrictions.eq("expired", false));
		criteria.add(Restrictions.eq("isRemoved", false));
		
		List<AgentDutyManagerSentHisBO> sentHistories = criteria.list();
		List<String> sensorIds = new ArrayList<String>();
		
		for (AgentDutyManagerSentHisBO sentHistory : sentHistories) {
			sensorIds.add(sentHistory.getSensorId());
		}
		
		return sensorIds;
	}
	
	@Override
	public void updateSentHistory(AgentDutyManagerSentHisBO sentHistory) {
		getHibernateTemplate().update(sentHistory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgentDutyManagerSentHisBO> getAllUnsentDutyManager(String sensorId) {
		Criteria criteria = getSession().createCriteria(AgentDutyManagerSentHisBO.class);
		criteria.add(Restrictions.eq("sensorId", sensorId));
		criteria.add(Restrictions.eq("expired", false));
		criteria.add(Restrictions.eq("isSent", false));
		criteria.add(Restrictions.eq("isRemoved", false));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgentDutyManagerSentHisBO> findSentHistory(String dutyManagerId) {
		Criteria criteria = getSession().createCriteria(AgentDutyManagerSentHisBO.class);
		criteria.add(Restrictions.eq("dutyManagerId", dutyManagerId));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUnsentDutyManager(List<String> dutyManagerIds) {
		Criteria criteria = getSession().createCriteria(AgentDutyManagerSentHisBO.class);
		criteria.add(Restrictions.in("dutyManagerId", dutyManagerIds));
		criteria.add(Restrictions.eq("isSent", false));
		criteria.add(Restrictions.eq("expired", false));
		criteria.add(Restrictions.eq("isRemoved", false));
		
		List<AgentDutyManagerSentHisBO> sentHistories = criteria.list();
		List<String> sensorIds = new ArrayList<String>();
		
		for (AgentDutyManagerSentHisBO sentHistory : sentHistories) {
			if (!sensorIds.contains(sentHistory.getSensorId())) {
				sensorIds.add(sentHistory.getSensorId());
			}
		}
		
		return sensorIds;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUnremovedDutySensorId() {
		Criteria criteria = getSession().createCriteria(AgentDutyManagerSentHisBO.class);
		criteria.add(Restrictions.eq("isRemoved", true));
		criteria.add(Restrictions.eq("isSent", true));
		criteria.add(Restrictions.eq("expired", false));
		criteria.add(Restrictions.eq("removedTime", null));
		
		List<AgentDutyManagerSentHisBO> sentHistories = criteria.list();
		List<String> sensorIds = new ArrayList<String>();
		
		for (AgentDutyManagerSentHisBO sentHistory : sentHistories) {
			if (!sensorIds.contains(sentHistory.getSensorId())) {
				sensorIds.add(sentHistory.getSensorId());
			}
		}
		
		return sensorIds;
	}
}
