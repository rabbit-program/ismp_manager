package org.infosec.ismp.sitecheck;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

public class SiteCheckMessageSend {
	private JmsTemplate jmsTemplate;
	private Destination destination;	
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void springSend(final Serializable object)
		throws Exception {
		jmsTemplate.send(destination, new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage msg =session.createMapMessage();
				SiteCheckModel model = (SiteCheckModel)object;
				msg.setString("nodeid",model.getNodeid());
				msg.setString("url", model.getUrl());
				msg.setString("pingStatus", model.getPingStatus());//ping状态  "Up", "Down"				
				msg.setDouble("responseTime", model.getResponseTime());
				msg.setString("siteCheckStatus", model.getSiteCheckStatus());//解析网站状态   "NORMAL", "EXCEPTION", "Down"	
				msg.setBoolean("isReset", model.isReset());//是否为重置操作
				msg.setString("pingTime", format.format(new Date()));
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
