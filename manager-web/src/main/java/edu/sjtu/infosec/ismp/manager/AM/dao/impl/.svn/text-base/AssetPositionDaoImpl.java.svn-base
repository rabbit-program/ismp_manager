package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetPositionDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * AssetPositionDao接口的实现类
 * 
 * @author Breggor
 * 
 */
@SuppressWarnings("unchecked")
public class AssetPositionDaoImpl extends HibernateDaoSupport implements
		AssetPositionDao {
	/**
	 * 实现接口方法
	 */
	public void saveAssetPosition(AssetPositionBO entity) {
		getHibernateTemplate().save(entity);

	}

	public void updateAssetPosition(AssetPositionBO entity) {
		getHibernateTemplate().update(entity);

	}

	public void deleteAssetPosition(AssetPositionBO entity) {
		getHibernateTemplate().delete(entity);

	}

	public List<AssetPositionBO> getListByAssetPosition(AssetPositionBO entity) {
		return (List<AssetPositionBO>) spliceCriteria(entity).list();

	}

	public AssetPositionBO getAssetPosition(Serializable entityId) {
		return (AssetPositionBO) getHibernateTemplate().get(
				AssetPositionBO.class, entityId);

	}
 
	public List<AssetPositionBO> getChildNodeByPosition(Serializable positionId) {
		String hql = "from AssetPositionBO posi where posi.positionId=:positionId";
		Query query = getSession().createQuery(hql);
		query.setParameter("positionId", positionId);
		return query.list();
	}

	public List<AssetPositionBO> getChildNodeListByParent(Serializable rootId) {
		String hql = "from AssetPositionBO posi where posi.parentId=:rootId";
		Query query = getSession().createQuery(hql);
		query.setParameter("rootId", rootId);
		return query.list();
	}

	public List<AssetPositionBO> getPageByAssetPosition(AssetPositionBO entity,
			Page page) {
		Criteria criteria = spliceCriteria(entity);
		criteria.setFirstResult(page.getBeginIndex());
		criteria.setMaxResults(page.getEveryPage());
		return criteria.list();
	}

	public int getCountByAssetPosition(AssetPositionBO entity) {
		int count = 0;
		Criteria criteria = spliceCriteria(entity);
		count = ((Integer) criteria.setProjection(Projections.rowCount())
				.uniqueResult()).intValue();
		return count;
	}

	public List<AssetPositionBO> getChildNodeListByParent(AssetPositionBO entity) {
		Criteria criteria = spliceCriteria(entity);
		criteria.addOrder(Order.desc("parentId"));
		return criteria.list();
	}

	private Criteria spliceCriteria(AssetPositionBO assetPosition) {
		Criteria criteria = getSession().createCriteria(AssetPositionBO.class);

		if (null == assetPosition) {
			return criteria;
		}
		if (null != assetPosition.getId()) {
			criteria.add(Restrictions.eq("id", assetPosition.getId()));
		}
		if (null != assetPosition.getParentId()) {
			criteria.add(Restrictions.eq("parentId", assetPosition
					.getParentId()));
		}
		if (null != assetPosition.getDescription()
				&& assetPosition.getDescription().trim().length() > 0) {
			criteria.add(Restrictions.like("description", "%"
					+ assetPosition.getDescription().trim() + "%"));
		}
		return criteria;
	}

	public boolean getChildNodeByPositionId(String nodeName, int posId) {
		String HQL = "select count(*) from AssetPositionBO bo where bo.description=:nodeName and bo.positionId=:posId";
		Query query = getSession().createQuery(HQL);
		query.setParameter("nodeName", nodeName);
		query.setParameter("posId", posId);
		int row = ((Long) query.uniqueResult()).intValue();
		if (row > 0) {
			return true;
		}
		return false;
	}

	public boolean getChildNodeByParentId(String nodeName, int parentId) {
		String HQL = "select count(*) from AssetPositionBO bo where bo.description=:nodeName and bo.parentId=:parentId";
		Query query = getSession().createQuery(HQL);
		query.setParameter("nodeName", nodeName);
		query.setParameter("parentId", parentId);
		int row = ((Long) query.uniqueResult()).intValue();
		if (row > 0) {
			return true;
		}
		return false;
	}

	public List<AssetPositionBO> getChildNodes(Serializable rootId) {
		String hql = "from AssetPositionBO posi where posi.parentId=:rootId";
		Query query = getSession().createQuery(hql);
		query.setParameter("rootId", rootId);
		return query.list();
	}

	public AssetPositionBO getParentNodeListByChild(Serializable entityId) {
		String hql = "from AssetPositionBO posi where posi.id= (select parentId from AssetPositionBO apb where apb.id =:entityId)";
		Query query = getSession().createQuery(hql);
		query.setParameter("entityId", entityId);
		return (AssetPositionBO) query.uniqueResult();
		
	}

	public AssetPositionBO getNodeListById(Serializable entityId) {
		String hql = "from AssetPositionBO posi where posi.id=:entityId";
		Query query = getSession().createQuery(hql);
		query.setParameter("entityId", entityId);
		return (AssetPositionBO) query.uniqueResult();
	}

}
