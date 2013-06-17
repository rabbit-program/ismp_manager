package edu.sjtu.infosec.ismp.manager.OSS.klbm.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.OSS.klbm.model.OssKnowledgeBase;
import edu.sjtu.infosec.ismp.manager.OSS.klbm.service.OssKnowledgeBaseService;
import edu.sjtu.infosec.ismp.manager.OSS.klbm.web.form.OssKnowledgeBaseForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.comm.comm.search.LuceneReadMysql;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
/**
 * 运维知识库
 * 
 * @author cxk
 *
 * date:2010-11-12
 */
public class FindOssKnowledgeBaseAction extends Action{
	/**
	 *  Service 接口的注入
	 */
	private OssKnowledgeBaseService ossKnowledgeBaseService;
	private DomainService domainService;
	
	public void setOssKnowledgeBaseService(
			OssKnowledgeBaseService ossKnowledgeBaseService) {
		this.ossKnowledgeBaseService = ossKnowledgeBaseService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
			/**
			 * 分页定义相关的基本信息
			 */
			int currPage = 1;
			Double totalPage = 0d;
			Long totalNum = 0l;
			int totalNums =0;
			int startResult = 0;
			int maxResult = 5;
		try{
			String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
			request.setAttribute("isAll", isAll);
			System.out.println("---isAll----"+isAll);
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
			OssKnowledgeBaseForm ossKnowledgeBaseForm = (OssKnowledgeBaseForm)form;
			int domainId = ossKnowledgeBaseForm.getDmid();
			String filecontent=ossKnowledgeBaseForm.getFile_content();
			request.setAttribute("selectid", domainId);
			request.setAttribute("filecontent", filecontent);
			Domain domain = domainService.findById(domainId);
			
			List<OssKnowledgeBase> BeginList = new ArrayList<OssKnowledgeBase>();
			List<OssKnowledgeBase> OKList = new ArrayList<OssKnowledgeBase>();
			
			if(filecontent!=null&&filecontent.length()>0&&domainId>0){
				List<Domain> domains= new ArrayList<Domain>();
				domains.add(domain);
				BeginList=ossKnowledgeBaseService.findAllByDomain(domains);
				OKList=LuceneReadMysql.LuceneRead(BeginList, filecontent,startResult,startResult+maxResult);
				totalNums = LuceneReadMysql.getCount();
				totalPage = Math.ceil((double)totalNums/maxResult);
			}else if(filecontent!=null&&filecontent.length()>0){
				BeginList=ossKnowledgeBaseService.findAll();
				OKList=LuceneReadMysql.LuceneRead(BeginList, filecontent,startResult,startResult+maxResult);
				totalNums = LuceneReadMysql.getCount();
				totalPage = Math.ceil((double)totalNums/maxResult);
			}else{
				
				if(isAll.equals("1")){
					request.setAttribute("isAll", isAll);
					/**
					 * 通过传来委办局信息Id查询运维知识库某段时间内的相关信息 
					 * 
					 * OKList =ossKnowledgeBaseService.findAllByDomain(null, null, startResult, maxResult, domainId, domain);
					 */
						OKList =ossKnowledgeBaseService.findAll(null, null, startResult, maxResult);
				}else{
//					OKList = ossKnowledgeBaseService.findAllByDomainList(userDomainList, null, null, startResult, maxResult, domainId, domain);
				}
				
				/**
				 * 	分页得到的相关基本信息
				 */
				if(OKList != null && OKList.size() >= 0){
				if(isAll.equals("1")){
					/**
					 * 通过传来委办局信息Id查询运维知识库某段时间内的相关信息的总记录数
					 * 
					 * totalNum=ossKnowledgeBaseService.findAllNumByDomain(null, null, domainId);
					 * System.out.println("总记录数："+totalNum);
					 */
					
						totalNum=ossKnowledgeBaseService.findAllNum(null, null);
						totalPage = Math.ceil((double)totalNum/maxResult);
				}else{
//						totalNum = ossKnowledgeBaseService.findAllNumByDomainList(userDomainList, null, null, domainId);
						totalPage = Math.ceil((double)totalNum/maxResult);
				}
			  }
			}
			
				if(totalPage>0 && currPage<=0){
					currPage = 1;
				}
					
			request.setAttribute("udl", userDomainList);
			request.setAttribute("OKList", OKList);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("ossMenu", "klbm");
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		return mapping.findForward("ossFindSucc");
	}
}
