package edu.sjtu.infosec.ismp.manager.AM.web.actions;

 
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.List; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction; 

import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.comm.MessageOut;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceForComm;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionForComm;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToPositionBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToPositionForComm;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetPositionService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToPositionService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.LocationForm;
import edu.sjtu.infosec.ismp.manager.AM.web.reports.AssetSenderWrapper;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.util.RandomCodeUtil;

public class LocationAction extends DispatchAction { 
	 
	// 树形服务接口
	private AssetPositionService assetPositionService;

	// 根据物理位置ID 查询出资产列表的服务接口
	private AssetToPositionService assetToPositionService;

	// 注入资产接口
	private AssetDeviceService assetDeviceService;
	// 通讯接口
	private AssetSenderWrapper assetSenderWrapper;

	// 注入委办局 信息 service
	private DomainService domainService;

	// 注入用户service接口
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public void setAssetSenderWrapper(AssetSenderWrapper assetSenderWrapper) {
		this.assetSenderWrapper = assetSenderWrapper;
	}

	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

	public void setAssetToPositionService(
			AssetToPositionService assetToPositionService) {
		this.assetToPositionService = assetToPositionService;
	}


	public void setAssetPositionService(AssetPositionService assetPositionService) {
		this.assetPositionService = assetPositionService;
	}

	private String buildPositionTree(List<AssetPositionBO> posList) {
		StringBuffer tree = new StringBuffer();
		if (posList == null || posList.isEmpty())
			return ""; 
		for (AssetPositionBO pos : posList) {
			if(pos.getParentId() == null)
				tree.append("d.add(").append(pos.getId()).append(",").append(pos.getPositionId()+"00").append(",'").append(pos.getDescription()).append("');");
			else
				tree.append("d.add(").append(pos.getId()).append(",").append(pos.getParentId()).append(",'").append(pos.getDescription()).append("',").append("'javascript:fwd(").append(pos.getId()).append(")')").append(";");
		} 
		return tree.toString();
	}
	private String buildManageTree(List<Domain> managerList) {
		StringBuffer tree = new StringBuffer();
		if (managerList == null || managerList.isEmpty())
			return ""; 
		for (Domain bo : managerList) {
			tree.append("d.add(").append(bo.getId()+"00").append(",").append(0).append(",'").append(bo.getDomainName()).append("');");
		} 
		return tree.toString();
	}

	// 获得树形数据
	public ActionForward initTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		// 获得所有父节点
//		HttpSession session = request.getSession();
//		UserBO userbo = (UserBO) session.getAttribute("userbo");
//		List<ManagerBO> managerList = null;
//		if (userbo != null) {
//			managerList = getManagerList(userbo); 
//		}
		OperatorDetails uservo = SecurityUserHolder.getCurrentUser();
		List<Domain> managerList = uservo.getDomainList();
		List<AssetPositionBO> posList = assetPositionService
				.getListByAssetPosition(null);
		request.setAttribute("posList", posList);
		request.setAttribute("tree", this.buildPositionTree(posList));
		request.setAttribute("rootTree", this.buildManageTree(managerList));
		return mapping.findForward("locationleft");
	}

//	private List<Domain> getManagerList(UserBO uservo) {
//		if (uservo != null) {
//			String managsStr = uservo.getUserToManager();
//			boolean status = userService.checkAdminService(uservo.getId());
//			// 如果是管理员就查询所有的委办局信息
//			if (status) {
//				return managerService.getManagerAllService();
//			} else {
//				if (managsStr != null && managsStr.length() > 0) {
//					String mStr[] = managsStr.split(",");
//					List<Integer> ids = new ArrayList();
//					if (mStr != null && mStr.length > 0) {
//						for (String string : mStr) {
//							ids.add(Integer.parseInt(string));
//						}
//					}
//					return managerService.getManagerByUserIDsService(ids);
//				}
//			}
//		} 
//		return null;
//	}

	// 删除已个树形节点
	public ActionForward delTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除物理位置信息");
		String locationCheckBox = request.getParameter("locationCheckBox");
		String[]ids = locationCheckBox.split(",");
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				if(id !=null && !"".equals(id.trim())){
				AssetPositionBO position = new AssetPositionBO();
				position.setId(Integer.parseInt(id));
				AssetPositionBO p = new AssetPositionBO();
				p.setParentId(Integer.parseInt(id));
				// 先删除本身
				assetPositionService.deleteAssetPosition(position);

				// 传送删除物理位置
				sendPosition(p, AssetConstant.ASSET_DELETE);
				// 在删除自己下面的子节点
				List<AssetPositionBO> list = assetPositionService
						.getListByAssetPosition(p);
				for (AssetPositionBO assetPositionBO : list) {
					assetPositionService.deleteAssetPosition(assetPositionBO);
				}}
			}
		}
		 
		return mapping.findForward("locationFrame");
	}

	// 根据父ID查询出所有的子节点
	public ActionForward getChialNode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		HttpSession session = request.getSession();
