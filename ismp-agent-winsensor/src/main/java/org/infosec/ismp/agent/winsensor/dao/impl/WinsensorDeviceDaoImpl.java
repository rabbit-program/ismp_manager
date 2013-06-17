package org.infosec.ismp.agent.winsensor.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.agent.winsensor.WinsensorConstant;
import org.infosec.ismp.agent.winsensor.dao.WinsensorDeviceDao;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Rocky
 * @version create time：Sep 30, 2010 10:57:05 AM
 * 
 */
public class WinsensorDeviceDaoImpl extends HibernateDaoSupport implements WinsensorDeviceDao {

	@Override
	public void addDevice(WinsensorDeviceBO device) {
		getHibernateTemplate().save(device);
	}

	@Override
	public void addDevices(List<WinsensorDeviceBO> devices) {
		getHibernateTemplate().saveOrUpdateAll(devices);
	}

	@Override
	public void deleteDevice(WinsensorDeviceBO device) {
		getHibernateTemplate().delete(device);
	}

	@Override
	public void deleteDevices(List<WinsensorDeviceBO> devices) {
		getHibernateTemplate().deleteAll(devices);
	}

	@SuppressWarnings("unchecked")
	@Override
	public WinsensorDeviceBO findDeviceBySensorId(String sensorId) {
		if (null == sensorId || sensorId.equals("")) {
			return null; 
		} else {
			Criteria criteria = getSession().createCriteria(WinsensorDeviceBO.class);
			criteria.add(Restrictions.eq("sensorId", sensorId));
			criteria.addOrder(Order.desc("createTime"));
			List<WinsensorDeviceBO> value = criteria.list();
			if (value.size() > 0) {
				return value.get(0);
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public WinsensorDeviceBO findDeviceByNodeId(String nodeId) {
		if (null == nodeId || nodeId.equals("")) {
			return null; 
		} else {
			Criteria criteria = getSession().createCriteria(WinsensorDeviceBO.class);
			criteria.add(Restrictions.eq("nodeId", nodeId));
			criteria.addOrder(Order.desc("createTime"));
			List<WinsensorDeviceBO> value = criteria.list();
			if (value.size() > 0) {
				return value.get(0);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WinsensorDeviceBO> getAllMonitorDevices() {
		Criteria criteria = getSession().createCriteria(WinsensorDeviceBO.class);
		criteria.add(Restrictions.eq("flag", 
				Integer.valueOf(WinsensorConstant.DEVICE_MONITORING_STATUS)));
		criteria.addOrder(Order.desc("createTime"));
		
		return criteria.list();
	}

	@Override
	public void pauseDevice(WinsensorDeviceBO device) {
		device.setFlag(WinsensorConstant.DEVICE_MONITOR_PAUSE_STATUS);
		updateDevice(device);
	}

	@Override
	public void pauseDevices(List<WinsensorDeviceBO> devices) {
		for (WinsensorDeviceBO winsensorDevice : devices) {
			pauseDevice(winsensorDevice);
		}
	}

	@Override
	public void updateDevice(WinsensorDeviceBO device) {
		getHibernateTemplate().update(device);
	}

	@Override
	public void updateDevices(List<WinsensorDeviceBO> devices) {
		for (WinsensorDeviceBO winsensorDevice :  devices) {
			updateDevice(winsensorDevice);
		}
	}

}
