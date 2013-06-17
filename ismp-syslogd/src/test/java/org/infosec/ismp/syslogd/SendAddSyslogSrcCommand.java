package org.infosec.ismp.syslogd;

import java.net.InetAddress;
import java.util.UUID;

import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.eventd.sender.SingleEventResponseCallback;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.syslog.UeiMatch;

public class SendAddSyslogSrcCommand {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Event event = new Event();
		event.setUei(EventConstants.SYSLOGD_CONFIG_NODE_ADD_EVENT_UEI);
	
		event.setUuid(UUID.randomUUID().toString());
		
//		UeiMatch match = new UeiMatch();
//		match.setIpAddr("127.0.0.1");
//		match.setSyslogType("hillstone");
//		match.setDomainId("1");
//		match.setSyslogSrcId("1");
		
		event.addParam("ipaddr", "127.0.0.1");
		event.addParam("domainid", "1");
		event.addParam("syslogsrcid", "1");
		event.addParam("syslogtype", "hillstone");
		InetAddress local = InetAddress.getByName("127.0.0.1");
		int port = 5819;
		SingleEventResponseCallback cb = new SingleEventResponseCallback(local, port);
		EventSender.sendEvent(local, port, event, 5*1000, cb);
		
		cb.waitFor();
		
	    System.out.println(cb.getUuid());

	}

}
