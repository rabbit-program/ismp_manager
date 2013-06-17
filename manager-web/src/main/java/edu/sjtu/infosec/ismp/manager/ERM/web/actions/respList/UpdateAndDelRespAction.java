package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList;

import java.io.PrintWriter;
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
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiBia;
import edu.sjtu.infosec.ismp.manager.ERM.model.LinkMan;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.BiaService;
import edu.sjtu.infosec.ismp.manager.ERM.service.LinkManService;
import edu.sjtu.infosec.ismp.manager.ERM.service.NotifyrocService;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespInfoService;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespProcService;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.AddRespInfoForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class UpdateAndDelRespAction extends DispatchAction {
	public RespInfoService respInfoService;
	private DomainService domainService;
	private BiaService biaService;
	private LinkManService linkManService;
	private NotifyrocService continotifyrocService;
	private RespProcService respprocService;
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	public void setRespprocService(RespProcService respprocService) {
		this.respprocService = respprocService;
	}
	public void setContinotifyrocService(NotifyrocService continotifyrocService) {
		this.continotifyrocService = continotifyrocService;
	}
	public void setBiaService(BiaService biaService) {
		this.biaService = biaService;
	}
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	public void setRespInfoService(RespInfoService respInfoService) {
		this.respInfoService = respInfoService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			request.setAttribute("currPage", 1);
			AddRespInfoForm respform=(AddRespInfoForm)form;
			RespInfoBO info=new RespInfoBO();
			String respId=request.getSession().getAttribute("respId").toString();
			
			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //格式化当前系统日期
			String dateTime = dateFm.format(new java.util.Date().getTime());
			java.util.Date timeDate = dateFm.parse(dateTime);
			java.sql.Timestamp dTime = new java.sql.Timestamp(timeDate.getTime());
			if(null!=respId && !"".equals(respId))
			{
				info.setId(Integer.parseInt(respId));
				info.setName(respform.getName());
				info.setDomain(domainService.findById(respform.getDmid()));
				info.setSysName(respform.getSysName());
				info.setSysDesc(respform.getSysDesc());
				info.setRefs(respform.getReferences());
				info.setTouchBy(respform.getTouchBy());
				info.setCreateTime(dTime);
				info.setUpdateTime(new Timestamp(new Date().getTime()));
				respInfoService.update(info);
				
				//添加日志
				OperatorDetails user = SecurityUserHolder.getCurrentUser();
				SystemLog log = new SystemLog();
				log.setUsername(user.getUsername());
				List<Role> list=user.getRoleList();
				String roles="";
				for(Role role:list){
					roles+=role.getRole()+",";
				}
				log.setRoleName(roles.substring(0,roles.length()-1));
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_ERM);
				log.setOperationDesc("应急响应模块,更新预案信息,ID为:"+info.getId()+",预案名称为:"+info.getName());
				log.setControl("成功");
				logService.saveSystemLog(log);
			}
			//更新后从新查询数据库
			List<RespInfoBO> respList=respInfoService.findAll();
			request.setAttribute("respList", respList);
			PrintWriter out = response.getWriter();
	        out = response.getWriter();
	        response.setContentType("text/html; charset=UTF-8");
	        out.println("<script language=\"javascript\">");
	        out.println("window.opener.location.href=window.opener.location.href;");
	        out.println("window.opener.location.reload();");
	        out.println("window.close();");
	        out.println("</script>");
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		//return new ActionForward("/ismp/domain/local/erm/respShow.do");
	}
	
	@SuppressWarnings("deprecation")
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String respId=request.getParameter("id");
		if(null!=respId && !"".equals(respId))
		{
			RespInfoBO info=respInfoService.findrespInfoById(Integer.parseInt(respId));
			if(info!=null&&!"".equals(info)){
				//删除bia
				biaService.deleteBiaByRespInfo(info);
				//删除应急响应过程
				respprocService.deleteProcByRespInfo(info);
				//删除应急通知规程
				continotifyrocService.deleteNotifyByRespInfo(info);
				//删除电话树
				//List<LinkMan> link = linkManService.findByRespInfo(info);
				linkManService.deleteLinkManByRespInfo(info);
				//删除打印文件
				respInfoService.deleteFileByRespInfo(info);
				
				respInfoService.delete(info);
				
				//添加日志
				OperatorDetails user = SecurityUserHolder.getCurrentUser();
				SystemLog log = new SystemLog();
				log.setUsername(user.getUsername());
				List<Role> list=user.getRoleList();
				String roles="";
				for(Role role:list){
					roles+=role.getRole()+",";
				}
				log.setRoleName(roles.substring(0,roles.length()-1));
				log.setTime(new Timestamp(new Date().getTime()));
				log.setModuleName(SystemModelInfo.MOD_ERM);
				log.setOperationDesc("应急响应模块,删除预案,ID为:"+info.getId()+"预案名称为:"+info.getName());
				log.setControl("成功");
			}
		}
		return new ActionForward("/ismp/domain/local/erm/respShow.do");
	}
	
	public ActionForward updateValue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			String respId=request.getParameter("id");
			//System.out.println("应急预案id====="+respId);
			request.getSession().setAttribute("respId", respId);
			if(respId!=null && !respId.equals(""))
			{
				RespInfoBO respInfo=respInfoService.findrespInfoById(Integer.parseInt(respId));
				request.setAttribute("respInfo", respInfo);
			}
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			request.setAttribute("udl", userDomainList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("showlistResp");
	}
}
