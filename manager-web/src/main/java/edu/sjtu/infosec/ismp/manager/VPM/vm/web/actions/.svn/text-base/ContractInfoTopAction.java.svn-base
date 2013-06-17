package edu.sjtu.infosec.ismp.manager.VPM.vm.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopVirus;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertStatService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusClientsService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class ContractInfoTopAction extends Action {
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
			String cc = (request.getParameter("cc")==null)?null:request.getParameter("cc");
			String depId = (request.getParameter("di")==null)?null:request.getParameter("di");
			String virusClientsId = (request.getParameter("vci")==null)?null:request.getParameter("vci");
			int topNum = Integer.parseInt((request.getParameter("tn")==null)?"0":request.getParameter("tn"));
			
//			Map<ManagerBO, List<VirusClients>> treeStruc = new HashMap<ManagerBO, List<VirusClients>>();
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}

//			for(ManagerBO dep : departmentList){
//				List<VirusClients> vcomList = new ArrayList<VirusClients>();
//				vcomList = virusClientsService.findAllVirusClientsByDepartment(dep);
//				treeStruc.put(dep, vcomList);
//			}
			
			Timestamp startTime = null;
			Timestamp endTime = null;
			Date t = new Date();
			int gtNUM = t.getDay();
			if(gtNUM == 0){
				gtNUM = 7;
			}
			startTime = new Timestamp(new Date(t.getYear(), t.getMonth(), (t.getDate()-gtNUM), 23,59,59).getTime());
			endTime = new Timestamp(new Date(t.getYear(), t.getMonth(), (t.getDate()+1), 0,0,0).getTime());

			if(virusClientsId!=null && !virusClientsId.equals("")){
				VirusClients virusClients = null;
				virusClients = virusClientsService.findVirusClientsById(Integer.parseInt(virusClientsId));
				if(cc!=null && cc.equals("virus")){
//					System.out.println("病毒TOP！");
					List<TopVirus> tvList = new ArrayList<TopVirus>();
					tvList = virusAlertsStatService.findTopVirusCountByVirusClients(virusClients, startTime, endTime, topNum);
			    	request.setAttribute("vc", virusClients);
			    	request.setAttribute("tvList", tvList);
					return mapping.findForward("virusTopShow");
				}else{
					System.out.println("请选择要查看的TOP内容！");
					return mapping.findForward("topShowError");
				}
			}else{
				List<VirusClients> virusClientsList = new ArrayList<VirusClients>();
				if(depId!=null && !depId.equals("")){
					Domain dep = domainService.findById(Integer.parseInt(depId));
					virusClientsList = virusClientsService.findAllVirusClientsByDepartment(dep);
				}else{
					virusClientsList = virusClientsService.findAllVirusClientsByDepartmentListExceptUnknow(userDomainList);
				}
				
				if(cc!=null && cc.equals("virus")){
//					System.out.println("病毒TOP！");
					List<TopVirus> tvList = new ArrayList<TopVirus>();
					tvList = virusAlertsStatService.findTopVirusCountByVirusClientsList(virusClientsList, startTime, endTime, topNum);
			    	request.setAttribute("tvList", tvList);
					return mapping.findForward("virusTopShow");
				}else if(cc!=null && cc.equals("clients")){
//					System.out.println("客户端TOP！");
					List<TopClients> tcList = new ArrayList<TopClients>();
					tcList = virusAlertsStatService.findTopClientsCountByVirusClientsList(virusClientsList, startTime, endTime, topNum);
			    	request.setAttribute("tcList", tcList);
					return mapping.findForward("clientsTopShow");
				}else{
					System.out.println("请选择要查看的TOP内容！");
					return mapping.findForward("topShowError");
				}
			}
		}catch(Exception e){
			System.out.println("TOP排名查询出错！");
//			e.printStackTrace();
			return mapping.findForward("topShowError");
		}
	}
}
