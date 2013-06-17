package org.infosec.ismp.applet.manager.component.panel.progress;

import twaver.Node;

/**
 * 进程信息
 * 默认提供了
 * 进程名称 进程描述信息 进程运行路径 进程分配的内存<Long> 进程消耗CPU时间<Long>
 * 再有其它的，可以通过clientproperty进行扩展
 */
public class Process extends Node {

	public static String CLIENTKEY = "process:";
	public static final String PROCESSNAME = "processname";
	public static final String PROCESSDESCIPTION = "processdesciption";
	public static final String PROCESSRUNPATH = "processrunpath";
	public static final String PROCESSMEMORY = "processmemory";
	public static final String PROCESSCPUTIME = "processcputime";

	public Process() {
		super();
	}

	public Process(Object id) {
		super(id);
	}

	public String getProcessName() {
		Object object = this.getClientProperty(CLIENTKEY + PROCESSNAME);
		if (object != null) {
			return object.toString();
		}
		return null;
	}

	public void setProcessName(String name) {
		this.putClientProperty(CLIENTKEY + PROCESSNAME, name);
	}

	public String getProcessDesciption() {
		Object object = this.getClientProperty(CLIENTKEY + PROCESSDESCIPTION);
		if (object != null) {
			return object.toString();
		}
		return null;
	}

	public void setProcessDesciption(String processDesciption) {
		this.putClientProperty(CLIENTKEY + PROCESSDESCIPTION, processDesciption);
	}

	public String getProcessRunPath() {
		Object object = this.getClientProperty(CLIENTKEY + PROCESSRUNPATH);
		if (object != null) {
			return object.toString();
		}
		return null;
	}

	public void setProcessRunPath(String processRunPath) {
		this.putClientProperty(CLIENTKEY + PROCESSRUNPATH, processRunPath);
	}

	public long getProcessMemory() {
		Object object = this.getClientProperty(CLIENTKEY + PROCESSMEMORY);
		if (object != null) {
			return Long.parseLong(object.toString());
		}
		return 0;
	}

	public void setProcessMemory(long processMemory) {
		this.putClientProperty(CLIENTKEY + PROCESSMEMORY, new Long(processMemory));
	}

	public long getProcessCpuTime() {
		Object object = this.getClientProperty(CLIENTKEY + PROCESSCPUTIME);
		if (object != null) {
			return Long.parseLong(object.toString());
		}
		return 0;
	}

	public void setProcessCpuTime(long processCpuTime) {
		this.putClientProperty(CLIENTKEY + PROCESSCPUTIME, new Long(processCpuTime));
	}

}
