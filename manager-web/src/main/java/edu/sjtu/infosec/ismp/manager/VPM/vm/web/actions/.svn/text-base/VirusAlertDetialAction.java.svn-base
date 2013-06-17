package edu.sjtu.infosec.ismp.manager.VPM.vm.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsStat;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertStatService;

public class VirusAlertDetialAction extends Action {
	/**
	 * 注入 service 接口
	 */
	private VirusAlertStatService virusAlertsStatService;


	public void setVirusAlertsStatService(VirusAlertStatService virusAlertsStatService) {
		this.virusAlertsStatService = virusAlertsStatService;
	}
	
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	       	

//		System.out.println("000000000000000");
		try{
			String virusAlertStatId = (request.getParameter("vasi")==null)?null:request.getParameter("vasi");
			VirusAlertsStat alerts = null;
			if(virusAlertStatId!=null && !virusAlertStatId.equals("")){
				alerts = virusAlertsStatService.findVirusAlertStatById(Integer.parseInt(virusAlertStatId));
			}
//			System.out.println("11111111111111111111111111111111111");
	    	request.setAttribute("alerts", alerts);
		}catch(Exception e){
			System.out.println("病毒告警详情查询出错！");
//			e.printStackTrace();
		}
		return mapping.findForward("virusAlertDetial");
	}
}
