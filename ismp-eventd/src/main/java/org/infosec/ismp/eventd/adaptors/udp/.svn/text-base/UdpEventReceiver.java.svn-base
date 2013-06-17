package org.infosec.ismp.eventd.adaptors.udp;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.eventd.adaptors.EventHandler;
import org.infosec.ismp.eventd.adaptors.EventReceiver;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.util.Assert;

/**
 * This class implements the User Datagram Protocol (UDP) event receiver. When
 * the an agent sends an event via UDP/IP the receiver will process the event
 * and then add the UUIDs to the internal list. If the event is successfully
 * processed then an event-receipt is returned to the caller.
 * 
 * @author <a href="mailto:weave@oculan.com">Brian Weaver </a>
 * @author <a href="http://www.oculan.com">Oculan Corporation </a>
 * 
 */
public final class UdpEventReceiver implements EventReceiver {
	/**
	 * The default User Datagram Port for the receipt and transmission of
	 * events.
	 */
	private static final int UDP_PORT = 5817;

	/**
	 * The UDP receiver thread.
	 */
	private UdpReceiver m_receiver;

	/**
	 * The user datagram packet processor
	 */
	private UdpProcessor m_processor;

	/**
	 * The event receipt generator and sender thread.
	 */
	private UdpUuidSender m_output;

	/**
	 * The list of incomming events.
	 */
	private final List<UdpReceivedEvent> m_eventsIn;

	/**
	 * The list of outgoing event-receipts by UUID.
	 */
	private final List<UdpReceivedEvent> m_eventUuidsOut;

	/**
	 * The list of registered event handlers.
	 */
	private List<EventHandler> m_eventHandlers;

	/**
	 * The Fiber's status.
	 */
	private volatile int m_status;

	/**
	 * The UDP socket for receipt and transmission of packets from agents.
	 */
	private DatagramSocket m_dgSock;

	/**
	 * The IP address for the UDP socket to bind on.
	 */
	private String m_ipAddress;

	/**
	 * The UDP socket port binding.
	 */
	private  int m_dgPort;

	/**
	 * The log prefix
	 */
	private final String m_logPrefix;

	public UdpEventReceiver() {
		this(UDP_PORT, null);
	}

	public UdpEventReceiver(int port, String ipAddress) {
		m_dgSock = null;
		m_ipAddress = ipAddress;
		m_dgPort = port;

		m_eventsIn = new LinkedList<UdpReceivedEvent>();
		m_eventUuidsOut = new LinkedList<UdpReceivedEvent>();

		m_eventHandlers = new ArrayList<EventHandler>(3);
		m_status = START_PENDING;

		m_dgSock = null;
		m_receiver = null;
		m_processor = null;
		m_output = null;
		m_logPrefix = Eventd.LOG4J_CATEGORY;
	}

	@Override
	public synchronized void start() {
		assertNotRunning();

		m_status = STARTING;

		try {
			InetAddress address = "*".equals(m_ipAddress) ? null : InetAddress
					.getByName(m_ipAddress);
			
			m_dgSock = new DatagramSocket(m_dgPort, address);

			m_receiver = new UdpReceiver(m_dgSock, m_eventsIn);
			m_processor = new UdpProcessor(m_eventHandlers, m_eventsIn,
					m_eventUuidsOut);
			m_output = new UdpUuidSender(m_dgSock, m_eventUuidsOut,
					m_eventHandlers);

			if (m_logPrefix != null) {
				m_receiver.setLogPrefix(m_logPrefix);
				m_processor.setLogPrefix(m_logPrefix);
				m_output.setLogPrefix(m_logPrefix);
			}
		} catch (IOException e) {
			throw new java.lang.reflect.UndeclaredThrowableException(e);
		}

		Thread rThread = new Thread(m_receiver, "UDP Event Receiver["
				+ m_dgPort + "]");
		Thread pThread = new Thread(m_processor, "UDP Event Processor["
				+ m_dgPort + "]");
		Thread oThread = new Thread(m_output, "UDP UUID Sender[" + m_dgPort
				+ "]");
		try {
			rThread.start();
			pThread.start();
			oThread.start();
		} catch (RuntimeException e) {
			rThread.interrupt();
			pThread.interrupt();
			oThread.interrupt();

			m_status = STOPPED;

			throw e;
		}

		m_status = RUNNING;
	}

	@Override
	public synchronized void stop() {
		if (m_status == STOPPED) {
			return;
		}
		if (m_status == START_PENDING) {
			m_status = STOPPED;
			return;
		}

		m_status = STOP_PENDING;

		try {
			m_receiver.stop();
			m_processor.stop();
			m_output.stop();
		} catch (InterruptedException e) {
			log().warn(
					"The thread was interrupted while attempting to join sub-threads: "
							+ e, e);
		}

		m_dgSock.close();

		m_status = STOPPED;
	}

	@Override
	public String getName() {
		return "Event UDP Receiver[" + m_dgPort + "]";
	}

	@Override
	public int getStatus() {
		return m_status;
	}

	@Override
	public void init() {
	}

	@Override
	public void destroy() {
	}
	
	public void setPort(int port){
		this.m_dgPort = port;
	}

	public String getIpAddress() {
		return m_ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		assertNotRunning();

		m_ipAddress = ipAddress;
	}

	/**
	 * Adds a new event handler to receiver. When new events are received the
	 * decoded event is passed to the handler.
	 * 
	 * @param handler
	 *            A reference to an event handler
	 * 
	 */
	@Override
	public void addEventHandler(EventHandler handler) {
		synchronized (m_eventHandlers) {
			if (!m_eventHandlers.contains(handler)) {
				m_eventHandlers.add(handler);
			}
		}
	}

	/**
	 * Removes an event handler from the list of handler called when an event is
	 * received. The handler is removed based upon the method
	 * <code>equals()</code> inherieted from the <code>Object</code> class.
	 * 
	 * @param handler
	 *            A reference to the event handler.
	 * 
	 */
	@Override
	public void removeEventHandler(EventHandler handler) {
		synchronized (m_eventHandlers) {
			m_eventHandlers.remove(handler);
		}
	}

	public List<EventHandler> getEventHandlers() {
		return m_eventHandlers;
	}

	public void setEventHandlers(List<EventHandler> eventHandlers) {
		m_eventHandlers = eventHandlers;
	}

	private void assertNotRunning() {
		Assert.state(m_status == START_PENDING || m_status == STOPPED,
				"The fiber is already running and cannot be modified or started");
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
	
	
}
