/**
 * 
 */
package org.infosec.ismp.manager.server.event.process;

import java.util.List;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.manager.rmi.aim.service.SendAlertService;
import org.infosec.ismp.manager.rmi.event.dao.IEventmoniDao;
import org.infosec.ismp.manager.rmi.event.dao.impl.EventmoniDao;
import org.infosec.ismp.manager.rmi.event.modle.EventFaciip;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;
import org.infosec.ismp.manager.rmi.event.util.EventConstants;
import org.infosec.ismp.manager.server.event.eventRmiImpl.EventRecivePipe;
import org.infosec.ismp.manager.server.event.util.Constants;
import org.infosec.ismp.manager.server.event.util.StartUpConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动基于拓扑的事件统计计算服务
 * 
 * @author Jianyu Shen
 * 
 *         2009-6-2 上午10:05:06
 */
public class EventTopoStatistics extends Thread {
	
	int i=0;
	
	public static final int ITERATION = 50; // 迭代次数

	public static final int SLEEP = 1000; // 每迭代一次后睡眠时间

	List<NormalizedEvent> events;

	// private final EventGenerator eventGenerator; // 事件生成器，用于生成事件

	private final EventProcessAgent eventProcessAgent; // 事件处理代理
	
//	public BureauEventStatistics centerEventsCal;
	protected final Log log = LogFactory.getLog(getClass());
//	public void setBureauEventStatistics(BureauEventStatistics vBureauEventStatistics){
////		System.out.println("set BureauEventStatistics bean");
//		this.centerEventsCal = vBureauEventStatistics;
//	}

	private IEventmoniDao eventmoniDao;

	public void setEventmoniDao(EventmoniDao vEventmoniDao) {
//		System.out.println("set eventmoniDao~~~~~~~~~~~~~~~~~~~~~~");
		this.eventmoniDao = vEventmoniDao;
	}

	private EventSaveToDB eventSaveToDB;

	public void setEventSaveToDB(EventSaveToDB eventSaveToDB) {
		// System.out.println("set eventSaveToDB!!!!!!!!!!!!!");
		this.eventSaveToDB = eventSaveToDB;
	}

	// 注入pipe，把数据存入pipe，以便RMI来取
	private EventRecivePipe eventRecivePipe;

	public void setEventRecivePipe(EventRecivePipe eventRecivePipe) {
		this.eventRecivePipe = eventRecivePipe;
	}
	
	/**
	 * 获取AlertReceiver类的bean
	 */
//	private AlertReceiver alertReceiver;
//	
//	public void setAlertReceiver(AlertReceiver alertReceiver){
//		this.alertReceiver = alertReceiver;
//	}
//	
    private AlertManager sendAlertService;
	
	
//	
//	private ContiEventService contiEventService;
//
//	public void setContiEventService(ContiEventService contiEventService) {
//		this.contiEventService = contiEventService;
//	}

	public AlertManager getSendAlertService() {
		return sendAlertService;
	}

	public void setSendAlertService(AlertManager sendAlertService) {
		this.sendAlertService = sendAlertService;
	}

	/**
     * 
     */
	public EventTopoStatistics() {
//		 eventGenerator = new EventGenerator();
		eventProcessAgent = new EventProcessAgent(new FaciComplexListener());
		
	}
	
//	public void sendAlert(){
//		AlertImpl alertImpl = new AlertImpl(){
//			void alertTrigger(Alert vAlert){				
//				eventRecivePipe.addAlertEvents(vAlert);
//			}
//		};
//		alertReceiver.addAlertListener(alertImpl);
//	}

