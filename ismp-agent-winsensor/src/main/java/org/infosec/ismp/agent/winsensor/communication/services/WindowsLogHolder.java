package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.agent.comm.winsensor.model.windowslog.WindowsLog;
import org.infosec.ismp.agent.winsensor.SensorServer;
import org.infosec.ismp.agent.winsensor.exception.ContentLengthOverLimitException;
import org.infosec.ismp.agent.winsensor.exception.ParseXmlException;
import org.infosec.ismp.agent.winsensor.util.FileUploadUtil;
import org.infosec.ismp.agent.winsensor.util.XmlParseUtil;

/**
 * @author Rocky
 * @version create time：Oct 29, 2010 2:22:31 PM
 * 
 */
public class WindowsLogHolder extends HttpServlet {

	private static final long serialVersionUID = 8222668036512010191L;
	
	private static Log log = LogFactory.getLog(WindowsLogHolder.class);
	
	private SensorServer sensorServer;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String clientIp = req.getRemoteAddr();
		log.debug("Get windowsLog request from Ip: " + clientIp);
		
		InputStream completeInputStream = null;
		XmlParseUtil xmlParseUtil = new XmlParseUtil();
		List<WindowsLog> windowsLogs = new ArrayList<WindowsLog>();
		FileUploadUtil fileUploadUtil = new FileUploadUtil();
		
		try {
			completeInputStream = fileUploadUtil.getCompleteInputStream(req);
			windowsLogs = xmlParseUtil.parseWindowsLog(completeInputStream);
		} catch (ContentLengthOverLimitException e) {
			log.warn("Sensor client Ip: " + clientIp + " Exception info: " + e.getMessage());
		} catch (ParseXmlException e) {
			log.warn("Sensor client Ip: " + clientIp + "Exception info: " + e.getMessage());
		}catch (IOException e) {
			log.warn("Sensor client Ip: " + clientIp + ", Exception occurs when get all input stream. " + e.getMessage());
		} finally {
			if (completeInputStream != null) {
				try {
					completeInputStream.close();
				} catch (IOException e) {
					log.warn("Sensor client Ip: " + clientIp + ", Exception occurs when close completeInputStream. " + e.getMessage());
				}
			}
		}
		
		if (windowsLogs.size() > 0) {
			sensorServer.addWindowsLog(windowsLogs);
			log.debug("Parse WindowsLog info success, and sent the info to Sensor server, client Ip: " 
					+ clientIp + " WindowsLog size: " + windowsLogs.size());
		}
	}
	
	public SensorServer getSensorServer() {
		return sensorServer;
	}

	public void setSensorServer(SensorServer sensorServer) {
		this.sensorServer = sensorServer;
	}
}
