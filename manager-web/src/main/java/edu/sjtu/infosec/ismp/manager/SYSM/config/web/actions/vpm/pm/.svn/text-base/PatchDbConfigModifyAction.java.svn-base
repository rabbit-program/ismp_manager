package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.vpm.pm;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDb;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigDbService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.vpm.pm.PatchDbConfigForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class PatchDbConfigModifyAction extends Action {
	private static Logger logger = Logger.getLogger(PatchDbConfigModifyAction.class);
	

	private SysConfigDbService sysConfigDbService;
	public void setSysConfigDbService(SysConfigDbService sysConfigDbService) {
		this.sysConfigDbService = sysConfigDbService;
	}

	private SystemLogService systemlogService;
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

    	String toPage = "success";
    	//添加日志
 		OperatorDetails user = SecurityUserHolder.getCurrentUser();
 		SystemLog log = new SystemLog();
 		log.setUsername(user.getUsername());
 		List<Role> list=user.getRoleList();
 		String roles="";
 		for(Role role:list){
 			roles+=role.getName()+",";
 		}
 		log.setRoleName(roles.substring(0,roles.length()-1));
 		log.setTime(new Timestamp(new Date().getTime()));
 		log.setModuleName(SystemModelInfo.MOD_SYSM_config);
		try{
			PatchDbConfigForm patchForm = (PatchDbConfigForm)form;
			
			SysConfigDb wsus = sysConfigDbService.findByName("wsus");
			if(wsus!=null){
				wsus.setDbUrl(patchForm.getDbUrl());
				wsus.setDbDriver(patchForm.getDbDriver());
				wsus.setUsername(patchForm.getUsername());
				wsus.setPassword(patchForm.getPassword());
				sysConfigDbService.update(wsus);
				request.setAttribute("message", "修改补丁信息成功");
				log.setOperationDesc("系统管理模块平台配置,修改补丁信息");
			}else{
				wsus = new SysConfigDb();
				wsus.setName("wsus");
				wsus.setDbUrl(patchForm.getDbUrl());
				wsus.setDbDriver(patchForm.getDbDriver());
				wsus.setUsername(patchForm.getUsername());
				wsus.setPassword(patchForm.getPassword());
				sysConfigDbService.add(wsus);
				request.setAttribute("message", "新增补丁信息成功");
				log.setOperationDesc("系统管理模块平台配置,新增补丁信息");
			}
			request.setAttribute("wsus", wsus);
			SysConfigDb rav = sysConfigDbService.findByName("rav");
			if(rav!=null){
				request.setAttribute("rav", rav);
			}
			log.setControl("成功");
		}catch(Exception e){
			toPage = "failed";
			request.setAttribute("message", "补丁信息操作失败");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			e.printStackTrace();
		}
		systemlogService.saveSystemLog(log);
		return mapping.findForward(toPage);
	}
}
