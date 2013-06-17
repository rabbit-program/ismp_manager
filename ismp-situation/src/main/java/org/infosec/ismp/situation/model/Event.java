package org.infosec.ismp.situation.model;

import java.sql.Timestamp;

public class Event {
	
	private int id;

	private String destAddress;

	private Integer priority;

	private Timestamp time;
	
	private String srcmod;
	
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDestAddress() {
		return destAddress;
	}

	public void setDestAddress(String destAddress) {
		this.destAddress = destAddress;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getSrcmod() {
		return srcmod;
	}

	public void setSrcmod(String srcmod) {
		this.srcmod = srcmod;
	}

}
