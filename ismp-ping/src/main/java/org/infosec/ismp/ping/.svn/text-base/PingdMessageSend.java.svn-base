package org.infosec.ismp.ping;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class PingdMessageSend {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void springSend(final Serializable object)
		throws Exception {
		jmsTemplate.send(destination, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
//				ObjectMessage msg = session.createObjectMessage(object);
				PingdModel pindgmodel = (PingdModel)object;
				MapMessage msg =session.createMapMessage();
				msg.setString("nodeid", pindgmodel.getNodeid());
				msg.setString("ipAddr", pindgmodel.getIpAddr());
				if(pindgmodel.getResponseTime()!=null){
					msg.setLong("responseTime", pindgmodel.getResponseTime());
				}
				else
				{
					msg.setLong("responseTime", -1);
				}
				msg.setString("pingFlag", pindgmodel.getPingFlag());
				msg.setString("pingTime",format.format(new Date()));
				return msg;
			}
			
		});
	}	
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void setDestination( Destination destination) {
		this.destination = destination;
	}
}
