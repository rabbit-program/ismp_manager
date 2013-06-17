package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.agent.winsensor.SensorServer;
import org.infosec.ismp.agent.winsensor.operation.entity.ProblemBO;
import org.infosec.ismp.agent.winsensor.util.FileUploadUtil;
import org.infosec.ismp.agent.winsensor.util.XmlParseUtil;

/**
 * @author Rocky
 * @version create time: Jan 12, 2011 10:34:56 AM
 *
 */
public class OperationWorkOrdersHolder extends HttpServlet {

	private static final long serialVersionUID = 6736367710367367552L;
	
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
			printWriter = resp.getWriter();
			Document document = xmlParseUtil.parseProblemConnection(inputStream);
			
			if (xmlParseUtil.parseIfCommitProblems(document)) {
				List<Problem> problems = xmlParseUtil.parseOperationProblems(document);
				if (problems.size() > 0) {
					sensorServer.commitOperationProblems(problems);
					//Return accept commit problem info.
					Document returnDocument = xmlParseUtil.createProblemsCommitSuccessInfo(problems);
					printWriter.write(returnDocument.getRootElement().asXML());
				}
			} else {
				String sensorId = xmlParseUtil.parseOperationWorkOrdersSensorId(document);
				if (!StringUtils.isBlank(sensorId)) {
					List<ProblemBO> problems = sensorServer.getOperationWorkOrdersInfo(sensorId);
					Document returnDocument = xmlParseUtil.createOrdersStatusChangedInfo(problems);
					printWriter.write(returnDocument.getRootElement().asXML());
					sensorServer.workOrdersStatusSendSuccess(problems);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSensorServer(SensorServer sensorServer) {
		this.sensorServer = sensorServer;
	}
}
