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
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.AppSysRoleService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.web.form.AppSysRoleForm;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;

public class AppSysRoleAction extends DispatchAction{

	Logger logger = Logger.getLogger(AppSysRoleAction.class);
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	private SystemLogService systemlogservice;
	
	private AppSysRoleService  appSysRoleService;
	 public void setAppSysRoleService(AppSysRoleService appSysRoleService) {
		this.appSysRoleService = appSysRoleService;
	}
	 /**
	  * 查询所有应用系统权限
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws IOException
	  */
	 
	public ActionForward getAppSysRoleInfo(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		 AppSysRoleForm appSysRoleForm = (AppSysRoleForm) form;
		 String asId = request.getParameter("asid");
		 if(HtmlFactory.isNotEmpty(asId)){
			 PMPage page = HtmlFactory.getPage(request);
			 AppSysInfo asi = new AppSysInfo();
			 asi.setId(Integer.valueOf(asId));
			 appSysRoleForm.getAsr().setAppSys(asi);
			 StringBuffer sbf = new StringBuffer();
			 List<AppSysRole> list = appSysRoleService.findConditionsInfo(appSysRoleForm.getAsr(), page, appSysRoleForm.getCreateStartDate(), appSysRoleForm.getCreateEndDate());
			 String str[][] ={{"id","getId"},{"name","getName"},{"desc","getDesc"},{"remark","getRemark"}};
			 for(AppSysRole asr : list){
				 Object objs[][] ={{asr,str}};
				 HtmlFactory.getDataArray(objs, sbf,"ASR");
			 }
			 HtmlFactory.getDataArray(page.getPageInfo(), sbf, "PAGE");
			 HtmlFactory.flushData(response, sbf);
		 }
		return null;
	 }
	/**
	 * 添加应用系统权限
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward addAppSysRoleInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		 AppSysRoleForm appSysRoleForm = (AppSysRoleForm) form;
		 String asId = request.getParameter("asid");
		 if(HtmlFactory.isNotEmpty(asId)){
			 String name=request.getParameter("asrname");
			 if(HtmlFactory.isNotEmpty(name)){
				 appSysRoleForm.getAsr().setName(HtmlFactory.conversionCoding(name,"GBK"));
			 }
			 String desc=request.getParameter("asrdesc");
			 if(HtmlFactory.isNotEmpty(desc)){
				 appSysRoleForm.getAsr().setDesc(HtmlFactory.conversionCoding(desc,"GBK"));
			 }
			 String remark=request.getParameter("asrremark");
			 if(HtmlFactory.isNotEmpty(remark)){
				 appSysRoleForm.getAsr().setRemark(HtmlFactory.conversionCoding(remark,"GBK"));
			 }
	        String falg = "成功！";
			try {
				 AppSysInfo asi = new AppSysInfo();
				 asi.setId(Integer.valueOf(asId));
				 appSysRoleForm.getAsr().setAppSys(asi);
				 appSysRoleForm.getAsr().setCreateTime(new Timestamp(new Date().getTime()));
				 appSysRoleService.add(appSysRoleForm.getAsr());
			} catch (Exception e) {
				falg = "失败！";
			} finally {
				try {
					systemlogservice.saveSystemLog(LogUtil.userName,
							LogUtil.roleName,
							SystemModelInfo.MOD_SYSM_user_other, "添加应用系统权限",
							new Timestamp(System.currentTimeMillis()), falg);
				} catch (Exception e) {
					logger.debug("连接日志出错", e);
				}
			}
		 }
		return null;
	}
	/**
	 * 删除应用系统权限
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward delasri(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		 String asrId = request.getParameter("asrid");
		 if(HtmlFactory.isNotEmpty(asrId)){
		        String falg = "成功！";
				try {
					AppSysRole appSysRole =appSysRoleService.findById(Integer.valueOf(asrId));
					appSysRoleService.delete(appSysRole);
				} catch (Exception e) {
					falg = "失败！";
				} finally {
					try {
						systemlogservice.saveSystemLog(LogUtil.userName,
								LogUtil.roleName,
								SystemModelInfo.MOD_SYSM_user_other, "删除应用系统权限",
								new Timestamp(System.currentTimeMillis()), falg);
					} catch (Exception e) {
						logger.debug("连接日志出错", e);
					}
				}
		 }
		return null;
	}
	/**
	 * 查询应用系统权限
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward findasri(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		 String asrId = request.getParameter("asrid");
		 if(HtmlFactory.isNotEmpty(asrId)){
			 try {
				AppSysRole appSysRole =appSysRoleService.findById(Integer.valueOf(asrId));

			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		return null;
	}
	/**
	 * 更新应用系统权限
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward upasri(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    String asrId = request.getParameter("asrid");
			 if(HtmlFactory.isNotEmpty(asrId)){
				    String falg = "成功！";
						try {
							 AppSysRole appSysRole =appSysRoleService.findById(Integer.valueOf(asrId));
							 String name=request.getParameter("asrname");
							 if(HtmlFactory.isNotEmpty(name)){
								 appSysRole.setName(HtmlFactory.conversionCoding(name,"GBK"));
							 }
							 String desc=request.getParameter("asrdesc");
							 if(HtmlFactory.isNotEmpty(desc)){
								 appSysRole.setDesc(HtmlFactory.conversionCoding(desc,"GBK"));
							 }
							 String remark=request.getParameter("asrremark");
							 if(HtmlFactory.isNotEmpty(remark)){
								 appSysRole.setRemark(HtmlFactory.conversionCoding(remark,"GBK"));
							 }
							 appSysRole.setLastUpdateTime(new Timestamp(new Date().getTime()));
							 appSysRoleService.update(appSysRole);
						} catch (Exception e) {
							falg = "失败！";
						} finally {
							try {
								systemlogservice.saveSystemLog(LogUtil.userName,
										LogUtil.roleName,
										SystemModelInfo.MOD_SYSM_user_other, "更新应用系统权限",
										new Timestamp(System.currentTimeMillis()), falg);
							} catch (Exception e) {
								logger.debug("连接日志出错", e);
							}
						}
						 
			 }
		return null;
	}
	/**
	 * 查询单个应用系统权限
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward findAll(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		 String asId = request.getParameter("asid");
		 if(HtmlFactory.isNotEmpty(asId)){
			try {
				List<AppSysRole>  list = appSysRoleService.findASIById(Integer.valueOf(asId));
				StringBuffer sbf = new StringBuffer();
				String[][] role ={{"id","getId"},{"name","getName"}};
				for(AppSysRole asr : list){
					Object[][] objs={{asr,role}};
					HtmlFactory.getDataArray(objs, sbf,"ROLEALL");
				}
				HtmlFactory.flushData(response, sbf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		return null;
	}
}
