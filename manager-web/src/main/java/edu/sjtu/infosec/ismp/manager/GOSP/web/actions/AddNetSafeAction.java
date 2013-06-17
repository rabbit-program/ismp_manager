package edu.sjtu.infosec.ismp.manager.GOSP.web.actions;

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
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.GOSP.model.SafeStateRecords;
import edu.sjtu.infosec.ismp.manager.GOSP.service.SafeStateRecordsService;
import edu.sjtu.infosec.ismp.manager.GOSP.web.form.SafeStateForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
@SuppressWarnings("unused")
/**
 * 等保状态信息的录入
 * 
 * @author cxk
 * 
 * Date:2010-11-17
 */
public class AddNetSafeAction extends Action{
	/**
	 * service 接口的注入
	 */
	private SafeStateRecordsService safeStateRecordsService;
	private DomainService domainService;
	private SystemLogService systemLogService;
	
	public void setSafeStateRecordsService(
			SafeStateRecordsService safeStateRecordsService) {
		this.safeStateRecordsService = safeStateRecordsService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}
	public ActionForward execute(ActionMapping mapping,ActionForm form,
										HttpServletRequest request,HttpServletResponse response)throws Exception{
		/**
		 * 加载日志信息
		 */
		LogUtil.init();
		SystemLog log = new SystemLog();
		String isAdd = (request.getParameter("isAdd")==null)?"0":request.getParameter("isAdd");
		String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
		request.setAttribute("isAll", isAll);
		if(isAdd.endsWith("1")){
			SafeStateForm safeStateForm = (SafeStateForm)form;
			SafeStateRecords netSafeInfo = new SafeStateRecords();
			/**
			 * 格式化当前系统日期
			 */
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = dateFm.format(new java.util.Date().getTime());
			java.util.Date timeDate = dateFm.parse(dateTime);
			java.sql.Timestamp dTime = new java.sql.Timestamp(timeDate.getTime());
			/**
			 * 从Form表单中得到网络等级保护状况相关的信息
			 */
			try{
				netSafeInfo.setName(safeStateForm.getName());
				netSafeInfo.setDesc(safeStateForm.getDesc());
				netSafeInfo.setLevel(safeStateForm.getLevel());
				netSafeInfo.setState(safeStateForm.getState());
//				netSafeInfo.setDomain(domainService.findById(safeStateForm.getDmid()));
				netSafeInfo.setCreateTime(dTime);
				netSafeInfo.setLastUpdateTime(new Timestamp(new Date().getTime()));
				netSafeInfo.setRemark(safeStateForm.getRemark());
				safeStateRecordsService.add(netSafeInfo);
				/**
				 * 加入日志相关的信息
				 */
				
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("网络等级保护状况信息的录入");
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
			}catch(Exception e){
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("网络等级保护状况信息的录入");
			    log.setControl("失败！");
			    systemLogService.saveSystemLog(log);
				e.printStackTrace();
			}
			return mapping.findForward("addNetSafeSucc");
		}else{
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			request.setAttribute("udl", userDomainList);
			return mapping.findForward("netSafeOpSucc");
		}
	}
}
