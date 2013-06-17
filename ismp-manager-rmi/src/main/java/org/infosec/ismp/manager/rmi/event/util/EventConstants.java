/**
 * Constants.java
 */
package org.infosec.ismp.manager.rmi.event.util;

import java.sql.Timestamp;
import java.util.Vector;

import org.apache.commons.collections.FastHashMap;
import org.infosec.ismp.manager.rmi.event.modle.EventFaciip;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;



/**
 * 定义的全局静态变量
 * @author Jianyu Shen
 * 
 *         2009-6-2 下午08:16:22
 */
public class EventConstants {
	/**
	 * 实例化归并事件
	 */
	public static Vector<Eventrealdisp> AGGREGATEDEVENT = new Vector<Eventrealdisp>();

	/**
	 * 要通过回调方式上传的实时显示事件
	 */
	public static Vector<Eventrealdisp> UPLOADEVENT = new Vector<Eventrealdisp>();

	/**
	 * 要通过回调方式上传的拓扑信息统计计算事件
	 */
	public static Vector<EventFaciip> TOPOSTICEVENT = new Vector<EventFaciip>();

	/**
	 * 要通过回调方式上传的拓扑信息统计计算事件,分两个变量存放，一个给显示，一个传态势
	 */
	public static Vector<Eventmoni> EVENTMONI = new Vector<Eventmoni>();
	public static Vector<Eventmoni> SITUATIONMONI = new Vector<Eventmoni>();


	/**
	 * 保存上一组事件的时间
	 */
	public static Timestamp TIME;

	/**
	 * 用于计算设备的可用度的5 个参数
	 */
	public static double BETA = 0.05;
	public static double ALFA = -5;
	public static double SIGMA = 2;
	public static double C = 50; // 常量
	public static double DELTA = 0.1; // 调节量值

	public static double LOGBASE = 2; // 用于对数计算的底

	/**
	 * FastHashMap方法，意在尽可能的提高处理速度
	 * 
	 * 在FastHashMap中的Value用ArrayList<Long> 记录时间窗内相应各个设备归并前的事件总数
	 * 用ArrayList记录某个单一设备归并前发送过来的事件总数 这些事件数必须统计到一个IP下，所以要用List
	 */
	public static FastHashMap EVENT_AMOUNT_MAP = new FastHashMap();

	/**
	 * value：ArrayList<Integer> 储存同一目的IP对应的不同威胁等级
	 */
	public static FastHashMap THRE_RANK_MAP = new FastHashMap();;

	/**
	 * value：ArrayList<String> 储存同一目的IP对应的不同事件类型
	 */
	public static FastHashMap EventTypeMap = new FastHashMap();
	
	/**
	 * 标识设备的唯一ID
	 */
	public static FastHashMap FACIID = new FastHashMap();

	public static FastHashMap getFACIID(){
		return FACIID;
	}
	
	public static void setFACIID(FastHashMap vFaciId){
		FACIID = vFaciId;
	}
	
	/**
	 * 
	 * getTHRE_RANK_MAP FastHashMap
	 */
	public static FastHashMap getTHRE_RANK_MAP() {

		return THRE_RANK_MAP;
		
	}

	/**
	 * 
	 * setTHRE_RANK_MAP void
	 */
	public static void setTHRE_RANK_MAP(FastHashMap vThre_rank_map) {
		THRE_RANK_MAP = vThre_rank_map;
	}

	/**
	 * 
	 * getEVENT_AMOUNT_MAP Map<String,long[]>
	 */
	public static FastHashMap getEventAmount() {
//		System.out.println("---getEventAmount---" + EVENT_AMOUNT_MAP);
		return EVENT_AMOUNT_MAP;
	}

	/**
	 * 
	 * setEVENT_AMOUNT_MAP void
	 */
	public static void setEventAmount(FastHashMap vEventAmount) {
		EVENT_AMOUNT_MAP = vEventAmount;
//		System.out.println("---setEventAmount(FastHashMap vEventAmount)---" + EVENT_AMOUNT_MAP +"<-->"+vEventAmount);
	}

	/**
	 * 
	 * getEventTypeMap FastHashMap
	 */
	public static FastHashMap getEventTypeMap() {
		return EventTypeMap;
	}

	/**
	 * 
	 * setEventTypeMap void
	 */
	public static void setEventTypeMap(FastHashMap vEventTypeMap) {
		EventTypeMap = vEventTypeMap;
	}

	public static int DEVICECOUNT = 1255;

	// /**
	// *
	// * getAmount long[]
	// */
	// public static long[] getAmount() {
	// return amount;
	// }
	//
	// /**
	// *
	// * setAmount void
	// */
	// public static void setAmount(long[] vAmount) {
	// amount = vAmount;
	// }

