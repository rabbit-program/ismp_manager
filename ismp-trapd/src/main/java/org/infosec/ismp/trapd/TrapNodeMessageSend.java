package org.infosec.ismp.trapd;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TrapNodeMessageSend {
		private JmsTemplate jmsTemplate;
		private Destination destination;
		public void setJmsTemplate(JmsTemplate jmsTemplate) {
			this.jmsTemplate = jmsTemplate;
		}
		public void setDestination(Destination destination) {
			this.destination = destination;
		}
		private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		public void springsend(final Serializable object){
			jmsTemplate.send(destination,new MessageCreator(){
				@Override
				public Message createMessage(Session session)
						throws JMSException {
					return session.createObjectMessage(object);
				}
				
			});
		}
		

}
