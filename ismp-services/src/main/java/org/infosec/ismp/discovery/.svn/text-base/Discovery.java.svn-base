//
// This file is part of the OpenNMS(R) Application.
//
// OpenNMS(R) is Copyright (C) 2002-2009 The OpenNMS Group, Inc.  All rights reserved.
// OpenNMS(R) is a derivative work, containing both original code, included code and modified
// code that was published under the GNU General Public License. Copyrights for modified 
// and included code are below.
//
// OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
//
// Modifications:
//
// 2009 Oct 01: test for null interface in handleInerfaceDeleted. - ayres@opennms.org
// 2003 Oct 21: Fixed typo in variable name.
// 2003 Jan 31: Cleaned up some unused imports.
//
// Original code base Copyright (C) 1999-2001 Oculan Corp.  All rights reserved.
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.                                                            
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
//       
// For more information contact: 
//      OpenNMS Licensing       <license@opennms.org>
//      http://www.opennms.org/
//      http://www.opennms.com/
//
// Tab Size = 8
//

package org.infosec.ismp.discovery;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventBuilder;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventForwarder;
import org.infosec.ismp.ping.Pinger;
import org.springframework.util.Assert;

/**
 * 
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class Discovery extends AbstractServiceDaemon {

	/**
	 * The callback that sends newSuspect events upon successful ping response.
	 */
	private static final DiscoveryPingResponseCallback cb = new DiscoveryPingResponseCallback();

	private static final int PING_IDLE = 0;
	private static final int PING_RUNNING = 1;
	private static final int PING_FINISHING = 2;

	/**
	 * The SQL query used to get the list of managed IP addresses from the database
	 */
	private static final String ALL_IP_ADDRS_SQL = "SELECT DISTINCT ipAddr FROM ipInterface WHERE isManaged <> 'D'";

	/**
	 * a set of devices to skip discovery on
	 */
	private final Set<String> m_alreadyDiscovered = Collections
			.synchronizedSet(new HashSet<String>());

	private Timer m_timer;

	private int m_xstatus = PING_IDLE;

	private volatile EventForwarder m_eventForwarder;

	public void setEventForwarder(EventForwarder eventForwarder) {
		m_eventForwarder = eventForwarder;
	}

	public EventForwarder getEventForwarder() {
		return m_eventForwarder;
	}

	/**
	 * Constructs a new discovery instance.
	 */
	public Discovery() {
		super("OpenNMS.Discovery");
	}

	@Override
	protected void onInit() throws IllegalStateException {

		Assert.state(m_eventForwarder != null,
				"must set the eventForwarder property");

		try {
			initializeConfiguration();
			EventIpcManagerFactory.init();
		} catch (Exception e) {
			log().debug("onInit: initialization failed: " + e, e);
			throw new IllegalStateException(
					"Could not initialize discovery configuration.", e);
		}
	}

	private void initializeConfiguration() throws MarshalException,
			ValidationException, IOException {
		// TODO
	}

	private void doPings() {
		debugf("starting ping sweep");

		try {
			initializeConfiguration();
		} catch (Exception e) {
			log().error(
					"doPings: could not re-init configuration, continuing with in memory configuration."
							+ e, e);
		}

		m_xstatus = PING_RUNNING;

		for (IPPollAddress pollAddress : getDiscoveryFactory()
				.getConfiguredAddresses()) {
			if (m_xstatus == PING_FINISHING || m_timer == null) {
				m_xstatus = PING_IDLE;
				return;
			}
			ping(pollAddress);
			try {
				// FIXME
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}

		debugf("finished discovery sweep");
		m_xstatus = PING_IDLE;
	}

	private void ping(IPPollAddress pollAddress) {
		InetAddress address = pollAddress.getAddress();
		if (address != null) {
			if (!isAlreadyDiscovered(address)) {
				try {
					Pinger.ping(address, pollAddress.getTimeout(),
							pollAddress.getRetries(), (short) 1, cb);
				} catch (Exception e) {
					debugf(e, "error pinging %s", address.getAddress());
				}
			}
		}
	}

	private boolean isAlreadyDiscovered(InetAddress address) {
		if (m_alreadyDiscovered.contains(address.getHostAddress())) {
			return true;
		}
		return false;
	}

	private void startTimer() {
		if (m_timer != null) {
			debugf("startTimer() called, but a previous timer exists; making sure it's cleaned up");
			m_xstatus = PING_FINISHING;
			m_timer.cancel();
		}

		debugf("scheduling new discovery timer");
		m_timer = new Timer("Discovery.Pinger", true);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				doPings();
			}

		};
		// FIXME
		m_timer.scheduleAtFixedRate(task, 1000, 60 * 1000);

	}

	private void stopTimer() {
		if (m_timer != null) {
			debugf("stopping existing timer");
			m_xstatus = PING_FINISHING;
			m_timer.cancel();
			m_timer = null;
		} else {
			debugf("stopTimer() called, but there is no existing timer");
		}
	}

	@Override
	protected void onStart() {
		syncAlreadyDiscovered();
		startTimer();
	}

	@Override
	protected void onStop() {
		stopTimer();
	}

	@Override
	protected void onPause() {
		stopTimer();
	}

	@Override
	protected void onResume() {
		startTimer();
	}

	protected void syncAlreadyDiscovered() {
		// 从数据库中读取已知节点
		log().info(
				"syncAlreadyDiscovered initialized list of managed IP addresses with "
						+ m_alreadyDiscovered.size() + " members");
	}

	public void handleDiscoveryConfigurationChanged(Event event) {
		log().info(
				"handleDiscoveryConfigurationChanged: handling message that a change to configuration happened...");
		reloadAndReStart();
	}

	private void reloadAndReStart() {
		EventBuilder ebldr = null;
		try {
			initializeConfiguration();
			ebldr = new EventBuilder(
					EventConstants.RELOAD_DAEMON_CONFIG_SUCCESSFUL_UEI,
					getName());
			ebldr.addParam(EventConstants.PARM_DAEMON_NAME, "Discovery");
			this.stop();
			this.start();
		} catch (MarshalException e) {
			fatalf(e,
					"Unable to initialize the discovery configuration factory");
			ebldr = new EventBuilder(
					EventConstants.RELOAD_DAEMON_CONFIG_FAILED_UEI, getName());
			ebldr.addParam(EventConstants.PARM_DAEMON_NAME, "Discovery");
			ebldr.addParam(EventConstants.PARM_REASON, e.getLocalizedMessage()
					.substring(0, 128));
		} catch (ValidationException e) {
			fatalf(e,
					"Unable to initialize the discovery configuration factory");
			ebldr = new EventBuilder(
					EventConstants.RELOAD_DAEMON_CONFIG_FAILED_UEI, getName());
			ebldr.addParam(EventConstants.PARM_DAEMON_NAME, "Discovery");
			ebldr.addParam(EventConstants.PARM_REASON, e.getLocalizedMessage()
					.substring(0, 128));
		} catch (IOException e) {
			fatalf(e,
					"Unable to initialize the discovery configuration factory");
			ebldr = new EventBuilder(
					EventConstants.RELOAD_DAEMON_CONFIG_FAILED_UEI, getName());
			ebldr.addParam(EventConstants.PARM_DAEMON_NAME, "Discovery");
			ebldr.addParam(EventConstants.PARM_REASON, e.getLocalizedMessage()
					.substring(0, 128));
		}
		m_eventForwarder.sendNow(ebldr.getEvent());
	}

	public void reloadDaemonConfig(Event e) {
		log().info("reloadDaemonConfig: processing reload daemon event...");
		if (isReloadConfigEventTarget(e)) {
			reloadAndReStart();
		}
		log().info("reloadDaemonConfig: reload daemon event processed.");
	}

	private boolean isReloadConfigEventTarget(Event event) {
		boolean isTarget = false;

		Map<String, String> params = event.getParams();

		for (Map.Entry<String, String> parm : params.entrySet()) {
			if (EventConstants.PARM_DAEMON_NAME.equals(parm.getKey())
					&& "Discovery".equalsIgnoreCase(parm.getValue())) {
				isTarget = true;
				break;
			}
		}

		log().debug(
				"isReloadConfigEventTarget: discovery was target of reload event: "
						+ isTarget);
		return isTarget;
	}

	public void handleInterfaceDeleted(Event event) {
		if (event.getNetInterface() != null) {
			// remove from known nodes
			m_alreadyDiscovered.remove(event.getNetInterface());

			debugf("Removed %s from known node list", event.getNetInterface());
		}
	}

	public void handleDiscoveryResume(Event event) {
		try {
			resume();
		} catch (IllegalStateException ex) {
		}
	}

	public void handleDiscoveryPause(Event event) {
		try {
			pause();
		} catch (IllegalStateException ex) {
		}
	}

	public void handleNodeGainedInterface(Event event) {
		// add to known nodes
		m_alreadyDiscovered.add(event.getNetInterface());

		debugf("Added %s as discovered", event.getNetInterface());
	}

}
