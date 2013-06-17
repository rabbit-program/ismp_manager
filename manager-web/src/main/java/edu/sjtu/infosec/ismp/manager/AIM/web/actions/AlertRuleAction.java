package edu.sjtu.infosec.ismp.manager.AIM.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertRuleBO;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertRuleService;
import edu.sjtu.infosec.ismp.manager.AIM.web.dwr.AlertDwrServices;
import edu.sjtu.infosec.ismp.manager.AIM.web.form.AlertRuleForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;


public class AlertRuleAction extends DispatchAction {

	// 注入告警规则service层接口
	private AlertRuleService alertRuleService;
    //查询类型所对应的子类型
	private AlertDwrServices alertDwrService;

	private UserService userService;
	
	private DomainService domainService;

	private SystemLogService systemlogService;

	
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}
	
	SystemLog log;
	String rolenames;
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
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setAlertDwrService(AlertDwrServices alertDwrService) {
		this.alertDwrService = alertDwrService;
	}
	public void setAlertRuleService(AlertRuleService alertRuleService) {
		this.alertRuleService = alertRuleService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	// 查询所有的告警规则信息并且分页显示
	public ActionForward getPageAlertRule(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AlertRuleBO alertRuleBo = new AlertRuleBO();
		try{
			init();
			Integer disuse = null;
			Page page = new Page();
			// 获得当前页
			String curpage = request.getParameter("curpage") != null
					&& (!request.getParameter("curpage").equals("")) ? request
					.getParameter("curpage") : "1";
					if(request.getAttribute("curpage")!=null && !request.getAttribute("curpage").equals("")){
						curpage=(String)request.getAttribute("curpage");
					}
			// 设置当前页跟开始位置
			page.setCurrentPage(Integer.parseInt(curpage));
			page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			if(user.getUsername().equals("admin")){
				PageResult result = alertRuleService.getPageAlertRuleService(page,
						alertRuleBo);
				request.setAttribute("page", result.getPage());
				request.setAttribute("list", result.getPageList());
			}else{
				List<Domain> list = user.getDomainList();
				PageResult result = alertRuleService.getPageAlertRuleService(page,alertRuleBo,list);
					request.setAttribute("page", result.getPage());
					request.setAttribute("list", result.getPageList());
			}
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询所有的告警规则信息并且分页显示");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("alertRuleIndex");
			
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询所有的告警规则信息并且分页显示");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	// 查询所有的告警规则信息并且分页显示
	public ActionForward getPageAlertRuleDisuse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AlertRuleBO alertRuleBo = new AlertRuleBO();
		
		
		try{
			init();
			Integer disuse = null;
			if (request.getParameter("disuse") != null) {
				disuse = Integer.parseInt(request.getParameter("disuse"));
			}
			alertRuleBo.setDeprecated(disuse);
			Page page = new Page();
			// 获得当前页
			String curpage = request.getParameter("curpage") != null
					&& (!request.getParameter("curpage").equals("")) ? request
					.getParameter("curpage") : "1";
			// 设置当前页跟开始位置
			page.setCurrentPage(Integer.parseInt(curpage));
			page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
			PageResult result = alertRuleService.getPageAlertRuleService(page,
					alertRuleBo);
			request.setAttribute("page", result.getPage());
			request.setAttribute("list", result.getPageList());
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询所有的告警规则信息并且分页显示");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("alertRuleDisuse");
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("查询所有的告警规则信息并且分页显示");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	// 删除告警规则信息
	public ActionForward deleteAlertRule(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "删除告警规则信息");
		
		
		try{
			init();
			String curpage = (request.getParameter("currpage") == null ||request.getParameter("currpage").equals(""))? "1"
					: request.getParameter("currpage");
			request.setAttribute("curpage", curpage);
			String rules[] = request.getParameterValues("ruleCheckbox");
			if (rules != null) {
				for (String string : rules) {
					alertRuleService.deleteAlterRuleService(Integer
							.parseInt(string));
				}
			}
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("删除告警规则信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getPageAlertRule(mapping, form, request, response);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("删除告警规则信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	// 根据ID 查询单个的告警信息
	public ActionForward getByIdAlertRule(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AlertRuleForm alertRuleForm = (AlertRuleForm) form;
		String alertId = request.getParameter("alertRuleId");
		AlertRuleBO alertRulebo =null;
		
		
		try{
			init();
			if (alertId != null && (!alertId.equals(""))) {
				 alertRulebo=alertRuleService.getByIdAlertRuleService(Integer.parseInt(alertId));
				alertRuleForm.setAlertRulebo(alertRulebo);
				if(alertRulebo.getDeparmentId()!=null && alertRulebo.getDeparmentId().toString().trim().length()!=0){
//					ManagerBO department = managerService.getManagerByIdService(alertRulebo.getDeparmentId());
					Domain domain = domainService.findById(alertRulebo.getDeparmentId());
					request.setAttribute("department", domain);
				}
				request.setAttribute("alertRulebo", alertRulebo);
			}
			if (request.getParameter("update") != null) {
				//根据类型查找子类型		
				List<AlertTypeBO> subTypeList=new ArrayList();
				if(alertRulebo!=null){
					subTypeList=alertDwrService.getSubTypeByNameService(alertRulebo.getType());
				}		
				request.setAttribute("curpage", request.getParameter("curpage"));
				request.setAttribute("subTypeList", subTypeList);
				return mapping.findForward("alertRuletUpdate");
			}
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("根据ID 查询单个的告警信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("alertRulePart");
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

	// 添加告警规则信息
	public ActionForward addAssetRule(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "添加告警规则信息");
		AlertRuleForm alertRuleForm = (AlertRuleForm) form;
		try{
			init();
			//判读是否重复提交
			if(isTokenValid(request)){
				AlertRuleBO alertRuleBo = new AlertRuleBO();
				alertRuleBo = alertRuleForm.getAlertRulebo();
				alertRuleForm.reset();
				alertRuleService.saveAlertRuleService(alertRuleBo);
			    resetToken(request);
			}else{
				saveToken(request);
			}	
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("添加告警规则信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getPageAlertRule(mapping, alertRuleForm, request, response);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("添加告警规则信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	// 更新告警规则信息
	public ActionForward updateAlertRule(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "更新告警规则信息");	
		
		
		
		try{
			init();
			AlertRuleForm alertRuleForm = (AlertRuleForm) form;
		    AlertRuleBO alertRuleBo = new AlertRuleBO();
			alertRuleBo = alertRuleForm.getAlertRulebo();
			alertRuleBo.setEmailTarget(request.getParameter("alertRulebo.emailTarget"));
			alertRuleBo.setMsgTarget(request.getParameter("alertRulebo.msgTarget"));
			alertRuleBo.setSmsTarget(request.getParameter("alertRulebo.smsTarget"));
			alertRuleForm.reset();
			
			//调用service方法执行更新
			alertRuleService.updateAlterRuleService(alertRuleBo);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("更新告警规则信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getPageAlertRule(mapping, alertRuleForm, request, response);
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("更新告警规则信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	// 根据告警信息提供的可能多个ID查询相应的告警规则
	public ActionForward getAlertRules(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String rules = request.getParameter("alertRuleId");
		// 如果不为空就根据ID 查询出
		try{
			init();
			List<AlertRuleBO> list=new ArrayList<AlertRuleBO>();
			if (rules != null && rules.length() > 0) {			
				String rulesId[] = rules.split(",");
				if (rulesId != null && rulesId.length > 0) {
					for (String string : rulesId) {
						AlertRuleBO alertRulebo = alertRuleService
								.getByIdAlertRuleService(Integer.parseInt(string));
						if (alertRulebo != null) {
							list.add(alertRulebo);
						}
					}
				}
			}
			request.setAttribute("list", list);
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("根据告警信息提供的可能多个ID查询相应的告警规则");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("alertToRule");
		}catch(Exception e){
			log.setUsername(username);
			log.setRoleName(rolenames);
			log.setTime(new Timestamp(new Date().getTime()));
			log.setModuleName(SystemModelInfo.MOD_AIM);
			log.setOperationDesc("根据告警信息提供的可能多个ID查询相应的告警规则");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	
	//添加告警规则的界面跳转
	public ActionForward forward(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        if(request.getParameter("add")!=null){
        	saveToken(request);
        	return mapping.findForward("addAlertRule");
        }
		return null;
	}
	//跳转
	public ActionForward alertFind(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("topcss", "alertFind");
		return mapping.findForward("alertFind");
	}
	//跳转
	public ActionForward alertFindFrame(ActionMapping mapping,ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("topcss", "alertFindFrame");
		return mapping.findForward("alertFindFrame");
	}
}
