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
public class ShowOssKnowledgeAction extends Action{
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
			int totalNums =0;
			int startResult = 0;
			int maxResult = 5;
		try{
			String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
			System.out.println("---isAll----"+isAll);
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
			 *  得到相关信息
			 */
			String filecontent=request.getParameter("filecontent");
			if(filecontent!=null&&!"".equals("filecontent"));
			filecontent = new String(request.getParameter("filecontent").getBytes("ISO8859-1"), "UTF-8");

			request.setAttribute("filecontent", filecontent);
			
			List<OssKnowledgeBase> BeginList = new ArrayList<OssKnowledgeBase>();
			List<OssKnowledgeBase> OKList = new ArrayList<OssKnowledgeBase>();
			
			if(filecontent!=null&&filecontent.length()>0){
				BeginList=ossKnowledgeBaseService.findAll();
				OKList=LuceneReadMysql.LuceneRead(BeginList, filecontent,startResult,startResult+maxResult);
				totalNums = LuceneReadMysql.getCount();
				totalPage = Math.ceil((double)totalNums/maxResult);
			}
			
			if(totalPage>0 && currPage<=0){
				currPage = 1;
			}
					
			request.setAttribute("OKList", OKList);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("respMenu", "klbm");
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		return mapping.findForward("FindossSucc");
	}
}
