package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.lm.dLog;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSourceType;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.SnmpTrapSourceService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.lm.dLog.SnmpTrapSourceFrom;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

/**
 * 处理SnmpTrap日志的查询、新增
 * @author 林超
 *
 */
public class SnmpTrapConfigAction extends DispatchAction {
	
	private SnmpTrapSourceService snmpTrapSourceSer;
	private TopoWebService topoWebService;
	private SystemLogService logService;
	private java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
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
			
			
			request.getSession().setAttribute("configSnmpTrapSourceListQuery_domain", domain);
			request.getSession().setAttribute("configSnmpTrapSourceListQuery_sysLogSource", snmpTrapSource);
		}
		
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<SnmpTrapSource> snmpTrapSourceList = snmpTrapSourceSer.getAllSnmpTrapSource((SnmpTrapSource)request.getSession().getAttribute("configSnmpTrapSourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("configSnmpTrapSourceListQuery_domain"), (pageBean.getPageNo()-1)*pageBean.getPageRowNum(), pageBean.getPageRowNum());
		pageBean.setResultRowSum(snmpTrapSourceSer.getAllSnmpTrapSourceCount((SnmpTrapSource)request.getSession().getAttribute("configSnmpTrapSourceListQuery_sysLogSource"), (List<Domain>) request.getSession().getAttribute("configSnmpTrapSourceListQuery_domain")));
		
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
		
		return mapping.findForward("snmpTrapSourceDisplay");
	}

	/**
	 * 初始化 SnmpTrapSourceType
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initSnmpTrapSourceType(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		List<SnmpTrapSourceType> sourceTypeList = snmpTrapSourceSer.getAllSnmpTrapSourceType();

		request.setAttribute("domainList", user.getDomainList());
		request.setAttribute("sourceTypeList", sourceTypeList);
		
		return mapping.findForward("snmpTrapSourceType");
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
	public ActionForward delSnmpTrapSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sourceId = request.getParameter("id");
		String startCollectSwitch = request.getParameter("startCollect");
		
		SnmpTrapSource snmpTrapSource = new SnmpTrapSource();
		snmpTrapSource.setId(Integer.valueOf(sourceId));
		snmpTrapSource.setStartCollectSwitch(Boolean.valueOf(startCollectSwitch));
		
		OperatorDetails eventLogClass = SecurityUserHolder.getCurrentUser();
		
		logService.saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "日志模块", 
				"删除 SnmpTrap 日志源", Timestamp.valueOf(sdf.format(new Date())), "成功");
		
		snmpTrapSourceSer.delSnmpTrapSource(snmpTrapSource,topoWebService);
		
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
	public ActionForward updateSnmpTrapSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String sourceId = request.getParameter("id");
		String startCollectSwitch = request.getParameter("startCollect");
		
		SnmpTrapSource snmpTrapSource = snmpTrapSourceSer.loadObject(sourceId);
		snmpTrapSource.setStartCollectSwitch(Boolean.valueOf(startCollectSwitch));
		
		OperatorDetails eventLogClass = SecurityUserHolder.getCurrentUser();
		
		logService.saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "日志模块", 
				"修改 SnmpTrap 日志源", Timestamp.valueOf(sdf.format(new Date())), "成功");
		
		snmpTrapSourceSer.updateSnmpTrapSource(snmpTrapSource);
		return mapping.findForward("getSource");
	}
	
	/**
	 *      SnmpTrap日志的 新增
	 * @param mapping
	 * @param from
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addSnmpTrapSource(ActionMapping mapping, ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SnmpTrapSourceFrom sourceFrom = (SnmpTrapSourceFrom) from;
		SnmpTrapSource source = new SnmpTrapSource();
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		
		List<Domain> domainList = user.getDomainList();
		for(Domain domain : domainList){
			if(domain.getId().equals(Integer.valueOf(sourceFrom.getDomain()))){
				source.setDomain(domain);
				break;
			}
		}
		
		List<SnmpTrapSourceType> sourceTypeList = snmpTrapSourceSer.getAllSnmpTrapSourceType();
		for(SnmpTrapSourceType sourceType : sourceTypeList){
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
		source.setCreateTime(new Timestamp(new Date().getTime()));
		source.setDeviceIP(sourceFrom.getDeviceIP());
		
		OperatorDetails eventLogClass = SecurityUserHolder.getCurrentUser();
		
		logService.saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "日志模块", 
				"新增 SnmpTrap 日志源", Timestamp.valueOf(sdf.format(new Date())), "成功");
		
		snmpTrapSourceSer.addSnmpTrapSource(source);
		
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

		return this.getSnmpTrapSource(mapping, from, request, response);
	}

	public SnmpTrapSourceService getSnmpTrapSourceSer() {
		return snmpTrapSourceSer;
	}

	public void setSnmpTrapSourceSer(SnmpTrapSourceService snmpTrapSourceSer) {
		this.snmpTrapSourceSer = snmpTrapSourceSer;
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
