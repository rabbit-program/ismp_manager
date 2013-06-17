package edu.sjtu.infosec.ismp.manager.AIM.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertTypeDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;


public class AlertTypeDaoImpl extends HibernateDaoSupport implements AlertTypeDao {

	public List<AlertTypeBO> getListByAlertTypeDao() {
		return getHibernateTemplate().find("from AlertTypeBO");
	}

}
