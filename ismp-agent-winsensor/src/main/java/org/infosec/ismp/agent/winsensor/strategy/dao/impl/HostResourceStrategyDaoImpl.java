package org.infosec.ismp.agent.winsensor.strategy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.strategy.dao.HostResourceStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.HostResourceStrategyBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:33:32 PM
 * 
 */
public class HostResourceStrategyDaoImpl extends HibernateDaoSupport implements HostResourceStrategyDao {

	@Override
	public void addStrategy(HostResourceStrategyBO strategy) {
		getHibernateTemplate().save(strategy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HostResourceStrategyBO> findAllUnissuedStrategy() {
		Criteria criteria = getSession().createCriteria(HostResourceStrategyBO.class);
		criteria.add(Restrictions.eq("issued", 0));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public HostResourceStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		Criteria criteria = getSession().createCriteria(HostResourceStrategyBO.class);
		criteria.add(Restrictions.eq("ip", ip));
		criteria.add(Restrictions.eq("sensorId", sensorId));
		if (issued == true) {
			criteria.add(Restrictions.eq("issued", 1));
		} else {
			criteria.add(Restrictions.eq("issued", 0));
		}
		criteria.addOrder(Order.desc("createTime"));
		List<HostResourceStrategyBO> strategy = criteria.list();
		if (strategy.size() > 0) {
			return strategy.get(0);
		} 
		return null;
	}

	@Override
	public void updateStrategy(HostResourceStrategyBO strategy) {
		getHibernateTemplate().update(strategy);
	}

}
