package edu.sjtu.infosec.ismp.manager.AIM.service.impl;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

import edu.sjtu.infosec.ismp.manager.AIM.dao.SendAlertDao;
import edu.sjtu.infosec.ismp.manager.AIM.service.SendAlertService;


public class SendAlertServiceImpl implements SendAlertService {

	private SendAlertDao sendAlertDao;
	

	public void setSendAlertDao(SendAlertDao sendAlertDao) {
		this.sendAlertDao = sendAlertDao;
	}


	public boolean sendAlertService(AlertInfoBO alertInfoBO) throws Exception {
		return sendAlertDao.sendAlertService(alertInfoBO);
	}

}
