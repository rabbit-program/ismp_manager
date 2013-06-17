package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToHardwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToHardwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetToHardwareDao接口的实现类
 * 
 * @author Breggor 6.25完善功能
 * 
 */
@SuppressWarnings("unchecked")
public class AssetToHardwareDaoImpl extends HibernateDaoSupport implements
		AssetToHardwareDao {
	/**
	 * 保存设备和硬件的关系
	 */
	public void saveAssetToHardware(AssetToHardwareBO entity) {
		getHibernateTemplate().save(entity);

	}

	/**
	 * 更新设备和硬件的关系
	 */
	public void updateAssetToHardware(AssetToHardwareBO entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 *删除设备和硬件的关系
	 */
	public void deleteAssetToHardware(AssetToHardwareBO entity) {
		getHibernateTemplate().delete(entity);

	}

	/**
	 * 根据设备和硬件关系的Id查询
	 */
	public AssetToHardwareBO getAssetToHardware(Serializable entityId) {
		return (AssetToHardwareBO) getHibernateTemplate().get(
				AssetToHardwareBO.class, entityId);
	}

	/**
	 * 根据设备和硬件关系的model查询
	 */
	public List<AssetToHardwareBO> getListByAssetToHardware(
			AssetToHardwareBO entity) {
		return (List<AssetToHardwareBO>) spliceCriteria(entity).list();

	}

	/**
	 * 根据硬件Id查询已关联的设备集合
	 */
	public List<AssetDeviceBO> getListByAssetDevice(Serializable hardwareId) {
		//根据硬件id等到设备id集合
		List ids = getAssetDeviceIds(hardwareId);
		//设备id集合为null或为空时，就return Null;
		if(ids == null || ids.isEmpty())
		{
			return null;
		}
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class);
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}
	
	/**
	 * 根据设备Id查询已关联的硬件集合
	 */
	public List<AssetHardwareBO> getListByHardware(Serializable assetId) {
		//根据设备Id得到硬件id集合
		List ids = getAssetHardwareIds(assetId);
		//硬件id集合为null或空时，就return Null
		if(ids == null || ids.isEmpty())
		{
			return null;
		}
		Criteria criteria = getSession().createCriteria(AssetHardwareBO.class);
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}

	/**
	 * 根据硬件Id查询没有关联的设备集合
	 */
	public List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable hardwareId) {
		List<AssetDeviceBO> deviceList = null;
		//根据硬件Id等到设备Id集合
		List deviceIds = getAssetDeviceIds(hardwareId);
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class);
		//设备Id集合为空或Null时，就return所有的设备集合
		if(deviceIds == null || deviceIds.isEmpty())
		{
			deviceList = criteria.list();
		}else
		{
			deviceList = criteria.add(Restrictions.not(Restrictions.in("id", deviceIds))).list();
		}  
		return deviceList;
	}

	/**
	 * 根据设备Id查询没有关联的硬件集合
	 */
	public List<AssetHardwareBO> getListNotJoinHardware(Serializable assetId) {
		List<AssetHardwareBO> hardwareList = null;
		//根据设备Id等到硬件Id集合
		List hardwareIds = getAssetHardwareIds(assetId);
		Criteria criteria = getSession().createCriteria(AssetHardwareBO.class);
		//硬件Id集合为空或Null时，就return所有的硬件集合
		if(hardwareIds == null || hardwareIds.isEmpty())
		{
			hardwareList = criteria.list();
		}else
		{
			hardwareList = criteria.add(Restrictions.not(Restrictions.in("id", hardwareIds))).list();
		} 
		return hardwareList;
	}
	
	/**
	 * 根据设备Id统计硬件行数
	 */
	public int getCountByHardware(Serializable deviceId) {
		int count = 0;
		List list = getListByHardware(deviceId);
		if(list != null &&list.size()>0)
			count = list.size();
		return count;
	}
	
	/**
	 * 根据设备Id分页查询硬件
	 */
	public List<AssetHardwareBO> getPageListByHardware(Serializable deviceId,
			Page page) {
		//根据设备Id得到硬件id集合
		List ids = getAssetHardwareIds(deviceId);
		//硬件id集合为null或空时，就return Null
		if(ids == null || ids.isEmpty())
		{
			return null;
		}
		Criteria criteria = getSession().createCriteria(AssetHardwareBO.class);
		criteria.add(Restrictions.in("id", ids));
		if(page != null)
		{
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
		}
		return criteria.list();
	}

	/**
	 * 生成查询条件
	 */
	private Criteria spliceCriteria(AssetToHardwareBO assetToHardware) {
		Criteria criteria = getSession()
				.createCriteria(AssetToHardwareBO.class);

		if (null == assetToHardware) {
			return criteria;
		}
		if (null != assetToHardware.getId()) {
			criteria.add(Restrictions.eq("id", assetToHardware.getId()));
		}
		if (null != assetToHardware.getAssetId()) {
			criteria.add(Restrictions.eq("assetId", assetToHardware
					.getAssetId()));
		}
		if (null != assetToHardware.getHardwareId()) {
			criteria.add(Restrictions.eq("hardwareId", assetToHardware
					.getHardwareId()));
		}
		if (null != assetToHardware.getDescription()
				&& assetToHardware.getDescription().trim().length() > 0) {
			criteria.add(Restrictions.like("description", "%"
					+ assetToHardware.getDescription().trim() + "%"));
		}
		return criteria;
	}
	/**
	 * 根据设备Id查询所有硬件Id
	 * @param deviceId
	 * @return
	 */
	private List<Integer> getAssetHardwareIds(Serializable deviceId) {
		List<Integer> idList = null;
		if (deviceId != null && !"".equals(deviceId)) {
			String hql = "select device.hardwareId from AssetToHardwareBO as device where device.assetId=:assetId";
			Query query = getSession().createQuery(hql);
			query.setParameter("assetId", deviceId);
			idList = query.list();
		}
		return idList;
	}

	/**
	 * 根据硬件Id查询所有设备Id
	 * @param hardwareId
	 * @return
	 */
	private List<Integer> getAssetDeviceIds(Serializable hardwareId) {
		List<Integer> idList = null;
		if (hardwareId != null && !"".equals(hardwareId)) {
			String hql = "select hardware.assetId from AssetToHardwareBO as hardware where hardware.hardwareId=:hardwareId";
			Query query = getSession().createQuery(hql);
			query.setParameter("hardwareId", hardwareId);
			idList = query.list();
		}
		return idList;
	}
}
