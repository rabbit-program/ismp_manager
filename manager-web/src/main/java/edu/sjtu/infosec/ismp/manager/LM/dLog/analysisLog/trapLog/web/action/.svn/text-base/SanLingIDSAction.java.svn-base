package edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.modle.SanLingIDS;
import edu.sjtu.infosec.ismp.manager.LM.dLog.analysisLog.trapLog.service.SnmpTrapIDSService;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

public class SanLingIDSAction extends Action {
	private SnmpTrapIDSService snmpTrapIDSSer;
	
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("showFlag", "SanLingIDS_0.0");
		String logSourceLogo = request.getSession().getAttribute("snmpTrap_logsourcelogo").toString();
		
		PageBean pageBean = (PageBean) request.getAttribute("pageBean");
			
		List<Domain> domain = SecurityUserHolder.getCurrentUser().getDomainList();
		Integer logCount = snmpTrapIDSSer.getSnmpTrapIDSLogCount(SanLingIDS.class, domain, logSourceLogo);
		
		List<SanLingIDS> sanLingIDSList = (List<SanLingIDS>) snmpTrapIDSSer.getSnmpTrapIDSLog(SanLingIDS.class, domain, logSourceLogo, (pageBean.getPageNo()-1)*Integer.valueOf(pageBean.getPageRowNum()), pageBean.getPageRowNum());
		
		pageBean.setPageResult(sanLingIDSList);
		pageBean.setPageMaxSum((logCount+pageBean.getPageRowNum()-1)/pageBean.getPageRowNum());
		pageBean.setResultRowSum(logCount);
		request.setAttribute("pageBean", pageBean);
		return mapping.findForward("snmpTrapDivSource");
	}
	public SnmpTrapIDSService getSnmpTrapIDSSer() {
		return snmpTrapIDSSer;
	}
	public void setSnmpTrapIDSSer(SnmpTrapIDSService snmpTrapIDSSer) {
		this.snmpTrapIDSSer = snmpTrapIDSSer;
	}

}
