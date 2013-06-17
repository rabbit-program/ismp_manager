package edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm;

import org.springframework.security.core.context.SecurityContextHolder;

import edu.sjtu.infosec.ismp.security.OperatorDetails;

/**
 * 用户管理
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class SecurityUserHolder {
	/**
	 * 获取当前登陆用户
	 * @return 当前登陆用户
	 */
	public static OperatorDetails getCurrentUser() {
		OperatorDetails user = (OperatorDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;   
    } 
}
