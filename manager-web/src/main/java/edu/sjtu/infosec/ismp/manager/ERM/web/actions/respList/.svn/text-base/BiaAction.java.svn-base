package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList;

import java.io.PrintWriter;
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

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiBia;
import edu.sjtu.infosec.ismp.manager.ERM.model.PriorityLevel;
import edu.sjtu.infosec.ismp.manager.ERM.service.BiaService;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.BiaForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class BiaAction extends DispatchAction {
	private BiaService biaService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	
	public void setBiaService(BiaService biaService) {
		this.biaService = biaService;
	}

	
	//查询bia是否存在
	public ActionForward showBia(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String respid=request.getParameter("id");
		request.getSession().setAttribute("respid", respid);
		if(request.getParameter("respname")!=null){
			request.setAttribute("respname",new String(request.getParameter("respname").getBytes("ISO8859-1"), "UTF-8"));
		}
		List<ContiBia> biaList=biaService.findBiaById(biaService.findRespBoById(respid));
		if(!biaList.isEmpty() && biaList.size()>0 && null!=biaList)
		{
			request.setAttribute("biaList", biaList);
		}
		
		//查询高中低级别
		List<PriorityLevel> plist=biaService.findPrior();
		request.getSession().setAttribute("plist", plist);
		
		return mapping.findForward("showBia");
	}
	
	//添加或更新bia
	public ActionForward savaorupdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			boolean flag=true;
			BiaForm biaform=(BiaForm)form;
			ContiBia con=new ContiBia();
			con.setBusiness(biaform.getBusiness());
			con.setPriorityLevel(biaService.findPriByid(biaform.getPriorityLevel()));
			con.setAssets(biaform.getAssets());
			con.setRto(biaform.getRto());
			con.setRtpo(biaform.getRtpo());
			con.setRespInfo(biaService.findRespBoById(request.getSession().getAttribute("respid").toString()));
			if(biaform.getId()<=0){
				con.setId(null);
			}else{
				flag=false;
				con.setId(biaform.getId());
			}
			biaService.saveorupdate(con);
			
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
			if(flag){
				log.setOperationDesc("应急响应模块,新增BIA信息,BIA的ID为:"+con.getId()+",BIA业务过程为:"+con.getBusiness());
			}else{
				log.setOperationDesc("应急响应模块,修改BIA信息,BIA的ID为:"+con.getId()+",BIA业务过程为:"+con.getBusiness());
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
