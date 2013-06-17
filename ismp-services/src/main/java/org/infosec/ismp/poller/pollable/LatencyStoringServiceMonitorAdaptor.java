/*
 * This file is part of the OpenNMS(R) Application.
 *
 * OpenNMS(R) is Copyright (C) 2006-2007 The OpenNMS Group, Inc.  All rights reserved.
 * OpenNMS(R) is a derivative work, containing both original code, included code and modified
 * code that was published under the GNU General Public License. Copyrights for modified
 * and included code are below.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * Modifications:
 * 
 * 2008 Apr 30: Fix for bug #2445,  Also make all fields private, add the
 *              exception cause to rethrown exception messages, specify initial
 *              array size when we have an idea of what the size will end up
 *              being, and use generics to eliminate warnings. - dj@opennms.org 
 * 
 * Created August 22, 2006
 *
 * Copyright (C) 2006-2007 The OpenNMS Group, Inc.  All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * For more information contact:
 *      OpenNMS Licensing       <license@opennms.org>
 *      http://www.opennms.org/
 *      http://www.opennms.com/
 */
package org.infosec.ismp.poller.pollable;

import java.util.LinkedHashMap;
import java.util.Map;

import org.infosec.ismp.model.poller.MonitoredService;
import org.infosec.ismp.model.poller.PollStatus;
import org.infosec.ismp.model.poller.ServiceMonitor;
import org.infosec.ismp.poller.PollerConfig;
import org.infosec.ismp.util.ThreadCategory;

/**
 * 
 * @author <a href="mailto:brozow@opennms.org">Mathew Brozowski</a>
 * @author <a href="mailto:ranger@opennms.org">Ben Reed</a>
 */
public class LatencyStoringServiceMonitorAdaptor implements ServiceMonitor {

	public static final String DEFAULT_BASENAME = "response-time";

	private final ServiceMonitor m_serviceMonitor;
	private final PollerConfig m_pollerConfig;

	// private final Package m_pkg;

	// private LatencyThresholdingSet m_thresholdingSet;

	public LatencyStoringServiceMonitorAdaptor(ServiceMonitor monitor,
			PollerConfig config) {
		m_serviceMonitor = monitor;
		m_pollerConfig = config;
		// m_pkg = pkg;
	}

	@Override
	public void initialize(Map<String, Object> parameters) {
		m_serviceMonitor.initialize(parameters);
	}

	@Override
	public void initialize(MonitoredService svc) {
		m_serviceMonitor.initialize(svc);
	}

	@Override
	public PollStatus poll(MonitoredService svc, Map<String, Object> parameters) {
		PollStatus status = m_serviceMonitor.poll(svc, parameters);

		// if (!status.getProperties().isEmpty()) {
		// storeResponseTime(svc,
		// new LinkedHashMap<String, Number>(status.getProperties()),
		// parameters);
		// }
		//
		// if ("true".equals(ParameterMap.getKeyedString(parameters,
		// "invert-status", "false"))) {
		// if (status.isAvailable()) {
		// return PollStatus
		// .unavailable("This is an inverted service and the underlying service has started responding");
		// } else {
		// return PollStatus.available();
		// }
		// }
		return status;
	}

	private void storeResponseTime(MonitoredService svc,
			LinkedHashMap<String, Number> entries,
			Map<String, Object> parameters) {
		// String rrdPath = ParameterMap.getKeyedString(parameters,
		// "rrd-repository", null);
		// String dsName = ParameterMap.getKeyedString(parameters, "ds-name",
		// DEFAULT_BASENAME);
		// String rrdBaseName = ParameterMap.getKeyedString(parameters,
		// "rrd-base-name", dsName);
		// String thresholds = ParameterMap.getKeyedString(parameters,
		// "thresholding-enabled", "false");
		//
		// if (!entries.containsKey(dsName)
		// && entries.containsKey(DEFAULT_BASENAME)) {
		// entries.put(dsName, entries.get(DEFAULT_BASENAME));
		// entries.remove(DEFAULT_BASENAME);
		// }
		//
		// if (thresholds.toLowerCase().equals("true")) {
		// applyThresholds(rrdPath, svc, dsName, entries);
		// } else {
		// log().debug(
		// "storeResponseTime: Thresholds processing is not enabled. Check thresholding-enabled parameter on service definition");
		// }
		//
		// if (rrdPath == null) {
		// log().debug(
		// "storeResponseTime: RRD repository not specified in parameters, latency data will not be stored.");
		// return;
		// }
		//
		// updateRRD(rrdPath, svc.getAddress(), rrdBaseName, entries);
	}

	private void applyThresholds(String rrdPath, MonitoredService service,
			String dsName, LinkedHashMap<String, Number> entries) {
		// try {
		// if (m_thresholdingSet == null) {
		// RrdRepository repository = new RrdRepository();
		// repository.setRrdBaseDir(new File(rrdPath));
		// // Interval does not make sense for Latency Thresholding,
		// // because all values are gauge.
		// m_thresholdingSet = new LatencyThresholdingSet(
		// service.getNodeId(), service.getIpAddr(),
		// service.getSvcName(), repository, 0);
		// }
		// LinkedHashMap<String, Double> attributes = new LinkedHashMap<String,
		// Double>();
		// for (String ds : entries.keySet()) {
		// attributes.put(ds, entries.get(ds).doubleValue());
		// }
		// if (m_thresholdingSet.hasThresholds(attributes)) {
		// List<Event> events = m_thresholdingSet.applyThresholds(dsName,
		// attributes);
		// if (events.size() > 0) {
		// ThresholdingEventProxy proxy = new ThresholdingEventProxy();
		// proxy.add(events);
		// proxy.sendAllEvents();
		// }
		// }
		//
		// } catch (Exception e) {
		// log().error(
		// "Failed to threshold on " + service + " for " + dsName
		// + " because of an exception", e);
		// }
	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	@Override
	public void release() {
		m_serviceMonitor.release();
	}

	@Override
	public void release(MonitoredService svc) {
		m_serviceMonitor.release(svc);
	}

	/**
	 * Should be called when thresholds configuration has been reloaded
	 */
	public void refreshThresholds() {
		// if (m_thresholdingSet != null)
		// m_thresholdingSet.reinitialize();
	}

}
