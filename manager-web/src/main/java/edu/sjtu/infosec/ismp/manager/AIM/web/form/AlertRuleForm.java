package edu.sjtu.infosec.ismp.manager.AIM.web.form;

import org.apache.struts.action.ActionForm;
import org.quartz.jobs.ee.mail.SendMailJob;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertRuleBO;


public class AlertRuleForm extends ActionForm {

	 //封装告警规则信息VO
	private AlertRuleBO alertRulebo=new AlertRuleBO();	
	

	public AlertRuleBO getAlertRulebo() {
		return alertRulebo;
	}

	public void setAlertRulebo(AlertRuleBO alertRulebo) {
		this.alertRulebo = alertRulebo;
	}
	
	public void reset() {
		alertRulebo = new AlertRuleBO();	
	}
}
