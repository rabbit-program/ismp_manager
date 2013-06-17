package org.infosec.ismp.syslogd;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MockUdpReceiver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		DatagramSocket socket = new DatagramSocket(5819,InetAddress.getByName("192.168.9.58"));
		byte[] data = new byte[1024];
		
		DatagramPacket pkt = new DatagramPacket(data,1024);
		
		socket.receive(pkt);
		
		System.out.println(new String(pkt.getData(),0,pkt.getLength()));
	}

}
