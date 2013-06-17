package org.infosec.ismp.applet.manager.component.panel.info.file;

import twaver.Node;

/**
 * 文件系统数据类
 */
public class FileElement extends Node {
	public static final String FILEPREFIX = "fileprefix";
	public static final String FILEUSED = "fileused";
	public static final String FILEUNUSED = "fileunused";

	public FileElement() {
		super();
	}

	public FileElement(Object id) {
		super(id);
	}

	public FileElement(double used, double unUsed) {
		super();
		setUsedFile(used);
		setUnUsedFile(unUsed);
	}

	/**
	 * 设置已用硬盘容量
	 * @param number
	 */
	public void setUsedFile(double number) {
		this.putClientProperty(FILEPREFIX + FILEUSED, new Double(number));
	}

	/**
	 * 获取已用硬盘容量
	 * 
	 * @return
	 */
	public double getUsedFile() {
		Object usedFile = this.getClientProperty(FILEPREFIX + FILEUSED);
		if (usedFile != null && usedFile instanceof Double) {
			return Double.parseDouble(usedFile.toString());
		}
		return 0;
	}

	/**
	 * 设置未使用硬盘容量
	 * @param number
	 */
	public void setUnUsedFile(double number) {
		this.putClientProperty(FILEPREFIX + FILEUNUSED, new Double(number));
	}

	/**
	 * 获取未使用硬盘容量信息
	 * @return
	 */
	public double getUnUsedFile() {
		Object usedFile = this.getClientProperty(FILEPREFIX + FILEUNUSED);
		if (usedFile != null && usedFile instanceof Double) {
			return Double.parseDouble(usedFile.toString());
		}
		return 0;
	}
}
