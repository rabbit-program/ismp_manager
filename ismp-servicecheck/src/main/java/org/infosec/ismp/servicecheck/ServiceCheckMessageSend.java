package org.infosec.ismp.servicecheck;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ServiceCheckMessageSend {
	private JmsTemplate jmsTemplate;
	private Destination destination;	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void springSend(final Serializable object)
		throws Exception {
		jmsTemplate.send(destination, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage msg =session.createMapMessage();
				ServiceCheckModel model = (ServiceCheckModel)object;
				msg.setString("nodeid", model.getNodeid());
				msg.setString("ipAddr", model.getIpAddr());
				msg.setString("serviceType", model.getType());
				msg.setString("pingStatus", model.getPingStatus());
				msg.setDouble("responseTime", model.getResponseTime());
				msg.setString("pingTime", format.format(new Date()));
				return msg;
			}
			
		});
	}
	@Autowired(required=true)
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}	
	public void setDestination( Destination destination) {
		this.destination = destination;
	}
}
