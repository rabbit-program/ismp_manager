package edu.sjtu.infosec.ismp.manager.AIM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertTypeDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertTypeService;


public class AlertTypeServiceImpl implements AlertTypeService{

	
	//注入DAO 层接口
	private AlertTypeDao alertTypeDao;
	
	public void setAlertTypeDao(AlertTypeDao alertTypeDao) {
		this.alertTypeDao = alertTypeDao;
	}
	
	
	public List<AlertTypeBO> getLisByAlertTypeService() {		
		return alertTypeDao.getListByAlertTypeDao();
	}

}
