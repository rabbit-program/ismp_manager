package org.infosec.ismp.manager.winsensor.operation;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.manager.winsensor.ManagerSensorServer;

/**
 * @author Rocky
 * @version create time: Jan 15, 2011 4:14:18 PM
 *
 */
public class OperationProblemMessageListener implements MessageListener {
	
	private ManagerSensorServer managerSensorServer;

	@Override
	public void onMessage(Message message) {
		ObjectMessage obj = (ObjectMessage) message;
		
		try {
			Problem problem = (Problem) obj.getObject();
			managerSensorServer.commitOperationProblem(problem);
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
