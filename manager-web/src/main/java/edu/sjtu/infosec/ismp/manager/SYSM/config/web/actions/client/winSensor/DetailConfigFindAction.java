package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.client.winSensor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;

public class DetailConfigFindAction extends Action {
	private static Logger logger = Logger.getLogger(DetailConfigFindAction.class);
	
	
//	private SysConfigDataSynService sysConfigDataSynService;
//	public void setSysConfigDataSynService(SysConfigDataSynService sysConfigDataSynService) {
//		this.sysConfigDataSynService = sysConfigDataSynService;
//	}

	private SystemLogService systemlogService;
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String toPage = "success";
		try{
//			List<SysConfigDataSyn> dataSyn=sysConfigDataSynService.findAll();
//			if(dataSyn!=null&&dataSyn.size()>0){
//				SysConfigDataSyn configDataSyn=dataSyn.get(0);
//				request.setAttribute("configDataSyn", configDataSyn);
//			}
			
		}catch(Exception e){
			toPage = "failed";
			e.printStackTrace();
		}
		return mapping.findForward(toPage);
	}
}
