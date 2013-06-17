package edu.sjtu.infosec.ismp.manager.GOSP.web.actions;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.GOSP.comm.StaticFinal;
import edu.sjtu.infosec.ismp.manager.GOSP.model.LawsAndRules;
import edu.sjtu.infosec.ismp.manager.GOSP.service.LawsAndRulesService;
import edu.sjtu.infosec.ismp.manager.GOSP.web.form.LawRulesForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
/**
 * 上传法律法规的相关信息
 * 
 * @author cxk
 * 
 * Date:2010-11-17
 */
@SuppressWarnings("unused")
public class UploadLawAndRulesAction extends Action{ 
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
	 * 上传法律法规的相关信息（LawsAndRules）
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward execute(ActionMapping mapping,ActionForm form,
										HttpServletRequest request,HttpServletResponse response)throws Exception{
		/**
		 * 加载日志信息
		 */
		LogUtil.init();
		SystemLog log = new SystemLog();
		String isAdd = (request.getParameter("isAdd")==null)?"0":request.getParameter("isAdd");
		String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
		request.setAttribute("currPage", request.getParameter("currPage"));
		request.setAttribute("isAll", isAll);
		if(isAdd.endsWith("1")){
			LawRulesForm lawRulesForm = (LawRulesForm)form;
			LawsAndRules lawsAndRules = new LawsAndRules();
			/**
			 * 上传文件的相关信息
			 */
			FormFile file = lawRulesForm.getFile();
			if(file != null){
				System.out.println("上传文件的名字："+file.getFileName());
				System.out.println("上传文件的类型："+file.getContentType());
			}
			String fileName=file.getFileName();
			request.getSession().setAttribute("fileName", fileName);
//			String path= request.getContextPath();
//			String path = request.getSession().getServletContext().getRealPath("/");	
//			String path = "D:/upload";
			String path = StaticFinal.PATH ;
			request.getSession().setAttribute("path", path);
			System.out.println("上传文件的路径："+path+"/"+file.getFileName());
//			String absolutePath = path+"/"+file.getFileName();
//			request.getSession().setAttribute("absolutePath", absolutePath);
			InputStream in = file.getInputStream();
			OutputStream out = new FileOutputStream(path+"/"+file.getFileName());
			int read = 0;
			byte[] buffer = new byte[1024];
			while((read = in.read(buffer,0,1024))!= -1){
				out.write(buffer, 0, read);
			}
			in.close();
			out.close();
			/**
			 * 格式化当前系统日期
			 */
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = dateFm.format(new java.util.Date().getTime());
			java.util.Date timeDate = dateFm.parse(dateTime);
			java.sql.Timestamp dTime = new java.sql.Timestamp(timeDate.getTime());
			/**
			 * 从Form表单中得到法律法规相关的信息
			 * window.opener.location.reload();
			 * window.opener.location.href=window.opener.location.href;
			 */
			try{
				lawsAndRules.setSn(lawRulesForm.getSn());
				// lawsAndRules.setName(lawRulesForm.getName());
				lawsAndRules.setName(file.getFileName());
				lawsAndRules.setFile_type(file.getContentType());
				lawsAndRules.setIssueUnit(lawRulesForm.getIssueUnit());
//				lawsAndRules.setDomain(domainService.findById(lawRulesForm.getDmid()));
				lawsAndRules.setIssueDate(dTime);
				lawsAndRules.setUploadTime(new Timestamp(new Date().getTime()));
				lawsAndRules.setRemark(lawRulesForm.getRemark());
				lawsAndRulesService.add(lawsAndRules);
				/**
				 * 加入日志相关的信息
				 */
				
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("上传文件:"+file.getFileName());
			    log.setControl("成功！");
			    systemLogService.saveSystemLog(log);
				PrintWriter pout = response.getWriter();
				pout = response.getWriter();
		        response.setContentType("text/html; charset=UTF-8");
		        pout.println("<script language=\"javascript\">");
		        pout.println("window.opener.location.href=window.opener.location.href;");
		        pout.println("window.opener.location.reload();");
		        pout.println("window.close();");
		        pout.println("</script>");
		        pout.close();
		        return null; 
			}catch(Exception e){
				    log.setUsername(LogUtil.userName);
				    log.setRoleName(LogUtil.roleName);
				    log.setTime(new Timestamp(new Date().getTime()));
				    log.setModuleName(SystemModelInfo.MOD_GOSP);
				    log.setOperationDesc("上传文件:"+file.getFileName());
				    log.setControl("失败！");
				    systemLogService.saveSystemLog(log);
				    e.printStackTrace();
			}
			
			return mapping.findForward("uploadSuccess");
		}else{
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			request.setAttribute("udl", userDomainList);
			return mapping.findForward("lawRulesOpSucc");
		}

	}
	
}
