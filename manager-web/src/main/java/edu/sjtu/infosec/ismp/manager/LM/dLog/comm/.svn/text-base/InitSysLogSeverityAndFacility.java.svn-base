package edu.sjtu.infosec.ismp.manager.LM.dLog.comm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogFacility;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogSeverity;

public class InitSysLogSeverityAndFacility {

	//存放syslog的严重性
	public static Map<Integer,String> SYSLOGSEVERITY = new HashMap<Integer,String>();
	//存放stslog的产生日志的程序模块
	public static Map<Integer,String> SYSLOGFACILITY = new HashMap<Integer,String>();
	
	public static void addSysLogSeverity(SysLogSeverity sysLogSeverity) {
		SYSLOGSEVERITY.put(sysLogSeverity.getSeverityNumber(), sysLogSeverity.getSeverityDescribe());
	}
	
	public static void closeSysLogSeverity(){
		SYSLOGSEVERITY.clear();
	}
	
	public static TreeMap<Integer,String> getSysLogSeverity(TreeMap<Integer,String> tempMap){
		if(!SYSLOGSEVERITY.isEmpty()){
			Set<Integer> severitySet = SYSLOGSEVERITY.keySet();
			Iterator<Integer> iter = severitySet.iterator();
			for(;iter.hasNext();){
				Integer severityNum = iter.next();
				tempMap.put(severityNum, SYSLOGSEVERITY.get(severityNum));
			}
		}
		return tempMap;
	}
	
	public static void addSysLogFacility(SysLogFacility sysLogFacility) {
		SYSLOGFACILITY.put(sysLogFacility.getFacilityNumber(), sysLogFacility.getFacilityDescribe());
	}
	
	public static void closeSysLogFacility(){
		SYSLOGFACILITY.clear();
	}
	
	public static TreeMap<Integer,String> getSysLogFacility(TreeMap<Integer,String> tempMap){
		if(!SYSLOGFACILITY.isEmpty()){
			Set<Integer> facilitySet = SYSLOGFACILITY.keySet();
			Iterator<Integer> iter = facilitySet.iterator();
			for(;iter.hasNext();){
				Integer facilityNum = iter.next();
				tempMap.put(facilityNum, SYSLOGFACILITY.get(facilityNum));
			}
		}
		return tempMap;
	}
}
