package org.infosec.ismp.manager.rmi.sysm.config.dao.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.dao.SysConfigDbDao;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDb;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public class SysConfigDbDaoImpl extends HibernateDaoSupport implements SysConfigDbDao {

	public void add(SysConfigDb db) throws Exception {
		getHibernateTemplate().saveOrUpdate(db);
	}

	public void delete(SysConfigDb db) throws Exception {
		getHibernateTemplate().delete(db);
	}

	public void update(SysConfigDb db) throws Exception {
		getHibernateTemplate().saveOrUpdate(db);
		getHibernateTemplate().flush();
	}

	public List<SysConfigDb> findAll() throws Exception {
		List<SysConfigDb> list = getHibernateTemplate().loadAll(SysConfigDb.class);
		return list;
	}

	public SysConfigDb findById(int id) {
		SysConfigDb db = (SysConfigDb)getHibernateTemplate().get(SysConfigDb.class, id);
		return db;
	}

	@SuppressWarnings("unchecked")
	public SysConfigDb findByName(String name) {
		String hql = "from SysConfigDb scd where name='"+name+"'";
		
		List<SysConfigDb> list = getHibernateTemplate().find(hql);
		SysConfigDb db = null;
		if(list!=null && list.size()>0){
			db = list.get(0);
		}
		return db;
	}

}
