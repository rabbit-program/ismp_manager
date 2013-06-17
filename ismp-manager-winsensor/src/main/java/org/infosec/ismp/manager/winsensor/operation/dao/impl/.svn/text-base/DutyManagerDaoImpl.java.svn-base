package org.infosec.ismp.manager.winsensor.operation.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.winsensor.operation.dao.DutyManagerDao;
import org.infosec.ismp.manager.winsensor.operation.entity.DutyManagerBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Jan 6, 2011 2:08:40 PM
 *
 */
public class DutyManagerDaoImpl extends HibernateDaoSupport implements DutyManagerDao {

	@Override
	public void addDutyManager(DutyManagerBO dutyManagerBO) {
		getHibernateTemplate().save(dutyManagerBO);
	}

	@Override
	public void deleteDutyManager(String dutyManagerId) {
		DutyManagerBO dutyManagerBO = findDutyManagerById(dutyManagerId);
		if (dutyManagerBO != null) {
			getHibernateTemplate().delete(dutyManagerBO);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public DutyManagerBO findDutyManagerById(String dutyManagerId) {
		if (StringUtils.isBlank(dutyManagerId)) {
			return null;
		}
		Criteria criteria = getSession().createCriteria(DutyManagerBO.class);
		criteria.add(Restrictions.eq("id", Long.parseLong(dutyManagerId)));
		
		List<DutyManagerBO> dutyManagerBOs = criteria.list();
		if (dutyManagerBOs.size() > 0) {
			return dutyManagerBOs.get(0);
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DutyManagerBO> getAllDutyManagerById(List<String> dutyManagerIds) {
		Criteria criteria = getSession().createCriteria(DutyManagerBO.class);
		criteria.add(Restrictions.in("id", dutyManagerIds));
		criteria.add(Restrictions.eq("expired", false));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}
}
