package org.infosec.ismp.collectd.services;

import org.infosec.ismp.collectd.snmp.SysObjectIdTracker;
import org.infosec.ismp.snmp.SnmpAgentConfig;
import org.infosec.ismp.snmp.SnmpUtils;
import org.infosec.ismp.snmp.SnmpWalker;

/**
 * test node if snmp service is available
 * @author lianglin
 *
 */
public class SnmpAvailabler implements Runnable {

	private SnmpAgentConfig m_agentConfig;

	private volatile boolean m_available = false;
	
	

	public SnmpAvailabler(SnmpAgentConfig agentConfig) {
		this.m_agentConfig =agentConfig;
	}

	@Override
	public void run() {
		SysObjectIdTracker tracker = new SysObjectIdTracker();
		SnmpWalker walker = SnmpUtils.createWalker(m_agentConfig,
				"availabeTest", tracker);
		walker.start();
		try {
			walker.waitFor(60 * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!tracker.failed())
			m_available = true;

	}

	public boolean isAvailable() {
		return m_available;
	}
	
	

}
