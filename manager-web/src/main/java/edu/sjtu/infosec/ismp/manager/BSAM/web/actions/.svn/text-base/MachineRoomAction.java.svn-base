package edu.sjtu.infosec.ismp.manager.BSAM.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineRoomService;
import edu.sjtu.infosec.ismp.manager.BSAM.web.form.MachineRoomForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;


public class MachineRoomAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(MachineRoomAction.class); 
	
	/**
	 * 注入 service 接口
	 */
	private MachineRoomService machineRoomService;
	
	private DomainService domainService;
	
	private SystemLogService systemLogService;
	
	public MachineRoomService getMachineRoomService() {
		return machineRoomService;
	}
	
	public void setMachineRoomService(MachineRoomService machineRoomService) {
		this.machineRoomService = machineRoomService;
	}
	
	public DomainService getDomainService() {
		return domainService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	public SystemLogService getSystemLogService() {
		return systemLogService;
	}

	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	///获取机房列表
	@SuppressWarnings("unchecked")
	public  ActionForward getMachineRoomList(ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response) throws Exception {
		
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
			List<MachineRoom> machineRoomList = new ArrayList<MachineRoom>();
			
			//分页定义的相关的基本信息
			if(isAll.equals("1")){
				totalNum = machineRoomService.getCount();
			}else{
				totalNum = machineRoomService.getCountByDomain(userDomainList);
			}
			totalPage = Math.ceil((double) totalNum / maxResult);
			if (totalPage > 0 && currPage <= 0) {
				currPage = 1;
			}
			
			///当前页没有数据之后返回到上一页(删除当前页全部记录的时候)
			if (currPage > totalPage) {
				currPage = totalPage.intValue();
				startResult = (currPage - 1) * maxResult;
				if (startResult < 0) {
					startResult = 0;
				}
			}
			
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				machineRoomList = machineRoomService.getMachineRoomList(startResult, maxResult);
			}else{
				machineRoomList = machineRoomService.getMachineRoomListByDomain(userDomainList,startResult, maxResult);
			}
			
			request.setAttribute("machineRoomList", machineRoomList);
		} catch (Exception e) {
			logger.debug("机房列表出错啦！");
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		request.setAttribute("situationMenu", "config");
		return mapping.findForward("machineRoomList");
	}
	
	//删除机房
	public  ActionForward machineRoomDelete(ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));
		
		String id = request.getParameter("id");
		
		MachineRoom machineRoom = machineRoomService.getMachineRoomById(Integer.parseInt(id));
		if(null != machineRoom){///用此种方法解决重复提交问题
			machineRoomService.deleteMachineRoomById(Integer.parseInt(id));
			
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
			systemLog.setModuleName(SystemModelInfo.MOD_BSAM);
			systemLog.setOperationDesc("态势感知模块：删除机房。机房ID:" + id);
			systemLog.setControl("成功");
			systemLogService.saveSystemLog(systemLog);
			/** 添加日志结束 **/
		}
		
		return getMachineRoomList(mapping,form,request,response);
	}
	
	///录入
	public  ActionForward machineRoomInput(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		saveToken(request);///创建一个新的令牌值，将其保存在当前的会话（session）范围内
		String isAll = request.getParameter("isAll");
		String currPage = request.getParameter("currPage");
		
		String id = request.getParameter("id");
		if(null != id){
			MachineRoom machineRoom =  machineRoomService.getMachineRoomById(Integer.parseInt(id));
			request.setAttribute("machineRoom", machineRoom);
		}
		
		List<Domain> userDomainList = SecurityUserHolder.getCurrentUser().getDomainList();
		request.setAttribute("userDomainList", userDomainList);
		
		request.setAttribute("isAll", isAll);
		request.setAttribute("currPage", currPage);
		request.setAttribute("situationMenu", "config");
		return mapping.findForward("machineRoomInput");
	}
	
	///更新或增加机房
	public  ActionForward machineRoomSaveOrUpdate(ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));
		
	    if(isTokenValid(request, true)){///检查令牌，防止重复提交
	    	MachineRoom machineRoom = new MachineRoom();
	    	BeanUtils.copyProperties(machineRoom, (MachineRoomForm)form);
	    	MachineRoomForm machineRoomForm = (MachineRoomForm)form;
        	
        	if(null != machineRoomForm.getSecurityAreaId() && !"".equals(machineRoomForm.getSecurityAreaId())){
        		Domain domain = domainService.findById(machineRoomForm.getSecurityAreaId());
        		machineRoom.setDomain(domain);
        	}
	    	String flag = "update";
	    	if(null == machineRoom.getId()){
	    		flag = "add";
	    	}else if(0 == machineRoom.getId()){
	    		flag = "add";
	    		machineRoom.setId(null);
	    	}
	    	machineRoomService.saveOrUpdate(machineRoom);
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
			systemLog.setModuleName(SystemModelInfo.MOD_BSAM);
			if("add".equals(flag)){
				systemLog.setOperationDesc("态势感知模块：新建机房。机房名称:" + machineRoom.getMachineRoomName());
			}else {
				systemLog.setOperationDesc("态势感知模块：修改机房。机房ID:" + machineRoom.getId());
			}
			systemLog.setControl("成功");
			systemLogService.saveSystemLog(systemLog);
			/** 添加日志结束 **/
		}else{
			saveToken(request);
		}
	    
	    return getMachineRoomList(mapping,form,request,response);
	}
	
}
