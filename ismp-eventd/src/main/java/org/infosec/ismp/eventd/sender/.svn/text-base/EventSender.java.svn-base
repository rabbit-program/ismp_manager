package org.infosec.ismp.eventd.sender;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;
import java.util.UUID;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;
import org.opennms.protocols.rt.IDBasedRequestLocator;
import org.opennms.protocols.rt.RequestTracker;

public class EventSender {
	private static RequestTracker<EventRequest, EventReply> s_commandTracker;

	public static void sendEvent(InetAddress host, int port, Event event,
			long timeout, EventResponseCallback cb) throws Exception {
		initialize();
		EventRequest request = new EventRequest(host, port, event, timeout, cb);
		s_commandTracker.sendRequest(request);
	}

	public static boolean sendEvent(InetAddress host, int port, Event event) {
		String uuid = event.getUuid();
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
			event.setUuid(uuid);
		}
		SingleEventResponseCallback cb = new SingleEventResponseCallback(host,
				port);
		try {
			sendEvent(host, port, event, 3000, cb);
			cb.waitFor();
		} catch (Exception e) {
			log().warn("发送事件出错", e);
		}
		if (uuid.equals(cb.getUuid())) {
			return true;
		} else {
			return false;
		}
	}

	public static void sendEventNoReply(InetAddress host, int port, Event event) throws Exception{
		String uuid = event.getUuid();
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
			event.setUuid(uuid);
		}
		SingleEventResponseCallback cb = new SingleEventResponseCallback(host,
				port);

		sendEvent(host, port, event, 3000, cb);

	}

	static ThreadCategory log() {
		return ThreadCategory.getInstance(EventSender.class.getName());
	}

	/**
	 * Initializes this singleton
	 */
	public synchronized static void initialize() throws IOException {
		if (s_commandTracker != null)
			return;
		s_commandTracker = new RequestTracker<EventRequest, EventReply>(
				"Command",
				new EventMessager(),
				new IDBasedRequestLocator<EventRequestId, EventRequest, EventReply>());
		s_commandTracker.start();
	}
}
