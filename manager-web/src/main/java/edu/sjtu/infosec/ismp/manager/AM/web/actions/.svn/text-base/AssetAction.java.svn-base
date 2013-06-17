package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceForComm;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.AssetForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;

import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.util.RandomCodeUtil;


@Component
public class AssetAction extends DispatchAction {
	private static Log log = LogFactory.getLog(AssetAction.class);

	// 注入assetService层接口

	private AssetDeviceService assetDeviceService;
	
	private TopoWebService topoWebService;

//	private static ClassPathXmlApplicationContext appContext;
//	static {
//		try {
//			appContext = new ClassPathXmlApplicationContext(new String[] {
//					"classpath:applicationContext.xml"
//			   });
//		} catch (Throwable t) {
//			throw new Error(t);
//		}
//	}
	

	// 注入委办局 信息 service
	private DomainService domainService;


	public void setTopoWebService(TopoWebService topoWebService) {
		this.topoWebService = topoWebService;
	}

	// 注入用户service接口
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

//	public void setInfoForAssetDevice(InfoForAssetDevice infoForAssetDevice) {
//		this.infoForAssetDevice = infoForAssetDevice;
//	}
//
//	public void setAssetSenderWrapper(AssetSenderWrapper assetSenderWrapper) {
//		this.assetSenderWrapper = assetSenderWrapper;
//	}

	

	/*public ActionForward initData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String temp = "pddc0000000";
		List<AssetDeviceBO> deviceList = assetserv.getListByAssetDevice(null);
		List<AssetDeviceBO> devList = new ArrayList<AssetDeviceBO>();
		AssetDeviceBO device = null;
		if (deviceList != null && !deviceList.isEmpty()) {
			for (int i = 0; i < deviceList.size(); i++) {
				device = deviceList.get(i);
				device.setSn(temp + i);
				devList.add(device);

			}
		}
		if (devList != null && !devList.isEmpty()) {
			for (AssetDeviceBO dev : devList)
				assetserv.updateAssetDevice(dev);
		}
		return mapping.findForward("chilmain");
	}*/

	// 根据类别查询资产 并且分页显示
	public ActionForward findAssetByLoc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// System.out.println(DeviceTradeMarkUtil.getMarkList().size() +
		// "品牌类型");

//		request.setAttribute("tmList", DeviceTradeMarkUtil.getMarkList());
//		if (DeviceTradeMarkUtil.getMarkList() != null
//				&& DeviceTradeMarkUtil.getMarkList().size() > 0) {
//			request.setAttribute("models", DeviceTradeMarkUtil.getModelList());
//		}
		Map<TradeMarkEntity,List<DeviceModelEntity>> map = topoWebService.getModelsByTradeMark();
		if(map!=null && map.size()>0){
			request.setAttribute("tmList", map.keySet());
			Iterator it = map.keySet().iterator();
			if(it.hasNext()){
				Object key =it.next();
				List<DeviceModelEntity> models = map.get(key);
				request.setAttribute("models", models);
			}
		}else{
			request.setAttribute("tmList", null);
			request.setAttribute("models", null);
		}
		
//		request.setAttribute("tmList", topoWebService.getTradeMarkAll());
//		if(topoWebService.getTradeMarkAll()!=null && topoWebService.getTradeMarkAll().size()>0){
//			TradeMarkEntity tradeMarkEntity = topoWebService.getTradeMarkAll().get(0);
//			List<DeviceModelEntity> models = map.get(tradeMarkEntity);
//			request.setAttribute("models", models);
//		}
		request.setAttribute("deviceTypeList", topoWebService.getNodeTypeAll());

		// 获得类型ID
		Page page = new Page();
		page.setEveryPage(15);
		AssetDeviceBO asbo = new AssetDeviceBO();
		Integer locid = 0;
		String locId = request.getParameter("locid");
		if (locId != null && !"".equals(locId.trim())){
			locid = Integer.parseInt(request.getParameter("locid"));
		}

		int typeid = 0;
		if (request.getParameter("tid") != null) {
			typeid = Integer.parseInt(request.getParameter("tid"));
		}
		if (request.getAttribute("tid") != null)
			typeid = Integer.parseInt(request.getAttribute("tid").toString());

