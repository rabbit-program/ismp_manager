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

import edu.sjtu.infosec.ismp.manager.BSAM.model.Machine;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinet;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineRoom;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineCabinetService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineRoomService;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineService;
import edu.sjtu.infosec.ismp.manager.BSAM.web.form.MachineForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class MachineAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(MachineAction.class); 
	
	/**
	 * 注入 service 接口
	 */
	private MachineService machineService;
	
	private MachineCabinetService machineCabinetService;
	
	private MachineRoomService machineRoomService;
	
	private DomainService domainService;
	
	private SystemLogService systemLogService;
	
	public void setMachineService(MachineService machineService) {
		this.machineService = machineService;
	}
	
	public void setMachineCabinetService(MachineCabinetService machineCabinetService) {
		this.machineCabinetService = machineCabinetService;
	}
	
	public void setMachineRoomService(MachineRoomService machineRoomService) {
		this.machineRoomService = machineRoomService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	///获取主机列表
	public  ActionForward getMachineList (ActionMapping mapping,ActionForm form,
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
			
			// 分页定义的相关的基本信息
			String cp = (request.getParameter("currPage") == null) ? "1" : request.getParameter("currPage");
			if (null != cp && !cp.equals("")) {
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage - 1) * maxResult;
			if (startResult < 0) {
				startResult = 0;
			}
			
			//数据相关的基本信息
			List<Machine> machineList = new ArrayList<Machine>();
			
			//分页定义的相关的基本信息
			if(isAll.equals("1")){
				totalNum = machineService.getCount();
			}else{
				totalNum = machineService.getCountByDomain(userDomainList);
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
				machineList = machineService.getMachineList(startResult, maxResult);
			}else{
				machineList = machineService.getMachineListByDomain(userDomainList, startResult, maxResult);
			}
			
			request.setAttribute("machineList", machineList);
		} catch (Exception e) {
			logger.debug("主机列表出错啦！");
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		
		request.setAttribute("situationMenu", "config");
		return mapping.findForward("machineList");
	}
	
	//删除主机
	public ActionForward machineDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));
        
		String id = request.getParameter("id");
		
		Machine machine = machineService.getMachineById(Integer.parseInt(id));
		if(null != machine){///用此种方法解决重复提交问题
			machineService.deleteMachineById(Integer.parseInt(id));
			
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
			systemLog.setOperationDesc("态势感知模块：删除主机。主机ID:" + id);
			systemLog.setControl("成功");
			systemLogService.saveSystemLog(systemLog);
			/** 添加日志结束 **/
		}
		
		return getMachineList(mapping, form, request, response);
	}
	///录入
	public  ActionForward machineInput(ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		saveToken(request);///创建一个新的令牌值，将其保存在当前的会话（session）范围内
		String isAll = request.getParameter("isAll");
		String currPage = request.getParameter("currPage");
		
	    String id = request.getParameter("id");
	    if(null != id){
	    	Machine machine = machineService.getMachineById(new Integer(id));
	    	request.setAttribute("machine", machine);
	    }
	    
	    List<Domain> userDomainList = SecurityUserHolder.getCurrentUser().getDomainList();
	    
	    List machineCabinetList = machineCabinetService.getMachineCabinetListByDomain(userDomainList);
	    List machineRoomList = machineRoomService.getMachineRoomListByDomain(userDomainList);
	    
		
	    request.setAttribute("machineCabinetList", machineCabinetList);///机柜列表
	    request.setAttribute("machineRoomList", machineRoomList);///机房列表
	    request.setAttribute("userDomainList", userDomainList);///用户域列表

	    request.setAttribute("isAll", isAll);
		request.setAttribute("currPage", currPage);
	    request.setAttribute("situationMenu", "config");
	    return mapping.findForward("machineInput");
	}
	
	///更新或者添加主机
	public  ActionForward machineSaveOrUpdate(ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));
		
	    if(isTokenValid(request, true)){
		   Machine machine = new Machine();
		   BeanUtils.copyProperties(machine, (MachineForm) form);
		   MachineForm machineForm = (MachineForm) form;
		   
		   if(null != machineForm.getParentType() && !"".equals(machineForm.getParentType())){
			   if("JiGui".equals(machineForm.getParentType())){///如果上级物理位置是机柜
				   if(null != machineForm.getMachineCabinetId() && !"".equals(machineForm.getMachineCabinetId())){
					   MachineCabinet machineCabinet = machineCabinetService.getMachineCabinetById(machineForm.getMachineCabinetId());
					   machine.setMachineCabinet(machineCabinet);
				   }
			   }else if("JiFang".equals(machineForm.getParentType())){///如果上级物理位置是机房
				   if(null != machineForm.getMachineRoomId() && !"".equals(machineForm.getMachineRoomId())){
					   MachineRoom machineRoom = machineRoomService.getMachineRoomById(machineForm.getMachineRoomId());
					   machine.setMachineRoom(machineRoom);
				   }
			   }else if("AnQuanYu".equals(machineForm.getParentType())){///如果上级物理位置是安全域
				   if(null != machineForm.getSecurityAreaId() && !"".equals(machineForm.getSecurityAreaId())){
					   Domain domain = domainService.findById(machineForm.getSecurityAreaId());
					   machine.setDomain(domain);
				   }
			   }
		   }
		   String flag = "update";
		   if(null == machine.getId()){
			   flag = "add";
		   }else  if(0 == machine.getId()){
			   flag = "add";
			   machine.setId(null);
		   }
		   machineService.saveOrUpdate(machine);
		   
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
		   	   systemLog.setOperationDesc("态势感知模块：新建主机。主机名称:" + machine.getMachineName());
		   }else {
		   	   systemLog.setOperationDesc("态势感知模块：修改主机。主机ID:" + machine.getId());
		   }
		   systemLog.setControl("成功");
		   systemLogService.saveSystemLog(systemLog);
		   /** 添加日志结束 **/
		 }else{
			 saveToken(request); 
		 }
	    
		 return getMachineList(mapping, form, request, response);
	}
	
	///获取权重前20名的主机
	public  ActionForward getTopMachineListByWeight (ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		try {
			String isAll = (request.getParameter("isAll") == null) ? "0" : request.getParameter("isAll");
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(null != user){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			
			//数据相关的基本信息
			List<Machine> topMachineListByWeight = new ArrayList<Machine>();
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				topMachineListByWeight = machineService.getTopMachineListByWeight(20);
			}else{
				topMachineListByWeight = machineService.getTopMachineListByWeightByDomain(userDomainList, 20);
			}
			request.setAttribute("topMachineListByWeight", topMachineListByWeight);
		} catch (Exception e) {
			logger.debug("主机权重前20列表出错啦！");
			e.printStackTrace();
		}
		request.setAttribute("situationMenu", "topWeight");
		return mapping.findForward("topMachineListByWeight");
	}
	
}
