package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetSoftwareDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetSoftwareDao接口的实现类
 * 
 * @author Breggor
 * 
 */
@SuppressWarnings("unchecked")
public class AssetSoftwareDaoImpl extends HibernateDaoSupport implements
		AssetSoftwareDao {

	public void saveAssetSoftware(AssetSoftwareBO entity) {
		getHibernateTemplate().save(entity);

	}

	public void updateAssetSoftware(AssetSoftwareBO entity) {
		getHibernateTemplate().update(entity);
	}

	public void deleteAssetSoftware(AssetSoftwareBO entity) {
		getHibernateTemplate().delete(entity);
	}

	public AssetSoftwareBO getAssetSoftware(Serializable entityId) {
		return (AssetSoftwareBO) getHibernateTemplate().get(
				AssetSoftwareBO.class, entityId);
	}

	public List<AssetSoftwareBO> getListByAssetSoftware(AssetSoftwareBO entity) {
		return (List<AssetSoftwareBO>) spliceCriteria(entity).list();

	}

	public int getCountByAssetSoftware(AssetSoftwareBO entity) {
		int count = 0;
		Criteria criteria = spliceCriteria(entity);
		count = ((Integer) criteria.setProjection(Projections.rowCount())
				.uniqueResult()).intValue();  
		return count;
	}

	public List<AssetSoftwareBO> getPageListByAssetSoftware(
			AssetSoftwareBO entity, Page page) {
		Criteria criteria = spliceCriteria(entity);
		criteria.setFirstResult(page.getBeginIndex());
		criteria.setMaxResults(page.getEveryPage());
		return criteria.list();
	}

	/**
	 * 生成查询条件
	 */
	private Criteria spliceCriteria(AssetSoftwareBO assetSoftware) {
		Criteria criteria = getSession().createCriteria(AssetSoftwareBO.class);

		if (null == assetSoftware) {
			return criteria;
		}
		if (null != assetSoftware.getId()) {
			criteria.add(Restrictions.eq("id", assetSoftware.getId()));
		}
		if (null != assetSoftware.getSoftwareType()
				&& assetSoftware.getSoftwareType().trim().length() > 0) {
			criteria.add(Restrictions.like("softwareType", "%"
					+ assetSoftware.getSoftwareType().trim() + "%"));
		}
		if (null != assetSoftware.getName()
				&& assetSoftware.getName().trim().length() > 0) {
			criteria.add(Restrictions.like("name", "%"
					+ assetSoftware.getName().trim() + "%"));
		}
		if (null != assetSoftware.getManufacturer()
				&& assetSoftware.getManufacturer().trim().length() > 0) {
			criteria.add(Restrictions.like("manufacturer", "%"
					+ assetSoftware.getManufacturer().trim() + "%"));
		}
		if (null != assetSoftware.getVersion()
				&& assetSoftware.getVersion().trim().length() > 0) {
			criteria.add(Restrictions.like("version", "%"
					+ assetSoftware.getVersion().trim() + "%"));
		}
		if (null != assetSoftware.getDescription()
				&& assetSoftware.getDescription().trim().length() > 0) {
			criteria.add(Restrictions.like("description", "%"
					+ assetSoftware.getDescription().trim() + "%"));
		}
		if (null != assetSoftware.getUser()
				&& assetSoftware.getUser().trim().length() > 0) {
			criteria.add(Restrictions.like("user", "%"
					+ assetSoftware.getUser().trim() + "%"));
		}
		if (null != assetSoftware.getTelephone()
				&& assetSoftware.getTelephone().trim().length() > 0) {
			criteria.add(Restrictions.like("telephone", "%"
					+ assetSoftware.getTelephone().trim() + "%"));
		}
		if (null != assetSoftware.getUnit()
				&& assetSoftware.getUnit().trim().length() > 0) {
			criteria.add(Restrictions.like("unit", "%"
					+ assetSoftware.getUnit().trim() + "%"));
		}
		if (null != assetSoftware.getDepartment()
				&& assetSoftware.getDepartment().trim().length() > 0) {
			criteria.add(Restrictions.like("department", "%"
					+ assetSoftware.getDepartment().trim() + "%"));
		}
		if (null != assetSoftware.getStatus()) {
			criteria.add(Restrictions.eq("status", assetSoftware.getStatus()));
		}
		if (null != assetSoftware.getStockTime()) {
			criteria.add(Restrictions.eq("stockTime", assetSoftware
					.getStockTime()));
		}
		if (null != assetSoftware.getValidityPeriod()) {
			criteria.add(Restrictions.eq("validityPeriod", assetSoftware
					.getValidityPeriod()));
		}
		if (null != assetSoftware.getRegistrationTime()) {
			criteria.add(Restrictions.eq("registrationTime", assetSoftware
					.getRegistrationTime()));
		}
		if (null != assetSoftware.getLocationId()) {
			criteria.add(Restrictions.eq("locationId", assetSoftware
					.getLocationId()));
		}
		return criteria;

	}

}
