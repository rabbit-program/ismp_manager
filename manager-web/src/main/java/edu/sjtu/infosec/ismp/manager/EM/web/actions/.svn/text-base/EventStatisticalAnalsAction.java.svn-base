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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.EM.comm.BaseAction;
import edu.sjtu.infosec.ismp.manager.EM.web.form.EventStatisticalAnalsForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * web层 事件统计Action.
 * 
 * @version 2009-06-02
 * @author yang li
 */

public class EventStatisticalAnalsAction extends BaseAction {

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
			if (null != request.getParameter(paramName)
					&& !"".equals(request.getParameter(paramName).trim())) {
				String paramValue = new String(request.getParameter(paramName)
						.getBytes(encoding), "utf-8");
				if (null != paramValue && !paramValue.trim().equals("")) {
					paramMap.put(paramName, paramValue);
					request.setAttribute(paramName, paramValue);
				}
			}
		}
		return paramMap;
	}

	/**
	 * 事件统计分析
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventStatisticalAnalysis(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EventStatisticalAnalsForm statisticalAnalsForm = (EventStatisticalAnalsForm) form;
		
		request.setAttribute("selectType", "sbType");
		Date beginDate = new Date();
		Date endDate = new Date();
		beginDate.setMonth(endDate.getMonth() - 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String begin = format.format(beginDate);
		String end = format.format(endDate);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);
		
		Date bDate = format.parse(begin);
		Date eDate = format.parse(end);

		statisticalAnalsForm.setBeginDate(begin);
		statisticalAnalsForm.setEndDate(end);
		
		Timestamp beginTime = new Timestamp(bDate.getTime());
		Timestamp endTime = new Timestamp(eDate.getTime());
		List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
		request.setAttribute("managerOfUser", managerBo);
		request.setAttribute("beginTime", beginTime);
		request.setAttribute("endTime", endTime);
//		return mapping.findForward("eventStatisticalAnalysis");
		return eventAnalysis(mapping, statisticalAnalsForm, request, response);
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
	 *             根据开始时间和结束时间来进行统计分析
	 */
	public ActionForward eventAnalysis(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EventStatisticalAnalsForm statisticalAnalsForm = (EventStatisticalAnalsForm) form;

		String selectType = request.getParameter("selectType");
		String bureauId = getBureauId(request);//request.getParameter("bureauId");
		if(selectType == null){
			selectType = "sbType";
		}
		String begin = statisticalAnalsForm.getBeginDate();
		String end = statisticalAnalsForm.getEndDate();

		request.setAttribute("selectType", selectType);
		request.setAttribute("begin", begin);
		request.setAttribute("end", end);

		String patter = "yyyy-MM-dd HH:mm";
		SimpleDateFormat format = new SimpleDateFormat(patter);

		Date beginDate = format.parse(begin);
		Date endDate = format.parse(end);

		Timestamp beginTime = new Timestamp(beginDate.getTime());
		Timestamp endTime = new Timestamp(endDate.getTime());

		request.setAttribute("beginTime", beginTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("bureauId", bureauId);
		List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
		request.setAttribute("managerOfUser", managerBo);
//		eventBaseClass.getStatisticsTime().setSafetystarttime(beginTime);
//		eventBaseClass.getStatisticsTime().setSafetyendtime(endTime);

		List<Object> list = null;
		// 根据设备类型来显示柱状图
		if (selectType.equals("sbType")) {
			list = eventBaseClass.getEventStatisticsService().staticticsSafety(
					beginTime, endTime, Integer.parseInt(bureauId));
			request.setAttribute("eventStatisticsList", list);
		}
		// 根据域来显示饼图
		else if (selectType.equals("yu")) {
			list = eventBaseClass.getGetTopoInfo().StatisticsDomain(beginTime,
					endTime, null);
			request.setAttribute("eventStatisticsList", list);
		} else if (selectType.equals("topTen")) {
			list = eventBaseClass.getEventStatisticsService().statisticsFaciip(
					beginTime, endTime, Integer.parseInt(bureauId));
			List<Object> object = new ArrayList<Object>(list.size());
			int value = 200;
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = new Object[4];
				int num = i + 1;
				obj[0] = num;
				if (i >= 1) {
					Object[] obj1 = (Object[]) list.get(i - 1);
					Object[] obj2 = (Object[]) list.get(i);
					float head = (float) Integer.parseInt(obj1[1].toString());
					float last = (float) Integer.parseInt(obj2[1].toString());
					if (head > last) {
						value -= 20;
					}
				}
				obj[1] = value;
				obj[2] = ((Object[]) list.get(i))[1];
				obj[3] = ((Object[]) list.get(i))[0];
				object.add(obj);
			}
			// request.setAttribute("eventStatisticsList", list);
			request.setAttribute("eventStatisticsList", object);
		} else if (selectType.equals("eventType")) {
			list = eventBaseClass.getEventStatisticsService()
					.staticticsEventType(beginTime, endTime, Integer.parseInt(bureauId));
			request.setAttribute("eventStatisticsList", list);
		}
		return mapping.findForward("eventStatisticalAnalysis");
	}

	public ActionForward eventDisplay(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		EventStatisticalAnalsForm statisticalAnalsForm = (EventStatisticalAnalsForm) form;

		// String selectType = request.getParameter("selectType");
		String begin = request.getParameter("beginDate");//statisticalAnalsForm.getBeginDate();
		String end = request.getParameter("endDate");//statisticalAnalsForm.getEndDate();
		String bureauId = getBureauId(request);//request.getParameter("bureauId");
		
		if(begin != null && begin.length() > 0){
			request.setAttribute("begin", begin);
			request.setAttribute("end", end);
		}else{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = new Date();
			Date last = new Date();
			
			start.setMonth(last.getMonth() -1);
			begin = format.format(start);
			end = format.format(last);
			request.setAttribute("begin", begin);
			request.setAttribute("end", end);
		}		

		String patter = "yyyy-MM-dd HH:mm";
		SimpleDateFormat format = new SimpleDateFormat(patter);

		Date beginDate = format.parse(begin);
		Date endDate = format.parse(end);

		Timestamp beginTime = new Timestamp(beginDate.getTime());
		Timestamp endTime = new Timestamp(endDate.getTime());

		request.setAttribute("beginTime", beginTime);
		request.setAttribute("endTime", endTime);
		request.setAttribute("bureauId", bureauId);
		List<Domain> managerBo = (List<Domain>)SecurityUserHolder.getCurrentUser().getDomainList();
		request.setAttribute("managerOfUser", managerBo);		
//		eventBaseClass.getStatisticsTime().setSafetystarttime(beginTime);
//		eventBaseClass.getStatisticsTime().setSafetyendtime(endTime);

		List<Object> list = null;

		list = eventBaseClass.getEventStatisticsService().statisticsFaciip(
				beginTime, endTime, Integer.parseInt(bureauId));
		List<Object> object = new ArrayList<Object>(list.size());
		int value = 200;
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = new Object[4];
			int num = i + 1;
			obj[0] = num;
			if (i >= 1) {
				Object[] obj1 = (Object[]) list.get(i - 1);
				Object[] obj2 = (Object[]) list.get(i);
				float head = (float) Integer.parseInt(obj1[1].toString());
				float last = (float) Integer.parseInt(obj2[1].toString());
				if (head > last) {
					value -= 20;
				}
			}
			obj[1] = value;
			obj[2] = ((Object[]) list.get(i))[1];
			obj[3] = ((Object[]) list.get(i))[0];
			object.add(obj);
		}
		request.setAttribute("eventStatisticsList", object);
		return mapping.findForward("eventDisplay");
	}
	
	public String getBureauId(HttpServletRequest request){
		String bureauId = request.getParameter("bureauId");
		List<Domain> managerBoList = SecurityUserHolder.getCurrentUser().getDomainList();
		if(bureauId == null || bureauId.equals("")){
			if(managerBoList != null && managerBoList.size() > 0){
				Domain managerBo = managerBoList.get(0);
				bureauId = managerBo.getId().toString();
			}
		}
		return bureauId==null?"0":bureauId;
	}
}
