package org.infosec.ismp.manager.winsensor.event;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2011-3-8 上午10:34:39
 * 
 */
public class EventConnection implements Runnable {

	private final DatagramPacket m_packet;

	private String m_logPrefix;

	private AlertManager m_alertManager;

	public EventConnection(AlertManager alertManager,
			final DatagramPacket packet) {
		m_packet = copyPacket(packet);
		m_alertManager = alertManager;
	}

	@Override
	public void run() {
		ThreadCategory.setPrefix(m_logPrefix);
		ThreadCategory log = ThreadCategory.getInstance(getClass());

		AlertInfoBO alertInfoBO = make(m_packet);

		m_alertManager.addAlertInfo(alertInfoBO);
		if (alertInfoBO != null)
			// delay a random period of time
			try {
				Thread.sleep((new Random()).nextInt(100));
			} catch (InterruptedException e) {
				log.debug("winsensor: Interruption " + e);
			}

	}

	private AlertInfoBO make(final DatagramPacket packet) {
		try {
			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(packet.getData()));
			AlertInfoBO alertInfoBO = (AlertInfoBO) in.readObject();
			return alertInfoBO;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

	private DatagramPacket copyPacket(final DatagramPacket packet) {
		byte[] message = new byte[packet.getLength()];
		System.arraycopy(packet.getData(), 0, message, 0, packet.getLength());
		InetAddress addr = null;
		try {
			addr = InetAddress.getByAddress(packet.getAddress().getHostName(),
					packet.getAddress().getAddress());
			System.out.println(addr.getHostAddress());
			DatagramPacket retPacket = new DatagramPacket(message, packet
					.getOffset(), packet.getLength(), addr, packet.getPort());
			return retPacket;
		} catch (UnknownHostException e) {
			ThreadCategory.getInstance(getClass()).warn(
					"unable to clone InetAddress object for "
							+ packet.getAddress());
		}
		return null;
	}
}
