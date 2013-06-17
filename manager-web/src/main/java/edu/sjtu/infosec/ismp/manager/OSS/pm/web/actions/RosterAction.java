package edu.sjtu.infosec.ismp.manager.OSS.pm.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;

import common.Logger;

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.OSS.pm.service.RosterService;
import edu.sjtu.infosec.ismp.manager.OSS.pm.web.form.RosterForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class RosterAction extends DispatchAction {

	Logger logger  = Logger.getLogger(RosterAction.class);
	public void setRosterService(RosterService rosterService) {
		this.rosterService = rosterService;
	}
	private RosterService rosterService;
	 
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	private SystemLogService systemlogservice;
	@SuppressWarnings("unused")
	private DomainService domainService;
	/**
	 * 查询所有人员
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	  public ActionForward rosterInfoAll(ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
			  OperatorDetails user = SecurityUserHolder.getCurrentUser();
			  RosterForm rosterForm =(RosterForm)form;
			  request.setAttribute("curpage", request.getParameter("currPage"));
			  String type=request.getParameter("type");
			  String doMainId=request.getParameter("doid");
			  List<Domain> domainList =null;
				PMPage page = new PMPage();
				String curpage = request.getParameter("currPage") != null
						&& (!request.getParameter("currPage").equals("")) ? request
						.getParameter("currPage") : "1";
				page.setCurrentPage(Integer.parseInt(curpage));
				page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
			  if(!(user == null)){
				  if("seach".equals(type)){
					   if(HtmlFactory.isNotEmpty(doMainId)){
						   Domain domain = new Domain();
						   domain.setId(Integer.valueOf(doMainId));
						   List<Domain> list = new ArrayList<Domain>();
						   list.add(domain);
						   domainList=list;
					   }
				  }
				  domainList = domainList == null ? user.getDomainList() : domainList;
				  List<Roster> list = rosterService.findConditionsInfo(rosterForm.getRoster(), domainList, page, rosterForm.getCreateStartDate(), rosterForm.getCreateEndDate());
				  request.setAttribute("list", list);
				  request.setAttribute("page", page.getPageInfo());
				  request.setAttribute("currPage", page.getPageInfo().getCurrentPage());
		    	  request.setAttribute("totalPage", page.getPageInfo().getTotalPage());
		    	  request.setAttribute("ossMenu","pm");
				return mapping.findForward("index");
			  }
			  return null;
	  }
	  /**
	   * 查询所有人员
	   * @param mapping
	   * @param form
	   * @param request
	   * @param response
	   * @return
	   * @throws Exception
	   */
	  public ActionForward selectRosterAll(ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
		      OperatorDetails user = SecurityUserHolder.getCurrentUser();
		  if(!(user == null)){
			  StringBuffer sbf = new StringBuffer();
			  List<Roster> list = rosterService.selectAll(user.getDomainList());
			  String[][] obj ={{"id","getId"},{"name","getName"}};
			  for(Roster roster : list){
				  Object[][] objs={{roster,obj}};
				  HtmlFactory.getDataArray(objs, sbf,"ROSTER");
			  }
			  HtmlFactory.flushData(response, sbf);
		  }
		  return null;
	  }
	  /**
	   * 添加人员
	   * @param mapping
	   * @param form
	   * @param request
	   * @param response
	   * @return
	   * @throws Exception
	   */
	  public ActionForward rosterInfoadd(ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
		      Roster roster = new Roster();    
		      Domain dm = new Domain();;
		      String domain = request.getParameter("userdomain");
		      String usersn = request.getParameter("usersn");
		      String userposition = request.getParameter("userposition");
		      String usermobile = request.getParameter("usermobile");
		      String userphone = request.getParameter("userphone");
		      String useremail = request.getParameter("useremail");
		      String userremark  = request.getParameter("userremark");
		      String username = request.getParameter("username");
		      String usersex  = request.getParameter("usersex");
		      if(domain != null && !domain.isEmpty()){
		    	  dm.setId(Integer.valueOf(domain));
		      }
		      roster.setSex(usersex == null || !usersex.isEmpty() ? Integer.valueOf(usersex) : 1);
		      roster.setEMail(useremail);
		      roster.setMobile(usermobile);
		      roster.setName(username);
		      roster.setPhone(userphone);
		      roster.setRemark(userremark);
		      roster.setSn(usersn);
		      roster.setPosition(userposition);
		      roster.setDomain(dm);
		      roster.setCreateTime(new Timestamp(System.currentTimeMillis()));
		      
		       String falg="成功！";
	      	   try {
	      		   rosterService.update(roster);
	    	   } catch (Exception e) {
	    		 falg = "失败！";
	    	   }finally{
	    		   try {
					  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_OSS_pm, "添加人员", new Timestamp(System.currentTimeMillis()), falg);
				  } catch (Exception e) {
					 logger.debug("连接日志出错",e);
				  }
	    	   }
/*			  PrintWriter out = response.getWriter();
		        response.setContentType("text ml; charset=UTF-8");
		        out.println("<script language=\"javascript\">");
		        out.println("window.opener.location.href=window.opener.location.href;");
		        out.println("window.close();");
		        out.println("</script>");
		        out.close();*/
			return null;
	  }
	  /**
	   * 查询id 人员
	   * @param mapping
	   * @param form
	   * @param request
	   * @param response
	   * @return
	   * @throws Exception
	   */
	  public ActionForward rosterInfoById(ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
		      String rid= request.getParameter("rid");
		      String identifier = request.getParameter("identifier");
		      Roster roster =  rosterService.findById(Integer.valueOf(rid));
		      request.setAttribute("roster",roster);
		  return mapping.findForward(identifier);
	  }
	  /**
	   * 更新Id 人员
	   * @param mapping
	   * @param form
	   * @param request
	   * @param response
	   * @return
	   * @throws Exception
	   */
	  public ActionForward rosterInfoUpdate(ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
			  Roster roster = new Roster();    
		      String rosterid = request.getParameter("rosterid");
		      if(rosterid != null && !rosterid.isEmpty()){
		    	  Domain dm = new Domain();
			      String domain = request.getParameter("userdomain");
			      String usersn = request.getParameter("usersn");
			      String userposition = request.getParameter("userposition");
			      String usermobile = request.getParameter("usermobile");
			      String userphone = request.getParameter("userphone");
			      String useremail = request.getParameter("useremail");
			      String userremark  = request.getParameter("userremark");
			      String username = request.getParameter("username");
			      String usersex  = request.getParameter("usersex");
			      if(domain != null && !domain.isEmpty()){
			    	  dm.setId(Integer.valueOf(domain));
			      }
			      roster.setSex(usersex == null || usersex.isEmpty() ? 1 : Integer.valueOf(usersex));
			      roster.setEMail(useremail);
			      roster.setId(Integer.valueOf(rosterid));
			      roster.setMobile(usermobile);
			      roster.setName(username);
			      roster.setPhone(userphone);
			      roster.setRemark(userremark);
			      roster.setSn(usersn);
			      roster.setPosition(userposition);
			      roster.setDomain(dm);
			      roster.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
			       String falg="成功！";
		      	   try {
		      		   rosterService.update(roster);
		    	   } catch (Exception e) {
		    		 falg = "失败！";
		    	   }finally{
		    		   try {
						  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_OSS_pm, "更新人员", new Timestamp(System.currentTimeMillis()), falg);
					  } catch (Exception e) {
						 logger.debug("连接日志出错",e);
					  }
		    	   }
		  }
		return null;
	  }
	  /**
	   * 删除id人员
	   * @param mapping
	   * @param form
	   * @param request
	   * @param response
	   * @return
	   * @throws Exception
	   */
	  public ActionForward rosterInfoDel(ActionMapping mapping, ActionForm form, 
			  HttpServletRequest request, HttpServletResponse response) throws Exception{
		  String rid= request.getParameter("rid");
	      Roster roster =  rosterService.findById(Integer.valueOf(rid));
	       String falg="成功！";
      	   try {
      		 rosterService.delete(roster);
    	   } catch (Exception e) {
    		 falg = "失败！";
    	   }finally{
    		   try {
				  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_OSS_pm, "删除人员", new Timestamp(System.currentTimeMillis()), falg);
			  } catch (Exception e) {
				 logger.debug("连接日志出错",e);
			  }
    	   }
	      
		return rosterInfoAll(mapping,new RosterForm(),request,response );
	  }
}
