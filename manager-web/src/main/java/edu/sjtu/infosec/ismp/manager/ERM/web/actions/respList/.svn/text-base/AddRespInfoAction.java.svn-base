package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespInfoService;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.AddRespInfoForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class AddRespInfoAction extends Action {
	SystemLog log = null;
	private RespInfoService respInfoService;
	private DomainService domainService;
	private SystemLogService logService;
		
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	
	public void setRespInfoService(RespInfoService respInfoService) {
		this.respInfoService = respInfoService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String isAdd = (request.getParameter("isAdd")==null)?"0":request.getParameter("isAdd");
		String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
		request.setAttribute("isAll", isAll);
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		if(isAdd.endsWith("1")){
			AddRespInfoForm resp=(AddRespInfoForm)form;
			RespInfoBO info=new RespInfoBO();
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //格式化当前系统日期
			String dateTime = dateFm.format(new java.util.Date().getTime());
			java.util.Date timeDate = dateFm.parse(dateTime);
			java.sql.Timestamp dTime = new java.sql.Timestamp(timeDate.getTime());
			try {
				info.setName(resp.getName());
				info.setDomain(domainService.findById(resp.getDmid()));
				info.setSysName(resp.getSysName());
				info.setSysDesc(resp.getSysDesc());
				info.setRefs(resp.getReferences());
				info.setTouchBy(resp.getTouchBy());
				info.setCreateTime(dTime);
				info.setUpdateTime(new Timestamp(new Date().getTime()));
				
				respInfoService.add(info);
				
				//添加日志
				log = new SystemLog();
				log.setUsername(user.getUsername());
				List<Role> list=user.getRoleList();
				String roles="";
				for(Role role:list){
					roles+=role.getRole()+",";
				}
				log.setRoleName(roles.substring(0,roles.length()-1));
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_ERM);
				log.setOperationDesc("应急响应模块,新增预案信息,预案ID为:"+info.getId()+",预案名称为:"+info.getName());
				log.setControl("成功");
				logService.saveSystemLog(log);
				
				PrintWriter out = response.getWriter();
		        out = response.getWriter();
		        response.setContentType("text/html; charset=UTF-8");
		        out.println("<script language=\"javascript\">");
		        out.println("window.opener.location.href=window.opener.location.href;");
		        out.println("window.opener.location.reload();");
		        out.println("window.close();");
		        out.println("</script>");
		        out.close();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mapping.findForward("addSucc");
		}else{
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			request.setAttribute("udl", userDomainList);
			return mapping.findForward("opSucc");
		}	
	}
}
