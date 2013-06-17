package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList;

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

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiNotifyProc;
import edu.sjtu.infosec.ismp.manager.ERM.service.NotifyrocService;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.NotifyForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class RespNotifyAction extends DispatchAction {
	private NotifyrocService continotifyrocService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	
	
	public void setContinotifyrocService(NotifyrocService continotifyrocService) {
		this.continotifyrocService = continotifyrocService;
	}

	
	//显示应急通知过程
	@SuppressWarnings("deprecation")
	public ActionForward showNotify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int currPage = 1;
		Double totalPage = 0d;
		int totalNum = 0;
		int startResult = 0;
		int maxResult = 5;
		
		String cp = (request.getParameter("currPage")==null)?"1":request.getParameter("currPage");
		if(cp!=null && !cp.equals("")){
			currPage = Integer.parseInt(cp);
		}
		startResult = (currPage-1)*maxResult;
		if(startResult < 0){
			startResult = 0;
		}
		
		String respid=request.getParameter("id");
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}//应急预案名称
		request.getSession().setAttribute("respid", respid); //应急预案id
		if(null!=respid && !"".equals(respid))
		{
		
		//分页定义的相关的基本信息
		
		totalNum = continotifyrocService.getCount(respid);
		totalPage = Math.ceil((double)totalNum/maxResult);
		if(totalPage>0 && currPage<=0){
			currPage = 1;
		}
		if(currPage>totalPage){
			currPage=totalPage.intValue();
			startResult = (currPage-1)*maxResult;
			if(startResult < 0){
				startResult = 0;
			}
		}
	    List<ContiNotifyProc> notifyList=continotifyrocService.findbyid(startResult,maxResult,Integer.parseInt(respid));
	    request.setAttribute("notifyList", notifyList);
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		}
		
		return mapping.findForward("shownotifylist");
	}
	
	//添加应急通知过程
	@SuppressWarnings("deprecation")
	public ActionForward addnotify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("~~~添加应急通知过程~~~~");
		String respid=request.getSession().getAttribute("respid").toString();
		NotifyForm notifyform=(NotifyForm)form;
		ContiNotifyProc notify=new ContiNotifyProc();
		try {
			notify.setRespInfo(continotifyrocService.findRespBoById(respid));
			notify.setName(notifyform.getName1());
			notify.setContent(notifyform.getContent1());
			continotifyrocService.save(notify);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		log.setOperationDesc("应急响应模块,新增应急通知规程信息,ID为:"+notify.getId()+",名称为:"+notify.getName());
		log.setControl("成功");
		logService.saveSystemLog(log);
		
		String id =(String) request.getSession().getAttribute("respid");
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		return new ActionForward("/ismp/domain/local/erm/respnotify.do?method=showNotify&id="+id);
	}
	
	//删除应急通知过程
	@SuppressWarnings("deprecation")
	public ActionForward deletenotify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("~~~删除应急通知过程~~~~");
		String notifyid=request.getParameter("id");
		ContiNotifyProc cont=new ContiNotifyProc();
		cont.setId(Integer.parseInt(notifyid));
		continotifyrocService.delete(cont);
		
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
		log.setOperationDesc("应急响应模块,删除应急通知规程信息,ID为:"+cont.getId());
		log.setControl("成功");
		logService.saveSystemLog(log);
		
		
		String id =(String) request.getSession().getAttribute("respid");
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		return new ActionForward("/ismp/domain/local/erm/respnotify.do?method=showNotify&id="+id);
	}
	
	//更新应急通知过程
	@SuppressWarnings("deprecation")
	public ActionForward updatenotify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("~~~更新应急通知过程~~~~");
		NotifyForm notifyform=(NotifyForm)form;
		int updateid =notifyform.getUpdateid();
		String name = notifyform.getName();
		String content = notifyform.getContent();
		ContiNotifyProc cont=new ContiNotifyProc();
		try {
			cont.setId(updateid);
			cont.setName(name);
			cont.setContent(content);
			cont.setRespInfo(continotifyrocService.findRespBoById(request.getSession().getAttribute("respid").toString()));
			continotifyrocService.update(cont);
			
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
			log.setOperationDesc("应急响应模块,修改应急通知规程信息,ID为:"+cont.getId()+",名称为:"+cont.getName());
			log.setControl("成功");
			logService.saveSystemLog(log);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String id =(String) request.getSession().getAttribute("respid");
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		return new ActionForward("/ismp/domain/local/erm/respnotify.do?method=showNotify&id="+id);
	
	}
}
