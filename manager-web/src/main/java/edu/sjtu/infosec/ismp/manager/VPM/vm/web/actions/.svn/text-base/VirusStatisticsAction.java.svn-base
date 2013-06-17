package edu.sjtu.infosec.ismp.manager.VPM.vm.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertStatService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusClientsService;

public class VirusStatisticsAction extends Action {
	/**
	 * 注入 service 接口
	 */
	private VirusClientsService virusClientsService;
	private VirusAlertStatService virusAlertsStatService;
//	private VirusService virusService;
	private UserService userService;
	private DomainService domainService;


	public void setVirusClientsService(VirusClientsService virusClientsService) {
		this.virusClientsService = virusClientsService;
	}
	public void setVirusAlertsStatService(VirusAlertStatService virusAlertsStatService) {
		this.virusAlertsStatService = virusAlertsStatService;
	}
//	public void setVirusService(VirusService virusService) {
//		this.virusService = virusService;
//	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

//		System.out.println("000000000000000");
		try{
			String qt = (request.getParameter("qt")==null)?null:request.getParameter("qt");
			System.out.println("qt:="+qt);
			if(qt!=null && qt.equals("y")){
				System.out.println("年统计！");
				
			}else if(qt!=null && qt.equals("m")){
				System.out.println("月统计！");
				
			}else if(qt!=null && qt.equals("d")){
				System.out.println("日统计！");
				
			}else{
				System.out.println("未选择要统计的范围，默认日统计！");
				qt = "d";
			}
			request.setAttribute("qt", qt);
			return mapping.findForward("statistics");
		}catch(Exception e){
			System.out.println("病毒统计信息出错！");
//			e.printStackTrace();
			return mapping.findForward("statisticsError");
		}
	}
}
