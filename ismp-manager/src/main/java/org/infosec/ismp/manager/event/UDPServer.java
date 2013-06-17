package org.infosec.ismp.manager.event;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 模拟UPD服务端
 * @author jiel
 *
 */
public class UDPServer {
	private static final int PORT = 5000;    
	private DatagramSocket dataSocket;    
	private DatagramPacket dataPacket;    
	private byte receiveByte[];    
	private String receiveStr;    
	public UDPServer() {        
		Init();    		    
	}
	public void Init() {        
		try {            
			dataSocket = new DatagramSocket(PORT);            
			receiveByte = new byte[1024];            
			dataPacket = new DatagramPacket(receiveByte, receiveByte.length);            
			receiveStr = "";            
			int i = 0;            
			while (i == 0)// 无数据，则循环           	
				{                
				dataSocket.receive(dataPacket);                
				i = dataPacket.getLength();  
				// 接收数据               
				if (i > 0) {                    
					// 指定接收到数据的长度,可使接收数据正常显示,开始时很容易忽略这一点                    
					receiveStr = new String(receiveByte, 0, dataPacket.getLength());                    
					System.out.println(receiveStr);                    
					i = 0;// 循环接收              
					}            
				}        
			} catch (Exception e) {
				e.printStackTrace();  
			}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new UDPServer();

	}

}
