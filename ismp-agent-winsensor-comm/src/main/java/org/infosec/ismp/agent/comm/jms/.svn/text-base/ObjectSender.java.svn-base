package org.infosec.ismp.agent.comm.jms;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * @author Rocky
 * @version create time：Dec 14, 2010 1:51:21 PM
 * 
 */
public class ObjectSender {

	private JmsTemplate jmsTemplate;
	
	private Destination destination;
	
	public void sendSerializableObject(final Serializable obj) {
		jmsTemplate.send(destination, new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage msg = session.createObjectMessage();
				msg.setObject(obj);
				return msg;
			}
			
		});
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
}
