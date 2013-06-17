package edu.sjtu.infosec.ismp.manager.AIM.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AIM.comm.AlertQueryVO;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertFusionRuleBO;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertRuleBO;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertFusionRuleServices;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertRuleService;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertService;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertTypeService;
import edu.sjtu.infosec.ismp.manager.AIM.web.dwr.AlertDwrServices;
import edu.sjtu.infosec.ismp.manager.AIM.web.form.AlertForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class AlertAction extends DispatchAction {

	// 注入告警信息 service层接口
	private AlertService alertService;
	// 注入告警类型service接口
	private AlertTypeService alertTypeService;
    
	private AlertDwrServices alertDwrService;
	
	private AlertFusionRuleServices alertFusionRuleServices;
	
	private UserService userService;
	
//	private ManagerService managerService;
	private DomainService domainService;
	private AlertRuleService alertRuleService;
	private SystemLogService systemlogService;

	
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}
	
	SystemLog log;
	String rolenames ;
	String username;
	OperatorDetails user;
	void init(){
		user = SecurityUserHolder.getCurrentUser();
		username = user.getUsername();
		rolenames="";
		for(Role role : user.getRoleList()){
			rolenames = rolenames+role.getName();
		}
		log = new SystemLog();
	}
	
	/**
	 * 查询所有的告警类型信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getListAlertType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		try{
			init();
			List<AlertTypeBO> alertTypelist = alertTypeService.getLisByAlertTypeService();
			request.getSession().setAttribute("altypeList", alertTypelist);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询所有的告警类型信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getListPageAlertAction(mapping, form, request, response);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询所有的告警类型信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	/**
	 * 多条件查询告警信息 并且分页显示
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getListPageAlertAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AlertForm alertForm = (AlertForm) form;
		HttpSession session = request.getSession();
		Page page = new Page();
		request.setAttribute("alertinfoQuery", alertForm.getAlertquer());
		try{
			init();
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("多条件查询告警信息 并且分页显示");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			 //根据类型查找子类型	
			List<AlertTypeBO> subTypeList=new ArrayList();
			if(alertForm.getAlertquer().getAlertType()!=null&&alertForm.getAlertquer().getAlertType().trim().length()>0){
				subTypeList=alertDwrService.getSubTypeByNameService(alertForm.getAlertquer().getAlertType());
			}		
			request.setAttribute("subTypeList", subTypeList);
			
			// 获得当前页
			String curpage = request.getParameter("curpage") != null
					&& (!request.getParameter("curpage").equals("")) ? request
					.getParameter("curpage") : "1";
			if (request.getParameter("pageSize") != null
					&& (!request.getParameter("pageSize").equals(""))) {
				int pagesize = Integer.parseInt(request.getParameter("pageSize"));
				request.setAttribute("pageSize", request.getParameter("pageSize"));
				page.setEveryPage(pagesize);
			}else{
				page.setEveryPage(10);
			}
			//如果第一次进来就初始化条件为NULL
			
			if(request.getParameter("first")!=null){
				alertForm.setAlertquer(new AlertQueryVO());
				request.setAttribute("subTypeList", null);
				request.setAttribute("alertinfoQuery",null);
			}
			// 设置当前页跟开始位置
			page.setCurrentPage(Integer.parseInt(curpage));
			page.setBeginIndex((page.getCurrentPage() - 1)*page.getEveryPage());
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			if(user.getUsername().equals("admin")){
			PageResult result = alertService.getListPageAlertService(page,
					alertForm.getAlertquer());
			request.setAttribute("page", result.getPage());
			request.setAttribute("list", result.getPageList());
			}
			else{
				List<Domain> listDomain = user.getDomainList();
				PageResult result = alertService.getListPageAlertService(page,alertForm.getAlertquer(),listDomain);
				if(result!=null){
					request.setAttribute("page", result.getPage());
					request.setAttribute("list", result.getPageList());
				}
			}
			//告警浏览
			if(request.getParameter("home")!=null && request.getParameter("home").trim().equals("1")){
				AlertFusionRuleBO alertFusionRuleBO=alertFusionRuleServices.getAlertFusionRuleServices();
				request.setAttribute("alertFusionRuleBO", alertFusionRuleBO);
				session.setAttribute("topcss", "alertIndex");
				return mapping.findForward("alertHome");
			}
			//弹出告警监控 小窗口
			if(request.getParameter("MinWindow")!=null){
				if(request.getSession().getAttribute("altypeList")==null){
				   this.getListAlertType(mapping, alertForm, request, response);
				}
				AlertFusionRuleBO alertFusionRuleBO=alertFusionRuleServices.getAlertFusionRuleServices();
				request.setAttribute("alertFusionRuleBO", alertFusionRuleBO);
				request.setAttribute("monitorTime", new Timestamp(System.currentTimeMillis()));
				return mapping.findForward("AlertMinWindow");
			}
			session.setAttribute("topcss", "alertIndex");
			return mapping.findForward("alertIndex");
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("多条件查询告警信息 并且分页显示");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	/**
	 * 根据ID 查询单个的告警信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getByIdAlert(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String alertId=request.getParameter("alertId");		
		try{
			init();
			if(alertId!=null&&(!alertId.equals(""))){
				AlertInfoBO alertInfobo=alertService.getByIdAlertService(Integer.parseInt(alertId));
				if(alertInfobo!=null){
					request.setAttribute("alertInfobo", alertInfobo);
					String fusion=alertInfobo.getFusioin();
					int fusionCount=0;
					List fustionTimeList=new ArrayList();
					if(fusion!=null&&fusion.trim().length()>0){
						String strs[]=fusion.split(",");
						if(strs!=null&&strs.length>0){
							fusionCount=strs.length;
							for (String string : strs) {
								fustionTimeList.add(string);
							}
						}
					}
					request.setAttribute("fusionCount", fusionCount);
					request.setAttribute("fustionTimeAll", fustionTimeList);
					if(alertInfobo.getStatus()!=null&&alertInfobo.getStatus()==1){
						//如果状态是未读  就更新状态为只读
						alertInfobo.setStatus(0);
						alertService.updateAlertService(alertInfobo);
					}
					if(alertInfobo.getIfnew()!=null&&alertInfobo.getIfnew()==1){
					    alertInfobo.setIfnew(0);
					    alertService.updateAlertService(alertInfobo);
					}
					if(alertInfobo!=null && alertInfobo.getDomain_id()!=null){
						Integer domain_id = alertInfobo.getDomain_id();
						Domain domain = domainService.findById(domain_id);
						request.setAttribute("department", domain);
					}
					//触发规则列表
					List alertRuleList=new ArrayList();
					if(alertInfobo.getRule()!=null && alertInfobo.getRule().trim().length()!=0){
						String strs[]= alertInfobo.getRule().split(",");
						for(int i=0;i<strs.length;i++){
							AlertRuleBO rule = alertRuleService.getByIdAlertRuleService(Integer.parseInt(strs[i]));
								alertRuleList.add(rule);
						}
					}
					request.setAttribute("alertruleList", alertRuleList);
				}
			}
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("根据ID 查询单个的告警信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("alertPart");
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("根据ID 查询单个的告警信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	
	/**
	 *  Frame 跳转专用
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward alertRuleFwd(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String alertId=request.getParameter("alertId");		
		
		
		
		try{
			init();
			if(alertId!=null&&(!alertId.equals(""))){
				AlertInfoBO alertInfobo=alertService.getByIdAlertService(Integer.parseInt(alertId));
				if(alertInfobo!=null){
					request.setAttribute("alertInfobo", alertInfobo);
					String fusion=alertInfobo.getFusioin();
					int fusionCount=0;
					List fustionTimeList=new ArrayList();
					if(fusion!=null&&fusion.trim().length()>0){
						String strs[]=fusion.split(",");
						if(strs!=null&&strs.length>0){
							fusionCount=strs.length;
							for (String string : strs) {
								fustionTimeList.add(string);
							}
						}
					}
					request.setAttribute("fusionCount", fusionCount);
					request.setAttribute("fustionTimeAll", fustionTimeList);
					if(alertInfobo.getStatus()!=null&&alertInfobo.getStatus()==1){
						//如果状态是未读  就更新状态为只读
						alertInfobo.setStatus(0);
						alertService.updateAlertService(alertInfobo);
					}
					if(alertInfobo.getIfnew()!=null&&alertInfobo.getIfnew()==1){
					    alertInfobo.setIfnew(0);
					    alertService.updateAlertService(alertInfobo);
					}
					if(alertInfobo!=null && alertInfobo.getDomain_id()!=null){
						Integer domain_id = alertInfobo.getDomain_id();
						Domain domain = domainService.findById(domain_id);
						request.setAttribute("department", domain);
					}
					//触发规则列表
					List alertRuleList=new ArrayList();
					if(alertInfobo.getRule()!=null && alertInfobo.getRule().trim().length()!=0){
						String strs[]= alertInfobo.getRule().split(",");
						for(int i=0;i<strs.length;i++){
							AlertRuleBO rule = alertRuleService.getByIdAlertRuleService(Integer.parseInt(strs[i]));
								alertRuleList.add(rule);
						}
					}
					request.setAttribute("alertruleList", alertRuleList);
				}
			}
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询告警类型信息详情");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("alertLinkage");
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询告警类型信息详情");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	
	/**
	 *  Frame 修改归并窗这个不涉及到权限 所以方法名称特殊点
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward alertSorUfusion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		
		
		try{
			init();
			AlertFusionRuleBO entityAlertFusionRuleBO=new AlertFusionRuleBO();
			String fusionTime=request.getParameter("fusionTime");
			if(fusionTime!=null){
			    entityAlertFusionRuleBO.setFusionTime(Integer.parseInt(fusionTime));	
			}			
			alertFusionRuleServices.saveOrUpdateAlertFusionRuleServices(entityAlertFusionRuleBO);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("修改归并时间");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getListPageAlertAction(mapping, form, request, response);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("修改归并时间");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	
	/**========================Spring IOC================================**/
	public void setAlertDwrService(AlertDwrServices alertDwrService) {
		this.alertDwrService = alertDwrService;
	}

	public void setAlertTypeService(AlertTypeService alertTypeService) {
		this.alertTypeService = alertTypeService;		
	}
	public void setAlertService(AlertService alertService) {
		this.alertService = alertService;
	}
	public void setAlertFusionRuleServices(
			AlertFusionRuleServices alertFusionRuleServices) {
		this.alertFusionRuleServices = alertFusionRuleServices;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/*public ManagerService getManagerService() {
		return managerService;
	}
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}*/
	public DomainService getDomainService() {
		return domainService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	public void setAlertRuleService(AlertRuleService alertRuleService) {
		this.alertRuleService = alertRuleService;
	}
	
	
}
