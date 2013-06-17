package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import edu.sjtu.infosec.ismp.manager.AM.comm.AssetConstant;
import edu.sjtu.infosec.ismp.manager.AM.comm.MessageOut;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToSoftwareBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetToSoftwareForComm;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetToSoftwareService;
import edu.sjtu.infosec.ismp.manager.AM.web.form.SoftRelatingForm;
import edu.sjtu.infosec.ismp.manager.AM.web.reports.AssetSenderWrapper;


/***
 * 处理软件设备关联的请求 *
 * **/
public class SoftRelating extends DispatchAction {

	private static Log log = LogFactory.getLog(SoftRelating.class);
	// 注入关联的借口
	private AssetToSoftwareService assetToSoftwareService;

	// 通讯接口
	private AssetSenderWrapper assetSenderWrapper;
	
	public void setAssetSenderWrapper(AssetSenderWrapper assetSenderWrapper) {
		this.assetSenderWrapper = assetSenderWrapper;
	}
	

	public void setAssetToSoftwareService(
			AssetToSoftwareService assetToSoftwareService) {
		this.assetToSoftwareService = assetToSoftwareService;
	}



	// 软件关联的方法
	public ActionForward addSoftRelating(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "添加软件跟设备关联");
		SoftRelatingForm softrelatingForm = (SoftRelatingForm) form;
		String assetStr[] = request.getParameterValues("asscheckbox");
		// 循环关联
		if (assetStr != null && assetStr.length > 0) {
			List<AssetToSoftwareBO> list = new ArrayList<AssetToSoftwareBO>();
			for (int i = 0; i < assetStr.length; i++) {
				AssetToSoftwareBO assetbo = new AssetToSoftwareBO();
				assetbo.setAssetId(Integer.parseInt(assetStr[i]));
				assetbo.setDescription(softrelatingForm.getSoftrelatingvo()
						.getDescription());
				assetbo.setSoftwareId(softrelatingForm.getSoftrelatingvo()
						.getSoftwareId());
				System.out.println("=========="+assetbo);
				assetToSoftwareService.saveAssetToSoftware(assetbo);
				list.add(assetbo);
			}
			//发送添加设备软件关联信息
			sendAssetToSoftware(list, AssetConstant.ASSET_ADD);
		}
		if (request.getParameter("seachsoft") != null
				&& request.getParameter("seachsoft").equals("1")) {
			return mapping.findForward("seachsoft");
		}
		MessageOut.println(response, "关联成功");
		return null;
	}

	// 取消软件关联的方法
	public ActionForward cancelSoftRelating(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "取消软件跟设备关联");
		SoftRelatingForm softrelatingForm = (SoftRelatingForm) form;
		if (request.getParameter("softId") != null) {
			String assetStr[] = request.getParameterValues("asscheckbox");
			if (assetStr != null && assetStr.length > 0) {
				// 取消关联
				for (int j = 0; j < assetStr.length; j++) {
					AssetToSoftwareBO atsoft = new AssetToSoftwareBO();
					atsoft.setAssetId(Integer.parseInt(assetStr[j]));
					atsoft.setSoftwareId(Integer.parseInt(request
							.getParameter("softId")));
					List<AssetToSoftwareBO> list = assetToSoftwareService
							.getListByAssetToSoftware(atsoft);
					for (AssetToSoftwareBO assetToSoftwareBO : list) {
						System.out.println("=========="+assetToSoftwareBO);
						assetToSoftwareService.deleteAssetToSoftware(assetToSoftwareBO);
					}
					//发送删除设备软件关联信息
					sendAssetToSoftware(list, AssetConstant.ASSET_DELETE);
				}

			}
		}
		MessageOut.println(response, "取消成功");
		return mapping.findForward("");
	}
	

	//传送设备软件关联信息
	private void  sendAssetToSoftware(List<AssetToSoftwareBO> beans, String method) 
	{ 
//		if(assetSenderWrapper == null)
//		{
//			log.info("发送器对象为Null,终止服务！");
//			return;
//		}
//		AssetToSoftwareForComm comm = new AssetToSoftwareForComm(); 
//		comm.setMethod(method);  
//		comm.setAssetToSoftwares(beans);
//		try {
//			assetSenderWrapper.executeSend(comm);
//		} catch (Exception e) {  
//			e.printStackTrace();
//		}
	}


}
