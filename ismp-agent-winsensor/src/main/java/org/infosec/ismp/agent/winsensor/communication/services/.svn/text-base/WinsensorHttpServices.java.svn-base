package org.infosec.ismp.agent.winsensor.communication.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.handler.HandlerCollection;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * @author Rocky
 * @version create time：Sep 16, 2010 3:00:16 PM
 * 
 */
public class WinsensorHttpServices {
	private static Log log = LogFactory.getLog(WinsensorHttpServices.class);
	
	private String registerPath;
	
	private int registerPort;
	
	private String hostResourcePath;
	
	private int hostResourcePort;
	
	private String windowsLogPath;
	
	private int windowsLogPort;
	
	private String operationDutyPath;
	
	private int operationDutyPort;
	
	private String operationWorkOrdersPath;
	
	private int operationWorkOrdersPort;
	
	private RegisterHolder registerHolder;
	
	private HostResourceHolder hostResourceHolder;
	
	private WindowsLogHolder windowsLogHolder;
	
	private OperationDutyHolder operationDutyHolder;
	
	private OperationWorkOrdersHolder operationWorkOrdersHolder;
	
	private InvalidHolder invalidHolder;
	
	private Server server;
	
	public void start() {
		server = new Server();
		
		SocketConnector registerConnector = new SocketConnector();
		registerConnector.setPort(registerPort);
		registerConnector.setName("registerConnector");
		
		SelectChannelConnector hostResourceConnector = new SelectChannelConnector();
		hostResourceConnector.setPort(hostResourcePort);
		hostResourceConnector.setName("hostResourceConnector");
		
		SelectChannelConnector windowsLogConnector = new SelectChannelConnector();
		windowsLogConnector.setPort(windowsLogPort);
		windowsLogConnector.setName("windowsLogConnector");
		
		SocketConnector operationDutyConnector = new SocketConnector();
		operationDutyConnector.setPort(operationDutyPort);
		operationDutyConnector.setName("operationDutyConnector");
		
		SocketConnector operationWorkOrdersConnector = new SocketConnector();
		operationWorkOrdersConnector.setPort(operationWorkOrdersPort);
		operationWorkOrdersConnector.setName("operationWorkOrdersConnector");
		
		server.setConnectors(new Connector[] {registerConnector, hostResourceConnector, windowsLogConnector, 
				operationDutyConnector, operationWorkOrdersConnector});
		log.info("Http server add connectors, " + "registerConnector: " + registerConnector.getClass().getName() 
				+ " hostResourceConnector: " + hostResourceConnector.getClass().getName()
				+ " windowsLogConnector: " + windowsLogConnector.getClass().getName()
				+ " operationDutyConnector: " + operationDutyConnector.getClass().getName()
				+ " operationWorkOrdersConnector: " + operationWorkOrdersConnector.getClass().getName());
		
		WebAppContext registerContext = new WebAppContext();
		registerContext.setWar("/");
		registerContext.setContextPath("/");
		registerContext.setConnectorNames(new String[] {"registerConnector"});
		log.info("registerContext: " + registerContext.getClass().getName() 
				+ " created, and add connector registerConnector.");
		
		WebAppContext hostResourceContext = new WebAppContext();
		hostResourceContext.setWar("/");
		hostResourceContext.setContextPath("/");
		hostResourceContext.setConnectorNames(new String[] {"hostResourceConnector"});
		log.info("hostResourceContext: " + hostResourceContext.getClass().getName() 
				+ " created, and add connector hostResourceConnector.");
		
		WebAppContext windowsLogContext = new WebAppContext();
		windowsLogContext.setWar("/");
		windowsLogContext.setContextPath("/");
		windowsLogContext.setConnectorNames(new String[] {"windowsLogConnector"});
		log.info("windowsLogContext: " + windowsLogContext.getClass().getName() 
				+ " created, and add connector windowsLogConnctor.");
		
		WebAppContext operationDutyContext = new WebAppContext();
		operationDutyContext.setWar("/");
		operationDutyContext.setContextPath("/");
		operationDutyContext.setConnectorNames(new String[] {"operationDutyConnector"});
		log.info("operationDutyContext: " + operationDutyContext.getClass().getName() 
				+ " created, and add connector operationDutyConnector.");
		
		WebAppContext operationWorkOrdersContext = new WebAppContext();
		operationWorkOrdersContext.setWar("/");
		operationWorkOrdersContext.setContextPath("/");
		operationWorkOrdersContext.setConnectorNames(new String[] {"operationWorkOrdersConnector"});
		log.info("operationWorkOrdersContext: " + operationWorkOrdersContext.getClass().getName() 
				+ " created, and add connector operationWorkOrdersConnector.");
		
		ServletHolder invalidServletHolder = new ServletHolder(getInvalidHolder());
		invalidServletHolder.setName("invalidHolder");
		
		ServletHolder registerServletHolder = new ServletHolder(getRegisterHolder());
		registerServletHolder.setName("registerHolder");
		registerContext.addServlet(registerServletHolder, registerPath);
		registerContext.addServlet(invalidServletHolder, "/*");
		log.info("registerContext add registerHolder, and holder servlet path is: " + registerPath + ", and port: " 
				+ getRegisterPort());
		
		ServletHolder hostResourceServletHolder = new ServletHolder(getHostResourceHolder());
		hostResourceServletHolder.setName("hostResourceHolder");
		hostResourceContext.addServlet(hostResourceServletHolder, hostResourcePath);
		hostResourceContext.addServlet(invalidServletHolder, "/*");
		log.info("hostResourceContext add hostResourceHolder, and holder servlet path is: " + hostResourcePath + ", and port: " 
				+ getHostResourcePort());
		
		ServletHolder windowsLogServletHolder = new ServletHolder(getWindowsLogHolder());
		windowsLogServletHolder.setName("windowsLogHolder");
		windowsLogContext.addServlet(windowsLogServletHolder, windowsLogPath);
		windowsLogContext.addServlet(invalidServletHolder, "/*");
		log.info("windowsLogContext add windowsLogHolder, and holder servlet path is: " 
				+ windowsLogPath + ", and port: " + getWindowsLogPort());
		
		ServletHolder operationDutyServletHolder = new ServletHolder(getOperationDutyHolder());
		operationDutyServletHolder.setName("operationDutyHolder");
		operationDutyContext.addServlet(operationDutyServletHolder, operationDutyPath);
		operationDutyContext.addServlet(invalidServletHolder, "/*");
		log.info("operationDutyContext add operationDutyHolder, and holder servlet path is: " 
				+ operationDutyPath + ", and port: " + getOperationDutyPort());
		
		ServletHolder operationWorkOrdersServletHolder = new ServletHolder(getOperationWorkOrdersHolder());
		operationWorkOrdersServletHolder.setName("operationWorkOrdersHolder");
		operationWorkOrdersContext.addServlet(operationWorkOrdersServletHolder, operationWorkOrdersPath);
		operationWorkOrdersContext.addServlet(invalidServletHolder, "/*");
		log.info("operationWorkOrdersContext add operationWorkOrdersHolder, and holder servlet path is: " 
				+ operationWorkOrdersPath + ", and port: " + getOperationWorkOrdersPort());
		
		HandlerCollection collection = new HandlerCollection();
		collection.setHandlers(new Handler[] {registerContext, hostResourceContext, windowsLogContext, 
				operationDutyContext, operationWorkOrdersContext});
		
		server.addHandler(collection);
		log.info("Http server add handlers: registerContext, hostResourceContext, windowsLogContext");
		
		try {
			server.start();
			log.info("Http server is started.");
		} catch (Exception e) {
			log.warn("Exception occurs when Http server starts. " + e.getMessage());
		}
	}
	
