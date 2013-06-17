package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.sms;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDataSyn;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigSms;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigSmsService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.ds.DataSynConfigForm;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.sms.SmsConfigForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class SmsConfigModifyAction extends Action {
	private static Logger logger = Logger.getLogger(SmsConfigModifyAction.class);
	
	
	private SysConfigSmsService sysConfigSmsService;
	public void setSysConfigSmsService(SysConfigSmsService sysConfigSmsService) {
		this.sysConfigSmsService = sysConfigSmsService;
	}

	private SystemLogService systemlogService;
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

	
	
	
	
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String toPage = "success";
    	//添加日志
 		OperatorDetails user = SecurityUserHolder.getCurrentUser();
 		SystemLog log = new SystemLog();
 		log.setUsername(user.getUsername());
 		List<Role> list=user.getRoleList();
 		String roles="";
 		for(Role role:list){
 			roles+=role.getName()+",";
 		}
 		log.setRoleName(roles.substring(0,roles.length()-1));
 		log.setTime(new Timestamp(new Date().getTime()));
 		log.setModuleName(SystemModelInfo.MOD_SYSM_config);
 		
		try{
			SmsConfigForm smsForm = (SmsConfigForm)form;
			SysConfigSms configSms = new SysConfigSms();
			
			List<SysConfigSms> sysConfigSms=sysConfigSmsService.findAll();
			if(sysConfigSms!=null&&sysConfigSms.size()>0){
				configSms = sysConfigSms.get(0);
				configSms.setSendIp(smsForm.getSendIp());
				configSms.setSendPort(smsForm.getSendPort());
				configSms.setEmailServer(smsForm.getEmailServer());
				configSms.setEmail(smsForm.getEmail());
				configSms.setUsername(smsForm.getUsername());
				configSms.setPassword(smsForm.getPassword());
				sysConfigSmsService.update(configSms);
				request.setAttribute("message", "修改信息发送信息成功");
				log.setOperationDesc("系统管理模块平台配置,修改信息发送信息");
			}else{
				configSms.setSendIp(smsForm.getSendIp());
				configSms.setSendPort(smsForm.getSendPort());
				configSms.setEmailServer(smsForm.getEmailServer());
				configSms.setEmail(smsForm.getEmail());
				configSms.setUsername(smsForm.getUsername());
				configSms.setPassword(smsForm.getPassword());
				sysConfigSmsService.add(configSms);
				request.setAttribute("message", "新增信息发送信息成功");
				log.setOperationDesc("系统管理模块平台配置,新增信息发送信息");
			}
			request.setAttribute("configSms", configSms);
			log.setControl("成功");
		}catch(Exception e){
			toPage = "failed";
			request.setAttribute("message", "信息发送信息操作失败");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			e.printStackTrace();
		}
		systemlogService.saveSystemLog(log);
		return mapping.findForward(toPage);
	}
}
