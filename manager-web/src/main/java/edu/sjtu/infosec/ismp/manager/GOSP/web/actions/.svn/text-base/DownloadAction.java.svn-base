package edu.sjtu.infosec.ismp.manager.GOSP.web.actions;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.rmi.lm.pfLog.model.SystemLog;

import edu.sjtu.infosec.ismp.manager.GOSP.comm.LogUtil;
import edu.sjtu.infosec.ismp.manager.GOSP.comm.StaticFinal;
import edu.sjtu.infosec.ismp.manager.GOSP.model.LawsAndRules;
import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;
import edu.sjtu.infosec.ismp.manager.comm.comm.reports.ExportToFileOrHtml;
import edu.sjtu.infosec.ismp.manager.comm.comm.reports.ReadFile;
/**
 * 下载法律法规的相关信息
 * 
 * @author cxk
 * 
 * Date:2010-11-17
 */
@SuppressWarnings("unused")
public class DownloadAction extends Action{
	/**
	 *  注入Service接口
	 */
	private SystemLogService systemLogService;
	
	public void setSystemLogService(SystemLogService systemLogService) {
		this.systemLogService = systemLogService;
	}

	public ActionForward execute(ActionMapping mapping,ActionForm form,
										HttpServletRequest request,HttpServletResponse response){
		/**
		 * 加载日志信息
		 */
		LogUtil.init();
		SystemLog log = new SystemLog();
		try{
			String  fileUrl="";
			String fileName="";

			String absolutePath = StaticFinal.PATH ;
			fileName = new String((request.getParameter("Name")).getBytes("iso8859-1"),"UTF-8");
			request.setAttribute("fileName", fileName);
			System.out.println("下载的文件名字--"+fileName);
			/**
			 * 拼接下载绝对路径
			 * path--静态常量
			 * fileName--页面传入
			 */
			fileUrl = absolutePath+"/"+fileName;
			System.out.println("下载文件的路径------："+fileUrl);
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"),"iso8859-1"));
			ReadFile.readFileToOutputStream(response.getOutputStream(),fileUrl);  
			
			ExportToFileOrHtml export = new ExportToFileOrHtml(); 
			// export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
			/**
			 * 加入日志相关的信息
			 */
			
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("下载文件:"+fileName);
		    log.setControl("成功！");
		    systemLogService.saveSystemLog(log);
            
		}catch(Exception e){
			String fileName = request.getAttribute("fileName").toString();
			log.setUsername(LogUtil.userName);
		    log.setRoleName(LogUtil.roleName);
		    log.setTime(new Timestamp(new Date().getTime()));
		    log.setModuleName(SystemModelInfo.MOD_GOSP);
		    log.setOperationDesc("下载文件:"+fileName);
		    log.setControl("失败！");
		    systemLogService.saveSystemLog(log);
			e.printStackTrace();
		}
		return null;
	}
}
