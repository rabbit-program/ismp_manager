package edu.sjtu.infosec.ismp.manager.GOSP.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.GOSP.model.GospKnowledgeBase;
import edu.sjtu.infosec.ismp.manager.GOSP.service.GospKnowledgeBaseService;
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
public class FindKnowledgeBaseAction extends Action{
	/**
	 *  Service 接口的注入
	 */

	private GospKnowledgeBaseService knowledgeBaseService;
	private DomainService domainService;
	
	public void setKnowledgeBaseService(GospKnowledgeBaseService knowledgeBaseService) {
		this.knowledgeBaseService = knowledgeBaseService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		
		/**
		 * 分页定义相关的基本信息
		 */
		int currPage = 1;
		Double totalPage = 0d;
		Long totalNum = 0l;
		int startResult = 0;
		int maxResult = 5;
		
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
			
			List<GospKnowledgeBase> knowledgeList = new ArrayList<GospKnowledgeBase>();
			
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				/**
				 * 通过传来的委办局信息Id查询某段时间内知识库相关的信息
				 * 
				 * knowledgeList =knowledgeBaseService.findAllByDomain(null, null, startResult, maxResult, domainId, domain);
				 */
					knowledgeList =knowledgeBaseService.findAll(null, null, startResult, maxResult);
			}else{
//				knowledgeList = knowledgeBaseService.findAllByDomainList(userDomainList, null, null, startResult, maxResult, domainId, domain);
			}
			
			/**
			 * 	分页得到的相关基本信息
			 */
			if(knowledgeList != null && knowledgeList.size() >= 0){
				if(isAll.equals("1")){
					/**
					 * 通过传来的委办局信息Id查询某段时间内知识库相关的信息的总记录数
					 * totalNum=knowledgeBaseService.findAllNumByDomain(null, null, domainId);
					 * System.out.println("总记录数："+totalNum);
					 */
					
						totalNum=knowledgeBaseService.findAllNum(null, null);
				}else{
//					totalNum = knowledgeBaseService.findAllNumByDomainList(userDomainList, null, null, domainId);
				}
			  }
				totalPage = Math.ceil((double)totalNum/maxResult);
				if(totalPage>0 && currPage<=0){
					currPage = 1;
				}
					
			request.setAttribute("udl", userDomainList);
			request.setAttribute("kBList", knowledgeList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		request.setAttribute("gradeMenu", "KB");
		return mapping.findForward("findSuccess");
	}
}
