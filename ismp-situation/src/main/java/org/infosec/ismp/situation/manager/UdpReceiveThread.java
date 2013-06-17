package org.infosec.ismp.situation.manager;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;

import org.infosec.ismp.situation.model.Event;
import org.infosec.ismp.situation.util.ConstantSource;
import org.infosec.ismp.situation.util.ToolUtil;
/**
 * 用来接收事件报文的线程类。
 * @author cc
 * 2010-10-11 15:30:27
 */
public class UdpReceiveThread extends Thread {
	
	private DatagramSocket dataSocket;
	
	private DatagramPacket dataPacket;
	
	private byte receiveByte[];///缓存
	
	private BlockingQueue<Event> queue;///线程安全的。
	
	private String receiveStr;///数据报接收字符串
	
	private String[] receiveStrArray;///数据报接收字符串数组
	
	public UdpReceiveThread(BlockingQueue<Event> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			dataSocket = new DatagramSocket(ConstantSource.PORT);
			receiveByte = new byte[1024];
			dataPacket = new DatagramPacket(receiveByte,receiveByte.length);
			while (true) {
				dataSocket.receive(dataPacket);// 接收数据报(阻塞式)
				receiveStr = new String(dataPacket.getData());
				System.out.println(receiveStr.trim());
				receiveStrArray = receiveStr.trim().split(";");
				if(receiveStrArray.length < 1){
					System.out.println("数据报里没有数据");
				}else{
					for (int i = 0; i < receiveStrArray.length; i++) {
						String tempString = receiveStrArray[i];
						String[] tempStringArray = tempString.split(",");
						Event event = new Event();
//						event.setId(new Integer(tempStringArray[0]));///id
						event.setTime(ToolUtil.string2Timestamp(tempStringArray[1]));///时间
						
						if("ids".equals(tempStringArray[2])){
							event.setType(1);///事件类型:1为攻击事件
						}else if("antivirus".equals(tempStringArray[2])){
							event.setType(2);///事件类型:2为病毒事件
						}else if("firewall".equals(tempStringArray[2])){
							event.setType(3);///事件类型:3为非法连接事件
						}
//						event.setType(new Integer(tempStringArray[2]));///事件类型
						event.setPriority(new Integer(tempStringArray[3]));///事件优先级
						event.setDestAddress(tempStringArray[4].trim());///ip地址 注意数据报解析之后的空格。
						event.setSrcmod(tempStringArray[0]);///事件的产生模块
//						System.out.println("放入一个事件！");
						queue.put(event);///put()方法是线程安全的，如果该队列已满，则等待可用的空间(先入先出)。
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
