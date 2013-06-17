package edu.sjtu.infosec.ismp.manager.GOSP.web.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.GOSP.model.SafeStateRecords;
import edu.sjtu.infosec.ismp.manager.GOSP.service.SafeStateRecordsService;

import edu.sjtu.infosec.ismp.manager.GOSP.web.form.ShowLawRulesForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
/**
 * 
 * @author cxk
 *
 * date:2010-11-12
 */
public class FindNetStateSafeAction extends Action{
	/**
	 *  Service 接口的注入
	 */
	private SafeStateRecordsService safeStateRecordsService;
	private DomainService domainService;
	
	public void setSafeStateRecordsService(
			SafeStateRecordsService safeStateRecordsService) {
		this.safeStateRecordsService = safeStateRecordsService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}


	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping,ActionForm form,
										HttpServletRequest request,HttpServletResponse response){
		/**
		 * 分页定义相关的基本信息
		 */
		int currPage = 1;
		Double totalPage = 0d;
		Long totalNum = 0l;
		int startResult = 0;
		int maxResult = 5 ;
		
		try{
			String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
			/**
			 * 得到域集合的相关信息
			 */
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			
			/**
			 * 分页得到的相关的基本信息
			 */
			String cp = (request.getParameter("currPage")==null)?"1":request.getParameter("currPage");
			if(cp!=null && !cp.equals("")){
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage-1)*maxResult;
			if(startResult < 0){
				startResult = 0;
			}
			
			/**
			 *   从表单得到相关信息
			 */
			ShowLawRulesForm showLawRulesForm = (ShowLawRulesForm)form;
			int domainId = showLawRulesForm.getDmid();
			request.setAttribute("selectid", domainId);
			@SuppressWarnings("unused")
			Domain domain = domainService.findById(domainId);
			List<SafeStateRecords> netSafelist = new ArrayList<SafeStateRecords>();	
			
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				/**
				 * 通过传来的委办局信息Id查询某时间段内网络等保状态相关信息
				 * 
				 * netSafelist =safeStateRecordsService.findAllByDomain(null, null, startResult, maxResult, domainId, domain);
				 */
					netSafelist =safeStateRecordsService.findAll(null, null, startResult, maxResult);
			}else{
//				netSafelist = safeStateRecordsService.findAllByDomainList(userDomainList, null, null, startResult, maxResult, domainId, domain);
			}
			
			/**
			 * 	分页得到的相关基本信息
			 */
			if(netSafelist != null && netSafelist.size() >= 0){
				if(isAll.equals("1")){
					/**
					 * 通过传来的委办局信息Id查询某时间段内网络等保状态相关信息的总记录数
					 * 
					 * totalNum=safeStateRecordsService.findAllNumByDomain(null, null, domainId);
					 */
						totalNum=safeStateRecordsService.findAllNum(null, null);
				}else{
//					totalNum = safeStateRecordsService.findAllNumByDomainList(userDomainList, null, null, domainId);
				}
			  }
				totalPage = Math.ceil((double)totalNum/maxResult);
				if(totalPage>0 && currPage<=0){
					currPage = 1;
				}
			
			/**
			 * 为等级保护状态的-等级填充数据的相关信息
			 */
			Map<String ,Integer> levelMap = new HashMap<String ,Integer>();
			List<String> lList = new ArrayList<String>();
			/**
			 * 查询指定域和时间段下等级保护的等级的相关信息
			 * 
			 * List<Object[]> levelList = safeStateRecordsService.findAllByDomainAndLevel(userDomainList, null, null);
			 */					
			List<Object[]> levelList = safeStateRecordsService.findAllByTimeAndLevel(null, null);
			for(Object[]  ssr : levelList){			
				levelMap.put(ssr[0]+"", Integer.parseInt(ssr[1].toString()));
				lList.add(ssr[0]+"") ;
			}
			request.setAttribute("lList", lList);
			request.setAttribute("lcMap", levelMap);
			/**
			 * 为等级保护状态的-状态填充数据的相关信息
			 */
			Map<String ,Integer> stateMap = new HashMap<String ,Integer>();
			List<String> sList = new ArrayList<String>();
			/**
			 * 查询指定域和时间段下等级保护的状态的相关信息
			 * 
			 * List<Object[]> stateList = safeStateRecordsService.findAllByDomainAndState(userDomainList, null, null);
			 */		
			List<Object[]> stateList = safeStateRecordsService.findAllByTimeAndState(null, null);
			for(Object[] netState : stateList){
				stateMap.put(netState[0]+"", Integer.parseInt(netState[1].toString()));
				sList.add(netState[0]+"");
			}
			request.setAttribute("sList", sList);
			request.setAttribute("scMap", stateMap);
			
			request.setAttribute("udl", userDomainList);
			request.setAttribute("netSafelist", netSafelist);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		request.setAttribute("gradeMenu", "NS");
		return mapping.findForward("netSafeSuccess");
	}
}
