package edu.sjtu.infosec.ismp.manager.OSS.wom.web.actions;

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
import org.infosec.ismp.manager.rmi.sensor.operation.service.WinsensorOperationWorkOrdersService;

import edu.sjtu.infosec.ismp.manager.ERM.web.form.ShowListForm;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.ClientQuestion;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.WorkOrder;
import edu.sjtu.infosec.ismp.manager.OSS.wom.service.ClientQuestionService;
import edu.sjtu.infosec.ismp.manager.OSS.wom.service.WorkOrderService;
import edu.sjtu.infosec.ismp.manager.OSS.wom.web.form.ClientQuestionForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 客户端问题Action.
 */
public class ClientQuestionAction extends DispatchAction  {
	private static Logger logger = Logger.getLogger(ClientQuestionAction.class); 
	//派工单访问接口
    private WorkOrderService workOrderService;
    
    //注入客户端问题service.
	private ClientQuestionService clientQuestionService;

    private DomainService  domainService;
    
    private WinsensorOperationWorkOrdersService winsensorOperationWorkOrdersService;
    
	private SystemLogService logService;
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
	}
	public static void setLogger(Logger logger) {
		ClientQuestionAction.logger = logger;
	}

	public void setWinsensorOperationWorkOrdersService(
			WinsensorOperationWorkOrdersService winsensorOperationWorkOrdersService) {
		this.winsensorOperationWorkOrdersService = winsensorOperationWorkOrdersService;
	}

	public WorkOrderService getWorkOrderService() {
		return workOrderService;
	}

	public void setWorkOrderService(WorkOrderService workOrderService) {
		this.workOrderService = workOrderService;
	}
    
    public ClientQuestionService getClientQuestionService() {
		return clientQuestionService;
	}

	public void setClientQuestionService(ClientQuestionService clientQuestionService) {
		this.clientQuestionService = clientQuestionService;
	}

	public DomainService getDomainService() {
		return domainService;
	}

	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}


	/**
     * 客户端问题分页
     */
	public ActionForward showQuestion(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		int currPage = 1;
		Double totalPage = 0d;
		int totalNum = 0;
		int startResult = 0;
		int maxResult = 5;
		Domain domain = null;
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
			//数据相关的基本信息
			ClientQuestionForm show=(ClientQuestionForm)form;
			request.setAttribute("domain", show.getDomain());
			request.setAttribute("state",show.getState());
			if(show.getDomain()!=null){
				domain = domainService.findById(show.getDomain());
			}
			List<ClientQuestion> questionList = new ArrayList<ClientQuestion>();
			if(isAll.equals("1")){
				request.setAttribute("isAll", isAll);
				questionList = clientQuestionService.findAll(startResult, maxResult,domain,show.getState());
			}else{
				questionList = clientQuestionService.findAllByDomain(userDomainList, startResult, maxResult,domain,show.getState());
			}
			

			//分页定义的相关的基本信息
			if(questionList!=null && questionList.size()>=0){
				if(isAll.equals("1")){
					totalNum=clientQuestionService.getCount(domain,show.getState());
				}else{
					totalNum = clientQuestionService.getCountByDomain(userDomainList,domain,show.getState());
				}
			}
			totalPage = Math.ceil((double)totalNum/maxResult);
			if(totalPage>0 && currPage<=0){
				currPage = 1;
			}
			
			request.setAttribute("udl", userDomainList);
			request.setAttribute("questionList", questionList);
		}catch(Exception e){
			logger.debug("应急响应--预案管理--首页访问出错啦！");
			e.printStackTrace();
		}
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalPage", totalPage.intValue());
		request.setAttribute("ossMenu","wom");
		request.setAttribute("womMenu","ques");

		return mapping.findForward("showQues");
    }
    
    
    /**
     * 关闭客户端问题
     */
    public ActionForward OnClose(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	try {
    		request.setAttribute("isAll", request.getParameter("isAll"));
    		request.setAttribute("currPage", request.getParameter("currPage"));
    		String id = request.getParameter("id");
        	ClientQuestion clientQuestion =null;
        	WorkOrder workOrder=null;
        	if(id!=null&&id.length()>0){
        		clientQuestion=clientQuestionService.findById(Integer.parseInt(id));
        		clientQuestion.setState(4);
        		clientQuestionService.saveOrUpdate(clientQuestion);
        		//向后台发送数据
        		
        		workOrder=workOrderService.findByQuestion(clientQuestion.getId());
        		if(workOrder!=null){
            		workOrder.setState(4);
            		workOrderService.saveOrUpdate(workOrder);
        		}
        		if(clientQuestion.getSn()!=null&&clientQuestion.getSn().length()>0){
            		winsensorOperationWorkOrdersService.closeProblem(clientQuestion.getSn());
                	//向后台发送数据
                	if(workOrder!=null){
                		winsensorOperationWorkOrdersService.closeWorkOrders(clientQuestion.getId().toString(), workOrder.getId().toString());
                	}
        		}
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
     		log.setModuleName(SystemModelInfo.MOD_OSS_wom);
     		if(workOrder!=null){
     			log.setOperationDesc("运维工单,关闭客户端问题,问题ID为:"+clientQuestion.getId()+",问题标题为:"+clientQuestion.getName()+",工单ID为:"+workOrder.getId());
     		}else{
     			log.setOperationDesc("运维工单,关闭客户端问题,问题ID为:"+clientQuestion.getId()+",问题标题为:"+clientQuestion.getName());
     		}
         	log.setControl("成功");
     		logService.saveSystemLog(log);
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
        return showQuestion(mapping,form,request,response);
    }
    
    
    /**
     * 查看客户端问题
     */
    public ActionForward lookQuestion(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        	
    		String id = request.getParameter("id");
        	ClientQuestion clientQuestion =null;
        	if(id!=null&&id.length()>0){
        		clientQuestion=clientQuestionService.findById(Integer.parseInt(id));
        	}
        	request.setAttribute("clientQuestion", clientQuestion);
        
           return mapping.findForward("lookQues");
    }
    
    /**
     * 生成工单前
     */
    public ActionForward addWorkOrder(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        	
    		String id = request.getParameter("id");
        	ClientQuestion clientQuestion =null;
        	if(id!=null&&id.length()>0){
        		clientQuestion=clientQuestionService.findById(Integer.parseInt(id));
        	}
        	request.setAttribute("clientQuestion", clientQuestion);
        
           return showQuestion(mapping,form,request,response);
    }
    
}
