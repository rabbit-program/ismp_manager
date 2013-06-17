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
 * 资产可用性报表
 * @author Wu Guojie
 * @date 2009-7-2
 * @version 1.0
 */
public class DevicePerformance extends Action {
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
				response.getWriter().write("<script>alert('您没有选择设备！')</script>");
            	throw new Exception("您没有选择设备！");
            }
           
//            Date startDate = new Date(new Date().getYear(), new Date().getMonth(), 1);
//            Date endDate = new Date(Date.UTC(new Date().getYear(), new Date().getMonth()+1, 1, -8, 0, 0) - 1);
         /*   
			String startDate = "";
            if(request.getParameter("startDate")!=null && !((String)request.getParameter("startDate")).equals("")){
            	startDate = (String)request.getParameter("startDate");
            }else{
				response.getWriter().write("<script>alert('请输入开始时间！')</script>");
            	throw new Exception("请输入开始时间！");
            }
            String endDate = "";
            if(request.getParameter("endDate")!=null && !((String)request.getParameter("endDate")).equals("")){
            	endDate = (String)request.getParameter("endDate");
            }else{
				response.getWriter().write("<script>alert('请输入结束时间！')</script>");
            	throw new Exception("请输入结束时间！");
            }
			int startDateYear = 0;
			int startDateMonth = 0;
			int startDateDate = 0;
			if(startDate!=null && !startDate.equals("")){
				String[] startDateSub = startDate.split("-");
				
				startDateYear = Integer.parseInt(startDateSub[0]);
				startDateMonth = Integer.parseInt(startDateSub[1]);
				startDateDate = Integer.parseInt(startDateSub[2]);
			}
			int endDateYear = 0;
			int endDateMonth = 0;
			int endDateDate = 0;
			if(endDate!=null && !endDate.equals("")){
				String[] endDateSub = endDate.split("-");
				
				endDateYear = Integer.parseInt(endDateSub[0]);
				endDateMonth = Integer.parseInt(endDateSub[1]);
				endDateDate = Integer.parseInt(endDateSub[2]);
			}
            Date startDateParams = new Date(startDateYear, startDateMonth, startDateDate);
            Date endDateParams = new Date(endDateYear, endDateMonth, endDateDate);
            */
            String subReportDir = application.getRealPath("/reports/AM/")+"\\";
            //参数
            Map params = new HashMap();
            params.put("SUBREPORT_DIR", subReportDir);
            params.put("deviceId", deviceId);
           // params.put("startDate", startDateParams);
          //  params.put("endDate", endDateParams);
//            params.put("startDate", startDate);
//            params.put("endDate", startDate);
            //.jrxml
            List<String> jrxmlFilePathList = new ArrayList<String>();
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
            //.jasper
            String reportFilePath = application.getRealPath("/reports/AM/DevicePerformance.jasper");
            
            ExportToFileOrHtml export = new ExportToFileOrHtml();
            
            if(outPutFileType==2){
                String outPutFileUrl = application.getRealPath("/reports/AM/DevicePerformance.rtf");
                response.addHeader("Content-Disposition", "attachment; filename=DevicePerformance.rtf");
                export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }else{
                String outPutFileUrl = application.getRealPath("/reports/AM/DevicePerformance.pdf");
                response.addHeader("Content-Disposition", "attachment; filename=DevicePerformance.pdf");
                export.exportToPdfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return null;
    }
}
