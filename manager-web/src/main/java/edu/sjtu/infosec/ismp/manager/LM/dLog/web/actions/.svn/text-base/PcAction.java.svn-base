package edu.sjtu.infosec.ismp.manager.LM.dLog.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.PcLog;
import edu.sjtu.infosec.ismp.manager.LM.dLog.service.PcService;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.Sensor;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.PcSourceService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.lm.dLog.PcSourceFrom;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class PcAction extends DispatchAction {
	
	private PcSourceService pcSourceSer;
	private PcService pcSer;
	
	/**
	 * 获得Sensor列表
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward getPcSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		Sensor sensor = new Sensor();
		PcSourceFrom pcFrom = (PcSourceFrom)from;
		List<Domain> domain = new ArrayList<Domain>();
		PageBean pageBean = new PageBean();
		
		if(request.getParameter("type")==null || !request.getParameter("type").equals("page")){
			if(pcFrom.getDomain()==null || pcFrom.getDomain()=="" || pcFrom.getDomain().equals("all")){
				domain = user.getDomainList();
			}else{
				for(Domain dom:user.getDomainList()){
					if(dom.getId().equals(Integer.valueOf(pcFrom.getDomain()))){
						domain.add(dom);
						break;
					}
				}
			}
			if(pcFrom.getSensorIp()!=null && pcFrom.getSensorIp()!="")
				sensor.setSensorIp(pcFrom.getSensorIp());
			
			if(pcFrom.getStartCollectSwitch()!=null)
				sensor.setStartCollectSwitch(pcFrom.getStartCollectSwitch());
			
			
			sensor.setSensorIsExist(true);
			
			if(request.getParameter("type")!=null && request.getParameter("type").equals("sel"))
			{
				sensor.setStartMonitorSwitch(true);
			}
			request.getSession().setAttribute("pcSourceListQuery_domain", domain);
			request.getSession().setAttribute("pcSourceListQuery_sensor", sensor);
		}
		
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<Sensor> pcSourceList = pcSourceSer.getAllPcSource((Sensor)request.getSession().getAttribute("pcSourceListQuery_sensor"), (List<Domain>) request.getSession().getAttribute("pcSourceListQuery_domain"), (pageBean.getPageNo()-1)*pageBean.getPageRowNum(), pageBean.getPageRowNum());
		pageBean.setResultRowSum(pcSourceSer.getAllPcSourceCount((Sensor)request.getSession().getAttribute("pcSourceListQuery_sensor"), (List<Domain>) request.getSession().getAttribute("pcSourceListQuery_domain")));
		
		pageBean.setPageMaxSum((pageBean.getResultRowSum()+(pageBean.getPageRowNum()-1))/pageBean.getPageRowNum());
		pageBean.setPageResult(pcSourceList);
		
		request.setAttribute("domainList", user.getDomainList());
		request.setAttribute("pageResult", pageBean);
		
//		System.out.println("----------PageBean--source-------");
//		System.out.println("当前页：" + pageBean.getPageNo());
//		System.out.println("一共多少页：" + pageBean.getPageMaxSum());
//		System.out.println("每页多少行：" + pageBean.getPageRowNum());
//		System.out.println("一共多少行：" + pageBean.getResultRowSum());
//		System.out.println("符合查询数：" + pageBean.getPageResult().size());
//		System.out.println("----------PageBean--source-------");
		
		return mapping.findForward("pcSourceDisplay");
	}
	
	/**
	 * 获得与该Sensor相关的日志
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getSensorLog(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String logsourcelogo = request.getParameter("logsourcelogo");
		PageBean pageBean = new PageBean();

		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<PcLog> pcList = pcSer.getPcLogBySensor(logsourcelogo,(pageBean.getPageNo()-1)*pageBean.getPageRowNum(), pageBean.getPageRowNum());
		pageBean.setResultRowSum(pcSer.getPcLogBySensorCount(logsourcelogo));
		
		pageBean.setPageMaxSum((pageBean.getResultRowSum()+(pageBean.getPageRowNum()-1))/pageBean.getPageRowNum());
		pageBean.setPageResult(pcList);
		
		request.setAttribute("logsourcelogo", logsourcelogo);
		request.setAttribute("pageResult", pageBean);
		
		System.out.println("----------PageBean--pc-------");
		System.out.println("当前页：" + pageBean.getPageNo());
		System.out.println("一共多少页：" + pageBean.getPageMaxSum());
		System.out.println("每页多少行：" + pageBean.getPageRowNum());
		System.out.println("一共多少行：" + pageBean.getResultRowSum());
		System.out.println("符合查询数：" + pageBean.getPageResult().size());
		System.out.println("----------PageBean--pc-------");
		
		return mapping.findForward("pcSensorLogDisplay");
	}
	public PcSourceService getPcSourceSer() {
		return pcSourceSer;
	}

	public void setPcSourceSer(PcSourceService pcSourceSer) {
		this.pcSourceSer = pcSourceSer;
	}

	public PcService getPcSer() {
		return pcSer;
	}

	public void setPcSer(PcService pcSer) {
		this.pcSer = pcSer;
	}
	
}
