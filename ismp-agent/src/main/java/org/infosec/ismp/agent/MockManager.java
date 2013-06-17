package org.infosec.ismp.agent;

import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;

import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.eventd.sender.SingleEventResponseCallback;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;

/**
 * 用来模拟Manager给Agent发送命令
 * @author lianglin
 *
 */
public class MockManager {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		
		Event event = new Event();
		event.setUuid(UUID.randomUUID().toString());
		event.setUei(EventConstants.SYSLOGD_CONFIG_NODE_ADD_EVENT_UEI);
		event.setTime(EventConstants.formatToString(new Date()));
		event.setNodeid("123");
		event.setIpAddr("192.168.9.58");
		InetAddress address = InetAddress.getByName("192.168.9.169");
		SingleEventResponseCallback cb = new SingleEventResponseCallback(address, 5819);
		EventSender.sendEvent(address, 5819, event, 300, cb);
		cb.waitFor();
		
		System.out.println(cb.getUuid());
	}

}
