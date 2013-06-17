package edu.sjtu.infosec.ismp.manager.GOSP.web.actions;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.GOSP.model.GospKnowledgeBase;
import edu.sjtu.infosec.ismp.manager.GOSP.service.GospKnowledgeBaseService;
import edu.sjtu.infosec.ismp.manager.GOSP.web.form.KnowledgeBaseForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
/**
 * 
 * @author cxk
 *
 * date:2010-11-17
 */
@SuppressWarnings("unused")
public class UpdateAndDelAction extends DispatchAction{
	/**
	 * service 接口的注入
	 */
	private GospKnowledgeBaseService knowledgeBaseService;
	private DomainService domainService;
	private SystemLogService systemLogService;
	
	public void setKnowledgeBaseService(GospKnowledgeBaseService knowledgeBaseService) {
		this.knowledgeBaseService = knowledgeBaseService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	/**
	 * 通过知识库ID得到知识库对象（KnowledgeBase）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updateValue(ActionMapping mapping, ActionForm form,
											HttpServletRequest request, HttpServletResponse response){
		try{
			String KBid = request.getParameter("id");
			request.getSession().setAttribute("KBid", KBid);
			if(null != KBid && !"".equals(KBid)){
				GospKnowledgeBase KBInfo = knowledgeBaseService.findById(Integer.parseInt(KBid));
				request.setAttribute("KBInfo", KBInfo);
			}
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			request.setAttribute("udl", userDomainList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mapping.findForward("updateSuccess");
	}
	/**
	 * 通过 KnowledgeBase 来更新知识库相关的信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward update(ActionMapping mapping, ActionForm form,
										HttpServletRequest request, HttpServletResponse response){
		/**
		 * 加载日志信息
		 */
		LogUtil.init();
		SystemLog log = new SystemLog();
		try{
		KnowledgeBaseForm knowledgeBaseForm =(KnowledgeBaseForm)form;
		GospKnowledgeBase knowledgeBase = new GospKnowledgeBase();
		String ID = request.getSession().getAttribute("KBid").toString();
		/**
		 * 格式化当前系统日期
		 */
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = dateFm.format(new java.util.Date().getTime());
		java.util.Date timeDate = dateFm.parse(dateTime);
		java.sql.Timestamp dTime = new java.sql.Timestamp(timeDate.getTime());
		
		if(null != ID && !"".equals(ID)){
			knowledgeBase.setId(Integer.parseInt(ID));
			knowledgeBase.setName(knowledgeBaseForm.getName());
//			knowledgeBase.setDomain(domainService.findById(knowledgeBaseForm.getDmid()));
			knowledgeBase.setFile_content(knowledgeBaseForm.getFile_content());
			knowledgeBase.setCreateTime(dTime);
			knowledgeBase.setIssuer(knowledgeBaseForm.getIssuer());
			knowledgeBase.setSn(knowledgeBaseForm.getSn());
			knowledgeBase.setLastUpdateTime(new Timestamp(new Date().getTime()));
			knowledgeBase.setRemark(knowledgeBaseForm.getRemark());
			knowledgeBaseService.update(knowledgeBase);
		}
		
		/**
		 * 加入日志相关的信息
		 */
		
		log.setUsername(LogUtil.userName);
	    log.setRoleName(LogUtil.roleName);
	    log.setTime(new Timestamp(new Date().getTime()));
	    log.setModuleName(SystemModelInfo.MOD_GOSP);
	    log.setOperationDesc("知识库相关信息的更新");
	    log.setControl("成功！");
	    systemLogService.saveSystemLog(log);
		PrintWriter out = response.getWriter();
        out = response.getWriter();
        response.setContentType("text/html; charset=UTF-8");
        out.println("<script language=\"javascript\">");
        out.println("window.opener.location.href=window.opener.location.href;");
        out.println("window.opener.location.reload();");
        out.println("window.close();");
        out.println("</script>");
        out.close();
        return null;
		}catch(Exception e){
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("知识库相关信息的更新");
		    log.setControl("失败！");
		    systemLogService.saveSystemLog(log);
			e.printStackTrace();
		}
		return mapping.findForward("update");
	}
	/**
	 * 通过 KnowledgeBase 来删除知识库的相关记录
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form,
											HttpServletRequest request, HttpServletResponse response){
		/**
		 * 加载日志信息
		 */
		LogUtil.init();
		SystemLog log = new SystemLog();
		try{
			String ID = request.getParameter("id");
			request.setAttribute("currPage", request.getParameter("currPage"));
			if(null != ID && !"".equals(ID)){
				GospKnowledgeBase knowledgeBase = knowledgeBaseService.findById(Integer.parseInt(ID));
				knowledgeBaseService.delete(knowledgeBase);
				/**
				 * 加入日志相关的信息
				 */
				
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("删除知识库相关的信息");
			    log.setControl("成功！");
			    systemLogService.saveSystemLog(log);
			}
		}catch(Exception e){
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("删除知识库相关的信息");
		    log.setControl("失败！");
		    systemLogService.saveSystemLog(log);
			e.printStackTrace();
		}
		return mapping.findForward("delSuccess");
	}
}
