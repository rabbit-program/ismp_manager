package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

public class DeviceChartVO implements Serializable{ 
	private Timestamp year;
	private Map<Integer, Integer> dataMap;
	public Timestamp getYear() {
		return year;
	}
	public void setYear(Timestamp year) {
		this.year = year;
	}
	public Map<Integer, Integer> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<Integer, Integer> dataMap) {
		this.dataMap = dataMap;
	}
	  
	
}
