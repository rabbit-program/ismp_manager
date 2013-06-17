package org.infosec.ismp.eventd.sender;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventReceipt;
import org.infosec.ismp.model.event.Events;
import org.infosec.ismp.model.event.Log;
import org.infosec.ismp.util.ThreadCategory;

public class UdpEventSocket {
	private DatagramSocket m_dgSocket;
	private DatagramPacket m_pkt;

	public UdpEventSocket() {
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
	 * 
	 * @param e
	 * @param addr
	 * @param port
	 * @return
	 */
	public void sendEvent(Event e, InetAddress addr, int port)
			throws Exception {
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
			throw new Exception("event cannot marshall");
		}

		byte[] data = dataXml.getBytes();

		m_pkt = new DatagramPacket(data, data.length);
//		m_pkt.setAddress(InetAddress.getByName("127.0.0.1"));
//		m_pkt.setPort(5817);
		System.out.println("add is : "+addr);
		System.out.println("port is : "+port);
		System.out.println("m_dgSocket is : "+m_dgSocket.getLocalPort());
		m_pkt.setAddress(addr);
		m_pkt.setPort(port);
		m_dgSocket.send(m_pkt);
	}
	
	public List<EventReply> receive()throws IOException{
		byte[] buf = new byte[0xff];
		DatagramPacket packet = new DatagramPacket(buf,0,0xff);
		m_dgSocket.receive(packet);
		byte[] data = packet.getData();
//		System.out.println("receive data is : "+new String(data,"utf-8"));
		StringReader reader = new StringReader(new String(data,0,packet.getLength(),"utf-8"));
		EventReceipt receipt = null;
		try {
			
			receipt = (EventReceipt)Unmarshaller.unmarshal(EventReceipt.class, reader);
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		
		InetAddress remoteAddr = packet.getAddress();
		int port = packet.getPort();
		List<EventReply> replys = new ArrayList<EventReply>();
		if(receipt!=null){
			String[] uuids = receipt.getUuid();
			for(String uuid:uuids){
				EventReply reply = new EventReply(remoteAddr, port, uuid);
				replys.add(reply);
			}
		}
		return replys;
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(UdpEventSocket.class);
	}
}
