package org.infosec.ismp.manager.direct;

import java.io.Serializable;
import java.net.InetAddress;

import org.infosec.ismp.model.event.Event;

public interface DirectResponseCallback {
	public void handleResponse(InetAddress address,int port,Serializable reply,String uuid);

	public void handleTimeout(InetAddress address,int port,Event event);

	public void handleError(InetAddress address,int port,Event event,
			Throwable t);
}
