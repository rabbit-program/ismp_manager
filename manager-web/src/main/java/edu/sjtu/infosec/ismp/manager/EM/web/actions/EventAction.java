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
import org.apache.struts.action.ActionMessages;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

import edu.sjtu.infosec.ismp.manager.EM.comm.BaseAction;
import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventmoniinfoCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventrealdispCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventGetTopoResult;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniResult;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventmoniinfoResult;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventrealdispResult;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoniinfo;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

/**
 * web层 事件监测Action.
 * 
 * @version 2009-06-02
 * @author yang li
 */

public class EventAction extends BaseAction {

	// private static int inTimeReportMarkJspMaxCount = 20;

	protected final Log log = LogFactory.getLog(getClass());
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private ActionMessages messages = new ActionMessages();
	private OperatorDetails eventLogClass =null;
	private EventBaseClass eventBaseClass;

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

	public ActionForward top(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("top");
	}

	public ActionForward childFrame(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("child");
	}

	/**
	 * 分页功能
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward showListByTag(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		eventLogClass = SecurityUserHolder.getCurrentUser();
		Page page = new Page();
		page.setEveryPage(15);

		String bureauId = request.getParameter("bureauId");
		List<Domain> managerBoList = SecurityUserHolder.getCurrentUser().getDomainList();
		Integer[] bureauIds = null;
		if (bureauId != null && !bureauId.equals("")) {// 如果用户选择特定委办局时
			bureauIds = new Integer[1];
			bureauIds[0] = Integer.parseInt(bureauId);
		} else if (managerBoList != null) {// 用户第一次登陆或是没有选择特定委办局时
			bureauIds = new Integer[managerBoList.size()];
			Domain bo = null;
			for (int i = 0; i < managerBoList.size(); i++) {
				bo = managerBoList.get(i);
				bureauIds[i] = bo.getId();
			}
		} else {// 登陆的用户不属于任何委办局时
			bureauIds = new Integer[1];
		}
		
		request.setAttribute("managerOfUser", managerBoList);
		
		Map paramMap = getParamMap(request);
		// mark用来标记选择跳转到的页数
		String pageMark = request.getParameter("mark");// 1&eventName=IDS
		String pageNo = request.getParameter("pageno") == null ? "1" : request
				.getParameter("pageno");

		if (null == pageMark) {
			pageMark = pageNo;
			page.setCurrentPage(Integer.parseInt(pageNo));
			request.setAttribute("pageMark", Integer.parseInt(pageMark));
		} else {
			page.setCurrentPage(Integer.parseInt(pageMark == "" ? "1"
					: pageMark));
			request.setAttribute("pageMark", pageMark);
		}
		EventmoniCondition condition = new EventmoniCondition();
		condition.setPage(page);
		String eventName = request.getParameter("eventName");
		EventGetTopoResult result = null;

		/*
		 * Integer[] str = null; if(managerBoList != null &&
		 * managerBoList.size() > 0){ str = new Integer[managerBoList.size()];
		 * for(int i = 0; i < managerBoList.size(); i ++){ ManagerBO managerBo =
		 * (ManagerBO)managerBoList.get(i); str[i] = managerBo.getId(); } }
		 */
		// eventName = 1,2,3分别表示的是自定义事件一，二，三；如果eventName不为空则进行自定义事件的分页查询
		if (request.getParameter("eventName") != null
				&& !"".equals(request.getParameter("eventName").trim())) {
			request.setAttribute("eventName", eventName);
			result = eventBaseClass.getEventmoniService()
					.queryEventByCustomize(eventLogClass.getUsername(),
							Integer.parseInt(eventName), bureauIds, page);
			// result =
			// eventBaseClass.getEventmoniService().queryEventByCustomize
			// (Integer.parseInt(eventName), page);
		} else {
			// 如果eventNaqme为空的话则表示的是进行全部事件的分页查询
			result = eventBaseClass.getGetTopoInfo().getTopoInfo(page,
					bureauIds);
			// result =
			// eventBaseClass.getEventmoniService().queryEventmoniByCondition
			// (condition);
		}
		if(result != null){
			page = result.getPage();
			List<Object[]> eventList = result.getDatas();
			request.setAttribute("page", page);
			request.setAttribute("eventList", eventList);
			if (eventList != null && eventList.size() > 0) {
				int size = eventList.size();
				request.setAttribute("eventListSize", size);
				/*
				 * for(int i = 0; i < eventList.size(); i ++){ Object[] obj =
				 * (Object[])eventList.get(i);
				 * System.out.println("EventAction-----------------------"
				 * +obj.length+"-------------------------------------EventList"); }
				*/
			}
		}

