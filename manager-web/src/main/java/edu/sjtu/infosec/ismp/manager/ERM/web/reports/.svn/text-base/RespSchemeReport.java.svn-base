package edu.sjtu.infosec.ismp.manager.ERM.web.reports;

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
 * 应急响应预案报表
 * @author Wu Guojie
 * @date 2009-8-4
 * @version 1.0
 */
public class RespSchemeReport extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        try{
            ServletContext application = request.getSession().getServletContext();
			int schemeId;
            if(request.getParameter("schemeId")!=null && !((String)request.getParameter("schemeId")).equals("")){
            	schemeId = Integer.parseInt((String)request.getParameter("schemeId"));
            }else{
				response.getWriter().write("<script>alert('请选择应急方案！')</script>");
            	throw new Exception("您没有选择应急方案！");
            }
            String subReportDir = application.getRealPath("/reports/ERM/")+"\\";
            //参数
            Map params = new HashMap();
            params.put("SUBREPORT_DIR", subReportDir);
            params.put("schemeId", schemeId);
            //.jrxml
            List<String> jrxmlFilePathList = new ArrayList<String>();
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme0Cover.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme1Summary.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView1Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView2Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView3Image1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView3Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView4Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView5Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView6Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView6Table1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView7Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView7Table1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView7Text2.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme2GeneralView.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme3SysDesc.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme4Plan1Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme4Plan2Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme4Plan3Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme4Plan.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme5DefenseScheme1Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme5DefenseScheme.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme6BaseTermAndDefinition.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix1Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix2Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix3Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix4Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix5Table1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix5Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix6Table1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix6Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix7Text1.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme7Appendix.jrxml"));
            jrxmlFilePathList.add(application.getRealPath("/reports/ERM/respScheme.jrxml"));
            //.jasper
            String reportFilePath = application.getRealPath("/reports/ERM/respScheme.jasper");
            
            ExportToFileOrHtml export = new ExportToFileOrHtml();

            String outPutFileUrl = application.getRealPath("/reports/ERM/RespSchemeReport.rtf");
            response.addHeader("Content-Disposition", "attachment; filename=RespSchemeReport.rtf");
            export.exportToRtfFile(request, jrxmlFilePathList, reportFilePath, params, outPutFileUrl);
            ReadFile.readFileToOutputStream(response.getOutputStream(), outPutFileUrl);
        }catch(Exception e){
        	e.printStackTrace();
        }
    	return null;
    }
}
