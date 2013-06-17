package edu.sjtu.infosec.ismp.manager.AM.web.actions;

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
 * 各类型设备统计
 * @author Wu Guojie
 * @date 2009-7-4
 * @version 1.0
 */
public class DeviceCountInBureauGroupByType extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        try{
            ServletContext application = request.getSession().getServletContext();
            int outPutFileType = (request.getParameter("outPutFileType")!=null 
					&& !((String)request.getParameter("outPutFileType")).equals(""))
								? Integer.parseInt((String)request.getParameter("outPutFileType")) 
								: 1;
            String bureauId = "";
            if(request.getParameter("bureauId")!=null && !((String)request.getParameter("bureauId")).equals("")){
            	bureauId = (String)request.getParameter("bureauId");
            }else{
            	bureauId = "all";
            }
			String myWhere="";
			if(bureauId!=null && !bureauId.equals("") && !bureauId.equals("all")){
				myWhere = " where a.locationId="+bureauId+" ";
			}else{
				myWhere = " ";
			}
			
            String subReportDir = application.getRealPath("/reports/AM/")+"\\";
            //参数
            Map params = new HashMap();
            params.put("SUBREPORT_DIR", subReportDir);
            params.put("myWhere", myWhere);
            //.jrxml
            List<String> jrxmlFilePathList = new ArrayList<String>();
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/DeviceCountInBureauGroupByTypeImage.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/DeviceCountInBureauGroupByTypeTable.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/DeviceCountInBureauGroupByType.jrxml"));
            //.jasper
            String reportFilePath = application.getRealPath("/reports/AM/DeviceCountInBureauGroupByType.jasper");
            
            ExportToFileOrHtml export = new ExportToFileOrHtml();
            
            if(outPutFileType==2){
                String outPutFileUrl = application.getRealPath("/reports/AM/DeviceCountInBureauGroupByType.rtf");
                response.addHeader("Content-Disposition", "attachment; filename=DeviceCountInBureauGroupByType.rtf");
                export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }else{
                String outPutFileUrl = application.getRealPath("/reports/AM/DeviceCountInBureauGroupByType.pdf");
                response.addHeader("Content-Disposition", "attachment; filename=DeviceCountInBureauGroupByType.pdf");
                export.exportToPdfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return null;
    }
}
