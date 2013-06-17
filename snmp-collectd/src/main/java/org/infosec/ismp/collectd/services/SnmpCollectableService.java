package org.infosec.ismp.collectd.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.collectd.snmp.tracker.GenericColumnTracker;
import org.infosec.ismp.collectd.snmp.tracker.SnmpCollectionDispatcher;
import org.infosec.ismp.collectd.snmp.tracker.SnmpTableTracker;
import org.infosec.ismp.model.snmp.Result;
import org.infosec.ismp.model.snmp.Results;
import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.infosec.ismp.snmp.SnmpUtils;
import org.infosec.ismp.snmp.SnmpWalker;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.scheduler.ReadyRunnable;
import org.infosec.ismp.util.scheduler.Schedule;

public class SnmpCollectableService implements ReadyRunnable {

	private Schedule m_schedule;

	/**
	 * delete flag
	 */
	private volatile boolean m_deleted = false;

	private volatile boolean m_collectFailed = false;

	private volatile long m_lastSuccessTime = -1L;

	private SnmpAgentConfig m_agentConfig;

	private SnmpNetwork m_network;


	public SnmpCollectableService(SnmpAgentConfig agentConfig,
			SnmpNetwork network) {
		this.m_agentConfig = agentConfig;
		this.m_network = network;
	}

	private AggregateTracker[] m_trackers = null;

	public void onInit() {
		SnmpCollectionDispatcher dispatcher = new SnmpCollectionDispatcher(
				m_agentConfig.getAddress());
		m_trackers = dispatcher.getAggregateTrackers(m_agentConfig.getType(),m_agentConfig.getBrand());
	}

	@Override
	public void run() {
		if (m_trackers == null || m_trackers.length == 0) {
			log().warn("不支持该类型");
			return;
		}
		SnmpWalker walker = SnmpUtils.createWalker(m_agentConfig,
				"snmpInfoCollectd", m_trackers);
		walker.start();
		try {
			walker.waitFor(60 * 1000);
		} catch (InterruptedException e) {
			log().debug("waler.waitfor exception " + e);
		}
		Results results = new Results();
		for (AggregateTracker tracker : m_trackers) {
			Result mssage = new Result();
			if (!tracker.failed()) {
				if (tracker instanceof SnmpTableTracker) {
					SnmpTableTracker t = (SnmpTableTracker) tracker;
					List<Map<String, Object>> result = t.getStoreResult();
					mssage.setListResults(result);
					mssage.setTrackerName(t.getTrackerName());
				} else if (tracker instanceof GenericColumnTracker) {
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					GenericColumnTracker t = (GenericColumnTracker) tracker;
					Map<String, Object> result = t.getStoreResult();
					list.add(result);
					mssage.setListResults(list);
					mssage.setTrackerName(t.getTrackerName());
				} else {
					throw new RuntimeException(
							"not support tracker,please check");
				}
			}else{
				System.out.println("AggregateTracker collect failed");
				m_collectFailed = true;
			}
			results.addResult(mssage);
		}
		results.setNodeid(m_agentConfig.getNodeid());
		results.setType(m_agentConfig.getType());
		results.setBrand(m_agentConfig.getBrand());
		results.setIpAddr(m_agentConfig.getAddress().getHostAddress());
		m_network.getSnmpContext().dispatch(results);
	}

	@Override
	public boolean isReady() {
		return true;
	}

	/**
	 * 将该服务放入调度池中
	 */
	public void schedule() {
		if (m_schedule == null)
			throw new IllegalStateException(
					"Cannot schedule a service whose schedule is set to null");

		m_schedule.schedule();
	}

	/**
	 * 取消该服务
	 */
	public void delete() {
		if (m_schedule == null)
			throw new IllegalStateException(
					"Cannot unschedule a service whose schedule is set to null");
		m_schedule.unschedule();
		m_deleted = true;
	}

	/**
	 * 判断snmp是否可达
	 * 
	 * @return
	 */
	public boolean isSnmpAvailable() {
		SnmpAvailabler availabler = new SnmpAvailabler(m_agentConfig);
		availabler.run();
		return availabler.isAvailable();
	}

	////////////////////////////////////////////////////////////////////////////
	public Schedule getSchedule() {
		return m_schedule;
	}

	public void setSchedule(Schedule schedule) {
		m_schedule = schedule;
	}

	public boolean isDeleted() {
		return m_deleted;
	}

	public boolean isCollectFailed() {
		return m_collectFailed;
	}

	public long getLastSuccessTime() {
		return m_lastSuccessTime;
	}

	public SnmpAgentConfig getAgentConfig() {
		return m_agentConfig;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
