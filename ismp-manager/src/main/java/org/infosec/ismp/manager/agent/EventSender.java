package org.infosec.ismp.manager.agent;

import java.io.IOException;
import java.io.StringWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.lang.StringUtils;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.Events;
import org.infosec.ismp.model.event.Log;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.stereotype.Component;

@Component
public class EventSender {
	private DatagramSocket m_dgSocket;
	private DatagramPacket m_pkt;

	public EventSender() {
		init();
	}

	public void init() {
		try {
			m_dgSocket = new DatagramSocket();
		} catch (SocketException e) {
			log().error("创建DatagramoSocket 出错" + e);
		}
	}

	/**
	 * 将事件发送到指定的目的地址
	 * @param e
	 * @param addr
	 * @param port
	 * @return
	 */
	public boolean sendEvent(Event e, InetAddress addr, int port) {
		Events events = new Events();
		events.addEvent(e);
		Log log = new Log();
		log.setEvents(events);

		StringWriter writer = new StringWriter();
		try {
			Marshaller.marshal(log, writer);
		} catch (MarshalException e1) {
			log().warn("marshall log error : " + e1, e1);
		} catch (ValidationException e1) {
			log().warn("marshall log error : " + e1, e1);
		}

		String dataXml = writer.toString();

		if (StringUtils.trimToNull(dataXml) == null) {
			log().error("event cannot marshall " + e);
			return false;
		}

		byte[] data = dataXml.getBytes();

		m_pkt = new DatagramPacket(data, data.length);
		m_pkt.setAddress(addr);
		m_pkt.setPort(port);
		try {
			m_dgSocket.send(m_pkt);
		} catch (IOException e1) {
			log().error("IO Exception ,couldn't send udp pakcet", e1);
			return false;
		}
		return true;
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(EventSender.class);
	}
}
