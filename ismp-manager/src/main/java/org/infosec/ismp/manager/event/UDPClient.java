package org.infosec.ismp.manager.event;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * UDP发送事件字符串对象
 * 
 * @author jiel
 * 
 */
public class UDPClient {
	private DatagramSocket dataSocket;
	private DatagramPacket dataPacket;

	public UDPClient() throws SocketException {
		dataSocket = new DatagramSocket();
	}

	/**
	 * UPD发送方法
	 * 
	 * @param address
	 *            UDP服务端地址
	 * @param port
	 *            UDP服务端端口
	 * @param eventString
	 *            带发送字符串
	 * @throws IOException
	 */
	public void send(InetAddress address, int port, String eventString)
			throws IOException {
		byte[] dataBytes = eventString.getBytes();
		dataPacket = new DatagramPacket(dataBytes, dataBytes.length, address,
				port);
		dataSocket.send(dataPacket);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		EventModel model = new EventModel();

		model.setEventId("111");
		model.setSrcMod("syslog");
		
		model.setEventType("ids");
		model.setSeverity("1");
		model.setTargetAddr("192.168.9.101");
		EventModel model2 = new EventModel();
		// model2.setEventId("111");
		model2.setSrcMod("syslog");
		
		model2.setEventType("ids");
		model2.setSeverity("2");
		model2.setTargetAddr("192.168.9.105");


		UDPClient udp = new UDPClient();
		InetAddress address = InetAddress.getByName("192.168.9.175");
		for (;;) {
			model.setEventTime(formatFormalDate(System.currentTimeMillis()));
			model2.setEventTime(formatFormalDate(System.currentTimeMillis()));
			EventModel[] modelArray = { model, model2 };
			// String eventString = EventModelParse.getEventModelParseString(model);
			String eventString = EventModelParse
					.getEventModelParseString(modelArray);
			
			System.out.println(eventString);
			udp.send(address, 5000, eventString);
			Thread.sleep(10000);
		}

	}

	private static final SimpleDateFormat formatterFormalDate = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	public static final String formatFormalDate(long time) {
		return formatterFormalDate.format(new java.util.Date(time));
	}
}
