package edu.sjtu.infosec.ismp.manager.WSM.web.actions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;
import org.infosec.ismp.manager.rmi.wsm.model.WebStates;
import org.infosec.ismp.manager.rmi.wsm.service.SiteCheckRmiInterface;
import org.infosec.ismp.manager.rmi.wsm.service.WebStatesService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicAsseStatService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicCpKindService;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicSecuLeveService;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.WSM.model.WebMonitorRecords;
import edu.sjtu.infosec.ismp.manager.WSM.service.WebMonitorRecordsService;
import edu.sjtu.infosec.ismp.manager.WSM.web.form.WebMonitorForm;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * 网站安全检测
 */
public class WebMonitorAction extends DispatchAction  {
	private static Logger logger = Logger.getLogger(WebMonitorAction.class); 
    
	private WebMonitorRecordsService webMonitorRecordsService;
	
	private DomainService domainService;

	private TopoWebService topoWebService;
	
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}

	public void setTopoWebService(TopoWebService topoWebService) {
		this.topoWebService = topoWebService;
	}

	public void setWebMonitorRecordsService(
			WebMonitorRecordsService webMonitorRecordsService) {
		this.webMonitorRecordsService = webMonitorRecordsService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	/**
     * 网站安全检测信息分页
     */
	public ActionForward showWebMonitor(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
        int currPage = 1;
		Double totalPage = 0d;
		int totalNum = 0;
		int startResult = 0;
		int maxResult = 5;
		try{
			String isAll = (request.getParameter("isAll")==null)?"0":request.getParameter("isAll");
			System.out.println("---------------isAll:----------"+isAll);
			OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			
			//分页定义的相关的基本信息
			String cp = (request.getParameter("currPage")==null)?"1":request.getParameter("currPage");
			if(cp!=null && !cp.equals("")){
				currPage = Integer.parseInt(cp);
			}
			startResult = (currPage-1)*maxResult;
			if(startResult < 0){
				startResult = 0;
			}
			
			//分页定义的相关的基本信息
			if(isAll.equals("1")){
				totalNum=webMonitorRecordsService.getCount();
			}else{
				totalNum=webMonitorRecordsService.getCountByDomain(userDomainList);
			}
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
			
			//数据相关的基本信息
			List<WebMonitorRecords> webMonitorList = new ArrayList<WebMonitorRecords>();
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				webMonitorList = webMonitorRecordsService.findAll(startResult, maxResult);
			}else{
				webMonitorList = webMonitorRecordsService.findAllByDomain(userDomainList,startResult, maxResult);
			}
			
			List<String> nodeList = new ArrayList<String>();
			for(WebMonitorRecords recode:webMonitorList){
				nodeList.add(recode.getNodeId().trim());
			}
			request.setAttribute("nodeIdList", nodeList);
			
			request.setAttribute("webMonitorList", webMonitorList);
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalPage", totalPage.intValue());
		}catch(Exception e){
			logger.debug("网站安全检查出错啦！");
			e.printStackTrace();
		}
        return mapping.findForward("show");
    }
    
	/**
     * 保存/更新网站安全检测信息前
     */
    public ActionForward preSaveWebMonitor(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String id = request.getParameter("id");
        request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));

        System.out.println(request.getAttribute("isAll"));
        WebMonitorRecords webMonitorRecords=null;
        if(id!=null&&!"".equals(id)){
        	webMonitorRecords= webMonitorRecordsService.findById(Integer.parseInt(id));
        }
        OperatorDetails user = SecurityUserHolder.getCurrentUser();
		List<Domain> userDomainList = new ArrayList<Domain>();
		if(user != null){
			userDomainList = user.getDomainList();
		}else{
			userDomainList = null;
		}
		request.setAttribute("webMonitorRecords", webMonitorRecords);
		request.setAttribute("udl", userDomainList);
		
        return mapping.findForward("preSave");
    }
	
    /**
     * 保存/更新网站安全检测信息
     */
    public ActionForward saveWebMonitor(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	boolean flag = true;
        request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));
        System.out.println(request.getAttribute("isAll"));
    	WebMonitorRecords webMonitorRecords = new WebMonitorRecords();
        WebMonitorForm webMonitorForm = (WebMonitorForm) form;
        BeanUtils.copyProperties(webMonitorRecords, webMonitorForm);
        
        if(webMonitorForm.getDomainid()!=null&&!"".equals(webMonitorForm.getDomainid())){
    		Domain domain = domainService.findById(Integer.parseInt(webMonitorForm.getDomainid()));
        	webMonitorRecords.setDomain(domain);
        }
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		
		//从后台获取nodeId
		NodeEntity nodeEntity = new NodeEntity();
		nodeEntity.setNodeStyle(1);
		topoWebService.saveOrUpdateNode(nodeEntity);
		String nodeId = nodeEntity.getNodeId();
		nodeId = nodeId.trim();
		System.out.println("========nodeId==="+nodeId);
		//String nodeId=webMonitorForm.getTimeOut()+"";
		
        if(webMonitorRecords.getId()==null||webMonitorRecords.getId()<=0){
        	webMonitorRecords.setId(null);
            String dateString = formatter.format(new Date());  
            Timestamp time = Timestamp.valueOf(dateString);
        	webMonitorRecords.setCreateTime(time);
        	webMonitorRecords.setNodeId(nodeId);
        }else{
        	flag=false;
        	String dateString1 = formatter.format(new Date());  
            Timestamp time1 = Timestamp.valueOf(dateString1);
            webMonitorRecords.setLastUpdateTime(time1);
            WebMonitorRecords records=webMonitorRecordsService.findById(webMonitorRecords.getId());
            webMonitorRecords.setCreateTime(records.getCreateTime());
            webMonitorRecords.setChangeCode(records.getChangeCode());
            webMonitorRecords.setNodeId(records.getNodeId());
        }
        
        try{
        	webMonitorRecordsService.saveAllMonitor(webMonitorRecords);
	        System.out.println("webMonitorRecordsService buildOk:");
        }catch(Exception e){
        	e.printStackTrace();
        }
        request.setAttribute("webMonitorRecords", webMonitorRecords);
        
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
 		log.setModuleName(SystemModelInfo.MOD_WSM);
 		if(flag){
     		log.setOperationDesc("网站安全检测模块,新增网站安全检测信息,ID为:"+webMonitorRecords.getId()+",名称为:"+webMonitorRecords.getName());
 		}else{
     		log.setOperationDesc("网站安全检测模块,修改网站安全检测信息,ID为:"+webMonitorRecords.getId()+",名称为:"+webMonitorRecords.getName());
 		}
 		log.setControl("成功");
 		logService.saveSystemLog(log);
        return showWebMonitor(mapping,form,request,response);
    }
    
    /**
     * 删除网站安全检测信息
     */
    public ActionForward delWebMonitor(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        request.setAttribute("isAll", request.getParameter("isAll"));
        request.setAttribute("currPage", request.getParameter("currPage"));

        System.out.println(request.getAttribute("isAll"));
        String id = request.getParameter("id");
        WebMonitorRecords record=null;
        try{
        	record= webMonitorRecordsService.findById(Integer.parseInt(id));
        	//发送数据给后台
        	webMonitorRecordsService.removeAllMonitor(record);
        }catch(Exception e){
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
 		log.setModuleName(SystemModelInfo.MOD_WSM);
     	log.setOperationDesc("网站安全检测模块,删除网站安全检测信息,ID为:"+record.getId()+",名称为:"+record.getName());
 		log.setControl("成功");
 		logService.saveSystemLog(log);
        return showWebMonitor(mapping,form,request,response);
    }
    
    /**
     * 查看网站安全检测信息
     */
    public ActionForward look(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        request.setAttribute("isAll", request.getAttribute("isAll"));
        String id = request.getParameter("id");
        try{
        	WebMonitorRecords webMonitorRecords	=webMonitorRecordsService.findById(Integer.parseInt(id));
        	request.setAttribute("webMonitorRecords", webMonitorRecords);
        }catch(Exception e){
        	e.printStackTrace();
        }
        return mapping.findForward("look");
    }
}
