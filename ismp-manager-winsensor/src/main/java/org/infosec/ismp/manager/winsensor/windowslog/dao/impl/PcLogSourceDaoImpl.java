package org.infosec.ismp.manager.winsensor.windowslog.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.winsensor.windowslog.dao.PcLogSourceDao;
import org.infosec.ismp.manager.winsensor.windowslog.entity.PcLogSourceBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Dec 28, 2010 11:04:27 AM
 *
 */
public class PcLogSourceDaoImpl extends HibernateDaoSupport implements PcLogSourceDao {

	@Override
	public void addSource(PcLogSourceBO source) {
		getHibernateTemplate().save(source);
	}

	@Override
	public void updateSource(PcLogSourceBO source) {
		getHibernateTemplate().update(source);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PcLogSourceBO findSourceBySensorId(String sensorId) {
		if (StringUtils.isBlank(sensorId)) {
			return null;
		}
		
		Criteria criteria = getSession().createCriteria(PcLogSourceBO.class);
		criteria.add(Restrictions.eq("sensorId", sensorId));
		criteria.add(Restrictions.eq("enable", true));
		criteria.addOrder(Order.desc("createTime"));
		
		List<PcLogSourceBO> sources = criteria.list();
		if (sources.size() > 0) {
			return sources.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcLogSourceBO> getAllUnSynchronizedSource() {
		Criteria criteria = getSession().createCriteria(PcLogSourceBO.class);
		criteria.add(Restrictions.eq("isSynchronized", false));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}
}
