package org.infosec.ismp.manager.server.event.eventRmiImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;

/**
 * 通道，用于存放数据以便RMI取
 * @author wudengke 2009-6-29
 *
 */
public class EventRecivePipe {
	
	private static final  int MAX_SIZE=800;
	
	private static final  int Alert_MAX_SIZE=80;
	
	public LinkedList<Eventmoni> evenmonidisp = null;
	
	public LinkedList<Eventrealdisp> eventrealdisp = null;
	
//	public LinkedList<Alert> alertEvents = null;
	
	public List<Object> dates = null;

	public List<Object> getDates() {
		
//		System.out.println("--*-*-*-**-" + dates.size());
		return dates;
	}

	public EventRecivePipe() {
	    evenmonidisp = new LinkedList<Eventmoni>();
	    eventrealdisp = new LinkedList<Eventrealdisp>();
	    dates = new ArrayList<Object>();
	}

	public synchronized void addEvents(Eventmoni obj) {
//		System.out.println("--addEvents(Eventmoni obj)--" + obj);
		
		if (obj != null) {
		    evenmonidisp.addFirst(obj);
		    Object[] oo = new Object[]{obj.getFaciIp(),obj.getCurrValue(),obj.getTime()};
		    dates.add(oo);
		}
		if(evenmonidisp.size()>MAX_SIZE){
		    evenmonidisp.removeLast();
		}
	}

	public synchronized void addRealtimeEvents(Eventrealdisp obj) {
		if (obj != null) {
			eventrealdisp.addFirst(obj);		    	    
		}
		if(eventrealdisp.size()>MAX_SIZE){
			eventrealdisp.removeLast();
		}
	}
	
//	public synchronized void addAlertEvents(Alert vAlert){
//		if (vAlert != null){
//			alertEvents.addFirst(vAlert);
//		}
//		if(alertEvents.size() > Alert_MAX_SIZE){
//			alertEvents.removeLast();
//		}
//	}

	
	public synchronized List<Eventmoni> getNewEvents() {
		List<Eventmoni> results = new ArrayList<Eventmoni>();
//		System.out.println("get");
//		for(SimpleAlert cloneAlert : simpleAlerts){
//    		results.add(cloneAlert);
//    	}
		
		for(int i=0;i<evenmonidisp.size();i++){
		    Eventmoni alert = (Eventmoni)evenmonidisp.get(i);
			results.add(alert);
		}
		return results;
	}

	public synchronized List<Eventrealdisp> getRealtimeEvents() {
		List<Eventrealdisp> results = new ArrayList<Eventrealdisp>();
		
		for(int i=0;i<eventrealdisp.size();i++){
			Eventrealdisp alert = (Eventrealdisp)eventrealdisp.get(i);
			results.add(alert);
		}
		return results;
	}
	
//	public synchronized List<Alert> getAlertEvents(){
//		List<Alert> results = new ArrayList<Alert>();
//		
//		for(int i = 0; i < alertEvents.size(); i++){
//			Alert event = (Alert) alertEvents.get(i);
//			results.add(event);
//		}
//		return results;
//	}

	public synchronized void clearEvents(){
	    evenmonidisp.clear();
	    dates.clear();
	}
	
	public synchronized void clearRealtimeEvents(){
		eventrealdisp.clear();
	}
	
//	public synchronized void clearAlertEvents(){
//		alertEvents.clear();
//	}
	
	public static void main(String[] args) {
		/*List srcList = new LinkedList();
		List destList = new LinkedList();
		for(int i=0;i<10;i++){
	 	    SimpleAlert alert = new SimpleAlert();
	 	    alert.setAnalyzerClass("Test"+i);
			srcList.add(alert);
		}
		
		
		//
		for(int i=0;i<srcList.size();i++){
			SimpleAlert alert = (SimpleAlert)srcList.get(i);
			destList.add(alert);
		}
		
		srcList.clear();
		
		for(int i =0;i<destList.size();i++){
			SimpleAlert alert = (SimpleAlert)destList.get(i);
			System.out.println("alert is :"+alert);
		}*/
	}
}
