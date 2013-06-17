package edu.sjtu.infosec.ismp.manager.HM.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.actions.LoginAction;

public class HelpAction extends Action {
	private static Logger logger = Logger.getLogger(LoginAction.class); 

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String help = "index";
		try{
			if(request.getAttribute("cmn")!=null && !request.getAttribute("cmn").equals("")){
				help = request.getAttribute("cmn").toString();
			}else{
				help = "index";
			}
		}catch(Exception e){
			help = "index";
			logger.debug("帮助页面查询出错啦！");
//			e.printStackTrace();
		}
		return mapping.findForward(help);
	}
}
