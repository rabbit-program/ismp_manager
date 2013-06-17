package org.infosec.ismp.syslogd;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;

public class SyslogConnection implements Runnable {

	private final DatagramPacket m_packet;

	private final UeiList m_ueiList;

	private String m_logPrefix;

	private static final String LOG4J_CATEGORY = "ISMP.Syslogd";

	public SyslogConnection(final DatagramPacket packet, final UeiList ueiList) {
		m_packet = copyPacket(packet);

		m_ueiList = ueiList;

		m_logPrefix = LOG4J_CATEGORY;
	}

	@Override
	public void run() {
		ThreadCategory.setPrefix(m_logPrefix);
		ThreadCategory log = ThreadCategory.getInstance(getClass());

		Event re = null;
		try {
			re = ConvertToEvent.make(m_packet, m_ueiList);
		} catch (UnsupportedEncodingException e1) {
			log.debug("Failure to convert package");
		} catch (MessageDiscardedException e) {
			log.debug("Message discarded, returning without enqueueing event.");
			return;
		}

		log.debug("Sending received packet to the queue");

		SyslogHandler.queueManager.putInQueue(re);
		// delay a random period of time
		try {
			Thread.sleep((new Random()).nextInt(100));
		} catch (InterruptedException e) {
			log.debug("Syslogd: Interruption " + e);
		}

	}

	void setLogPrefix(String prefix) {
		m_logPrefix = prefix;
	}

	private DatagramPacket copyPacket(final DatagramPacket packet) {
		byte[] message = new byte[packet.getLength()];
		System.arraycopy(packet.getData(), 0, message, 0, packet.getLength());
		InetAddress addr = null;
		try {
			addr = InetAddress.getByAddress(packet.getAddress().getHostName(),
					packet.getAddress().getAddress());
			DatagramPacket retPacket = new DatagramPacket(message,
					packet.getOffset(), packet.getLength(), addr,
					packet.getPort());
			return retPacket;
		} catch (UnknownHostException e) {
			ThreadCategory.getInstance(getClass()).warn(
					"unable to clone InetAddress object for "
							+ packet.getAddress());
		}
		return null;
	}
}
// END OF CLASS
