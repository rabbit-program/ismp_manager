package edu.sjtu.infosec.ismp.manager.VPM.vm.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsStat;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertStatService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusClientsService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class ClientsVirusInfoAction extends Action {
	/**
	 * 注入 service 接口
	 */
	private VirusClientsService virusClientsService;
	private VirusAlertStatService virusAlertsStatService;
	private UserService userService;
	private DomainService domainService;


	public void setVirusClientsService(VirusClientsService virusClientsService) {
		this.virusClientsService = virusClientsService;
	}
	public void setVirusAlertsStatService(VirusAlertStatService virusAlertsStatService) {
		this.virusAlertsStatService = virusAlertsStatService;
	}
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
			int currPage = 0;
			Double totalPage = 0d;
			Long totalNum = 0l;
			String cp = (request.getParameter("cp")==null)?"0":request.getParameter("cp");
			if(cp!=null && !cp.equals("")){
				currPage = Integer.parseInt(cp);
			}
			Long starResult = 0l;
			Long maxResult = 10l;
			starResult = (currPage-1)*maxResult;
			
			
			
			Map<Domain, List<VirusClients>> treeStruc = new HashMap<Domain, List<VirusClients>>();
			
			
//			System.out.println("11111111111");
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}

//			System.out.println("22222222222222222");
			for(Domain dep : userDomainList){
				List<VirusClients> vcomList = new ArrayList<VirusClients>();
				vcomList = virusClientsService.findAllVirusClientsByDepartment(dep);
								
				treeStruc.put(dep, vcomList);
			}

			long allNum = 0;
			long okNum = 0;
			long unOkNum = 0;
			Timestamp startTime = null;
			Timestamp endTime = null;
			Date t = new Date();
			int gtNUM = t.getDay();
			if(gtNUM == 0){
				gtNUM = 7;
			}
			startTime = new Timestamp(new Date(t.getYear(), t.getMonth(), (t.getDate()-gtNUM), 23,59,59).getTime());
			endTime = new Timestamp(new Date(t.getYear(), t.getMonth(), (t.getDate()+1), 0,0,0).getTime());
			// This is virus Information
			List<VirusAlertsStat> alertList = new ArrayList<VirusAlertsStat>();
			String virusClientsId = (request.getParameter("vci")==null)?null:request.getParameter("vci");
			VirusClients virusClients = null;
			if(virusClientsId!=null && !virusClientsId.equals("")){
				virusClients = virusClientsService.findVirusClientsById(Integer.parseInt(virusClientsId));
			}
	    	alertList = virusAlertsStatService.findAllByVirusClients(virusClients, startTime, endTime, starResult.intValue(), maxResult.intValue());
	    	totalNum = virusAlertsStatService.findAllNumByVirusClients(virusClients, startTime, endTime);
	    	allNum = totalNum;
	    	okNum = virusAlertsStatService.findKilledNumByVirusClients(virusClients, startTime, endTime);
	    	unOkNum = allNum - okNum;
//			System.out.println("11111111111111111111111111111111111");
			
			

//			System.out.println("3333333333333333333");
//			Iterator iter = treeStruc.entrySet().iterator(); 
//			while (iter.hasNext()) { 
//			    Map.Entry entry = (Map.Entry) iter.next(); 
//			    ManagerBO key = (ManagerBO)entry.getKey(); 
//			    List<VirusClients> val = (List<VirusClients>)entry.getValue(); 
//				System.out.println("=======================");
//				System.out.println(key.getManagerName());
//				System.out.println("=======================");
//				for(VirusClients vc : val){
//					System.out.println(vc.getClientID()+"["+vc.getClientIP()+"]");
//				}
//			}

	    	int topNum = 10;
			List<TopVirus> tvList = null;
			List<TopClients> tcList = null;
			if(virusClients!=null){
				tvList = virusAlertsStatService.findTopVirusCountByVirusClients(virusClients, startTime, endTime, topNum);
			}

			totalPage = Math.ceil((double)totalNum/maxResult);
			if(totalPage>0 && currPage<=0){
				currPage = 1;
			}
			
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalPage", totalPage.intValue());
			
	    	request.setAttribute("tvList", tvList);
			request.setAttribute("virusClientsId", virusClientsId);
			request.setAttribute("treeStruc", treeStruc);
			request.setAttribute("allNum", allNum);
			request.setAttribute("okNum", okNum);
			request.setAttribute("unOkNum", unOkNum);
	    	request.setAttribute("vc", virusClients);
	    	request.setAttribute("alertList", alertList);
		}catch(Exception e){
			System.out.println("客户端病毒告警信息查询出错！");
//			e.printStackTrace();
		}
		return mapping.findForward("virusQuery");
	}
}
