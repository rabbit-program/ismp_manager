package org.infosec.ismp.agent;

import java.io.StringWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

import org.exolab.castor.xml.Marshaller;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.Events;
import org.infosec.ismp.model.event.Log;
import org.infosec.ismp.model.spservicepoller.SpecialService;

/**
 * 
 * mock manager server
 *
 */
public class MockAgentClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Event event = new Event();
		event.setUei(EventConstants.SPECIAL_SERVICE_DELETE_EVENT_UEI);
//		event.setServiceId(String.valueOf(1));
		event.setTime(EventConstants.formatToString(new Date()));
		
		Log log = new Log();
		Events events = new Events();
		events.addEvent(event);
		log.setEvents(events);
		
		StringWriter writer = new StringWriter();
		Marshaller.marshal(log, writer);
		System.out.println(writer.toString());
		
		String xml = writer.toString();
		byte[] data = xml.getBytes();
		
		DatagramPacket pkt = new DatagramPacket(data,0,data.length);
		pkt.setAddress(InetAddress.getLocalHost());
		pkt.setPort(5817);
		DatagramSocket socket = new DatagramSocket();
		socket.send(pkt);
		socket.close();
		
		
		Thread.sleep(1000*30);
		
		sendAddEvent();
	}
	
	private static void sendAddEvent()throws Exception{
		Event event = new Event();
		event.setUei(EventConstants.SPECIAL_SERVICE_ADD_EVENT_UEI);
//		event.setServiceId(String.valueOf(2));
		event.setTime(EventConstants.formatToString(new Date()));
		SpecialService service = new SpecialService();
		service.setIpAddr("192.168.9.253");
		service.setInterval(1000*3);
		service.setSvcName("icmp");
		service.setServiceId(2);
		service.setName("testadddService");
		service.setStatus("down");
//		event.setSpecialService(service);
		
		Log log = new Log();
		Events events = new Events();
		events.addEvent(event);
		log.setEvents(events);
		
		StringWriter writer = new StringWriter();
		Marshaller.marshal(log, writer);
		System.out.println(writer.toString());
		
		String xml = writer.toString();
		byte[] data = xml.getBytes();
		
		DatagramPacket pkt = new DatagramPacket(data,0,data.length);
		pkt.setAddress(InetAddress.getLocalHost());
		pkt.setPort(5817);
		DatagramSocket socket = new DatagramSocket();
		socket.send(pkt);
		socket.close();
		
	}

}
