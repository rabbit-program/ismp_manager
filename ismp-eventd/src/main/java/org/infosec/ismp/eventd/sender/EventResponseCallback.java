package org.infosec.ismp.eventd.sender;

import java.net.InetAddress;

import org.infosec.ismp.model.event.Event;

public interface EventResponseCallback {
	
	public void handleResponse(InetAddress address, int port,String uuid);

	public void handleTimeout(InetAddress address, int port,Event event);

	public void handleError(InetAddress address, int port,Event event,
			Throwable t);
	
}
