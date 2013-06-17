package org.infosec.ismp.agent.winsensor.strategy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.strategy.dao.WindowsUpdateStrategyDao;
import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsUpdateStrategyBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time：Oct 20, 2010 8:36:24 PM
 * 
 */
public class WindowsUpdateStrategyDaoImpl extends HibernateDaoSupport implements WindowsUpdateStrategyDao {

	@Override
	public void addStrategy(WindowsUpdateStrategyBO strategy) {
		getHibernateTemplate().save(strategy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WindowsUpdateStrategyBO> findAllUnissuedStrategy() {
		Criteria criteria = getSession().createCriteria(WindowsUpdateStrategyBO.class);
		criteria.add(Restrictions.eq("issued", 0));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public WindowsUpdateStrategyBO findStrategy(String ip, String sensorId,
			boolean issued) {
		Criteria criteria = getSession().createCriteria(WindowsUpdateStrategyBO.class);
		criteria.add(Restrictions.eq("ip", ip))
			.add(Restrictions.eq("sensorId", sensorId));
		if (issued == true) {
			criteria.add(Restrictions.eq("issued", 1));
		} else {
			criteria.add(Restrictions.eq("issued", 0));
		}
		criteria.addOrder(Order.desc("createTime"));
		List<WindowsUpdateStrategyBO> strategy = criteria.list();
		if (strategy.size() > 0) {
			return strategy.get(0);
		}
		return null;
	}

	@Override
	public void updateStrategy(WindowsUpdateStrategyBO strategy) {
		getHibernateTemplate().update(strategy);
	}

}
