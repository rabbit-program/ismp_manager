package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;



/***
 * 因为Frame 框架不能直接访问WEB-INF 下面的资源 所以用这Action 专门来以跳转的方式访问JSP页面 *
 * ***/
public class ForwardAction extends Action {
	private TopoWebService topoWebService;
	

	public void setTopoWebService(TopoWebService topoWebService) {
		this.topoWebService = topoWebService;
	}


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		List<Domain> domainList = user.getDomainList();
		HttpSession session = request.getSession();
//		request.setAttribute("managerbo", domainList);
		session.setAttribute("managerbo", domainList);
		if (request.getParameter("index") != null) {
			// 获得数据采集下拉列表框数据
		/*	List<AgentBO> agentBoList = agent.getAllAgentBO();
			List list = new ArrayList();

			// 将端口IP 地址拼起来
			for (AgentBO agentBO : agentBoList) {
				AgentBO ag = new AgentBO();
				ag.setIpAddr(agentBO.getIpAddr() + ":" + agentBO.getPort());
				ag.setName(agentBO.getName());
				list.add(ag);
			}*/
//			request.getSession().setAttribute("agentList", list);
			return mapping.findForward("ind");
		}
		if (request.getParameter("top") != null) {
			return mapping.findForward("top");
		}
		if (request.getParameter("child") != null) {
			return mapping.findForward("child");
		}
		if (request.getParameter("left") != null) {
			return mapping.findForward("left");
		}
		if (request.getParameter("chilmain") != null) {
			request.setAttribute("s", "soft数据");
			return mapping.findForward("chilmain");
		}
		if (request.getParameter("hometop") != null) {
			return mapping.findForward("hometop");
		}
		if (request.getParameter("homeleft") != null) {
			return mapping.findForward("homeleft");
		}
		if (request.getParameter("homemain") != null) {
			return mapping.findForward("homemain");
		}
		if (request.getParameter("soft") != null) {
			return mapping.findForward("mainFrame");
		}
		if (request.getParameter("foot") != null) {
			return mapping.findForward("foot");
		}
		if (request.getParameter("test") != null) {
			return mapping.findForward("test");
		}
		if (request.getParameter("addAsset") != null) {
			
			Map<TradeMarkEntity,List<DeviceModelEntity>> map = topoWebService.getModelsByTradeMark();
			
			request.setAttribute("tmList", topoWebService.getTradeMarkAll());
			if(topoWebService.getTradeMarkAll()!=null && topoWebService.getTradeMarkAll().size()>0){
				TradeMarkEntity tradeMarkEntity = topoWebService.getTradeMarkAll().get(0);
				List<DeviceModelEntity> models = map.get(tradeMarkEntity);
				request.setAttribute("models", models);
			}
			request.setAttribute("deviceTypeList", topoWebService.getNodeTypeAll());
			
//			request.setAttribute("tmList", DeviceTradeMarkUtil.getMarkList());
//			if (DeviceTradeMarkUtil.getMarkList() != null
//					&& DeviceTradeMarkUtil.getMarkList().size() > 0) {
//				request.setAttribute("models", DeviceTradeMarkUtil
//						.getMarkList().get(0).getModels());
//			}
//			request.setAttribute("deviceTypeList", DeviceTradeMarkUtil
//					.getDeviceTypeList());
			request.setAttribute("tid", request.getParameter("deviceType"));
			request.setAttribute("locid", request.getParameter("locid"));
			saveToken(request);
			return mapping.findForward("addAsset");
		}
		// 单纯的首页链接页面跳转
		// 提交成功了 哈哈
		// 软件的Frame 跳转================================
		if (request.getParameter("s") != null) {
			return mapping.findForward("test");
		}
		if (request.getParameter("assetSoft") != null) {

			return mapping.findForward("softPage");
		}
		if (request.getParameter("leftSoft") != null) {
			return mapping.findForward("leftSoft");
		}
		if (request.getParameter("softmain") != null) {
			return mapping.findForward("softmain");
		}
		if (request.getParameter("addSoft") != null) {
			request.setAttribute("locid", request.getParameter("locid"));
			saveToken(request);
			return mapping.findForward("addSoft");
		}
		// 硬件的Frame 跳转======================================
		if (request.getParameter("hardware") != null) {

			return mapping.findForward("hardware");
		}
		if (request.getParameter("hardwareleft") != null) {
			return mapping.findForward("hardwareleft");
		}
		if (request.getParameter("hardwardMain") != null) {
			return mapping.findForward("hardwardMain");
		}
		if (request.getParameter("addHardware") != null) {
			request.setAttribute("locid", request.getParameter("locid"));
			saveToken(request);
			return mapping.findForward("addHardware");
		}
		// 位置
		if (request.getParameter("location") != null) {
			return mapping.findForward("location");
		}
		if (request.getParameter("locationFrame") != null) {
			return mapping.findForward("locationFrame");
		}
		if (request.getParameter("building") != null) {
			return mapping.findForward("building");
		}
		if (request.getParameter("middle") != null) {
			return mapping.findForward("middle");
		}
		if (request.getParameter("locationIndex") != null) {
			return mapping.findForward("locationIndex");
		}
		if (request.getParameter("logtop") != null) {
			request.setAttribute("logtop", 1);
			return mapping.findForward("logtop");
		}
		// Os查询界面判断
		if (request.getParameter("deviceType") != null) {
			if (request.getParameter("deviceType").equals("2")) {
				return mapping.findForward("ShowOslog");
			}
		}
		if (request.getParameter("assetwelcome") != null) {
			request.setAttribute("assetwelcome", 1);
			session.setAttribute("topcss", null);
			session.setAttribute("topcss", "assetwelcome");
			return mapping.findForward("devicewelcome");
		}
		if (request.getParameter("locationwelcome") != null) {
			request.setAttribute("locationwelcome", 1);
			session.setAttribute("topcss", null);
			session.setAttribute("topcss", "locationwelcome");
			return mapping.findForward("devicewelcome");
		}
		if (request.getParameter("hardwarewelcome") != null) {
			request.setAttribute("hardwarewelcome", 1);
			session.setAttribute("topcss", null);
			session.setAttribute("topcss", "hardwarewelcome");
			return mapping.findForward("devicewelcome");
		}
		if (request.getParameter("softwelcome") != null) {
			request.setAttribute("softwelcome", 1);
			session.setAttribute("topcss", null);
			session.setAttribute("topcss", "softwelcome");
			return mapping.findForward("devicewelcome");
		}
		if(request.getParameter("search")!= null){
			request.setAttribute("search", 1);
			session.setAttribute("topcss", null);
			session.setAttribute("topcss", "search");
			System.out.println("================="+session.getAttribute("topcss"));
			return mapping.findForward("search");
		}
		
		return null;
	}

	
}
