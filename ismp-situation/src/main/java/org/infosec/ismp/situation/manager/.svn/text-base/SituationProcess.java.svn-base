package org.infosec.ismp.situation.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.situation.calculate.substep.AttackReckon;
import org.infosec.ismp.situation.calculate.substep.IllicitConnectReckom;
import org.infosec.ismp.situation.calculate.substep.VirusReckon;
import org.infosec.ismp.situation.dao.RecordIndexDao;
import org.infosec.ismp.situation.model.Event;
import org.infosec.ismp.situation.util.ConstantSource;


/**
 * 此线程用来调度先入先出队列。
 * 将收到的报文分组后重新放入一个新的先入先出队列。
 * @author cc
 * 2010-10-11 16:48:11
 */
public class SituationProcess extends Thread {
	
	private int columnNum = 0;///将事件按照分析时间分组后，用columnNum来统计一组内事件的数量。
	
	private Timestamp time;///开始分组时间
	
	private Timestamp lastTime;///上次list的最后一组时间
	
	private int index = 1;
	
	private long analyseTime = ConstantSource.ANALYSETIME;///数据分析时间间隔
	
	private static boolean flag = true;///标志位
	
	/**
	 * 记录指针Dao
	 */
	private RecordIndexDao recordIndexDao;
	
	public void setRecordIndexDao(RecordIndexDao recordIndexDao) {
		this.recordIndexDao = recordIndexDao;
	}

	/**
	 * 注入病毒计数计算器
	 */
	private VirusReckon virusReckon;

	public void setVirusReckon(VirusReckon virusReckon) {
		this.virusReckon = virusReckon;
	}

	/**
	 * 注放非法连接计数计算器
	 */
	private IllicitConnectReckom illicitConnectReckom;

	public void setIllicitConnectReckom(
			IllicitConnectReckom illicitConnectReckom) {
		this.illicitConnectReckom = illicitConnectReckom;
	}

	/**
	 * 攻击计数计算器
	 */
	private AttackReckon attackReckon;

	public void setAttackReckon(AttackReckon attackReckon) {
		this.attackReckon = attackReckon;
	}
	
	private SituationSaveToDB situationSaveToDB;

	public void setSituationSaveToDB(SituationSaveToDB situationSaveToDB) {
		this.situationSaveToDB = situationSaveToDB;
	}
	
	///先入先出队列(线程安全)：这个队列用来存分组前收集到的事件。
	private BlockingQueue<Event> queueEvent;
	
	private ArrayList<Event> listEvent = new ArrayList<Event>();///解析数据报中的事件数据，存放到listEvent(有序)。
	
	private long startTime;

	private long endTime;

	private int eventId = 0;

	private int recordId;
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public void setQueueEvent(BlockingQueue<Event> queueEvent) {
		this.queueEvent = queueEvent;
	}
	
	public void init() {
//		Timestamp time2 = null;
//		List<RecordIndex> recordIndexs = recordIndexDao.getAll();///获取读取位置表类集合(集合中只有最后一条读取位置)
//		Timestamp time1 = eventDao.getEventsStartTime();///取得最早的事件发生时间
//		if (recordIndexs != null && recordIndexs.size() > 0) {
//			RecordIndex recordIndex = recordIndexs.get(0);///取得最后的一条读取位置记录
//			recordId = recordIndex.getId();
//			eventId = recordIndex.getColumnNumber();///取得表读取位置，赋值给eventId
//			time2 = recordIndex.getTime();///取得表读取位置表类的时间
//			if (recordId>0) {
//				situationSaveToDB.setRecordId(recordId);
//			}
//		} else {
//			eventId = 0;///如果读取位置表集合中没有数据，则eventId为0
//		}
//		
//		///将最早的事件发生时间 和 最后一条表读取位置表的时间比较后，最晚的那个赋值给time
//		if (time1 != null || time2 != null) {
//			if (time1 != null && time2 != null) {
//				if (time1.getTime() > time2.getTime()) {
//					time = time1;
//				} else {
//					time = time2;
//				}
//			} else if (time1 != null && time2 == null) {
//				time = time1;
//			}else if (time1==null && time2 !=null) {
//				time = new Timestamp(System.currentTimeMillis());
//			}
//		} else {
//			///如果两个时间都为null，则选取当前时间。
//			time = new Timestamp(System.currentTimeMillis());
//		}
	}
	
