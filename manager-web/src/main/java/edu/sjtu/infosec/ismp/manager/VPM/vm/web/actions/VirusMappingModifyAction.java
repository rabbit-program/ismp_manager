package edu.sjtu.infosec.ismp.manager.VPM.vm.web.actions;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusClientsService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.web.form.VirusClientsORMModifyForm;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class VirusMappingModifyAction extends Action {
	private VirusClientsService virusClientsService;
	private AssetDeviceService assetDeviceService;
	private UserService userService;
	private DomainService domainService;


	public void setVirusClientsService(VirusClientsService virusClientsService) {
		this.virusClientsService = virusClientsService;
	}
	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
		String failedPage = "success";
		try{
			String mOk = (request.getParameter("mok")==null)?null:request.getParameter("mok");
			String mDel = (request.getParameter("mdel")==null)?null:request.getParameter("mdel");
			
			if(mDel!=null && !mDel.equals("")){
				if(mDel.equals("1")){
					String virusClientId = (request.getParameter("vci")==null)?null:request.getParameter("vci");
					VirusClients virusClients = virusClientsService.findVirusClientsById(Integer.parseInt(virusClientId));
					virusClientsService.removeVirusClients(virusClients);
					failedPage = "success";
				}
				return mapping.findForward(failedPage);
			}
			if(mOk!=null && !mOk.equals("")){
				if(mOk.equals("1")){
					VirusClientsORMModifyForm virusClientsORMModifyForm = (VirusClientsORMModifyForm)form;
					String virusClientId = (virusClientsORMModifyForm.getVirusClientId()==null)?null:virusClientsORMModifyForm.getVirusClientId();
					String virusClientName = (virusClientsORMModifyForm.getVirusClientName()==null)?null:virusClientsORMModifyForm.getVirusClientName();
					String assetDevice = (virusClientsORMModifyForm.getAssetDevice()==null)?null:virusClientsORMModifyForm.getAssetDevice();
					String department = (virusClientsORMModifyForm.getDepartment()==null)?null:virusClientsORMModifyForm.getDepartment();

					if(virusClientId!=null && !virusClientId.equals("")){
						VirusClients virusClients = virusClientsService.findVirusClientsById(Integer.parseInt(virusClientId));
//						if(virusClientName!=null && !virusClientName.equals("")){
						if(virusClientName!=null){
							virusClients.setName(virusClientName);
							failedPage = "mClientName";
						}else{
//							virusClients.setName("");
						}
						if(assetDevice!=null && !assetDevice.equals("")){
							AssetDeviceBO assetDeviceBO = assetDeviceService.findById(Integer.parseInt(assetDevice));
							virusClients.setAssetDevice(assetDeviceBO);
							failedPage = "mAssetDevice";
						}
						if(department!=null && !department.equals("")){
							Domain dep = domainService.findById(Integer.parseInt(department));
							virusClients.setDepartment(dep);
							failedPage = "mManager";
						}
						virusClientsService.modifyVirusClients(virusClients);
						PrintWriter out = response.getWriter();
		                out = response.getWriter();
		                response.setContentType("text/html; charset=UTF-8");
		                out.println("<script language=\"javascript\">");
		                out.println("window.opener.location.href=window.opener.location.href;");
		                out.println("window.close();");
		                out.println("</script>");
		                out.close();
						return null;
					}else{
						throw new Exception("没有选择病毒客户端！");
					}
				}else if(mOk.equals("0")){
					String opName = (request.getParameter("opname")==null)?null:request.getParameter("opname");
					String virusClientId = (request.getParameter("vci")==null)?null:request.getParameter("vci");
					if(opName!=null && !opName.equals("")){
						if(opName.equals("mvcn")){
							VirusClients virusClients = virusClientsService.findVirusClientsById(Integer.parseInt(virusClientId));
							
							request.setAttribute("virusClients", virusClients);
							return mapping.findForward("mClientName");
						}else if(opName.equals("mad")){
							VirusClients virusClients = virusClientsService.findVirusClientsById(Integer.parseInt(virusClientId));
							List<AssetDeviceBO> assetDeviceList = new ArrayList<AssetDeviceBO>();

							OperatorDetails user = SecurityUserHolder.getCurrentUser();
							List<Domain> userDomainList = new ArrayList<Domain>();
							if(user != null){
								userDomainList = user.getDomainList();
							}else{
								userDomainList = null;
							}
							try{
								assetDeviceList = assetDeviceService.findAllByDomain(userDomainList);
							}catch(Exception adle){
								System.out.println("当前用户可操作的资产查询出错！");
							}
							
							request.setAttribute("virusClients", virusClients);
							request.setAttribute("assetDeviceList", assetDeviceList);
							return mapping.findForward("mAssetDevice");
						}else if(opName.equals("mm")){
							VirusClients virusClients = virusClientsService.findVirusClientsById(Integer.parseInt(virusClientId));
							List<Domain> depList = new ArrayList<Domain>();

							OperatorDetails user = SecurityUserHolder.getCurrentUser();
//							List<Domain> userDomainList = new ArrayList<Domain>();
							if(user != null){
								depList = user.getDomainList();
							}else{
								depList = null;
							}
							
							request.setAttribute("virusClients", virusClients);
							request.setAttribute("depList", depList);
							return mapping.findForward("mManager");
						}else{
							throw new Exception("请求路径有误！");
						}
					}else{
						throw new Exception("请求路径有误！");
					}
				}else{
					throw new Exception("请求路径有误！");
				}
			}else{
				throw new Exception("请求路径有误！");
			}
		}catch(Exception e){
			System.out.println("病毒客户端映射修改出错！");
			e.printStackTrace();
			return mapping.findForward(failedPage);
		}
	}
}
