/**
 * 上海交通大学
 */
package org.infosec.ismp.manager.server.event.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.util.EventConstants;
import org.infosec.ismp.manager.server.event.util.Constants;

/**
 * 事件过滤
 * 
 * @author <a mailto:xxxx@edu.sjtu.cn>沈建宇</a>
 * @date 2009-6-29
 */
public class EventFilter extends Thread {
	
	public List<Object> topoEvents = new ArrayList<Object>(); //保存拓扑中设备IP和MAC地址
	
	/**
	 * @param vTopoEvents the topoEvents to set
	 */
	public void setTopoEvents(List<Object> vTopoEvents) {
		topoEvents = vTopoEvents;
	}

	Vector<Eventmoni> monis = new Vector<Eventmoni>(); //事件统计信息
	
	EventSaveToDB eventSaveToDB;
	
	Object[] topoEvent;
	
	public EventFilter(){
		
	}
	
	public void setEventSaveToDB(EventSaveToDB eventSaveToDB) {
		// System.out.println("set eventSaveToDB!!!!!!!!!!!!!");
		this.eventSaveToDB = eventSaveToDB;
	}

	public void run() {
		topoEvents = eventSaveToDB.getTopoEventInfo();
//		System.out.println("--------EventFilter.run-----------topoEvents.size()-" + topoEvents.size());
//		//2010-6-4
//		for(Object o:topoEvents){
//			System.out.println("--------topoEvents.0-------------"+o);
//		}
//		
		while (true) {	
			
			//wwwwwwwwwwwww
//			for(int k = 0; k < topoEvents.size(); k++){
//				Object[] topoEvent = (Object[])topoEvents.get(k);
////				System.out.println("MACCCCCCCCCCCCC " + topoEvent[1] + "  " + topoEvent[0]);
//			}
			//ssssssssss
			monis = Constants.getMoniEventBatch();
			
//			System.out.println("--monis--" + monis.size());
			if (monis != null || (!monis.isEmpty())) {
				if(topoEvents != null){
					for (Eventmoni moni : monis) {
						for (int i = 0; i < topoEvents.size(); i++) {
							topoEvent = (Object[])topoEvents.get(i);
							String ip = (String)topoEvent[0];
							String macAddr = (String)topoEvent[1];
							String faciName = (String)topoEvent[2];
//							System.out.println("ip " + ip + " macAddr " + macAddr + "moni.faciIp" + moni.getFaciIp().trim() + "--" + moni.getFaciIp().trim().equals(ip.trim()));
							if (moni.getFaciIp().trim().equals(ip.trim())) {
								moni.setFaciId(macAddr);
								moni.setFaciName(faciName);
//								System.out.println("ip " + ip + " macAddr " + macAddr + "moni.faciIp" + moni.getFaciIp().trim());
								EventConstants.addMonitorEvent(moni);
							}
						}
					}
				}
			}else{
				System.out.println("event is XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx");
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
