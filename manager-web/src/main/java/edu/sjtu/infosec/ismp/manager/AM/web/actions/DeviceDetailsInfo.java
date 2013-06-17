package edu.sjtu.infosec.ismp.manager.AM.web.actions;

import java.util.ArrayList;
import java.util.Date;
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
 * 设备详细信息表
 * @author Wu Guojie
 * @date 2009-7-7
 * @version 1.0
 */
public class DeviceDetailsInfo extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        try{
            ServletContext application = request.getSession().getServletContext();
            int outPutFileType = (request.getParameter("outPutFileType")!=null 
								&& !((String)request.getParameter("outPutFileType")).equals(""))
											? Integer.parseInt((String)request.getParameter("outPutFileType")) 
											: 1;
			int deviceId;
            if(request.getParameter("deviceId")!=null && !((String)request.getParameter("deviceId")).equals("")){
                deviceId = Integer.parseInt((String)request.getParameter("deviceId"));
            }else{
				response.getWriter().write("<script>alert('您没有选择设备IP！')</script>");
            	throw new Exception("您没有选择设备！");
            }
            Date startDate = new Date(new Date().getYear(), new Date().getMonth(), 1);
            Date endDate = new Date(Date.UTC(new Date().getYear(), new Date().getMonth()+1, 1, -8, 0, 0) - 1);
            
            String subReportDir = application.getRealPath("/reports/AM/")+"\\";
            //参数
            Map params = new HashMap();
            params.put("SUBREPORT_DIR", subReportDir);
            params.put("deviceId", deviceId);
            params.put("startDate", startDate);
            params.put("endDate", endDate);
            System.out.println(subReportDir+"========="+deviceId);
        //    params.put("bureau", bureau);
            //.jrxml
            List<String> jrxmlFilePathList = new ArrayList<String>();
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/DeviceBaseInfo.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/SoftwareInfo.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/HardwareInfo.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/PositionInfo.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/cpuPerformanceByDay.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/cpuPerformanceByMonth.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/cpuPerformanceByYear.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/memoryPerformanceByDay.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/memoryPerformanceByMonth.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/memoryPerformanceByYear.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/diskPerformanceByDay.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/diskPerformanceByMonth.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/diskPerformanceByYear.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/netIntByDay.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/netIntByMonth.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/netIntByYear.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/netQuByDay.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/netQuByMonth.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/netQuByYear.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/onLineByDay.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/onLineByMonth.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/onLineByYear.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/DevicePerformance.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/AM/DeviceDetailsInfo.jrxml"));
            //.jasper
            String reportFilePath = application.getRealPath("/reports/AM/DeviceDetailsInfo.jasper");
            
            ExportToFileOrHtml export = new ExportToFileOrHtml();
            
            if(outPutFileType==2){
                String outPutFileUrl = application.getRealPath("/reports/AM/DeviceDetailsInfo.rtf");
                response.addHeader("Content-Disposition", "attachment; filename=DeviceDetailsInfo.rtf");
                export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }else{
                String outPutFileUrl = application.getRealPath("/reports/AM/DeviceDetailsInfo.pdf");
                response.addHeader("Content-Disposition", "attachment; filename=DeviceDetailsInfo.pdf");
                export.exportToPdfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return null;
    }
}
