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
import edu.sjtu.infosec.ismp.manager.GOSP.model.SafeStateRecords;
import edu.sjtu.infosec.ismp.manager.GOSP.service.SafeStateRecordsService;
import edu.sjtu.infosec.ismp.manager.GOSP.web.form.SafeStateForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
/**
 * 等保状态信息的更新
 * 
 * @author cxk
 * 
 * Date:2010-11-17
 */
@SuppressWarnings("unused")
public class NetSafeUpdateAndDelAction extends DispatchAction{
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
	
	/**
	 * 通过网络等保状况ID得到网络等保状况对象（SafeStateRecords）
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
			String netSafeId = request.getParameter("id");
			request.getSession().setAttribute("netSafeId", netSafeId);
			if(null != netSafeId && !"".equals(netSafeId)){
				SafeStateRecords netSafeInfo = safeStateRecordsService.findById(Integer.parseInt(netSafeId));
				request.setAttribute("netSafeInfo", netSafeInfo);
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
		return mapping.findForward("updateInfo");
	}
	/**
	 * 通过 SafeStateRecords 来更新网络等保状况相关的信息
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
			SafeStateForm safeStateForm = (SafeStateForm)form;
			SafeStateRecords safeStateRecords = new SafeStateRecords();
			String ID = request.getSession().getAttribute("netSafeId").toString();
			/**
			 * 格式化当前系统日期
			 */
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateTime = dateFm.format(new java.util.Date().getTime());
			java.util.Date timeDate = dateFm.parse(dateTime);
			java.sql.Timestamp dTime = new java.sql.Timestamp(timeDate.getTime());
			
			if(null != ID && !"".equals(ID)){
				safeStateRecords.setId(Integer.parseInt(ID));
				safeStateRecords.setName(safeStateForm.getName());
				safeStateRecords.setDesc(safeStateForm.getDesc());
				safeStateRecords.setLevel(safeStateForm.getLevel());
				safeStateRecords.setState(safeStateForm.getState());
				safeStateRecords.setCreateTime(dTime);
				safeStateRecords.setLastUpdateTime(new Timestamp(new Date().getTime()));
//				safeStateRecords.setDomain(domainService.findById(safeStateForm.getDmid()));
				safeStateRecords.setRemark(safeStateForm.getRemark());
				safeStateRecordsService.update(safeStateRecords);
				/**
				 * 加入日志相关的信息
				 */
				
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("网络等级保护状况信息的更新");
			    log.setControl("成功！");
			    systemLogService.saveSystemLog(log);
				PrintWriter out = response.getWriter();
		        out = response.getWriter();
		        response.setContentType("text/html; charset=UTF-8");
		        out.println("<script language=\"javascript\">");
		        out.println("window.opener.location.reload();");
		        out.println("window.close();");
		        out.println("</script>");
		        out.close();
		        return null;
			}
		}catch(Exception e){
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("网络等级保护状况信息的更新");
		    log.setControl("失败！");
		    systemLogService.saveSystemLog(log);
			e.printStackTrace();
		}
		return mapping.findForward("updateSuccess");
		
	}
	/**
	 * 通过 SafeStateRecords 来删除网络等保状况相关的信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward deleteNetSafeInfo(ActionMapping mapping, ActionForm form,
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
				SafeStateRecords safeStateRecords = safeStateRecordsService.findById(Integer.parseInt(ID));
				safeStateRecordsService.delete(safeStateRecords);
				/**
				 * 加入日志相关的信息
				 */
				
				log.setUsername(LogUtil.userName);
			    log.setRoleName(LogUtil.roleName);
			    log.setTime(new Timestamp(new Date().getTime()));
			    log.setModuleName(SystemModelInfo.MOD_GOSP);
			    log.setOperationDesc("删除网络等级保护状况相关的信息");
			    log.setControl("成功！");
			    systemLogService.saveSystemLog(log);
			}
		}catch(Exception e){
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("删除网络等级保护状况相关的信息");
		    log.setControl("失败！");
		    systemLogService.saveSystemLog(log);
			e.printStackTrace();
		}
		return mapping.findForward("delSuccess");
	}
	
}
