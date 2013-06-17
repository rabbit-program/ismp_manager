package edu.sjtu.infosec.email.service.impl;

import java.util.Date;

import org.apache.commons.mail.SimpleEmail;

import edu.sjtu.infosec.email.service.EmailSendService;

public class EmailSendServiceImpl implements EmailSendService {
	public boolean send(String emailTo, String mess, String server,
			String from, String password) {
		try {
	    	SimpleEmail email = new SimpleEmail();
			email.setTLS(true);
			email.setHostName(server);//邮件服务器
			email.setAuthentication(from, password); //用户名和密码验证
			email.addTo(emailTo);//接收方
			email.setFrom(from);//发送方
			email.setCharset("utf-8");//设置为UTF-8编码 支持中文
			
			Date de=new Date();
			email.setSubject(de.toLocaleString() + "：安管平台消息");//标题
			email.setMsg(de.toLocaleString() +"：" + mess);//内容
			
			email.send();
			return true;
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("邮件发送失败！");
			return false;
		}
	}

	public static void main(String[] args) {
		String mess = "浦东安管平台：" 
						+ "\n中心端服务器中上传了一个软件 "
						+ "\n\t软件名称:mail.exe"
						+ "\n\t软件大小:123456字节";
		String server = "smtp.sina.com.cn";
		String emailTo = "wuguojie@pengyue.com.cn";
		String from = "sxq236@sina.com";
		String password = "123456";
		EmailSendService ess = new EmailSendServiceImpl();
		boolean esss = ess.send(emailTo, mess, server, from, password);
		System.out.println(esss);
	}
}
