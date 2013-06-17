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
 * 基于拓扑信息的事件统计
 * @author Wu Guojie
 * @date 2009-7-7
 * @version 1.0
 */
public class TopoEvent extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
    	ReportEventGroupByForm reportEventGroupByForm = (ReportEventGroupByForm)form;
        try{
            ServletContext application = request.getSession().getServletContext();
            int outPutFileType = (reportEventGroupByForm.getOutPutFileType()!=null) ? reportEventGroupByForm.getOutPutFileType() : 1;
            Date startDate = (reportEventGroupByForm.getStartDate()!=null) ? reportEventGroupByForm.getStartDate() : new Date();
            Date endDate = (reportEventGroupByForm.getEndDate()!=null) ? reportEventGroupByForm.getEndDate() : new Date();
            int bureauId = (reportEventGroupByForm.getBureauId()!=null) ? reportEventGroupByForm.getBureauId() : 0;
            //参数
            Map params = new HashMap();
            params.put("startDate", startDate);
            params.put("endDate", endDate);
            params.put("bureauId", bureauId);
            //.jrxml
            List<String> jrxmlFilePathList = new ArrayList<String>();
            jrxmlFilePathList.add(application.getRealPath("/reports/EM/TopoEvent.jrxml"));
            //.jasper
            String reportFilePath = application.getRealPath("/reports/EM/TopoEvent.jasper");
            
            ExportToFileOrHtml export = new ExportToFileOrHtml();
            
            if(outPutFileType==2){
                String outPutFileUrl = application.getRealPath("/reports/EM/TopoEvent.rtf");
                response.addHeader("Content-Disposition", "attachment; filename=TopoEvent.rtf");
                export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }else{
                String outPutFileUrl = application.getRealPath("/reports/EM/TopoEvent.pdf");
                response.addHeader("Content-Disposition", "attachment; filename=TopoEvent.pdf");
                export.exportToPdfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
                ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return null;
    }
}
