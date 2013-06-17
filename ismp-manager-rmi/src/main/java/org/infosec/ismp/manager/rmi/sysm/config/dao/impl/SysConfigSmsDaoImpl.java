package org.infosec.ismp.manager.rmi.sysm.config.dao.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.sysm.config.dao.SysConfigSmsDao;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigSms;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
public class SysConfigSmsDaoImpl extends HibernateDaoSupport implements SysConfigSmsDao {

	public void add(SysConfigSms sms) throws Exception {
		getHibernateTemplate().saveOrUpdate(sms);
	}

	public void delete(SysConfigSms sms) throws Exception {
		getHibernateTemplate().delete(sms);
	}

	public void update(SysConfigSms sms) throws Exception {
		getHibernateTemplate().saveOrUpdate(sms);
		getHibernateTemplate().flush();
	}

	public List<SysConfigSms> findAll() throws Exception {
		List<SysConfigSms> list = getHibernateTemplate().loadAll(SysConfigSms.class);
		return list;
	}

	public SysConfigSms findById(int id) {
		SysConfigSms sms = (SysConfigSms)getHibernateTemplate().get(SysConfigSms.class, id);
		return sms;
	}

	@SuppressWarnings("unchecked")
	public SysConfigSms findByName(String name) {
		String hql = "from SysConfigSms scs where name='"+name+"'";
		
		List<SysConfigSms> list = getHibernateTemplate().find(hql);
		SysConfigSms sms = null;
		if(list!=null && list.size()>0){
			sms = list.get(0);
		}
		return sms;
	}

}
