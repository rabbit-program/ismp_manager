package edu.sjtu.infosec.ismp.manager.BSAM.web.actions;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.BSAM.model.ColorThreshold;
import edu.sjtu.infosec.ismp.manager.BSAM.service.ColorThresholdService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Role;

public class ColorThresholdAction extends DispatchAction {
	
	private ColorThresholdService colorThresholdService;
	
	private SystemLogService systemLogService;
	
	public ColorThresholdService getColorThresholdService() {
		return colorThresholdService;
	}

	public void setColorThresholdService(ColorThresholdService colorThresholdService) {
		this.colorThresholdService = colorThresholdService;
	}
	
	public SystemLogService getSystemLogService() {
		return systemLogService;
	}

	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	@SuppressWarnings("unchecked")
	public  ActionForward colorThresholdInput(ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response) throws Exception {
		
			List list = colorThresholdService.getColorThresholdList();
			request.setAttribute("colorThresholdList", list);
		    request.setAttribute("greenColorThreshold", list.get(0));
		    request.setAttribute("yellowColorThreshold", list.get(1));
		    request.setAttribute("situationMenu", "config");
		    return mapping.findForward("colorThresholdInput");
	}
	
	public  ActionForward colorThresholdUpdate(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		    String greenValue = (String) request.getParameter("greenValue");
		    String yellowValue = (String) request.getParameter("yellowValue");
		    
		    ColorThreshold colorThreshold = colorThresholdService.getColorThresholdByColor("green");
		    colorThreshold.setValue(new Integer(greenValue));
		    colorThresholdService.saveOrUpdate(colorThreshold);///更新绿色的颜色阈值
		    
		    colorThreshold = colorThresholdService.getColorThresholdByColor("yellow");
		    colorThreshold.setValue(new Integer(yellowValue));
		    colorThresholdService.saveOrUpdate(colorThreshold);///更新黄色的颜色阈值
		    
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
			systemLog.setOperationDesc("态势感知模块：修改颜色阈值。");
			systemLog.setControl("成功");
			systemLogService.saveSystemLog(systemLog);
			/** 添加日志结束 **/
		    
		    return mapping.findForward("colorThresholdUpdate");
	}
	
}
