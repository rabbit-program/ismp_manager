/**
 * 
 */
package org.infosec.ismp.manager.server.event.process;

import java.util.List;

import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.manager.rmi.aim.service.SendAlertService;
import org.infosec.ismp.manager.rmi.event.modle.EventFaciip;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;
import org.infosec.ismp.manager.server.event.eventstream.AggregationEvent;
import org.infosec.ismp.manager.server.event.listener.AggregationEventListener;
import org.infosec.ismp.manager.server.event.listener.AlertEventListener;
import org.infosec.ismp.manager.server.event.listener.ComplexEventListener;
import org.infosec.ismp.manager.server.event.listener.EventFaciListener;
import org.infosec.ismp.manager.server.event.listener.NormalizedEventListener;
import org.infosec.ismp.manager.server.event.util.ConfigContent;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 * eql查询语句，系统启动后加载
 * 
 * @author Jianyu Shen
 * 
 *         2009-6-2 上午09:47:44
 */
public class EventProcessAgent {
	private EPServiceProvider esperEngine; // 实例化esper事件流处理引擎

	public List<Object> totalValue; // 存放从数据库取得的日总量
	
	private EventSaveToDB eventSaveToDB;

	public void setEventSaveToDB(EventSaveToDB eventSaveToDB) {
		// System.out.println("set eventSaveToDB!!!!!!!!!!!!!");
		this.eventSaveToDB = eventSaveToDB;
	}

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
	 * @return the totalValue
	 */
	public List<Object> getTotalValue() {
		return totalValue;
	}

	/**
	 * @param vTotalValue
	 *            the totalValue to set
	 */
	public void setTotalValue(List<Object> vTotalValue) {
		totalValue = vTotalValue;
	}

	/**
	 * 事件处理算法
	 * 
	 * @param complexEventListener
	 */
	public EventProcessAgent(ComplexEventListener complexEventListener) {
		Configuration config = new Configuration();
		complexEventListener.onComplexEvent("----");
		config.addEventType("NormalizedEvent", NormalizedEvent.class);
		config.addEventType("AggregationEvent", AggregationEvent.class);
		config.addEventType("Eventrealdisp", Eventrealdisp.class);
		config.addEventType("EventFaciip", EventFaciip.class);
		// config.addEventType("TopoInfoEvent", TopoInfoEvent.class);
		// config.addEventType("Eventmoni", Eventmoni.class);
		// situation
//		config.addEventType("Event", Event.class);
//		config.addEventType("Virus", Virus.class);
		esperEngine = EPServiceProviderManager.getDefaultProvider(config);
		// situation
//		IndexData.epService = esperEngine;
//		System.out.println("Esper Engine is " + esperEngine);
	}

	public void init(ComplexEventListener complexEventListener) {

		EPStatement statment;
		String stmt;

		totalValue = getTotalValue();

		// stmt =
		// "select *,count(*) as countPerType from NormalizedEvent.win:time_batch(10 sec) group by dest_ip"
		// ; // eql处理语句
		// ，
		// 用于将归一化事件按目标IP分类
		// stmt =
		// "select count(*) as amount from NormalizedEvent.win:time_batch(10 sec)"
		// ;
		// statment = esperEngine.getEPAdministrator().createEQL(stmt);
		// statment
		// .addListener(new NormalizedEventListener(complexEventListener));
		// //添加事件监听器
		
		stmt = "insert into AlertEvent select *, count(*) as countPerType from NormalizedEvent.win:time_batch("
				+ ConfigContent.insertTime
				+ " sec)";
		statment = esperEngine.getEPAdministrator().createEPL(stmt);
		statment.addListener(new NormalizedEventListener(complexEventListener,eventSaveToDB)); // 添加事件监听器

		stmt = "select * from AlertEvent where AlertEvent.threrank > 3 group by srcip, destip, messageType";
		statment = esperEngine.getEPAdministrator().createEPL(stmt);
		statment.addListener(new AlertEventListener(complexEventListener,sendAlertService,eventSaveToDB));

		// 查找源或目的IP中相同的IP，并把它作为设备IP耦合在一起，进行统计计算
		// stmt =
		// "insert into EventDestip select dest_ip as faci_ip, count(*) as countPerType from Eventrealdisp.win:time_batch(8 sec) group by dest_ip"
		// ;

		stmt = "select srcIp as faciIp, eventTime,domain, count(*) as countPerType from Eventrealdisp.win:time_batch("
				+ ConfigContent.faciListenerTime + " sec) group by srcIp";
		statment = esperEngine.getEPAdministrator().createEPL(stmt);
		statment.addListener(new EventFaciListener(complexEventListener));
		stmt = "select destIp as faciIp, eventTime,domain, count(*) as countPerType from Eventrealdisp.win:time_batch("
				+ ConfigContent.faciListenerTime + " sec) group by destIp";
		statment = esperEngine.getEPAdministrator().createEPL(stmt);
		statment.addListener(new EventFaciListener(complexEventListener));
		// stmt =
		// "insert into EventSrcip select *, count(*) as countPerType from Eventrealdisp.win:time_batch(8 sec) group by src_ip"
		// ;
		// stmt =
		// "select (a.countPerType + b.countPerType) as counts from pattern [ every a=EventDestip -> b=EventSrcip(a.faci_ip = b.faci_ip)]"
		// ;
		stmt = "select *, count(*) as countts from EventFaciip.win:time_batch("
				+ ConfigContent.aggreListenerTime + " sec) group by faci_ip,bureauId";
		statment = esperEngine.getEPAdministrator().createEPL(stmt);

		// 向AggregationEventListener里传事件总量列表，totalValue是从数据库里读取的值，要通过DAO的调用
		AggregationEventListener aggreListener = new AggregationEventListener(
				complexEventListener);
		if (totalValue == null) {
			// System.out.println("nullllllllllllllllllllllllll");
		} else {
			aggreListener.setTotalValue(totalValue);
		}

		statment.addListener(aggreListener);

		// statment.addListener(new
		// AggregationEventListener(complexEventListener));

		////////////////////////////////////////////////////////////////////////
		// /
		// /////////////////////////////////////////////////////////////////////
		// ////
		// 后面还有一个eql处理
		// 把上面统计得到的事件Eventmoni还要再取过来，参与处理
		//
		// 因为有可能这边拿到的数据在系统的拓扑统计信息里不存在，这样的事件要丢弃，所以还要再处理一次，重新封装到Eventmoni里，
		// 最后传给web及入库
		// 拓扑另生成一个表，只有faci_ip，表名TopoInfo；
		// stmt =
		// "select * from Eventmoni.win:time_batch(8 sec) as aa inner join TopoInfoEvent.win:keepall().std:unique(faci_ip) as bb on bb.faci_ip = aa.faci_ip"
		// ;
		// stmt =
		// "select * from Eventmoni.win:time_batch(4 sec) where faci_ip in (select faci_ip from TopoInfoEvent.std:unique(faci_ip))"
		// ;
		// stmt = "select * from TopoInfoEvent.win:time_batch(4 sec)";
		// statment = esperEngine.getEPAdministrator().createEPL(stmt);
		// statment.addListener(new TopoFilterListener(complexEventListener));
		//
	}

	public void sendEvent(Object event) {
		esperEngine.getEPRuntime().sendEvent(event); // 送esper引擎处理
	}

}
