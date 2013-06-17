package edu.sjtu.infosec.ismp.manager.AIM.dao;

import java.util.List;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;




/**
 * 发送告警信息 给个模块公用
 * **/

public interface SendAlertDao {

	public boolean sendAlertService(AlertInfoBO alertInfoBO) throws Exception;

}
