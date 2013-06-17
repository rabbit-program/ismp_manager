package edu.sjtu.infosec.ismp.manager.ERM.web.actions.respPrint;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.ERM.model.RespFilePrint;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespInfoService;
import edu.sjtu.infosec.ismp.manager.ERM.web.actions.respList.RespShowAction;
import edu.sjtu.infosec.ismp.manager.ERM.web.form.FilePrintFrom;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;
import edu.sjtu.infosec.ismp.util.EscapeUnescape;

public class RespPrintAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(RespShowAction.class); 

	/**
	 * 注入 service 接口
	 */
	private RespInfoService respInfoService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService){
		this.logService = logService;
	}
	
	public void setRespInfoService(RespInfoService respInfoService) {
		this.respInfoService = respInfoService;
	}

    public ActionForward showselect(ActionMapping mapping, ActionForm form,
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
			List<RespInfoBO> respList = new ArrayList<RespInfoBO>();
			if(isAll.equals("1")){
				respList = respInfoService.findAll();
			}else{
				respList = respInfoService.findAllByDomain(userDomainList);
			}
			
			
			

			request.getSession().setAttribute("respList", respList);
		}catch(Exception e){
			toPage = "failed";
			logger.debug("应急响应--预案打印--首页访问出错啦！");
			e.printStackTrace();
		}
		logger.debug("=====toPage======="+toPage);
		
		
		
		request.setAttribute("respMenu", "fp");
		
		return mapping.findForward(toPage);
    }
    
    
    public ActionForward showContent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("~~~~~根据select条件查询对应的文本信息~~~~~~~~");
    	RespFilePrint file=new RespFilePrint();
    	String selectid=request.getParameter("selectid");
    	request.setAttribute("selectid", selectid);
    	System.out.println("selectid======="+selectid);
    	if(null!=selectid && !"".equals(selectid))
    	{
    		RespFilePrint res=respInfoService.findFileContentById(respInfoService.findrespInfoById(Integer.parseInt(selectid)));
        	if(null!=res)
        	{
        		request.setAttribute("printid", res.getId()); //打印信息编号
        		request.setAttribute("printres", res.getContent());//打印信息内容
        		request.setAttribute("printResp", res.getRespInfo());//打印信息对应的应急编号
        	}
    	}
		request.setAttribute("respMenu", "fp");
    	return mapping.findForward("filecount");
    }
    
    public ActionForward saveorupdate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	boolean flag = false;
    	System.out.println("~~~~增加或更新打印信息~~~~~");
    	FilePrintFrom fileform=(FilePrintFrom)form;
    	RespFilePrint file=new RespFilePrint();
    	System.out.println("id==="+fileform.getId());
    	System.out.println("content==="+fileform.getPrintcontent());
    	System.out.println("procid==="+fileform.getSelectresp());
    	request.setAttribute("printres", fileform.getPrintcontent());
    	request.setAttribute("selectid", fileform.getSelectresp());
    	if(fileform.getId()==0){
    		flag=true;
    		file.setId(null);
    	}else{
    		file.setId(fileform.getId());
    	}
    	file.setContent(fileform.getPrintcontent());
    	file.setRespInfo(respInfoService.findrespInfoById(fileform.getSelectresp()));
    	respInfoService.saveorupdate(file);
    	
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
			log.setOperationDesc("应急响应模块文件打印,新增打印信息,ID为:"+file.getId()+",所属预案名称为:"+file.getRespInfo().getName());
		}else{
			log.setOperationDesc("应急响应模块文件打印,修改打印信息,ID为:"+file.getId()+",所属预案名称为:"+file.getRespInfo().getName());
		}
		log.setControl("成功");
		logService.saveSystemLog(log);
		request.setAttribute("respMenu", "fp");
    	return mapping.findForward("filecount");
    }
}
