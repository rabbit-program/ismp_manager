package org.infosec.ismp.agent.winsensor.strategy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.strategy.dao.SoftwareUpdateStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.SoftwareUpdateStrategyBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:35:00 PM
 * 
 */
public class SoftwareUpdateStrategyDaoImpl extends HibernateDaoSupport implements SoftwareUpdateStrategyDao {

	@Override
	public void addStrategy(SoftwareUpdateStrategyBO strategy) {
		getHibernateTemplate().save(strategy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SoftwareUpdateStrategyBO> findAllUnissuedStrategy() {
		Criteria criteria = getSession().createCriteria(SoftwareUpdateStrategyBO.class);
		criteria.add(Restrictions.eq("issued", 0));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SoftwareUpdateStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		Criteria criteria = getSession().createCriteria(SoftwareUpdateStrategyBO.class);
		criteria.add(Restrictions.eq("ip", ip));
		criteria.add(Restrictions.eq("sensorId", sensorId));
		if (issued == true) {
			criteria.add(Restrictions.eq("issued", 1));
		} else {
			criteria.add(Restrictions.eq("issued", 0));
		}
		criteria.addOrder(Order.desc("createTime"));
		List<SoftwareUpdateStrategyBO> strategy = criteria.list();
		if (strategy.size() > 0) {
			return strategy.get(0);
		} 
		return null;
	}

	@Override
	public void updateStrategy(SoftwareUpdateStrategyBO strategy) {
		getHibernateTemplate().update(strategy);
	}

}
