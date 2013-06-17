package edu.sjtu.infosec.ismp.manager.EM.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Role;

public class EventAspect implements MethodInterceptor {

	private HttpServletRequest request;
	
	private HttpSession session;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 得到方法执行的所有参数
		Object[] args = invocation.getArguments();

		// 设置参数匹配值
		setMappingParameter(args);
		// 给Session赋值
		if (request != null) {
			session = request.getSession();
		}
		// 获得类名和方法名
		String methodName = request.getParameter("method");
		// 判断是否有权限Tag
		boolean flag = false;
		
		List<Role> list = (List<Role>) SecurityUserHolder.getCurrentUser().getRoleList();
		// 获得角色信息
		if (list != null && !list.isEmpty()) {

			// 对角色List进行轮循，判断该用户的操作是否有权限
			for (Role roleBO : list) {
				if (methodName.indexOf(EventContainer.OPERATE_METHOD_ADD) != -1
						|| methodName.indexOf(EventContainer.OPERATE_METHOD_DELETE) != -1
						) {
					// 如果是添加和删除操作
					if (roleBO.getRole().equals(EventContainer.ROLE_NAME_ADMIN)) {
						// 如果用户角色名字为超级管理员或者审计员的情况
						flag = true;
					}
					break;
				} else {
					// 如果是查看或其他操作
					if (roleBO.getRole().equals(EventContainer.ROLE_NAME_ADMIN)
							|| roleBO.getRole().equals(EventContainer.ROLE_NAME_WATCH)
							|| roleBO.getRole().equals(EventContainer.ROLE_NAME_USER)) {
						// 如果用户角色名字为超级管理员或值班员或普通管理员的情况
						flag = true;
						break;
					}
				}
			}
		}
		if (flag) {
			// 有权限的时候继续执行
			return invocation.proceed();
		} else {
			// 没有权限的时候抛出异常
			
			throw new EventNotPopedomException("not popedomException!");
		}

	}

	/**
	 * 
	 * setMappingParameter decription : TODO
	 * 
	 * @param args
	 */
	private void setMappingParameter(Object[] args) {
		Object obj = null;
		// 对参数进行轮循
		for (int i = 0; i < args.length; i++) {
			obj = args[i];
			if (obj instanceof HttpServletRequest) {
				request = (HttpServletRequest) obj;
			}
		}

	}

}
