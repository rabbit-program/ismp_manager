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
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.service.AppSysInfoService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.web.form.AppSysInfoForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class AppSysInfoAction extends DispatchAction{

	Logger logger  = Logger.getLogger(AppSysInfoAction.class);
	private AppSysInfoService appSysInfoService;
	private DomainService domainService;
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	private SystemLogService systemlogservice;

	public void setAppSysInfoService(AppSysInfoService appSysInfoService) {
		this.appSysInfoService = appSysInfoService;
	}
	/**
	 * 查询应用系统信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	 public ActionForward getAppSysInfo(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		 AppSysInfoForm appSysInfoForm = (AppSysInfoForm) form;
		 PMPage page = HtmlFactory.getPage(request);
		 OperatorDetails user= SecurityUserHolder.getCurrentUser();  
		 if(!(user == null)){
			 List<AppSysInfo> list = appSysInfoService.findConditionsInfo(appSysInfoForm.getAsi(), user.getDomainList(), page, appSysInfoForm.getCreateStartDate(), appSysInfoForm.getCreateEndDate());
			 request.setAttribute("list", list);
			 request.setAttribute("page", page.getPageInfo());
			 return mapping.findForward("index");
		 }
		 return null;
	 }
	 /**
	  * 删除应用系统信息
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws IOException
	  */
	 public ActionForward delAppSysInfo(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		    String asid = request.getParameter("asid");
		    if(HtmlFactory.isNotEmpty(asid)){
			        String falg = "成功！";
					try {
						AppSysInfo appSysInfo = appSysInfoService.findById(Integer
								.valueOf(asid));
						appSysInfoService.delete(appSysInfo);
					} catch (Exception e) {
						falg = "失败！";
					} finally {
						try {
							systemlogservice.saveSystemLog(LogUtil.userName,
									LogUtil.roleName,
									SystemModelInfo.MOD_SYSM_user_other, "删除应用系统信息",
									new Timestamp(System.currentTimeMillis()), falg);
						} catch (Exception e) {
							logger.debug("连接日志出错", e);
						}
					}
		    }

		    return getAppSysInfo(mapping,new AppSysInfoForm(),request,response);
	 }
	 /**查询单个应用系统信息
	  * 
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws IOException
	  */
	 public ActionForward getAppSysInfoId(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		    String asid = request.getParameter("asid");
		    if(HtmlFactory.isNotEmpty(asid)){
		    	try {
		    		StringBuffer sbf = new StringBuffer();
					AppSysInfo appSysInfo = appSysInfoService.findById(Integer.valueOf(asid)); 
					String[][] str = {{"id","getId"},{"name","getName"},{"desc","getDesc"}};
					Object[][] objs ={{appSysInfo,str}};
					HtmlFactory.getDataArray(objs, sbf,"asi");
					HtmlFactory.flushData(response, sbf);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		 return null;
	 }
	 
	 /**
	  * 更新应用系统信息
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws IOException
	  */
	 public ActionForward upAppSysInfo(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		   AppSysInfoForm appSysInfoForm = (AppSysInfoForm) form;
		    String asid = request.getParameter("asid");
		    if(HtmlFactory.isNotEmpty(asid)){
			        String falg = "成功！";
					try {
						AppSysInfo appSysInfo = appSysInfoService.findById(Integer.valueOf(asid)); 
						appSysInfo.setName(HtmlFactory.conversionCoding(appSysInfoForm.getAsi().getName(),"GBK"));
						appSysInfo.setDesc(HtmlFactory.conversionCoding(appSysInfoForm.getAsi().getDesc(),"GBK"));
						appSysInfoForm.setAsi(appSysInfo);
					} catch (Exception e) {
						falg = "失败！";
					} finally {
						try {
							systemlogservice.saveSystemLog(LogUtil.userName,
									LogUtil.roleName,
									SystemModelInfo.MOD_SYSM_user_other, "更新应用系统信息",
									new Timestamp(System.currentTimeMillis()), falg);
						} catch (Exception e) {
							logger.debug("连接日志出错", e);
						}
					}
				  return addAppSysInfo(mapping,appSysInfoForm,request,response);
		    }
		 return null;
		 
	 }
	 /**
	  * 添加应用系统信息
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws IOException
	  */
	 public ActionForward addAppSysInfo(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		 AppSysInfoForm appSysInfoForm = (AppSysInfoForm) form;
		 String dId = request.getParameter("domainId");
			 if(HtmlFactory.isNotEmpty(dId)){
			        String falg = "成功！";
					try {
						 Domain domain= domainService.findById(Integer.valueOf(dId));
						 appSysInfoForm.getAsi().setDomain(domain);
						 appSysInfoForm.getAsi().setCreateTime(new Timestamp(new Date().getTime()));
						 appSysInfoService.update(appSysInfoForm.getAsi());
						 form.reset(mapping, request);
					} catch (Exception e) {
						falg = "失败！";
					} finally {
						try {
							systemlogservice.saveSystemLog(LogUtil.userName,
									LogUtil.roleName,
									SystemModelInfo.MOD_SYSM_user_other, "添加应用系统信息",
									new Timestamp(System.currentTimeMillis()), falg);
						} catch (Exception e) {
							logger.debug("连接日志出错", e);
						}
					}
				 
			 }
		 return getAppSysInfo(mapping,new AppSysInfoForm(),request,response);
	 }
	 
	
}
