package edu.sjtu.infosec.ismp.manager.AM.web.actions;

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
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToHardwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToHardwareForComm;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToHardwareService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.HardwareRaletingForm;
import edu.sjtu.infosec.ismp.manager.AM.web.reports.AssetSenderWrapper;


public class HardwareRaletingAction extends DispatchAction {

	private AssetToHardwareService assetToHardwareService;

	//通讯接口
	private AssetSenderWrapper assetSenderWrapper;
	
	public void setAssetSenderWrapper(AssetSenderWrapper assetSenderWrapper) {
		this.assetSenderWrapper = assetSenderWrapper;
	}

	public void setAssetToHardwareService(
			AssetToHardwareService assetToHardwareService) {
		this.assetToHardwareService = assetToHardwareService;
	}


	// 添加硬件的关联方法
	public ActionForward addHardwareRaleting(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "添加硬件与资产的关联");
		HardwareRaletingForm softrelatingForm = (HardwareRaletingForm) form;
		String assetStr[] = request.getParameterValues("asscheckbox");
		// 在不等于null的时候并且长度大于一的情况循环关联
		if (null != assetStr && assetStr.length > 0) {
			List<AssetToHardwareBO> list = new ArrayList<AssetToHardwareBO>();
			for (int i = 0; i < assetStr.length; i++) {
				AssetToHardwareBO hardwarevo = new AssetToHardwareBO();
				hardwarevo.setAssetId(Integer.parseInt(assetStr[i]));
				hardwarevo.setDescription(softrelatingForm
						.getHardwareraletingvo().getDescription());
				hardwarevo.setHardwareId(softrelatingForm
						.getHardwareraletingvo().getHardwareId());
				assetToHardwareService.saveAssetToHardware(hardwarevo);
				list.add(hardwarevo);
			}
			//发送添加设备硬件关系信息
			sendAssetToHardware(list, AssetConstant.ASSET_ADD);
		}
		//判断如果是查询界面的请求就跳转至查询界面
		if (request.getParameter("search") != null
				&& request.getParameter("search").equals("1")) {
			return mapping.findForward("searchHardware");
		} else {
			MessageOut.println(response,"关联成功");
		}
		return mapping.findForward("");
	}

	// 取消硬件的关联方法
	public ActionForward cancelHardwareRaleting(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "取消硬件与资产的关联");
		HardwareRaletingForm softrelatingForm = (HardwareRaletingForm) form;
		String assetStr[] = request.getParameterValues("asscheckbox");
		Integer hid = null;
		if (request.getParameter("hid") != null) {
			hid = Integer.parseInt(request.getParameter("hid"));
		}
		if (request.getParameter("hid") != null) {
			if (assetStr != null && assetStr.length > 0) {
				// 循环关联
				for (int i = 0; i < assetStr.length; i++) {
					AssetToHardwareBO hardwarevo = new AssetToHardwareBO();
					hardwarevo.setAssetId(Integer.parseInt(assetStr[i]));
					hardwarevo.setHardwareId(hid);
					List<AssetToHardwareBO> list = assetToHardwareService
							.getListByAssetToHardware(hardwarevo);
					for (AssetToHardwareBO assetToHardwareBO : list) {
						assetToHardwareService.deleteAssetToHardware(assetToHardwareBO);
					}
					
					//发送删除设备硬件关系信息
					sendAssetToHardware(list, AssetConstant.ASSET_DELETE);
				}
			}
		}
		MessageOut.println(response, "取消成功");
		return null;
	}
	
	
	//传送设备硬件关联信息
	private void  sendAssetToHardware(List<AssetToHardwareBO> beans, String method) 
	{
		if(assetSenderWrapper == null)
		{
			log.info("发送器对象为Null,终止服务！");
			return;
		}
		AssetToHardwareForComm comm = new AssetToHardwareForComm(); 
		comm.setMethod(method);  
		comm.setAssetToHardwares(beans);
		try {
			assetSenderWrapper.executeSend(comm);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
