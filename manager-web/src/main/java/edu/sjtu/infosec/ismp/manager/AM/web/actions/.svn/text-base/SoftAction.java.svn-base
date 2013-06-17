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
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareForComm;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetSoftwareService;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToSoftwareService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.SoftForm;
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


/***
 * 
 * 处理资产中-软件相关的请求
 * **/

public class SoftAction extends DispatchAction {

	private static Log log = LogFactory.getLog(SoftAction.class);
	// 注入 Services 层接口
	private AssetSoftwareService assetSoftwareService;
	// 注入设备的Services 接口以便查询出所有的设备信息与软件进行设备关联
	private AssetDeviceService assetDeviceService;
	// 注入查询软件 关联设备的服务接口
	private AssetToSoftwareService assetToSoftwareService;
	// 通讯接口
	private AssetSenderWrapper assetSenderWrapper;
	
	// 注入委办局 信息 service
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


	public void setAssetToSoftwareService(
			AssetToSoftwareService assetToSoftwareService) {
		this.assetToSoftwareService = assetToSoftwareService;
	}

	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

	// 根据软件类型查询软件信息并且分页显示
	public ActionForward findSoftPagin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setEveryPage(20);
		AssetSoftwareBO softbo = new AssetSoftwareBO();
		String softtype = null;
		if (request.getParameter("sid") != null)
			softtype = request.getParameter("sid");
		if (request.getAttribute("sid") != null)
			softtype = request.getAttribute("sid").toString();
		request.getSession().setAttribute("SoftType", softtype);
		
		Integer locid = null;
		String locId = request.getParameter("locid");
		if (locId != null && !"".equals(locId.trim())) {
			locid = Integer.parseInt(locId);
			softbo.setLocationId(locid);
		}
		// 将ID存起来 添加的时候要用
		if (softtype != null) {
			if (softtype.equals("os"))
				softbo.setSoftwareType(AssetConstant.SOFT_OS);
			if (softtype.equals("db"))
				softbo.setSoftwareType(AssetConstant.SOFT_DB);
			if (softtype.equals("app"))
				softbo.setSoftwareType(AssetConstant.SOFT_APPLY);
			if (softtype.equals("oa"))
				softbo.setSoftwareType(AssetConstant.SOFT_OA);
			if (softtype.equals("other"))
				softbo.setSoftwareType(AssetConstant.SOFT_OTHER);
		}
		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		if (request.getParameter("pagesize") != null) {
			page.setEveryPage(Integer
					.parseInt(request.getParameter("pagesize")));
		}
		page.setCurrentPage(Integer.parseInt(curpage));
		// 设置开始位置
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		// 页面下拉列表框循环打印的页数
		PageResult result = assetSoftwareService.getPageListByAssetSoftware(softbo, page);
		request.setAttribute("page", result.getPage());
		request.setAttribute("softlist", result.getPageList());
		request.setAttribute("softid", softtype);
		request.setAttribute("locid", locid);
		return mapping.findForward("softmain");
	}

	// 添加软件信息的方法
	public ActionForward addSoft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "添加软件信息");
		// 获得类型ID
		SoftForm softForm = (SoftForm) form;
		request.setAttribute("sid", softForm.getSoftbo().getSoftwareType());
		if (isTokenValid(request)) {
			AssetSoftwareBO softwareBO = softForm.getSoftbo();
			softwareBO.setSingleCode(RandomCodeUtil.getSingleRandomCode());
			assetSoftwareService.saveAssetSoftware(softwareBO);

			// 发送添加软件信息
			sendSoftware(softwareBO, AssetConstant.ASSET_ADD);
			resetToken(request);
		} else {
			saveToken(request);
		}
		return this.findSoftPagin(mapping, softForm, request, response);
	}

	// 根据ID删除软件的方法
	public ActionForward deleteSoft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "删除软件信息");
		// 获得类型ID
		if (request.getParameter("softid") != null) {
			AssetSoftwareBO softbo = assetSoftwareService.getAssetSoftware(Integer
					.parseInt(request.getParameter("softid")));
			if (softbo != null) {
				assetSoftwareService.deleteAssetSoftware(softbo);
				// 发送删除软件信息
				sendSoftware(softbo, AssetConstant.ASSET_DELETE);
			}
		}
		request.setAttribute("sid", request.getParameter("tid"));
		return mapping.findForward("findSoftPagin");
	}

	// 根据ID查询单个软件信息
	public ActionForward getOneSoft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		// 获得id 根据ID 进行查询
		SoftForm assetForm = (SoftForm) form;
		AssetSoftwareBO assetbo = null;
