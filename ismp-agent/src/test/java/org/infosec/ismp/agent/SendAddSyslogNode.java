package org.infosec.ismp.agent;

import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.eventd.sender.SingleEventResponseCallback;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

public class SendAddSyslogNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SYSLOGD_CONFIG_NODE_DELETE_EVENT_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid("123");
		InetAddress address = InetAddress.getByName("192.168.9.169");
		boolean flag =EventSender.sendEvent(address, 5819, event);
		System.out.println("send flag is : "+flag);

	}

}
