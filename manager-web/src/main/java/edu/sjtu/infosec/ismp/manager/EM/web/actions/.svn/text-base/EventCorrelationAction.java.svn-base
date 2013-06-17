package edu.sjtu.infosec.ismp.manager.EM.web.actions;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.EM.comm.BaseAction;
import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventcorrruleResult;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventrealdispResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventcorrrule;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;
import edu.sjtu.infosec.ismp.manager.EM.util.PageUtil;
import edu.sjtu.infosec.ismp.manager.EM.web.form.EventCorrelationForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

/**
 * web层 事件关联Action.
 * 
 * @version 2009-06-02
 * @author yang li
 */

public class EventCorrelationAction extends BaseAction {
	
	//private static int curPage = 1;
	
	private static final int everyPageSize = 18;

	protected final Log log = LogFactory.getLog(getClass());
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private EventBaseClass eventBaseClass;
	private OperatorDetails eventLogClass = null;
	public void setEventBaseClass(EventBaseClass eventBaseClass) {
		this.eventBaseClass = eventBaseClass;
	}
	
	/**
	 * 获取查询参数
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 查询参数Map
	 * @throws UnsupportedEncodingException
	 */
	public Map getParamMap(HttpServletRequest request)
			throws UnsupportedEncodingException {
		Map paramMap = new HashMap();
		String encoding = "ISO-8859-1";
//		String encoding = "GBK";
		Enumeration paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if (null != request.getParameter(paramName)
					&& !"".equals(request.getParameter(paramName).trim())) {
				String paramValue = new String(request.getParameter(paramName)
						.getBytes(), "utf-8");
				if (null != paramValue && !paramValue.trim().equals("")) {
					paramMap.put(paramName, paramValue);
					request.setAttribute(paramName, paramValue);
				}
			}
		}
		return paramMap;
	}
	
	/**
	 * 得到委办局ID
	 * @param request
	 * @return
	 */
	public Integer getBureauId(HttpServletRequest request){
		String bureauId = request.getParameter("bureauId");
		Integer id = new Integer(0);
		if(bureauId == null || bureauId.equals("")){
			List<Domain> managerBoList = SecurityUserHolder.getCurrentUser().getDomainList();
			if(managerBoList != null && managerBoList.size() > 0){
				Domain managerBo = managerBoList.get(0);
				id = managerBo.getId();
			}
		}else{
			id = Integer.parseInt(bureauId);
		}
		return id;
	}

	/**
	 * 跳转到事件关联页面，带过一个事件关联表记录的list
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventCorrelation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		page.setEveryPage(15);

		// mark用来标记选择跳转到的页数
		String pageMark = request.getParameter("mark");
		String pageNo = request.getParameter("pageno") == null ? "1" : request.getParameter("pageno");

		if (null == pageMark) {
			pageMark = pageNo;
			page.setCurrentPage(Integer.parseInt(pageNo));
			request.setAttribute("pageMark", Integer.parseInt(pageMark));
		} else {
			page.setCurrentPage(Integer.parseInt(pageMark==""?"1":pageMark));
			request.setAttribute("pageMark", pageMark);
		}
		
		EventcorrruleResult results = eventBaseClass.getEventcorrruleService().queryAllByPage(page, SecurityUserHolder.getCurrentUser().getUsername());
		if(results != null){
			List<Eventcorrrule> list = results.getEvcors();
			page = results.getPage();
			request.setAttribute("eventcorrruleList", list);
			request.setAttribute("page", page);
		}else{
			request.setAttribute("page", new Page());
		}
		
		return mapping.findForward("eventCorrelation");
	}

	/**
	 * 添加事件关联规则
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventCorrelationSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * 日志信息添加
		 */
		eventLogClass = SecurityUserHolder.getCurrentUser();
		eventBaseClass.getLogService().saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "事件模块", 
				"添加事件关联规则", Timestamp.valueOf(sdf.format(new Date())), "true");
//		System.out.println(request.getContentType());
//		request.setCharacterEncoding("UTF-8");
		EventCorrelationForm eventCorrelationForm = (EventCorrelationForm)form;
//		Map map = getParamMap(request);
		Eventcorrrule eventcorrrule = new Eventcorrrule();
		BeanUtils.copyProperties(eventcorrrule, eventCorrelationForm);
		eventcorrrule.setUserName(eventLogClass.getUsername());
		eventcorrrule.setOperation((byte)1);
		eventBaseClass.getEventcorrruleService().add(eventcorrrule);
		return eventCorrelation(mapping, form, request, response);
	}
	
	/**
	 * 关联规则应用
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventCorrelationInUse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		/**
		 * 日志信息添加
		 */
		eventLogClass = SecurityUserHolder.getCurrentUser();
		List<Domain> managerBoList = eventLogClass.getDomainList();
		Integer[] ids = new Integer[managerBoList.size()];//当前登陆用户所属委办局的数组
		if(managerBoList != null && managerBoList.size() > 0){
			for(int i = 0; i < managerBoList.size(); i ++){
				Domain managerBo = managerBoList.get(i);
				int id = managerBo.getId();
				ids[i] = id;
			}
		}
		eventBaseClass.getLogService().saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "事件模块",  
				"关联规则应用", Timestamp.valueOf(sdf.format(new Date())), "");
		Page page = new Page();
		page.setEveryPage(everyPageSize);
		
		String pageMark = request.getParameter("mark");
		String pageNo = request.getParameter("pageno") == null ? "1" : request.getParameter("pageno");

		if (null == pageMark) {
			pageMark = pageNo;
			page.setCurrentPage(Integer.parseInt(pageNo));
			request.setAttribute("pageMark", Integer.parseInt(pageMark));
		} else {
			page.setCurrentPage(Integer.parseInt(pageMark==""?"1":pageMark));
			request.setAttribute("pageMark", pageMark);
		}
		
		String useIn = request.getParameter("useIn");
		String winLen = request.getParameter("winLen");
		String inUseStri = "";
