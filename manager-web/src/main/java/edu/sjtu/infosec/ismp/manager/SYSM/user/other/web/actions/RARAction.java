package edu.sjtu.infosec.ismp.manager.SYSM.user.other.web.actions;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;

import common.Logger;

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysInfo;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysRole;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.RoleAssignRecords;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.RoleAssignRecordsService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.web.form.RARForm;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;

public class RARAction extends DispatchAction{

	Logger logger = Logger.getLogger(RARAction.class);
	
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	private SystemLogService systemlogservice;
	
	public void setRoleAssignRecordsService(
			RoleAssignRecordsService roleAssignRecordsService) {
		this.roleAssignRecordsService = roleAssignRecordsService;
	}
	private RoleAssignRecordsService roleAssignRecordsService;
	
	/**查询 应用系统权限分配记录
	 * RAR (RoleAssignRecords 简写)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward getRARInfo(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		 RARForm appSysInfoForm = (RARForm) form;
		 String asid = request.getParameter("asid");
		 if(HtmlFactory.isNotEmpty(asid)){
			 PMPage page = HtmlFactory.getPage(request);
			 StringBuffer sbf = new StringBuffer();
			 String user[][]={{"id","getId"},{"username","getUser"},{"ctime","getCreateTime"},{"operator","getOperator"}};
             String security[][]={{"roleid","getId"},{"rolename","getName"}};
             AppSysInfo asi = new AppSysInfo();
             asi.setId(Integer.valueOf(asid));
             appSysInfoForm.getRar().setAppSys(asi);
			List<RoleAssignRecords> list = roleAssignRecordsService.findConditionsInfo(appSysInfoForm.getRar(), page, appSysInfoForm.getCreateStartDate(), appSysInfoForm.getCreateEndDate());
			for(RoleAssignRecords rar : list){
				Object objs[][]={{rar,user},{rar.getRole(),security}};
				HtmlFactory.getDataArray(objs, sbf, "RAR");
			}
			HtmlFactory.getDataArray(page.getPageInfo(), sbf, "PAGE");
			HtmlFactory.flushData(response, sbf);
		 }
		 return null;
	 }
	/**
	 * 更新  应用系统权限分配记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward upRARInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			String asrid = request.getParameter("asrid");
			String rarid = request.getParameter("rarid");
			String name =  request.getParameter("name");
			String operator =  request.getParameter("operator");
		    if(HtmlFactory.isNotEmpty(rarid)){
		    	AppSysRole asr = new AppSysRole();
			    if(HtmlFactory.isNotEmpty(asrid)){
			    	asr.setId(Integer.valueOf(asrid));
			    }
			    if(HtmlFactory.isNotEmpty(name)){
                    name = HtmlFactory.conversionCoding(name,"GBK");
			    }
			    if(HtmlFactory.isNotEmpty(operator)){
			    	operator = HtmlFactory.conversionCoding(operator,"GBK");
			    }
		        String falg = "成功！";
				try {
					RoleAssignRecords rar =  roleAssignRecordsService.findById(Integer.valueOf(rarid));
					rar.setRole(asr);
					rar.setUser(name);
					rar.setOperator(operator);
					rar.setLastUpdateTime(new Timestamp(new Date().getTime()));
					roleAssignRecordsService.update(rar);
				} catch (Exception e) {
					falg = "失败！";
				} finally {
					try {
						systemlogservice.saveSystemLog(LogUtil.userName,
								LogUtil.roleName,
								SystemModelInfo.MOD_SYSM_user_other, "更新 应用系统权限分配记录",
								new Timestamp(System.currentTimeMillis()), falg);
					} catch (Exception e) {
						logger.debug("连接日志出错", e);
					}
				}
		    }
		return null;
		
	}
	/**
	 * 添加 应用系统权限分配记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward addRARInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			String asrid = request.getParameter("asrid");
			String asiid = request.getParameter("asid");
			String name =  request.getParameter("name");
			String operator =  request.getParameter("operator");
	    	 if(HtmlFactory.isNotEmpty(asiid)){
	    		 AppSysRole asr = new AppSysRole();
	    		 AppSysInfo asi = new AppSysInfo();
	    		 asi.setId(Integer.valueOf(asiid));
	    		 if(HtmlFactory.isNotEmpty(asrid)){
	    			 asr.setId(Integer.valueOf(asrid));
	    		 }
	    		 if(HtmlFactory.isNotEmpty(name)){
	    			 name = HtmlFactory.conversionCoding(name,"GBK");
	    		 }
	    		 if(HtmlFactory.isNotEmpty(operator)){
	    			 operator = HtmlFactory.conversionCoding(operator,"GBK");
	    		 }
 		        String falg = "成功！";
				try {
	    			 RoleAssignRecords rar =  new RoleAssignRecords();
	    			 rar.setRole(asr);
	    			 rar.setUser(name);
	    			 rar.setOperator(operator);
	    			 rar.setAppSys(asi);
	    			 rar.setCreateTime(new Timestamp(new Date().getTime()));
	    			 roleAssignRecordsService.add(rar);
				} catch (Exception e) {
					falg = "失败！";
				} finally {
					try {
						systemlogservice.saveSystemLog(LogUtil.userName,
								LogUtil.roleName,
								SystemModelInfo.MOD_SYSM_user_other, "添加应用系统权限分配记录",
								new Timestamp(System.currentTimeMillis()), falg);
					} catch (Exception e) {
						logger.debug("连接日志出错", e);
					}
				}  
	    	 }
		return null;
	}
	/**
	 * 删除 应用系统权限分配记录
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward delRARInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			String rarid = request.getParameter("rarid");
	    	 if(HtmlFactory.isNotEmpty(rarid)){
	 		        String falg = "成功！";
					try {
						 RoleAssignRecords rar =  roleAssignRecordsService.findById(Integer.valueOf(rarid));
						 roleAssignRecordsService.delete(rar);
					} catch (Exception e) {
						falg = "失败！";
					} finally {
						try {
							systemlogservice.saveSystemLog(LogUtil.userName,
									LogUtil.roleName,
									SystemModelInfo.MOD_SYSM_user_other, "删除应用系统权限分配记录",
									new Timestamp(System.currentTimeMillis()), falg);
						} catch (Exception e) {
							logger.debug("连接日志出错", e);
						}
					}
	    	 }
		return null;
	}
}
