package edu.sjtu.infosec.ismp.manager.BSAM.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.util.EscapeUnescape;

/**
 * 
 * @author shixq
 *
 */
public class SituationHistoryAction extends DispatchAction {
	
	/**
	 * 历史态势 查询界面 跳转
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward forward(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String id=request.getParameter("id");
		
		if (null != name && name.trim().length() > 0) {
			name = EscapeUnescape.unescape(name);
		}
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("type", type);
		return mapping.findForward("situationHistory");
	}
}
