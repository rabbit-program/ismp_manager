package org.infosec.ismp.ping;

import java.lang.reflect.UndeclaredThrowableException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.LegacyScheduler;
import org.infosec.ismp.util.scheduler.Schedule;
import org.infosec.ismp.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * ping服务的管理组件
 * 
 * @author lianglin
 * 
 */
@Component(value="pingd")
public class Pingd extends AbstractServiceDaemon {

	private final static String LOG4J_CATEGORY = "ISMP.Pinger";
	private HashMap<String, PingdService> scheduleMap = new HashMap<String, PingdService>();
	private Scheduler m_scheduler;// 调度器
	private PingdMessageSend pingdsend;

	private int m_threads = 0;
	public Pingd() {
		super(LOG4J_CATEGORY);
	}

	@Autowired(required=true)
	public void setPingdsend( @Qualifier("pingdSend")PingdMessageSend pingdsend) {
		this.pingdsend = pingdsend;
	}
	@Override
	protected void onInit() {
		Assert.state(m_threads>0,"请检查,hreads没有赋值");
		log().debug("init: init pingd component");
		createScheduler();
		
		
	}

	/**
	 * 添加一个需要ping的地址
	 * 
	 * @param nodeid
	 * @param ipAddr
	 * @param interval
	 * @param halfIntervalWhenDown
	 */
	public void ping(String nodeid, String ipAddr, long interval,
			boolean halfIntervalWhenDown) {
		log().debug("nodeid:"+nodeid+"ipAddr:"+ipAddr+"interval:"+interval+"进入Pingd类的ping方法");
		InetAddress iaip;
		try {
			iaip = InetAddress.getByName(ipAddr);
		} catch (UnknownHostException e) {
			log().error("IP地址输入不正确！", e);
			return;			
		}
		PingdService pdService = new PingdService();
		PingdModel pingdModel = new PingdModel();
		pingdModel.setIpAddr(ipAddr);
		pingdModel.setIpInetAddr(iaip);
		pingdModel.setNodeid(nodeid);
		PingdConfig pdConfig = new PingdConfig();
		pdConfig.setInterval(interval);				
		if (scheduleMap.containsKey(nodeid)) {
//			pdService = scheduleMap.get(nodeid);
//			pdService.delete();
			log().error("该nodeid已存在！请重新输入！");
			return;	
		}
		pdService.setPingdmodel(pingdModel);
		pdService.setPingdsend(pingdsend);
		pdService.setConfig(pdConfig);
		pdService.setHalfIntervalWhenDown(halfIntervalWhenDown);
		Schedule schedule = new Schedule(pdService, pdConfig, m_scheduler);
		pdService.setSchedule(schedule);
		pdService.schedule();		
		scheduleMap.put(nodeid, pdService);
	}

	/**
	 * 取消一个曾经添加的ping需求。
	 * 
	 * @param nodeid
	 */
	public void unping(String nodeid) {
		if (scheduleMap.containsKey(nodeid)) {
			PingdService pdService = scheduleMap.get(nodeid);
			pdService.delete();
			scheduleMap.remove(nodeid);
			log().debug(" 取消一个曾经添加的ping需求！nodeId:"+nodeid);
		}else
		{
			log().debug("该nodeId:"+nodeid+"不存在服务中！");
		}
	}

	private void createScheduler() {
		ThreadCategory log = log();
		// Create a scheduler
		try {
			log.debug("init: Creating "+LOG4J_CATEGORY+" scheduler");

			setScheduler(new LegacyScheduler(LOG4J_CATEGORY, m_threads));
		} catch (RuntimeException e) {
			log.fatal("init: Failed to create "+LOG4J_CATEGORY+" scheduler", e);
			throw e;
		}
	}
	@Override
	protected void onStart() {
		try {
			if (log().isDebugEnabled())
				log().debug("start: Starting snmp collectd scheduler");

			getScheduler().start();			
		} catch (RuntimeException e) {
			if (log().isEnabledFor(ThreadCategory.Level.FATAL))
				log().fatal("start: Failed to start scheduler", e);
			throw e;
		}
		
		try{
			BroadcastEventProcessor processor = new BroadcastEventProcessor(this);
		}catch (Exception ex) {
			log().error("Failed to setup event reader", ex);
//			throw new UndeclaredThrowableException(ex);
		}
	}

	@Override
	protected void onStop() {
		if (log().isDebugEnabled())
			log().debug("stop: stoping snmp collectd scheduler");
		if (getScheduler() != null) {
			getScheduler().stop();
		}
	}

	public Scheduler getScheduler() {
		return m_scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		m_scheduler = scheduler;
	}

	public int getThreads() {
		return m_threads;
	}

	public void setThreads(int threads) {
		m_threads = threads;
	}
	
	
}
