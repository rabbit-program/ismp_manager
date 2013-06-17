package edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.actions;


import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.directwebremoting.WebContextFactory;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteStatusBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.BlackAndWhiteService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.BlackAndWhiteStatusService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.RoleService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.form.UserForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.vo.UserUpdateVO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
import edu.sjtu.infosec.ismp.security.User;
import edu.sjtu.infosec.ismp.util.Md5Util;
/**
 * 
 * @author shixq 用户配置Action 包括注册更新等。。
 */

/**
 * 
 * @author gengtongyong
 */

public class UserConfigAction extends DispatchAction {

	private UserService userservice;// 注入用户service接口
	private DomainService domainService;
	private BlackAndWhiteService blackandwhiteservice;// 注入黑白名单service接口
	private BlackAndWhiteStatusService blackandwhitestatusservice; // 注入控制黑白名单启用状态services
	private RoleService roleservice;// 用户角色 service接口
	
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
		log.setUsername(username);
		log.setRoleName(rolenames);
		log.setTime(new Timestamp(new Date().getTime()));
		log.setModuleName(SystemModelInfo.MOD_SYSM_user_self);
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             frame框架跳转
	 */
	public ActionForward forward(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
//		// 先查询出来
//		if (request.getParameter("top") != null) {
//			return mapping.findForward("userTop");
//		}
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		if (request.getParameter("add") != null) {
			request.setAttribute("cssclass", "userRegister");
			return mapping.findForward("userRegister");
		}
		if (request.getParameter("addBlackAndWhite") != null) {
			List<Domain> domainList = user.getDomainList();
			request.setAttribute("domainList", domainList);
			List<Role> rolelists=roleservice.getBlurRoleService(null);
	        request.getSession().setAttribute("rolesSearchList",rolelists);
	        request.setAttribute("cssclass", "addBlackAndWhite");
			return mapping.findForward("addBlackAndWhite");
		}
		if (request.getParameter("blackandwhiteFwd") != null) {
			List<Domain> domainList = user.getDomainList();
			request.setAttribute("domainList", domainList);
			List<Role> rolelists=roleservice.getBlurRoleService(null);
	        request.getSession().setAttribute("rolesSearchList",rolelists);
	        request.setAttribute("cssclass", "userBlackandWhiteSearch");
			return mapping.findForward("userBlackandWhiteSearch");
		}
		if (request.getParameter("addManager") != null) {
			List<Domain> domainList = user.getDomainList();
			request.setAttribute("domainList", domainList);
			saveToken(request);
			return mapping.findForward("userToManagerSave");
		}
		if(request.getParameter("updateManager") != null){
			List<Domain> domainList = user.getDomainList();
			request.setAttribute("domainList", domainList);
			saveToken(request);
			return this.getManagerById(mapping, userForm, request, response);
		}
		if (request.getParameter("main") != null) {
			System.out.println("========");
			request.setAttribute("all", "true");
			HttpSession session = request.getSession();
			 session.setAttribute("topcss", "userconfig");
			return this.getBlurUser(mapping, userForm, request, response);
		}
		return null;
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             用户模糊查询并且分页显示
	 */
	public ActionForward getBlurUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		User userbo = new User();
		BeanUtils.copyProperties(userbo, userForm.getUservo());
		if(userForm.getStatus()==null || userForm.getStatus().equals("")){
			userbo.setEnabled(null);
		}
		Page page = new Page();
		// 获得当前页
		request.setAttribute("uservo", userForm.getUservo());
		request.setAttribute("status", userForm.getStatus());
		request.setAttribute("rid", userForm.getRid());
		String curpage = request.getParameter("curpage") != null
				&& (!request.getParameter("curpage").trim().equals("")) ? request
				.getParameter("curpage") : "1";
		if (request.getParameter("pageSize") != null
				&& (!request.getParameter("pageSize").equals(""))) {
			int pagesize = Integer.parseInt(request.getParameter("pageSize"));
			request.setAttribute("pageSize", request.getParameter("pageSize"));
			page.setEveryPage(pagesize);
		}else{
			page.setEveryPage(10);
		}
		// 设置当前页跟开始位置
		page.setCurrentPage(Integer.parseInt(curpage));
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		
		
		try{
			init();
			PageResult result = null;
			// 如果是用户浏览的话就查询所有
			if ((request.getAttribute("all") != null&& request.getAttribute("all").equals("true"))||
				(request.getParameter("all") != null&& request.getParameter("all").equals("true"))) {
				result = userservice.getBlurUserService(null, page,null);
			} else {
//				request.setAttribute("rid", userForm.getRid());
				result = userservice.getBlurUserService(userbo, page,userForm.getRid());
			}
			log.setOperationDesc("用户模糊查询并且分页显示");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			if (result != null) {
				List<User> list = result.getPageList();
				request.setAttribute("list", result.getPageList());
				request.setAttribute("page", result.getPage());
				//在循环根据用户ID找角色信息
				Map<Integer, List<Role>> rolemap=new HashMap<Integer, List<Role>>();
				for (User user:list) {
					List<Role> roleLists= new ArrayList<Role>(user.getRoles());
					rolemap.put(user.getId(),roleLists);
				}
				request.setAttribute("rolemap", rolemap);
			}
			if (request.getParameter("search") != null
					&& request.getParameter("search").equals("1")) {
				return mapping.findForward("userSearch");
			}
			saveToken(request);
			request.setAttribute("cssclass", "userMain");
			return mapping.findForward("userMain");
		}catch(Exception e){
			log.setOperationDesc("用户模糊查询并且分页显示");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             跟据ID 查看各人信息
	 */
	public ActionForward getUserById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		// 先查询出来
//		request.setAttribute("curPage", request.getParameter("curPage"));
//		request.setAttribute("pageSize", request.getParameter("pageSize"));
		request.setAttribute("search",request.getParameter("search"));
		try{
			init();
			if (request.getParameter("userId") != null) {
				Integer userId = Integer.parseInt(request.getParameter("userId"));
				User user = userservice.getUserByIdService(userId);
				if (user != null) {
					List<Role> roleList = new ArrayList<Role>(user.getRoles());
					request.setAttribute("rlist", roleList);
					String roles = user.getRoleNames();
					if(roles != null && roles.trim().length()!=0){
						List<Domain> domains = null;
						if(roles.indexOf("AdminAll")!=-1){
							 domains = userservice.getAllDomain();
						}else if(roles.indexOf("DomainAdminAll")!=-1){
							domains = userservice.getCasecadeDomain(user.getDomains());
						}else if(roles.indexOf("")!=-1){
							domains = new ArrayList();
							for(Domain d : user.getDomains()){
								domains.add(d);
							}
						}
						//域本地管理员不用处理
						request.setAttribute("domainList",domains );
					} 
				request.setAttribute("user", user);
				}
			}
			log.setOperationDesc(" 跟据ID 查看各人信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			if (request.getParameter("update") != null) {
				List<Role> roles = roleservice.getBlurRoleService(null);
				request.setAttribute("rolelist", roles);
				return mapping.findForward("userUpdate");
			}
			if (request.getParameter("roleallot") != null) {
				return mapping.findForward("userRoleAllot");
			}
			return mapping.findForward("userDetails");
			
		}catch(Exception e){
			log.setOperationDesc(" 跟据ID 查看各人信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             更新用户信息(包括更新角色)
	 */
	public ActionForward updateUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
//		request.setAttribute("curPage", request.getParameter("curPage"));
		request.setAttribute("curpage", request.getParameter("curpage"));
		String roleids[] = request.getParameterValues("roleid");
//		Set<Role> roles = new HashSet();
//		for(String roleid:roleids){
//			roles.add(roleservice.getRoleByIdService(Integer.parseInt(roleid)));
//		}
//		userForm.getUserupdatevo().setRoles(roles);
		UserUpdateVO uuv = userForm.getUserupdatevo();
		
		try{
			init();
			if(roleids!=null && roleids.length > 0){
				Set<Role> set = new HashSet<Role>();
				for(String ids: roleids){
					set.add(roleservice.getRoleByIdService(Integer.parseInt(ids)));
				}
				System.out.println("===="+uuv.getUsername());
				uuv.setRoles(set);
			}
			if(uuv!=null){
				userservice.updateUserService(uuv);
			}
			log.setOperationDesc(" 跟据ID 查看各人信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			//==============
			PrintWriter out = response.getWriter();
	        out = response.getWriter();
	        response.setContentType("text/html; charset=UTF-8");
	        out.println("<script language=\"javascript\">");
	        out.println("alert('修改用户成功');");
	        out.println("window.close();");
	        out.println("</script>");
	        out.close();
			
			return null;
//			return this.getBlurUser(mapping, form, request, response);
		}catch(Exception e){
			log.setOperationDesc(" 跟据ID 查看各人信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}


	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             用户注册
	 */
	public ActionForward saveUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 日志描述
		request.setAttribute("operation", "用户注册");
		UserForm userForm = (UserForm) form;
		// 默认是系统注册时间
		userForm.getUser().setRegistertime(new Timestamp(System.currentTimeMillis()));
		// 默认是废弃状态
		userForm.getUser().setEnabled(false);
		String pwdStr = Md5Util.getMD5Str(userForm.getUser().getPassword());
		userForm.getUser().setPassword(pwdStr);
		
		
		
		
		try{
			init();
			userservice.saveUserService(userForm.getUser());
			// 判断是否重复提交
			if (isTokenValid(request)) {
				userservice.saveUserService(userForm.getUser());
				resetToken(request);
			} else {
				saveToken(request);
			}
			log.setOperationDesc("添加用户");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getBlurUser(mapping, userForm, request, response);
		}catch(Exception e){
			log.setOperationDesc("添加用户");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}


	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             更新用户用户状态
	 */
	public ActionForward updateUserStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "更新用户状态");
		UserForm userForm = (UserForm) form;

		try{
			init();
			if (request.getParameter("userId") != null) {
				Integer userid = Integer.valueOf(request.getParameter("userId"));
				Boolean status = false;
				if (request.getParameter("statuss") != null
						&& request.getParameter("statuss").equals("1")) {
					status = true;
				}
				userservice.updateUserStatusService(userid, status);
			}
			log.setOperationDesc("添加用户");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getBlurUser(mapping, userForm, request, response);
		}catch(Exception e){
			log.setOperationDesc("添加用户");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             条件查询 委办局信息
	 */
	public ActionForward getUserToManagerByList(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		
		try{
			init();
			Domain domain = new Domain();
			domain.setDomainName(request.getParameter("domainname"));
			request.setAttribute("domainname", request.getParameter("domainname"));
//			mbo.setManagerName(userForm.getManagerName());
			Page page = new Page();
			String curpage = request.getParameter("curpage") != null
					&& (!request.getParameter("curpage").equals("")) ? request
					.getParameter("curpage") : "1";
			// 设置当前页跟开始位置
			page.setCurrentPage(Integer.parseInt(curpage));
			page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
			PageResult rs = domainService.findByParam(domain, page);
//			List<Domain> rs = domainService.findAll();
			if (rs != null) {
				request.setAttribute("page", rs.getPage());
				request.setAttribute("list", rs.getPageList());
			}
			log.setOperationDesc("条件查询域信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("userToManagerIndex");
		}catch(Exception e){
			log.setOperationDesc("条件查询域信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             添加新的委办局信息
	 */
	public ActionForward saveManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "添加委办局信息");
		
		try{
			init();
			UserForm userform = (UserForm) form;
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			Domain domain = new Domain();
			domain.setDomainName(request.getParameter("domain_name"));
			domain.setDescription(request.getParameter("description"));
			String parent_id = request.getParameter("parent_id");
			if(parent_id!=null && !parent_id.equals("") && !parent_id.equals("-1")){
				domain.setParentDomain(domainService.findById(Integer.parseInt(parent_id)));
			}
			if (!isTokenValid(request,true)) {
				resetToken(request);
				domainService.add(domain);
				user.getDomainList().add(domain);
			} else {
				saveToken(request);
			}
			log.setOperationDesc("添加新域信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("userToManagerIndex");
		}catch(Exception e){
			log.setOperationDesc("添加新域信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}


	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             删除用户信息
	 */
	public ActionForward deleteUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		request.setAttribute("operation", "删除用户");
		String usid = request.getSession().getAttribute("usid") == null ? ""
				: request.getSession().getAttribute("usid").toString();
		
		
		try{
			init();
			if (request.getParameter("userId") != null
					&& !request.getParameter("userId").equals(usid)) {
				request.getSession().setAttribute("usid",
						request.getParameter("userId"));
				Integer userId = Integer.parseInt(request.getParameter("userId"));
				User user = userservice.getUserByIdService(userId);
				if (user != null) {
					userservice.deleteUserService(user);
				}
			}
			log.setOperationDesc("删除用户信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getBlurUser(mapping, userForm, request, response);
		}catch(Exception e){
			log.setOperationDesc("删除用户信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}


	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             更新用户密码
	 */
	public ActionForward updateUserPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "修改密码");
		
		
		
		try{
			init();
			String uname = request.getParameter("user.username").trim();
			String newpwd = Md5Util.getMD5Str(request
					.getParameter("user.password2").trim());
			User userbo = new User();
			userbo.setLoginName(uname);
			// 判断是否是重设密码
			if (request.getParameter("user.password") != null) {
				String formerpwd = Md5Util.getMD5Str(request
						.getParameter("user.password").trim());
				userbo.setPassword(formerpwd);
			}
			User newuserbo = userservice.getUserByUnameAndPwd(userbo);
			// 验证密码是否跟老密码相同
			if (newuserbo != null && !newuserbo.getPassword().equals(newpwd)) {
				newuserbo.setPassword(newpwd);
				userservice.updateUserPasswordService(newuserbo.getId(),newpwd);
			}
			log.setOperationDesc("更新用户密码");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			//===========
//			PrintWriter out = response.getWriter();
//	        out = response.getWriter();
//	        response.setContentType("text html; charset=UTF-8");
//	        out.println("<script language=\"javascript\">");
//	        out.println("window.opener.location.href=window.opener.location.href;");
//	        out.println("window.opener.location.reload();");
//	        out.println("window.close();");
//	        out.println("</script>");
//	        out.close();
	        
	        
	        
	        PrintWriter out = response.getWriter();
	        out = response.getWriter();
	        response.setContentType("text/html; charset=UTF-8");
	        out.println("<script language=\"javascript\">");
	        out.println("alert('操作成功');");
	        out.println("window.close();");
	        out.println("</script>");
	        out.close();
			
			
			return null;
//			return new ActionForward("/ismp/domain/local/userResetPassword.do");
		}catch(Exception e){
			log.setOperationDesc("更新用户密码");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             重置用户密码
	 */
	public ActionForward updateResetPass(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "重置密码");
		
		
		try{
			init();
			String uname = request.getParameter("user.username");
			String newpwd = Md5Util.getMD5Str(request
					.getParameter("user.password2"));
			User newuserbo = userservice.getUserinfoByNameService(uname);
			// 验证密码是否跟老密码相同
			if (newuserbo != null) {	
				userservice.updateUserPasswordService(newuserbo.getId(),newpwd);
			}
			log.setOperationDesc("重置用户密码");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			//================
			 PrintWriter out = response.getWriter();
		        out = response.getWriter();
		        response.setContentType("text/html; charset=UTF-8");
		        out.println("<script language=\"javascript\">");
		        out.println("alert('操作成功');");
		        out.println("window.close();");
		        out.println("</script>");
		        out.close();
		    return null;
//			return new ActionForward("/ismp/domain/local/userResetPassword.do");
		}catch(Exception e){
			log.setOperationDesc("重置用户密码");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             查询黑白名单并且分页显示
	 */
	public ActionForward getPageListBlackAndWhite(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		
		
		
		

		try{
			init();
			Page page = new Page();
			// 获得当前页
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> domainList = user.getDomainList();
			request.setAttribute("domainList", domainList);
			request.setAttribute("blackandwhitebo", userForm.getBlackandwhitebo());
			if(userForm.getBlackandwhitebo().getRole()!=null && userForm.getBlackandwhitebo().getRole().equals("-1")){
				userForm.getBlackandwhitebo().setRole(null);
			}
			String curpage = request.getParameter("curpage") != null
					&& (!request.getParameter("curpage").equals("")) ? request
					.getParameter("curpage") : "1";
			if (request.getParameter("pageSize") != null
					&& (!request.getParameter("pageSize").equals(""))) {
				int pagesize = Integer.parseInt(request.getParameter("pageSize"));
				request.setAttribute("pageSize", request.getParameter("pageSize"));
				page.setEveryPage(pagesize);
			}
			// 设置当前页跟开始位置
			page.setCurrentPage(Integer.parseInt(curpage));
			page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
			PageResult result = blackandwhiteservice
					.getPageListBlurBlackAndWhiteService(userForm
							.getBlackandwhitebo(), page);
			request.setAttribute("page", result.getPage());
			request.setAttribute("list", result.getPageList());
			request.setAttribute("cssclass", "userBlackandWhiteSearch");
			log.setOperationDesc("查询黑白名单并且分页显示");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("userBlackandWhiteSearch");
		}catch(Exception e){
			log.setOperationDesc("查询黑白名单并且分页显示");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 *             更新黑白名单
	 */
	public ActionForward updateUserBlackAndWhite(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "更新黑白名单");
		String mid =request.getParameter("mid");
		String marker =request.getParameter("marker");
		String role =request.getParameter("role");
		String domain =request.getParameter("domain");
		String ipaddress =request.getParameter("ipaddress");
		String depict =request.getParameter("depict");
		String curpage=request.getParameter("curpage");
		UserForm userForm = (UserForm) form;
		BlackAndWhiteBO blackandwhitebo = new BlackAndWhiteBO();
		if(mid!=null && !mid.trim().equals("")){
			blackandwhitebo.setId(Integer.parseInt(mid));
		}
		if(role!=null && !role.trim().equals("") && !role.trim().equals("-1")){
			Role role2 = roleservice.getRoleByIdService(Integer.parseInt(role.trim()));
			blackandwhitebo.setRole(role2.getRole());
		}
		if(marker!=null && !marker.trim().equals("") && (marker.trim().equals("1")||marker.trim().equals("0")) ){
			blackandwhitebo.setMarker(Integer.parseInt(marker));
		}
		if(domain!=null && !domain.equals("") && !domain.equals("-1")){
			blackandwhitebo.setDomain(Integer.parseInt(domain));
		}
		if(ipaddress!=null && !ipaddress.trim().equals("")){
			blackandwhitebo.setIpaddress(ipaddress);
		}
		if(depict!=null){
			blackandwhitebo.setDepict(depict);
		}
		
		
		
		try{
			init();
			blackandwhiteservice.updateBelackAndWhiteService(blackandwhitebo);
			log.setOperationDesc("更新黑白名单");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			
			//================
			 PrintWriter out = response.getWriter();
		        out = response.getWriter();
		        response.setContentType("text/html; charset=UTF-8");
		        out.println("<script language=\"javascript\">");
		        out.println("alert('操作成功');");
		        out.println("window.close();");
		        out.println("</script>");
		        out.close();
		    return null;
//			return new ActionForward("/ismp/domain/local/userConfig.do?method=getPageListBlackAndWhite&curpage="+curpage);
		}catch(Exception e){
			log.setOperationDesc("更新黑白名单");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * ID查询黑白名单
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getByIdBlackAndWhite(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("curpage", request.getParameter("curpage"));
		try{
			init();
			if (request.getParameter("blid") != null && !request.getParameter("blid").trim().equals("")) {
				OperatorDetails user = SecurityUserHolder.getCurrentUser();
				List<Domain> domainList = user.getDomainList();
				request.setAttribute("domainList", domainList);
				List<Role> rolelists=roleservice.getBlurRoleService(null);
		        request.getSession().setAttribute("rolesSearchList",rolelists);
				BlackAndWhiteBO blbo = blackandwhiteservice
						.getBlackAndWhiteByIdService(Integer.parseInt(request
								.getParameter("blid")));
				request.setAttribute("blackandwhitebo", blbo);
			}
			log.setOperationDesc("ID查询黑白名单");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("updateBlackAndWhite");
		}catch(Exception e){
			log.setOperationDesc("ID查询黑白名单");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * ID删除黑白名单
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteBlackandWhite(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "删除黑白名单");
		UserForm userForm = (UserForm) form;
		try{
			init();
			String blid = request.getSession().getAttribute("blid") == null ? ""
					: request.getSession().getAttribute("blid").toString();
			if (request.getParameter("bid") != null
					&& !request.getParameter("bid").equals(blid)) {

//				request.getSession().setAttribute("blid",
//						request.getParameter("bid"));
				BlackAndWhiteBO blbo = blackandwhiteservice
						.getBlackAndWhiteByIdService(Integer.parseInt(request
								.getParameter("bid")));
				if (blbo != null) {
					blackandwhiteservice.deleteBlackAndWhiteService(blbo);
				}
			}
			log.setOperationDesc("ID删除黑白名单");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getPageListBlackAndWhite(mapping, userForm, request, response);
		}catch(Exception e){
			log.setOperationDesc("ID删除黑白名单");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * ID删除部门
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delDomainById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除委办局信息");
		String curpage = request.getParameter("curpage");
		request.setAttribute("curpage", curpage);
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		String mid = request.getParameter("mid");
		try{
			init();
			if (mid!=null && !mid.trim().toString().equals("")) {
				if(mid != null){
					List<Domain> list = user.getDomainList();
					Domain dm = domainService.findById(Integer.parseInt(mid));
					for(Domain d:list){
						if(dm!=null && d.getId().equals(dm.getId())){
							domainService.delete(dm);			//级联删除子节点。
						}
					}
					for(int i=0;i<list.size();i++){
						if(dm!=null && list.get(i).getId().equals(dm.getId())){
							user.getDomainList().remove(i);
						}
					}
					
				}
				}
			log.setOperationDesc("ID删除域");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getUserToManagerByList(mapping, form, request, response);
		}catch(Exception e){
			log.setOperationDesc("ID删除域");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

//	/**
//	 * 与cener通信
//	 * 
//	 * @param mbo
//	 * @param status
//	 * @throws IllegalAccessException
//	 * @throws InvocationTargetException
//	 */
//	private boolean sendToCenter(ManagerBO mbo, int status)
//			throws IllegalAccessException, InvocationTargetException {
//		try {
//			SoftwareDepartmentManagerBO s = new SoftwareDepartmentManagerBO();
//			convertBean(s, mbo, status);
//			s.setId(mbo.getId());
//			// 发送到center端
//			softwareDepartmentManagerSender.setHost(WebConfigContent.centerIp);
//			softwareDepartmentManagerSender.setPort(Integer.parseInt(WebConfigContent.dataPort));
//			softwareDepartmentManagerSender.senderSoftwareDepartmentInfo(s);
//		} catch (Exception e) {
//            e.printStackTrace();
//            return false;
//		}
//		return true;
//	}
//
	/**
	 * ID查询委办局信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getManagerById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("curpage", request.getParameter("curpage"));
		
		
		
		try{
			init();
			String mid = request.getParameter("mid");
			if (mid != null && !mid.trim().toString().equals("")) {
				Domain domain = domainService.findById(Integer
						.parseInt(mid));
				request.setAttribute("domainVO", domain);
			}
			log.setOperationDesc("ID查询域信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("userToManagerUpdate");
		}catch(Exception e){
			log.setOperationDesc("ID查询域信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 新增黑白名单
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveBlackandWhite(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserForm userForm = (UserForm) form;
		request.setAttribute("operation", "新增黑白名单");
		
		
		try{
			init();
			BlackAndWhiteBO blackandwhitebo = userForm.getBlackandwhitebo();
			if(blackandwhitebo!=null && blackandwhitebo.getMarker()!=-1){
				Role role = roleservice.getRoleByIdService(Integer.parseInt(blackandwhitebo.getRole()));
				if(role!=null){
					userForm.getBlackandwhitebo().setRole(role.getRole());
				}else{
					userForm.getBlackandwhitebo().setRole("");
				}
			}else{
				userForm.getBlackandwhitebo().setRole("");
			}
			if (!isTokenValid(request)) {
				resetToken(request);
				blackandwhiteservice.saveBlackAndWhiteService(userForm
						.getBlackandwhitebo());
			} else {
				saveToken(request);
			}
			BlackAndWhiteBO bwBO = new BlackAndWhiteBO();
			bwBO.setRole("-1");
			userForm.setBlackandwhitebo(bwBO);// 设置查询条件为空 查询出所有来
			log.setOperationDesc("新增黑白名单");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getPageListBlackAndWhite(mapping, form, request, response);
		}catch(Exception e){
			log.setOperationDesc("新增黑白名单");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 获得当前黑白名单启用状态
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getBlackandWhiteStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		
		try{
			init();
			BlackAndWhiteStatusBO blackandwhitestatusbo = blackandwhitestatusservice
			.getBlackAndWhiteStatusService();
			request.setAttribute("blackandwhitestatusbo", blackandwhitestatusbo);
			request.setAttribute("cssclass", "blackandwhitestatus");
			log.setOperationDesc("获得当前黑白名单启用状态");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return mapping.findForward("blackandwhitestatus");
		}catch(Exception e){
			log.setOperationDesc("获得当前黑白名单启用状态");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	/**
	 * 获得所有的角色信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getRoleAll(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		try{
			init();
			List<Role> rolelists=roleservice.getBlurRoleService(null);
	        request.getSession().setAttribute("rolesSearchList",rolelists);
	        request.setAttribute("cssclass", "userSearch");
	        log.setOperationDesc("根据用户ID查看用户 所对应的委办局信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			request.setAttribute("cssclass", "userToManager");
			return mapping.findForward("userSearch");
		}catch(Exception e){
			log.setOperationDesc("根据用户ID查看用户 所对应的委办局信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 根据用户ID查看用户 所对应的委办局信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getUserToManagerById(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("search", request.getParameter("search"));
		request.setAttribute("curpage", request.getParameter("curpage"));
		//当前登录用户管辖的部门
		
		
		try{
			init();
			OperatorDetails user = SecurityUserHolder.getCurrentUser();	
			List<Domain> domainList = user.getDomainList();
			request.setAttribute("domainList", domainList);
			if (request.getParameter("uid") != null) {
				User u = userservice.getUserByIdService(Integer.parseInt(request.getParameter("uid")));
				request.setAttribute("user", u);// 用户对应的委办局基本信息
				Set<Domain> set = u.getDomains();
				request.setAttribute("domainset", set);
				// 找出所属角色
				if (u != null) {
					List<Role> rolelist = roleservice.getRoleByUserIdService(u
							.getId());
					request.setAttribute("rlist", rolelist);// 用户角色信息
				}

			}
			log.setOperationDesc("根据用户ID查看用户 所对应的委办局信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			request.setAttribute("cssclass", "userToManager");
			return mapping.findForward("userToManager");
		}catch(Exception e){
			log.setOperationDesc("根据用户ID查看用户 所对应的委办局信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	
//	public ActionForward getUserToRoleById(ActionMapping mapping,
//			ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		request.setAttribute("search", request.getParameter("search"));
//		//当前登录用户管辖的部门
//		OperatorDetails user = SecurityUserHolder.getCurrentUser();	
//		List<Role> roleList = user.getRoleList();
//		request.setAttribute("rolelist", roleList);
//		if (request.getParameter("uid") != null) {
//			User u = userservice.getUserByIdService(Integer.parseInt(request.getParameter("uid")));
//			request.setAttribute("user", u);// 用户对应的委办局基本信息
//			Set<Role> set = u.getRoles();
//			request.setAttribute("rlist", set);
//			
//			// 找出所属角色
////			if (u != null) {
////				List<Role> rolelist = roleservice.getRoleByUserIdService(u
////						.getId());
////				request.setAttribute("rlist", rolelist);// 用户角色信息
////			}
//
//		}
//		return mapping.findForward("userToRole");
//	}

	/**
	 * 更新用户所对应的委办局信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateUserToManager(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "更新用户所对应的委办局信息");
		request.setAttribute("search", request.getAttribute("search"));
		String mids[] = request.getParameterValues("mid");
		request.setAttribute("curpage", request.getParameter("curpage"));
		String uid = request.getParameter("userid");
		Set<Domain> set = new HashSet();
		
		
		try{
			init();
			if (mids != null && mids.length > 0) {
				for (String strmid : mids) {
					set.add(domainService.findById(Integer.parseInt(strmid)));
				}
			}
			if (uid != null && uid.trim().length() > 0) {
				User userbo = userservice.getUserByIdService(Integer
						.parseInt(uid));
				if (userbo != null) {
					userbo.setDomains(set);
					// 执行更新
					userservice.updateUser(userbo);
					
				}
			}
			log.setOperationDesc("更新用户所对应的域信息");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			//==========
			PrintWriter out = response.getWriter();
	        out = response.getWriter();
	        response.setContentType("text/html; charset=UTF-8");
	        out.println("<script language=\"javascript\">");
	        out.println("alert('指定域成功');");
	        out.println("window.close();");
	        out.println("</script>");
	        out.close();
			return null;
			
			//return this.getBlurUser(mapping, form, request, response);
		}catch(Exception e){
			log.setOperationDesc("更新用户所对应的域信息");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}
	
//	/**
//	 * 更新、分配用户所对应的角色
//	 * @param mapping
//	 * @param form
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	public ActionForward updateUserToRole(ActionMapping mapping,
//			ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		request.setAttribute("operation", "更新用户所对应的角色");
//		request.setAttribute("search", request.getAttribute("search"));
//		String roleid[] = request.getParameterValues("roleid");
//		
//		String uid = request.getParameter("userid");
//		Set<Role> set = new HashSet();
//		if (roleid != null && roleid.length > 0) {
//			for (String strmid : roleid) {
//				set.add(roleservice.getRoleByIdService(Integer.parseInt(strmid)));
//			}
//		}
//		if (uid != null && uid.trim().length() > 0) {
//			User userbo = userservice.getUserByIdService(Integer
//					.parseInt(uid));
//			if (userbo != null) {
//				userbo.setRoles(set);
//				// 执行更新
//				userservice.updateUser(userbo);
//				
//			}
//		}
//		return this.getBlurUser(mapping, form, request, response);
//	}

	/**
	 * 更新委办局信息
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		request.setAttribute("curpage", request.getParameter("curpage"));
		
		try{
			init();
			Domain domain = domainService.findById(userForm.getMid());
			domain.setId(userForm.getMid());
			domain.setDescription(userForm.getDepict());
			domain.setDomainName(userForm.getManagerName());
			domain.setParentDomain(domainService.findById(Integer.parseInt(request.getParameter("pid"))));
			domainService.update(domain);
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> list = user.getDomainList();
			for(Domain d : list){
				if(d.getId().equals(domain.getId())){
					d=domain;
				}
			}
			log.setOperationDesc("新增黑白名单状态");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getUserToManagerByList(mapping, userForm, request, response);
		}catch(Exception e){
			log.setOperationDesc("新增黑白名单状态");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	/**
	 * 添加/或者更新当前黑白名单启用状态
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveOrUpdateBlackandWhiteStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "新增黑白名单状态");
		UserForm userForm = (UserForm) form;
		try{
			init();
			BlackAndWhiteStatusBO blackandwhitestatusbo = blackandwhitestatusservice
			.getBlackAndWhiteStatusService();
			if (request.getParameter("blsid") != null
					&& request.getParameter("blsid").trim().length() > 0
					&& blackandwhitestatusbo != null) {
				blackandwhitestatusbo.setStatus(Integer.parseInt(request
						.getParameter("bwstatus")));
				blackandwhitestatusservice
						.updateBlackAndWhiteStatusService(blackandwhitestatusbo);
		
			} else {
				BlackAndWhiteStatusBO bwstatusbo = new BlackAndWhiteStatusBO();
				bwstatusbo.setStatus(Integer.parseInt(request
						.getParameter("bwstatus")));
				blackandwhitestatusservice
						.saveBlackAndWhiteStatusService(bwstatusbo);
		
			}
			log.setOperationDesc("新增黑白名单状态");
			log.setControl("成功");
			systemlogService.saveSystemLog(log);
			return this.getBlackandWhiteStatus(mapping, form, request, response);
		}catch(Exception e){
			log.setOperationDesc("新增黑白名单状态");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			return null;
		}
	}

	

	/**
	 * Spring IOC需要的set方法
	 * 
	 * @param blackandwhiteservice
	 */
	public void setBlackandwhiteservice(
			BlackAndWhiteService blackandwhiteservice) {
		this.blackandwhiteservice = blackandwhiteservice;
	}

	public void setBlackandwhitestatusservice(
			BlackAndWhiteStatusService blackandwhitestatusservice) {
		this.blackandwhitestatusservice = blackandwhitestatusservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}

//
//	public void setManagerService(ManagerService managerService) {
//		this.managerService = managerService;
//	}
//
//	public void setSoftwareDepartmentManagerSender(
//			SoftwareDepartmentManagerSender softwareDepartmentManagerSender) {
//		this.softwareDepartmentManagerSender = softwareDepartmentManagerSender;
//	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
}
