package org.infosec.ismp.manager.winsensor.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.winsensor.dao.ManagerWinsensorDeviceDao;
import org.infosec.ismp.manager.winsensor.entity.ManagerWinsensorDeviceBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time: Dec 23, 2010 4:26:43 PM
 *
 */
public class ManagerWinsensorDeviceDaoImpl extends HibernateDaoSupport implements ManagerWinsensorDeviceDao {

	@Override
	public void addDevice(ManagerWinsensorDeviceBO device) {
		getHibernateTemplate().save(device);
	}

	@Override
	public void updateDevice(ManagerWinsensorDeviceBO device) {
		getHibernateTemplate().update(device);
	}

	@Override
	public void deleteDevice(ManagerWinsensorDeviceBO device) {
		getHibernateTemplate().delete(device);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ManagerWinsensorDeviceBO findDeviceBySensorId(String sensorId) {
		if (StringUtils.isBlank(sensorId)) {
			return null;
		}
		
		Criteria criteria = getSession().createCriteria(ManagerWinsensorDeviceBO.class);
		criteria.add(Restrictions.eq("sensorId", sensorId));
		criteria.addOrder(Order.desc("registerTime"));
		
		List<ManagerWinsensorDeviceBO> devices = criteria.list();
		
		return (devices.size() > 0) ? devices.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ManagerWinsensorDeviceBO findDeviceByNodeId(String nodeId) {
		if (StringUtils.isBlank(nodeId)) {
			return null;
		}
		
		Criteria criteria = getSession().createCriteria(ManagerWinsensorDeviceBO.class);
		criteria.add(Restrictions.eq("nodeId", nodeId));
		criteria.addOrder(Order.desc("registerTime"));
		
		List<ManagerWinsensorDeviceBO> devices = criteria.list();
		
		return (devices.size() > 0) ? devices.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerWinsensorDeviceBO> getAllDevice() {
		Criteria criteria = getSession().createCriteria(ManagerWinsensorDeviceBO.class);
		criteria.addOrder(Order.desc("registerTime"));
		
		return criteria.list();
	}

}
