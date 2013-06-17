package org.infosec.ismp.agent.winsensor.strategy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.strategy.dao.WinsensorManagerStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.WinsensorManagerStrategyBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:37:01 PM
 * 
 */
public class WinsensorManagerStrategyDaoImpl extends HibernateDaoSupport implements
		WinsensorManagerStrategyDao {

	@Override
	public void addStrategy(WinsensorManagerStrategyBO strategy) {
		getHibernateTemplate().save(strategy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WinsensorManagerStrategyBO> findAllUnissuedStrategy() {
		Criteria criteria = getSession().createCriteria(WinsensorManagerStrategyBO.class);
		criteria.add(Restrictions.eq("issued", 0));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public WinsensorManagerStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		Criteria criteria = getSession().createCriteria(WinsensorManagerStrategyBO.class);
		criteria.add(Restrictions.eq("ip", ip)).add(Restrictions.eq("sensorId", sensorId));
		if (issued == true) {
			criteria.add(Restrictions.eq("issued", 1));
		} else {
			criteria.add(Restrictions.eq("issued", 0));
		}
		criteria.addOrder(Order.desc("createTime"));
		List<WinsensorManagerStrategyBO> strategy = criteria.list();
		if (strategy.size() > 0) {
			return strategy.get(0);
		}
		return null;
	}

	@Override
	public void updateStrategy(WinsensorManagerStrategyBO strategy) {
		getHibernateTemplate().update(strategy);
	}

}
