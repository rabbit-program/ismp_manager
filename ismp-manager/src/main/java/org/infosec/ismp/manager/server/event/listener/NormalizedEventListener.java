/**
 * AggregationEventListener用的不是AggregationEvent这个事件基本类
 * 它用的是Eventrealdisp这个类，是由吴登科定义的
 * NormalizedEventListener.java
 */
package org.infosec.ismp.manager.server.event.listener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Formatter;

import org.apache.commons.collections.FastHashMap;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.rmi.event.util.EventConstants;
import org.infosec.ismp.manager.server.event.process.EventSaveToDB;

import com.espertech.esper.client.EventBean;

/**
 * 处理发送过来的归一化事件，生成归并事件
 * 
 * @author Jianyu Shen
 * 
 *         2009-6-2 上午11:42:45
 */
public class NormalizedEventListener extends BaseEventListener {

//	private EventSaveToDB eventSaveToDB;
//
//	public void setEventSaveToDB(EventSaveToDB eventSaveToDB) {
//		// System.out.println("set eventSaveToDB!!!!!!!!!!!!!");
//		this.eventSaveToDB = eventSaveToDB;
//	}

	/**
	 * @param vComplexEventListener
	 */
	public NormalizedEventListener(ComplexEventListener vComplexEventListener,
			EventSaveToDB eventSaveToDB) {
		super(vComplexEventListener);
//		this.eventSaveToDB = eventSaveToDB;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 分配6个数组空间用于存放统计数据
	 */
	public static long[] initValue = new long[EventConstants.DEVICECOUNT]; // 初始事件数
	public long[] currValue = new long[EventConstants.DEVICECOUNT]; // 当前事件数
	public long[] maxValue = new long[EventConstants.DEVICECOUNT]; // 整个监控时间内到达的事件最多的事件数
	public long[] minValue = new long[EventConstants.DEVICECOUNT]; // 整个监控时间内到达的事件最少的事件数
	public long[] total = new long[EventConstants.DEVICECOUNT]; // 从监控时间开始总的事件数
	public ArrayList<Long> amounts; // 统计出来的各个事件的归并前事件数量，存放同一目的IP事件所对应的不同归并前事件数量
	public ArrayList<Integer> threRanks; // 存放同一目的IP事件所对应的不同威胁等级
	public ArrayList<String> eventTypes;
	public long[] counts = new long[EventConstants.DEVICECOUNT];
	public long amount = 0;
	public int threRank = 0;
	public int faciId = 0;

	// public Map<String, ArrayList<Long>> eventAmount= new FastHashMap();
	// //相对应各个监控设备在当前时间窗内的归并前的事件数
	/**
	 * FastHashMap方法，意在尽可能的提高处理速度 相对应各个监控设备在当前时间窗内的归并前的事件数
	 */
	public FastHashMap eventAmount = new FastHashMap();

	/**
	 * FastHashMap方法，意在尽可能的提高处理速度 对应各个目的IP的威胁等级列表
	 */
	public FastHashMap threRankMap = new FastHashMap();

	/**
	 * FastHashMap方法，意在尽可能的提高处理速度 对应各个目的IP的不同事件类型列表
	 */
	public FastHashMap eventTypeMap = new FastHashMap();

	/**
	 * 标识设备
	 */
	public FastHashMap faciIdentifier = new FastHashMap();

	/**
	 * update方法，当事件监听器监听到事件后触发这里的动作
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		
//		System.out.println("-------------update方法，当事件监听器监听到事件后触发这里的动作------------------");
		
		Formatter out = new Formatter(new StringBuffer());
//		out.format("%10s | %10s | %10s | %10s | %10s | %10s | %10s\n",
//				"dest_ip", "dest_ip", "faci_type", "event_type", "counts",
//				"threRank", "time");
//		out
//				.format("---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ----------\n");

		eventAmount.setFast(true);
		threRankMap.setFast(true);
		eventTypeMap.setFast(true);
		faciIdentifier.setFast(true);
		
//		System.out.println("----------------newEvents---newEvents-------------------------" + newEvents);
		
		if (newEvents != null) {
			for (int i = 0; i < newEvents.length; i++) { // 对每个收到的归并事件进行统计，
				// 并通过接口传给页面同时入库
				String destIp = (String) newEvents[i].get("destip");
				String srcIp = (String) newEvents[i].get("srcip");
				String event_type = (String) newEvents[i].get("messageType");
				// int dest_Port = (Integer) newEvents[i].get("dest_port");
				String faci_type = (String) newEvents[i].get("devicetype");
				int thre_rank = (Integer) newEvents[i].get("threrank");
				Timestamp time = (Timestamp) newEvents[i].get("timestamp");
				// String faci_id = (String) newEvents[i].get("faci_id");
				counts[i] = (Long) newEvents[i].get("countPerType");

				if (!(faciIdentifier.containsKey(destIp))) {
					faciId = faciIdentifier.size() + 1;
					faciIdentifier.put(destIp, faciId);
				}

				if (!(faciIdentifier.containsKey(srcIp))) {
					faciId = faciIdentifier.size() + 1;
					faciIdentifier.put(srcIp, faciId);
				}

				if (!(eventAmount.containsKey(destIp))) {
					amounts = new ArrayList<Long>();
					// amount = eventAmount.get(destIp);
					amount = (Long) newEvents[i].get("countPerType");
					amounts.add(amount);
					eventAmount.put(destIp, amounts);
				} else {
					// 单个事件归并前数量
					amounts = (ArrayList<Long>) eventAmount.get(destIp);
					// int j = amounts.size();
					amounts.add((Long) newEvents[i].get("countPerType"));
					eventAmount.put(destIp, amounts);
				}

				if (!(eventAmount.containsKey(srcIp))) {
					amounts = new ArrayList<Long>();
					// amount = eventAmount.get(destIp);
					amount = (Long) newEvents[i].get("countPerType");
					amounts.add(amount);
					eventAmount.put(srcIp, amounts);
				} else {
					amounts = (ArrayList<Long>) eventAmount.get(srcIp);
					// int j = amounts.size();
					amounts.add((Long) newEvents[i].get("countPerType"));
					eventAmount.put(srcIp, amounts);
				}

				if (!(threRankMap.containsKey(destIp))) {
					threRanks = new ArrayList<Integer>();
					threRank = thre_rank;
					threRanks.add(threRank);
					threRankMap.put(destIp, threRanks);
				} else {
					// 归并事件威胁等级
					threRanks = (ArrayList<Integer>) threRankMap.get(destIp);
					threRanks.add(thre_rank);
					threRankMap.put(destIp, threRanks);
				}

				if (!(threRankMap.containsKey(srcIp))) {
					threRanks = new ArrayList<Integer>();
					threRank = thre_rank;
					threRanks.add(threRank);
					threRankMap.put(srcIp, threRanks);
				} else {
					threRanks = (ArrayList<Integer>) threRankMap.get(srcIp);
					threRanks.add(thre_rank);
					threRankMap.put(srcIp, threRanks);
				}

				if (!(eventTypeMap.containsKey(destIp))) {
					eventTypes = new ArrayList<String>();
					eventTypes.add(event_type);
					eventTypeMap.put(destIp, eventTypes);
				} else {
					eventTypes = (ArrayList<String>) eventTypeMap.get(destIp);
					if (!(eventTypes.contains(event_type))) {
						eventTypes.add(event_type);
					}
					eventTypeMap.put(destIp, eventTypes);
				}

				if (!(eventTypeMap.containsKey(srcIp))) {
					eventTypes = new ArrayList<String>();
					eventTypes.add(event_type);
					eventTypeMap.put(srcIp, eventTypes);
				} else {
					eventTypes = (ArrayList<String>) eventTypeMap.get(srcIp);
					if (!(eventTypes.contains(event_type))) {
						eventTypes.add(event_type);
					}
					eventTypeMap.put(srcIp, eventTypes);
				}

//				out.format("%10s | %10s | %10s | %10s | %10s | %10s | %10s\n",
//						destIp, srcIp, faci_type, event_type, counts[i],
//						thre_rank, time);

			}

			EventConstants.setEventAmount(eventAmount); // 保存相对应设备的归并前事件量
			EventConstants.setTHRE_RANK_MAP(threRankMap); // 保存对应目的IP设备的事件威胁等级
			EventConstants.setEventTypeMap(eventTypeMap); // 保存对应同一个目的IP的不同事件类型
			EventConstants.setFACIID(faciIdentifier); // 保存每个设备的唯一标识

			// EventConstants.setAmount(amount); // 保存amount

//			EventConstants.clearAggreBatch();
			/**
			 * 保存归并后的事件
			 */
//			System.out.println("++++++++++++newEvents.length+++++++++++" + newEvents.length);
//			System.out.println("++++++++++++newEvents+++++++++++" + newEvents);
			for (int i = 0; i < newEvents.length; i++) {
//				FastHashMap map = eventSaveToDB.getTopoToMap();
				Eventrealdisp event = new Eventrealdisp();
//				String srcip = (String) newEvents[i].get("src_ip");
//				Integer agentId = (Integer) newEvents[i].get("agentId");
//				String srcstr = srcip.trim() +":"+ agentId.toString().trim();
				
//				System.out.println("----map-----"+map);
//				System.out.println("***********************");
//				System.out.println("------srcstr-------"+srcstr);
//				String destip = (String) newEvents[i].get("dest_ip");
//				agentId = (Integer) newEvents[i].get("agentId");
//				String deststr = destip.trim()+":" + agentId.toString().trim();
				
//				if (map.containsKey(srcstr)) {
//					Object[] obj = (Object[]) map.get(srcstr);
//					if (obj[5] != null && obj[6] != null) {
						event.setDestIp((String) newEvents[i].get("destip"));
						event.setEventType((String) newEvents[i]
								.get("messageType"));
						event.setFaciType((String) newEvents[i]
								.get("devicetype"));
						event.setSrcIp((String) newEvents[i].get("srcip"));
						if (newEvents[i].get("srcport") != null) {
							event.setSrcPort(Integer.valueOf(newEvents[i]
									.get("srcport").toString()));
						}
						if (newEvents[i].get("destport") != null) {
							event.setDestPort(Integer.valueOf(newEvents[i]
									.get("destport").toString()));
						}
						event.setThreRank((Integer) newEvents[i]
								.get("threrank"));
						event.setFaciIp((String) newEvents[i].get("ipaddr"));
						event.setEventTime((Timestamp) newEvents[i].get("timestamp"));
						event.setDescrip((String) newEvents[i].get("msg"));
						event.setProtType((String) newEvents[i]
								.get("protocol"));
						event.setDomain((String) newEvents[i].get("domain"));
						
						//2010-6-2
//						System.out.println("------------NormalizedEventListener.event-------------" + event);
						
						EventConstants.addAggreEvent(event);
						EventConstants.addUploadEvent(event);
					}
				}
				/*if (map.containsKey(deststr)) {
					Object[] obj = (Object[]) map.get(deststr);
					if (obj[5] != null && obj[6] != null) {
						event.setDest_ip((String) newEvents[i].get("dest_ip"));
						event.setEvent_type((String) newEvents[i]
								.get("event_type"));
						event.setFaci_type((String) newEvents[i]
								.get("faci_type"));
						event.setSrc_ip((String) newEvents[i].get("src_ip"));
						if (newEvents[i].get("src_port") != null) {
							event.setSrc_port((Integer) newEvents[i]
									.get("src_port"));
						}
						if (newEvents[i].get("dest_port") != null) {
							event.setDest_port((Integer) newEvents[i]
									.get("dest_port"));
						}
						event.setThre_rank((Integer) newEvents[i]
								.get("thre_rank"));
						event.setFaci_ip((String) newEvents[i].get("faci_ip"));
						event.setTime((Timestamp) newEvents[i].get("time"));
						event.setDescrip((String) newEvents[i].get("descrip"));
						event.setProt_type((String) newEvents[i]
								.get("prot_type"));
						event.setBureauId((Integer) obj[5]);
						event.setBureauName((String) obj[6]);
						EventConstants.addAggreEvent(event);
						EventConstants.addUploadEvent(event);
					}
				}*/
			}

			// eventAmount.clear();
//		} else {
//			// System.out.println("events is nulLLLLLLLLLLLLLLLL");
//		}
		// complexEventListener.onComplexEvent("The facility Statistics :\n"
		// + out.out().toString());

//	}

}
