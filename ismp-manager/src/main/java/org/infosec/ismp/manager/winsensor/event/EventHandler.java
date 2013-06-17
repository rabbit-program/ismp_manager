package org.infosec.ismp.manager.winsensor.event;

import java.io.IOException;
import java.net.DatagramSocket;

import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2011-3-9 上午10:19:32
 * 
 */
public final class EventHandler {
	/**
	 * The default User Datagram Port for the receipt and transmission of
	 * events.
	 */

	/**
	 * The UDP receiver thread.
	 */
	private EventReceiver m_receiver;

	/**
	 * The user datagram packet processor
	 */

	/**
	 * The Fiber's status.
	 */
	private volatile int m_status;

	/**
	 * The UDP socket for receipt and transmission of packets from agents.
	 */
	private DatagramSocket m_dgSock;

	/**
	 * The UDP socket port binding.
	 */
	private final int m_dgPort;

	/**
	 * The log prefix
	 */
	private String m_logPrefix;

	private final AlertManager m_alertManager;
	
	public EventHandler(AlertManager alertManager,int port) {
		m_dgSock = null;
		m_receiver = null;
		m_logPrefix = null;
		m_dgPort = port;
		m_alertManager = alertManager;
		m_status = START_PENDING;

	}


	public synchronized void start() {
		if (m_status != START_PENDING)
			throw new RuntimeException("The Fiber is in an incorrect state");

		m_status = STARTING;

		try {
			
			m_dgSock = new DatagramSocket(m_dgPort);

			m_receiver = new EventReceiver(m_alertManager,m_dgSock);


			if (m_logPrefix != null) {
				m_receiver.setLogPrefix(m_logPrefix);

			}
		} catch (IOException e) {
			throw new java.lang.reflect.UndeclaredThrowableException(e);
		}

		Thread rThread = new Thread(m_receiver, "winsensor event Event Receiver["
				+ m_dgPort + "]");


		try {
			rThread.start();


		} catch (RuntimeException e) {
			rThread.interrupt();


			m_status = STOPPED;
			throw e;
		}

		m_status = RUNNING;
	}

	public synchronized void stop() {
		if (m_status == STOPPED)
			return;
		if (m_status == START_PENDING) {
			m_status = STOPPED;
			return;
		}

		m_status = STOP_PENDING;

		try {
			m_receiver.stop();


		} catch (InterruptedException e) {
			ThreadCategory log = ThreadCategory.getInstance(this.getClass());
			log.warn(
					"The thread was interrupted while attempting to join sub-threads",
					e);
		}

		m_dgSock.close();

		m_status = STOPPED;
	}

	public String getName() {
		return "SyslogdHandler[" + m_dgPort + "]";
	}

	public int getStatus() {
		return m_status;
	}

	public void init() {
	}

	public void destroy() {
	}

//	public void setPort(Integer port) {
//		if (m_status == STARTING || m_status == RUNNING
//				|| m_status == STOP_PENDING)
//			throw new IllegalStateException("The process is already running");
//
//		m_dgPort = port;
//	}

	public Integer getPort() {
		return m_dgPort;
	}

	/**
	 * Adds a new event handler to receiver. When new events are received the
	 * decoded event is passed to the handler.
	 *
	 * @param handler
	 *            A reference to an event handler
	 */
	/*
	 * public void addEventHandler(Eventd handler) { synchronized
	 * (m_handlers) { if (!m_handlers.contains(handler))
	 * m_handlers.add(handler); } }
	 */

	/**
	 * Removes an event handler from the list of handler called when an event
	 * is received. The handler is removed based upon the method
	 * <code>equals()</code> inherieted from the <code>Object</code>
	 * class.
	 * <p/>
	 * A reference to the event handler.
	 */
	/*
	 * public void removeEventHandler(Eventd handler) { synchronized
	 * (m_handlers) { m_handlers.remove(handler); }
	 */
	public void setLogPrefix(String prefix) {
		m_logPrefix = prefix;
	}

	// YUCK!

	/**
	 * The string names that correspond to the states of the fiber.
	 */
	public static final String STATUS_NAMES[] = { "START_PENDING", // 0
			"STARTING", // 1
			"RUNNING", // 2
			"STOP_PENDING", // 3
			"STOPPED", // 4
			"PAUSE_PENDING", // 5
			"PAUSED", // 6
			"RESUME_PENDING" // 7
	};

	/**
	 * This is the initial <code>Fiber</code> state. When the
	 * <code>Fiber</code> begins it startup process it will transition to
	 * the <code>STARTING</code> state. A <code>Fiber</code> in a start
	 * pending state has not begun any of the initilization process.
	 */
	public static final int START_PENDING = 0;

	/**
	 * This state is used to define when a <code>Fiber</code> has begun the
	 * initilization process. Once the initilization process is completed the
	 * <code>Fiber</code> will transition to a <code>RUNNING</code>
	 * status.
	 */
	public static final int STARTING = 1;

	/**
	 * This state is used to define the normal runtime condition of a
	 * <code>Fiber</code>. When a <code>Fiber</code> is in this state
	 * then it is processing normally.
	 */
	public static final int RUNNING = 2;

	/**
	 * This state is used to denote when the <code>Fiber</code> is
	 * terminating processing. This state is always followed by the state
	 * <code>ST0PPED</code>.
	 */
	public static final int STOP_PENDING = 3;

	/**
	 * This state represents the final resting state of a <code>Fiber</code>.
	 * Depending on the implementation it may be possible to resurect the
	 * <code>Fiber</code> from this state.
	 */
	public static final int STOPPED = 4;

	// private static SyslogdConfig m_syslogdConfig;

}

