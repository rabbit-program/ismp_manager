package org.infosec.ismp.manager.winsensor.windowslog;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.agent.comm.winsensor.model.windowslog.WindowsLog;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time：Dec 14, 2010 1:38:20 PM
 * 
 */
public class WindowsLogMessageListener implements MessageListener {
	
	private ManagerSensorServer managerSensorServer;

	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
		try {
			List<WindowsLog> windowsLogs = (ArrayList<WindowsLog>) msg.getObject();
			
			managerSensorServer.addWindowsLog(windowsLogs);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public ManagerSensorServer getManagerSensorServer() {
		return managerSensorServer;
	}

	public void setManagerSensorServer(ManagerSensorServer managerSensorServer) {
		this.managerSensorServer = managerSensorServer;
	}
}