	public void stop() {
		try {
			server.stop();
			log.info("Http server is closed.");
		} catch (Exception e) {
			log.warn("Exception occurs when Http server is stopped. " + e.getMessage());
		}
	}

	public String getRegisterPath() {
		return registerPath;
	}

	public void setRegisterPath(String registerPath) {
		this.registerPath = registerPath;
	}

	public int getRegisterPort() {
		return registerPort;
	}

	public void setRegisterPort(int registerPort) {
		this.registerPort = registerPort;
	}

	public String getHostResourcePath() {
		return hostResourcePath;
	}

	public void setHostResourcePath(String hostResourcePath) {
		this.hostResourcePath = hostResourcePath;
	}

	public int getHostResourcePort() {
		return hostResourcePort;
	}

	public void setHostResourcePort(int hostResourcePort) {
		this.hostResourcePort = hostResourcePort;
	}

	public String getWindowsLogPath() {
		return windowsLogPath;
	}

	public void setWindowsLogPath(String windowsLogPath) {
		this.windowsLogPath = windowsLogPath;
	}

	public int getWindowsLogPort() {
		return windowsLogPort;
	}

	public void setWindowsLogPort(int windowsLogPort) {
		this.windowsLogPort = windowsLogPort;
	}

	public RegisterHolder getRegisterHolder() {
		return registerHolder;
	}

	public void setRegisterHolder(RegisterHolder registerHolder) {
		this.registerHolder = registerHolder;
	}

	public HostResourceHolder getHostResourceHolder() {
		return hostResourceHolder;
	}

	public void setHostResourceHolder(HostResourceHolder hostResourceHolder) {
		this.hostResourceHolder = hostResourceHolder;
	}

	public WindowsLogHolder getWindowsLogHolder() {
		return windowsLogHolder;
	}

	public void setWindowsLogHolder(WindowsLogHolder windowsLogHolder) {
		this.windowsLogHolder = windowsLogHolder;
	}

	public InvalidHolder getInvalidHolder() {
		return invalidHolder;
	}

	public void setInvalidHolder(InvalidHolder invalidHolder) {
		this.invalidHolder = invalidHolder;
	}

	public String getOperationDutyPath() {
		return operationDutyPath;
	}

	public void setOperationDutyPath(String operationDutyPath) {
		this.operationDutyPath = operationDutyPath;
	}

	public int getOperationDutyPort() {
		return operationDutyPort;
	}

	public void setOperationDutyPort(int operationDutyPort) {
		this.operationDutyPort = operationDutyPort;
	}

	public String getOperationWorkOrdersPath() {
		return operationWorkOrdersPath;
	}

	public void setOperationWorkOrdersPath(String operationWorkOrdersPath) {
		this.operationWorkOrdersPath = operationWorkOrdersPath;
	}

	public int getOperationWorkOrdersPort() {
		return operationWorkOrdersPort;
	}

	public void setOperationWorkOrdersPort(int operationWorkOrdersPort) {
		this.operationWorkOrdersPort = operationWorkOrdersPort;
	}

	public OperationDutyHolder getOperationDutyHolder() {
		return operationDutyHolder;
	}

	public void setOperationDutyHolder(OperationDutyHolder operationDutyHolder) {
		this.operationDutyHolder = operationDutyHolder;
	}

	public OperationWorkOrdersHolder getOperationWorkOrdersHolder() {
		return operationWorkOrdersHolder;
	}

	public void setOperationWorkOrdersHolder(
			OperationWorkOrdersHolder operationWorkOrdersHolder) {
		this.operationWorkOrdersHolder = operationWorkOrdersHolder;
	}
}
