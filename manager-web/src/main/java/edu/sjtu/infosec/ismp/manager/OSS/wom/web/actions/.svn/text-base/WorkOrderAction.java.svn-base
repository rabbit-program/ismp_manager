package edu.sjtu.infosec.ismp.manager.OSS.wom.web.actions;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigSms;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigSmsService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.ClientQuestion;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.WorkOrder;
import edu.sjtu.infosec.ismp.manager.OSS.wom.service.ClientQuestionService;
import edu.sjtu.infosec.ismp.manager.OSS.wom.service.WorkOrderService;
import edu.sjtu.infosec.ismp.manager.OSS.wom.web.form.WorkOrderForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.comm.comm.send.SendMsg;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

/**
 * web层 派工单Action.
 */
public class WorkOrderAction extends DispatchAction{
	private static Logger logger = Logger.getLogger(WorkOrderAction.class); 

	//派工单访问接口
    private WorkOrderService workOrderService;
    
    //注入客户端问题service.
	private ClientQuestionService clientQuestionService;

    private DomainService  domainService;
    
    private WinsensorOperationWorkOrdersService winsensorOperationWorkOrdersService;
    
	private SystemLogService logService;
	
	private SysConfigSmsService sysConfigSmsService;
	
	public void setSysConfigSmsService(SysConfigSmsService sysConfigSmsService) {
		this.sysConfigSmsService = sysConfigSmsService;
	}
	
	public void setLogService(SystemLogService logService) {
		this.logService = logService;
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
     * 工单分页
     */
    public ActionForward showWorkOrder(ActionMapping mapping,
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
    			WorkOrderForm show=(WorkOrderForm)form;
    			request.setAttribute("domain", show.getDomain());
    			request.setAttribute("state",show.getState());
    			if(show.getDomain()!=null){
    				domain = domainService.findById(show.getDomain());
    			}
    			List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
    			if(isAll.equals("1")){
    				request.setAttribute("isAll", isAll);
    				workOrderList = workOrderService.findAll(startResult, maxResult,domain,show.getState());
    			}else{
    				workOrderList = workOrderService.findAllByDomain(userDomainList, startResult, maxResult,domain,show.getState());
    			}
    			

    			//分页定义的相关的基本信息
    			if(workOrderList!=null && workOrderList.size()>=0){
    				if(isAll.equals("1")){
    					totalNum=workOrderService.getCount(domain,show.getState());
    				}else{
    					totalNum = workOrderService.getCountByDomain(userDomainList,domain,show.getState());
    				}
    			}
    			totalPage = Math.ceil((double)totalNum/maxResult);
    			if(totalPage>0 && currPage<=0){
    				currPage = 1;
    			}
    			
    			request.setAttribute("udl", userDomainList);
    			request.setAttribute("workOrderList", workOrderList);
    		}catch(Exception e){
    			logger.debug("工单管理--访问出错啦！");
    			e.printStackTrace();
    		}
    		
    		request.setAttribute("currPage", currPage);
    		request.setAttribute("totalPage", totalPage.intValue());
    		request.setAttribute("ossMenu","wom");
    		request.setAttribute("womMenu", "work");
    		return mapping.findForward("showWorkOrder");
        }
    
