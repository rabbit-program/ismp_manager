package edu.sjtu.infosec.ismp.manager.comm.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ForwardAction extends Action {
	private static Logger logger = Logger.getLogger(ForwardAction.class); 

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String toPage = "index";
		try{
			if(request.getParameter("tp")!=null && !request.getParameter("tp").equals("")){
				toPage = request.getParameter("tp").toString();
			}else{
				toPage = "index";
			}
		}catch(Exception e){
			toPage = "welcome";
			logger.debug("首页访问出错啦！");
//			e.printStackTrace();
		}
		logger.debug("=====toPage======="+toPage);
		return mapping.findForward(toPage);
	}
}