//		传多个关联规则的ID的字符串：inUseStri；时间戳：timeLen(时间戳改为毫秒：秒*1000；分*1000*60)
		if(useIn != null && useIn.length() > 0){
			inUseStri = useIn.substring(0, useIn.length() - 1);
		}
		long timeLen = Long.parseLong(winLen) * 1000;
		/**
		 * 把inUseStri和timeLen传入到service层调用方法返回一个List，对这个List进行分页
		 */
		List<Eventrealdisp> eventRealDispList = eventBaseClass.getEventStatisticsService().queryEventrealdispByRules(inUseStri, timeLen, ids);
		EventrealdispResult results = myListGroup(page, eventRealDispList);
		//表示的分页后的List，但是这个list里面存储的是一个数组
		List<Object> realDispList = new ArrayList<Object>();

		if(results != null){
			realDispList = results.getList();//list里面存储的是数组
			page = results.getPage();
		}
		request.setAttribute("timeLen", winLen);
		request.setAttribute("useIn", useIn);
		request.setAttribute("page", page);
		request.setAttribute("realDispList", realDispList);
		return mapping.findForward("eventCorrelationInUse");
	}
	
	/**
	 * 将一个List进行分页
	 * @param page
	 * @param list
	 * @return
	 */
	public static EventrealdispResult myListGroup(Page page, List<Eventrealdisp> list){
		if(list != null && list.size() > 0){
			EventrealdispResult result = new EventrealdispResult();
			PageUtil util = new PageUtil();
			page = util.createPage(page.getEveryPage(), page.getCurrentPage(), list.size());
			List<Object> targetList = new ArrayList<Object>();
			int begin = page.getEveryPage() * (page.getCurrentPage() - 1);
			int end = begin + everyPageSize;
			for(int i = begin; i < end; i ++){
				if(i < list.size()){
					targetList.add(list.get(i));
				}
			}
			result.setPage(page);
			result.setList(targetList);
			return result;
		}
		return null;
	}
	
	/**
	 * 该方法用来删除点击关联规则应用后的数据
	 */
	public ActionForward eventCorrelationDel(ActionMapping mapping, 
					ActionForm form, HttpServletRequest request,
					HttpServletResponse response) throws Exception{
		String str = request.getParameter("deleteIn");
		List ids = new ArrayList();
		for(String s : str.split(",")){
			ids.add(Integer.parseInt(s));
		}
		eventBaseClass.getEventrealdispService().delete(ids);
		return eventCorrelationInUse(mapping, form, request, response);
	}
	
	/**
	 * 该方法用来删除关联规则
	 */
	public ActionForward correlationDelete(ActionMapping mapping, ActionForm form,
					HttpServletRequest request, HttpServletResponse response)
					throws Exception{
		/**
		 * 日志信息添加
		 */
		eventLogClass = SecurityUserHolder.getCurrentUser();
		eventBaseClass.getLogService().saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "事件模块", 
				"关联规则删除", Timestamp.valueOf(sdf.format(new Date())), "");
		String ids = request.getParameter("deleteIn");
		List list = new ArrayList();
		for(String id : ids.split(",")){
			list.add(Integer.parseInt(id));
		}
		eventBaseClass.getEventcorrruleService().delete(list);
		return eventCorrelation(mapping, form, request, response);
	}
	
	/**
	 * 进行修改页面的跳转
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventCorrelationUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String id = request.getParameter("id");
		Eventcorrrule eventcorrrule = eventBaseClass.getEventcorrruleService().get(Integer.parseInt(id));
		request.setAttribute("eventcorrrule", eventcorrrule);
		return eventCorrelation(mapping, form, request, response);
	}
	
	/**
	 * 执行修改的操作
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventCorrelationDoUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		/**
		 * 日志信息添加
		 */
		eventLogClass = SecurityUserHolder.getCurrentUser();
		eventBaseClass.getLogService().saveSystemLog(eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "事件模块", 
				"修改关联规则", Timestamp.valueOf(sdf.format(new Date())), "");
		EventCorrelationForm eventCorrelationForm = (EventCorrelationForm)form;
//		Map map = getParamMap(request);
		Eventcorrrule eventcorrrule = new Eventcorrrule();
		BeanUtils.copyProperties(eventcorrrule, eventCorrelationForm);
		eventcorrrule.setOperation((byte)1);
		eventcorrrule.setUserName(eventLogClass.getUsername());
		eventBaseClass.getEventcorrruleService().update(eventcorrrule);
		
		return eventCorrelation(mapping, form, request, response);
	}
}
