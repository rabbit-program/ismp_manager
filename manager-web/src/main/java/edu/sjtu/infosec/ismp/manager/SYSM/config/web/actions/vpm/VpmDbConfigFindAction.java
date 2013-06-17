package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.vpm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDb;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigDbService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;

public class VpmDbConfigFindAction extends Action {
	private static Logger logger = Logger.getLogger(VpmDbConfigFindAction.class);
	

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

    	String toPage = "success";
		try{
			SysConfigDb wsus = sysConfigDbService.findByName("wsus");
			if(wsus!=null){
				request.setAttribute("wsus", wsus);
			}
			SysConfigDb rav = sysConfigDbService.findByName("rav");
			if(rav!=null){
				request.setAttribute("rav", rav);
			}
			
		}catch(Exception e){
			toPage = "failed";
		}
		return mapping.findForward(toPage);
	}
}
