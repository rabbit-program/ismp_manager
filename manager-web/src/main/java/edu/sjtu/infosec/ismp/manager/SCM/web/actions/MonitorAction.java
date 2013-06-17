package edu.sjtu.infosec.ismp.manager.SCM.web.actions;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.scm.service.ServiceMonitor;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SCM.comm.Constants;
import edu.sjtu.infosec.ismp.manager.SCM.model.Monitor;
import edu.sjtu.infosec.ismp.manager.SCM.service.MonitorService;
import edu.sjtu.infosec.ismp.manager.SCM.web.form.MonitorForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class MonitorAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(MonitorAction.class); 
	
	/**
	 * 注入 service 接口
	 */
	private MonitorService monitorService;
	
	private DomainService domainService;
	
	private ServiceMonitor monitorServiceClient;
	
	private TopoWebService topoWebService;
	
	private SystemLogService systemLogService;
	
	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
		
	public void setMonitorServiceClient(ServiceMonitor monitorServiceClient) {
		this.monitorServiceClient = monitorServiceClient;
	}
	
	public void setTopoWebService(TopoWebService topoWebService) {
		this.topoWebService = topoWebService;
	}
	
	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	public ActionForward changeDisplay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		form.reset(mapping, request);
		
		OperatorDetails user = SecurityUserHolder.getCurrentUser();///获取当前用户                                                                                                                                                                                                                                                                                                                                                                                                            
		List<Domain> userDomainList = new ArrayList<Domain>();
		if(null != user){
			userDomainList = user.getDomainList();
		}else{
			userDomainList = null;
		}
		String type = request.getParameter("type");
		request.setAttribute("monitorType", type);
		request.setAttribute("userDomainList", userDomainList);
		return mapping.findForward("monitorInput");
	}
	
	///点击左导航（服务检测）
	public ActionForward getMonitorList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		form.reset(mapping, request);
		
		int currPage = 1;
		Double totalPage = 0d;
		int totalNum = 0;
		int startResult = 0;
		int maxResult = 5;
		
		try {
			String isAll = (request.getParameter("isAll") == null) ? "0" : request.getParameter("isAll");
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(null != user){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			
			//分页定义的相关的基本信息
			String cp = (request.getParameter("currPage") == null) ? "1" : request.getParameter("currPage");
			if (cp != null && !cp.equals("")) {
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage - 1) * maxResult;
			if(startResult < 0){
				startResult = 0;
			}
			
			//数据相关的基本信息
			List<Monitor> monitorList = new ArrayList<Monitor>();
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				monitorList = monitorService.getMonitorList(startResult, maxResult);
			}else{
				monitorList = monitorService.getMonitorListByDomain(userDomainList, startResult, maxResult);
			}
			
			List<String> nodeList = new ArrayList<String>();
			if(null != monitorList){
				for(Monitor monitor:monitorList){
					nodeList.add(monitor.getNodeId());
				}
			}
			request.setAttribute("nodeIdList", nodeList);
			
			//分页定义的相关的基本信息
			if(isAll.equals("1")){
				totalNum = monitorService.getCount();
			}else{
				totalNum = monitorService.getCountByDomain(userDomainList);
			}
			totalPage = Math.ceil((double) totalNum / maxResult);
			if (totalPage > 0 && currPage <= 0) {
				currPage = 1;
			}
			
			request.setAttribute("monitorList", monitorList);
		} catch (Exception e) {
			logger.debug("机房列表出错啦！");
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		return mapping.findForward("monitorList");
	}
	
	public ActionForward monitorInput(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		saveToken(request);///创建一个新的令牌值，将其保存在当前的会话（session）范围内
		MonitorForm monitorForm = (MonitorForm) form;
		monitorForm.reset();
		String isAll = request.getParameter("isAll");
		String currPage = request.getParameter("currPage");
		
		String id = request.getParameter("id");
		if(null != id){///id不为空说明是更新前
			Monitor monitor = monitorService.getMonitorById(Integer.parseInt(id));
			if(null != monitor){
				request.setAttribute("monitorType", monitor.getType());
				request.setAttribute("monitor", monitor);
			}
		}else{///id为空说明是增加前
			request.setAttribute("monitorType", "UDP");///默认首先显示的是UDP
		}
		
		List<Domain> userDomainList = SecurityUserHolder.getCurrentUser().getDomainList();
		request.setAttribute("userDomainList", userDomainList);
		request.setAttribute("isAll", isAll);
		request.setAttribute("currPage", currPage);
		return mapping.findForward("monitorInput");
	}
	
	///增加或更新监控机
	public ActionForward monitorSaveOrUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));
		
        if(isTokenValid(request, true)){///检查令牌，防止重复提交
        	Monitor monitor = new Monitor();
        	BeanUtils.copyProperties(monitor, (MonitorForm)form);
        	MonitorForm monitorForm = (MonitorForm)form;
        	
        	if(null != monitorForm.getDomainId() && !"".equals(monitorForm.getDomainId())){
        		Domain domain = domainService.findById(monitorForm.getDomainId());
        		monitor.setDomain(domain);
        	}
        	
        	String[] weekcheck = monitorForm.getWeekcheck();///获取周检测取值
        	StringBuffer tempweekcheck = new StringBuffer();
        	if(null != weekcheck && weekcheck.length > 0){///解析数组，将周检测时间组成字符串，用","分隔入库。
        		for (int i = 0; i < weekcheck.length; i++) {
        			if(i != (weekcheck.length -1) ){
        				tempweekcheck.append(weekcheck[i] + ",");
        			}else{
        				tempweekcheck.append(weekcheck[i]);
        			}
				}
        		monitor.setWeekcheck(tempweekcheck.toString());
        	}
        	String flag = "update";
        	if(null == monitor.getId() || monitor.getId() <= 0){///增加
//        		monitor.setId(null);
        		flag = "add";
        		monitor.setCreateTime(new Timestamp(new Date().getTime()));///创建时间
        		
        		
        		//从后台获取nodeId
        		NodeEntity nodeEntity = new NodeEntity();
        		nodeEntity.setNodeStyle(1);
        		topoWebService.saveOrUpdateNode(nodeEntity);
        		String nodeId = nodeEntity.getNodeId();
        		nodeId = nodeId.trim();
        		
        		monitor.setNodeId(nodeId);///从拓扑那里取得
        		
        		HashMap<String, String> hashMap = new HashMap<String, String>();
        		String tempSubType = monitorForm.getSubType().toLowerCase();
        		if("dns".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
            		hashMap.put("lookup", monitorForm.getIp());
        		}else if("ftp".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("userid", monitorForm.getUserid());
            		hashMap.put("password", monitorForm.getPassword());
        		}else if("http".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("url", monitorForm.getUrl());
        		}else if("https".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("url", monitorForm.getUrl());
        		}else if("icmp".equals(tempSubType)){
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}else if("imap".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}else if("smtp".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}else if("pop3".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}
        		try {
        			
//        			public void registerServiceMonitor(String domain,String nodeid,String serviceType,
//        			String ipAddr,long interval,Map<String,String> parameters);
        			
        			/** 调用后台接口注册监控项 **/
        			if(!"smtp".equals(tempSubType) && !"imap".equals(tempSubType) && !"pop3".equals(tempSubType) ){
//        				monitorServiceClient.registerServiceMonitor(monitorForm.getDomainId()+"", nodeId,monitorForm.getSubType().toLowerCase(),
//        						monitorForm.getIp(), monitorForm.getIntervalTime()*1000, hashMap);
        				monitorServiceClient.registerServiceMonitor(monitorForm.getDomainId()+"", nodeId,monitorForm.getSubType().toLowerCase(),
                				monitorForm.getIp(), monitorForm.getIntervalTime()*1000, hashMap);
        			}else {
        				monitorServiceClient.registerServiceMonitor(monitorForm.getDomainId()+"", nodeId,monitorForm.getSubType().toLowerCase(),
                				monitorForm.getUrl(), monitorForm.getIntervalTime()*1000, hashMap);
//        				monitorServiceClient.registerServiceMonitor(monitorForm.getDomainId()+"", nodeId,monitorForm.getSubType().toLowerCase(),
//                				monitorForm.getUrl(), monitorForm.getIntervalTime()*1000, hashMap);
        			}
//        			else if("pop3".equals(tempSubType) ){
//        				monitorServiceClient.registerServiceMonitor("testDomain", nodeId,monitorForm.getSubType().toLowerCase(),
//                				monitorForm.getUrl(), monitorForm.getIntervalTime()*1000, hashMap);
////        				monitorServiceClient.registerServiceMonitor(monitorForm.getDomainId()+"", nodeId,monitorForm.getSubType().toLowerCase(),
////                				monitorForm.getUrl(), monitorForm.getIntervalTime()*1000, hashMap);
//        			}
        			
				} catch (Exception e) {
					logger.error("后台注册失败！！");
//					e.printStackTrace();
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=UTF-8");
					out.println("<script language=\"javascript\">");
					out.println("window.opener.location.reload();");
					out.println("alert('后台注册失败！！');");
					out.println("window.close();");
					out.println("</script>");
					out.close();
					
					/** 添加日志开始 **/
					SystemLog systemLog = new SystemLog();
					systemLog.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
					List<Role> roleList = SecurityUserHolder.getCurrentUser().getRoleList();
					StringBuffer roles = new StringBuffer("");
					
					for(Role role:roleList){
						roles.append(role.getName());
						roles.append(",");
					}
					systemLog.setRoleName(roles.substring(0,roles.length()-1));
					systemLog.setTime(new Timestamp(new Date().getTime()));
					systemLog.setModuleName(SystemModelInfo.MOD_SCM);
					systemLog.setOperationDesc("服务检测模块：注册监控项。监控项名称:" + monitor.getName());
					systemLog.setControl("失败");
					systemLogService.saveSystemLog(systemLog);
					/** 添加日志结束 **/
					
					return null;
				}
	    	}else {///更新
	    		Monitor oldMonitor = monitorService.getMonitorById(monitor.getId());
	    		monitor.setCreateTime(oldMonitor.getCreateTime());
	    		monitor.setNodeId(oldMonitor.getNodeId());
	    		
	    		HashMap<String, String> hashMap = new HashMap<String, String>();
	    		
	    		String tempSubType = monitorForm.getSubType().toLowerCase();
        		if("dns".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
            		hashMap.put("lookup", monitorForm.getIp());
        		}else if("ftp".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("userid", monitorForm.getUserid());
            		hashMap.put("password", monitorForm.getPassword());
        		}else if("http".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("url", monitorForm.getUrl());
        		}else if("https".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("url", monitorForm.getUrl());
        		}else if("icmp".equals(tempSubType)){
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}else if("imap".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}else if("smtp".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}else if("pop3".equals(tempSubType)){
        			hashMap.put("port", monitorForm.getPort());
        			hashMap.put("retry", monitorForm.getRetry() + "");
        			hashMap.put("timeout", monitorForm.getTimeout()*1000 + "");
        		}
	    		
        		try {
        			/** 调用后台接口更新监控项(先删除再重新注册) **/
        			monitorServiceClient.removeServiceMonitor(monitor.getNodeId());
        			if(!"smtp".equals(tempSubType) && !"imap".equals(tempSubType) && !"pop3".equals(tempSubType) ){
//        				monitorServiceClient.registerServiceMonitor(monitor.getDomain().getId()+"", monitor.getNodeId(),monitorForm.getSubType().toLowerCase(),
//        						monitorForm.getIp(), monitorForm.getIntervalTime()*1000, hashMap);
        				monitorServiceClient.registerServiceMonitor(monitorForm.getDomainId()+"", monitor.getNodeId(),monitorForm.getSubType().toLowerCase(),
                				monitorForm.getIp(), monitorForm.getIntervalTime()*1000, hashMap);
        			}else {
//        				monitorServiceClient.registerServiceMonitor(monitor.getDomain().getId()+"", monitor.getNodeId(),monitorForm.getSubType().toLowerCase(),
//        						monitorForm.getUrl(), monitorForm.getIntervalTime()*1000, hashMap);
        				monitorServiceClient.registerServiceMonitor(monitorForm.getDomainId()+"", monitor.getNodeId(),monitorForm.getSubType().toLowerCase(),
                				monitorForm.getUrl(), monitorForm.getIntervalTime()*1000, hashMap);
        			}
				} catch (Exception e) {
					logger.error("后台更新失败！！");
//					e.printStackTrace();
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=UTF-8");
					out.println("<script language=\"javascript\">");
					out.println("window.opener.location.reload();");
					out.println("alert('后台更新失败！！');");
					out.println("window.close();");
					out.println("</script>");
					out.close();
					
					/** 添加日志开始 **/
					SystemLog systemLog = new SystemLog();
					systemLog.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
					List<Role> roleList = SecurityUserHolder.getCurrentUser().getRoleList();
					StringBuffer roles = new StringBuffer("");
					
					for(Role role:roleList){
						roles.append(role.getName());
						roles.append(",");
					}
					systemLog.setRoleName(roles.substring(0,roles.length()-1));
					systemLog.setTime(new Timestamp(new Date().getTime()));
					systemLog.setModuleName(SystemModelInfo.MOD_SCM);
					systemLog.setOperationDesc("服务检测模块：更新监控项。监控项名称:" + monitor.getName());
					systemLog.setControl("失败");
					systemLogService.saveSystemLog(systemLog);
					/** 添加日志结束 **/
					return null;
				}
	    	}
        	monitorService.saveOrUpdateMonitor(monitor);
        	
        	/** 添加日志开始 **/
			SystemLog systemLog = new SystemLog();
			systemLog.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
			List<Role> roleList = SecurityUserHolder.getCurrentUser().getRoleList();
			StringBuffer roles = new StringBuffer("");
			
			for(Role role:roleList){
				roles.append(role.getName());
				roles.append(",");
			}
			systemLog.setRoleName(roles.substring(0,roles.length()-1));
			systemLog.setTime(new Timestamp(new Date().getTime()));
			systemLog.setModuleName(SystemModelInfo.MOD_SCM);
			if("add".equals(flag)){
				systemLog.setOperationDesc("服务检测模块：新建监控项。监控项名称:" + monitor.getName());
			}else {
				systemLog.setOperationDesc("服务检测模块：修改监控项。监控项ID:" + monitor.getId());
			}
			systemLog.setControl("成功");
			systemLogService.saveSystemLog(systemLog);
			/** 添加日志结束 **/
        	
        	monitorForm.reset();
        }else{
			saveToken(request);
		}
       
		request.setAttribute("monitorType", request.getParameter("type"));
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		out.println("<script language=\"javascript\">");
		out.println("window.opener.location.reload();");
		out.println("window.close();");
		out.println("</script>");
		out.close();
		return null;
	}
	
	///删除监控项
	public ActionForward monitorDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));
		
		String id = request.getParameter("id");
		
		Monitor monitor = monitorService.getMonitorById(Integer.parseInt(id));
		
		String flag = "success";
		
		if (null != monitor) {
			try {
				/** 调用后台接口删除监控项 **/
    			monitorServiceClient.removeServiceMonitor(monitor.getNodeId());
			} catch (Exception e) {
				logger.error("后台删除失败！！");
				flag = "fail";			
				/** 添加日志开始 **/
				SystemLog systemLog = new SystemLog();
				systemLog.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
				List<Role> roleList = SecurityUserHolder.getCurrentUser().getRoleList();
				StringBuffer roles = new StringBuffer("");
				
				for(Role role:roleList){
					roles.append(role.getName());
					roles.append(",");
				}
				systemLog.setRoleName(roles.substring(0,roles.length()-1));
				systemLog.setTime(new Timestamp(new Date().getTime()));
				systemLog.setModuleName(SystemModelInfo.MOD_SCM);
				systemLog.setOperationDesc("服务检测模块：后台删除监控项。监控项名称:" + monitor.getName());
				systemLog.setControl("失败");
				systemLogService.saveSystemLog(systemLog);
				/** 添加日志结束 **/
//				e.printStackTrace();
			}
			if(flag != "fail"){
				monitorService.deleteMonitorById(Integer.parseInt(id));
				
				/** 添加日志开始 **/
				SystemLog systemLog = new SystemLog();
				systemLog.setUsername(SecurityUserHolder.getCurrentUser().getUsername());
				List<Role> roleList = SecurityUserHolder.getCurrentUser().getRoleList();
				StringBuffer roles = new StringBuffer("");
				
				for(Role role:roleList){
					roles.append(role.getName());
					roles.append(",");
				}
				systemLog.setRoleName(roles.substring(0,roles.length()-1));
				systemLog.setTime(new Timestamp(new Date().getTime()));
				systemLog.setModuleName(SystemModelInfo.MOD_SCM);
				systemLog.setOperationDesc("服务检测模块：删除监控项。监控项ID:" + id);
				systemLog.setControl("成功");
				systemLogService.saveSystemLog(systemLog);
				/** 添加日志结束 **/
			}
		}
		
		return getMonitorList(mapping, form, request, response);
	}
	
	//查看详细信息
	public ActionForward monitorDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		String id = request.getParameter("id");
		if(null != id){
			Monitor monitor = monitorService.getMonitorById(Integer.parseInt(id));
			request.setAttribute("monitor", monitor);
			
		}
		return mapping.findForward("monitorDetail");
	}
	///跳转到修改页面
	public ActionForward toUpdateMonitorJsp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		saveToken(request);///创建一个新的令牌值，将其保存在当前的会话（session）范围内
		MonitorForm monitorForm = (MonitorForm) form;
		monitorForm.reset();
		
		String isAll = request.getParameter("isAll");
		String currPage = request.getParameter("currPage");
		
		String id = request.getParameter("id");
		if(null != id){///id不为空说明是更新前
			Monitor monitor = monitorService.getMonitorById(Integer.parseInt(id));
			if(null != monitor){
				if(null != monitor.getWeekcheck() && !"".equals(monitor.getWeekcheck())){
					String[] weekcheck = monitor.getWeekcheck().split(",");
					for (int i = 0; i < weekcheck.length; i++) {
						request.setAttribute(weekcheck[i],weekcheck[i] );
					}
				}
				request.setAttribute("monitorType", monitor.getType());
				request.setAttribute("monitor", monitor);
			}
		}else{///id为空说明是增加前
			request.setAttribute("monitorType", "UDP");///默认首先显示的是UDP
		}
		
		List<Domain> userDomainList = SecurityUserHolder.getCurrentUser().getDomainList();
		request.setAttribute("userDomainList", userDomainList);
		
		request.setAttribute("isAll", isAll);
		request.setAttribute("currPage", currPage);
		return mapping.findForward("monitorUpdate");
	}
}
