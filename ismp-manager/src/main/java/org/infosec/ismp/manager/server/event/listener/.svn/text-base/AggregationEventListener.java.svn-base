/**
 * 
 */
package org.infosec.ismp.manager.server.event.listener;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.util.EventConstants;
import org.infosec.ismp.manager.server.event.util.Constants;

import com.espertech.esper.client.EventBean;

/**
 * 处理归并事件发送过来的事件监听器，生成统计事件
 * @author Jianyu Shen
 * 
 *         2009-6-1 下午04:43:43
 */
public class AggregationEventListener extends BaseEventListener {
	protected final Log log = LogFactory.getLog(getClass());
	/**
	 * @param vComplexEventListener
	 */
	public AggregationEventListener(ComplexEventListener vComplexEventListener) {
		super(vComplexEventListener);
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
	public float[] redundancy = new float[EventConstants.DEVICECOUNT]; // 记录每个对应设备的归并前事件的冗余度
	public double[] available = new double[EventConstants.DEVICECOUNT]; // 记录设备的可用度
	public double[] amplification = new double[EventConstants.DEVICECOUNT];

	public ArrayList<Long> amounts; // 用于存储从HashMap中的list,某个监控设备在当前时间窗内的归并前的事件数
	public ArrayList<Integer> threRanks; // 用于存储从HashMap中的list,存放同一目的IP对应的不同威胁等级
	public ArrayList<String> eventTypes; // 用于存储从HashMap中的list,存放同一目的IP对应的不同事件类型
	public Integer faciId;

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 规范时间格式

	public List<Object> totalValue;
	public Object[] objs;
	public int timeFlag;

	/**
	 * HashMap方法
	 */
	// public Map<String, ArrayList<Long>> eventAmount = new HashMap<String,
	// ArrayList<Long>>(); //各个监控设备在当前时间窗内的归并前的事件数哈希表
	/**
	 * FastHashMap方法，意在尽可能的提高处理速度
	 */
	public FastHashMap eventAmount = new FastHashMap(); // 各个监控设备在当前时间窗内的归并前的事件数哈希表

	/**
	 * FastHashMap方法，意在尽可能的提高处理速度
	 */
	public FastHashMap threRankMap = new FastHashMap(); // 对应各个目的IP的威胁等级列表

	public FastHashMap eventTypeMap = new FastHashMap(); // 对应各个目的IP的事件类型列表

	public FastHashMap faciMap = new FastHashMap(); // 标识设备的map

	public double log(double value, double base) {
		return Math.log(value) / Math.log(base);
	}

	/**
	 * @return 下午04:17:47
	 */
	public List<Object> getTotalValue() {
		return totalValue;
	}

	/**
	 * @param vTotalValue
	 *            the totalValue to set
	 * 
	 */
	public void setTotalValue(List<Object> vTotalValue) {
		if(totalValue == null){
//			System.out.println("nullllllllllllllllllllllllll");
		}else{
			totalValue.clear();
			totalValue = vTotalValue;
		}

	}

	/**
	 * update方法，当事件监听器监听到事件后触发这里的动作
	 */
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
//		System.out.println("--------AggregationEventListener.start-------");
//		Formatter out = new Formatter(new StringBuffer());
//		out
//				.format(
//						"%10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s\n",
//						"faci_ip", "initValue", "total", "currValue",
//						"maxValue", "minValue", "counts", "redundancy",
//						"amplification", "threRank", "available",
//						"eventTypeArray", "time");
//		out
//				.format("---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ---------- | ----------\n");

		eventAmount.setFast(true);
		eventAmount = EventConstants.getEventAmount();

		threRankMap.setFast(true);
		threRankMap = EventConstants.getTHRE_RANK_MAP();

		eventTypeMap.setFast(true);
		eventTypeMap = EventConstants.getEventTypeMap();

		faciMap.setFast(true);
		faciMap = EventConstants.getFACIID();

		totalValue = this.getTotalValue();

		Timestamp timenew = (Timestamp) newEvents[0].get("time");
		Timestamp timeold = EventConstants.getTime();
		EventConstants.addTime(timenew);
//		System.out.println("new time " + timenew + " ; old time is " + timeold);
		if (timeold == null) { // 判断时间是否是第一次的
			timeFlag = -1;
		} else {
			timeFlag = timenew.getDate() - timeold.getDate();

			if (timeFlag == timenew.getDate()) {
				timeFlag = -2; // -2代表系统重启
			} else if (timeFlag != 0) {
				timeFlag = -1; // -1代表两天的过渡
			}
		}
		
//		System.out.println("--------eventAmount.isEmpty()-------" + eventAmount.isEmpty());
		
		if (!(eventAmount.isEmpty())) {
			for (int i = 0; i < newEvents.length; i++) { // 对每个收到的归并事件进行统计，
				Eventmoni event = new Eventmoni();

				// 并通过接口传给页面同时入库
				String faciIp = (String) newEvents[i].get("faci_ip");
				Integer bureauId = (Integer) newEvents[i].get("bureauId");
				Timestamp time = (Timestamp) newEvents[i].get("time");
				amounts = (ArrayList<Long>) eventAmount.get(faciIp); // 该destIp的归并前事件数的List
				threRanks = (ArrayList<Integer>) threRankMap.get(faciIp); // 该IP对应的威胁等级列表
				eventTypes = (ArrayList<String>) eventTypeMap.get(faciIp); // 该IP对应的事件类型列表
				// System.out.println("SSSSSSSSSSSSSSSSSSSSs " + threRanks.);
				int threRank = 0;
//				System.out.println("threRanks WWWWWWWWWWWWWWWWWWWWWWWw "
//						+ threRanks);

				if (threRanks == null) {
					threRank = 0;
					continue;
				} else if (threRanks != null || !threRanks.isEmpty()) {
					threRank = threRanks.get(0);

					// int threRank = 0;
					for (int j = 1; j < threRanks.size(); j++) {
						if (threRank < threRanks.get(j)) {
							threRank = threRanks.get(j);
						}
					}
//					threRanks.clear();
				}

				faciId = (Integer) faciMap.get(faciIp);

				// 由于同一目的IP会有多个事件类型，把多个事件类型组合成一个数组储存在这里
				String eventTypeArray = null;
				eventTypeArray = eventTypes.get(0);
				for (int k = 1; k < eventTypes.size(); k++) {
					eventTypeArray = eventTypeArray.concat(", "
							+ eventTypes.get(k));
				}

				long counts = 0;

				if (timeFlag == -2) {

					for (int k = 0; k < totalValue.size(); k++) {
						// 查找出该faciIp对应的数据库中事件总量
						objs = (Object[]) totalValue.get(k);
						if (faciIp.equals((String) objs[0]) && (Integer) objs[2] == bureauId) {
							total[faciId] = (Long) objs[1];
							initValue[faciId] = amounts.size();
							maxValue[faciId] = initValue[faciId];
							minValue[faciId] = initValue[faciId];
							break;// 找到后跳出for循环
						}
					}
				} else if (timeFlag == -1) {
					initValue[faciId] = 0;
				}
				if (initValue[faciId] == 0) {
					initValue[faciId] = amounts.size();
					maxValue[faciId] = initValue[faciId];
					minValue[faciId] = initValue[faciId];
					total[faciId] = initValue[faciId];
					currValue[faciId] = initValue[faciId];
					amplification[faciId] = 0;
				} else {
					currValue[faciId] = amounts.size();

					if (maxValue[faciId] < currValue[faciId]) {
						maxValue[faciId] = currValue[faciId];
					} else if (minValue[faciId] > currValue[faciId]) {
						minValue[faciId] = currValue[faciId];
					}
					total[faciId] = total[faciId] + currValue[faciId];

					amplification[faciId] = (double) (currValue[faciId] - initValue[faciId])
							/ initValue[faciId];
					
					double amfi = Math.round((int)(amplification[faciId]*1000));
					amplification[faciId] = amfi / 10;
				}

				for (int j = 0; j < amounts.size(); j++) {

					counts = counts + amounts.get(j);
				}

				if (counts == 0) {
					counts = 1;
					redundancy[faciId] = 0;
				}else if(counts < currValue[faciId]){
					redundancy[faciId] = 0;
				} else {
					redundancy[faciId] = (float) ((counts - (double) currValue[faciId]) / counts); // 计算冗余度
					float b = Math.round((int) (redundancy[faciId] * 1000));
					redundancy[faciId] = b / 10;
					log.debug("冗余消除率(%)："+redundancy[faciId]);
				}
				
				available[faciId] = EventConstants.C
						+ (EventConstants.BETA // 计算设备可用度
						* log(counts, EventConstants.LOGBASE))
						* (EventConstants.ALFA) * (threRank + 1)
						- EventConstants.SIGMA
						* (amplification[faciId] + EventConstants.DELTA)
						/ (-redundancy[faciId] + 1);

				if(available[faciId] > 50){
					available[faciId] = 50;
				}
				
				double av = Math.round((int) (available[faciId] * 10));
				available[faciId] = av / 10;
				
//				out
//						.format(
//								"%10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s | %10s\n",
//								faciIp, initValue[faciId], total[faciId],
//								currValue[faciId], maxValue[faciId],
//								minValue[faciId], counts, redundancy[faciId]
//										+ "%", amplification[faciId] + "%", threRank,
//								available[faciId], eventTypeArray, time);

				event.setFaciIp(faciIp);
				event.setInitValue((int) initValue[faciId]);
				event.setTotalValue((int) total[faciId]);
				event.setCurrValue((int) currValue[faciId]);
				event.setMaxValue((int) maxValue[faciId]);
				event.setMinValue((int) minValue[faciId]);
				event.setRedundance(redundancy[faciId]);
				event.setFaciAvai(available[faciId]);
				event.setRange(amplification[faciId]);
				event.setThreRank(threRank);
				event.setType(eventTypeArray);
				event.setTime(Timestamp.valueOf(df.format(new Date())));
//				event.setFaci_id("12");
				event.setDomain(bureauId.toString());
//				event.setFaci_name("dfdf");

				Constants.addMoniEvent(event);
			}
		} else {
			System.out.println("Map is null");
		}

		/**
		 * 清空FastHashMap
		 */
		eventAmount.clear();
		threRankMap.clear();
		eventTypeMap.clear();

//		complexEventListener.onComplexEvent("The facility Statistics :\n"
//				+ out.out().toString());
	}

}