			// response.getWriter().close();
		if (request.getParameter("isFirst") != null
				&& request.getParameter("isFirst").trim().equals("true")) {
			return mapping.findForward("eventListFirst");
		} else {
			return mapping.findForward("eventList");
		}
		
	}

	/**
	 * 删除功能
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * 
	 *             可以多条删除或是单条删除
	 */
	public ActionForward deleteEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * 日志信息添加
		 * 
		 */
		eventLogClass = SecurityUserHolder.getCurrentUser();
		
		eventBaseClass.getLogService().saveSystemLog(
				eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "事件模块",  "自定义事件删除", Timestamp.valueOf(sdf.format(new Date())), "");
		// 1@12,2@12,3@12
		String ids = request.getParameter("deleteIn");
		String mark = request.getParameter("mark");
		String event = request.getParameter("eventName");
		String[] idStr = ids.split(",");
		List idList = new ArrayList();// mac地址
		for (int i = 0; i < idStr.length; i++) {
			String every = idStr[i];
			idList.add(idStr[i].substring(0, idStr[i].indexOf("@")));
		}
		// System.out.println(idList.toString());
		eventBaseClass.getEventtaskseleService().delete(
				eventLogClass.getUsername(), event, idList);// .
		// getEventmoniService
		// (
		// ).delete(idList);
		return showListByTag(mapping, form, request, response);
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 
	 *             添加自定义事件
	 */
	public ActionForward addDefineEvent(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * 日志信息添加
		 */
		eventLogClass = SecurityUserHolder.getCurrentUser();
		eventBaseClass.getLogService().saveSystemLog(
				eventLogClass.getUsername(), 
				eventLogClass.getRoleList().get(0).getName(), "事件模块", "自定义事件添加", Timestamp.valueOf(sdf.format(new Date())), "");
		String ids = request.getParameter("defineEventCondition");
		String str = ids.substring(0, ids.lastIndexOf(","));
		StringBuffer sb = new StringBuffer();
		String[] string = str.split(",");
		for (int i = 0; i < string.length; i++) {
			sb.append(string[i].substring(string[i].lastIndexOf("@") + 1))
					.append(",");
		}
		String result = sb.toString().substring(0,
				sb.toString().lastIndexOf(","));
		String eventNumber = ids.substring(ids.lastIndexOf(",") + 1, ids
				.length());
		// eventLogClass = new EventLogClass(request);
		eventBaseClass.getEventtaskseleService().save(
				eventLogClass.getUsername(), Integer.parseInt(eventNumber),
				result);
		return showListByTag(mapping, form, request, response);
	}

	/**
	 * 跳到实时显示页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventInTimeSpecific(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 System.out.println("eventInTimeSpecific");
		 eventLogClass = SecurityUserHolder.getCurrentUser();
		if (eventLogClass.getDomainList() != null) {
			List<Domain> managerBoList = eventLogClass.getDomainList();
			String bureauId = request.getParameter("bureauId");
//			Integer[] bureauIds = null;
			StringBuffer bureauIds = new StringBuffer();
			if (bureauId == null || bureauId.equals("")) {
				if (managerBoList != null) {
					for (int i = 0; i < managerBoList.size(); i++) {
						Domain managerBo = managerBoList.get(i);
						if(managerBo != null){
							if(i == 0){
								bureauIds.append(managerBo.getId());
							}else{
								bureauIds.append(",").append(managerBo.getId());
							}
						}
					}
				}
			}else{
				bureauIds.append(bureauId);
				request.setAttribute("bureauId", bureauId);
			}
			request.setAttribute("bureauIds", bureauIds);
			request.setAttribute("managerBoList", managerBoList);
		}
		String maxCount = request.getParameter("maxCount");
		request.setAttribute("maxCount", maxCount);
		
		System.out.println("maxCount=" + maxCount);
		// request.getSession().setAttribute("inTimeReportMarkJspMaxCount",
		// inTimeReportMarkJspMaxCount);
		return mapping.findForward("inTimeReportMark");
	}

	/**
	 * 通过该方法实现行情报表页面的显示
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventSpecific(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EventrealdispCondition condition = new EventrealdispCondition();
		Page page = new Page();
		page.setEveryPage(15);

		String pageMark = request.getParameter("mark");// 1&eventName=IDS
		String pageNo = request.getParameter("pageno") == null ? "1" : request
				.getParameter("pageno");

		if (null == pageMark) {
			pageMark = pageNo;
			page.setCurrentPage(Integer.parseInt(pageNo));
			request.setAttribute("pageMark", Integer.parseInt(pageMark));
		} else {
			page.setCurrentPage(Integer.parseInt(pageMark == "" ? "1"
					: pageMark));
			request.setAttribute("pageMark", pageMark);
		}

		String ip = request.getParameter("faci_ip");
		String bureauId = request.getParameter("bureauId");
		/*if (bureauId != null && !bureauId.trim().equals("")) {
			EventmoniCondition eventMoniCondition = new EventmoniCondition();
			Page eventPage = new Page();
			eventPage.setCurrentPage(1);
			eventPage.setEveryPage(10);
			eventMoniCondition.setFaci_ip(ip);
			eventMoniCondition.setPage(eventPage);
			eventMoniCondition.setBureauId(Integer.parseInt(bureauId==null?"0":bureauId));
			EventmoniResult eventmoniResult = eventBaseClass
					.getEventmoniService().queryEventmoniByCondition(
							eventMoniCondition);
			// if(eventmoniResult != null){
			// if(eventmoniResult.getResults() != null){
			// eventmoni = eventmoniResult.getResults().get(0);
			// }
			// }
		}*/
		// eventBaseClass.getServiceClient().setValueToPipe(ip);
		/**
		 * 把IP传入到pipe里面去，并得到一个List到页面上显示
		 * 
		 */
		condition.setSrc_ip(ip);
		condition.setPage(page);
		condition.setBureauId(Integer.parseInt(bureauId==null?"0":bureauId));
		EventrealdispResult result = eventBaseClass.getEventrealdispService()
				.queryEventrealdispByCondition(condition);
		page = result.getPage();

