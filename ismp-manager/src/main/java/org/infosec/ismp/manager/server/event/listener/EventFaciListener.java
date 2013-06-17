/**
 * EventFaciListener.java
 */
package org.infosec.ismp.manager.server.event.listener;

import java.sql.Timestamp;
import java.util.Formatter;

import org.infosec.ismp.manager.rmi.event.modle.EventFaciip;
import org.infosec.ismp.manager.rmi.event.util.EventConstants;

import com.espertech.esper.client.EventBean;

/**
 * 用于基于源和目的IP的事件统计监听器
 * @author Jianyu Shen
 * 
 *         2009-6-12 下午01:46:58
 */
public class EventFaciListener extends BaseEventListener {

	/**
	 * @param vComplexEventListener
	 */
	public EventFaciListener(ComplexEventListener vComplexEventListener) {
		super(vComplexEventListener);
		// TODO Auto-generated constructor stub
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		
//		System.out.println("----------- 用于基于源和目的IP的事件统计监听器------------");
		
		Formatter out = new Formatter(new StringBuffer());
//		out.format("%10s | %10s | %10s\n", "faciIp", "count", "eventTime");
//		out.format("---------- | ---------- |\n");

		if (newEvents != null) {
			for (int i = 0; i < newEvents.length; i++) {
				EventFaciip event = new EventFaciip();
				event.setFaci_ip((String) newEvents[i].get("faciIp"));
				event.setCountPerType((Long) newEvents[i].get("countPerType"));
				event.setTime((Timestamp) newEvents[i].get("eventTime"));
				event.setBureauId(Integer.parseInt(newEvents[i].get("domain").toString()));
				
//				System.out.println("%%%%%%%=========EventFaciListener.event=======%%%%%%%"+ event);
				
				EventConstants.addStatisticsEvent(event);

//				out.format("%10s | %10s | %10s\n", (String) newEvents[i]
//						.get("faciIp"), (Long) newEvents[i]
//						.get("countPerType"), (Timestamp) newEvents[i]
//						.get("eventTime"));
			}
		}
		complexEventListener.onComplexEvent("The facility Statistics :\n"
				+ out.out().toString());

	}
}
