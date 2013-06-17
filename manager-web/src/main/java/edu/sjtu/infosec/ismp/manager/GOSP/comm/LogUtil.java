package edu.sjtu.infosec.ismp.manager.GOSP.comm;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
/**
 * 该类定义等级保护全局日志信息。
 * 
 * @author cxk
 * 
 * Date:2010-12-30
 */
public class LogUtil {
	/**
	 * 定义相关的static属性
	 */
	public static String userName = null;
	public static String roleName = null;
	/**
	 * 初始化日志相关信息
	 */
	public static void init(){
		
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		userName = user.getUsername();
		StringBuffer roles = new StringBuffer("");
		for(Role role : user.getRoleList()){
			roles.append(role.getName());
			roles.append(",");
		}
		 roleName = roles.substring(0,roles.length()-1);
	}
}
