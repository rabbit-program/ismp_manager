package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToSoftwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToSoftwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetToSoftwareDao接口的实现类
 * 
 * @author Breggor 6.25完善
 * 
 */
@SuppressWarnings("unchecked")
public class AssetToSoftwareDaoImpl extends HibernateDaoSupport implements
		AssetToSoftwareDao {

	/**
	 * 保存软件和设备关联关系
	 */
	public void saveAssetToSoftware(AssetToSoftwareBO entity) {
		getHibernateTemplate().save(entity);

	} 
	/**
	 * 更新软件和设备关联关系
	 */
	public void updateAssetToSoftware(AssetToSoftwareBO entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 删除软件和设备关联关系
	 */
	public void deleteAssetToSoftware(AssetToSoftwareBO entity) {
		getHibernateTemplate().delete(entity);
	}
	/**
	 * 根据软件和设备关联关系的Id查询
	 */
	public AssetToSoftwareBO getAssetToSoftware(Serializable entityId) {
		return (AssetToSoftwareBO) getHibernateTemplate().get(
				AssetToSoftwareBO.class, entityId);
	}
	/**
	 *  根据软件和设备关联关系model查询
	 */
	public List<AssetToSoftwareBO> getListByAssetToSoftware(
			AssetToSoftwareBO entity) {
		return (List<AssetToSoftwareBO>) spliceCriteria(entity).list(); 
	}
	/**
	 * 根据软件Id查询设备
	 */
	public List<AssetDeviceBO> getListByAssetDevice(Serializable softwareId) {
		//根据softwareID查询所有的device的ID
		List deviceIds = getDeviceIds(softwareId); 
		if(deviceIds == null || deviceIds.isEmpty())
		{
			return null;
		} 
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class);
		criteria.add(Restrictions.in("id", deviceIds));
		return criteria.list();
	}
	
	/**
	 * 根据设备Id查询软件
	 */
	public List<AssetSoftwareBO> getListByAssetSoftware(Serializable deviceId) { 
		//根据deviceId查询所有的software的Id集合
		List softIds = getSoftwareIds(deviceId);
		//没有软件Id集合时，直接return Null
		if(softIds == null || softIds.isEmpty())
		{
			return null;
		}
		//根据软件Id集合查询软件
		Criteria criteria = getSession().createCriteria(AssetSoftwareBO.class);
		criteria.add(Restrictions.in("id", softIds));
		return criteria.list();
	}
	
	/**
	 * 根据软件Id查询没有关联设备
	 */
	public List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable softwareId) {
		List<AssetDeviceBO> deviceList = null;
		//根据softwareID查询所有的device的ID集合
		List deviceIds = getDeviceIds(softwareId);
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class);
		//硬件Id集合为空或Null时，直接return 全部设备
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
	 * 根据设备Id查询没有关联软件
	 */
	public List<AssetSoftwareBO> getListNotJoinAssetSoftware(
			Serializable deviceId) {
		List<AssetSoftwareBO> softwareList = null;
		//根据deviceID查询所有的software的Id集合
		 List softIds = getSoftwareIds(deviceId);
		 Criteria criteria = getSession().createCriteria(AssetSoftwareBO.class); 
		//软件Id集合为空或Null时，就return 全部软件
		 if(softIds == null || softIds.isEmpty())
		 {
			 softwareList = criteria.list();
		 } else
		 {
			 softwareList = criteria.add(Restrictions.not(Restrictions.in("id", softIds))).list();
		 } 
		return softwareList;
	}
	
	/**
	 * 根据设备Id统计软件行数
	 */
	public int getCountByAssetSoftware(Serializable deviceId) {
		int count = 0;
		List list = getListByAssetSoftware(deviceId);
		if(list != null &&list.size()>0)
		{
			count = list.size();
		}
			
		return count;
	}
	
	/**
	 * 根据设备Id分页查询软件集合
	 */
	public List<AssetSoftwareBO> getPageListByAssetSoftware(
			Serializable deviceId, Page page) {
		//根据deviceId查询所有的software的Id集合
		List softIds = getSoftwareIds(deviceId);
		//没有软件Id集合时，直接return Null
		if(softIds == null || softIds.isEmpty())
		{
			return null;
		}
		//根据软件Id集合查询软件
		Criteria criteria = getSession().createCriteria(AssetSoftwareBO.class);
		criteria.add(Restrictions.in("id", softIds));
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
	private Criteria spliceCriteria(AssetToSoftwareBO assetToSoftware) {
		Criteria criteria = getSession()
				.createCriteria(AssetToSoftwareBO.class);

		if (null == assetToSoftware) {
			return criteria;
		}
		if (null != assetToSoftware.getId()) {
			criteria.add(Restrictions.eq("id", assetToSoftware.getId()));
		}
		if (null != assetToSoftware.getAssetId()) {
			criteria.add(Restrictions.eq("assetId", assetToSoftware
					.getAssetId()));
		}
		if (null != assetToSoftware.getSoftwareId()) {
			criteria.add(Restrictions.eq("softwareId", assetToSoftware
					.getSoftwareId()));
		}
		if (null != assetToSoftware.getDescription()
				&& assetToSoftware.getDescription().trim().length() > 0) {
			criteria.add(Restrictions.like("description", "%"
					+ assetToSoftware.getDescription().trim() + "%"));
		}
		return criteria;
	}
	
	/**
	 * 	根据设备Id查询软件Id集合
	 * @param deviceId
	 * @return
	 */
	private List<Integer> getSoftwareIds(Serializable deviceId)
	{
		List<Integer> idList = null;
		if(null != deviceId && !"".equals(deviceId))
		{
			String hql = "select soft.softwareId from AssetToSoftwareBO soft where soft.assetId=:deviceId";
			Query query = getSession().createQuery(hql);
			idList = query.setParameter("deviceId", deviceId).list(); 
		} 
		return idList;
	}
	/**
	 * 	根据软件Id查询设备Id集合
	 * @param deviceId
	 * @return
	 */
	private List<Integer> getDeviceIds(Serializable softwareId)
	{
		List<Integer> idList = null;
		if(null != softwareId && !"".equals(softwareId))
		{
			String hql = "select soft.assetId from AssetToSoftwareBO soft where soft.softwareId=:softwareId";
			Query query = getSession().createQuery(hql);
			idList = query.setParameter("softwareId", softwareId).list(); 
		} 
		return idList;
	}

}
