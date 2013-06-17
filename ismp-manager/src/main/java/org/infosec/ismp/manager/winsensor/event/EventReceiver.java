package org.infosec.ismp.manager.winsensor.event;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2011-3-8 上午10:17:17
 * 
 */
public class EventReceiver implements Runnable {

	private static final int SOCKET_TIMEOUT = 500;

	private static final String LOG4J_CATEGORY = "ISMP.Syslogd";

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

	private AlertManager m_alertManager;

	/**
	 * construct a new receiver
	 * 
	 * @param sock
	 * @param matchPattern
	 * @param hostGroup
	 * @param messageGroup
	 */
	EventReceiver(AlertManager alertManager, DatagramSocket sock) {
		m_stop = false;
		m_dgSock = sock;
		m_logPrefix = LOG4J_CATEGORY;
		m_alertManager = alertManager;

	}

	/*
	 * stop the current receiver
	 * 
	 * @throws InterruptedException
	 */
	void stop() throws InterruptedException {
		m_stop = true;
		if (m_context != null) {
			ThreadCategory log = ThreadCategory.getInstance(getClass());
			log.debug("Stopping and joining thread context "
					+ m_context.getName());
			m_context.interrupt();
			m_context.join();
			log.debug("Thread context stopped and joined");
		}
	}

	/**
	 * Return true if this receiver is alive
	 * 
	 * @return boolean
	 */
	boolean isAlive() {
		return (m_context != null && m_context.isAlive());
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
		ThreadCategory log = ThreadCategory.getInstance(getClass());

		if (m_stop) {
			log.debug("Stop flag set before thread started, exiting");
			return;
		} else
			log.debug("Thread context started");

		// allocate a buffer
		final int length = 0xffff;
		final byte[] buffer = new byte[length];

		// set an SO timeout to make sure we don't block forever
		// if a socket is closed.
		try {
			log.debug("Setting socket timeout to " + SOCKET_TIMEOUT + "ms");
			m_dgSock.setSoTimeout(SOCKET_TIMEOUT);
		} catch (SocketException e) {
			log
					.warn(
							"An I/O error occured while trying to set the socket timeout",
							e);
		}

		// Increase the receive buffer for the socket
		try {
			log.debug("Setting receive buffer size to " + length);
			m_dgSock.setReceiveBufferSize(length);
		} catch (SocketException e) {
			log.info("Failed to set the receive buffer to " + length, e);
		}
		// set to avoid numerous tracing message
		boolean ioInterrupted = false;
		// now start processing incoming requests
		while (!m_stop) {
			if (m_context.isInterrupted()) {
				log.debug("Thread context interrupted");
				break;
			}

			try {
				if (!ioInterrupted) {
					log.debug("Wating on a datagram to arrive");
				}

				DatagramPacket pkt = new DatagramPacket(buffer, length);
				m_dgSock.receive(pkt);

				// SyslogConnection *Must* copy packet data and InetAddress as
				// DatagramPacket is a mutable type
				Thread worker = new Thread(new EventConnection(m_alertManager,
						pkt));
				worker.start();
				ioInterrupted = false; // reset the flag
			} catch (SocketTimeoutException e) {
				ioInterrupted = true;
				continue;
			} catch (InterruptedIOException e) {
				ioInterrupted = true;
				continue;
			} catch (IOException e) {
				log
						.error(
								"An I/O exception occured on the datagram receipt port, exiting",
								e);
				break;
			}

		} // end while status OK

		log.debug("Thread context exiting");

	}

	protected void setLogPrefix(String prefix) {
		m_logPrefix = prefix;
	}

}
