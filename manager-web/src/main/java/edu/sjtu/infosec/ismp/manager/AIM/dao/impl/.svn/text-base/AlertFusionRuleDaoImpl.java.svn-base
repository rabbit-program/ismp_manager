package edu.sjtu.infosec.ismp.manager.AIM.dao.impl;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertFusionRuleDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertFusionRuleBO;

/**
 * 
 * @author shixq
 *
 */
public class AlertFusionRuleDaoImpl extends HibernateDaoSupport implements AlertFusionRuleDao {

	public AlertFusionRuleBO getAlertFusionRuleDao() {
		// TODO Auto-generated method stub
		Criteria cri=getSession().createCriteria(AlertFusionRuleBO.class);
		cri.setMaxResults(1);
		AlertFusionRuleBO alertFusionRuleBO=(AlertFusionRuleBO) cri.uniqueResult();
		return alertFusionRuleBO;
	}
	public void saveOrUpdateAlertFusionRuleDao(AlertFusionRuleBO entityAlertFusionRuleBO) {
		// TODO Auto-generated method stub
		getHibernateTemplate().clear();
		getHibernateTemplate().saveOrUpdate(entityAlertFusionRuleBO);
	}
}
