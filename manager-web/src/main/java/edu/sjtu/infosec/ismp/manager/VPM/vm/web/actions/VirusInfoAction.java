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

public class VirusInfoAction extends Action {
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

		try{

			String depId = (request.getParameter("di")==null)?null:request.getParameter("di");
						
			/*
			 * 分页基本信息的定义
			 * 以及相关信息的计算
			 */
			int currPage = 0;
			Double totalPage = 0d;
			Long totalNum = 0l;
			
			String cp = (request.getParameter("cup")==null)?"0":request.getParameter("cup");

			if(cp!=null && !cp.equals("")){
				currPage = Integer.parseInt(cp);
			}

			Long starResult = 0l;
			Long maxResult = 10l;
			starResult = (currPage-1)*maxResult;
			
			
			Map<Domain, List<VirusClients>> treeStruc = new HashMap<Domain, List<VirusClients>>();
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}

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
			List<VirusClients> virusClientsList = new ArrayList<VirusClients>();
			if(depId!=null && !depId.equals("")){
				Domain dep = domainService.findById(Integer.parseInt(depId));
				virusClientsList = virusClientsService.findAllVirusClientsByDepartment(dep);
			}else{
				virusClientsList = virusClientsService.findAllVirusClientsByDepartmentListExceptUnknow(userDomainList);
			}
			List<VirusAlertsStat> alertList = new ArrayList<VirusAlertsStat>();
	    	alertList = virusAlertsStatService.findAllByVirusClientsList(virusClientsList, startTime, endTime, starResult.intValue(), maxResult.intValue());
	    	totalNum = virusAlertsStatService.findAllNumByVirusClientsList(virusClientsList, startTime, endTime);
	    	if(alertList!=null && alertList.size()>0){
		    	allNum = totalNum;
	    	}
	    	okNum = virusAlertsStatService.findKilledNumByVirusClientsList(virusClientsList, startTime, endTime);
	    	unOkNum = allNum - okNum;
//			System.out.println("11111111111111111111111111111111111");findAllByVirusClientsList(virusClientsList, startTime, endTime);
	    	
//	    	for(Iterator it =alertList.iterator();it.hasNext();){
//	    		VirusAlertsStat vs = (VirusAlertsStat)it.next();
//	    		
//	    		System.out.println("这是查找时间"+vs.getLastFindTime());
//	    		System.out.println("这是病毒数量"+vs.getVCount());
//	    		
//	    	}
			
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
	    	
//	    	总页数的计算
	    	totalPage = Math.ceil((double)totalNum/maxResult);
			if(totalPage>0 && currPage<=0){
				currPage = 1;
			}
			
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalPage", totalPage.intValue());

	    	int topNum = 10;
			List<TopVirus> tvList = null;
			List<TopClients> tcList = null;
			if(virusClientsList!=null && virusClientsList.size()>0){
				tcList = virusAlertsStatService.findTopClientsCountByVirusClientsList(virusClientsList, startTime, endTime, topNum);
				tvList = virusAlertsStatService.findTopVirusCountByVirusClientsList(virusClientsList, startTime, endTime, topNum);
			}

	    	request.setAttribute("depId", depId);
	    	request.setAttribute("tcList", tcList);
	    	request.setAttribute("tvList", tvList);
			request.setAttribute("treeStruc", treeStruc);
			request.setAttribute("allNum", allNum);
			request.setAttribute("okNum", okNum);
			request.setAttribute("unOkNum", unOkNum);
	    	request.setAttribute("alertList", alertList);
		}catch(Exception e){
			System.out.println("所有病毒告警信息查询出错！");
//			e.printStackTrace();
		}
		return mapping.findForward("virusQuery");
	}
}
