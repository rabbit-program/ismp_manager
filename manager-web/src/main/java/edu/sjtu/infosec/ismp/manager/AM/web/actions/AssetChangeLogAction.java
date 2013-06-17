package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.AIM.service.SendAlertService;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetChangeLogBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetChangeLogService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.AssetChangeLogForm;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;



public class AssetChangeLogAction extends DispatchAction {

	private AssetChangeLogService assetChangeLogService; 
	private SendAlertService sendAlertService;
	private AssetDeviceService assetDeviceService;
	
	public void setSendAlertService(SendAlertService sendAlertService) {
		this.sendAlertService = sendAlertService;
	}
	
	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}
	public void setAssetChangeLogService(
			AssetChangeLogService assetChangeLogService) {
		this.assetChangeLogService = assetChangeLogService;
	}

	public ActionForward searchChangeLog(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("chid");
		request.setAttribute("locid", request.getParameter("locid"));
		request.setAttribute("typeid", request.getParameter("typeid"));
		request.setAttribute("chid", request.getParameter("chid"));
		String scurpage = request.getParameter("curpage") == null ? "0"
				: request.getParameter("curpage");
		if(null!=request.getAttribute("curpage") && !("").equals(request.getAttribute("curpage"))){
			scurpage=(String)request.getAttribute("curpage");
		}
		System.out.println("========="+scurpage);
		AssetChangeLogBO bean = new AssetChangeLogBO();
		Integer sid = null;
		if (id != null&&!"".equals(id.trim()))
			sid = Integer.valueOf(id);
		else if (request.getAttribute("deviceId") != null) {
			sid = Integer.valueOf((String) request.getAttribute("deviceId"));
			request.setAttribute("deviceId", request.getParameter("deviceId"));
		}
		if (sid != null)
			bean.setDeviceId(sid);
		int count = assetChangeLogService.getListByAssetChangeLog(bean).size();
		Page page = PageUtil.createPage(10, 1, count);
		page.setCurrentPage(Integer.parseInt(scurpage));
		// AssetChangeLogForm changeLogForm = (AssetChangeLogForm)form;

		PageResult result = assetChangeLogService.getPageListByAssetChangeLog(
				bean, page);
		request.setAttribute("changelogList", result.getPageList());
		request.setAttribute("page", result.getPage());
		if (sid != null)
			request.setAttribute("deviceId", sid);
		return mapping.findForward("changelogList");
	}

	public ActionForward searchAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = null;
		if (request.getParameter("id") != null) {
			id = request.getParameter("id");
		}
		if (request.getAttribute("id") != null) {
			id = request.getAttribute("id").toString();
		}
		request.setAttribute("id", id);
		String scurpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		AssetChangeLogBO bean = new AssetChangeLogBO();
		Integer sid = null;
		if (id != null) {
			sid = Integer.parseInt(id);
			bean.setDeviceId(sid);
		}

		int count = assetChangeLogService.getListByAssetChangeLog(bean).size();
		Page page = PageUtil.createPage(10, 1, count);
		page.setCurrentPage(Integer.parseInt(scurpage));
		// AssetChangeLogForm changeLogForm = (AssetChangeLogForm)form;

		PageResult result = assetChangeLogService.getPageListByAssetChangeLog(
				bean, page);
		request.setAttribute("changelogList", result.getPageList());
		request.setAttribute("page", result.getPage());
		request.setAttribute("id", sid);
		return mapping.findForward("changelog");
	}

	public ActionForward addChangeLog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//System.out.print(WebConfigContent.mailAddress + ">>>" + WebConfigContent.mailFrom + ">>>" + WebConfigContent.mailPassword + ">>>" + WebConfigContent.mmsIp +">>>" +  WebConfigContent.mmsPort);
		String devId = request.getParameter("chid");
		AssetChangeLogForm forms = (AssetChangeLogForm) form; 
		AssetChangeLogBO bean = new AssetChangeLogBO();
		bean.setCreateTime(new Timestamp(System.currentTimeMillis()));
		bean.setStatusAfter(forms.getStatusAfter());
		bean.setStatusBefore(forms.getStatusBefore());
		Integer deviceId = null;
		if(devId != null && !"".equals(devId.trim()))
			deviceId = Integer.valueOf(devId);
		bean.setDeviceId(deviceId);
		assetChangeLogService.saveAssetChangeLog(bean);
		AssetDeviceBO device = assetDeviceService.findById(deviceId);
		Domain department = new Domain();
		if(device.getLocationId()!= null){
			department.setId(device.getLocationId());
		}
		if(device != null && device.getName() != null && !"".equals(device.getName().trim()))
//			sendAlertService.sendAlertService(1, "资产管理", "资产信息变动", null, device.getName()+"有新的资产变动信息！" + "变更后：" + bean.getStatusAfter(), null, null, "事件报告", WebConfigContent.mailAddress, WebConfigContent.mailFrom, WebConfigContent.mailPassword,  WebConfigContent.mmsIp,WebConfigContent.mmsPort,department);
		request.setAttribute("locid", request.getParameter("locid"));
		request.setAttribute("typid", request.getParameter("typeid"));
		request.setAttribute("chid", request.getParameter("chid"));
		request.setAttribute("curpage", request.getParameter("curpage"));
		return searchChangeLog(mapping, form, request, response);
	}

	// 删除变动信息
	public ActionForward delChangeLog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String logstr[] = request.getParameterValues("checkboxLog");
		request.setAttribute("id", request.getParameter("id"));
		if (null != logstr && logstr.length > 0) {
			for (String string : logstr) {
				Integer lid = Integer.parseInt(string);
				AssetChangeLogBO asseclb = new AssetChangeLogBO();
				asseclb.setId(lid);
				AssetChangeLogBO aclb = assetChangeLogService
						.getAssetChangeLog(lid);
				if (null != aclb) {
					assetChangeLogService.deleteAssetChangeLog(aclb);
				}
			}
		}
		String id = request.getParameter("deviceId");

		String scurpage = request.getParameter("curpage") == null ? "0"
				: request.getParameter("curpage");
		AssetChangeLogBO bean = new AssetChangeLogBO();
		Integer sid = null;
		if (id != null)
			sid = Integer.valueOf(id);
		else if (request.getAttribute("devId") != null) {
			sid = Integer.valueOf((String) request.getAttribute("devId"));
			request.removeAttribute("devId");
		}
		if (sid != null)
			bean.setDeviceId(sid);
		int count = assetChangeLogService.getListByAssetChangeLog(bean).size();
		Page page = PageUtil.createPage(10, 1, count);
		page.setCurrentPage(Integer.parseInt(scurpage));
		// AssetChangeLogForm changeLogForm = (AssetChangeLogForm)form;

		PageResult result = assetChangeLogService.getPageListByAssetChangeLog(
				bean, page);
		request.setAttribute("changelogList", result.getPageList());
		request.setAttribute("page", result.getPage());
		if (sid != null)
			request.setAttribute("deviceId", sid);
		// return mapping.findForward("changelogList");
		return searchAll(mapping, form, request, response);
	}

	public ActionForward delLog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer chid = Integer.parseInt(request.getParameter("logId"));
		if (chid != null)
			assetChangeLogService.deleteAssetChangeLog(assetChangeLogService
					.getAssetChangeLog(chid));
		request.setAttribute("locid", request.getParameter("locid"));
		request.setAttribute("typid", request.getParameter("typeid"));
		request.setAttribute("chid", request.getParameter("chid"));
		request.setAttribute("curpage", request.getParameter("curpage"));
		return searchChangeLog(mapping, form, request, response);
	}

}
