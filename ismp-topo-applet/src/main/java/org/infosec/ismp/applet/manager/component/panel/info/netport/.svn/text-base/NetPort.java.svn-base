package org.infosec.ismp.applet.manager.component.panel.info.netport;

import twaver.Node;

/**
 * 网络接口数据类
 * 
 */
public class NetPort extends Node {
	public static final String FILEPREFIX = "fileprefix";
	public static final String SENDSPEED = "sendspeed";
	public static final String RECEIVESPEED = "receivespeed";

	public NetPort() {
		super();
	}

	public NetPort(Object id) {
		super(id);
	}

	/**
	 * 设置发送速率
	 * @param speed
	 */
	public void setSendSpeed(double speed) {
		this.putClientProperty(FILEPREFIX + SENDSPEED, new Double(speed));
	}

	/**
	 * 获取发送速率
	 * @return
	 */
	public double getSendSpeed() {
		Object usedFile = this.getClientProperty(FILEPREFIX + SENDSPEED);
		if (usedFile != null && usedFile instanceof Double) {
			return Double.parseDouble(usedFile.toString());
		}
		return 0;
	}

	/**
	 * 设置接收速率
	 * @param speed
	 */
	public void setReceiveSpeed(double speed) {
		this.putClientProperty(FILEPREFIX + RECEIVESPEED, new Double(speed));
	}

	/**
	 * 获取接收速率
	 * @return
	 */
	public double getReceiveSpeed() {
		Object usedFile = this.getClientProperty(FILEPREFIX + RECEIVESPEED);
		if (usedFile != null && usedFile instanceof Double) {
			return Double.parseDouble(usedFile.toString());
		}
		return 0;
	}
}
