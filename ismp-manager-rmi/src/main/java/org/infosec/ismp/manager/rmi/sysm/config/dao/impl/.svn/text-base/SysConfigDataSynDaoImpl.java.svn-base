package org.infosec.ismp.manager.rmi.sysm.config.dao.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.dao.SysConfigDataSynDao;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDataSyn;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public class SysConfigDataSynDaoImpl extends HibernateDaoSupport implements SysConfigDataSynDao {

	public void add(SysConfigDataSyn dataSyn) throws Exception {
		getHibernateTemplate().saveOrUpdate(dataSyn);
	}

	public void delete(SysConfigDataSyn dataSyn) throws Exception {
		getHibernateTemplate().delete(dataSyn);
	}

	public void update(SysConfigDataSyn dataSyn) throws Exception {
		getHibernateTemplate().saveOrUpdate(dataSyn);
		getHibernateTemplate().flush();
	}

	public List<SysConfigDataSyn> findAll() throws Exception {
		List<SysConfigDataSyn> list = getHibernateTemplate().loadAll(SysConfigDataSyn.class);
		return list;
	}

	public SysConfigDataSyn findById(int id) {
		SysConfigDataSyn dataSyn = (SysConfigDataSyn)getHibernateTemplate().get(SysConfigDataSyn.class, id);
		return dataSyn;
	}

	@SuppressWarnings("unchecked")
	public SysConfigDataSyn findByName(String name) {
		String hql = "from SysConfigDataSyn scs where name='"+name+"'";
		
		List<SysConfigDataSyn> list = getHibernateTemplate().find(hql);
		SysConfigDataSyn dataSyn = null;
		if(list!=null && list.size()>0){
			dataSyn = list.get(0);
		}
		return dataSyn;
	}

}
