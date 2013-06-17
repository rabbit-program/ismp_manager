package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetToPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToPositionBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetToPositionDao接口的实现类
 * 
 * @author Breggor 6.25完善功能
 * 
 */
@SuppressWarnings("unchecked")
public class AssetToPositionDaoImpl extends HibernateDaoSupport implements
		AssetToPositionDao {
	/**
	 * 保持物理位置和设备的关联关系
	 */
	public void saveAssetToPosition(AssetToPositionBO entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * 更新物理位置和设备的关联关系
	 */
	public void updateAssetToPosition(AssetToPositionBO entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * 删除物理位置和设备的关联关系
	 */
	public void deleteAssetToPosition(AssetToPositionBO entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * 根据物理位置和设备关系的Id查询
	 */
	public AssetToPositionBO getAssetToPosition(Serializable entityId) {
		return (AssetToPositionBO) getHibernateTemplate().get(
				AssetToPositionBO.class, entityId);
	}

	/**
	 * 根据物理位置和设备关系的model查询
	 */
	public List<AssetToPositionBO> getListByAssetToPosition(
			AssetToPositionBO entity) {
		return (List<AssetToPositionBO>) spliceCriteria(entity).list();

	}

	/**
	 * 根据物理位置Id查询已关联设备集合
	 */
	public List<AssetDeviceBO> getListByAssetDevice(Serializable positionId) {
		//根据物理位置Id得到设备Id集合
		List deviceIds = getAssetDeviceIds(positionId);
		//没有设备Id集合,就return Null
		if(deviceIds == null || deviceIds.isEmpty())
		{
			return null;
		}
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class);
		criteria.add(Restrictions.in("id", deviceIds));
		return criteria.list();
	}

	/**
	 * 根据设备Id查询已关联物理位置集合
	 */
	public List<AssetPositionBO> getListByPosition(Serializable deviceId) {
		//根据设备Id得到物理位置Id集合
		List posList = getAssetPositionIds(deviceId);
		//没有物理位置Id集合，就return Null
		if(posList == null || posList.isEmpty())
		{
			return null;
		} 
		Criteria criteria = getSession().createCriteria(AssetPositionBO.class);
		criteria.add(Restrictions.in("id", posList));
		return criteria.list();
	}
	/**
	 * 根据物理位置Id查询没有关联设备集合
	 */
	public List<AssetDeviceBO> getListNotJoinAssetDevice(Serializable positionId) {
		
		List<AssetDeviceBO> deviceList = null;
		//根据物理位置Id得到设备Id集合
		List deviceIds = getAssetDeviceIds(positionId);
		
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class); 
		//设备Id集合为空或Null时,就return 全部的设备
		if(deviceIds == null || deviceIds.isEmpty())
		{ 
			deviceList = criteria.list();
		}else{
			deviceList = criteria.add(Restrictions.not(Restrictions.in("id", deviceIds))).list();
		} 
		
		return deviceList;
	}
	/**
	 * 根据设备Id查询没有关联的物理位置集合
	 */
	public List<AssetPositionBO> getListNotJoinPosition(Serializable deviceId) {
		List<AssetPositionBO> positionList = null;
		//根据设备Id得到物理位置Id集合
		List posIds = getAssetPositionIds(deviceId);
		Criteria criteria = getSession().createCriteria(AssetPositionBO.class);
		//物理位置Id集合为空或Null时，就return全部的物理位置
		if(posIds == null || posIds.isEmpty())
		{
			positionList = criteria.list();
		}else
		{
			positionList = criteria.add(Restrictions.not(Restrictions.in("id", posIds))).list();
		}  
		return positionList;
	}

	/**
	 * 根据物理位置Id分页查询设备 
	 */
	public List<AssetDeviceBO> getPageListByAssetDevice(
			Serializable positionId, Page page) {
		//根据物理位置Id得到设备Id集合
		List deviceIds = getAssetDeviceIds(positionId);
		//没有设备Id集合,就return Null
		if(deviceIds == null || deviceIds.isEmpty())
		{
			return null;
		} 
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class);
		criteria.add(Restrictions.in("id", deviceIds));
		criteria.setFirstResult(page.getBeginIndex());
		criteria.setMaxResults(page.getEveryPage());
		return criteria.list();
	}

	/**
	 * 根据物理位置Id统计设备的总行数
	 */
	public int getCountByAssetDevice(Serializable positionId) {
		int count = 0;
		List deviceIds = getAssetDeviceIds(positionId);
		if(deviceIds==null || deviceIds.isEmpty())
		{
			return count;
		}
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class);
		criteria.add(Restrictions.in("id", deviceIds));
		count = ((Integer) criteria.setProjection(Projections.rowCount())
				.uniqueResult()).intValue();
		return count;
	}

	/**
	 * 生成查询条件
	 */
	private Criteria spliceCriteria(AssetToPositionBO assetToPosition) {
		Criteria criteria = getSession()
				.createCriteria(AssetToPositionBO.class);

		if (null == assetToPosition) {
			return criteria;
		}
		if (null != assetToPosition.getId()) {
			criteria.add(Restrictions.eq("id", assetToPosition.getId()));
		}
		if (null != assetToPosition.getAssetId()) {
			criteria.add(Restrictions.eq("assetId", assetToPosition
					.getAssetId()));
		}
		if (null != assetToPosition.getPositionId()) {
			criteria.add(Restrictions.eq("positionId", assetToPosition
					.getPositionId()));
		}
		if (null != assetToPosition.getDescription()
				&& assetToPosition.getDescription().trim().length() > 0) {
			criteria.add(Restrictions.like("description", "%"
					+ assetToPosition.getDescription().trim() + "%"));
		}
		return criteria;
	}
	
	/**
	 * 根据物理位置Id查询设备Id集合
	 * @param positionId
	 * @return
	 */
	private List<Integer> getAssetDeviceIds(Serializable positionId) {
		List<Integer> idsList = null;
		if (positionId != null && !"".equals(positionId)) {
			String hql = "select  device.assetId from AssetToPositionBO device where device.positionId=:positionId";
			Query query = getSession().createQuery(hql);
			query.setParameter("positionId", positionId);
			idsList = query.list();
		}
		return idsList;
	}
	/**
	 * 根据设备Id查询物理位置Id集合
	 * @param positionId
	 * @return
	 */
	private List<Integer> getAssetPositionIds(Serializable deviceId) {
		List<Integer> idsList = null;
		if (deviceId != null && !"".equals(deviceId)) {
			String hql = "select pos.positionId from AssetToPositionBO pos where pos.assetId=:assetId";
			Query query = getSession().createQuery(hql);
			query.setParameter("assetId", deviceId);
			idsList = query.list();
		}
		return idsList;
	}

	public List<AssetToPositionBO> getPositionIdByDeviceId(Serializable deviceId) {
		String hql = "from AssetToPositionBO assetTopos where assetTopos.assetId=?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, deviceId); 
		return query.list();
	}

	public List<AssetDeviceBO> getListNotJoinAssetDevice() {
		List<AssetDeviceBO> deviceList = null;
		//得到所有房间的id号
		List<AssetPositionBO> rooms = getRooms();
		//根据设备Id得到物理位置Id集合
		List deviceIds = new ArrayList();	
		for(AssetPositionBO room:rooms){
			List deviceId = getAssetDeviceIds(room.getId());
			deviceIds.addAll(deviceId);
		}
		Criteria criteria = getSession().createCriteria(AssetDeviceBO.class); 
		//设备Id集合为空或Null时,就return 全部的设备
		if(deviceIds == null || deviceIds.isEmpty())
		{ 
			deviceList = criteria.list();
		}else{
			deviceList = criteria.add(Restrictions.not(Restrictions.in("id", deviceIds))).list();
		} 
		
		return deviceList;
	}
	//得到所有房间的信息
	public List<AssetPositionBO> getRooms(){
		Criteria criteria = getSession().createCriteria(AssetPositionBO.class);
		return criteria.add(Restrictions.isNotNull("parentId")).list();
	}
}
