package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.agent.winsensor.SensorServer;
import org.infosec.ismp.agent.winsensor.exception.ContentLengthOverLimitException;
import org.infosec.ismp.agent.winsensor.exception.ParseXmlException;
import org.infosec.ismp.agent.winsensor.util.FileUploadUtil;
import org.infosec.ismp.agent.winsensor.util.XmlParseUtil;

/**
 * @author Rocky
 * @version create time：Sep 28, 2010 1:52:30 PM
 * 
 */
public class HostResourceHolder extends HttpServlet {

	private static final long serialVersionUID = -5135138624049042956L;
	
	private static Log log = LogFactory.getLog(HostResourceHolder.class);
	
	private SensorServer sensorServer;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		handleRequest(req, resp);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String clientIp = req.getRemoteAddr();
		log.debug("Get hostResource request from Ip: " + clientIp);
		
		InputStream inputStream = null;
		ServletOutputStream outputStream = null;
		FileUploadUtil fileUploadUtil = new FileUploadUtil();
		XmlParseUtil xmlParseUtil = new XmlParseUtil();
		HostResource hostResource = null;
		
		try {
			inputStream = fileUploadUtil.getCompleteInputStream(req);
			outputStream = resp.getOutputStream();
			hostResource = xmlParseUtil.parseHostResource(inputStream);
		} catch (ContentLengthOverLimitException e) {
			log.warn("Sensor client Ip: " + clientIp + " Exception info: " + e.getMessage());
		} catch (ParseXmlException e) {
			log.warn("Sensor client Ip: " + clientIp + "Exception info: " + e.getMessage());
		} catch (IOException e) {
			log.warn("Sensor client Ip: " + clientIp + ", Exception occurs when get all input stream. " + e.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					log.warn("Sensor client Ip: " + clientIp + ", Exception occurs when close inputStream. " + e.getMessage());
				}
			}
			
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					log.warn("Sensor client Ip: " + clientIp + ", Exception occurs when close inputStream. " + e.getMessage());
				}
			}
		}
		
		//Call Sensor Server interface to handle hostResources info.
		if (hostResource != null) {
			sensorServer.addHostResource(hostResource);
			log.debug("Parse hostResource info success, and sent the info to Sensor server, client Ip: " + clientIp);
		}
	}
	
	public void setSensorServer(SensorServer sensorServer) {
		this.sensorServer = sensorServer;
	}
}
