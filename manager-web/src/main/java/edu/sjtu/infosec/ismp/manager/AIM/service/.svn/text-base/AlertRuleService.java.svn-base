package edu.sjtu.infosec.ismp.manager.AIM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertRuleBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;


public interface AlertRuleService {

	
	 //查询所有的告警规则并且分页显示
	PageResult getPageAlertRuleService(Page page,AlertRuleBO queryVo);
	
	//添加告警规则信息
	void saveAlertRuleService(AlertRuleBO alertRuleBoEntity);
	
	//根据ID 查询出单条告警规则信息
	AlertRuleBO getByIdAlertRuleService(Integer AlertRuleEntityId);
	
	//根据Id删除单条告警信息
	void deleteAlterRuleService(Integer AlertRuleEntityId);
	
	
	
	//更新告警规则信息
	void updateAlterRuleService(AlertRuleBO alertRuleboEntity);
	
	//根据用户所属委办局，查询所有的告警规则并且分页显示
	PageResult getPageAlertRuleService(Page page,AlertRuleBO queryVo,List<Domain> userToManager);
}
