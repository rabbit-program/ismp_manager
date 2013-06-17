package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.vpm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigDbService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;

public class VpmDbConfigModifyAction extends Action {
	private static Logger logger = Logger.getLogger(VpmDbConfigModifyAction.class);
	

	private SysConfigDbService sysConfigDbService;
	public void setSysConfigDbService(SysConfigDbService sysConfigDbService) {
		this.sysConfigDbService = sysConfigDbService;
	}
	
	private SystemLogService systemlogService;
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

	
	
	
	
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String toPage = "index";
		try{
			toPage = "success";
			
		}catch(Exception e){
			
		}
		return mapping.findForward(toPage);
	}
}
