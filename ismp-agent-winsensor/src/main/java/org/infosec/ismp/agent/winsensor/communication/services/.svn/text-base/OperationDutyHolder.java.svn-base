package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.infosec.ismp.agent.winsensor.SensorServer;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.util.FileUploadUtil;
import org.infosec.ismp.agent.winsensor.util.XmlParseUtil;

/**
 * @author Rocky
 * @version create time: Jan 12, 2011 10:30:23 AM
 *
 */
public class OperationDutyHolder extends HttpServlet {

	private static final long serialVersionUID = -2062497937004072606L;
	
	private SensorServer sensorServer;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		InputStream inputStream = null;
		FileUploadUtil fileUploadUtil = new FileUploadUtil();
		XmlParseUtil xmlParseUtil = new XmlParseUtil();
		PrintWriter printWriter = null;
		
		try {
			inputStream = fileUploadUtil.getCompleteInputStream(req);
			String sensorId = xmlParseUtil.parseDutyConnection(inputStream);
			resp.setContentType("text/xml;charset=UTF-8");
			printWriter = resp.getWriter();
			
			if (!StringUtils.isBlank(sensorId)) {
				AgentDutyManagerBO dutyManager = sensorServer.getNewDutyInfo(sensorId);
				if (dutyManager != null) {
					Document document = xmlParseUtil.createDuty(dutyManager);
					System.out.println("Duty: " + document.getRootElement().asXML());
					printWriter.write(document.getRootElement().asXML());
					
					sensorServer.dutySendSuccess(sensorId, String.valueOf(dutyManager.getId()));
				} else {
					if (sensorServer.ifRemovedCurrentDutyInfo(sensorId)) {
						Document document = xmlParseUtil.createRemovedDuty();
						printWriter.write(document.getRootElement().asXML());
						
						sensorServer.removedCurrentDutySuccess(sensorId);
					} else {
						printWriter.write("");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (printWriter != null) {
				printWriter.close();
			}
		}
		
	}

	public void setSensorServer(SensorServer sensorServer) {
		this.sensorServer = sensorServer;
	}
}
