package edu.sjtu.infosec.ismp.manager.EM.web.reports;

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

import edu.sjtu.infosec.ismp.manager.EM.web.form.ReportEventGroupByForm;
import edu.sjtu.infosec.ismp.manager.comm.comm.reports.ExportToFileOrHtml;
import edu.sjtu.infosec.ismp.manager.comm.comm.reports.ReadFile;

/**
 * 事件IP地址TOP10排名
 * @author Wu Guojie
 * @date 2009-7-4
 * @version 1.0
 */
public class EventTop10 extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	ReportEventGroupByForm reportEventGroupByForm = (ReportEventGroupByForm)form;
        try{
            ServletContext application = request.getSession().getServletContext();
            int outPutFileType = (reportEventGroupByForm.getOutPutFileType()!=null) ? reportEventGroupByForm.getOutPutFileType() : 1;
            Date startDate = (reportEventGroupByForm.getStartDate()!=null) ? reportEventGroupByForm.getStartDate() : new Date();
            Date endDate = (reportEventGroupByForm.getEndDate()!=null) ? reportEventGroupByForm.getEndDate() : new Date();
            int bureauId = (reportEventGroupByForm.getBureauId()!=null) ? reportEventGroupByForm.getBureauId() : 0;
            String subReportDir = application.getRealPath("/reports/EM/")+"\\";
            //参数
            Map params = new HashMap();
            params.put("SUBREPORT_DIR", subReportDir);
            params.put("startDate", startDate);
            params.put("endDate", endDate);
            params.put("bureauId", bureauId);
            //.jrxml
            List<String> jrxmlFilePathList = new ArrayList<String>();
            jrxmlFilePathList.add(application.getRealPath("/reports/EM/EventTop10Iamge.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/EM/EventTop10Table.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/EM/EventTop10.jrxml"));
            //.jasper
            String reportFilePath = application.getRealPath("/reports/EM/EventTop10.jasper");
            
            ExportToFileOrHtml export = new ExportToFileOrHtml();
            
            if(outPutFileType==2){
                String outPutFileUrl = application.getRealPath("/reports/EM/EventTop10.rtf");
                response.addHeader("Content-Disposition", "attachment; filename=EventTop10.rtf");
                export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }else{
                String outPutFileUrl = application.getRealPath("/reports/EM/EventTop10.pdf");
                response.addHeader("Content-Disposition", "attachment; filename=EventTop10.pdf");
                export.exportToPdfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return null;
    }
}
