package edu.sjtu.infosec.ismp.manager.comm.web.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.comm.comm.reports.ExportToFileOrHtml;
import edu.sjtu.infosec.ismp.manager.comm.comm.reports.ReadFile;


/**
 * 硬件清单报表
 * @author Wu Guojie
 * @date 2009-7-2
 * @version 1.0
 */
public class HardwareList extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        try{
            ServletContext application = request.getSession().getServletContext();
            int outPutFileType = (request.getParameter("outPutFileType")!=null 
					&& !((String)request.getParameter("outPutFileType")).equals(""))
											? Integer.parseInt((String)request.getParameter("outPutFileType")) 
											: 1;
            //参数
            Map params = new HashMap();
            //.jrxml
            List<String> jrxmlFilePathList = new ArrayList<String>();
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/HardwareList.jrxml"));
            //.jasper
            String reportFilePath = application.getRealPath("/reports/AM/HardwareList.jasper");
            
            ExportToFileOrHtml export = new ExportToFileOrHtml();
            
            if(outPutFileType==3){
                String outPutFileUrl = application.getRealPath("/reports/AM/HardwareList.xls");
                response.addHeader("Content-Disposition", "attachment; filename=HardwareList.xls");
                export.exportToExcelFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }else if(outPutFileType==2){
                String outPutFileUrl = application.getRealPath("/reports/AM/HardwareList.rtf");
                response.addHeader("Content-Disposition", "attachment; filename=HardwareList.rtf");
                export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }else{
                String outPutFileUrl = application.getRealPath("/reports/AM/HardwareList.pdf");
                response.addHeader("Content-Disposition", "attachment; filename=HardwareList.pdf");
                export.exportToPdfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return null;
    }
}
