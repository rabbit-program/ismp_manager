package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiRespProc;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.model.SafeThreatenInfo;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespProcService;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.RespProcForm;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.ShowListForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class RespProcAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(RespShowAction.class); 
	private RespProcService  respprocService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	
	public void setRespprocService(RespProcService respprocService) {
		this.respprocService = respprocService;
	}

	//查询安全威胁列条以及显示响应过程列表
	public ActionForward showRespProc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String respid=request.getParameter("id");
		//System.out.println("id=========="+respid);
		request.setAttribute("respid", respid);
		request.getSession().setAttribute("respid", respid);
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		List<SafeThreatenInfo> safeThreatList=respprocService.findSafeThreat();
		request.getSession().setAttribute("safeThreatList", safeThreatList);
		
		return showRespProcBySafe(mapping,form,request,response);
	}
	
	//根据威胁名称查询对应的应急响应响应过程列表
	public ActionForward showRespProcBySafe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	  try{
		RespProcForm respproc=(RespProcForm)form;
		String respid=request.getSession().getAttribute("respid").toString();
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}else{
			System.out.println(request.getAttribute("respname"));
			request.setAttribute("respname", request.getAttribute("respname"));
		}
		String safeid=respproc.getSafethreat(); //得到威胁id
		request.getSession().setAttribute("safeid", safeid);
			int currPage = 1;
			Double totalPage = 0d;
			int totalNum = 0;
			int startResult = 0;
			int maxResult = 5;
			//根据威胁id查询威胁名称
			if(safeid!=null && !"".equals(safeid)){
				String safeName=respprocService.findSafeNameById(safeid);
				request.getSession().setAttribute("safeName", safeName);
			}
			String cp = (request.getParameter("currPage")==null)?"1":request.getParameter("currPage");
			if(cp!=null && !cp.equals("")){
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage-1)*maxResult;
			if(startResult < 0){
				startResult = 0;
			}
	
		
			//分页定义的相关的基本信息
			
			totalNum = respprocService.getCount(respid,safeid);
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
			//查询应急响应过程列表
			List<ContiRespProc> respprocList=respprocService.findRespProcByrespinfo(startResult,maxResult,respid,safeid);
			request.setAttribute("respprocList", respprocList);
	
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalPage", totalPage.intValue());
 	 }catch(Exception e){
		logger.debug("应急响应--响应过程列表--首页访问出错！");
		e.printStackTrace();
	 }
		
		return mapping.findForward("showrespproc");
	}
	
	//添加
	public ActionForward addRespProcInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("~~~~~~进入添加新的应急过程~~~~~~~");
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		String respid=request.getSession().getAttribute("respid").toString();
		//System.out.println("respid=========="+respid);
		RespProcForm respproc=(RespProcForm)form;
		ContiRespProc cont=new ContiRespProc();
		cont.setRespInfo(respprocService.findRespBoById(respid));
		cont.setName(respproc.getProcname1());
		cont.setContent(respproc.getProccontent1());
		cont.setSafeThreaten(respprocService.findSafeThreatenInfoById(request.getSession().getAttribute("safeid").toString()));
		respprocService.save(cont);
		
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
		log.setOperationDesc("应急响应模块,新增应急响应过程信息,ID为:"+cont.getId()+",名称为:"+cont.getName());
		log.setControl("成功");
		logService.saveSystemLog(log);
		
		return new ActionForward("/ismp/domain/local/erm/respproc.do?method=showRespProcBySafe");
	}
	
	//更新
	public ActionForward updateproc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("~~~~~~进入更新应急过程~~~~~~~");
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		RespProcForm prcoform=(RespProcForm)form;
		ContiRespProc cont=new ContiRespProc();
		cont.setId(prcoform.getProcid());
		cont.setName(prcoform.getProcname());
		cont.setContent(prcoform.getProccontent());
		respprocService.update(cont);
		
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
		log.setOperationDesc("应急响应模块,更新应急响应过程信息,ID为:"+cont.getId()+",名称为:"+cont.getName());
		log.setControl("成功");
		logService.saveSystemLog(log);
		
		return new ActionForward("/ismp/domain/local/erm/respproc.do?method=showRespProcBySafe");
	}
	
	//删除
	public ActionForward deleteproc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("~~~~~~进入删除应急过程~~~~~~~");
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		String respprocid=request.getParameter("id");
		ContiRespProc cont=new ContiRespProc();
		cont.setId(Integer.parseInt(respprocid));
		respprocService.delete(cont);
		
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
		log.setOperationDesc("应急响应模块,删除应急响应过程信息,ID为:"+cont.getId());
		log.setControl("成功");
		logService.saveSystemLog(log);
		
		return new ActionForward("/ismp/domain/local/erm/respproc.do?method=showRespProcBySafe");
	}
}
