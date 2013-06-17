package edu.sjtu.infosec.ismp.manager.TM.discover.dao.impl.typeSense;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.typeSense.DeviceTypeRuler;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.TM.discover.dao.typeSense.DeviceTypeRulerDao;


/**
 * 匹配规则-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public class DeviceTypeRulerDaoImpl extends HibernateDaoSupport implements
		DeviceTypeRulerDao {
	/**
	 * 添加规则
	 * @param deviceTypeRuler
	 * 规则
	 */
	public void addDeviceTypeRuler(DeviceTypeRuler deviceTypeRuler) throws Exception {
		getHibernateTemplate().saveOrUpdate(deviceTypeRuler);
	}

	/**
	 * 删除规则
	 * @param deviceTypeRuler
	 * 规则
	 */
	public void deleteDeviceTypeRuler(DeviceTypeRuler deviceTypeRuler) throws Exception {
		getHibernateTemplate().delete(deviceTypeRuler);
	}

	/**
	 * 修改规则
	 * @param deviceTypeRuler
	 * 规则
	 */
	public void updateDeviceTypeRuler(DeviceTypeRuler deviceTypeRuler) throws Exception {
		getHibernateTemplate().saveOrUpdate(deviceTypeRuler);
	}

	/**
	 * 查找所有规则
	 * @return 规则list
	 */
	@SuppressWarnings("unchecked")
	public List<DeviceTypeRuler> findAllDeviceTypeRulers() throws Exception {
		List<DeviceTypeRuler> list = getHibernateTemplate().loadAll(DeviceTypeRuler.class);
		return list;
	}

	/**
	 * 通过名字查找规则
	 * @param name
	 * 名字
	 * @return 规则list
	 */
	@SuppressWarnings("unchecked")
	public List<DeviceTypeRuler> findAllDeviceTypeRulersByDeviceName(String name) throws Exception {
		String hql = "from DeviceTypeRuler dtr where dtr.name=" + "'" + name + "'";
		List<DeviceTypeRuler> list = getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 通过id查找规则
	 * @param id
	 * id
	 * @return 规则
	 */
	public DeviceTypeRuler findDeviceTypeRulerById(int id) throws Exception {
		DeviceTypeRuler deviceTypeRuler = (DeviceTypeRuler)getHibernateTemplate().get(DeviceTypeRuler.class, id);
		return deviceTypeRuler;
	}

	/**
	 * 查找所有规则名
	 * @return 规则名list
	 */
	@SuppressWarnings("unchecked")
	public List<String> findAllDeviceName() throws Exception {
		String hql = "select dtr.name as name from DeviceTypeRuler as dtr group by dtr.name";
		List<String> list = getHibernateTemplate().find(hql);
		return list;
	}
}
