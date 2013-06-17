package edu.sjtu.infosec.ismp.manager.AIM.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertFusionRuleDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertFusionRuleBO;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertFusionRuleServices;

/**
 * 
 * @author shixq
 *
 */
public class AlertFusionRuleServicesImpl implements AlertFusionRuleServices {

	private AlertFusionRuleDao alertFusionRuleDao;
	
	

	public AlertFusionRuleBO getAlertFusionRuleServices() {
		// TODO Auto-generated method stub
		return alertFusionRuleDao.getAlertFusionRuleDao();
	}

	public void saveOrUpdateAlertFusionRuleServices(AlertFusionRuleBO entityAlertFusionRuleBO) {
		// TODO Auto-generated method stub
        AlertFusionRuleBO alertFusionRuleBO=alertFusionRuleDao.getAlertFusionRuleDao();
        if(alertFusionRuleBO!=null){
        	try {
        		entityAlertFusionRuleBO.setDepict(alertFusionRuleBO.getDepict());
        		entityAlertFusionRuleBO.setId(alertFusionRuleBO.getId());
				BeanUtils.copyProperties(alertFusionRuleBO, entityAlertFusionRuleBO);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		alertFusionRuleDao.saveOrUpdateAlertFusionRuleDao(alertFusionRuleBO);
	}
	
	public void setAlertFusionRuleDao(AlertFusionRuleDao alertFusionRuleDao) {
		this.alertFusionRuleDao = alertFusionRuleDao;
	}
}