//		setManagerBoToRequest(request);
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		List<Domain> managerList = user.getDomainList();
		request.setAttribute("managerbo", managerList);
		Integer assetid = 0;
		if (request.getParameter("sid") != null) {
			assetid = Integer.parseInt(request.getParameter("sid"));
			// 查询出软件基本信息
			assetbo = assetSoftwareService.getAssetSoftware(assetid);
			// 查询出关联的基本信息
			AssetToSoftwareBO assetTosoftware = new AssetToSoftwareBO();
			assetTosoftware.setSoftwareId(assetid);
			List<AssetToSoftwareBO> list = assetToSoftwareService
					.getListByAssetToSoftware(assetTosoftware);
			request.setAttribute("tosoft", list);
			assetForm.setSoftbo(assetbo); // 将时间转换成字符串

			if (assetbo.getStockTime() != null
					&& (!assetbo.getStockTime().equals(""))) {
				assetForm.setStocktimepage(assetbo.getStockTime().toString());
			}
			if (assetbo.getRegistrationTime() != null
					&& (!assetbo.getRegistrationTime().equals(""))) {
				assetForm.setRegistrationtimepage(assetbo.getRegistrationTime()
						.toString());
			}
			request.setAttribute("softinfo", assetbo);
		}

		request.setAttribute("locid", request.getParameter("locid"));
		// 如果不为空就表示是查询界面进来的
		if (request.getParameter("seachsoft") != null) {
			request.setAttribute("seachsoft", 1);
		}
		// 如果不为空就表示是跳转到更新界面去
		if (request.getParameter("up") != null) {
			return mapping.findForward("updateSoft");
		}
		// 如果不为空就表示是跳到显示详细内容的界面去
		if (request.getParameter("relating") != null) {
			// 如果是将软件进行关联就查询出所有没有跟该软件关联的设备信息;
			request.setAttribute("deviceList", assetToSoftwareService
					.getListNotJoinAssetDevice(assetid));
			return mapping.findForward("softRelating");
		}
		if (request.getParameter("cancel") != null) {
			// 如果是取消就查询出所有与该软件关联了的设备信息
			request.setAttribute("deviceList", assetToSoftwareService
					.getListByAssetDevice(assetid));
			return mapping.findForward("softCancelRelating");
		} else {
			System.out.println("进来首位");
			return mapping.findForward("showsoftOne");
		}
	}

	// 更新软件信息
	public ActionForward updateSoft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("operation", "更新软件信息");
		// 获得id 根据ID 进行查询
		SoftForm assetForm = (SoftForm) form;
		System.out.println("---------"+assetForm.getSoftbo());
		assetSoftwareService.updateAssetSoftware(assetForm.getSoftbo());
		// 发送更新软件信息
		sendSoftware(assetForm.getSoftbo(), AssetConstant.ASSET_UPDATE);
		request.setAttribute("sid", assetForm.getSoftbo().getSoftwareType());
		return this.findSoftPagin(mapping, assetForm, request, response);
	}

	// 根据资产ID 查询跟他相关的软件信息
	public ActionForward getAssetToSoft(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Page page = new Page();
		AssetSoftwareBO softbo = new AssetSoftwareBO();
		Integer assetId = null;
		if (request.getParameter("aid") != null) {
			assetId = Integer.parseInt(request.getParameter("aid"));
		}
		if (request.getAttribute("aid") != null) {
			assetId = Integer.parseInt(request.getAttribute("aid").toString());
		}
		request.getSession().setAttribute("SoftType", assetId);
		String curpage = request.getParameter("curpage") == null ? "1"
				: request.getParameter("curpage");
		if (request.getParameter("pagesize") != null) {
			page.setEveryPage(Integer
					.parseInt(request.getParameter("pagesize")));
		}else{
			page.setEveryPage(10);
		}
		// 获得总共记录数
		int maxsize = assetToSoftwareService.getCountByAssetSoftware(assetId);
		// 当前页数
		page.setCurrentPage(Integer.parseInt(curpage));
		page.setBeginIndex(page.getCurrentPage() - 1);
		// 页面下拉列表框循环打印的页数
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(),
				maxsize);
		PageResult result = assetToSoftwareService.getPageListByAssetSoftware(assetId,
				page);
		request.setAttribute("page", result.getPage());
		request.setAttribute("softlist", result.getPageList());
		request.setAttribute("assetId", assetId);
		return mapping.findForward("showAssetSoft");
	}


	public void setAssetSoftwareService(AssetSoftwareService assetSoftwareService) {
		this.assetSoftwareService = assetSoftwareService;
	}

	// 传送软件信息
	private void sendSoftware(AssetSoftwareBO bean, String method) {
		if (assetSenderWrapper == null) {
			log.info("发送器对象为Null,终止服务！");
			return;
		}
		AssetSoftwareForComm comm = new AssetSoftwareForComm();
		comm.setMethod(method);
		List<AssetSoftwareBO> list = new ArrayList<AssetSoftwareBO>();
		list.add(bean);
		comm.setSoftwares(list);
		try {
			assetSenderWrapper.executeSend(comm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
/*	private void setManagerBoToRequest(HttpServletRequest request){
		  HttpSession session=request.getSession();
	      if(session!=null){
	              UserBO userbo=(UserBO) session.getAttribute("userbo");	
	              List<ManagerBO> managerList=getManagerList(userbo);
	              request.setAttribute("managerbo", managerList);
	      }
	    
	      }
		private List<ManagerBO> getManagerList(UserBO uservo) {
			if(uservo!=null){
				String managsStr = uservo.getUserToManager();
				boolean status=userService.checkAdminService(uservo.getId());
				//如果是管理员就查询所有的委办局信息
				if(status){
					return managerService.getManagerAllService();
				}else{
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
		}

*/
}
