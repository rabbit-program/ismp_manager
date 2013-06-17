package org.infosec.ismp.eventd.sender;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 负责向指定的destination发送对象
 * 
 * @author lianglin
 * 
 */
@Component
public class ObjectJmsSender {

	private JmsTemplate jmsTemplate;

	private Destination destination;

	public void sendSerializableObject(final Serializable object)
			throws Exception {
		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage msg = session.createObjectMessage();
				msg.setObject(object);
				return msg;
			}

		});
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	@Autowired(required = true)
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Autowired(required = true)
	public void setDestination(Destination destination) {
		this.destination = destination;
	}

}
