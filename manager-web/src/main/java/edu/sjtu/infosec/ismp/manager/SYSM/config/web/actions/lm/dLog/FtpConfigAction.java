package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.lm.dLog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.FtpSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.FtpSourceService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

/**
 * 处理Ftp日志的查询、新增
 * @author 林超
 *
 */
public class FtpConfigAction extends DispatchAction {
	
	private FtpSourceService ftpSourceSer;
	
	/**
	 *      Ftp日志的 查询
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
		List<FtpSource> ftpSourceList = ftpSourceSer.getAllFtpSource(ftpsource, user, 0, 50);
		request.setAttribute("ftpSourceList", ftpSourceList);
		return mapping.findForward("ftpSourceDisplay");
	}
	
	/**
	 *      Ftp日志的 新增
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addFtpSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return mapping.findForward("");
	}

	public FtpSourceService getFtpSourceSer() {
		return ftpSourceSer;
	}

	public void setFtpSourceSer(FtpSourceService ftpSourceSer) {
		this.ftpSourceSer = ftpSourceSer;
	}

}
