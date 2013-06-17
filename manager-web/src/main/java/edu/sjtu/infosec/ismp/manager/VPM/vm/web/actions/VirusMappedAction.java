package edu.sjtu.infosec.ismp.manager.VPM.vm.web.actions;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.DomainService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusClientsService;
import edu.sjtu.infosec.ismp.manager.VPM.vm.web.form.VirusClientsORMForm;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;


public class VirusMappedAction extends DispatchAction {
	Logger logger = Logger.getLogger(VirusMappedAction.class);
	/**
	 * 注入 service 接口
	 */
	private VirusClientsService virusClientsService;
	private UserService userService;
	private DomainService domainService;
	private AssetDeviceService assetDeviceService;
	private SystemLogService systemlogservice;
	
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	public VirusClientsService getVirusClientsService() {
		return virusClientsService;
	}
	public void setVirusClientsService(VirusClientsService virusClientsService) {
		this.virusClientsService = virusClientsService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public DomainService getDomainService() {
		return domainService;
	}
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	public AssetDeviceService getAssetDeviceService() {
		return assetDeviceService;
	}
	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}
	@SuppressWarnings("unchecked")
	public ActionForward getVirusClientsAll(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	PMPage page = HtmlFactory.getPage(request);
		OperatorDetails user= SecurityUserHolder.getCurrentUser();  
		//根据User 脚色权限查询委办局
		List<Domain> userDomainList = new ArrayList<Domain>();
		if(user != null)
		{
			userDomainList = user.getDomainList();
		}else{
			userDomainList=null;
		}
    	VirusClientsORMForm vcf = (VirusClientsORMForm)form;
    	StringBuffer sbf = new StringBuffer();
    	LinkedList<Object> linkedList = virusClientsService.queryAllVirusClients(userDomainList,vcf.getVc(), page.getBeginIndex(), page.getEveryPage(), vcf.getCreateStartDate(), vcf.getCreateEndDate());
    	page = PMPageUtil.createPage(page, (Integer)linkedList.getFirst());
    	List<VirusClients> list = (List<VirusClients>)linkedList.getLast();
    	String[][] vcs ={{"id","getId"},{"ip","getClientIP"},{"name","getName"},{"cid","getClientID"},{"rTime","getRecordTime"}};
    	String[][] adObje={{"acid","getId"},{"accode","getSingleCode"}};
    	String[][] dmainObje={{"dmid","getId"},{"dmname","getDomainName"}};
    	String[][] naObje ={{"accode","未关联"},{"acid","-1"}};
    	String[][] ndObje ={{"dmname","未关联"},{"dmid","-1"}};
    	for(Iterator<VirusClients> iter = list.iterator();iter.hasNext();){
    		VirusClients vc = iter.next();
		      if(HtmlFactory.isNotNull(vc)){
		    	  AssetDeviceBO ad=vc.getAssetDevice();
		    	  Domain adom = vc.getDepartment();
		    	  boolean isad =HtmlFactory.isNotNull(ad);
		    	  boolean isdom =HtmlFactory.isNotNull(adom);
		    	  Object[][] objs={{vc,vcs},{ isad ? ad :"add", isad ? adObje: naObje},{isdom? adom : "add",isdom?dmainObje:ndObje}};
		    	  HtmlFactory.getDataArray(objs,sbf,"VCS");
				}
    	}
    	HtmlFactory.getDataArray(page, sbf,"PAGE");
    	HtmlFactory.flushData(response,sbf);
    	return null;
	}
	/**
	 * updateVirusClients uvcs 简写
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward uvcs(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
		   
		    String vcid =request.getParameter("vcid");
	        String name = request.getParameter("vcname");
	        String sasset = request.getParameter("vcasset");
	        String sdomain=request.getParameter("vcdomain");
	        String unlink=request.getParameter("unlink");
	        String msg = "";
	        String falg="成功！";
	        if(HtmlFactory.isNotEmpty(vcid)){
	        	 StringBuffer sbf = new StringBuffer();
	             try{
		        	 VirusClients vcs =virusClientsService.getVirusClientsById(Integer.valueOf(vcid));
		        	 if(HtmlFactory.isNotEmpty(name)){
		        		 name=HtmlFactory.conversionCoding(name);
		        		 vcs.setName(name);
		        		 String[][] obj={{"data",name},{"general",""}};
		        		 Object objs[][]={{"add",obj}};
		        		 HtmlFactory.getDataArray(objs,sbf,"UPNAME");
		        		 msg ="更新病毒客户端名称";
		        	 }else if(HtmlFactory.isNotEmpty(sasset)){
		        		 AssetDeviceBO asset = assetDeviceService.findById(Integer.valueOf(sasset));
		        		 vcs.setAssetDevice(asset);
		        		 String[][] adObje={{"acid",asset.getId().toString()},{"data",asset.getSingleCode()},{"general","acid"}};
		        		 Object objs[][]={{"add",adObje}};
		        		 HtmlFactory.getDataArray(objs,sbf,"UPNAME");
		        		 msg ="更新病毒客户端资产";
		        	 }else if(HtmlFactory.isNotEmpty(sdomain)){
		        		try {
		        			sdomain=HtmlFactory.conversionCoding(sdomain);
							Domain domain= domainService.findById(Integer.valueOf(sdomain));
							vcs.setDepartment(domain);
			        		String[][] obj={{"dmid",domain.getId().toString()},{"data",domain.getDomainName()},{"general","dmid"}};
			        		Object objs[][]={{"add",obj}};
			        		HtmlFactory.getDataArray(objs,sbf,"UPNAME");
			        		 msg ="更新病毒客户端域";
						} catch (Exception e) {
							e.printStackTrace();
						}
		        	 }else if(HtmlFactory.isNotEmpty(unlink) && "unlink".equals(unlink)){
		        		  virusClientsService.delQueryVirusClientsById(Integer.valueOf(vcid));
		        		  return null;
		        	 }
				    virusClientsService.saveVirusClients(vcs);
	             }catch(Exception e){
	            	 falg = "失败！";
	             }finally{
	     		    try {
	     		    	 systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_vm, msg, new Timestamp(System.currentTimeMillis()), falg);
	  			   } catch (Exception e) {
	  				 logger.debug("连接日志出错",e);
	  			   }
	      	    }
	           HtmlFactory.flushData(response,sbf);
	        }
	return null;
	}
}
