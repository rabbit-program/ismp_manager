package edu.sjtu.infosec.ismp.manager.VPM.sd.web.actions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import key.HashStr;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.web.actions.TacticsAction;
import edu.sjtu.infosec.ismp.manager.VPM.sd.comm.FileProcessUtil;
import edu.sjtu.infosec.ismp.manager.VPM.sd.comm.XmlProcessUtil;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.SoftwareInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.TypeInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.service.SoftwareManagerService;
import edu.sjtu.infosec.ismp.manager.VPM.sd.service.SoftwareTypeInfoService;
import edu.sjtu.infosec.ismp.manager.VPM.sd.web.form.SoftwareForm;
import edu.sjtu.infosec.ismp.security.OperatorDetails;
import edu.sjtu.infosec.ismp.security.Role;

public class SoftwareAction extends DispatchAction {
	Logger logger = Logger.getLogger(SoftwareAction.class);
	//软件分发路径
	private  String softWarePatch;
    //软件分发接口
	private SoftwareManagerService softwareManagerService;
	private SystemLogService systemlogservice;
	
	/**
	 * @param systemlogservice the systemlogservice to set
	 */
	public void setSystemlogservice(SystemLogService systemlogservice) {
		this.systemlogservice = systemlogservice;
	}
	private SoftwareTypeInfoService softwareTypeInfoService;
	/**
	 * @return the softwareManagerService
	 */
	public SoftwareManagerService getSoftwareManagerService() {
		return softwareManagerService;
	}

	/**
	 * @param softwareManagerService the softwareManagerService to set
	 */
	public void setSoftwareManagerService(
			SoftwareManagerService softwareManagerService) {
		this.softwareManagerService = softwareManagerService;
	}

	/**
	 * @return the softwareTypeInfoService
	 */
	public SoftwareTypeInfoService getSoftwareTypeInfoService() {
		return softwareTypeInfoService;
	}

	/**
	 * @param softwareTypeInfoService the softwareTypeInfoService to set
	 */
	public void setSoftwareTypeInfoService(
			SoftwareTypeInfoService softwareTypeInfoService) {
		this.softwareTypeInfoService = softwareTypeInfoService;
	}

	
	/**
	 * @return the softWarePatch
	 */
	public String getSoftWarePatch() {
		return softWarePatch.isEmpty() ? "c:\\manager" : softWarePatch;
	}

