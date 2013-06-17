package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.infosec.ismp.agent.winsensor.SensorServer;
import org.infosec.ismp.agent.winsensor.exception.ContentLengthOverLimitException;
import org.infosec.ismp.agent.winsensor.exception.ParseXmlException;
import org.infosec.ismp.agent.winsensor.register.WinsensorRegisterInfo;
import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;
import org.infosec.ismp.agent.winsensor.util.FileUploadUtil;
import org.infosec.ismp.agent.winsensor.util.XmlParseUtil;

/**
 * @author Rocky
 * @version create time：Sep 28, 2010 1:54:29 PM
 * 
 */
public class RegisterHolder extends HttpServlet {

	private static final long serialVersionUID = -8876456904656888996L;
	
	private static Log log = LogFactory.getLog(RegisterHolder.class);

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
		log.debug("Get register request from Ip: " + clientIp);
		
		boolean sendSuccess = true;
		InputStream inputStream = null;
		FileUploadUtil fileUploadUtil = new FileUploadUtil();
		XmlParseUtil xmlParseUtil = new XmlParseUtil();
		WinsensorRegisterInfo registerInfo = null;
		List<BaseStrategy> strategies = new ArrayList<BaseStrategy>();
		PrintWriter writer = null;
		
		try {
			inputStream = fileUploadUtil.getCompleteInputStream(req);
			registerInfo = xmlParseUtil.parseWinsensorRegisterInfo(inputStream);
			if (registerInfo != null) {
				strategies = sensorServer.registerWinsensorClientInfo(registerInfo);
				Document document = xmlParseUtil.createRegisterBackStrategy(strategies);
				resp.setContentType("text/xml;charset=UTF-8");
				writer = resp.getWriter();
				
				writer.write(document.getRootElement().asXML());
				log.debug("Parse register info success, and return sensor client (Ip: " + clientIp + ") strategy: " 
						+ document.getRootElement().asXML());
			}
		} catch (ContentLengthOverLimitException e) {
			log.warn("Sensor client Ip: " + clientIp + " Exception info: " + e.getMessage());
			sendSuccess = false;
		}catch (ParseXmlException e) {
			log.warn("Sensor client Ip: " + clientIp + "Exception info: " + e.getMessage());
			sendSuccess = false;
		} catch (IOException e) {
			log.warn("Sensor client Ip: " + clientIp + ", Exception occurs when get all input stream. " + e.getMessage());
			sendSuccess = false;
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					sendSuccess = false;
					log.warn("Sensor client Ip: " + clientIp + ", Exception occurs when close inputStream. " + e.getMessage());
				}
				
				if (writer != null) {
					writer.close();
				}
			}
		}

		if ((sendSuccess == true) && (strategies.size() > 0)) {
			sensorServer.strategySendSuccess(registerInfo, strategies);
			log.debug("Return sensor client (Ip: " + clientIp + ") strategy success, and refresh current sensor server strategy state.");
		}
	}

	public SensorServer getSensorServer() {
		return sensorServer;
	}

	public void setSensorServer(SensorServer sensorServer) {
		this.sensorServer = sensorServer;
	}
}
