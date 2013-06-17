package edu.sjtu.infosec.ismp.manager.VPM.pm.web.actions;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateTactics;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.PatchTacticsService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorClientsService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.web.form.PatchForm;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;


public class PatchAction extends DispatchAction {

	 Logger logger = Logger.getLogger(PatchAction.class);
	// SensorInfoManagerService
	private SensorClientsService sensorClientsService;

	private PatchTacticsService patchTacticsService;
	//部门
	private DomainService doaminService;
	//资产
	private AssetDeviceService assetDeviceService;
	
	private SystemLogService systemlogservice;
	
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	/**
	 * Set get
	 * @return
	 */
	public DomainService getDoaminService() {
		return doaminService;
	}
	public void setDoaminService(DomainService doaminService) {
		this.doaminService = doaminService;
	}
	public AssetDeviceService getAssetDeviceService() {
		return assetDeviceService;
	}
    public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}
	public SensorClientsService getSensorClientsService() {
		return sensorClientsService;
	}
	public void setSensorClientsService(SensorClientsService sensorClientsService) {
		this.sensorClientsService = sensorClientsService;
	}
	public PatchTacticsService getPatchTacticsService() {
		return patchTacticsService;
	}
	public void setPatchTacticsService(PatchTacticsService patchTacticsService) {
		this.patchTacticsService = patchTacticsService;
	}
	
    /**
     * 获取winsensor 客户端
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
	@SuppressWarnings("unchecked")
	public ActionForward getWinSensorAssetInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PatchForm patchForm = (PatchForm) form;
		OperatorDetails user= SecurityUserHolder.getCurrentUser();  
		//根据User 脚色权限查询委办局
		List<Domain> userDomainList = new ArrayList<Domain>();
		if(user != null)
		{
			userDomainList = user.getDomainList();
		}else{
			userDomainList=null;
		}
			PMPage page= HtmlFactory.getPage(request);
			LinkedList linkList=sensorClientsService.getSensorInfos(userDomainList,patchForm.getS(), page.getBeginIndex(), page.getEveryPage(), patchForm.getCreateStartDate(), patchForm.getCreateEndDate());
			Integer count =(Integer)linkList.getFirst();
			PMPage page1 = PMPageUtil.createPage(page, count);
			List<SensorClients> list = (List<SensorClients>) linkList.getLast();
			StringBuffer sbf=new StringBuffer(); 
	    	String[][] sObje={{"id","getId"},{"ip","getSensorIP"},{"name","getName"},{"gltime","getOperateTime"}};
	    	String[][] adObje={{"acid","getId"},{"accode","getSingleCode"}};
	    	String[][] dmainObje={{"dmid","getId"},{"dmname","getDomainName"}};
	    	String[][] naObje ={{"accode","未关联"},{"acid","-1"}};
	    	String[][] ndObje ={{"dmname","未关联"},{"dmid","-1"}};
		    for(SensorClients sc : list)
		    {
			      if(!(sc == null)){
			    	  AssetDeviceBO ad=sc.getAssetDevice();
			    	  Domain adom = sc.getDepartment();
			    	  boolean isad =HtmlFactory.isNotNull(ad);
			    	  boolean isdom =HtmlFactory.isNotNull(adom);
			    	  Object[][] objs={{sc,sObje},{ isad ? ad :"add", isad ? adObje: naObje},{isdom? adom : "add",isdom?dmainObje:ndObje}};
			    	  HtmlFactory.getDataArray(objs,sbf,"SH");
					}
		    }
		    HtmlFactory.getDataArray(page1, sbf,"PAGE");
	        HtmlFactory.flushData(response,sbf);
		return null;
	}
	
	
	/** 修改 资产 部门  名称
	 * updateSensorAssetInfo usai
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward usai(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    StringBuffer sbf = new StringBuffer();
		    String sid =request.getParameter("sid");
	        String name = request.getParameter("sname");
	        String sasset = request.getParameter("sasset");
	        String sdomain=request.getParameter("sdomain");
	        String unlink=request.getParameter("unlink");
	//      PatchUtil.isNotEmpty(msg) &&  PatchUtil.isNotEmpty(msg)
	        String msg ="";
	        String falg="成功！";
	        if(HtmlFactory.isNotEmpty(sid)){
	        	 SensorClients sc =sensorClientsService.getSensorClients(Integer.valueOf(sid));
	        	 if(HtmlFactory.isNotEmpty(name)){
	        		 name=HtmlFactory.conversionCoding(name);
	        		 sc.setName(name);
	        		 String[][] obj={{"data",name},{"general",""}};
	        		 Object objs[][]={{"add",obj}};
	        		 HtmlFactory.getDataArray(objs,sbf,"UPNAME");
	        		 msg ="修改winSensor客户端名称";
	        	 }else if(HtmlFactory.isNotEmpty(sasset)){
	        		 AssetDeviceBO asset = assetDeviceService.findById(Integer.valueOf(sasset));
	        		 sc.setAssetDevice(asset);
	        		 String[][] adObje={{"acid",asset.getId().toString()},{"data",asset.getSingleCode()},{"general","acid"}};
	        		 Object objs[][]={{"add",adObje}};
	        		 HtmlFactory.getDataArray(objs,sbf,"UPNAME");
	        		 msg ="修改winSensor客户端资产";
	        	 }else if(HtmlFactory.isNotEmpty(sdomain)){
	        		try {
	        			sdomain=HtmlFactory.conversionCoding(sdomain);
						Domain domain= doaminService.findById(Integer.valueOf(sdomain));
						sc.setDepartment(domain);
		        		String[][] obj={{"dmid",domain.getId().toString()},{"data",domain.getDomainName()},{"general","dmid"}};
		        		Object objs[][]={{"add",obj}};
		        		HtmlFactory.getDataArray(objs,sbf,"UPNAME");
		        		msg ="修改winSensor客户端域";
					} catch (Exception e) {
						e.printStackTrace();
					}
	        	 }else if(HtmlFactory.isNotEmpty(unlink) && "unlink".equals(unlink)){
	        		 sc.setDepartment(null);
	        		 sc.setAssetDevice(null);
	        		 msg ="取消winSensor客户端关联";
	        	 }
	        	 try {
	        		 sensorClientsService.saveOrUpdateSensorClients(sc);
	        	 } catch (Exception e) {
	        		 falg = "失败！";
	        	 }finally{
	        		 try {
						systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_pm, msg, new Timestamp(System.currentTimeMillis()), falg);
					} catch (Exception e) {
						 logger.debug("连接日志出错",e);
					}
	        	 }
	        }
	        HtmlFactory.flushData(response,sbf);
		return null;
	}
	

	/** 查询 资产
	 * getAssetDeviceAll (getADL)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward getADL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			StringBuffer sbf = new StringBuffer();
			List<AssetDeviceBO> list = assetDeviceService.findAll();
			String[][] adObje={{"acid","getId"},{"accode","getSingleCode"}};
			for(AssetDeviceBO ad : list){
				Object[][] objs ={{ad,adObje}};
				HtmlFactory.getDataArray(objs,sbf,"ADL");
			}
			HtmlFactory.flushData(response,sbf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  return null;
	}
	
	/** 查询部门
	 * getDoMain (getDM)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward getDM(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			OperatorDetails user= SecurityUserHolder.getCurrentUser();  
			//根据User 脚色权限查询委办局
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null)
			{
				userDomainList = user.getDomainList();
				StringBuffer sbf = new StringBuffer();
				String[][] dmainObje={{"dmid","getId"},{"dmname","getDomainName"}};
				for(Domain dom : userDomainList){
					Object[][] obj ={{dom,dmainObje}};
					HtmlFactory.getDataArray(obj, sbf, "SDOM");
				}
				HtmlFactory.flushData(response,sbf);
			}
	     return null;
	}
	
	
	/**
	 * 根据部门查询sernsor
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ActionForward getDoMainSensorCenter(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		   PatchForm patchForm = (PatchForm) form;
			OperatorDetails user= SecurityUserHolder.getCurrentUser();  
			//根据User 脚色权限查询委办局
			List<Domain> userDomainList = new ArrayList<Domain>();
			if(user != null)
			{
				userDomainList = user.getDomainList();
			}else{
				userDomainList=null;
			}
		   String domainid=request.getParameter("domainid");
		   String clientid=request.getParameter("clientid");
		   String sd =request.getParameter("createStartDate");
		   String ed =request.getParameter("createEndDate");
		   sd= HtmlFactory.isNotEmpty(sd)  ? sd : "";
		   ed= HtmlFactory.isNotEmpty(ed)  ? ed : "" ;
		   List<SensorClients> list= null;
		   LinkedList linkList= null;
		   PMPage page = null;
		   if(HtmlFactory.isNotEmpty(domainid)){
			   Domain domain = new Domain();
			   domain.setId(new Integer(domainid));
			   page= HtmlFactory.getPage(request);
			   linkList= sensorClientsService.getSensorInfosByTactics(new SensorClients(domain),page.getBeginIndex(),page.getEveryPage(),patchForm.getCreateStartDate(),patchForm.getCreateEndDate());
			   Integer count = (Integer) linkList.getFirst();
			   page = PMPageUtil.createPage(page, count);
			   list = (List<SensorClients>) linkList.getLast(); 
		   }else if(HtmlFactory.isNotEmpty(clientid)){
			   SensorClients sensorClients=  sensorClientsService.getSensorClients(Integer.valueOf(clientid));
			   list= new ArrayList<SensorClients>();
			   list.add(sensorClients);
		   }else{
			   page= HtmlFactory.getPage(request);
			   linkList=sensorClientsService.getSensorInfosAll(userDomainList,page.getBeginIndex(),page.getEveryPage(),patchForm.getCreateStartDate(),patchForm.getCreateEndDate());
			   Integer count = (Integer) linkList.getFirst();
			   page = PMPageUtil.createPage(page, count);
			   list = (List<SensorClients>) linkList.getLast(); 
		   }
		   StringBuffer sbf=new StringBuffer();
		   String[][]  cvalue={{"0","不自动更新"},{"1","自动更新"}};
	       Object[][] patchObje={{"pid","getId"},{"uptime","getUpdateTime"},{"uttime","getLastChangeTime"},{"update","getIsAutoUpdate",cvalue}};
	       String[][] sObje={{"id","getId"},{"ip","getSensorIP"},{"name","getName"}};
	       String[][] ele ={{"starttime",sd},{"endtime",ed}};
		   for(SensorClients sc : list)
		   {
			      if(!(sc == null)){
			    	  PatchUpdateTactics put= sc.getPatchUpdateTactics() ;
			    	  Object[][] objs={{sc,sObje},{put,patchObje},{"add",ele}};
			    	  HtmlFactory.getDataArray(objs, sbf,"SH");
					}
		   }
		   HtmlFactory.getDataArray(page, sbf,"PAGE",ele);
           HtmlFactory.flushData(response,sbf);
		return null;
	}
	/**
	 * 修改补丁策略
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward updateTactics(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String sid =request.getParameter("sid");
		String tid =request.getParameter("tid");
		if(HtmlFactory.isNotEmpty(sid) && HtmlFactory.isNotEmpty(tid)){
			SensorClients sensorClient = sensorClientsService.getSensorClients(Integer.valueOf(sid));
			PatchUpdateTactics patchUpdateTactics= patchTacticsService.getPachStrategyById(Integer.valueOf(tid));
			sensorClient.setPatchUpdateTactics(patchUpdateTactics);
			String flag ="成功!";
			try {
				sensorClientsService.saveOrUpdateSensorClients(sensorClient);
			} catch (Exception e1) {
				flag ="失败!";
			}finally{
	   		    try {
					systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_pm, "修改补丁策略", new Timestamp(System.currentTimeMillis()), flag);
				} catch (Exception e) {
					 logger.debug("连接日志出错",e);
				}  
			}
			return getDoMainSensorCenter(mapping,form,request,response);
		}
		return null;
	}
	/**
	 * 批量修改补丁策略
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward updateListTactics(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String[] sids =request.getParameterValues("sidList");
		String tid =request.getParameter("tid");
		if(HtmlFactory.isNotNull(sids) && HtmlFactory.isNotEmpty(tid)){
			String flag ="成功!";
			try {
				for(String sid : sids){
					SensorClients sensorClient = sensorClientsService.getSensorClients(Integer.valueOf(sid));
					PatchUpdateTactics patchUpdateTactics= patchTacticsService.getPachStrategyById(Integer.valueOf(tid));
					sensorClient.setPatchUpdateTactics(patchUpdateTactics);
					sensorClientsService.saveOrUpdateSensorClients(sensorClient);
				}
			} catch (Exception e1) {
				flag ="失败!";
			}finally{
	   		    try {
					systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_pm, "批量更新补丁策略", new Timestamp(System.currentTimeMillis()), flag);
				} catch (Exception e) {
					 logger.debug("连接日志出错",e);
				}  
			}
		}
		return getDoMainSensorCenter(mapping,form,request,response);
	}
	
}