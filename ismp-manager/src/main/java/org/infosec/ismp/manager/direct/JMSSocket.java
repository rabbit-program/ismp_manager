package org.infosec.ismp.manager.direct;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import javax.jms.Message;

import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.eventd.sender.UdpEventSocket;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.jms.core.JmsTemplate;


public abstract class JMSSocket {
	

	private  JmsTemplate jmsTemplate;
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public String getDestination() {
		return destination;
	}

	private  String destination;

	
	

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * 将事件发送到指定的目的地址
	 * 
	 * @param event
	 * @param addr
	 * @param port
	 * @return
	 */
	public void sendEvent(Event event, InetAddress addr, int port)
			throws Exception {
		EventSender.sendEventNoReply(addr, port, event);
	}
	
	/**
	 * 接受jms事件
	 * @return
	 * @throws IOException
	 */
	public List<DirectReply> receive()throws IOException{
		Message message = jmsTemplate.receive(destination);
		return processMessage(message);
	}
	
	private ThreadCategory log() {
		return ThreadCategory.getInstance(UdpEventSocket.class);
	}
	
	protected abstract List<DirectReply> processMessage(Message message);
}
