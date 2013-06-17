package edu.sjtu.infosec.ismp.manager.comm.comm.reports;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * 利用报表模板生成各种格式报表
 * @author Wu Guojie
 * @date 2009-7-1
 * @version 1.0
 */
public class ExportToFileOrHtml {
	/**
	 * 导出PDF报表
	 * @param request
	 * @param response
	 * @param jrxmlFilePathList
	 * @param reportFilePath
	 * @param params
	 * @throws Exception
	 */
    public void exportToPdf(HttpServletRequest request,HttpServletResponse response, List<String> jrxmlFilePathList,String reportFilePath, Map params) throws Exception {
        try {
            response.setContentType("application/pdf; charset=utf-8");
            response.reset();
            ApplicationContext applicationContext=(WebApplicationContext)request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            JasperPrint jasperPrint = new JasperPrintWithHibernate(jrxmlFilePathList, reportFilePath, params, applicationContext).getJasperPrint();
            // 使用JRPdfExporter导出PDF格式
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.TRUE);
            exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "utf-8");
            // 导出
            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("在导出PDF格式报表时发生错误!");
        }
    }
	/**
	 * 导出PDF报表文件
	 * @param request
	 * @param jrxmlFilePathList
	 * @param reportFilePath
	 * @param params
	 * @param outPutFileUrl
	 * @throws Exception
	 */
    public void exportToPdfFile(HttpServletRequest request, List<String> jrxmlFilePathList,String reportFilePath, Map params, String outPutFileUrl) throws Exception {
        try {
            ApplicationContext applicationContext=(WebApplicationContext)request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            JasperPrint jasperPrint = new JasperPrintWithHibernate(jrxmlFilePathList, reportFilePath, params, applicationContext).getJasperPrint();
            // 使用JRPdfExporter导出PDF格式
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outPutFileUrl);
//            exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.TRUE);
            exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "utf-8");
            // 导出
            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("在导出PDF格式报表时发生错误!");
        }
    }

	/**
	 * 导出RTF(包括word)报表文件
	 * @param request
	 * @param jrxmlFilePathList
	 * @param reportFilePath
	 * @param params
	 * @param outPutFileUrl
	 * @throws Exception
	 */
    public void exportToRtfFile(HttpServletRequest request, List<String> jrxmlFilePathList,String reportFilePath, Map params, String outPutFileUrl) throws Exception {

        try {
            ApplicationContext applicationContext=(WebApplicationContext)request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        	JasperPrint jasperPrint = new JasperPrintWithHibernate(jrxmlFilePathList, reportFilePath, params, applicationContext).getJasperPrint();
            // 使用JRRtfExporter导出RTF格式
            JRRtfExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outPutFileUrl);
            exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "utf-8");
            // 导出
            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("在导出RTF格式报表时发生错误!");
        }
    }

	/**
	 * 导出Excel报表
	 * @param request
	 * @param response
	 * @param jrxmlFilePathList
	 * @param reportFilePath
	 * @param params
	 * @throws Exception
	 */
    public void exportToExcel(HttpServletRequest request,HttpServletResponse response, List<String> jrxmlFilePathList,String reportFilePath, Map params) throws Exception {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.reset();
            ApplicationContext applicationContext=(WebApplicationContext)request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            JasperPrint jasperPrint = new JasperPrintWithHibernate(jrxmlFilePathList, reportFilePath, params, applicationContext).getJasperPrint();
            // 使用JRXlsExporter导出Excel格式
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "utf-8");
            // 导出
            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("在导出Excel格式报表时发生错误!");
        }
    }
	/**
	 * 导出Excel报表文件
	 * @param request
	 * @param jrxmlFilePathList
	 * @param reportFilePath
	 * @param params
	 * @param outPutFileUrl
	 * @throws Exception
	 */
    public void exportToExcelFile(HttpServletRequest request, List<String> jrxmlFilePathList,String reportFilePath, Map params, String outPutFileUrl) throws Exception {
        try {
            ApplicationContext applicationContext=(WebApplicationContext)request.getSession().getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            JasperPrint jasperPrint = new JasperPrintWithHibernate(jrxmlFilePathList, reportFilePath, params, applicationContext).getJasperPrint();
            // 使用JRXlsExporter导出Excel格式
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outPutFileUrl);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "utf-8");
            // 导出
            exporter.exportReport();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("在导出Excel格式报表时发生错误!");
        }
    }
}