//		String bureauId = request.getParameter("bureauId");

		NodeEntity topoManageDevice = eventBaseClass.getGetTopoInfo()
				.queryByIpBureauId(ip, Integer.parseInt(bureauId));

		List list = new ArrayList();
		list.add(ip);
		if (topoManageDevice != null) {
			list.add(topoManageDevice.getDomain().getDomainName());
		} else {
			list.add("");
		}
		// list.add(request.getParameter("name"));
		list.add(request.getParameter("init"));
		list.add(request.getParameter("curr"));
		list.add(request.getParameter("max"));
		list.add(request.getParameter("min"));
		list.add(request.getParameter("thre"));

		// request.setAttribute("eventmoni", eventmoni);
		request.setAttribute("faci_ip", ip);
		request.setAttribute("bureauId", bureauId);
		request.setAttribute("page", page);
		request.setAttribute("paraList", list);
		request.setAttribute("eventrealdispList", result.getResults());
		if (result.getResults() != null) {
			request.setAttribute("listSize", result.getResults().size());
		} else {
			request.setAttribute("listSize", 10);
		}

		return mapping.findForward("markReport");
	}

	/**
	 * 双击事件监测某条记录的时候显示到分时走势页面
	 * 
	 * 通过该方法实现分时走势页面的显示
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward eventTimeTrend(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String ip = request.getParameter("faci_ip");

		Page pg = new Page();
		pg.setCurrentPage(1);
		pg.setEveryPage(15);

		String bureauId = request.getParameter("bureauId");

		NodeEntity topoManageDevice = eventBaseClass.getGetTopoInfo()
				.queryByIpBureauId(ip, Integer.parseInt(bureauId));

		List list = new ArrayList();
		list.add(ip);
		if (topoManageDevice != null) {
			list.add(topoManageDevice.getDomain().getDomainName());
		} else {
			list.add("");
		}
		list.add(request.getParameter("init"));
		list.add(request.getParameter("curr"));
		list.add(request.getParameter("max"));
		list.add(request.getParameter("min"));
		list.add(request.getParameter("thre"));
		list.add(request.getParameter("total"));

		EventmoniCondition eventMoniCondition = new EventmoniCondition();
		Page eventPage = new Page();
		eventPage.setCurrentPage(1);
		eventPage.setEveryPage(15);
		eventMoniCondition.setPage(eventPage);
		eventMoniCondition.setBureauId(Integer.parseInt(bureauId==null?"0":bureauId));
		EventmoniResult eventmoniResult = eventBaseClass.getEventmoniService()
				.queryEventmoniByCondition(eventMoniCondition);
		request.setAttribute("faci_ip", ip);
		request.setAttribute("bureauId", bureauId);
		request.setAttribute("paraList", list);

		return mapping.findForward("eventTimeTrend");
	}

	public ActionForward monitoringInformation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		page.setEveryPage(15);

		String pageMark = request.getParameter("mark");// 1&eventName=IDS
		String pageNo = request.getParameter("pageno") == null ? "1" : request
				.getParameter("pageno");

		if (null == pageMark) {
			pageMark = pageNo;
			page.setCurrentPage(Integer.parseInt(pageNo));
			request.setAttribute("pageMark", Integer.parseInt(pageMark));
		} else {
			page.setCurrentPage(Integer.parseInt(pageMark == "" ? "1"
					: pageMark));
			request.setAttribute("pageMark", pageMark);
		}

		EventmoniinfoCondition condition = new EventmoniinfoCondition();
		condition.setPage(page);
		//condition.setBureauId(Integer.parseInt(request.getParameter("bureauId")));
		condition.setIpAddress(request.getParameter("faci_ip"));
		getParamMap(request);
		EventmoniinfoResult result = eventBaseClass.getEventmoniinfoService()
				.queryEventmoniinfoByCondition(condition);
		page = result.getPage();
		List<Eventmoniinfo> eventmoniinfo = result.getResults();

		request.setAttribute("page", page);
		request.setAttribute("eventmoniinfoList", eventmoniinfo);
		return mapping.findForward("monitoring_information");
	}

	/**
	 * 查看关联资产
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deviceInView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		System.out
//				.println("^^^^^^^^^^^^^^^^^^^^^^deviceInView^^^^^^^^^^^^^^^^^^^^^^^^^");
//		// String eventmoniId = request.getParameter("id");
//		String faciIp = request.getParameter("eventFaciIp");
//		String bureauId = request.getParameter("bureauId");
//		//eventBaseClass.getEventStatisticsService().queryAssetDeviceBOByFaciip(
//		// "", 1);
////		AssetDeviceBO assetDeviceBO = eventBaseClass
////				.getEventStatisticsService().queryAssetDeviceBOByFaciip(faciIp,
////						Integer.parseInt(bureauId));
//
//		request.getSession().setAttribute("assetDeviceBO", assetDeviceBO);
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//
//		if (assetDeviceBO != null) {
//			StringBuffer sb = new StringBuffer();
//			sb.append("您查看的设备所关联的资产信息为\n\n");
//			String name = assetDeviceBO.getName() == null ? "" : assetDeviceBO
//					.getName();
//			String assetType = assetDeviceBO.getAssetType() == null ? ""
//					: assetDeviceBO.getAssetType().toString().trim();
//			String ip = assetDeviceBO.getIp() == null ? "" : assetDeviceBO
//					.getIp();
//			String mac = assetDeviceBO.getMac() == null ? "" : assetDeviceBO
//					.getMac();
//			String status = assetDeviceBO.getStatus() == null ? ""
//					: assetDeviceBO.getStatus().toString().trim();
//			String model = assetDeviceBO.getModel() == null ? ""
//					: assetDeviceBO.getModel();
//
//			if(assetType.equals("1")){
//				assetType = "网路设备";
//			}else if(assetType.equals("2")){
//				assetType = "安全设备";
//			}else if(assetType.equals("3")){
//				assetType = "服务器";
//			}else if(assetType.equals("4")){
//				assetType = "桌面主机";
//			}else{
//				assetType = "未知";
//			}
//			
//			if(status.equals("1")){
//				status = "在线";
//			}else if(status.equals("2")){
//				status = "报废";
//			}else{
//				status = "未知";
//			}
//			sb.append("资产名称：" + name + "\n");
//			sb.append("资产类型：" + assetType + "\n");
//			sb.append("IP地址：" + ip + "\n");
//			sb.append("设备mac地址：" + mac + "\n");
//			sb.append("资产状态：" + status + "\n");
//			sb.append("设备型号：" + model + "\n");
//			out.print(sb.toString());
//		} else {
//			out.print("你查看的设备没有关联的资产");
//		}
//		out.close();// 表示的是已经发回响应到客户端，不能在进行页面跳转了，所以下面返回的是空
		return null;
	}
}