	/**
	 * @param softWarePatch the softWarePatch to set
	 */
	public void setSoftWarePatch(String softWarePatch) {
		this.softWarePatch = softWarePatch;
	}
	/**
	 * 查询所有软件信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
   public ActionForward softwareAll(ActionMapping mapping, 
	 ActionForm form, HttpServletRequest request, 
	 HttpServletResponse response) throws Exception{
	   SoftwareForm  softwareForm = (SoftwareForm)form;	
		PMPage page = new PMPage();
		String curpage = request.getParameter("currPage") != null
				&& (!request.getParameter("currPage").equals("")) ? request
				.getParameter("currPage") : "1";
		page.setCurrentPage(Integer.parseInt(curpage));
		page.setBeginIndex((page.getCurrentPage() - 1) * page.getEveryPage());
		Timestamp uploadStartTime=softwareForm.getStarttime() == null ? null :   Timestamp.valueOf(softwareForm.getStarttime());
		Timestamp uploadEndTime= softwareForm.getEndtime() == null ? null : Timestamp.valueOf(softwareForm.getEndtime());
	   List<SoftwareInfo> list = softwareManagerService.searchByConditions(softwareForm.getSi(), page,
			   uploadStartTime , uploadEndTime);
	   request.setAttribute("list", list);
	   request.setAttribute("startTime", softwareForm.getStarttime());
	   request.setAttribute("endTime", softwareForm.getEndtime());
	   request.setAttribute("software", softwareForm.getSi());
	   request.setAttribute("page", page.getPageInfo());
	   request.setAttribute("currPage", page.getPageInfo().getCurrentPage());
	   request.setAttribute("totalPage", page.getPageInfo().getTotalPage());
      return mapping.findForward("index"); 
   }
	/*
	 * 查询软件对象
	 */
   public ActionForward softwareById(ActionMapping mapping, 
			 ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response) throws Exception{
			   String softwareId = request.getParameter("sid");
			   if(HtmlFactory.isNotEmpty(softwareId)){
				   SoftwareInfo softwareInfo = softwareManagerService.searchById(Integer.valueOf(softwareId));
				   String startTime = TimeConvert(softwareInfo.getDispatchPolicy().getDispatchStartTime());
				   String endTime = TimeConvert(softwareInfo.getDispatchPolicy().getDispatchEndTime());
				   request.setAttribute("up_start_Time", startTime);
				   request.setAttribute("up_end_Time", endTime);
				   request.setAttribute("software", softwareInfo);
				   return mapping.findForward("update"); 
			   }
		  return null; 
	}
/**
 * 查询软件对象
 * @param mapping
 * @param form
 * @param request
 * @param response
 * @return
 * @throws Exception
 */
  public ActionForward softwareByIdAjax(ActionMapping mapping, 
			 ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response) throws Exception{
			   String softwareId = request.getParameter("sid");
			   if(HtmlFactory.isNotEmpty(softwareId)){
				   StringBuffer sbf = new StringBuffer();
				   SoftwareInfo softwareInfo = softwareManagerService.searchById(Integer.valueOf(softwareId));
				   String startTime = TimeConvert(softwareInfo.getDispatchPolicy().getDispatchStartTime());
				   String endTime = TimeConvert(softwareInfo.getDispatchPolicy().getDispatchEndTime());
				   String info_conversion[][]={{"FILE","文件"},{"DIR","目录"}};
				   Object software_info[][] ={{"si_name","getName"},{"si_type","getType",info_conversion},{"si_size","getSize"},{"si_uploadTime","getUploadTime"}};
				   String software_type[][]= {{"t_name","getName"}};
				   String dispatch_conversion[][]={{"true","分发"},{"false","不分发"}};
				   String consistencyCheck[][]={{"true","是"},{"false","否"}};
				   Object softwaer_dispatch[][]={{"d_CheckTag","getDispatchCheckTag",dispatch_conversion},
						   {"d_consistencyCheckTag","getConsistencyCheckTag",consistencyCheck},{"d_StartDate","getDispatchStartDate"},
						   {"d_EndDate","getDispatchEndDate"},{"d_ThreadNum","getDispatchThreadNum"}};
				   String execute_conversion[][]={{"true","执行"},{"false","不执行"}};
				   Object softwaer_execute[][]={{"e_Tag","getExecuteCheckTag",execute_conversion},{"e_Path","getExecuteFilePath"},{"e_Parameter","getExecuteParameter"},
						   {"e_Message","getExecutePromptingMessage"}};
				   String validate_conversion[][]={{"true","验证"},{"false","不验证"}};
				   Object software_validate[][]={{"v_CheckTag","getValidateCheckTag",validate_conversion} ,{"v_FilePath","getValidateFilePath"},
						   {"v_FileVersion","getValidateFileVersion"} ,{"v_Key","getValidateRegisterKey"}  ,{"v_Process","getValidateProcess"},
						   {"v_Service","getValidateService"}};
				   //分发策略时间转换 ,
				   String time_vonversion[][]={{"d_StartTime", startTime},{"d_EndTime",endTime},};
				   
				   Object objs[][] = {{softwareInfo,software_info},{softwareInfo.getTypeInfo(),software_type} ,{softwareInfo.getDispatchPolicy(),softwaer_dispatch},
						   {softwareInfo.getExecutePolicy(),softwaer_execute},{softwareInfo.getValidatePolicy(),software_validate},{"add",time_vonversion}};
				   HtmlFactory.getDataArray(objs, sbf,"SOFTWAREINFO");
				   HtmlFactory.flushData(response,sbf);
			   }
		  return null; 
	}
   /**
    * 添加软件
    * @param mapping
    * @param form
    * @param request
    * @param response
    * @return
    * @throws Exception
    */
	public ActionForward softwareAdd(ActionMapping mapping, 
			 ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response) throws Exception{
		 SoftwareForm  softwareForm = (SoftwareForm)form;	
		 if(upload(softwareForm)){
			 try {
				XmlProcessUtil.writeSoftwareXML(getSoftWarePatch(), softwareForm);
				softwareManagerService.save(softwareForm.getSi());
				
		        String falg="成功！";
	      	    try {
	      	    	softwareManagerService.save(softwareForm.getSi());
	    	    } catch (Exception e) {
	    		  falg = "失败！";
	    	    }finally{
	    		    try {
				 	  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_sd, "添加软件", new Timestamp(System.currentTimeMillis()), falg);
				   } catch (Exception e) {
					   logger.debug("连接日志出错",e);
				   }
	    	    }
	    	    
			} catch (Exception e) {
				 FileProcessUtil.deletedSpecifyFile(softwareForm.getPath());
				 FileProcessUtil.deletedSpecifyFile(softwareForm.getXmlPath());
			} 
		 }
		return null; 
	}
	/**
	 * 软件上传
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	private boolean upload(SoftwareForm softwareForm){
			try {
				//将文件写入数出指定的目录
				FormFile formFile =softwareForm.getFormFile();
				if(!FileProcessUtil.checkDirectoryExist(getSoftWarePatch())){
					FileProcessUtil.createDirectory(getSoftWarePatch());
				}
				String path = getSoftWarePatch()+"\\"+formFile.getFileName();
				InputStream in = formFile.getInputStream();
				OutputStream out = new FileOutputStream(path);
				int read = 0;
				byte[] buffer = new byte[1024];
				while((read = in.read(buffer,0,1024))!= -1){
					out.write(buffer, 0, read);
				}
				in.close();
				out.close();
				
			    //软件信息
				String fileName = formFile.getFileName();
				
				softwareForm.getSi().setName(fileName);
				softwareForm.getSi().setSize(Long.valueOf(formFile.getFileSize()));
				softwareForm.getSi().setMD5(FileProcessUtil.getHash(path, null, null));
				softwareForm.getSi().setUploadTime(new Timestamp(System.currentTimeMillis()));
			    String sub = fileName.substring(fileName.lastIndexOf("."),fileName.length()).toLowerCase();
				softwareForm.getSi().setType(sub.equals(".rar") || sub.equals(".zip") ? "FILE" : "DIR");
				softwareForm.getSi().getDispatchPolicy().setDispatchFormTag(false);//表示由用户打包
				String hashStr = HashStr.getHash(FileProcessUtil.getHASHStr(softwareForm.getSi()));
				softwareForm.getSi().setValidate(hashStr);
				softwareForm.setPath(path);
				
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	/**
	 * 更新软件
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateSoftwareInfo(ActionMapping mapping, 
			 ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response) throws Exception{
		 SoftwareForm  softwareForm = (SoftwareForm)form;	
		 if(HtmlFactory.isNotEmpty(softwareForm.getSi().getId().toString())){
			   SoftwareInfo softwareInfo = softwareManagerService.searchById(Integer.valueOf(softwareForm.getSi().getId()));
			   softwareInfo.setValidatePolicy(softwareForm.getVp());
			   softwareInfo.setTypeInfo(softwareForm.getTi());
			   softwareInfo.setDispatchPolicy(softwareForm.getDp());
			   softwareInfo.setExecutePolicy(softwareForm.getEp());
			   softwareManagerService.update(softwareInfo);
			   
		        String falg="成功！";
	      	    try {
	      	    	softwareManagerService.update(softwareInfo);
	    	    } catch (Exception e) {
	    		  falg = "失败！";
	    	    }finally{
	    		    try {
				 	  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_sd, "更新软件", new Timestamp(System.currentTimeMillis()), falg);
				   } catch (Exception e) {
					   logger.debug("连接日志出错",e);
				   }
	    	    }

		 }
		return null; 
	 }
	/**
	 * 删除软件
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delsoftware (ActionMapping mapping, 
			 ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response) throws Exception{
		    SoftwareForm  softwareForm = (SoftwareForm)form;	
			String softwareId = request.getParameter("sid");
			if(HtmlFactory.isNotEmpty(softwareId)){
			   
		        String falg="成功！";
	      	    try {
		 			   SoftwareInfo softwareInfo = softwareManagerService.searchById(Integer.valueOf(softwareId));
					   String path =getSoftWarePatch()+"\\"+softwareInfo.getName();
					   String xmlpath = getSoftWarePatch()+"\\"+softwareInfo.getName().substring(0, softwareInfo.getName().lastIndexOf("."))+".xml";
					   softwareManagerService.del(softwareInfo);
					   if(FileProcessUtil.deleteFileByAbsolutePath(path)){
						   FileProcessUtil.deletedSpecifyFile(path);
						   FileProcessUtil.deletedSpecifyFile(xmlpath);
					   }
	    	    } catch (Exception e) {
	    		  falg = "失败！";
	    	    }finally{
	    		    try {
				 	  systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_sd, "删除软件", new Timestamp(System.currentTimeMillis()), falg);
				   } catch (Exception e) {
					   logger.debug("连接日志出错",e);
				   }
	    	    }
		 }
		return softwareAll(mapping,softwareForm,request,response); 
	 }
	
	/**
	 * 批量删除
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward delsoftwareList (ActionMapping mapping, 
			 ActionForm form, HttpServletRequest request, 
			 HttpServletResponse response) throws Exception{
		    SoftwareForm  softwareForm = (SoftwareForm)form;
		    String strs[]=  request.getParameterValues("sids");
			
			String flag ="成功!";
			try {
				   for (int i = 0; i < strs.length; i++) {
						  if(HtmlFactory.isNotEmpty(strs[i])){
							   SoftwareInfo softwareInfo = softwareManagerService.searchById(Integer.valueOf(strs[i]));
							   String path =getSoftWarePatch()+"\\"+softwareInfo.getName();
							   String xmlpath = getSoftWarePatch()+"\\"+softwareInfo.getName().substring(0, softwareInfo.getName().lastIndexOf("."))+".xml";
							   softwareManagerService.del(softwareInfo);
							   if(FileProcessUtil.deleteFileByAbsolutePath(path)){
								   FileProcessUtil.deletedSpecifyFile(path);
								   FileProcessUtil.deletedSpecifyFile(xmlpath);
							   }
					      }
					} 
			} catch (Exception e1) {
				flag ="失败!";
			}finally{
	   		    try {
					systemlogservice.saveSystemLog(LogUtil.userName, LogUtil.roleName, SystemModelInfo.MOD_VPM_sd, "批量删除软件", new Timestamp(System.currentTimeMillis()), flag);
				} catch (Exception e) {
					logger.debug("连接日志出错",e);
				}  
			}	
			
	   return softwareAll(mapping,softwareForm,request,response); 
	 }
	
	/**
	 * 查询软件类型
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward findAllSoftwareInfo(ActionMapping mapping, 
	 ActionForm form, HttpServletRequest request, 
	 HttpServletResponse response) throws Exception{
	 StringBuffer sbf = new StringBuffer();
	 List<TypeInfo> list = softwareTypeInfoService.searchAll();
     for(TypeInfo type : list){
    	 HtmlFactory.getDataArray(type, sbf, "TYPE");
     }
     HtmlFactory.flushData(response, sbf);
     return null; 
    }
	
	/**
	 * 
	 * @param timel
	 * @return String 分钟转换成小时
	 */
	private String TimeConvert(Long timel) {
		String time = "";
		Long hour = timel / 60l;
		Long minute = timel % 60;
		if (minute == 0) {
			time = hour + ":00";
		} else if (minute < 10) {
			time = hour + ":0" + minute;
		} else {
			time = hour + ":" + minute;
		}
		return time;
	}

}
