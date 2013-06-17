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
import edu.sjtu.infosec.ismp.manager.GOSP.model.LawsAndRules;
import edu.sjtu.infosec.ismp.manager.GOSP.service.LawsAndRulesService;
import edu.sjtu.infosec.ismp.manager.GOSP.web.form.LawRulesForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
/**
 * 上传信息的更新和删除
 * 
 * @author cxk
 *
 * date:2010-11-17
 */
@SuppressWarnings("unused")
public class UpdateAndDelLawRulesAction extends DispatchAction{
	/**
	 * service 接口的注入
	 */
	private LawsAndRulesService lawsAndRulesService;
	private DomainService domainService;
	private SystemLogService systemLogService;
	
	public void setLawsAndRulesService(LawsAndRulesService lawsAndRulesService) {
		this.lawsAndRulesService = lawsAndRulesService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}	
	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}
	/**
	 * 通过法律法规（上传信息）ID得到法律法规（LawsAndRules）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward updateValue(ActionMapping mapping,ActionForm form,
											HttpServletRequest request,HttpServletResponse response){
		try{
			String uploadId = request.getParameter("id");
			request.getSession().setAttribute("uploadId", uploadId);
			if(null != uploadId && !"".equals(uploadId)){
				LawsAndRules lawsAndRules = lawsAndRulesService.findById(Integer.parseInt(uploadId));
				request.getSession().setAttribute("lawsAndRules", lawsAndRules);
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
		return mapping.findForward("updateLawRules");
	}
	/**
	 * 通过 LawAndRules 来更新法律法规相关的信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward update(ActionMapping mapping,ActionForm form,
										HttpServletRequest request,HttpServletResponse response){
		/**
		 * 加载日志信息
		 */
		LogUtil.init();
		SystemLog log = new SystemLog();
		try{			
			LawRulesForm lawRulesForm = (LawRulesForm)form;
			LawsAndRules lawsAndRules = new LawsAndRules();
			String ID = request.getSession().getAttribute("uploadId").toString();
			
			LawsAndRules lRInfo = (LawsAndRules)request.getSession().getAttribute("lawsAndRules");
			/**
			 * 格式化当前系统日期
			 */
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = dateFm.format(new java.util.Date().getTime());
			java.util.Date timeDate = dateFm.parse(dateTime);
			java.sql.Timestamp dTime = new java.sql.Timestamp(timeDate.getTime());
			
			if(null != ID && !"".equals(ID)){
				lawsAndRules.setId(Integer.parseInt(ID));
				lawsAndRules.setName(lRInfo.getName());
//				lawsAndRules.setDomain(domainService.findById(lawRulesForm.getDmid()));
				lawsAndRules.setSn(lawRulesForm.getSn());
				lawsAndRules.setFile_type(lRInfo.getFile_type());
				lawsAndRules.setIssueUnit(lawRulesForm.getIssueUnit());
				lawsAndRules.setIssueDate(dTime);
				lawsAndRules.setUploadTime(new Timestamp(new Date().getTime()));
				lawsAndRules.setRemark(lawRulesForm.getRemark());
				lawsAndRulesService.update(lawsAndRules);
				
				/**
				 * 加入日志相关的信息
				 */
				
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("修改文件:"+lRInfo.getName());
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
			}
		}catch(Exception e){
			/**
			 * 加入日志相关的信息
			 */
			LawsAndRules lRInfo = (LawsAndRules)request.getSession().getAttribute("lawsAndRules");
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("修改文件:"+lRInfo.getName());
		    log.setControl("失败！");
		    systemLogService.saveSystemLog(log);
			e.printStackTrace();
		}
		return mapping.findForward("updateLawRulesSucc");
	}
	/**
	 * 通过 LawsAndRules 来删除法律法规的相关记录
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteLawRules(ActionMapping mapping,ActionForm form,
												HttpServletRequest request,HttpServletResponse response){
		/**
		 * 加载日志信息
		 */
		LogUtil.init();
		SystemLog log = new SystemLog();
		try{
			String ID = request.getParameter("id");
			request.setAttribute("currPage", request.getParameter("currPage"));
			if(null != ID && !"".equals(ID)){
				LawsAndRules lawsAndRules = lawsAndRulesService.findById(Integer.parseInt(ID));
				request.setAttribute("lawsAndRules", lawsAndRules);
				lawsAndRulesService.delete(lawsAndRules);
				/**
				 * 加入日志相关的信息
				 */
				
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("删除文件:"+lawsAndRules.getName());
			    log.setControl("成功！");
			    systemLogService.saveSystemLog(log);
			}
		}catch(Exception e){
			LawsAndRules lawsAndRules = (LawsAndRules)request.getAttribute("lawsAndRules");
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("删除文件:"+lawsAndRules.getName());
		    log.setControl("失败！");
		    systemLogService.saveSystemLog(log);
			e.printStackTrace();
		}
		return mapping.findForward("deleteSuccess");
	}
}
