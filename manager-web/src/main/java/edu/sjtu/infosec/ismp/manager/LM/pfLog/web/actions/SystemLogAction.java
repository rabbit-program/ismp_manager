package edu.sjtu.infosec.ismp.manager.LM.pfLog.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.web.form.SystemLogActionForm;
import edu.sjtu.infosec.ismp.manager.LM.util.InitQueryDate;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;

public class SystemLogAction extends DispatchAction {
	
	private SystemLogService systemlogService;
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<String> initDate = InitQueryDate.initQueryDate(30);
		
		SystemLogActionForm systemLogActionForm = (SystemLogActionForm) form;
		if(systemLogActionForm.getBeginDate()==null){
			systemLogActionForm.setBeginDate(initDate.get(0));
			systemLogActionForm.setEndDate(initDate.get(1));
		}
		
		request.setAttribute("dateList", initDate);
		return query(mapping, form, request, response);
	}
	
	public ActionForward query(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SystemLog log = new SystemLog();
		SystemLogActionForm systemLogActionForm = (SystemLogActionForm) form;
//		System.out.println("--------------"+systemLogActionForm.getModuleName());
		
		
		PageBean pageBean = new PageBean();
		
		if(request.getParameter("type")==null || !request.getParameter("type").equals("page")){
			if(!systemLogActionForm.getModuleName().equals("all")){
				BeanUtils.copyProperties(log, systemLogActionForm);
//				System.out.println("--------------"+log.getModuleName()+"--"+log.getTime());
			}
			
			List dateList = new ArrayList();
			dateList.add(systemLogActionForm.getBeginDate());
			dateList.add(systemLogActionForm.getEndDate());
			
			request.getSession().setAttribute("systemLogListQuery_date", dateList);
			request.getSession().setAttribute("systemLogListQuery_log", log);
		}
		
		
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null && request.getParameter("pageNo")!="")
			pageNo = Integer.valueOf(request.getParameter("pageNo"));
		
		pageBean.setPageRowNum(12);
		pageBean.setPageNo(pageNo);
		
		List<SystemLog> systemlog = systemlogService.getPageBySystemLog((SystemLog)request.getSession().getAttribute("systemLogListQuery_log"), (pageBean.getPageNo()-1)*pageBean.getPageRowNum(), pageBean.getPageRowNum(), Timestamp.valueOf(((List)request.getSession().getAttribute("systemLogListQuery_date")).get(0).toString()), Timestamp.valueOf(((List)request.getSession().getAttribute("systemLogListQuery_date")).get(1).toString()));
		pageBean.setResultRowSum(systemlogService.getSystemLogCount((SystemLog)request.getSession().getAttribute("systemLogListQuery_log"), Timestamp.valueOf(((List)request.getSession().getAttribute("systemLogListQuery_date")).get(0).toString()), Timestamp.valueOf(((List)request.getSession().getAttribute("systemLogListQuery_date")).get(1).toString())));
		
		pageBean.setPageMaxSum((pageBean.getResultRowSum()+(pageBean.getPageRowNum()-1))/pageBean.getPageRowNum());
		pageBean.setPageResult(systemlog);
		
		request.setAttribute("pageResult", pageBean);
		
//		System.out.println("----------PageBean--source-------");
//		System.out.println("当前页：" + pageBean.getPageNo());
//		System.out.println("一共多少页：" + pageBean.getPageMaxSum());
//		System.out.println("每页多少行：" + pageBean.getPageRowNum());
//		System.out.println("一共多少行：" + pageBean.getResultRowSum());
//		System.out.println("符合查询数：" + pageBean.getPageResult().size());
//		System.out.println("----------PageBean--source-------");
		
		return mapping.findForward("systemLogDisplay");
	}

	
	public SystemLogService getSystemlogService() {
		return systemlogService;
	}

	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}

}
