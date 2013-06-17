package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import edu.sjtu.infosec.ismp.manager.ERM.model.LinkMan;
import edu.sjtu.infosec.ismp.manager.ERM.service.LinkManService;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespProcService;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.PhoneTreeform;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class PhoneTreeAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(RespShowAction.class); 
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	/**
	 * 电话树
	 */
	private LinkManService linkManService;
	private RespProcService respProcService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public void setRespProcService(RespProcService respProcService) {
		this.respProcService = respProcService;
	}

	//显示电话树
    public ActionForward showtree(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	 String toPage = "success";
    	 try{
			toPage = "success";
			String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");

			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			//数据相关的基本信息
			List<LinkMan> linkManList = new ArrayList<LinkMan>();
			String respId=request.getParameter("respid");
			if(respId==null || "".equals(respId)){
				respId = (String) request.getSession().getAttribute("respid");
			}
			request.getSession().setAttribute("respid", respId);
			String respname=request.getParameter("respname");
			if(respname!=null){
				respname=new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8");
				request.setAttribute("respname",respname);
			}else{
				respname = (String) request.getAttribute("respname");
				request.setAttribute("respname",respname);
			}
			
			if(respId==null){
				if(isAll.equals("1")){
					linkManList = linkManService.findAll();
				}else{
					linkManList = linkManService.findAllByDomain(userDomainList);
				}
			}else{
 				linkManList = linkManService.findByRespInfoId(Integer.parseInt(respId));
			}

			String basePath = request.getContextPath();
			String treeList=linkManService.getTree(linkManList, basePath,respname);
			//System.out.println("treeList==="+treeList);
			request.setAttribute("treeList", treeList);
			
		}catch(Exception e){
			toPage = "failed";
			logger.debug("应急响应--预案管理--电话树访问出错！");
			e.printStackTrace();
		}
		logger.debug("=====toPage======="+toPage);
		return mapping.findForward(toPage);
	}
    
    public ActionForward showedit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	try {
			
	    	if(request.getParameter("respname")!=null){
				request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
			}
	    	Integer linkManid = Integer.parseInt(request.getParameter("treeid"));
			request.setAttribute("linkManid", linkManid);
			
			LinkMan linkman = linkManService.findById(linkManid);
			request.setAttribute("teamCode", linkman.getTeamCode());
			
			if(linkman.getTeamCode()!=null&&!"".equals(linkman.getTeamCode())) {
				request.setAttribute("isTeam", "yes");
			}
	        request.setAttribute("link", linkman);
	        showtree(mapping,form,request,response);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return mapping.findForward("success");
    }
    
    public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PhoneTreeform editlinkmanForm = (PhoneTreeform) form;
		LinkMan linkman = linkManService.findById(new Integer(editlinkmanForm.getId()));
		 linkman.setEmail(editlinkmanForm.getEmail());
         linkman.setName(editlinkmanForm.getName());
         linkman.setFax(editlinkmanForm.getFax());
         linkman.setJob(editlinkmanForm.getJob());
         linkman.setMp(editlinkmanForm.getMp());
         if(editlinkmanForm.getTeam_code()==null){
        	 linkman.setJobid("DA_"+editlinkmanForm.getPid().toString());
         }
         linkman.setPid(new Integer(editlinkmanForm.getPid()));
         linkman.setFid(new Integer(editlinkmanForm.getFid()));
         String respid=(String) request.getSession().getAttribute("respid");
		 linkman.setRespInfo(respProcService.findRespBoById(respid));
         linkManService.saveorupdate(linkman);
         
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
		if(linkman.getTeamCode()!=null&&!"".equals(linkman.getTeamCode())){
			log.setOperationDesc("应急响应模块,修改电话树中小组信息,ID为:"+linkman.getId()+",小组编号为:"+linkman.getTeamCode());
		}else{
			log.setOperationDesc("应急响应模块,修改电话树中人员信息,ID为:"+linkman.getId()+",姓名为:"+linkman.getName());
		}
		log.setControl("成功");
		logService.saveSystemLog(log);
         
         showtree(mapping,form,request,response);
		 return mapping.findForward("success");
	}

   	 //addNode：添加子节点
	public ActionForward addNode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, InvocationTargetException {
		
		String forward = "success";
		String respid = (String)request.getSession().getAttribute("respid");
		PhoneTreeform editlinkmanForm = (PhoneTreeform) form;
		LinkMan linkmanbo = new LinkMan();
		//获得pid
		Integer pid = linkManService.getMaxPid(Integer.parseInt(respid))+1;
		//获得teamcode
		String teamId = editlinkmanForm.getTeam_code();
		boolean teamIdExit = false;
		if(teamId!=null && !"".equals(teamId)) {
			teamIdExit = linkManService.checkTeamId(Integer.parseInt(respid), teamId);
		}
        Integer fid = -1;
         
        if(editlinkmanForm.getLinkManid()!=null&&editlinkmanForm.getLinkManid()!=""){
        	Integer linkmanId =Integer.parseInt(editlinkmanForm.getLinkManid());
        	
        	if(linkmanId!=null&&!"".equals(linkmanId)){
    	        LinkMan linkMan = linkManService.findById(linkmanId);
    	        //获得fid
    	        fid = linkMan.getPid();
            }
        }
         
        if(!teamIdExit) {
            BeanUtils.copyProperties(linkmanbo, editlinkmanForm);
            linkmanbo.setFid(fid);
            linkmanbo.setPid(pid);
            if(teamId==null || "".equals(teamId)){
            	  linkmanbo.setJobid("DA_"+pid.toString());
            }
            linkmanbo.setId(null);
            linkmanbo.setRespInfo(respProcService.findRespBoById(respid));
            if(teamId!=null || !"".equals(teamId)){
            	 linkmanbo.setTeamCode(teamId);
            }else{
            	linkmanbo.setTeamCode(null);
            }
           
           }else{
            linkmanbo = linkManService.findByTeamId(teamId,respid);
            linkmanbo.setEmail(editlinkmanForm.getEmail());
            linkmanbo.setFax(editlinkmanForm.getFax());
            linkmanbo.setJob(editlinkmanForm.getJob());
            linkmanbo.setMp(editlinkmanForm.getMp());
            linkmanbo.setName(editlinkmanForm.getName());
            linkmanbo.setJobid("DA_"+linkmanbo.getPid().toString());
           }
        try {
			linkManService.saveorupdate(linkmanbo);
								
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
			if(linkmanbo.getTeamCode()!=null&&!"".equals(linkmanbo.getTeamCode())){
				log.setOperationDesc("应急响应模块,新增电话树中小组信息,ID为:"+linkmanbo.getId()+",小组编号为:"+linkmanbo.getTeamCode());
			}else{
				log.setOperationDesc("应急响应模块,新增电话树中人员信息,ID为:"+linkmanbo.getId()+",姓名为:"+linkmanbo.getName());
			}
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
		return mapping.findForward(forward);
		
	}

	/**
	 * addNode：删除子节点
	 */
	public ActionForward deleteNode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
        String linkManId = request.getParameter("linkManId");
		String respid = (String)request.getSession().getAttribute("respid");

		LinkMan linkMan = linkManService.findById(new Integer(linkManId));
		       
		try{
			if(linkMan!=null&&!"".equals(linkMan)){
				String delStr=delete(linkMan.getPid(),respid);
				//System.out.println("---deleteid---"+delStr);
				linkManService.deleteByPid(delStr,respid);
							
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
				if(linkMan.getTeamCode()!=null&&!"".equals(linkMan.getTeamCode())){
					log.setOperationDesc("应急响应模块,删除电话树小组中,ID为:"+linkMan.getId()+"下所有子节点");
				}else{
					log.setOperationDesc("应急响应模块,删除电话树人员信息,ID为:"+linkMan.getId()+",姓名为:"+linkMan.getName());
				}
				log.setControl("成功");
				logService.saveSystemLog(log);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		 showtree(mapping,form,request,response);
		System.out.println("删除成功");
		return mapping.findForward("success");
	}
	
	//递归删除节点
	String s ="";
    public String  delete(int pid,String respid) {//递归方法，循环调用   
    	s += pid+",";
    	//根据当前pid查找其他fid=pid记录的id
    	List<LinkMan> list= linkManService.queryByPid(pid,respid);
    	for(LinkMan link:list){
    		delete(link.getPid(),respid);
    	}
    	return s.substring(0,s.lastIndexOf(","));
    }    
    
    
    public ActionForward addteam(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
    	request.setAttribute("linkManid", request.getParameter("linkManid"));
    	request.setAttribute("teamCode", request.getParameter("teamCode"));
    	System.out.println("linkManid===="+request.getParameter("linkManid"));
    	System.out.println("teamCode===="+request.getParameter("teamCode"));
		return mapping.findForward("addteam");
    }
    
    public ActionForward addperson(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
    	request.setAttribute("linkManid", request.getParameter("linkManid"));
    	request.setAttribute("teamCode", request.getParameter("teamCode"));
    	System.out.println("linkManid===="+request.getParameter("linkManid"));
    	System.out.println("teamCode===="+request.getParameter("teamCode"));
		return mapping.findForward("addperson");
    }
}
