package org.infosec.ismp.manager.winsensor.event;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2011-3-9 上午10:42:09
 * 
 */

public class EventSender {

	/**
	 * Event send UDP port.
	 */
	private int m_port;

	/**
	 * Event send destination Address.
	 */
	private String m_inetAddress;

	private DatagramSocket m_dataSocket;

	private DatagramPacket m_dataPacket;

	public EventSender() {

	}

	public void SendInfo(byte[] dataBytes) throws IOException {
		m_dataSocket = new DatagramSocket();
		m_dataPacket = new DatagramPacket(dataBytes, dataBytes.length,
				InetAddress.getByName(m_inetAddress), m_port);
		m_dataSocket.send(m_dataPacket);
	}

	public void send(Object obj) {

		ThreadCategory log = ThreadCategory.getInstance(getClass());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.flush();
			byte arr[] = baos.toByteArray();
			if (arr == null)
				return;
			SendInfo(arr);
			if (baos != null)
				baos.close();
			if (oos != null)
				oos.close();
		} catch (Exception e) {
			log.debug("Exception in Sending data to server.", e);
		}
	}

	public int getPort() {
		return m_port;
	}

	public String getInetAddress() {
		return m_inetAddress;
	}

	public void setPort(int port) {
		m_port = port;
	}

	public void setInetAddress(String inetAddress) {
		m_inetAddress = inetAddress;
	}
}
