package edu.sjtu.infosec.ismp.manager.VPM.pm.web.actions;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateTactics;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.PatchTacticsService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.web.form.TacticsForm;
public class TacticsAction extends DispatchAction{
	Logger logger = Logger.getLogger(TacticsAction.class);
	private PatchTacticsService patchTacicsService;
	private SystemLogService systemlogservice;
	
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	public PatchTacticsService getPatchTacicsService() {
		return patchTacicsService;
	}

	public void setPatchTacicsService(PatchTacticsService patchTacicsService) {
		this.patchTacicsService = patchTacicsService;
	}

	/**
	 * 多条件查询所有
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ActionForward getTacticsInfoAll(ActionMapping mapping,
				ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws IOException {
		       TacticsForm tform = (TacticsForm) form;
		       PMPage page= HtmlFactory.getPage(request);
	           LinkedList  linkList = patchTacicsService.getTacticsInfos(tform.getT(), page.getBeginIndex(), page.getEveryPage(), tform.getCreateStartDate(), tform.getCreateEndDate());
	           String proValue= patchTacicsService.getGlobalPatchUpdateTactics();
			   Integer count =(Integer)linkList.getFirst();
			   PMPage page1 = PMPageUtil.createPage(page, count);
			   List<PatchUpdateTactics> list = (List<PatchUpdateTactics>) linkList.getLast();
			   StringBuffer sbf = new StringBuffer();
			   String[][] cvalue={{"0","不自动更新"},{"1","自动更新"}};
			   String[][] defPro={{proValue,"true","false"}};
			   String[][] xvalue={{"2","通知下载并通知安装"},{"3","自动下载并通知安装"},{"4","自动下载并计划安装(在计划时间安装)推荐"}};
			   Object[][] objs ={{"tid","getId"},{"tname","getName"},{"ctime","getUpdateTime"},{"upad","getUpdateAddress"},{"isup","getIsAutoUpdate",cvalue},{"uw","getUpdateWay",xvalue},{"defProYN","getId",defPro}};
			   for(PatchUpdateTactics put : list){
			      if(!(put == null)){
			    	     Object[][] tobj ={{put,objs}};  
			    	     HtmlFactory.getDataArray(tobj,sbf,"TACTICS");
					}
			   }
			Object[][] obspage={{null,"everyPage"},{null,"totalCount"},{null,"beginIndex"}};
		    HtmlFactory.getDataArray(page1, sbf,obspage,"PAGE");
	        HtmlFactory.flushData(response,sbf);
			return null;
	}
	/**
	 * 获得对象信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward getTacticsInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    String tid = request.getParameter("tid");
		    if(HtmlFactory.isNotEmpty(tid)){
		    	StringBuffer sbf = new StringBuffer();
		        PatchUpdateTactics p=patchTacicsService.getPachStrategyById(new Integer(tid));
		        String dAddress = patchTacicsService.getDefAddress();
		        String[][] obj ={{"defAddress",dAddress}};
		        Object objs[][]={{"add",obj}};
		        HtmlFactory.getDataArray(p, sbf,objs,"TACTICS");
		        HtmlFactory.flushData(response,sbf);
		    }
		    return null;
	}
	/**
	 * 删除对象
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward delTacticsInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    String tid = request.getParameter("tid");
		    String falg="成功！";
		    if(HtmlFactory.isNotEmpty(tid)){
		        	 try {
		        		 patchTacicsService.delPatchUpdateTactics(Integer.valueOf(tid));
		        	 } catch (Exception e) {
		        		 falg = "失败！";
		        	 }finally{
		        		 try {
							systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_pm, "删除补丁策略", new Timestamp(System.currentTimeMillis()), falg);
						} catch (Exception e) {
							 logger.debug("连接日志出错",e);
						}
		        	 }
		    }
		    return  null;
	}
	
	/**
	 * 更新查询
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward updateTacticsInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		   TacticsForm tform = (TacticsForm) form;
		   String proValue="";
		   StringBuffer sbf = new StringBuffer();
		   PatchUpdateTactics p=patchTacicsService.getPachStrategyById(tform.getT().getId());
		   if(HtmlFactory.isNotEmpty(tform.getT().getName())){
			   p.setName(tform.getT().getName());
		   }
		   if(HtmlFactory.isNotEmpty(tform.getT().getRemarks())){
			   p.setRemarks(tform.getT().getRemarks());
		   }
		   if(HtmlFactory.isNotEmpty(tform.getT().getUpdateAddress())){
			   p.setUpdateAddress(tform.getT().getUpdateAddress());
		   }
		   if(HtmlFactory.isNotEmpty(tform.getT().getUpdateTime())){
			   p.setUpdateTime(tform.getT().getUpdateTime());
		   }
		   if(HtmlFactory.isNotNull(tform.getT().getCreateTime())){
			   p.setCreateTime(tform.getT().getCreateTime());
		   }
		   if(HtmlFactory.isNotNull(tform.getT().getLastChangeTime())){
			   p.setLastChangeTime(tform.getT().getLastChangeTime());
		   }
		   if(HtmlFactory.isNotNull(tform.getGlobalDefaultPolicy())){
			   patchTacicsService.setGlobalPatchUpdateTactics(tform.getT().getId());
		   }
		   p.setUpdateWay(tform.getT().getUpdateWay());
		   p.setIsAutoUpdate(tform.getT().getIsAutoUpdate());
		   p.setLastChangeTime(new Timestamp(new Date().getTime()));
		   
	       String falg="成功！";
      	   try {
	  		     patchTacicsService.saveOrUpdatePatchUpdateTactics(p);
		    	 proValue= patchTacicsService.getGlobalPatchUpdateTactics();
    	   } catch (Exception e) {
    		 falg = "失败！";
    	   }finally{
    		   try {
				  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_pm, "修改补丁策略", new Timestamp(System.currentTimeMillis()), falg);
			  } catch (Exception e) {
				 logger.debug("连接日志出错",e);
			  }
    	   }

		   String[][] cvalue={{"0","不自动更新"},{"1","自动更新"}};
		   String[][] defPro={{proValue,"true","false"}};
		   String[][] xvalue={{"2","通知下载并通知安装"},{"3","自动下载并通知安装"},{"4","自动下载并计划安装(在计划时间安装)推荐"}};
		   Object[][] objs ={{"upw","getUpdateWay",xvalue},{"isup","getIsAutoUpdate",cvalue},{"defProYN","getId",defPro}};
	       HtmlFactory.getDataArray(p, sbf,objs,"TACTICS");
	       HtmlFactory.flushData(response,sbf);
		return null;
	}
	/**
	 * 保存
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ActionForward saveTacticsInfo(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    TacticsForm tform = (TacticsForm) form;
		    tform.getT().setCreateTime(new Timestamp(new Date().getTime()));
		    
	        String falg="成功！";
      	    try {
      		    patchTacicsService.saveOrUpdatePatchUpdateTactics(tform.getT());
    	    } catch (Exception e) {
    		  falg = "失败！";
    	    }finally{
    		    try {
			 	  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_pm, "添加 补丁策略", new Timestamp(System.currentTimeMillis()), falg);
			   } catch (Exception e) {
				 logger.debug("连接日志出错",e);
			   }
    	    }
		    if(HtmlFactory.isNotNull(tform.getGlobalDefaultPolicy())){
			   patchTacicsService.setGlobalPatchUpdateTactics(tform.getT().getId());
		    }
		    tform.setT(null);
		    return  getTacticsInfoAll(mapping,form,request,response);
	}
	public ActionForward getPatchUpdateTacicsAll(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    StringBuffer sbf = new StringBuffer();
		   List<PatchUpdateTactics> list = patchTacicsService.getAllPachStrategy();
		   Object[][] objs ={{"tid","getId"},{"tname","getName"}};
		   for(PatchUpdateTactics put : list){
		      if(!(put == null)){
		    	     Object[][] tobj ={{put,objs}};  
		    	     HtmlFactory.getDataArray(tobj,sbf,"UPTACTICS");
				}
		   }
	       HtmlFactory.flushData(response,sbf);
		  return  null;
	}
	public ActionForward getDefaultAddess(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		 StringBuffer sbf = new StringBuffer();
	     String addess =patchTacicsService.getDefAddress();
         String[][] obj ={{"address",addess}};
         Object objs[][]={{"add",obj}};
         HtmlFactory.getDataArray(objs,sbf,"ADDESS");
         HtmlFactory.flushData(response,sbf);
	     return null;
	}
		
}
