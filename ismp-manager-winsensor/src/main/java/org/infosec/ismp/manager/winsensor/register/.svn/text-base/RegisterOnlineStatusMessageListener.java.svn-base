package org.infosec.ismp.manager.winsensor.register;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.agent.comm.winsensor.model.status.RegisterOnlineStatus;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time：Dec 21, 2010 10:41:36 PM
 * 
 */
public class RegisterOnlineStatusMessageListener implements MessageListener {
	
	private ManagerSensorServer managerSensorServer;

	@Override
	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
		try {
			RegisterOnlineStatus onlineStatus = (RegisterOnlineStatus) msg.getObject();
			managerSensorServer.addRegisterOnlineStatus(onlineStatus);
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
