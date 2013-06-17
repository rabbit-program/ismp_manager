package edu.sjtu.infosec.ismp.manager.LM.dLog.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.Ftp;
import edu.sjtu.infosec.ismp.manager.LM.dLog.service.FtpService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class FtpAction extends DispatchAction {
	
	private FtpService ftpSer;
	/**
	 *      Ftp日志源的 查询
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getFtpSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		FtpSource ftpsource = new FtpSource();
		List<FtpSource> ftpSourceList = ftpSer.getAllFtpSource(ftpsource, user, 0, 50);
		request.setAttribute("ftpSourceList", ftpSourceList);
		return mapping.findForward("ftpSourceListDisplay");
	}
	
	/**
	 * 	Ftp日志的 查询
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getFtpBySource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String logSource = request.getParameter("logsourcelogo");
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		List<Domain> domain = user.getDomainList();
		List<Ftp> ftpList = ftpSer.getFtpBySource(logSource, domain, 0, 50);
		request.setAttribute("ftpList", ftpList);
		return mapping.findForward("ftpListDisplay");
	}
	
	public FtpService getFtpSer() {
		return ftpSer;
	}
	public void setFtpSer(FtpService ftpSer) {
		this.ftpSer = ftpSer;
	}

}
