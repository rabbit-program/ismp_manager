package org.infosec.ismp.eventd.adaptors.udp;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.eventd.Eventd;
import org.infosec.ismp.eventd.adaptors.EventHandler;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventReceipt;
import org.infosec.ismp.util.ThreadCategory;

/**
 * This class implements the User Datagram Protocol (UDP) event receiver. When
 * the an agent sends an event via UDP/IP the receiver will process the event
 * and then add the UUIDs to the internal list. If the event is successfully
 * processed then an event-receipt is returned to the caller.
 * 
 * 
 */
final class UdpUuidSender implements Runnable {
	/**
	 * The list of outgoing event-receipts by UUID.
	 */
	private final List<UdpReceivedEvent> m_eventUuidsOut;

	/**
	 * The stop flag
	 */
	private volatile boolean m_stop;

	/**
	 * The UDP socket for receipt and transmission of packets from agents.
	 */
	private final DatagramSocket m_dgSock;

	/**
	 * The thread context
	 */
	private Thread m_context;

	/**
	 * The list of handlers
	 */
	private final List<EventHandler> m_handlers;

	/**
	 * The log prefix
	 */
	private String m_logPrefix;

	/**
	 * Constructs a new instance of this runnable.
	 */
	UdpUuidSender(DatagramSocket sock, List<UdpReceivedEvent> uuidsOut,
			List<EventHandler> handlers) {
		m_context = null;
		m_dgSock = sock;
		m_stop = false;
		m_eventUuidsOut = uuidsOut;
		m_handlers = handlers;
		m_logPrefix = Eventd.LOG4J_CATEGORY;
	}

	/**
	 * Stops the current context.
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
	 * Returns true if the runnable is still running in its context
	 */
	boolean isAlive() {
		return (m_context == null ? false : m_context.isAlive());
	}

	@Override
	public void run() {
		// get the context
		m_context = Thread.currentThread();

		// get a logger
		ThreadCategory.setPrefix(m_logPrefix);
		boolean isTracing = log().isDebugEnabled();

		if (m_stop) {
			log().debug("Stop flag set before thread started, exiting");
			return;
		} else {
			log().debug("Thread context started");
		}

		/*
		 * This loop is labeled so that it can be
		 * exited quickly when the thread is interrupted.
		 */
		List<UdpReceivedEvent> eventHold = new ArrayList<UdpReceivedEvent>(30);
		Map<UdpReceivedEvent, EventReceipt> receipts = new HashMap<UdpReceivedEvent, EventReceipt>();

		RunLoop: while (!m_stop) {
			log().debug("Waiting on event receipts to be generated");

			synchronized (m_eventUuidsOut) {
				// wait for an event to show up. wait in 1 second intervals
				while (m_eventUuidsOut.isEmpty()) {
					try {
						// use wait instead of sleep to release the lock!
						m_eventUuidsOut.wait(1000);
					} catch (InterruptedException ie) {
						log().debug("Thread context interrupted");
						break RunLoop;
					}
				}

				eventHold.addAll(m_eventUuidsOut);
				m_eventUuidsOut.clear();
			}

			if (isTracing) {
				log().debug(
						"Received " + eventHold.size()
								+ " event receipts to process");
				log().debug("Processing receipts");
			}

			// build an event-receipt
			for (UdpReceivedEvent re : eventHold) {
				for (Event e : re.getAckedEvents()) {
					if (e.getUuid() != null) {
						EventReceipt receipt = receipts.get(re);
						if (receipt == null) {
							receipt = new EventReceipt();
							receipts.put(re, receipt);
						}
						receipt.addUuid(e.getUuid());
					}
				}
			}
			eventHold.clear();

			log().debug("Event receipts sorted, transmitting receipts");

			// turn them into XML and send it out the socket
			for (Map.Entry<UdpReceivedEvent, EventReceipt> entry : receipts
					.entrySet()) {
				UdpReceivedEvent re = entry.getKey();
				EventReceipt receipt = entry.getValue();

				StringWriter writer = new StringWriter();
				try {
					Marshaller.marshal(receipt, writer);
				} catch (ValidationException e) {
					log().warn(
							"Failed to build event receipt for agent "
									+ re.getSender().getHostAddress() + ":"
									+ re.getPort() + ": " + e, e);
				} catch (MarshalException e) {
					log().warn(
							"Failed to build event receipt for agent "
									+ re.getSender().getHostAddress() + ":"
									+ re.getPort() + ": " + e, e);
				}

				String xml = writer.getBuffer().toString();
				try {
					byte[] xml_bytes = xml.getBytes("US-ASCII");
					DatagramPacket pkt = new DatagramPacket(xml_bytes,
							xml_bytes.length, re.getSender(), re.getPort());

					if (isTracing) {
						log().debug(
								"Transmitting receipt to destination "
										+ re.getSender().getHostAddress() + ":"
										+ re.getPort());
					}

					m_dgSock.send(pkt);

					synchronized (m_handlers) {
						for (EventHandler handler : m_handlers) {
							try {
								handler.receiptSent(receipt);
							} catch (Throwable t) {
								log().warn(
										"Error processing event receipt: " + t,
										t);
							}
						}
					}

					if (isTracing) {
						log().debug("Receipt transmitted OK {");
						log().debug(xml);
						log().debug("}");
					}
				} catch (UnsupportedEncodingException e) {
					log().warn("Failed to convert XML to byte array: " + e, e);
				} catch (IOException e) {
					log().warn(
							"Failed to send packet to host"
									+ re.getSender().getHostAddress() + ":"
									+ re.getPort() + ": " + e, e);
				}
			}

			receipts.clear();
		}

		log().debug("Context finished, returning");
	}

	void setLogPrefix(String prefix) {
		m_logPrefix = prefix;
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
