package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.modle.HillStoneFireWall;
import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.sysLog.service.HillStoneFireWallService;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

public class HillStoneFireWallAction extends Action {
	
	private HillStoneFireWallService hillStoneFireWallService;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("showFlag", "HillStoneFireWall_0.0");
		String logSourceLogo = request.getSession().getAttribute("sysLog_logsourcelogo").toString();
		
		PageBean pageBean = (PageBean) request.getAttribute("pageBean");
			
		List<Domain> domain = SecurityUserHolder.getCurrentUser().getDomainList();
		Integer logCount = hillStoneFireWallService.getHillStoneFireWallSysLogCount(domain, logSourceLogo);
		
		List<HillStoneFireWall> hillStoneList = hillStoneFireWallService.getHillStoneFireWallSysLog(domain, logSourceLogo, (pageBean.getPageNo()-1)*Integer.valueOf(pageBean.getPageRowNum()), pageBean.getPageRowNum());
		
		pageBean.setPageResult(hillStoneList);
		pageBean.setPageMaxSum((logCount+pageBean.getPageRowNum()-1)/pageBean.getPageRowNum());
		pageBean.setResultRowSum(logCount);
		request.setAttribute("pageBean", pageBean);
		return mapping.findForward("sysLogDivSource");
	}

	public HillStoneFireWallService getHillStoneFireWallService() {
		return hillStoneFireWallService;
	}

	public void setHillStoneFireWallService(
			HillStoneFireWallService hillStoneFireWallService) {
		this.hillStoneFireWallService = hillStoneFireWallService;
	}
	
}