	@Override
	public void run() {
		try {
			Event firstEvent = queueEvent.take();///取出队列中的第一个事件
			time = firstEvent.getTime();///第一个事件的时间。
			listEvent.add(firstEvent);
			Timer timer = new Timer();///计时器
		    timer.schedule(new TimerTask() {
		          public void run() {
		             flag = !flag;///延迟一分钟之后每隔一分钟改变一次
		             System.out.println("此时标志位为 ：" + flag );
		          }
		    }, 1000*20, 1000*20);///30秒之后改变：下次改变是10分钟,为了测试，以后用常量来代替
			while(true){
				if(flag){
//					System.out.println("消费一个事件");
					///tack()是线程安全的。获取并移除此队列的头部，在元素变得可用之前一直等待
					Event _event = queueEvent.take();///取出队列中的一个事件
//					long startRange = time.getTime();
//					long endRange = time.getTime() + 60000;
//					listEvent = getListEventByTime(startRange,endRange);
					listEvent.add(_event);
				} else if(null != listEvent && listEvent.size() > 0) {
//					time = listEvent.get(0).getTime();
					if(null == lastTime){
//						time = listEvent.get(0).getTime();
						time = new Timestamp(listEvent.get(0).getTime().getTime()-1000);///这批事件的起始时间。
					}else if(lastTime.getTime() <= listEvent.get(0).getTime().getTime()){
						time = lastTime ;
					}else {
						time = new Timestamp(listEvent.get(0).getTime().getTime()-1000);///这批事件的起始时间。
					}
//					endTime = time.getTime()-1000;///这批事件的起始时间。
					endTime = time.getTime();///这批事件的起始时间。
					for (int i = 0; i < listEvent.size(); i++) {
						Event event = listEvent.get(i);///依次取出某个事件。
						startTime = event.getTime().getTime();///这个事件的发生时间。
						if ((startTime - endTime) <= analyseTime) {///小于等于分析时间，则说明分到当前组。
//							time = event.getTime();///cc:将这个事件的发生时间赋值给time?
							columnNum++;///分组内 事件数量计数器。
							int type = event.getType();///判断这个事件的类型。根据事件类型选择对应的计算器。
							switch (type) {
							case 1:
								attackReckon.analyzeEvent(event);///分析事件：将攻击事件的优先级和IP放入hashmap里。
								break;
							case 2:
								virusReckon.analyzeEvent(event);///分析事件：将病毒事件的优先级和IP放入hashmap里。
								break;
							case 3:
								illicitConnectReckom.analyzeEvent(event);///分析事件：将非法连接事件的优先级和IP放入hashmap里。
								break;
							}
						} else {///大于分析时间，则说明这个事件已经不属于当前分组，一轮分组结束。
							attackReckon.reckonExponential(time, index);///计算攻击指数
							virusReckon.reckonExponential(time, index);///计算病毒指数
							illicitConnectReckom.reckonExponential(time, index);///计算非法连接指数
							long t1 = startTime - endTime;///当前事件与这批事件起始时间的相差毫秒数。(这里的相差毫秒数肯定大于一个分析时间)
							t1 = t1 % analyseTime;///超出单位分析时间的部分。
							endTime = startTime - t1;///分组中最后一个事件的发生时间-这个事件超出单位分析时间的部分=分组的截止时间。
							time = new Timestamp(endTime);///将这个分组的截止时间（倍数）赋值给time，作为下个分组的起始时间。
							i--;///如果不i--，每次分组计算一次态势则会错过一个事件。因为此时当前的事件已经是下个分组的第一个事件了。
							log.info("生成第" + index + "次运算！！！");
							index++;///每计算一次，index加1
							columnNum = 0;///分组内事件计数器清零。下个分组开始
						}
						if(i == (listEvent.size()-1)){
							lastTime = time;///保存最后一次分组的最后时间
							listEvent.clear();
							
						}
					}
				}
			    
				
//				if(listEvent.size() >= ConstantSource.LISTSIZE){
////					
//					
//				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
