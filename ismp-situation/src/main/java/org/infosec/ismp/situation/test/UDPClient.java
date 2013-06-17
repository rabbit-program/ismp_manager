package org.infosec.ismp.situation.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.infosec.ismp.situation.util.ToolUtil;

public class UDPClient {
	private static final int PORT = 5000;
	
	private DatagramSocket dataSocket;
	
	private DatagramPacket dataPacket;
	
	private byte sendDataByte[];
	
	private String sendStr;
	
	private StringBuffer sendStrBuffer;
	
	private Timestamp timestamp;
	
	private int i = 0;

	public UDPClient() {
		Init();
	}
	
	public void Init() {
		try {
			dataSocket = new DatagramSocket(PORT+1);
			sendDataByte = new byte[1024];
//			sendStr = "UDP方式发送数据";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			Date date = simpleDateFormat.parse("2011/03/14 14:47:23");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.SECOND, 1);
			timestamp = new Timestamp(calendar.getTimeInMillis());
//			System.out.println(timestamp);
			
			while(true){
//				sendStr = "111、syslog、2010-10-10 12:30:23、2、3、127.0.0.1&111、syslog、2010-10-10 12:30:23、2、3、127.0.0.1&111、syslog、2010-10-10 12:30:23、2、3、127.0.0.1";
				////模拟事件发送，做测试
				sendStrBuffer = new StringBuffer();
				sendStrBuffer.append("syslog,");
				timestamp = ToolUtil.afterTimestamp(timestamp, Calendar.SECOND, 1);///加一秒
				sendStrBuffer.append(ToolUtil.timestamp2string(timestamp));
				sendStrBuffer.append(",3,2,192.168.9.101;");
				sendStrBuffer.append("syslog,");
				timestamp = ToolUtil.afterTimestamp(timestamp, Calendar.SECOND, 1);///加一秒
				sendStrBuffer.append(ToolUtil.timestamp2string(timestamp));
				sendStrBuffer.append(",3,2,192.168.9.102;");
				sendStrBuffer.append("syslog,");
				timestamp = ToolUtil.afterTimestamp(timestamp, Calendar.SECOND, 1);///加一秒
				sendStrBuffer.append(ToolUtil.timestamp2string(timestamp));
				sendStrBuffer.append(",3,2,192.168.9.103");
				
//				System.out.println(sendStrBuffer.toString());
				
				sendDataByte = sendStrBuffer.toString().getBytes();
				
				dataPacket = new DatagramPacket(sendDataByte, sendDataByte.length,
						InetAddress.getByName("localhost"), PORT);
				dataSocket.send(dataPacket);///模拟事件报文的发送。
//				System.out.println("发送一次");
				Thread.sleep(1000);///每1秒钟发一次
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public static void main(String args[]) {
		new UDPClient();
	 }
}