    /**
     * 关闭工单
     */
    public ActionForward OnClose(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	try {
    		request.setAttribute("isAll", request.getParameter("isAll"));
    		request.setAttribute("currPage", request.getParameter("currPage"));
    		String id = request.getParameter("id");
    		WorkOrder workOrder =null;
        	if(id!=null&&id.length()>0){
        		workOrder=workOrderService.findById(Integer.parseInt(id));
        		workOrder.setState(4);
        		workOrderService.saveOrUpdate(workOrder);
        		
        		ClientQuestion question = workOrder.getQuestion();
        		question.setState(1);
        		clientQuestionService.saveOrUpdate(question);
        		//向后台发送数据
        		if(question.getSn()!=null&&question.getSn().length()>0){
            		winsensorOperationWorkOrdersService.closeWorkOrders(question.getSn(), workOrder.getId().toString());
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
         	log.setOperationDesc("运维工单,关闭工单,工单ID为:"+workOrder.getId()+",工单所属问题名称为:"+workOrder.getQuestion().getName());
     		log.setControl("成功");
     		logService.saveSystemLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return showWorkOrder(mapping,form,request,response);
	}
    
    /**
     * 结单
     */
    public ActionForward OverWorkOrder(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	try {
    		request.setAttribute("isAll", request.getParameter("isAll"));
    		request.setAttribute("currPage", request.getParameter("currPage"));
    		String id = request.getParameter("id");
    		WorkOrder workOrder =null;
    		ClientQuestion question=null;
        	if(id!=null&&id.length()>0){
        		workOrder=workOrderService.findById(Integer.parseInt(id));
        		workOrder.setState(3);
        		workOrderService.saveOrUpdate(workOrder);
        		
        		question = workOrder.getQuestion();
        		question.setState(3);
        		clientQuestionService.saveOrUpdate(question);
        		//向后台发送数据
        		if(question.getSn()!=null&&question.getSn().length()>0){
            		winsensorOperationWorkOrdersService.completeWorkOrders(question.getSn(), workOrder.getId().toString());
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
         	log.setOperationDesc("运维工单,结单,工单ID为:"+workOrder.getId()+",问题ID为:"+question.getId()+",问题名称为:"+question.getName());
     		log.setControl("成功");
     		logService.saveSystemLog(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return showWorkOrder(mapping,form,request,response);
	}
    
    /**
     * 新增工单前
     */
    public ActionForward preAddWorkOrder(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	try {
    		request.setAttribute("isAll", request.getParameter("isAll"));
    		//工单号
    	    String str=workOrderService.findSN();
    	    int i=Integer.parseInt(str);
    	    String str2=i+1+"";
    	    String sn = str.substring(0,str.length()-str2.length())+str2;
    	    //所属域
    	    OperatorDetails user = SecurityUserHolder.getCurrentUser();
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null){
				userDomainList = user.getDomainList();
			}else{
				userDomainList = null;
			}
			//处理人
			List<Roster> rosterList= workOrderService.findOperator();
			
			request.setAttribute("sn", sn);
			request.setAttribute("udl", userDomainList);
			request.setAttribute("rosterList", rosterList);
			
			String id =request.getParameter("id");
			if(id!=null&&!"".equals(id)){
				ClientQuestion question=clientQuestionService.findById(Integer.parseInt(id));
				request.setAttribute("question", question);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("preAddWorkOrder");
	}
    /**
     * 新增工单
     */
    public ActionForward addWorkOrder(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
    	request.setAttribute("isAll", request.getParameter("isAll"));
    	WorkOrderForm orderForm = (WorkOrderForm)form;
    	Roster operator=workOrderService.findOperatorById(orderForm.getOperator());
    	String mobile = operator.getMobile();
    	String email =operator.getEMail();
    	String message="尊敬的'"+operator.getName()+"'您好！你有一个工单需要处理问题标题为'"+orderForm.getName()+"',详情请登录安管平台进行处理或拨打电话进行咨询。";
    	
    	List<SysConfigSms> sysList=sysConfigSmsService.findAll();
    	SysConfigSms sysconfigSms=null;
    	if(sysList!=null&&sysList.size()>0){
    		sysconfigSms=sysList.get(0);
    	}
    	String socketIp =null; 
        Integer socketProt=0;
    	if(sysconfigSms!=null){
    		socketIp=sysconfigSms.getSendIp();
    		socketProt=Integer.parseInt(sysconfigSms.getSendPort());
    	}else{
    		request.getSession().setAttribute("message", "邮件服务器的IP和端口未设置请进行设置!");
			return preAddWorkOrder(mapping,form,request,response);
    	}
    	
    	int[] notices=orderForm.getNoticeWays();
    	//发送短信，邮件
    	int noticeWay=1;
    	try {
        	if(notices!=null&&notices.length==1){
        		noticeWay=notices[0];
        	    //发短信
        		if(noticeWay==1){
        			String msg=SendMsg.sendMobileMes(mobile, message, socketIp, socketProt);
        			if(msg!="1"){
        				request.getSession().setAttribute("message", "短息发送失败,请重新提交页面");
        				return preAddWorkOrder(mapping,form,request,response);
        			}
        		}else if(noticeWay==2){
        		//发送邮件	
        			String mail=SendMsg.sendMail(email, message, socketIp, socketProt);
        			String[] str= mail.split(":");
            		mail=str[1];
        			if("false".equals(mail.trim())){
        				request.getSession().setAttribute("message", "邮件发送失败,请重新提交页面");
        				return preAddWorkOrder(mapping,form,request,response);
        			}
        		}
        	}else if(notices!=null&&notices.length==2){
        		noticeWay = 3;
        		//发送短信和邮件
        		String msg=SendMsg.sendMobileMes(mobile, message, socketIp, socketProt);
        		String mail=SendMsg.sendMail(email, message, socketIp, socketProt);
        		String[] str= mail.split(":");
        		mail=str[1];
        		if(msg!="1"||"false".equals(mail.trim())){
        			request.getSession().setAttribute("message", "短息或邮件发送失败,请重新提交页面");
    				return preAddWorkOrder(mapping,form,request,response);
        		}
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	boolean flag=true;
		try {
			//保存问题
	    	ClientQuestion question = new ClientQuestion();
			Domain domain = domainService.findById(orderForm.getDomain());
	    	question.setDomain(domain);
	    	/*if(orderForm.getIsNew()>=0){
	    		question.setIsNew(orderForm.getIsNew());
	    	}else{
	    		question.setIsNew(1);
	    	}*/
	    	
	    	question.setName(orderForm.getName());
	    	question.setDesc(orderForm.getDesc());
	    	question.setRemark(orderForm.getRemark());
	    	question.setServerUrl(orderForm.getServerUrl());
	    	question.setLinkman(orderForm.getLinkman());
	    	question.setContactInfo(orderForm.getContactInfo());
	    	question.setState(2);
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        String dateString = formatter.format(new Date());  
	        Timestamp time = Timestamp.valueOf(dateString);
	    	question.setCreateTime(time);
	    	if(orderForm.getId()!=null){
	    		flag=false;
	    		question.setId(orderForm.getId());
	        	question.setSource(orderForm.getSource());
	        	question.setSn(orderForm.getQ_sn());
	        	question.setSensorId(orderForm.getSensorId());
	    	}
	    	if(question.getSn()!=null&&question.getSn().length()>0&&question.getSensorId()!=null&&question.getSensorId().length()>0){
	    		question.setIsNew(1);
	    	}else{
	    		question.setIsNew(0);
	    	}
	    	clientQuestionService.saveOrUpdate(question);
	    	
	    	//保存工单
	    	WorkOrder order = new WorkOrder();
	    	order.setDomain(domain);
	    	order.setQuestion(question);
	    	order.setSn(orderForm.getSn());
	    	order.setOperator(operator);
	    	order.setLevel(orderForm.getLevel());
	    	order.setState(2);
	    	order.setNoticeWay(noticeWay);
	    	order.setCreateTime(time);
	    	String endTime = orderForm.getEndTime() + " 23:59:59" ;
	        Timestamp   tempEndtime   =   Timestamp.valueOf(endTime);
	    	order.setEndTime(tempEndtime);
	    	workOrderService.saveOrUpdate(order);
	    	
	    	//向后台发送数据
	    	if(question.getSn()!=null&&question.getSn().length()>0){
	    		winsensorOperationWorkOrdersService.generateWorkOrders(question.getSn(), order.getId().toString());
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
     		if(flag){
                log.setOperationDesc("运维工单,直接生成工单,工单ID为:"+order.getId()+",问题ID为:"+question.getId()+",问题名称为:"+question.getName());
     		}else{
                log.setOperationDesc("运维工单,由问题生成工单,工单ID为:"+order.getId()+",问题ID为:"+question.getId()+",问题名称为:"+question.getName());
     		}
     		log.setControl("成功");
     		logService.saveSystemLog(log);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	}
    
    /**
     * 查看工单
     */
    public ActionForward lookWorkOrder(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    		
    	String id = request.getParameter("id");
    	WorkOrder workOrder = null;
    	if(id!=null&&!"".equals(id)){
    		workOrder=workOrderService.findById(Integer.parseInt(id));
    	}
    	request.setAttribute("workOrder", workOrder);
    	
	    return mapping.findForward("lookOrder");
	}
}