//		UserBO userbo = (UserBO) session.getAttribute("userbo");
//		List<ManagerBO> managerList = null;
//		if (userbo != null) {
//			managerList = getManagerList(userbo); 
//		}
		OperatorDetails uservo = SecurityUserHolder.getCurrentUser();
		List<Domain> managerList = uservo.getDomainList();
		System.out.println("===="+managerList.size());
		request.setAttribute("managerbo", managerList);
		if (request.getParameter("parentId") != null
				&& (!request.getParameter("parentId").equals(""))) {
			AssetPositionBO position = new AssetPositionBO();
			position.setParentId(Integer.parseInt(request
					.getParameter("parentId")));
			List list = assetPositionService.getListByAssetPosition(position);
			request.setAttribute("parentId",
					request.getParameter("parentId"));
			request.setAttribute("nodeList", list);
		}
		if (request.getParameter("posId") != null
				&& (!request.getParameter("posId").equals(""))) {
			AssetPositionBO position = new AssetPositionBO();
			position.setParentId(Integer.parseInt(request
					.getParameter("posId")));
			List list = assetPositionService.getChildNodeListByParent(position);
			request.setAttribute("posId",
					request.getParameter("posId"));
			request.setAttribute("nodeList", list);
		}
		if (request.getParameter("del") != null) {
			return mapping.findForward("delromm");
		} else if (request.getParameter("delRomm") != null) {
			return mapping.findForward("delCHialNode");
		} else if (request.getParameter("delFang") != null) {
			return mapping.findForward("delFang");
		} else {
			return mapping.findForward("addromm");
		}
	} 

	// 根据父ID查询出所有的子节点
	public ActionForward getChialNodeHouse(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
//		HttpSession session = request.getSession();
//		UserBO userbo = (UserBO) session.getAttribute("userbo");
//		List<ManagerBO> managerList = null;
//		if (userbo != null) {
//			managerList = getManagerList(userbo); 
//		}
		OperatorDetails uservo = SecurityUserHolder.getCurrentUser();
		List<Domain> managerList = uservo.getDomainList();
		request.setAttribute("managerbo", managerList);
		if (request.getParameter("del") != null) {
			return mapping.findForward("delromm");
		} else if (request.getParameter("delRomm") != null) {
			return mapping.findForward("delCHialNode");
		} else if (request.getParameter("delFang") != null) {
			return mapping.findForward("delFang");
		} else {
			return mapping.findForward("addromm");
		}
	}

	// 修改节点名称
	public ActionForward updateTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "修改物理位置信息");
		LocationForm locationForm = (LocationForm) form;
		// 执行更新
		assetPositionService.updateAssetPosition(locationForm.getPosition());

		// 传送更新物理位置
		sendPosition(locationForm.getPosition(), AssetConstant.ASSET_UPDATE);
		// 更新后动态显示更新的
		return mapping.findForward("locationleft");
	}

	// 添加物理位置 也就是树形节点
	public ActionForward addTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
		 
		// 获得所有父节点List
		LocationForm locationForm = (LocationForm) form;
		// 执行节点的添加
		if (null != locationForm.getPosition()) {
			AssetPositionBO positionBO = locationForm.getPosition(); 
			positionBO.setSingleCode(RandomCodeUtil.getSingleRandomCode());
			positionBO.setPositionId(null);
			assetPositionService.saveAssetPosition(positionBO);
			// 添加成功后马上执行查询 动态显示添加的内容

			// 传送添加物理位置
			sendPosition(positionBO, AssetConstant.ASSET_ADD);
		} else {
			MessageOut.println(response, "请选择父节点", -2);
		} 
		return mapping.findForward("locationFrame");
	}
	/**
	 * 添加楼号信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addPos(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception { 
		 
		LocationForm locationForm = (LocationForm) form;
		AssetPositionBO positionBO = locationForm.getPosition();
		positionBO.setParentId(null);
		if (positionBO != null) {  
			positionBO.setSingleCode(RandomCodeUtil.getSingleRandomCode());
			assetPositionService.saveAssetPosition(positionBO);
			sendPosition(positionBO, AssetConstant.ASSET_ADD);
		} else {
			MessageOut.println(response, "请选择父节点", -2);
		}
		return mapping.findForward("locationFrame");
	}

	// 根据物理位置查询相应的资产列表
	public ActionForward findlocationDevicePagin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Page page = new Page();
		AssetDeviceBO assetdevice = new AssetDeviceBO();

		Integer typeid = 1;
		if (request.getParameter("pid") != null) {
			typeid = Integer.parseInt(request.getParameter("pid"));
		}
		if (request.getAttribute("pid") != null) {
			System.out.println("jinglailTid::" + request.getAttribute("pid"));
			typeid = Integer.parseInt(request.getAttribute("pid").toString());
		}
		request.setAttribute("publicPid", typeid);
		// 将ID存起来 添加的时候要用

		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		// 当前页数
		page.setEveryPage(10);
		page.setCurrentPage(Integer.parseInt(curpage));
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), page.getTotalCount());
		PageResult result = assetToPositionService.getPageListByAssetDevice(typeid,
				page);
		request.setAttribute("page", result.getPage());
		request.setAttribute("devicelist", result.getPageList());
		request.setAttribute("softid", typeid);
		return mapping.findForward("locationToasset");
	}

	// 删除ID资产列表
	public ActionForward delDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除在与物理位置有关联中的资产信息");
		if (request.getParameter("did") != null) {
			AssetDeviceBO assetDevicebo = new AssetDeviceBO(); 
			assetDevicebo.setId(Integer.parseInt(request.getParameter("did")));
			assetDeviceService.delete(assetDevicebo);
			// 发送删除设备信息
			sendAssetDevice(assetDevicebo, AssetConstant.ASSET_DELETE);

		}
		request.setAttribute("pid", request.getParameter("pid"));
		return this.findlocationDevicePagin(mapping, form, request, response);
	}

	// 查询单个资产信息用于界面显示详细，或者更新
	public ActionForward getOneDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
		// 获得id 根据ID 进行查询
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss"); 
		String deviceId = request.getParameter("deviceId");
		if (deviceId != null && !"".equals(deviceId.trim())) { 
			AssetDeviceBO assetDevicebo = assetDeviceService.findById(Integer
					.parseInt(deviceId));
			// 将时间转换成字符串
			request.setAttribute("assetBo", assetDevicebo);
			OperatorDetails uservo = SecurityUserHolder.getCurrentUser();
			List<Domain> managerList = uservo.getDomainList();
//			HttpSession session = request.getSession();
//			if (session != null) {
//				UserBO userbo = (UserBO) session.getAttribute("userbo");
//				List<ManagerBO> managerList = getManagerList(userbo);
//				request.setAttribute("managerbo", managerList);
//			}
			request.setAttribute("managerbo", managerList);
//			request.setAttribute("tmList", DeviceTradeMarkUtil.getMarkList());
//			if (DeviceTradeMarkUtil.getMarkList() != null
//					&& DeviceTradeMarkUtil.getMarkList().size() > 0) {
//				request.setAttribute("models", DeviceTradeMarkUtil.getModelList());
//			}
			if (assetDevicebo.getStockTime() != null) {
				request.setAttribute("stocktimepage", simp.format(assetDevicebo
						.getStockTime()));
			}
			if (assetDevicebo.getRegistrationTime() != null) {
				request.setAttribute("registrationtimepage", simp
						.format(assetDevicebo.getRegistrationTime()));
			}
		}
		if (request.getParameter("part") != null) {
			request.setAttribute("aid", deviceId);
			return mapping.findForward("assetpart");
		} else {
			request.setAttribute("pid", request.getParameter("pid"));
			return mapping.findForward("updateDevice");
		}
	}

	// 更新资产信息
	public ActionForward updateDevice(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "更新在与物理位置有关联中的资产信息");
		// 获得id 根据ID 进行查询
		LocationForm assetForm = (LocationForm) form;
		AssetDeviceBO assetbo = assetForm.getAssetBo();
		assetDeviceService.update(assetbo);
		// 发送更新设备信息
		sendAssetDevice(assetbo, AssetConstant.ASSET_UPDATE);

		request.setAttribute("pid", request.getParameter("pid"));
		return this.findlocationDevicePagin(mapping, assetForm, request,
				response);
	}

	// 查询所有没有关联的assetDevice
	public ActionForward getNotJoinAssetDevice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 获得id 根据ID 进行查询
		if (request.getParameter("pid") != null) {
			AssetPositionBO assetpositionbo = assetPositionService
					.getAssetPosition(Integer.parseInt(request
							.getParameter("pid")));
			request.setAttribute("assetPositionBo", assetpositionbo);
//			List list = assettoposition.getListNotJoinAssetDevice(Integer
//					.parseInt(request.getParameter("pid")));
			List list = assetToPositionService.getListNotJoinAssetDevice();
			request.setAttribute("dlist", list);
		}
		if (request.getParameter("seachpos") != null) {
			request.setAttribute("seachpos", 1);
		}
		return mapping.findForward("deviceJion");
	}

	// 查询跟当前物理位置有关联的设备信息
	public ActionForward getByJoinAssetDevice(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 获得id 根据ID 进行查询
		Integer pid = 0;
		if (request.getParameter("pid") != null) {
			pid = Integer.parseInt(request.getParameter("pid"));
			AssetToPositionBO atpobj = new AssetToPositionBO();
			atpobj.setPositionId(pid);
			// 根据物理位置ID 查询出相关表中的备注信息...
			List<AssetToPositionBO> assetlist = assetToPositionService
					.getListByAssetToPosition(atpobj);
			request.setAttribute("assetList", assetlist);
			AssetPositionBO assetpositionbo = assetPositionService
					.getAssetPosition(pid);
			request.setAttribute("assetPositionBo", assetpositionbo);
			List list = assetToPositionService.getListByAssetDevice(pid);
			if (request.getParameter("seachpos") != null) {
				request.setAttribute("seachpos", 1);
			}
			request.setAttribute("dlist", list);
		}
		return mapping.findForward("canceldeviceJion");
	}

	// 物理位置跟资产的关联
	public ActionForward assetJionposition(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "添加物理位置跟资产的关联");
		// 获得id 根据ID 进行查询
		LocationForm locationForm = (LocationForm) form;
		String str[] = request.getParameterValues("assetid");
		Integer pid = 0;
		if (str != null && str.length > 0) {
			pid = Integer.parseInt(request.getParameter("pid"));
			List<AssetToPositionBO> list = new ArrayList<AssetToPositionBO>();
			for (int i = 0; i < str.length; i++) {
				AssetToPositionBO assetToposition = new AssetToPositionBO();
				assetToposition.setAssetId(Integer.parseInt(str[i]));
				assetToposition.setDescription(request.getParameter("descr"));
				assetToposition.setPositionId(pid);
				assetToPositionService.saveAssetToPosition(assetToposition);
				list.add(assetToposition);
			}
			// 发送新增资产和地理位置关联
			sendAssetToPosition(list, AssetConstant.ASSET_ADD);
			request.setAttribute("pid", pid);
			if (request.getParameter("seachpos") != null
					&& request.getParameter("seachpos").equals("1")) {
				MessageOut.println(response, "关联成功", -2);
				return null;
			}
			return this.findlocationDevicePagin(mapping, locationForm, request,
					response);
		} else {
			MessageOut.println(response, "没有任务关联", -2);
		}

		if (request.getParameter("seachpos") != null
				&& request.getParameter("seachpos").equals("1")) {
			return mapping.findForward("seachpos");
		}
		return null;
	}

	// 取消物理位置跟资产的关联
	public ActionForward cancelAssetJionposition(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "取消物理位置跟资产的关联");
		// 获得id 根据ID 进行查询
		LocationForm locationForm = (LocationForm) form;
		String str[] = request.getParameterValues("assetid");
		Integer assetid = 0;
		Integer pid = null;
		if (request.getParameter("pid") != null) {
			pid = Integer.parseInt(request.getParameter("pid"));
		}
		if (str != null && str.length > 0) {
			// 在重新关联
			for (int i = 0; i < str.length; i++) {
				AssetToPositionBO assetToposition = new AssetToPositionBO();
				assetToposition.setAssetId(Integer.parseInt(str[i]));
				assetToposition.setPositionId(pid);
				List<AssetToPositionBO> list = assetToPositionService
						.getListByAssetToPosition(assetToposition);
				for (AssetToPositionBO assetToPositionBO : list) {
					assetToPositionService.deleteAssetToPosition(assetToPositionBO);
				}
				// 发送删除资产地理位置关联
				sendAssetToPosition(list, AssetConstant.ASSET_DELETE);

				request.setAttribute("pid", pid);

			}
			if (request.getParameter("seachpos") != null
					&& request.getParameter("seachpos").equals("1")) {
				MessageOut.println(response, "取消成功", -2);
				return null;
			}
			return this.findlocationDevicePagin(mapping, locationForm, request,
					response);
		} else {
			MessageOut.println(response, "没有任何关联", -2);
		}

		MessageOut.println(response, "取消成功", -2);
		return null;
	}

	// 根据设备ID 查询出该设备所在的地理位置信息,
	public ActionForward getLocationinfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("did") != null) {
			List<AssetPositionBO> list = assetToPositionService
					.getListByPosition(Integer.parseInt(request
							.getParameter("did")));
			if (list != null && !list.isEmpty()) {
			 AssetPositionBO assetPositionBO = list.get(0);
					// 房号
					request.setAttribute("room", assetPositionBO
							.getDescription());
					// 根据房号查询出楼号 
					 AssetPositionBO positionBO = new AssetPositionBO();
					 positionBO.setId(assetPositionBO.getParentId());
					List<AssetPositionBO> alist = assetPositionService.getListByAssetPosition(positionBO);
					if (alist != null && alist.get(0) != null) {
						AssetPositionBO pos = alist.get(0);
						request.setAttribute("foom", pos.getDescription());
					if(pos.getPositionId() != null)  {
//						ManagerBO managerBO = managerService.getManagerByIdService(pos.getPositionId());
						Domain domain = domainService.findById(pos.getPositionId());
						request.setAttribute("weibanju", domain.getDomainName()); 
					} 
				}
			}
		}
		return mapping.findForward("showAssetToLocation");
	}

	// 传送物理位置信息
	private void sendPosition(AssetPositionBO bean, String method) {
		if (assetSenderWrapper == null) {
			log.info("发送器对象为Null,终止服务！");
			return;
		}
		AssetPositionForComm comm = new AssetPositionForComm();
		comm.setMethod(method);
		List<AssetPositionBO> list = new ArrayList<AssetPositionBO>();
		list.add(bean);
		comm.setPositions(list);
		try {
			assetSenderWrapper.executeSend(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 传送资产和地位关系信息
	private void sendAssetToPosition(List<AssetToPositionBO> beans,
			String method) {
		if (assetSenderWrapper == null) {
			log.info("发送器对象为Null,终止服务！");
			return;
		}
		AssetToPositionForComm comm = new AssetToPositionForComm();
		comm.setMethod(method);
		comm.setAssetToPositions(beans);
		try {
			assetSenderWrapper.executeSend(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 传送设备信息
	private void sendAssetDevice(AssetDeviceBO bean, String method) {
		if (assetSenderWrapper == null) {
			log.info("发送器对象为Null,终止服务！");
			return;
		}
		AssetDeviceForComm comm = new AssetDeviceForComm();
		comm.setMethod(method);
		List<AssetDeviceBO> list = new ArrayList<AssetDeviceBO>();
		list.add(bean);
		comm.setAssetDeviceList(list);
		try {
			assetSenderWrapper.executeSend(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
