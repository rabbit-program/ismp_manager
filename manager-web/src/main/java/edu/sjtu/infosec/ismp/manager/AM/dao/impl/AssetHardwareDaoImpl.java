package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetHardwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetHardwareDao接口的实现类
 * 
 * @author Breggor
 * 
 */
@SuppressWarnings("unchecked")
public class AssetHardwareDaoImpl extends HibernateDaoSupport implements
		AssetHardwareDao
{

	/**
	 * 实现接口方法
	 */
	public void saveAssetHardware(AssetHardwareBO entity)
	{
		getHibernateTemplate().save(entity);
	}

	public void updateAssetHardware(AssetHardwareBO entity)
	{
		getHibernateTemplate().update(entity);
	}

	public void deleteAssetHardware(AssetHardwareBO entity)
	{
		getHibernateTemplate().delete(entity);

	}

	public AssetHardwareBO getAssetHardware(Serializable entityId)
	{
		return (AssetHardwareBO) getHibernateTemplate().get(
				AssetHardwareBO.class, entityId);
	}

	public List<AssetHardwareBO> getListByAssetHardware(final AssetHardwareBO assetHardware)
	{
		return (List<AssetHardwareBO>) spliceCriteria(assetHardware).list();
//		return   (List<AssetHardwareBO>) getHibernateTemplate().execute(new HibernateCallback(){
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				Criteria criteria = session.createCriteria(AssetHardwareBO.class);
//				return criteria.list();
//			}
//		});
		
		 
	}
	
	public int getCountByAssetHardware(AssetHardwareBO entity) { 
		int count = 0;
		 Criteria criteria = spliceCriteria(entity);
		 count = ((Integer)criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
		return count;
	}
	public List<AssetHardwareBO> getPageListByAssetHardware(
			AssetHardwareBO entity, Page page) { 
		 Criteria criteria = spliceCriteria(entity);
		 criteria.setFirstResult(page.getBeginIndex());
		 criteria.setMaxResults(page.getEveryPage());
		return criteria.list();
	}

	/**
	 * 生成查询条件
	 */
	private Criteria spliceCriteria(AssetHardwareBO assetHardware)
	{
		Criteria criteria = getSession().createCriteria(AssetHardwareBO.class);

		if (null == assetHardware)
		{
			return criteria;
		}
		if (null != assetHardware.getId())
		{
			criteria.add(Restrictions.eq("id", assetHardware.getId()));
		}
		if (null != assetHardware.getHardwareType()
				&& assetHardware.getHardwareType().trim().length() > 0)
		{
			criteria.add(Restrictions.like("hardwareType", "%"
					+ assetHardware.getHardwareType().trim() + "%"));
		}
		if (null != assetHardware.getName()
				&& assetHardware.getName().trim().length() > 0)
		{
			criteria.add(Restrictions.like("name", "%"
					+ assetHardware.getName().trim() + "%"));
		}
		if (null != assetHardware.getManufacturer()
				&& assetHardware.getManufacturer().trim().length() > 0)
		{
			criteria.add(Restrictions.like("manufacturer", "%"
					+ assetHardware.getManufacturer().trim() + "%"));
		}
		if (null != assetHardware.getVersion()
				&& assetHardware.getVersion().trim().length() > 0)
		{
			criteria.add(Restrictions.like("version", "%"
					+ assetHardware.getVersion().trim() + "%"));
		}
		if (null != assetHardware.getCapacity())
		{
			criteria.add(Restrictions.eq("capacity", assetHardware
					.getCapacity()));
		}
		if (null != assetHardware.getDescription()
				&& assetHardware.getDescription().trim().length() > 0)
		{
			criteria.add(Restrictions.like("description", "%"
					+ assetHardware.getDescription().trim() + "%"));
		}
		if (null != assetHardware.getStatus())
		{
			criteria.add(Restrictions.eq("status", assetHardware.getStatus()));
		}
		if (null != assetHardware.getStockTime())
		{
			criteria.add(Restrictions.eq("stockTime", assetHardware
					.getStockTime()));
		}
		if (null != assetHardware.getValidityPeriod())
		{
			criteria.add(Restrictions.eq("validityPeriod", assetHardware
					.getValidityPeriod()));
		}
		if (null != assetHardware.getRegistrationTime())
		{
			criteria.add(Restrictions.eq("registrationTime", assetHardware
					.getRegistrationTime()));
		}
		if (null != assetHardware.getLocationId())
		{
			criteria.add(Restrictions.eq("locationId", assetHardware
					.getLocationId()));
		}
		return criteria;
	}

}
