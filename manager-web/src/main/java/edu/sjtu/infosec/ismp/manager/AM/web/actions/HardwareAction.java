package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareForComm;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetHardwareService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToHardwareService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.HardwareForm;
import edu.sjtu.infosec.ismp.manager.AM.web.reports.AssetSenderWrapper;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.util.RandomCodeUtil;


/***
 * 
 * 处理所有有关资产中 硬件模块的请求
 * **/
public class HardwareAction extends DispatchAction {

	private static Log log = LogFactory.getLog(HardwareAction.class);
	// 注入 硬件模块的服务接口
	private AssetHardwareService assetHardwareService;
	// 注入设备的的服务接口
	private AssetDeviceService assetDeviceService;
	// 注入设备跟硬件的关联的服务接口
	private AssetToHardwareService assetToHardwareService;
	// 通讯接口
	private AssetSenderWrapper assetSenderWrapper;
	
	// 注入委办局 信息 service
//	private ManagerService managerService;
	private DomainService domainService;
	
	// 注入用户service接口
	private UserService userService;
	
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setAssetSenderWrapper(AssetSenderWrapper assetSenderWrapper) {
		this.assetSenderWrapper = assetSenderWrapper;
	}

	public void setAssetToHardwareService(
			AssetToHardwareService assetToHardwareService) {
		this.assetToHardwareService = assetToHardwareService;
	}

	public void setAssetHardwareService(AssetHardwareService assetHardwareService) {
		this.assetHardwareService = assetHardwareService;
	}


	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

	// 根据硬件类别ID 查询硬件信息 并且分页显示
	public ActionForward findHardWarePagin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setEveryPage(20);
		AssetHardwareBO hardwarebo = new AssetHardwareBO();
		String hardwaretype = null;
		if (request.getParameter("hid") != null)
			hardwaretype = request.getParameter("hid");
		if (request.getAttribute("hid") != null)
			hardwaretype = request.getAttribute("hid").toString();
		request.getSession().setAttribute("hardwareType", hardwaretype);
		if (hardwaretype != null) {
			if (hardwaretype.equals("cpu"))
				hardwarebo.setHardwareType(AssetConstant.HARDWARE_CPU);
			if (hardwaretype.equals("harddisk"))
				hardwarebo.setHardwareType(AssetConstant.HARDWARE_HD);
			if (hardwaretype.equals("memory"))
				hardwarebo.setHardwareType(AssetConstant.HARDWARE_MEM);
			if (hardwaretype.equals("interface"))
				hardwarebo.setHardwareType(AssetConstant.HARDWARE_INF);
		}
		Integer locId = null;
		String locid = request.getParameter("locid");
		if (locid != null && !"".equals(locid.trim())) {
			locId = Integer.parseInt(locid);
			hardwarebo.setLocationId(locId);
		}
		
		// 将ID存起来 添加的时候要用
		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage"); // 当前页数
		page.setCurrentPage(Integer.parseInt(curpage));
		// 设置开始位置
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		// 调用service层分页方法
		PageResult result = assetHardwareService.getPageListByAssetHardware(hardwarebo,
				page);
		request.setAttribute("locid", locId);
		request.setAttribute("page", result.getPage());
		request.setAttribute("hardwarelist", result.getPageList());
		request.setAttribute("hid", hardwaretype);
		return mapping.findForward("asstHardward");
	}

	// 添加硬件信息的方法
	public ActionForward addHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "添加硬件");
		// 获得类型ID
		HardwareForm hardwareForm = (HardwareForm) form;
		request.setAttribute("hid", hardwareForm.getHardware()
				.getHardwareType());
		if (isTokenValid(request)) {
			AssetHardwareBO hardwareBO  = hardwareForm.getHardware();
			hardwareBO.setSingleCode(RandomCodeUtil.getSingleRandomCode());
			assetHardwareService.saveAssetHardware(hardwareBO);
			// 传送添加硬件的信息
			sendHardware(hardwareBO, AssetConstant.ASSET_ADD);
			resetToken(request);
		} else {
			saveToken(request);
		}
		return this.findHardWarePagin(mapping, hardwareForm, request, response);
	}

	// 根据ID删除硬件的方法
	public ActionForward deleteHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除硬件");
		// 获得类型ID
		if (request.getParameter("hid") != null) {
			AssetHardwareBO hardwarebo = assetHardwareService.getAssetHardware(Integer
					.parseInt(request.getParameter("hid")));
			if (hardwarebo != null) {
				assetHardwareService.deleteAssetHardware(hardwarebo);
				// 发送删除硬件信息
				sendHardware(hardwarebo, AssetConstant.ASSET_DELETE);
			}
		}
		request.setAttribute("hid", request.getParameter("tid"));
		return mapping.findForward("findHardWarePagin");
	}

	// 根据ID查询单个硬件信息用来跟新或者查看详细信息时显示
	public ActionForward getOneHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// 获得id 根据ID 进行查询
		AssetHardwareBO hardwarebo = null;
		HardwareForm hardwareForm = (HardwareForm) form;
