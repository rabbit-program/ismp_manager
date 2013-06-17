package edu.sjtu.infosec.ismp.manager.AIM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;


public interface AlertTypeService {
   
	
	//查询所有的设备类型
	List<AlertTypeBO> getLisByAlertTypeService();
}
