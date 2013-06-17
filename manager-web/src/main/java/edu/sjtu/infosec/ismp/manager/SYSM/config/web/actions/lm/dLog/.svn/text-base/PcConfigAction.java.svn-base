package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.lm.dLog;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.Sensor;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.PcSourceService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.lm.dLog.PcSourceFrom;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

/**
 * 处理Pc日志的查询、新增
 * @author 林超
 *
 */
public class PcConfigAction extends DispatchAction {
	
	private PcSourceService pcSourceSer;
	private SystemLogService logService;
	private java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 *    Pc日志的 查询
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
			request.getSession().setAttribute("pcConfigSourceListQuery_domain", domain);
			request.getSession().setAttribute("pcConfigSourceListQuery_sensor", sensor);
		}
		
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<Sensor> pcSourceList = pcSourceSer.getAllPcSource((Sensor)request.getSession().getAttribute("pcConfigSourceListQuery_sensor"), (List<Domain>) request.getSession().getAttribute("pcConfigSourceListQuery_domain"), (pageBean.getPageNo()-1)*pageBean.getPageRowNum(), pageBean.getPageRowNum());
		pageBean.setResultRowSum(pcSourceSer.getAllPcSourceCount((Sensor)request.getSession().getAttribute("pcConfigSourceListQuery_sensor"), (List<Domain>) request.getSession().getAttribute("pcConfigSourceListQuery_domain")));
		
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
	 * 修改
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePcSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sourceId = request.getParameter("id");
		String startCollectSwitch = request.getParameter("startCollect");
		String intervalCollectTime = request.getParameter("intervalCollectTime");
		List<String> sourceIdList = new ArrayList<String>();
		
		if(sourceId != null && sourceId.contains(",")){
			String[] id = sourceId.split(",");
			for(String obj:id){
				sourceIdList.add(obj);
			}
		}else{
			sourceIdList.add(sourceId);
		}
		
		OperatorDetails eventLogClass = SecurityUserHolder.getCurrentUser();
		
		logService.saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "日志模块", 
				"修改 Sensor 日志源", Timestamp.valueOf(sdf.format(new Date())), "成功");
		
		pcSourceSer.updatePcSource(sourceIdList, startCollectSwitch, intervalCollectTime);
		
		return mapping.findForward("getSource");
	}
	
	/**
	 * 修改 轮循采集时间
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePcSourceintervalCollectTime(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sourceId = request.getParameter("id");
		Sensor sensor = pcSourceSer.loadObject(sourceId);
		request.setAttribute("sensorObject", sensor);
		return mapping.findForward("pcSensorDisplay");
	}
	
	/**
	 *      SysLog日志的 新增
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addSysLogSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		SysLogSourceFrom sourceFrom = (SysLogSourceFrom) from;
//		SysLogSource source = new SysLogSource();
//		OperatorDetails user = SecurityUserHolder.getCurrentUser();
//		
//		List<Domain> domainList = user.getDomainList();
//		for(Domain domain : domainList){
//			if(domain.getId().equals(Integer.valueOf(sourceFrom.getDomain()))){
//				source.setDomain(domain);
//				break;
//			}
//		}
//		
//		List<SysLogSourceType> sourceTypeList = sysLogSourceSer.getAllSysLogSourceType();
//		for(SysLogSourceType sourceType : sourceTypeList){
//			if(sourceType.getId().equals(Integer.valueOf(sourceFrom.getSourceType()))){
//				source.setSourceType(sourceType);
//				break;
//			}
//		}
//		
//		source.setSourceName(sourceFrom.getSourceName());
//		source.setStartCollectSwitch(sourceFrom.getStartCollectSwitch());
//		source.setLogSourceseQuence(UUID.randomUUID().toString());
//		source.setCreateTime(new Timestamp(new Date().getTime()));
//		source.setDeviceIP(sourceFrom.getDeviceIP());
//		
//		sysLogSourceSer.addSysLogSource(source);
//		
////		清空ActionForm的缓存，清掉上次页面的自动填写。
////		if(mapping.getAttribute()!=null){  
////			if("request".equals(mapping.getScope())){  
////				request.removeAttribute(mapping.getAttribute());  
////			}else{
////				request.getSession().removeAttribute(mapping.getAttribute());
////			}
////		}
//		
//		//设置防止重复提交的令牌 
////		saveToken(request); 
//		
//		from.reset(mapping, request);
//
//		return this.getSysLogSource(mapping, from, request, response);
		return null;
	}

	public PcSourceService getPcSourceSer() {
		return pcSourceSer;
	}

	public void setPcSourceSer(PcSourceService pcSourceSer) {
		this.pcSourceSer = pcSourceSer;
	}

	public SystemLogService getLogService() {
		return logService;
	}

	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
	
}
