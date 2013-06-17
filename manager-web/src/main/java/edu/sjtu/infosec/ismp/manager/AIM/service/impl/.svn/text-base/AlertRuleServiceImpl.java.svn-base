package edu.sjtu.infosec.ismp.manager.AIM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertRuleDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertRuleBO;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertRuleService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;


public class AlertRuleServiceImpl implements AlertRuleService {
	
	//注入Dao接口
	private AlertRuleDao alertRuleDao;
	
	
	public void setAlertRuleDao(AlertRuleDao alertRuleDao) {
		this.alertRuleDao = alertRuleDao;
	}
	//查询所有的告警规则并且分页显示
	public PageResult getPageAlertRuleService(Page page, AlertRuleBO queryVo) {
		// TODO Auto-generated method stub
		return alertRuleDao.getPageAlertRuleDao(page, queryVo);
	}
	//添加告警规则信息
	public void saveAlertRuleService(AlertRuleBO alertRuleBoEntity) {
		// TODO Auto-generated method stub
		alertRuleDao.saveAlertRuleDao(alertRuleBoEntity);
	}
	//删除告警规则信息
	public void deleteAlterRuleService(Integer AlertRuleEntityId) {
		// TODO Auto-generated method stub
		alertRuleDao.deleteAlterRuleDao(AlertRuleEntityId);
	}
	//根据ID 查询告警规则信息
	public AlertRuleBO getByIdAlertRuleService(Integer AlertRuleEntityId) {
		// TODO Auto-generated method stub
		return alertRuleDao.getByIdAlertRuleDao(AlertRuleEntityId);
	}
	//跟新告警规则信息
	public void updateAlterRuleService(AlertRuleBO alertRuleboEntity) {
		// TODO Auto-generated method stub
		alertRuleDao.updateAlterRuleDao(alertRuleboEntity);
	}
	//根据用户所属委办局，查询所有的告警规则并且分页显示
	public PageResult getPageAlertRuleService(Page page, AlertRuleBO queryVo,
			List<Domain> userToManager) {
		return alertRuleDao.getPageAlertRuleDao(page, queryVo,userToManager);
	}
	
}
