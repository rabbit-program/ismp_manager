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
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniinfoCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventrealdispCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniinfoResult;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventrealdispResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoniinfo;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;
import edu.sjtu.infosec.ismp.manager.EM.web.form.EventSelectConditionForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * web层 事件查询Action.
 * 
 * @version 2009-06-02
 * @author yang li
 */

public class EventSelectConditionAction extends BaseAction {

	protected final Log log = LogFactory.getLog(getClass());
	
	private EventBaseClass eventBaseClass;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		Enumeration paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if (null != request.getParameter(paramName) && !"".equals(request.getParameter(paramName).trim())) {
				String paramValue = new String(request.getParameter(paramName).getBytes(encoding), "utf-8");
				if (null != paramValue && !paramValue.trim().equals("")) {
					paramMap.put(paramName, paramValue);
					request.setAttribute(paramName, paramValue);
				}
			}
		}
		return paramMap;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 
	 * 跳转到事件查询页面，并初始化查询时间
	 */
	public ActionForward eventSelectCondition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws Exception {
		getDefaultTime(request);
		return selectByCondition(mapping, form, request, response);
	}
	
	/**
	 * 在跳转到事件查询页面的时候初始化查询的起止时间
	 * @param request
	 */
	public void getDefaultTime(HttpServletRequest request){
		Date beginDate = new Date();
		Date endDate = new Date();
		beginDate.setMonth(endDate.getMonth() - 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String begin = format.format(beginDate);
		String end = format.format(endDate);
		request.setAttribute("beginDate", begin);
		request.setAttribute("endDate", end);
		
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
	}
	
	/**
	 * 通过输入的多条件来查询事件，进行分页显示
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward selectByCondition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
//		System.out.println("------------------------");
//		EventSelectConditionForm selectForm = (EventSelectConditionForm)form;
		getDefaultTime(request);
		EventSelectConditionForm selectForm = (EventSelectConditionForm)request.getSession().getAttribute("eventSelectConditionForm");
		
		String begin = request.getParameter("beginDate");
		String end = request.getParameter("endDate");
		
//		System.out.println("------begin------" + begin);
//		System.out.println("------end------" + end);
		
		String bureauId = request.getParameter("bureauId");
		List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
		if(bureauId == null || bureauId.equals("")){
			if(managerBo != null && managerBo.size() > 0){
				bureauId = managerBo.get(0).getId().toString();
			} 
		}
		request.setAttribute("managerOfUser", managerBo);
		request.setAttribute("bureauId", bureauId);
		if(begin == null && request.getAttribute("beginDate") != null){
			begin = request.getAttribute("beginDate").toString();
		}
		if(end == null && request.getAttribute("endDate") != null){
			end = request.getAttribute("endDate").toString();
		}

		Map map = getParamMap(request);
		Page page = new Page();
		page.setEveryPage(7);
		
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
		
//		EventSelectConditionForm conditionForm = (EventSelectConditionForm)form;
		EventrealdispCondition condition = new EventrealdispCondition();
		condition.setBureauId(Integer.parseInt(bureauId==null?"0":bureauId));
		condition.setPage(page);

		String patter = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(patter);
		
		if(null != begin && !"".equals(begin.trim())){
			Date beginDate = format.parse(begin);
			Timestamp beginTime = new Timestamp(beginDate.getTime());
//			System.out.println("------beginTime------" + beginTime);

			condition.setStarttime(beginTime);
		}
		if(null != end && !"".equals(end.trim())){
			Date endDate = format.parse(end);
			Timestamp endTime = new Timestamp(endDate.getTime());
//			System.out.println("------endTime------" + endTime); 
			
			condition.setEndtime(endTime);
		}

		BeanUtils.copyProperties(condition, map);
		if(selectForm != null){
			if(selectForm.getEvent_type() != null){
				condition.setEvent_type(selectForm.getEvent_type());
			}
			if(selectForm.getFaci_type() != null){
				condition.setFaci_type(selectForm.getFaci_type());
			}
		}
		
//		request.setAttribute("event_type", selectForm.getEvent_type());
//		request.setAttribute("faci_type()", selectForm.getFaci_type());
		if(request.getParameter("select").trim().equals("safe")){
			EventrealdispResult result = eventBaseClass.getEventrealdispService().queryEventrealdispByCondition(condition);
			List<Eventrealdisp> eventrealdisp = new ArrayList<Eventrealdisp>();
			if(result != null && result.getResults() != null && !result.getResults().isEmpty()){
				page = result.getPage();
				eventrealdisp = result.getResults();
//				for(Eventrealdisp e:eventrealdisp){
//					System.out.println(e.getDestIp());
//					System.out.println(e.getEventTime());
//					System.out.println(e.getDomain().getDomainName());
//				}
			}
				
			request.setAttribute("page", page);
			request.setAttribute("eventrealdispList", eventrealdisp);
		}
		
		return mapping.findForward("eventSelectCondition");
	}
	
	public ActionForward selectByJianKong(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		EventSelectConditionForm selectForm = (EventSelectConditionForm)request.getSession().getAttribute("eventSelectConditionForm");
		String bureauId = request.getParameter("bureauId");
		List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
		if(bureauId == null || bureauId.equals("")){
			if(managerBo != null && managerBo.size() > 0){
				bureauId = managerBo.get(0).getId().toString();
			} 
		}
		getDefaultTime(request);
		
		Page page = new Page();
		page.setEveryPage(7);
		
		String pageMark = request.getParameter("marks");
		String pageNo = request.getParameter("pageno") == null ? "1" : request.getParameter("pageno");

		if (null == pageMark) {
			pageMark = pageNo;
			page.setCurrentPage(Integer.parseInt(pageNo));
			request.setAttribute("pageMarks", Integer.parseInt(pageMark));
		} else {
			page.setCurrentPage(Integer.parseInt(pageMark==""?"1":pageMark));
			request.setAttribute("pageMarks", pageMark);
		}
		
		EventmoniinfoCondition condition = new EventmoniinfoCondition();
//		condition.setBureauId(Integer.parseInt(bureauId));
		Map map = getParamMap(request);
		if(map.get("begin") != null && map.get("end") != null){
			String startTime = map.get("begin").toString();
			String endTime = map.get("end").toString();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date begin = format.parse(startTime);
			Date end = format.parse(endTime);
			
			
			condition.setStartTime(begin);
			condition.setEndTime(end);
		}
		if(selectForm != null){
			if(selectForm.getEventTypes() != null){
				condition.setEventType(selectForm.getEventTypes());
			}
			if(selectForm.getIPAddress() != null){
				condition.setIpAddress(selectForm.getIPAddress());
			}
		}
//		request.setAttribute("eventTypes", selectForm.getEventTypes());
		condition.setPage(page);
		EventmoniinfoResult result = eventBaseClass.getEventmoniinfoService().queryEventmoniinfoByCondition(condition);
		List<Eventmoniinfo> eventmoniinfo = new ArrayList<Eventmoniinfo>();
		if(result != null && result.getResults() != null && !result.getResults().isEmpty()){
			page = result.getPage();
			eventmoniinfo = result.getResults();
		}
		request.setAttribute("page", page);
		request.setAttribute("eventmoniinfoList", eventmoniinfo);
		request.setAttribute("bureauId", bureauId);
		request.setAttribute("managerOfUser", managerBo);
		return mapping.findForward("eventSelectCondition");
	}
	
	public ActionForward reset(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		ActionForward forward = selectMethod(mapping, form, request, response);
		request.getSession().setAttribute("eventSelectConditionForm", null);
		getDefaultTime(request);
		request.setAttribute("select", request.getParameter("select"));
//		return mapping.findForward("eventSelectCondition");
		return forward;
	}
	
	public ActionForward selectMethod(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String select = request.getParameter("select");
		if(select.trim().equals("safe")){
			return selectByCondition(mapping, form, request, response);
		}else if (select.trim().equals("jiank")){
			return selectByJianKong(mapping, form, request, response);
		}else{
			return null;
		}
	}
}
