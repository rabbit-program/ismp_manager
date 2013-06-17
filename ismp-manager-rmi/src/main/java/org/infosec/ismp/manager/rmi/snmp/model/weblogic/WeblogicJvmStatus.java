package org.infosec.ismp.manager.rmi.snmp.model.weblogic;

import java.io.Serializable;


/**
 * @author Rocky
 * @version create time：Sep 9, 2010 5:12:05 PM
 * 
 */
public class WeblogicJvmStatus implements Serializable{

	private static final long serialVersionUID = -7688376209999340476L;
	
	private String name;		//JVM名
	
	private String type;			//JVM类型
	
	private String javaVersion;		//JAVA version of JVM
	
	private Long heapSizeCurrent;		//JVM中已使用内存数量（bytes）
	
	private Long heapFreeCurrent;		//JVM中空闲内存数量（bytes）

	
	public WeblogicJvmStatus() {

	}


	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}


	public String getJavaVersion() {
		return javaVersion;
	}


	public Long getHeapSizeCurrent() {
		return heapSizeCurrent;
	}


	public Long getHeapFreeCurrent() {
		return heapFreeCurrent;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}


	public void setHeapSizeCurrent(Long heapSizeCurrent) {
		this.heapSizeCurrent = heapSizeCurrent;
	}


	public void setHeapFreeCurrent(Long heapFreeCurrent) {
		this.heapFreeCurrent = heapFreeCurrent;
	}


}
