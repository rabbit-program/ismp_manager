package edu.sjtu.infosec.sms.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 发短消息接口
 * @author Wu Guojie
 * @date 2010-8-16
 * @version 1.0
 */
public interface SmsService {
	/**
	 * 手机群发短消息
	 * @param mobileList
	 * 			手机号List
	 * @param mess
	 * 			短信内容
	 * @param socket
	 * 			手机服务socket地址
	 * @param prot
	 * 			手机服务socket端口
	 */
	void sendMessToMuch(String[] mobileList, String mess, String socketAddr, Integer prot) throws Exception;
	/**
	 * 手机单点发送短消息
	 * @param mobile
	 * 			手机号
	 * @param mess
	 * 			短信内容
	 * @param socket
	 * 			手机服务socket地址
	 * @param prot
	 * 			手机服务socket端口
	 */
	void sendMessToOne(String mobile, String mess, String socketAddr, Integer prot) throws Exception;
	/**
	 * 手机单点发送短消息，并返回发送状态
	 * @param mobile
	 * 			手机号
	 * @param mess
	 * 			短信内容
	 * @param socket
	 * 			手机服务socket地址
	 * @param prot
	 * 			手机服务socket端口
	 * @return 发送状态
	 * 			0				表示失败
	 * 			1或其它值		表示成功
	 */
	String sendMessToOneState(String mobile, String mess, String socketAddr, Integer prot) throws Exception;
	/**
	 * 关闭socket连接
	 * @param outs
	 * 			输出流
	 * @param ins
	 * 			输入流
	 * @param socket
	 * 			短信连接socket
	 */
	void closeStream(OutputStream outs, InputStream ins, Socket socket) throws Exception;
}
