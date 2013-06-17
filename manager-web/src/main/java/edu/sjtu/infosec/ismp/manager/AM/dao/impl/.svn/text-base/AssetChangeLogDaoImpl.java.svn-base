package edu.sjtu.infosec.ismp.manager.AM.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AM.dao.AssetChangeLogDao;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetChangeLogBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


public class AssetChangeLogDaoImpl extends HibernateDaoSupport implements AssetChangeLogDao {


	/**
	 * 保存资产变动信息
	 * 
	 * @param entity
	 */
	public void saveAssetChangeLog(AssetChangeLogBO entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * 更新资产变动信息
	 * 
	 * @param entity
	 */
	public void updateAssetChangeLog(AssetChangeLogBO entity) {
		getHibernateTemplate().update(entity);
	}
	/**
	 * 删除资产变动信息
	 * @param entity
	 */
	public void deleteAssetChangeLog(AssetChangeLogBO entity) {
		getHibernateTemplate().delete(entity);
	}
	/**
	 * 根据Id查询资产变动信息
	 * @param entityId
	 * @return
	 */
	public AssetChangeLogBO getAssetChangeLog(Serializable entityId) {
		return (AssetChangeLogBO)getHibernateTemplate().get(AssetChangeLogBO.class, entityId);
	}
	/**
	 * 查询所有的资产变动信息
	 * @param entity
	 * @return
	 */
	public List<AssetChangeLogBO> getListByAssetChangeLog(AssetChangeLogBO entity)
	{
		Criteria criteria = getSession().createCriteria(AssetChangeLogBO.class);
		if(entity != null)
		  criteria.add(Example.create(entity));
		return criteria.list();
	}
	
	public List<AssetChangeLogBO> getPageListByAssetChangeLog(
			AssetChangeLogBO entity, Page page) {
		Criteria criteria = getSession().createCriteria(AssetChangeLogBO.class);
		if(entity != null)
		  criteria.add(Example.create(entity));
		if(page != null)
		{
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
		}
		return criteria.list();
		 
	}
	

}
