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
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSourceType;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.SysLogSourceService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.lm.dLog.SysLogSourceFrom;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

/**
 * 处理SysLog日志的查询、新增
 * @author 林超
 *
 */
public class SysLogConfigAction extends DispatchAction {
	
	private SysLogSourceService sysLogSourceSer;
	private SystemLogService logService;
	private java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private TopoWebService topoWebService;
	/**
	 *      SysLog日志的 查询
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ActionForward getSysLogSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		SysLogSource sysLogSource = new SysLogSource();
		SysLogSourceFrom sysLogFrom = (SysLogSourceFrom)from;
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
			
			
			request.getSession().setAttribute("configSourceListQuery_domain", domain);
			request.getSession().setAttribute("configSourceListQuery_sysLogSource", sysLogSource);
		}
		
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<SysLogSource> sysLogSourceList = sysLogSourceSer.getAllSysLogSource((SysLogSource)request.getSession().getAttribute("configSourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("configSourceListQuery_domain"), (pageBean.getPageNo()-1)*pageBean.getPageRowNum(), pageBean.getPageRowNum());
		pageBean.setResultRowSum(sysLogSourceSer.getAllSysLogSourceCount((SysLogSource)request.getSession().getAttribute("configSourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("configSourceListQuery_domain")));
		
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
		
		return mapping.findForward("sysLogSourceDisplay");
	}

	/**
	 * 初始化 SysLogSourceType
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initSysLogSourceType(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		List<SysLogSourceType> sourceTypeList = sysLogSourceSer.getAllSysLogSourceType();

		request.setAttribute("domainList", user.getDomainList());
		request.setAttribute("sourceTypeList", sourceTypeList);
		
		return mapping.findForward("sysLogSourceType");
	}
	
	/**
	 * 删除
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delSysLogSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sourceId = request.getParameter("id");
		String startCollectSwitch = request.getParameter("startCollect");
		
		SysLogSource sysLogSource = new SysLogSource();
		sysLogSource.setId(Integer.valueOf(sourceId));
		sysLogSource.setStartCollectSwitch(Boolean.valueOf(startCollectSwitch));
		
		OperatorDetails eventLogClass = SecurityUserHolder.getCurrentUser();
		
		logService.saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "日志模块", 
				"删除 SysLog 日志源", Timestamp.valueOf(sdf.format(new Date())), "成功");
		
		sysLogSourceSer.delSysLogSource(sysLogSource,topoWebService);
		
		return mapping.findForward("getSource");
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
	public ActionForward updateSysLogSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sourceId = request.getParameter("id");
		String startCollectSwitch = request.getParameter("startCollect");
		
		SysLogSource sysLogSource = sysLogSourceSer.loadObject(sourceId);
		sysLogSource.setStartCollectSwitch(Boolean.valueOf(startCollectSwitch));
		
		OperatorDetails eventLogClass = SecurityUserHolder.getCurrentUser();
		
		logService.saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "日志模块", 
				"修改 SysLog 日志源", Timestamp.valueOf(sdf.format(new Date())), "成功");
		
		sysLogSourceSer.updateSysLogSource(sysLogSource);
		return mapping.findForward("getSource");
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
		SysLogSourceFrom sourceFrom = (SysLogSourceFrom) from;
		SysLogSource source = new SysLogSource();
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		
		List<Domain> domainList = user.getDomainList();
		if(!sourceFrom.getDomain().equals("noDomain")){
			for(Domain domain : domainList){
				if(domain.getId().equals(Integer.valueOf(sourceFrom.getDomain()))){
					source.setDomain(domain);
					break;
				}
			}
		}
		
		List<SysLogSourceType> sourceTypeList = sysLogSourceSer.getAllSysLogSourceType();
		for(SysLogSourceType sourceType : sourceTypeList){
			if(sourceType.getId().equals(Integer.valueOf(sourceFrom.getSourceType()))){
				source.setSourceType(sourceType);
				break;
			}
		}
		
		source.setSourceName(sourceFrom.getSourceName());
		source.setStartCollectSwitch(sourceFrom.getStartCollectSwitch());
		
		NodeEntity node = new NodeEntity();
		topoWebService.saveOrUpdateNode(node);
		
		source.setLogSourceseQuence(node.getNodeId());
		
//		System.out.println("-------***-----" + source.getLogSourceseQuence());
		source.setCreateTime(new Timestamp(new Date().getTime()));
		source.setDeviceIP(sourceFrom.getDeviceIP());
		
		sysLogSourceSer.addSysLogSource(source);
		
		OperatorDetails eventLogClass = SecurityUserHolder.getCurrentUser();
		
		logService.saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "日志模块", 
				"新增 SysLog 日志源", Timestamp.valueOf(sdf.format(new Date())), "成功");
		
//		清空ActionForm的缓存，清掉上次页面的自动填写。
//		if(mapping.getAttribute()!=null){  
//			if("request".equals(mapping.getScope())){  
//				request.removeAttribute(mapping.getAttribute());  
//			}else{
//				request.getSession().removeAttribute(mapping.getAttribute());
//			}
//		}
		
		//设置防止重复提交的令牌 
//		saveToken(request); 
		
		from.reset(mapping, request);

		return this.getSysLogSource(mapping, from, request, response);
	}

	public SysLogSourceService getSysLogSourceSer() {
		return sysLogSourceSer;
	}

	public void setSysLogSourceSer(SysLogSourceService sysLogSourceSer) {
		this.sysLogSourceSer = sysLogSourceSer;
	}

	public TopoWebService getTopoWebService() {
		return topoWebService;
	}

	public void setTopoWebService(TopoWebService topoWebService) {
		this.topoWebService = topoWebService;
	}

	public SystemLogService getLogService() {
		return logService;
	}

	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}

}
