package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.vpm.vm;

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
import edu.sjtu.infosec.ismp.manager.SYSM.config.web.form.vpm.vm.VirusDbConfigForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class VirusDbConfigModifyAction extends Action {
	private static Logger logger = Logger.getLogger(VirusDbConfigModifyAction.class);
	

	private SysConfigDbService sysConfigDbService;
	public void setSysConfigDbService(SysConfigDbService sysConfigDbService) {
		this.sysConfigDbService = sysConfigDbService;
	}
	
	private SystemLogService systemlogService;
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

	//病毒
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
			VirusDbConfigForm virusForm = (VirusDbConfigForm)form;
			
			SysConfigDb rav = sysConfigDbService.findByName("rav");
			if(rav!=null){
				rav.setDbUrl(virusForm.getDbUrl1());
				rav.setDbDriver(virusForm.getDbDriver1());
				rav.setUsername(virusForm.getUsername1());
				rav.setPassword(virusForm.getPassword1());
				sysConfigDbService.update(rav);
				request.setAttribute("message1", "修改病毒信息成功");
				log.setOperationDesc("系统管理模块平台配置,修改病毒信息");
			}else{
				rav = new SysConfigDb();
				rav.setName("rav");
				rav.setDbUrl(virusForm.getDbUrl1());
				rav.setDbDriver(virusForm.getDbDriver1());
				rav.setUsername(virusForm.getUsername1());
				rav.setPassword(virusForm.getPassword1());
				sysConfigDbService.add(rav);
				request.setAttribute("message1", "新增病毒信息成功");
				log.setOperationDesc("系统管理模块平台配置,新增病毒信息");
			}
			request.setAttribute("rav", rav);
			SysConfigDb wsus = sysConfigDbService.findByName("wsus");
			if(wsus!=null){
				request.setAttribute("wsus", wsus);
			}
			log.setControl("成功");
		}catch(Exception e){
			toPage = "failed";
			request.setAttribute("message1", "病毒信息操作失败");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			e.printStackTrace();
		}
		systemlogService.saveSystemLog(log);
		return mapping.findForward(toPage);
	}
}
