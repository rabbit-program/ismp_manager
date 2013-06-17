package edu.sjtu.infosec.ismp.manager.LM.dLog.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.LM.dLog.service.SysLogService;
import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogFrom;
import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogInitQueryBean;
import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogResponseQueryBean;
import edu.sjtu.infosec.ismp.manager.LM.util.InitQueryDate;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class SysLogAction extends DispatchAction {

	private SysLogService sysLogSer;

	public ActionForward originalDisplay(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		
		sysLogSer.sysLogBaseInfoService();
		
		if(request.getParameter("type")==null || !request.getParameter("type").equals("page")){
			SysLogResponseQueryBean sysLogQueryBean = sysLogSer.responseQuery(from,user);
			request.getSession().setAttribute("sysLogQuery_sysLogQueryBean", sysLogQueryBean);
		}
		
		List<String> initDate = InitQueryDate.initQueryDate(30);
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		request.setAttribute("sysLogResponseQueryBean", request.getSession().getAttribute("sysLogQuery_sysLogQueryBean"));
		request.setAttribute("pageResult", sysLogSer.getSysLog((SysLogResponseQueryBean)request.getSession().getAttribute("sysLogQuery_sysLogQueryBean"), pageNo, initDate.get(0), initDate.get(1)));
		return mapping.findForward("sysLogDisplay");
	}
	
	public ActionForward getQueryEntry(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SysLogInitQueryBean sysLogInitQueryBean = sysLogSer.initQuery();
		request.setAttribute("sysLogInitQueryBean", sysLogInitQueryBean);
		return mapping.findForward("sysLogQuery");
	}
	
	@SuppressWarnings("unchecked")
	public ActionForward logSourceDisplay(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		SysLogSource sysLogSource = new SysLogSource();
		SysLogFrom sysLogFrom = (SysLogFrom)from;
		List<Domain> domain = new ArrayList<Domain>();
		PageBean pageBean = new PageBean();
		
		if(request.getParameter("type")==null || !request.getParameter("type").equals("page")){
			if(sysLogFrom.getDomain()==null || sysLogFrom.getDomain()=="" || sysLogFrom.getDomain().equals("all")){
				domain = user.getDomainList();
			}else{
				for(Domain dom:user.getDomainList()){
					if(dom.getId().equals(Integer.valueOf(sysLogFrom.getDomain()))){
						domain.add(dom);
						break;
					}
				}
			}
			if(sysLogFrom.getDeviceIP()!=null && sysLogFrom.getDeviceIP()!="")
				sysLogSource.setDeviceIP(sysLogFrom.getDeviceIP());
			
			if(sysLogFrom.getStartCollectSwitch()!=null)
				sysLogSource.setStartCollectSwitch(sysLogFrom.getStartCollectSwitch());
			
			
			request.getSession().setAttribute("sourceListQuery_domain", domain);
			request.getSession().setAttribute("sourceListQuery_sysLogSource", sysLogSource);
		}
		
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<SysLogSource> sysLogSourceList = sysLogSer.getAllSysLogSource((SysLogSource)request.getSession().getAttribute("sourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("sourceListQuery_domain"), (pageBean.getPageNo()-1)*Integer.valueOf(pageBean.getPageRowNum()), pageBean.getPageRowNum());
		pageBean.setResultRowSum(sysLogSer.getAllSysLogSourceCount((SysLogSource)request.getSession().getAttribute("sourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("sourceListQuery_domain")));
		
		pageBean.setPageMaxSum((pageBean.getResultRowSum()+(pageBean.getPageRowNum()-1))/pageBean.getPageRowNum());
		pageBean.setPageResult(sysLogSourceList);
		
		request.setAttribute("domainList", user.getDomainList());
		request.setAttribute("pageResult", pageBean);
		
//		System.out.println("----------PageBean--source-------");
//		System.out.println("当前页：" + pageBean.getPageNo());
//		System.out.println("一共多少页：" + pageBean.getPageMaxSum());
//		System.out.println("每页多少行：" + pageBean.getPageRowNum());
//		System.out.println("一共多少行：" + pageBean.getResultRowSum());
//		System.out.println("符合查询数：" + pageBean.getPageResult().size());
//		System.out.println("----------PageBean--source-------");
		
		return mapping.findForward("sysLogSourceListDisplay");
	}

	public SysLogService getSysLogSer() {
		return sysLogSer;
	}

	public void setSysLogSer(SysLogService sysLogSer) {
		this.sysLogSer = sysLogSer;
	}
}
