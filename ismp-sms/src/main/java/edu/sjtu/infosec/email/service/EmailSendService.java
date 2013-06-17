package edu.sjtu.infosec.email.service;

/**
 * 发邮件接口
 * @author Wu Guojie
 * @date 2010-8-16
 * @version 1.0
 */
public interface EmailSendService {
	/**
	 * 发邮件
	 * @param emailTo
	 * 			收件人地址
	 * @param mess
	 * 			邮件内容
	 * @param server
	 * 			邮件服务器地址
	 * @param from
	 * 			发件人地址
	 * @param password
	 * 			发件人邮箱密码
	 * @return 发送成功与否
	 * 			true	表示成功
	 * 			false	表示失败
	 */
	boolean send(String emailTo, String mess,String server,String from,String password);
}