	/**
	 * 发送事件 sendEvents void
	 */
	public void sendEvents() {

		// List<NormalizedEvent> events = eventGenerator.generateBatch(); //
		// 保存归一化事件的列表

		Vector<Eventrealdisp> eventsToSend = new Vector<Eventrealdisp>(); // 保存归并事件列表

		eventsToSend = EventConstants.getAggreBatch(eventsToSend);
		
		//新增
//		System.out.println("WWWWWWWWWWWWWWWWWWWWWww  event realdisp " + eventsToSend.size());

		// 对每一条事件总的源IP和目的IP都分别进行统计，保存基于源IP或是目的IP的事件量，把其作为faci_ip保存，
		// 对每种IP都进行统计，同时保存相应IP的事件数
		// 其实最后统计完的总事件量是真实事件量的2倍
		Vector<EventFaciip> eventFaci = new Vector<EventFaciip>();
		eventFaci = EventConstants.getStatisEventBatch(eventFaci);
		 
//		System.out.println("event faci counts are XXXXXXXXXX"
//		 + eventFaci.size());
//		System.out.println("event faci ====" + eventFaci);
//		System.out.println("------------------------------------");
//		
		
		Vector<Eventmoni> eventMoni = new Vector<Eventmoni>(); // 实际用的方法，测试不用
		eventMoni = EventConstants.getMonitorEventBatch(eventMoni);
//		System.out.println("///////*****************///////////" + eventMoni.size());
		
//		if(EventFactory.getStatisticsEvent() != null && eventMoni.size()>0){
//			log.debug("把事件(EventMoni)发送给态势："+eventMoni.size());
//			EventFactory.getStatisticsEvent().interestingEvent(eventMoni);//把事件发送给态势
//		}		

		// **调用EventSaveToDB中的保存实时事件的方法，入库**//
		if (eventsToSend != null && eventsToSend.size()>0) {
			eventSaveToDB.saveRealDispEventList(eventsToSend);
			i = eventsToSend.size();
			log.debug("入库数量："+i);
			System.out.println("入库数量==" + i);
		}
		
		// **调用EventSaveToDB中的保存拓扑统计事件的方法，入库**//
		if (eventMoni != null && eventMoni.size()>0) {
			eventSaveToDB.saveMoniEventList(eventMoni);
		}
		
		
		

		// **RMI通信以及向一级发送，传送eventmoni列表**//
		if (eventMoni != null && eventMoni.size() > 0) {
//			log.debug("向1级发送并存入通道： " + eventMoni.size());
//			centerEventsCal.handleMoniEvent(eventMoni);
			eventRecivePipe.clearEvents();
			for (int i = 0; i < eventMoni.size(); i++) {
				eventRecivePipe.addEvents(eventMoni.get(i));
			}
		}

		// **RMI通信，传送eventsToSend列表**//
		if (eventsToSend != null && eventsToSend.size() > 0) {
			log.debug("实时事件存入通道： " + eventsToSend.size());
			System.out.println("实时事件存入通道： " + eventsToSend.size());
			eventRecivePipe.clearRealtimeEvents();
			for (int i = 0; i < eventsToSend.size(); i++) {
				// System.out.println("add realtime events to pipe " +
				// eventsToSend.get(i).toString());
//				System.out.println(eventsToSend.get(i));
				eventRecivePipe.addRealtimeEvents(eventsToSend.get(i));
				// System.out.println("realtime event list is " +
				// eventsToSend.get(i));
			}
		}

		// 将列表中的归并后事件送esper引擎处理
		// System.out.println("IOIIOIOIOIOIOI" + eventsToSend.isEmpty());
		if (eventsToSend != null && eventsToSend.size() > 0) {
		for (Eventrealdisp event : eventsToSend) {
			eventProcessAgent.sendEvent(event);
		}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 对归并后事件的二次处理，为了统计在目的IP和源IP中总共出现的事件总数
		if (eventFaci != null && eventFaci.size() > 0) {
		for (EventFaciip event : eventFaci) {
			eventProcessAgent.sendEvent(event);
		}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// for (Eventmoni moniEvent : eventMoni) {
		// eventProcessAgent.sendEvent(moniEvent);
		// }
		// eventProcessAgent.sendEvent(moniEvent);

		//
		//		
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// for (TopoInfoEvent topoEvent : topoEvents) {
		// eventProcessAgent.sendEvent(topoEvent);
		// }

	}

	/**
	 * 负责接收事件 (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		if (eventProcessAgent.getTotalValue() == null) {
//			eventProcessAgent.setTotalValue(eventmoniDao.queryIpTotalByNew());//系统起来时设置日总量
			eventProcessAgent.setSendAlertService(sendAlertService);
//			eventProcessAgent.setContiEventService(contiEventService);
			eventProcessAgent.setEventSaveToDB(eventSaveToDB);
			eventProcessAgent.init(new FaciComplexListener());
//			sendAlert();//向WEB端发送设备监控发现的安全告警事件(event_moni_info：设备监控信息表)
		}
		while (true) {
			events = Constants.getAuditEventBatch(); // 保存归一化事件的列表
			if (events == null || events.isEmpty()) {
//				 System.out.println("no events");
			} else {
				// System.out.println("have events");
				// 将列表中的归一化后事件送esper引擎处理
				for (NormalizedEvent event : events) {
					eventProcessAgent.sendEvent(event);
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sendEvents();
			}
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// System.out.println("XXXXXXXXXXCCCCCCCCCCCCCCCCCCCCC");
			}
		}
	}

	public static void main(String args[]) {

		
		
		StartUpConfig start = new StartUpConfig();
		start.startConfig();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext.xml",
						"classpath:applicationContext-manager.xml" });
		
		EventReceiveFromAudit auditEvent = new EventReceiveFromAudit();
		auditEvent.start();
		
		EventFilter filter = (EventFilter) ctx.getBean("eventFilter");
		filter.start();
		
		EventTopoStatistics topoStatistics = (EventTopoStatistics) ctx.getBean("eventTopoStatistics");
		topoStatistics.run();
		
		
		// topoStatistics.setEventRecivePipe(eventRecivePipe);
		

		// topoStatistics.setIEventrealdispDao(eventrealdispDao);

		// EventSendToRMI aa = new EventSendToRMI();
		// topoStatistics.setEventReceive(eventReceive);

		System.out.println("Event Statistics ended!");

	}
}
