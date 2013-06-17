package org.infosec.ismp.manager.threshold;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceStatus;
import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.manager.rmi.snmp.model.host.CPUStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.HardDiskStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.HostDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.InterfaceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.MemoryStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.PartitionStatus;
import org.infosec.ismp.manager.rmi.threshold.AlertType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoxianwei
 * @date 2010-12-30 下午03:11:08
 * 
 */
@Component
public class ThresholdAlert {

	ThresholdAlertLocator m_thresholdAlertLocator;

	AlertManager m_alertManager;

	public void alert(SnmpDeviceStatus satus) {
		HostDeviceStatus host = satus.getHostDeviceStatus();
		if (host != null) {
			String nodeid = host.getNodeid();
			if (m_thresholdAlertLocator
					.containsThreshold(nodeid, AlertType.CUP)) {
				thresholdCupAlert(nodeid, host.getIpAddr(), host.getDomain(),
						host.getCpuStatus());
			}
			if (m_thresholdAlertLocator.containsThreshold(nodeid, AlertType.HD)) {
				thresholdHDAlert(nodeid, host.getIpAddr(), host.getDomain(),
						host.getHardDiskStatus());
			}
			if (m_thresholdAlertLocator.containsThreshold(nodeid,
					AlertType.MEMORY)) {
				thresholdMemoryAlert(nodeid, host.getIpAddr(),
						host.getDomain(), host.getMemoryStatus());
			}
			if (m_thresholdAlertLocator.containsThreshold(nodeid,
					AlertType.TRAFFIC)) {
				thresholdTrafficAlert(nodeid, host.getIpAddr(), host
						.getDomain(), host.getNetworkStatus());
			}
		}
	}

	private void thresholdCupAlert(String nodeid, String ipAddr, String domain,
			CPUStatus cpuStatus) {
		Threshold threshold = m_thresholdAlertLocator.getThreshold(nodeid,
				AlertType.CUP);
		if (cpuStatus != null && cpuStatus.getLoads() != null) {
			for (int load : cpuStatus.getLoads()) {
				if (load > threshold.getThreshold().intValue()) {
					AlertInfoBO alertInfo = createAlertInfo(nodeid, ipAddr,
							domain, threshold);
					m_alertManager.addAlertInfo(alertInfo);
				}
			}
		}

	}

	private void thresholdHDAlert(String nodeid, String ipAddr, String domain,
			HardDiskStatus hdStatus) {
		Threshold threshold = m_thresholdAlertLocator.getThreshold(nodeid,
				AlertType.HD);
		if (hdStatus != null && hdStatus.getPartitionStatus() != null) {
			for (PartitionStatus partitionStatus : hdStatus
					.getPartitionStatus()) {
				if (partitionStatus.getLabel().startsWith(threshold.getValue())) {
					if (partitionStatus.getUsed() > threshold.getThreshold()
							.longValue()) {
						AlertInfoBO alertInfo = createAlertInfo(nodeid, ipAddr,
								domain, threshold);
						m_alertManager.addAlertInfo(alertInfo);
					}
				}
			}
		}

	}

	private void thresholdMemoryAlert(String nodeid, String ipAddr,
			String domain, MemoryStatus memoryStatus) {
		Threshold threshold = m_thresholdAlertLocator.getThreshold(nodeid,
				AlertType.MEMORY);
		long used = memoryStatus.getUsed();
		if (used > threshold.getThreshold().intValue()) {

			AlertInfoBO alertInfo = createAlertInfo(nodeid, ipAddr, domain,
					threshold);
			m_alertManager.addAlertInfo(alertInfo);

		}
	}

	/*
	 * 产生告警
	 */
	private AlertInfoBO createAlertInfo(String nodeid, String ipAddr,
			String domain, Threshold threshold) {
		AlertInfoBO alertinfo = new AlertInfoBO();
		alertinfo.setNodeid(Long.valueOf(nodeid));
		alertinfo.setSrcIP(ipAddr);
		alertinfo.setDomain_id(Integer.parseInt(domain));
		alertinfo.setLevel(threshold.getLevel());
		alertinfo.setAlertType("阈值告警");
		alertinfo.setAlertSubType(threshold.getType().toString());
		alertinfo.setAlertReason("超出阈值");
		alertinfo.setTime(long2Timestamp(System.currentTimeMillis()));
		return alertinfo;
	}

	public static java.sql.Timestamp long2Timestamp(long time) {
		java.sql.Timestamp timeTemp = new java.sql.Timestamp(time);
		timeTemp.setNanos(0);
		return timeTemp;
	}

	private void thresholdTrafficAlert(String nodeid, String ipAddr,
			String domain, NetworkStatus networkStatus) {
		Threshold threshold = m_thresholdAlertLocator.getThreshold(nodeid,
				AlertType.TRAFFIC);
		if (networkStatus != null && networkStatus.getInterfaceStatus() != null) {
			for (InterfaceStatus interfaceStatus : networkStatus
					.getInterfaceStatus()) {
				if (interfaceStatus.getInBytes() > threshold.getThreshold()
						.longValue()) {
					AlertInfoBO alertInfo = createAlertInfo(nodeid, ipAddr,
							domain, threshold);
					m_alertManager.addAlertInfo(alertInfo);
				}
				if (interfaceStatus.getOutBytes() > threshold.getThreshold()
						.longValue()) {
					AlertInfoBO alertInfo = createAlertInfo(nodeid, ipAddr,
							domain, threshold);
					m_alertManager.addAlertInfo(alertInfo);
				}
			}
		}
	}

	@Autowired(required = true)
	public void setThresholdAlertLocator(
			ThresholdAlertLocator thresholdAlertLocator) {
		m_thresholdAlertLocator = thresholdAlertLocator;
	}

	@Autowired(required = true)
	public void setAlertManager(AlertManager alertManager) {
		m_alertManager = alertManager;
	}

	// private ThreadCategory logger() {
	// return ThreadCategory.getInstance(getClass());
	// }
}
