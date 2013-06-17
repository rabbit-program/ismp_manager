package edu.sjtu.infosec.ismp.manager.LM.dLog.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;

public class SysLogDivSourceAction extends DispatchAction {

	public ActionForward sysLogGetDevice(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String deviceName = request.getParameter("device");
		String logsourcelogo = request.getParameter("logsourcelogo");
		
		request.getSession().setAttribute("sysLog_deviceName", deviceName);
		request.getSession().setAttribute("sysLog_logsourcelogo", logsourcelogo);
		return mapping.findForward("sysLogAnalysisDisplay");
	}
	
	public ActionForward sysLogDeviceForward(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String deviceName = (String) request.getSession().getAttribute("sysLog_deviceName");
		String pageNo = request.getParameter("pageNo");
		
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(Integer.parseInt(pageNo));
		pageBean.setPageRowNum(12);
		request.setAttribute("pageBean", pageBean);
		
		return mapping.findForward(deviceName);
	}
}
