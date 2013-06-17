package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetHardwareService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetPositionService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetSoftwareService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.SearchForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class SearchAction extends DispatchAction {

	private AssetDeviceService assetDeviceService;
	private AssetHardwareService assetHardwareService;
	private AssetPositionService assetPositionService;
	private AssetSoftwareService assetSoftwareService;

	/**
	 * 设备模糊查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward searchDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SearchForm deviceForm = (SearchForm) form;
		AssetDeviceBO bean = deviceForm.getDevice();
//		UserBO uservo = (UserBO) request.getSession().getAttribute("userbo");
		OperatorDetails uservo = SecurityUserHolder.getCurrentUser();
		List<Integer> domainids = new ArrayList<Integer>();;
		for(Domain d : uservo.getDomainList()){
			domainids.add(d.getId());
		}
		Page page = new Page();
		String curpage = ( request.getParameter("curpage") == null || request.getParameter("curpage").trim().equals("") )? "1"
				: request.getParameter("curpage");
		
		System.out.println("==="+curpage);
//		PageResult result = new PageResult();
		List<AssetDeviceBO> result;
		page = PageUtil.createPage(15, Integer.parseInt(curpage),page.getTotalCount());
//		page.setCurrentPage(Integer.parseInt(curpage));
		result = assetDeviceService.getPageListByAssetDevice(bean, page,domainids);
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
		
//		if(uservo.getUsername().equals("admin")){
////			int totalCount = deviceService.getCountByAssetDevice(bean);
//			Page page = PageUtil.createPage(20, 1, 0);
//			page.setCurrentPage(Integer.parseInt(curpage));
//			result = deviceService.getPageListByAssetDevice(bean, page);
//		}else{
//			//权限设置
////			String userToManager = uservo.g();
//			int totalCount = deviceService.getCountByAsdeviceAndManager(bean,userToManager);
//			Page page = PageUtil.createPage(20, 1, totalCount);
//			page.setCurrentPage(Integer.parseInt(curpage));
//			result = deviceService.getPageListByAsDeviceAndManager(bean, page,userToManager);
//		}
//		request.setAttribute("deviceList", result.getPageList());
//		request.setAttribute("page", result.getPage());
		request.setAttribute("deviceList", result);
		request.setAttribute("page", page);
		request.setAttribute("device", bean);
		return mapping.findForward("deviceList");
	}

	/**
	 * 根据设备ID更新
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "更新资产信息");

		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String sn = request.getParameter("sn");
		String ip = request.getParameter("ip");
		Integer status = Integer
				.parseInt(request.getParameter("status") == "" ? "0" : request
						.getParameter("status"));
		String user = request.getParameter("user");
		String unit = request.getParameter("unit");
		String stockTime = request.getParameter("stockTime");
		Integer validityPeriod = Integer.parseInt(request
				.getParameter("validityPeriod") == "" ? "0" : request
				.getParameter("validityPeriod"));
		String telephone = request.getParameter("telephone");
		Integer assetType = Integer
				.parseInt(request.getParameter("assetType") == "" ? "0"
						: request.getParameter("assetType"));

		// 封装查询Bean
		AssetDeviceBO bean = assetDeviceService.findById(id);

		// 时间转换
		Timestamp vstockTime = convertDateFromString(stockTime);

		bean.setName(name);
		bean.setIp(ip);
		bean.setStatus(status);
		bean.setUnit(unit);
		bean.setSn(sn);
		bean.setUser(user);
		bean.setTelephone(telephone);
		bean.setValidityPeriod(validityPeriod);
		bean.setStockTime(vstockTime);
		bean.setAssetType(assetType);

		assetDeviceService.update(bean);
		request.setAttribute("device", bean);
		return mapping.findForward("viewDevice");
	}

	/**
	 * 根据设备ID删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从request中得到查询参数
		int id = Integer.parseInt(request.getParameter("id")); 
		AssetDeviceBO bean = assetDeviceService.findById(id);
		if (bean == null) {
			return mapping.getInputForward();
		}
		assetDeviceService.delete(bean); 
		return searchDevice(mapping, form, request, response);
	}

	/**
	 * 显示设备
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward viewDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从request中得到查询参数
		int id = Integer.parseInt(request.getParameter("id"));
		AssetDeviceBO bean = assetDeviceService.findById(id);

		if (bean == null) {
			// 这里写Actionmessage
			return mapping.getInputForward();
		}
		request.setAttribute("device", bean);
		return mapping.findForward("viewDevice");
	}

	// frameset跳转
	public ActionForward doFrame(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从request中得到查询参数
		if (request.getParameter("id") != null) {
			request.setAttribute("url", request.getParameter("url"));
			request.setAttribute("id", request.getParameter("id"));
			return mapping.findForward("mainframe");
		}
		return null;
	}

	/**
	 * 软件模糊查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward searchSoftware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SearchForm software = (SearchForm) form;
		AssetSoftwareBO bean = software.getSoftware();
		int totalCount = assetSoftwareService.getCountByAssetSoftware(bean);
		Page page = new Page();
		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
//		page.setCurrentPage(Integer.parseInt(curpage));
		page = PageUtil.createPage(15, Integer.parseInt(curpage), totalCount);
		PageResult result = assetSoftwareService.getPageListByAssetSoftware(bean,
				page);
		request.setAttribute("softwareList", result.getPageList());
		request.setAttribute("page", result.getPage());
		request.setAttribute("software", bean);
		return mapping.findForward("softwareList");
	}

	/**
	 * 根据软件ID更新
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateSoftware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "更新软件信息");
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String softwareType = request.getParameter("softwareType");
		String version = request.getParameter("version");
		String manufacturer = request.getParameter("manufacturer");
		Integer validityPeriod = Integer.parseInt(request
				.getParameter("validityPeriod") == "" ? "0" : request
				.getParameter("validityPeriod"));
		Integer status = Integer
				.parseInt(request.getParameter("status") == "" ? "0" : request
						.getParameter("status"));
		String telephone = request.getParameter("user");
		String user = request.getParameter("telephone");
		String stockTime = request.getParameter("stockTime");
		String unit = request.getParameter("unit");

		// 时间格式转换
		Timestamp vStockTime = convertDateFromString(stockTime);

		// 封装查询Bean
		AssetSoftwareBO bean = assetSoftwareService.getAssetSoftware(id);
		bean.setName(name);
		bean.setSoftwareType(softwareType);
		bean.setVersion(version);
		bean.setManufacturer(manufacturer);
		bean.setValidityPeriod(validityPeriod);
		bean.setStatus(status);
		bean.setTelephone(telephone);
		bean.setStockTime(vStockTime);
		bean.setUnit(unit);
		bean.setUser(user);

		assetSoftwareService.updateAssetSoftware(bean);
		request.setAttribute("soft", bean);
		return mapping.findForward("viewSoftware");
	}

	/**
	 * 根据软件ID删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteSoftware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除软件信息");
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		AssetSoftwareBO bean = assetSoftwareService.getAssetSoftware(id);
		if (bean == null)
			return mapping.getInputForward();
		assetSoftwareService.deleteAssetSoftware(bean);
		return searchSoftware(mapping, form, request, response);
	}

	/**
	 * 显示软件
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward viewSoftware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		AssetSoftwareBO bean = assetSoftwareService.getAssetSoftware(id);
		if (bean == null)
			return mapping.getInputForward();
		request.setAttribute("soft", bean);
		return mapping.findForward("viewSoftware");
	}

	/**
	 * 物理位置模糊查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward searchPosition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		SearchForm position = (SearchForm) form;
		AssetPositionBO bean = position.getPosition();
		Page page = new Page();
		String curpage = (request.getParameter("curpage") == null ||request.getParameter("curpage").equals(""))? "1"
				: request.getParameter("curpage");
		int totalCount = assetPositionService.getCounttByAssetPosition(bean);
		page = PageUtil.createPage(15, Integer.parseInt(curpage), totalCount);
//		page.setCurrentPage(Integer.parseInt(curpage));
		PageResult result = assetPositionService.getPageListByAssetPosition(bean,
				page);
		request.setAttribute("positionList", result.getPageList());
		request.setAttribute("page", result.getPage());
		request.setAttribute("position", bean);
		return mapping.findForward("positionList");
	}

	/**
	 * 根据物理位置ID更新
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updatePosition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "更新物理位置信息");
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		String description = request.getParameter("description");
		String parentId = request.getParameter("parentId");

		AssetPositionBO bean = assetPositionService.getAssetPosition(id);
		// 封装查询Bean
		bean.setDescription(description);

		// parentId为空时，设成NUll
		// 否则就是更新ParentId
		if ("".equals(parentId)) {
			bean.setParentId(null);
		} else {
			Integer pid = Integer.parseInt(parentId);
			bean.setParentId(pid);
		}
		assetPositionService.updateAssetPosition(bean);
		request.setAttribute("position", bean);
		return mapping.findForward("viewPosition");
	}

	/**
	 * 根据物理位置ID删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deletePosition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除物理位置信息");
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		AssetPositionBO bean = assetPositionService.getAssetPosition(id);
		if (bean == null)
			return mapping.getInputForward();
		Page page = new Page();
		page.setBeginIndex(1);
		page.setEveryPage(5);
		AssetPositionBO p = new AssetPositionBO();
		p.setParentId(bean.getId());
		List<AssetPositionBO> list = assetPositionService.getListByAssetPosition(p);
		for (AssetPositionBO assetPositionBO : list) {
			assetPositionService.deleteAssetPosition(assetPositionBO);
		}
		assetPositionService.deleteAssetPosition(bean);
		return searchPosition(mapping, form, request, response);
	}

	/**
	 * 显示物理位置
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward viewPosition(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		AssetPositionBO bean = assetPositionService.getAssetPosition(id);
		if (bean == null)
			return mapping.getInputForward();

		request.setAttribute("position", bean);
		return mapping.findForward("viewPosition");
	}

	/**
	 * 硬件模糊查询
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward searchHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SearchForm hardware = (SearchForm) form;
		AssetHardwareBO bean = hardware.getHardware();
		int totalCount = assetHardwareService.getCountByAssetHardware(bean);
		Page page = new Page();
		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		page = PageUtil.createPage(15, Integer.parseInt(curpage), totalCount);
//		page.setCurrentPage(Integer.parseInt(curpage));
		PageResult result = assetHardwareService.getPageListByAssetHardware(bean,
				page);
		request.setAttribute("hardwareList", result.getPageList());
		request.setAttribute("page", result.getPage());
		request.setAttribute("hardware", bean);
		return mapping.findForward("hardwareList");
	}

	/**
	 * 根据硬件ID更新
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "跟新硬件信息");
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String version = request.getParameter("version");
		String hardwareType = request.getParameter("hardwareType");
		String manufacturer = request.getParameter("manufacturer");
		String stockTime = request.getParameter("stockTime");
		Integer status = Integer
				.parseInt(request.getParameter("status") == "" ? "0" : request
						.getParameter("status"));
		// 封装查询Bean
		AssetHardwareBO bean = assetHardwareService.getAssetHardware(id);

		// 时间格式转换
		Timestamp vStockTime = convertDateFromString(stockTime);

		bean.setName(name);
		bean.setVersion(version);
		bean.setHardwareType(hardwareType);
		bean.setManufacturer(manufacturer);
		bean.setStatus(status);
		bean.setStockTime(vStockTime);

		assetHardwareService.updateAssetHardware(bean);
		request.setAttribute("hardware", bean);
		return mapping.findForward("viewHardware");
	}

	/**
	 * 根据硬件ID删除
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deleteHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除硬件信息");
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		AssetHardwareBO bean = assetHardwareService.getAssetHardware(id);
		if (bean == null)
			return mapping.getInputForward();
		Page page = new Page();
		page.setBeginIndex(1);
		page.setEveryPage(5);
		assetHardwareService.deleteAssetHardware(bean);
		return searchHardware(mapping, form, request, response);
	}

	/**
	 * 显示硬件
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward viewHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 从request中得到查询参数
		Integer id = Integer.parseInt(request.getParameter("id"));
		AssetHardwareBO bean = assetHardwareService.getAssetHardware(id);
		if (bean == null)
			return mapping.getInputForward();

		request.setAttribute("hardware", bean);
		return mapping.findForward("viewHardware");
	}

	// 时间转换
	private Timestamp convertDateFromString(String date) throws ParseException {
		if (null != date || "".equals(date)) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return new Timestamp(format.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ParseException("date parse fail!", 0);
		}
	}

	

	public AssetDeviceService getAssetDeviceService() {
		return assetDeviceService;
	}

	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

	public AssetHardwareService getAssetHardwareService() {
		return assetHardwareService;
	}

	public void setAssetHardwareService(AssetHardwareService assetHardwareService) {
		this.assetHardwareService = assetHardwareService;
	}

	public AssetPositionService getAssetPositionService() {
		return assetPositionService;
	}

	public void setAssetPositionService(AssetPositionService assetPositionService) {
		this.assetPositionService = assetPositionService;
	}

	public AssetSoftwareService getAssetSoftwareService() {
		return assetSoftwareService;
	}

	public void setAssetSoftwareService(AssetSoftwareService assetSoftwareService) {
		this.assetSoftwareService = assetSoftwareService;
	}
}
