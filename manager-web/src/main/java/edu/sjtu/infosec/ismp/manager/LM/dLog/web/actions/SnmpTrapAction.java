package edu.sjtu.infosec.ismp.manager.LM.dLog.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.SnmpTrapSourceService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.lm.dLog.SnmpTrapSourceFrom;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class SnmpTrapAction extends DispatchAction {
	
	private SnmpTrapSourceService snmpTrapSourceSer;
	
	/**
	 *      SnmpTrap日志的 查询
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward getSnmpTrapSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		SnmpTrapSource snmpTrapSource = new SnmpTrapSource();
		SnmpTrapSourceFrom snmpTrapFrom = (SnmpTrapSourceFrom)from;
		List<Domain> domain = new ArrayList<Domain>();
		PageBean pageBean = new PageBean();
		
		if(request.getParameter("type")==null || !request.getParameter("type").equals("page")){
			if(snmpTrapFrom.getDomain()==null || snmpTrapFrom.getDomain()=="" || snmpTrapFrom.getDomain().equals("all")){
				domain = user.getDomainList();
			}else{
				for(Domain dom:user.getDomainList()){
					if(dom.getId().equals(Integer.valueOf(snmpTrapFrom.getDomain()))){
						domain.add(dom);
						break;
					}
				}
			}
			if(snmpTrapFrom.getDeviceIP()!=null && snmpTrapFrom.getDeviceIP()!="")
				snmpTrapSource.setDeviceIP(snmpTrapFrom.getDeviceIP());
			
			if(snmpTrapFrom.getStartCollectSwitch()!=null)
				snmpTrapSource.setStartCollectSwitch(snmpTrapFrom.getStartCollectSwitch());
			
			
			request.getSession().setAttribute("SnmpTrapSourceListQuery_domain", domain);
			request.getSession().setAttribute("SnmpTrapSourceListQuery_sysLogSource", snmpTrapSource);
		}
		
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<SnmpTrapSource> snmpTrapSourceList = snmpTrapSourceSer.getAllSnmpTrapSource((SnmpTrapSource)request.getSession().getAttribute("SnmpTrapSourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("SnmpTrapSourceListQuery_domain"), (pageBean.getPageNo()-1)*pageBean.getPageRowNum(), pageBean.getPageRowNum());
		pageBean.setResultRowSum(snmpTrapSourceSer.getAllSnmpTrapSourceCount((SnmpTrapSource)request.getSession().getAttribute("SnmpTrapSourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("SnmpTrapSourceListQuery_domain")));
		
		pageBean.setPageMaxSum((pageBean.getResultRowSum()+(pageBean.getPageRowNum()-1))/pageBean.getPageRowNum());
		pageBean.setPageResult(snmpTrapSourceList);
		
		request.setAttribute("domainList", user.getDomainList());
		request.setAttribute("pageResult", pageBean);
		
//		System.out.println("----------PageBean--source-------");
//		System.out.println("当前页：" + pageBean.getPageNo());
//		System.out.println("一共多少页：" + pageBean.getPageMaxSum());
//		System.out.println("每页多少行：" + pageBean.getPageRowNum());
//		System.out.println("一共多少行：" + pageBean.getResultRowSum());
//		System.out.println("符合查询数：" + pageBean.getPageResult().size());
//		System.out.println("----------PageBean--source-------");
		
		return mapping.findForward("snmpTrapSourceListDisplay");
	}

	public SnmpTrapSourceService getSnmpTrapSourceSer() {
		return snmpTrapSourceSer;
	}

	public void setSnmpTrapSourceSer(SnmpTrapSourceService snmpTrapSourceSer) {
		this.snmpTrapSourceSer = snmpTrapSourceSer;
	}

}