//		setManagerBoToRequest(request);
		OperatorDetails uservo = SecurityUserHolder.getCurrentUser();
		request.setAttribute("managerbo", uservo.getDomainList());
		request.setAttribute("locid", request.getParameter("locid"));

		Integer hid = 0;
		if (request.getParameter("hid") != null) {
			hid = Integer.parseInt(request.getParameter("hid"));
			// 根据ID查询出硬件的基本信息
			hardwareForm.setHardware(assetHardwareService.getAssetHardware(hid));
			hardwarebo = hardwareForm.getHardware();
			// 查询出关联的基本信息
			AssetToHardwareBO assetTohardware1 = new AssetToHardwareBO();
			assetTohardware1.setHardwareId(hid);
			List<AssetToHardwareBO> list = assetToHardwareService
					.getListByAssetToHardware(assetTohardware1);
			request.setAttribute("hlist", list);
			if (hardwareForm.getHardware().getStockTime() != null
					&& (!hardwareForm.getHardware().getStockTime().equals(""))) {
				hardwareForm.setStocktimepage(hardwareForm.getHardware()
						.getStockTime().toString());
			}
			if (hardwareForm.getHardware().getRegistrationTime() != null
					&& (!hardwareForm.getHardware().getRegistrationTime()
							.equals(""))) {
				hardwareForm.setRegistrationtimepage(hardwareForm.getHardware()
						.getRegistrationTime().toString());
			}
			request.setAttribute("hardware", hardwarebo);
		}
		if (request.getParameter("search") != null) {
			request.setAttribute("search", 1);
		}
		if (request.getParameter("up") != null) {
			return mapping.findForward("updateHardware");
		}
		if (request.getParameter("hardwareRaleting") != null) {
			// 当是进行 关联的换就查询出所有没有跟该硬件关联的设备信息
			request.setAttribute("deviceList", assetToHardwareService
					.getListNotJoinAssetDevice(hid));
			return mapping.findForward("hardwareRaleting");
		}
		if (request.getParameter("cancelHardwareRaleting") != null) {
			// 当是进行 取消关联的换就查询出所有跟该硬件有关联的设备信息
			request.setAttribute("deviceList", assetToHardwareService
					.getListByAssetDevice(hid));
			return mapping.findForward("cancelhardwareRaleting");
		} else {
			return mapping.findForward("showHardware");
		}
	}

	// 更新硬件信息
	public ActionForward updateHardware(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "更新硬件");
		// 获得id 根据ID 进行查询
		HardwareForm hardwareForm = (HardwareForm) form;
		assetHardwareService.updateAssetHardware(hardwareForm.getHardware());

		// 发送更新硬件
		sendHardware(hardwareForm.getHardware(), AssetConstant.ASSET_UPDATE);

		request.setAttribute("hid", hardwareForm.getHardware()
				.getHardwareType());
		return this.findHardWarePagin(mapping, hardwareForm, request, response);
	}

	// 根据物理位置ID 查询出他所关联的硬件信息
	public ActionForward getAssetToHardware(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		page.setEveryPage(20);
		AssetSoftwareBO softbo = new AssetSoftwareBO();
		Integer hardwareId = null;
		if (request.getParameter("hid") != null) {
			hardwareId = Integer.parseInt(request.getParameter("hid"));
		}
		if (request.getAttribute("hid") != null) {
			hardwareId = Integer.parseInt(request.getAttribute("hid")
					.toString());
		}
		request.setAttribute("hid", hardwareId);

		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		if (request.getParameter("pagesize") != null) {
			page.setEveryPage(Integer
					.parseInt(request.getParameter("pagesize")));
		}
		// 获得总共记录数
		int maxsize = assetToHardwareService.getCounttByHardware(hardwareId);
		// 当前页数
		page.setCurrentPage(Integer.parseInt(curpage));
		// 计算最大页数

		// 设置开始位置
		page.setBeginIndex(page.getCurrentPage() - 1);
		// 页面下拉列表框循环打印的页数
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(),
				maxsize);
		List slist = new ArrayList();

		for (int i = 0; i < page.getTotalPage(); i++) {
			if (page.getCurrentPage() == (i + 1)) {
				slist.add("yes");
				continue;
			}
			slist.add("no");
		}
		PageResult result = assetToHardwareService.getPageListByHardware(hardwareId,
				page);
		request.setAttribute("page", result.getPage());
		request.setAttribute("hardwarelist", result.getPageList());
		request.setAttribute("hardwareId", hardwareId);
		request.setAttribute("slist", slist);
		return mapping.findForward("showAssetHardeware");
	}

	// 传送硬件的信息
	private void sendHardware(AssetHardwareBO bean, String method) {
		if (assetSenderWrapper == null) {
			log.info("发送器对象为Null,终止服务！");
			return;
		}
		AssetHardwareForComm comm = new AssetHardwareForComm();
		comm.setMethod(method);
		List<AssetHardwareBO> list = new ArrayList<AssetHardwareBO>();
		list.add(bean);
		comm.setHardwares(list);

		try {
			assetSenderWrapper.executeSend(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	private void setManagerBoToRequest(HttpServletRequest request){
//		  HttpSession session=request.getSession();
//	      if(session!=null){
//	              UserBO userbo=(UserBO) session.getAttribute("userbo");	
//	              List<ManagerBO> managerList=getManagerList(userbo);
//	              request.setAttribute("managerbo", managerList);
//	      }
//	      }
//		private List<ManagerBO> getManagerList(UserBO uservo) {
//			if(uservo!=null){
//				String managsStr = uservo.getUserToManager();
//				boolean status=userService.checkAdminService(uservo.getId());
//				//如果是管理员就查询所有的委办局信息
//				if(status){
//					return managerService.getManagerAllService();
//				}else{
//					if (managsStr != null && managsStr.length() > 0) {
//						String mStr[] = managsStr.split(",");
//						List<Integer> ids = new ArrayList();
//						if (mStr != null && mStr.length > 0) {
//							for (String string : mStr) {
//								ids.add(Integer.parseInt(string));
//							}
//						}
//						return managerService.getManagerByUserIDsService(ids);
//					}
//				}
//			}
//		    return null;
//		}


}