	/**
	 * 
	 * getAggreBatch Vector<AggregationEvent>
	 */
	public static synchronized Vector<Eventrealdisp> getAggreBatch(
			Vector<Eventrealdisp> vBatch) {

		int i = AGGREGATEDEVENT.size();
		
//		System.out.println("&&&&&&&&&&&&AGGREGATEDEVENT.size()&&&&&&&&&&&&&&&" + i);
		
		if (i > 0) {
			for (int j = 0; j < i; j++) {
				vBatch.add(AGGREGATEDEVENT.get(j));
			}
			AGGREGATEDEVENT.removeAllElements();
		}
		return vBatch;
	}
	
	public static void clearAggreBatch(){
		AGGREGATEDEVENT.clear();
	}

	/**
	 * 
	 * addAggreEvent void
	 */
	public static synchronized void addAggreEvent(Eventrealdisp vEvent) {
		AGGREGATEDEVENT.add(vEvent);
//		System.out.println("&&&&&&&&&&&&AGGREGATEDEVENT&&&&&&&&&&&&&&&" + AGGREGATEDEVENT.size());
	}

	/**
	 * 
	 * getUploadEventBatch Vector<AggregationEvent>
	 */
	public static synchronized Vector<Eventrealdisp> getUploadEventBatch(
			Vector<Eventrealdisp> vBatch) {

		int i = UPLOADEVENT.size();
		if (i > 0) {
			for (int j = 0; j < i; j++) {
				vBatch.add(UPLOADEVENT.get(j));
			}
			UPLOADEVENT.removeAllElements();
		}
		return vBatch;
	}

	/**
	 * 
	 * addAggreEvent void
	 */
	public static synchronized void addUploadEvent(Eventrealdisp vEvent) {
		UPLOADEVENT.add(vEvent);
	}

	/**
	 * 获得拓扑统计计算事件列表 getStatisEventBatch Vector<TopoStatisticsEvent>
	 */
	public static synchronized Vector<EventFaciip> getStatisEventBatch(
			Vector<EventFaciip> vBatch) {
		int i = TOPOSTICEVENT.size();
//		System.out.println("=========TOPOSTICEVENT.size===========" + i);
		if (i > 0) {
			for (int j = 0; j < i; j++) {
				vBatch.add(TOPOSTICEVENT.get(j));
			}
			TOPOSTICEVENT.removeAllElements();
		}
		return vBatch;
	}

	/**
	 * 添加拓扑统计计算事件 addStatisticsEvent void
	 */
	public static synchronized void addStatisticsEvent(EventFaciip vEvent) {
		TOPOSTICEVENT.add(vEvent);
//		System.out.println("=============TOPOSTICEVENT================" + TOPOSTICEVENT.size());
	}

	////////////////////////////////////////////////////////////////////////////
	// /////////////////

	/**
	 * 获得拓扑统计计算事件列表 getStatisEventBatch Vector<TopoStatisticsEvent>
	 */
	public static synchronized Vector<Eventmoni> getMonitorEventBatch(
			Vector<Eventmoni> vBatch) {
		int i = EVENTMONI.size();

		if (i > 0) {
			for (int j = 0; j < i; j++) {
				vBatch.add(EVENTMONI.get(j));
			}
			EVENTMONI.removeAllElements();
		}
//		System.out.println("---getMonitorEventBatch()---" + vBatch);
		return vBatch;
	}

	/**
	 * 添加拓扑统计计算事件 addStatisticsEvent void
	 */
	public static synchronized void addMonitorEvent(Eventmoni vEvent) {
		EVENTMONI.add(vEvent);
//		System.out.println("?????????????????????addMonitorEvent(Eventmoni vEvent)-??????????????????????+++" + vEvent);
	}

	////////////////////////////////////////////////////////////////////////////
	// ////////////////////////////////

	/**
	 * 获得拓扑统计计算事件列表 getStatisEventBatch Vector<TopoStatisticsEvent>
	 */
	public static synchronized Vector<Eventmoni> getSituationMonitorEventBatch(
			Vector<Eventmoni> vBatch) {
		int i = SITUATIONMONI.size();

		if (i > 0) {
			for (int j = 0; j < i; j++) {
				vBatch.add(SITUATIONMONI.get(j));
			}
			SITUATIONMONI.removeAllElements();
		}
		return vBatch;
	}

	/**
	 * 添加拓扑统计计算事件 addStatisticsEvent void
	 */
	public static synchronized void addSituationMonitorEvent(Eventmoni vEvent) {
		SITUATIONMONI.add(vEvent);
	}

	public static synchronized Timestamp getTime() {
		return TIME;
	}
	
	public static synchronized void addTime(Timestamp vTime){
		TIME = vTime;
	}

}
