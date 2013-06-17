package edu.sjtu.infosec.ismp.manager.AIM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;


public interface AlertTypeDao {
   
	//查询出所有的设备类型
	List<AlertTypeBO> getListByAlertTypeDao();
}
