package org.infosec.ismp.collectd;

import org.infosec.ismp.collectd.services.SnmpCollectableConfig;
import org.infosec.ismp.collectd.services.SnmpCollectableService;
import org.infosec.ismp.collectd.services.SnmpNetwork;
import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.LegacyScheduler;
import org.infosec.ismp.util.scheduler.Schedule;
import org.infosec.ismp.util.scheduler.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
@Component
public class SnmpCollectd extends AbstractServiceDaemon {

	private Scheduler m_scheduler;// 调度器

	private int m_threads = -1;
	private SnmpNetwork m_snmpNetwork;

	public static String LOG_CATEGORY = "Ismp.SnmpCollectd";

	public SnmpCollectd() {
		super(LOG_CATEGORY);
	}

	@Override
	protected void onInit() {
		Assert.state(m_threads>0,"请检查threads是否设定");
		Assert.notNull(m_snmpNetwork,
				"please set m_snmpNetwork,it must not be null");

		createScheduler();

	}


	//执行SNMP设备采集轮询操作
	public void scheduleSnmpNode(SnmpAgentConfig agentConfig){

		SnmpCollectableService svc = m_snmpNetwork.createSnmpCollectableService(agentConfig);
		SnmpCollectableConfig config = new SnmpCollectableConfig(svc);
		Schedule schedule = new Schedule(svc, config, getScheduler());
        svc.setSchedule(schedule);
        svc.onInit();
        svc.schedule();
	}
	
	
	public void unscheduleSnmpService(String nodeid){
		SnmpCollectableService svc = m_snmpNetwork.getSnmpCollectableService(nodeid);
		if(svc!=null){
			svc.delete();
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
			new BroadcastEventProcessor(this);
		}catch (Exception ex) {
			log().error("Failed to setup event reader", ex);
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

	private void createScheduler() {
		ThreadCategory log = log();
		// Create a scheduler
		try {
			log.debug("init: Creating snmp collectd scheduler");

			setScheduler(new LegacyScheduler("snmp collectd", m_threads));
		} catch (RuntimeException e) {
			log.fatal("init: Failed to create poller scheduler", e);
			throw e;
		}
	}

	// //////////////////////////

	public Scheduler getScheduler() {
		return m_scheduler;
	}

	public void setScheduler(Scheduler scheduler) {
		m_scheduler = scheduler;
	}
	
	@Autowired(required=true)
	public void setSnmpNetwork(SnmpNetwork snmpNetwork) {
		m_snmpNetwork = snmpNetwork;
	}

	public SnmpNetwork getSnmpNetwork() {
		return m_snmpNetwork;
	}

	public int getThreads() {
		return m_threads;
	}

	public void setThreads(int threads) {
		m_threads = threads;
	}

	
	
	

}
