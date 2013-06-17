package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.sms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigSms;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigSmsService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;

public class SmsConfigFindAction extends Action {
	private static Logger logger = Logger.getLogger(SmsConfigFindAction.class);
	
	
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
		try{
			List<SysConfigSms> sysConfigSms=sysConfigSmsService.findAll();
			if(sysConfigSms!=null&&sysConfigSms.size()>0){
				SysConfigSms configSms = sysConfigSms.get(0);
				request.setAttribute("configSms", configSms);
			}
		}catch(Exception e){
			toPage = "failed";
			e.printStackTrace();
		}
		return mapping.findForward(toPage);
	}
}
