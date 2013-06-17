package org.infosec.ismp.eventd.adaptors.udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.List;

import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 
 * 用udp方式发来event的接收器。
 * 
 */
class UdpReceiver implements Runnable {
	/**
	 * The list of incomming events.
	 */
	private final List<UdpReceivedEvent> m_eventsIn;

	/**
	 * The Fiber's status.
	 */
	private volatile boolean m_stop;

	/**
	 * The UDP socket for receipt and transmission of packets from agents.
	 */
	private final DatagramSocket m_dgSock;

	/**
	 * The context thread
	 */
	private Thread m_context;

	/**
	 * The log prefix
	 */
	private String m_logPrefix;

	/**
	 * construct a new receiver
	 */
	UdpReceiver(DatagramSocket sock, List<UdpReceivedEvent> xchange) {
		m_eventsIn = xchange;
		m_stop = false;
		m_dgSock = sock;
		m_logPrefix = Eventd.LOG4J_CATEGORY;
	}

	/**
	 * stop the current receiver
	 */
	void stop() throws InterruptedException {
		m_stop = true;
		if (m_context != null) {
			if (log().isDebugEnabled()) {
				log().debug(
						"Stopping and joining thread context "
								+ m_context.getName());
			}

			m_context.interrupt();
			m_context.join();

			log().debug("Thread context stopped and joined");
		}
	}

	/**
	 * Return true if this receiver is alive
	 */
	boolean isAlive() {
		return (m_context == null ? false : m_context.isAlive());
	}

	/**
	 * The execution context.
	 */
	@Override
	public void run() {
		// get the context
		m_context = Thread.currentThread();

		// Get a log instance
		ThreadCategory.setPrefix(m_logPrefix);

		if (m_stop) {
			log().debug("Stop flag set before thread started, exiting");
			return;
		} else {
			log().debug("Thread context started");
		}

		// allocate a buffer
		final int length = 0xffff;
		final byte[] buffer = new byte[length];
		DatagramPacket pkt = new DatagramPacket(buffer, length);

		// Set an SO timout to make sure we don't block forever if a socket is
		// closed.
		try {
			log().debug("Setting socket timeout to 500ms");

			m_dgSock.setSoTimeout(500);
		} catch (SocketException e) {
			log().warn(
					"An I/O error occured while trying to set the socket timeout: "
							+ e, e);
		}

		// Increase the receive buffer for the socket
		try {
			if (log().isDebugEnabled()) {
				log().debug("Setting receive buffer size to " + length);
			}

			m_dgSock.setReceiveBufferSize(length);
		} catch (SocketException e) {
			log().info(
					"Failed to set the receive buffer to " + length + ": " + e,
					e);
		}

		// set to avoid numerious tracing message
		boolean ioInterrupted = false;

		// now start processing incomming request
		while (!m_stop) {
			if (m_context.isInterrupted()) {
				log().debug("Thread context interrupted");

				break;
			}

			try {
				if (log().isDebugEnabled() && !ioInterrupted) {
					log().debug("Wating on a datagram to arrive");
				}

				m_dgSock.receive(pkt);
				ioInterrupted = false; // reset the flag
			} catch (InterruptedIOException e) {
				ioInterrupted = true;
				continue;
			} catch (IOException e) {
				log().error(
						"An I/O exception occured on the datagram receipt port, exiting: "
								+ e, e);
				break;
			}

			try {
				log().debug("Sending received packet to processor");
//                 System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				UdpReceivedEvent re = UdpReceivedEvent.make(pkt);
				synchronized (m_eventsIn) {
					m_eventsIn.add(re);
					m_eventsIn.notify();
				}
			} catch (UnsupportedEncodingException e) {
				log().warn(
						"Failed to convert received XML event, discarding: "
								+ e, e);
			}

			pkt = new DatagramPacket(buffer, length);

		}

		log().debug("Thread context exiting");

	}

	void setLogPrefix(String prefix) {
		m_logPrefix = prefix;
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
