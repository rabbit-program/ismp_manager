package org.infosec.ismp.eventd.sender;

import java.net.InetAddress;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.infosec.ismp.model.event.Event;
import org.opennms.protocols.rt.Request;

public class EventRequest implements
		Request<EventRequestId, EventRequest, EventReply> {

	private EventRequestId m_id;

	private InetAddress m_address;

	private int m_port;

	private Event m_event;

	private EventResponseCallback m_callback;

	/**
	 * how long to wait for a response
	 */
	private final long m_timeout;

	/**
	 * The expiration time of this request
	 */
	private long m_expiration = -1L;

	private final AtomicBoolean m_processed = new AtomicBoolean(false);

	public EventRequest(InetAddress address, int port, Event event,
			long timeout,EventResponseCallback call) {
		m_id = new EventRequestId(address,  event.getUuid());
		m_address = address;
		m_port = port;
		m_event = event;
		m_timeout = timeout;
		m_callback=call;
	}

	public long getExpiration() {
		return m_expiration;
	}

	@Override
	public int compareTo(Delayed request) {
		long myDelay = getDelay(TimeUnit.MILLISECONDS);
		long otherDelay = request.getDelay(TimeUnit.MILLISECONDS);
		if (myDelay < otherDelay)
			return -1;
		if (myDelay == otherDelay)
			return 0;
		return 1;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(getExpiration() - System.currentTimeMillis(),
				TimeUnit.MILLISECONDS);
	}

	@Override
	public EventRequestId getId() {
		return m_id;
	}

	@Override
	public boolean isProcessed() {
		return m_processed.get();
	}

	private void setProcessed(boolean processed) {
		m_processed.set(processed);
	}

	@Override
	public void processError(Throwable t) {
		try {
			m_callback.handleError(getAddress(), getPort(),getEvent(), t);
		} finally {
			setProcessed(true);
		}

	}

	@Override
	public boolean processResponse(EventReply reply) {
		try {
			m_callback.handleResponse(reply.getAddr(), reply.getPort(),
					reply.getUuid());
		} finally {
			setProcessed(true);
		}
		return true;
	}

	@Override
	public EventRequest processTimeout() {
		try {
			EventRequest returnval = null;
			if (this.isExpired()) {
				m_callback.handleTimeout(getAddress(), getPort(), getEvent());
			}
			return returnval;
		} finally {
			setProcessed(true);
		}
	}

	public boolean isExpired() {
		return (System.currentTimeMillis() >= getExpiration());
	}

	public void sendCommand(UdpEventSocket socket) {
		try {
			m_expiration = System.currentTimeMillis() + m_timeout;
			socket.sendEvent(m_event, m_address, m_port);
		} catch (Throwable t) {
			m_callback.handleError(m_address, m_port, m_event, t);
		}
	}

	public InetAddress getAddress() {
		return m_address;
	}

	public void setAddress(InetAddress address) {
		m_address = address;
	}

	public int getPort() {
		return m_port;
	}

	public void setPort(int port) {
		m_port = port;
	}

	public Event getEvent() {
		return m_event;
	}

	public void setEvent(Event event) {
		m_event = event;
	}

}
