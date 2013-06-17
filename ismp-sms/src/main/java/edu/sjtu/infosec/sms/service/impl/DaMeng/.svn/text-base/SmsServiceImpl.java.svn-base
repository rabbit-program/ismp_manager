package edu.sjtu.infosec.sms.service.impl.DaMeng;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import edu.sjtu.infosec.sms.service.SmsService;

public class SmsServiceImpl implements SmsService {
	public void sendMessToMuch(String[] mobileList, String mess, String socketAddr,
			Integer prot) throws Exception {
	    DataOutputStream outs = null;
	    DataInputStream ins = null;
	    Socket socket = null;
	    if(mess==null || mess.equals("")){
	    	return;
	    }
	    String sended = (mess.length() > 70) ? mess.substring(0, 69) : mess;
	    // 待提供接口
	    StringBuffer context = new StringBuffer("SENDMESSAGE||" + mess + "||");

	    for (String mobile : mobileList) {
	    	context = context.append(mobile + ";");
	    }
	    try {
	    	socket = new Socket(InetAddress.getByName(socketAddr), prot);
	    	// 获得本次socket输出流
	    	outs = new DataOutputStream(socket.getOutputStream());
	    	// 获得本次socket输入流
	    	ins = new DataInputStream(socket.getInputStream());
	    	// 将需要发送的数据写到 outs 输出流中
	    	outs.write(context.toString().getBytes("GBK"));
	    	outs.flush();
	    	// 定义一个 1024字节的 缓冲区
	    	byte buff[] = new byte[1024];
	    	// 读取服务器返回状态
	    	ins.read(buff);
	    	String stats = new String(buff).trim();
	    	String str = stats.substring(stats.lastIndexOf("|") + 1, stats.length());
	    	
	    	char cha[] = str.toCharArray();
	    	for (int i = 0; i < cha.length; i++) {
	    		if (cha[i] == '0') {
	    			System.out.println("手机号：" + mobileList[i] + "发送失败");
	    		}
	    	}
	    }catch(IOException e){
//	    	e.printStackTrace();
	    	System.out.println("短信网关连接失败");
	    }finally{
	    	closeStream(outs, ins, socket);
	    }
	}

	public void sendMessToOne(String mobile, String mess, String socketAddr,
			Integer prot) throws Exception {
	    DataOutputStream outs = null;
	    DataInputStream ins = null;
	    Socket socket = null;
	    if(mess == null || mess.equals("")){
	    	return;
	    }
	    String sended = (mess.length() > 70) ? mess.substring(0, 69) : mess;

	    // 拼接发送内容跟请求头部
	    String context = "SENDMESSAGE||" + mess + "||" + mobile + ";";
//	    System.out.println(context);
	    try {
	    	socket = new Socket(InetAddress.getByName(socketAddr), prot);
	    	outs = new DataOutputStream(socket.getOutputStream());
	    	// 写完后获得服务器状态
	    	ins = new DataInputStream(socket.getInputStream());
	    	outs.write(context.getBytes("GBK"));
	    	outs.flush();
	    	// 定义一个 1024字节的 缓冲区
	    	byte buff[] = new byte[1024];
	    	// 读取服务器返回状态
	    	ins.read(buff);
	    	String stats = new String(buff).trim();
	    	// 将服务器返回状态转换成String类型
//	    	System.out.println(stats.trim() + ":服务器返回状态");
//	    	System.out.print("向手机  " + socketAddr + " 发送消息\"" + sended + "\"");
	    }catch(IOException e){
//	    	e.printStackTrace();
	    	System.out.println("短信网关连接失败");
	    }finally{
	      closeStream(outs, ins, socket);
	    }
	}

	public String sendMessToOneState(String mobile, String mess, String socketAddr,
			Integer prot) throws Exception {
		String sendState = "1";

	    DataOutputStream outs = null;
	    DataInputStream ins = null;
	    Socket socket = null;
	    if(mess == null || mess.equals("")){
	    	sendState = "0";
	    	return sendState;
	    }
	    String sended = (mess.length() > 70) ? mess.substring(0, 69) : mess;

	    // 拼接发送内容跟请求头部
	    String context = "SENDMESSAGE||" + mess + "||" + mobile + ";";
//	    System.out.println(context);
	    try {
	    	socket = new Socket(InetAddress.getByName(socketAddr), prot);
	    	outs = new DataOutputStream(socket.getOutputStream());
	    	// 写完后获得服务器状态
	    	ins = new DataInputStream(socket.getInputStream());
	    	outs.write(context.getBytes("GBK"));
	    	outs.flush();
	    	// 定义一个 1024字节的 缓冲区
	    	byte buff[] = new byte[1024];
	    	// 读取服务器返回状态
	    	ins.read(buff);
	    	String stats = new String(buff).trim();
	    	// 将服务器返回状态转换成String类型
//	    	System.out.println(stats.trim() + ":服务器返回状态");
//	    	System.out.print("向手机 " + mobile + "发送消息\"" + sended + "\"");
	    	sendState = stats.trim().substring(stats.trim().length()-1);
	    	return sendState;
	    }catch(IOException e){
//	    	e.printStackTrace();
	    	System.out.println("短信网关连接失败");
	    	sendState = "2";
	    	return sendState;
	    }finally{
	      closeStream(outs, ins, socket);
	    }
	}

	public void closeStream(OutputStream outs, InputStream ins, Socket socket)
			throws Exception {
	    try {
	    	if(ins != null){
	    		ins.close();
	    	}
	    	if(outs != null){
	    		outs.close();
	    	}
	    	if(socket != null){
	    		socket.close();
	    	}
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
	}

//	public static void main(String[] args) {
//		SmsService ss = new SmsServiceImpl();
//		String mobile = "18918397176";
//		String[] mobileList = {"18918397176", "18918397181"};
//		String mess = "中文test";
//		String socketAddr = "172.16.1.2";
//		Integer prot = 9110;
//	    try {
//			ss.sendMessToOne(mobile, mess, socketAddr, prot);
//			String state = ss.sendMessToOneState(mobile, mess, socketAddr, prot);
//			System.out.println("发送状态：" + state);
//			ss.sendMessToMuch(mobileList, mess, socketAddr, prot);
//		} catch (Exception e) {
//			System.out.println("发送出错！");
//			e.printStackTrace();
//		}
//	}
}
