/**
 * 上海交通大学
 */
package org.infosec.ismp.manager.server.event.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.FastHashMap;
import org.infosec.ismp.manager.rmi.event.dao.IEventGetTopoDao;
import org.infosec.ismp.manager.rmi.event.dao.IEventmoniDao;
import org.infosec.ismp.manager.rmi.event.dao.IEventrealdispDao;
import org.infosec.ismp.manager.rmi.event.dao.impl.EventGetTopoDao;
import org.infosec.ismp.manager.rmi.event.dao.impl.EventmoniDao;
import org.infosec.ismp.manager.rmi.event.dao.impl.EventrealdispDao;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.rmi.event.util.EventConstants;
import org.infosec.ismp.manager.server.event.util.Constants;
import org.springframework.transaction.annotation.Transactional;

/**
 * 处理后事件入库以及从数据库去数据
 * 
 * @author Jianyu Shen
 * 
 *         2009-6-19 上午11:00:00
 */
public class EventSaveToDB {

	public EventSaveToDB() {
		init();
	}

	private IEventrealdispDao eventrealdispDao;

	private IEventmoniDao eventmoniDao;

	private IEventGetTopoDao eventGetTopoDao;
	
	private EventFilter eventFilter;

	public void setEventrealdispDao(EventrealdispDao vEventrealdispDao) {
//		System.out.println("set eventrealdispDao+++++++++++++++");
		this.eventrealdispDao = vEventrealdispDao;
	}

	public void setEventmoniDao(EventmoniDao vEventmoniDao) {
//		System.out.println("set eventmoniDao==================");
		this.eventmoniDao = vEventmoniDao;
	}

	public void setEventGetTopoDao(EventGetTopoDao vGetTopoDao) {
//		System.out.println("set topoEventDao+++++++++++++++");
		this.eventGetTopoDao = vGetTopoDao;
	}
	
	public void setEventFilter(EventFilter vEventFilter){
		this.eventFilter = vEventFilter;
	}

	public static List<Eventrealdisp> realdispEventBatch = new ArrayList<Eventrealdisp>(); // 实时事件存储控制时临时存放的地方
	public static List<Eventmoni> moniEventBatch = new ArrayList<Eventmoni>(); // 统计计算事件存储控制时临时存放的地方
	public static List<Object> topoInfos = new ArrayList<Object>(); // 存储拓扑数据库表中提取出来的设备IP和MAC地址
	public static List<Object> totalValue; // 存放从数据库取得的日总量
	public static FastHashMap topoInfosToMap = new FastHashMap();

	List<Object> topos = new ArrayList<Object>();

	long timeReal = 0;
	long timeMoni = 0;

	/**
	 * 保存实时显示事件入库，控制存储策略 saveRealDispEventList void
	 */
	public void saveRealDispEventList(List<Eventrealdisp> realEvents) {

		realdispEventBatch.addAll(realEvents);
		if (realdispEventBatch.size() > 600) {
			eventrealdispDao.add(realdispEventBatch);
			timeReal = System.currentTimeMillis();
			realdispEventBatch.clear();
			EventConstants.clearAggreBatch();
		} else if ((System.currentTimeMillis() - timeReal) > 60000) {
			eventrealdispDao.add(realdispEventBatch);
			timeReal = System.currentTimeMillis();
			realdispEventBatch.clear();
			EventConstants.clearAggreBatch();
		}

	}

	/**
	 * 保存统计计算事件入库，控制存储策略 saveMoniEventList void
	 */
//	@Transactional(propagation=)
	public void saveMoniEventList(List<Eventmoni> moniEvents) {
	
		moniEventBatch.addAll(moniEvents);
		if (moniEventBatch.size() > 600) {
			eventmoniDao.add(moniEventBatch);
			timeMoni = System.currentTimeMillis();
			moniEventBatch.clear();
		} else if ((System.currentTimeMillis() - timeMoni) > 60000) {
			eventmoniDao.add(moniEventBatch);
			timeMoni = System.currentTimeMillis();
			moniEventBatch.clear();
		}
	}
	

	public List<Object> getTopoFromDB() {
//		System.out.println("test DB per 1 sec");
		topoInfos.clear();
		topoInfos = eventGetTopoDao.getTopoInfo();
		eventFilter.setTopoEvents(topoInfos);
		if (topoInfos != null && topoInfos.size()>0) {
			for (int i=0;i<topoInfos.size();i++) {
				Object[] obj = (Object[]) topoInfos.get(i); 
				String key = obj[0].toString().trim()+":"+obj[4].toString().trim();
				topoInfosToMap.put(key, obj);
			}
		}
		return topoInfos;
	}

	/**
	 * 系统启动后第一次取得topo的IP和MAC
	 * @return
	 */
	public List<Object> getTopoEventInfo() {

		if (topoInfos.isEmpty()) {
//			System.out.println("topo info is null, no topo info");
			topoInfos = eventGetTopoDao.getTopoInfo();
			topos = topoInfos;
			if (topoInfos != null && topoInfos.size()>0) {
				for (int i=0;i<topoInfos.size();i++) {
					Object[] obj = (Object[]) topoInfos.get(i); 
					String key = obj[0].toString().trim()+":"+obj[4].toString().trim();
					topoInfosToMap.put(key, obj);
				}
			}
//			System.out.println("topo size isssssssssssssssssssssssssssss " + topos.size());
		} else {
			topos = topoInfos;
		}
		return topos;
	}
	
	//-------2010-7-13新增-------------
	public void getUpdateTopoToMap() {
		if (!topoInfosToMap.isEmpty()) {
			topoInfosToMap.clear();
			List<Object> list = eventGetTopoDao.getTopoInfo();
			if (list != null && list.size()>0) {
				for (int i=0;i<list.size();i++) {
					Object[] obj = (Object[]) list.get(i); 
					String key = obj[0].toString().trim()+":"+obj[4].toString().trim();
					topoInfosToMap.put(key, obj);
				}
			}
		}
	}
	
	public FastHashMap getTopoToMap() {
//		System.out.println("*******EventSaveToDB.topoInfosToMap.isEmpty()******"+topoInfosToMap.isEmpty());
//		System.out.println("*******EventSaveToDB.topoInfosToMap******"+topoInfosToMap);
		if (topoInfosToMap.isEmpty()) {
			List<Object> list = eventGetTopoDao.getTopoInfo();
			
//			System.out.println("*******EventSaveToDB.list****"+list);
			
			if (list != null && list.size()>0) {
				for (int i=0;i<list.size();i++) {
					Object[] obj = (Object[]) list.get(i); 
					String key = obj[0].toString().trim()+":"+obj[4].toString().trim();
					topoInfosToMap.put(key, obj);
				}
			}
		}
//		System.out.println("*******EventSaveToDB.topoInfosToMap**end****"+topoInfosToMap);
		return topoInfosToMap;
	}

	public void getTotalValueFromDB() {
		if (totalValue == null) {
//			System.out.println("nullllllllll");
		} else {
//			System.out.println("topo not nullllllllll");
			totalValue.clear();
			totalValue = null;
			Constants.addTotalValue(totalValue);
		}
	}

	public void init() {
		getTotalValueFromDB();
	}
}