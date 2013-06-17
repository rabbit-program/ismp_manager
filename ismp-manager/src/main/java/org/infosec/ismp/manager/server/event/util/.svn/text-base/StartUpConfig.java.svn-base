package org.infosec.ismp.manager.server.event.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Scanner;

public class StartUpConfig {

	/**
	 * 数据传输给1级平台使用端口
	 */
	private String dataPort;

	/**
	 * 1级平台IP地址
	 */
	private String centerIp;

	/**
	 * 1级平台jetty使用的端口
	 */
	private String jettyPort;

	/**
	 * 1级平台中该２级平台的注册号
	 */
	private String authorizationCode;

	public void startConfig() {
		String filePath = getClass().getResource("/").getPath()+"config.properties";   
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
			centerIp = properties.getProperty("center.ip");
			while (centerIp == null || centerIp.trim().length() == 0) {
				Scanner scanne = new Scanner(System.in);
				System.out.print("请输入中心平台IP地址:");
				centerIp = scanne.next().trim();
				System.out.println("'Y'确认，'N'重新输入:");
				Scanner sc = new Scanner(System.in);
				String str = sc.next().trim();
				if (str.toUpperCase().equals("Y")) {
					ConfigContent.setCenterIp(centerIp);
					properties.setProperty("center.ip", centerIp);
					properties.setProperty("center.server.ip.address", centerIp);
				} else {
					centerIp = null;
				}
			}
			dataPort = properties.getProperty("data.comm.port");
			while (dataPort == null || dataPort.trim().length() == 0) {
				Scanner scanne = new Scanner(System.in);
				System.out.print("请输入与中心平台通信的端口号:");
				dataPort = scanne.next();
				System.out.println("'Y'确认，'N'重新输入:");
				Scanner sc = new Scanner(System.in);
				String str = sc.next().trim();
				if (str.equals("Y")||str.equals("y")) {
					ConfigContent.setDataPort(dataPort.trim());
					properties.setProperty("data.comm.port", dataPort);
				} else {
					dataPort = null;
				}
			}
			jettyPort = properties.getProperty("center.jetty.port");
			while (jettyPort == null || jettyPort.trim().length() == 0) {
				Scanner scanne = new Scanner(System.in);
				System.out.print("请输入与中心平台通信的jetty端口号:");
				jettyPort = scanne.next();
				System.out.println("'Y'确认，'N'重新输入:");
				Scanner sc = new Scanner(System.in);
				String str = sc.next().trim();
				if (str.equals("Y")||str.equals("y")) {
					ConfigContent.setJettyPort(jettyPort);
					properties.setProperty("center.jetty.port", jettyPort);
				} else {
					jettyPort = null;
				}
			}
			authorizationCode = properties.getProperty("authorizationCode");
			while (authorizationCode == null
					|| authorizationCode.trim().length() == 0) {
				Scanner scanne = new Scanner(System.in);
				System.out.print("请输入本管理平台在中心平台的注册号:");
				authorizationCode = scanne.next();
				System.out.println("'Y'确认，'N'重新输入:");
				Scanner sc = new Scanner(System.in);
				String str = sc.next().trim();
				if (str.equals("Y")||str.equals("y")) {
					ConfigContent.setAuthorizationCode(authorizationCode);
					properties.setProperty("authorizationCode",
							authorizationCode);
					
				} else {
					authorizationCode = null;
				}
			}
			
			ConfigContent.setCenterServerIpAddress(properties.getProperty("center.server.ip.address"));
			ConfigContent.setCenterSocktPort(properties.getProperty("center.software.server.sockt.port"));
			ConfigContent.setCenterIp(centerIp);
			ConfigContent.setDataPort(dataPort);
			ConfigContent.setJettyPort(jettyPort);
			ConfigContent.setAuthorizationCode(authorizationCode);
			ConfigContent.setEchoService(properties.getProperty("echoService"));
			ConfigContent.setWebPrefix(properties.getProperty("web.prefix"));
			ConfigContent.setJettyServerPort(properties.getProperty("jetty.server.port"));
			
			//设置事件处理时间
			ConfigContent.setInsertTime(Integer.valueOf(properties.getProperty("insertTime")));
			ConfigContent.setFaciListenerTime(Integer.valueOf(properties.getProperty("faciListenerTime")));
			ConfigContent.setAggreListenerTime(Integer.valueOf(properties.getProperty("aggreListenerTime")));
			
			//设置告警信息所要发送到的邮件信息
			ConfigContent.setMailAddress(properties.getProperty("mail.address"));
			ConfigContent.setMailFrom(properties.getProperty("mail.from"));
			ConfigContent.setMailPassword(properties.getProperty("mail.password"));
			
			//设置告警信息所要发送到的短信平台信息
			ConfigContent.setMmsIp(properties.getProperty("socket.address"));
			ConfigContent.setMmsPort(Integer.valueOf(properties.getProperty("socket.port")));
			
			
			//Topo用中心url
			ConfigContent.setCenterServer(properties.getProperty("center.server"));
			
			OutputStream fos = null;
			try {
				fos = new FileOutputStream(filePath);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			properties.store(fos, "Update");
			fos.close();  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
