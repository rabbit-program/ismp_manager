package org.infosec.ismp.manager.winsensor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.winsensor.dao.ThresholdDao;
import org.infosec.ismp.manager.winsensor.entity.ThresholdBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 2:00:19 PM
 *
 */
public class ThresholdDaoImpl extends HibernateDaoSupport implements ThresholdDao {

	@Override
	public void addThreshold(ThresholdBO threshold) {
		getHibernateTemplate().save(threshold);
	}

	@Override
	public void updateThreshold(ThresholdBO threshold) {
		getHibernateTemplate().update(threshold);
	}

	@Override
	public void deleteThreshold(ThresholdBO threshold) {
		getHibernateTemplate().delete(threshold);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThresholdBO> findThresholdByNodeId(String nodeId) {
		if (StringUtils.isBlank(nodeId)) {
			return new ArrayList<ThresholdBO>();
		}
		
		Criteria criteria = getSession().createCriteria(ThresholdBO.class);
		criteria.add(Restrictions.eq("nodeId", nodeId));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ThresholdBO findThresholdById(long id) {
		Criteria criteria = getSession().createCriteria(ThresholdBO.class);
		criteria.add(Restrictions.eq("id", id));
		List<ThresholdBO> thresholds = criteria.list();
		
		if (thresholds.size() > 0) {
			return thresholds.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ThresholdBO> getAllThreshold() {
		Criteria criteria = getSession().createCriteria(ThresholdBO.class);
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

}
