package edu.sjtu.infosec.ismp.manager.SYSM.config.web.actions.client.winSensor;

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

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class DefConfigModifyAction extends Action {
	private static Logger logger = Logger.getLogger(DefConfigModifyAction.class); 
	
	
//	private SysConfigDataSynService sysConfigDataSynService;
//	public void setSysConfigDataSynService(SysConfigDataSynService sysConfigDataSynService) {
//		this.sysConfigDataSynService = sysConfigDataSynService;
//	}

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
//			DataSynConfigForm DataSynConfigForm = (DataSynConfigForm)form;
//			SysConfigDataSyn configDataSyn = new SysConfigDataSyn();
//			
//			List<SysConfigDataSyn> dataSyn=sysConfigDataSynService.findAll();
//			if(dataSyn!=null&&dataSyn.size()>0){
//				configDataSyn = dataSyn.get(0);
//				configDataSyn.setCenterIp(DataSynConfigForm.getCenterIp());
//				configDataSyn.setDataSynPort(DataSynConfigForm.getDataSynPort());
//				sysConfigDataSynService.update(configDataSyn);
//				request.setAttribute("message", "修改数据上报信息成功");
//				log.setOperationDesc("系统管理模块平台配置,修改数据上报信息");
//			}else{
//				configDataSyn.setCenterIp(DataSynConfigForm.getCenterIp());
//				configDataSyn.setDataSynPort(DataSynConfigForm.getDataSynPort());
//				sysConfigDataSynService.add(configDataSyn);
//				request.setAttribute("message", "新增数据上报信息成功");
//				log.setOperationDesc("系统管理模块平台配置,新增数据上报信息");
//			}
//			request.setAttribute("configDataSyn", configDataSyn);

			log.setControl("成功");
		}catch(Exception e){
			toPage = "failed";
			request.setAttribute("message", "数据上报信息操作失败");
			log.setControl("失败");
			systemlogService.saveSystemLog(log);
			e.printStackTrace();
		}
//		systemlogService.saveSystemLog(log);
		return mapping.findForward(toPage);
	}
}