		// 将ID存起来 添加的时候要用
		request.getSession().setAttribute("deviceType", typeid);
		if (typeid == 1)
			asbo.setAssetType(AssetConstant.NETWORK_DEVICE_TYPE);
		if (typeid == 2)
			asbo.setAssetType(AssetConstant.SECURITY_DEVICE_TYPE);
		if (typeid == 3)
			asbo.setAssetType(AssetConstant.SERVER_DEVICE_TYPE);
		if (typeid == 4)
			asbo.setAssetType(AssetConstant.TERMINAL_DEVICE_TYPE);

		asbo.setLocationId(locid);
		// 获得当前页数
		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		page.setCurrentPage(Integer.parseInt(curpage));
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		List<AssetDeviceBO> result = assetDeviceService.getPageListByAssetDevice(asbo, page, null);
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
		request.setAttribute("page", page);
		request.setAttribute("listd", result);
		request.setAttribute("typid", typeid);
		request.setAttribute("locid", locid);
		saveToken(request);
		return mapping.findForward("chilmain");
	}

	


	// 根据类别查询资产 并且分页显示
	public ActionForward findAssetAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// System.out.println(DeviceTradeMarkUtil.getMarkList().size() +
		// "品牌类型");

//		request.setAttribute("tmList", DeviceTradeMarkUtil.getMarkList());
//		if (DeviceTradeMarkUtil.getMarkList() != null
//				&& DeviceTradeMarkUtil.getMarkList().size() > 0) {
//			request.setAttribute("models", DeviceTradeMarkUtil.getModelList());
//		}

		// 获得类型ID
		Page page = new Page();
		page.setEveryPage(20);
		AssetDeviceBO asbo = new AssetDeviceBO();
		int typeid = 0;
		if (request.getParameter("tid") != null) {
			typeid = Integer.parseInt(request.getParameter("tid"));
		}
		if (request.getAttribute("tid") != null)
			typeid = Integer.parseInt(request.getAttribute("tid").toString());

		// 将ID存起来 添加的时候要用
		request.getSession().setAttribute("deviceType", typeid);
		if (typeid == 1)
			asbo.setAssetType(AssetConstant.NETWORK_DEVICE_TYPE);
		if (typeid == 2)
			asbo.setAssetType(AssetConstant.SECURITY_DEVICE_TYPE);
		if (typeid == 3)
			asbo.setAssetType(AssetConstant.SERVER_DEVICE_TYPE);
		if (typeid == 4)
			asbo.setAssetType(AssetConstant.TERMINAL_DEVICE_TYPE);
		// 获得当前页数
		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		page.setCurrentPage(Integer.parseInt(curpage));
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		asbo.setLocationId(null);
		List<AssetDeviceBO> result = assetDeviceService.getPageListByAssetDevice(asbo, page,null);
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
		request.setAttribute("page", page);
		request.setAttribute("list", result);
		request.setAttribute("typid", typeid);
		saveToken(request);
		return mapping.findForward("chilmain");
	}

	// 添加资产信息
	public ActionForward addAsset(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AssetDeviceBO assetBO = new AssetDeviceBO();
		request.setAttribute("operation", "添加资产信息");
		setManagerBoToRequest(request);
		// 获得类型ID
		AssetForm assetForm = (AssetForm) form;
		assetBO = assetForm.getAssetBo();
		assetBO.setId(null);
		assetBO.setMonitorStatus(0);
		assetBO.setSingleCode(RandomCodeUtil.getSingleRandomCode());

		request.setAttribute("tid", assetForm.getAssetBo().getAssetType());
		if (isTokenValid(request)) {
			assetDeviceService.add(assetBO);
			resetToken(request);
			// 传送添加资产的信息
			try {
				sendDevice(assetBO, AssetConstant.ASSET_ADD);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return this.findAssetByLoc(mapping, assetForm, request, response);
		} else {
			saveToken(request);
			return this.findAssetByLoc(mapping, assetForm, request, response);
		}
	}

	// 根据资产编号删除资产信息
	public ActionForward deleteAsset(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// 获得类型ID
		// 根据资产ID 删除某个资产信息
		request.setAttribute("operation", "删除资产信息");
		if (request.getParameter("aid") != null) {
			AssetDeviceBO asset = assetDeviceService.findById(Integer
					.parseInt(request.getParameter("aid")));
			if (asset != null) {
				assetDeviceService.delete(asset);
				// 传送删除资产的信息
				sendDevice(asset, AssetConstant.ASSET_DELETE);
//				infoForAssetDevice.deleteByAsset(asset);
//				infoForAssetDevice.deleteFromAssetDevice(asset.getSingleCode());
			}
		}
		request.setAttribute("tid", request.getParameter("tid"));
		request.setAttribute("locid", request.getParameter("locid")); 
		return this.findAssetByLoc(mapping, form, request, response);
	}
	// 根据资产编号删除资产信息
	public ActionForward delAsset(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		// TODO Auto-generated method stub
		// 获得类型ID
		// 根据资产ID 删除某个资产信息
		request.setAttribute("operation", "删除资产信息");
		if (request.getParameter("aid") != null) {
			AssetDeviceBO asset = assetDeviceService.findById(Integer
					.parseInt(request.getParameter("aid")));
			if (asset != null) {
				assetDeviceService.delete(asset);
				// 传送删除资产的信息
				sendDevice(asset, AssetConstant.ASSET_DELETE);
//				infoForAssetDevice.deleteByAsset(asset);
//				infoForAssetDevice.deleteFromAssetDevice(asset.getSingleCode());
			}
		}
		request.setAttribute("tid", request.getParameter("tid"));
		return mapping.findForward("deviceMain");
	}

	// 查询单个资产信息
	public ActionForward getOneAsset(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		setManagerBoToRequest(request);
		// 获得id 根据ID 进行查询
		AssetForm assetForm = (AssetForm) form;
		if (request.getParameter("aid") != null) {
			// 根据ID查询资产信息
			AssetDeviceBO assetDevicebo = new AssetDeviceBO();
			assetDevicebo = assetDeviceService.findById(Integer.parseInt(request
					.getParameter("aid")));
			
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
//				if (assetDevicebo.getManufacturer() != null
//						&& !"".equals(assetDevicebo.getManufacturer())) {
//					TradeMark mark = DeviceTradeMarkUtil
//							.getTradeMadeByEn(assetDevicebo.getManufacturer());
//					if (mark != null) {
//						List<DeviceModel> dmList = mark.getModels();
//						request.setAttribute("models", dmList);
//					}
//				}
//			}
			assetForm.setAssetBo(assetDevicebo);
			// 设置查询条件的起始时间，不为空的时候就转换
			if (assetDevicebo.getStockTime() != null
					&& (!assetDevicebo.getStockTime().equals(""))) {
				request.setAttribute("stocktimepage", assetDevicebo
						.getStockTime().toString());
			}
			if (assetDevicebo.getRegistrationTime() != null
					&& (!assetDevicebo.getRegistrationTime().equals(""))) {
				request.setAttribute("registrationtimepage", assetDevicebo
						.getRegistrationTime().toString());
			}
			request.setAttribute("assetBo", assetDevicebo);
		}

		request.setAttribute("aid", request.getParameter("aid"));
		request.setAttribute("locid", request.getParameter("locid"));
		// 判断如果是查看详细的话跳转到详细界面。否则就是跳转到更新界面

		if (request.getParameter("part") != null) {
			return mapping.findForward("assetpart");
		} else {
			return mapping.findForward("showassetOne");
		}
	}

	// 更新资产信息
	public ActionForward updateAsset(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除资产信息");
		setManagerBoToRequest(request);
		// 获得id 根据ID 进行查询
		AssetForm assetForm = (AssetForm) form;
		AssetDeviceBO assetbo = assetForm.getAssetBo();
		// System.out.println(assetbo.toString() +
		// "update asset>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		assetDeviceService.update(assetbo);
//		infoForAssetDevice.updateByAsset(assetbo);
//		infoForAssetDevice.editFromAssetDevice(assetbo);
		// 传送更新资产的信息
		sendDevice(assetbo, AssetConstant.ASSET_UPDATE);

		request.setAttribute("tid", assetForm.getAssetBo().getAssetType());
		return this.findAssetByLoc(mapping, assetForm, request, response);
	}

	public ActionForward monitor(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String devId = request.getParameter("deviceId");
		if (devId != null && !"".equals(devId.trim())) {
			AssetDeviceBO device = assetDeviceService.findById(Integer
					.valueOf(devId));
			if (device != null) {
				NodeEntity nodeEntity = new NodeEntity();
				nodeEntity.setNodeStyle(1);
//				System.out.println(topoWebService+"==="+nodeEntity);
//				if(topoWebService==null){
//					topoWebService = new TopoWebServiceImpl();
//				}
//				topoWebService = (TopoWebService)appContext.getBean("topoWebService");
//				System.out.println("==========="+topoWebService);
					topoWebService.saveOrUpdateNode(nodeEntity);
//					topoNodeDao.saveOrUpdateNode(nodeEntity);
					String node_id = nodeEntity.getNodeId();
				if (device.getNodeId()==null || device.getNodeId().equals("")) {
					device.setNodeId(node_id);
				}
				device.setMonitorStatus(1);
				assetDeviceService.update(device);
				
			}
			
			request.setAttribute("tid", device.getAssetType());
			sendDevice(device, AssetConstant.ASSET_UPDATE);

		}

		request.setAttribute("locid", request.getParameter("locid"));
		return this.findAssetByLoc(mapping, form, request, response);
	}

	// 批量导入
	public ActionForward excelImport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "批量导入资产信息");
		String locId = request.getParameter("locid");
		Integer locationId = null;
		if (locId != null && !"".equals(locId)) {
			locationId = Integer.parseInt(locId);
		}
		// 获得id 根据ID 进行查询
		AssetForm assetForm = (AssetForm) form;
		request.setAttribute("tid", assetForm.getAssettypeid());
		assetDeviceService.excelImport(assetForm.getExcelFile().getInputStream(),
				assetForm.getAssettypeid(), locationId);
		return this.findAssetByLoc(mapping, assetForm, request, response);
	}
	
	public ActionForward doExcel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {		
		String locId = request.getParameter("locid");
		String devType = request.getParameter("devTy"); 
		request.setAttribute("deviceType", devType);
		request.setAttribute("locid", locId);
		return mapping.findForward("excel_import");
	}

	public ActionForward updateSearchDevice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "更新资产信息");
		AssetForm assetForm = (AssetForm) form;
		AssetDeviceBO device = assetForm.getAssetBo();
		assetDeviceService.update(device);
		request.setAttribute("device", device);
		return mapping.findForward("viewDevice");
	}

	// 传送资产的信息
	private void sendDevice(AssetDeviceBO bean, String method) {
		log.info("设备信息发送");
//		if (assetSenderWrapper == null) {
//			log.info("发送器对象为Null,终止服务!");
//			System.out.println("发送器对象为Null,终止服务!");
//			return;
//		}

		AssetDeviceForComm comm = new AssetDeviceForComm();
		comm.setMethod(method);
		List<AssetDeviceBO> list = new ArrayList<AssetDeviceBO>();
		list.add(bean);
		comm.setAssetDeviceList(list);

//		try {
//			assetSenderWrapper.executeSend(comm);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	// 选择类型
	public ActionForward selectModels(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String enName = request.getParameter("enName");
		StringBuffer enNames = new StringBuffer();
//		List<edu.sjtu.infosec.ismp.micommon.topo.topomanage.model.DeviceModel> models = DeviceTradeMarkUtil
//				.getTradeMadeByEn(enName).getModels();
//		for (DeviceModel model : models) {
//			enNames.append('@').append(model.getName());
//		}
		Map<TradeMarkEntity,List<DeviceModelEntity>> map = topoWebService.getModelsByTradeMark();
		
		
		response.getWriter().write(enNames.toString());
		enNames = null;
		return null;
	}

	private void setManagerBoToRequest(HttpServletRequest request) {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		List<Domain> domainList = user.getDomainList();
		request.setAttribute("managerbo", domainList);
//		HttpSession session = request.getSession();
//		if (session != null) {
//			User userbo = (User) session.getAttribute("userbo");
//			List<Domain> managerList = getManagerList(userbo);
//			request.setAttribute("managerbo", managerList);
//		}

	}

	/*private List<Domain> getManagerList(User uservo) {
		if (uservo != null) {
			String managsStr = uservo.getUserToManager();
			boolean status = userService.checkAdminService(uservo.getId());
			// 如果是管理员就查询所有的委办局信息
			if (status) {
				return managerService.getManagerAllService();
			} else {
				if (managsStr != null && managsStr.length() > 0) {
					String mStr[] = managsStr.split(",");
					List<Integer> ids = new ArrayList();
					if (mStr != null && mStr.length > 0) {
						for (String string : mStr) {
							ids.add(Integer.parseInt(string));
						}
					}
					return managerService.getManagerByUserIDsService(ids);
				}
			}
		}
		return null;
	}*/

}
