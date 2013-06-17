package org.infosec.ismp.manager.winsensor.status;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time：Dec 17, 2010 2:12:33 PM
 * 
 */
public class HostResourceMessageListener implements MessageListener {
	
	private ManagerSensorServer managerSensorServer;
	
	@Override
	public void onMessage(Message message) {
		ObjectMessage msg = (ObjectMessage) message;
		try {
			HostResource hostResource = (HostResource) msg.getObject();
			System.out.println("nodeId: " + hostResource.getDevice().getNodeId());
			getManagerSensorServer().addHostResource(hostResource);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
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
