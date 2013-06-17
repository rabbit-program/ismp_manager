package edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.comm.model.SysInitArgs;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class LoginAction extends Action {
	private static Logger logger = Logger.getLogger(LoginAction.class); 
	/**
	 * 注入 service 接口
	 */
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

		try{
			String error = (request.getParameter("error")==null)?"":request.getParameter("error");
//			if(error!=null && error.equals("1")){
//				return mapping.findForward("failed");
//			}else 
			if(error!=null && error.equals("2")){
				return mapping.findForward("sessionFailed");
			}else{
				OperatorDetails user = SecurityUserHolder.getCurrentUser();
				if(user == null){
					return mapping.findForward("unLogin");
				}else{
					logger.debug("=====当前用户为："+user.getUsername());
					if(user.getRoleList() == null){
						logger.debug("其权限(0个)为：null");
					}else{
						logger.debug("其权限("+user.getRoleList().size()+"个)为："+user.getRoleList().get(0).getName());
					}
					if(user.getDomainList() == null){
						logger.debug("当前用户未分配的委办局！！！");
					}else{
						logger.debug("当前用户分配的委办局有：");
						for(Domain domain : user.getDomainList()){
							logger.debug(domain.getDomainName());
						}
					}
					SysInitArgs.getInstance();
					SysInitArgs.WEB_URL_BASE = request.getContextPath();
					return mapping.findForward("success");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return mapping.findForward("failed");
		}
		
	}
}
