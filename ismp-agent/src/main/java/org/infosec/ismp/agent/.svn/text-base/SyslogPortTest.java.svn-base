package org.infosec.ismp.agent;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SyslogPortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		DatagramSocket socket = new DatagramSocket(1033);
		DatagramPacket packet = new DatagramPacket(new byte[0xff], 0xff);
		while (true) {
			socket.receive(packet);

			byte[] data = packet.getData();

			System.out.println(new String(data));
		}

	}

}
