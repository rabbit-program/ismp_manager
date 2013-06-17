package org.infosec.ismp.manager.snmp.processor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.infosec.ismp.manager.model.snmp.NetworkHistoryEntity;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseEntity;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseStatus;
import org.infosec.ismp.manager.rmi.snmp.model.NetworkDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.CPUStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.InterfaceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.MemoryStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus;
import org.infosec.ismp.manager.snmp.SnmpDeviceConstants;
import org.infosec.ismp.manager.snmp.SnmpDeviceLocator;
import org.infosec.ismp.model.snmp.Result;
import org.infosec.ismp.model.snmp.Results;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-12-23 上午10:27:29
 * 
 */
public final class NetworkMessageProcessor {

	// 持久化基本信息类
	private SnmpDeviceHistoryBaseEntity m_baseEntity = null;
	// 持久化思科信息类,是基本信息类的子集
	private List<NetworkHistoryEntity> networkEntityList = new ArrayList<NetworkHistoryEntity>();

	public SnmpDeviceHistoryBaseStatus process(Results results) {
		NetworkDeviceStatus networkDeviceStatus = networkDeviceStatus(results);
		SnmpDeviceHistoryBaseStatus baseStatus = null;// 保存状态和入库信息
		if (!networkEntityList.isEmpty()) {
			baseStatus = new SnmpDeviceHistoryBaseStatus();
			// 把网络设备状态由MAP转化为POJO类
			baseStatus.setNetworkDeviceStatus(networkDeviceStatus);
			// SnmpDeviceHistoryBaseEntity 属性赋值
			copyProperties(results.getNodeid(), results.getIpAddr(), results
					.getBrand());
			baseStatus.setSnmpDeviceHistoryBaseEntity(m_baseEntity);
		}
		return baseStatus;
	}

	private NetworkDeviceStatus networkDeviceStatus(Results results) {
		NetworkDeviceStatus networkDeviceStatus = new NetworkDeviceStatus();// 状态信息
		// ，
		// 供前台调用
		if(results!=null && results.getResultList()!=null){
			for (Result result : results.getResultList()) {
				String deviceName = result.getTrackerName();
				String ipAddr = results.getIpAddr();
				if ("memory".equals(deviceName)) {
					// 内存状态
					networkDeviceStatus
							.setMemoryStatus(convertMemoryStatus(result));
					continue;
				} else if ("cpu".equals(deviceName)) {
					// CPU状态
					networkDeviceStatus.setCpuStatus(convertCPUStatus(result));
					continue;
				} else if ("ifTable".equals(deviceName)) {
					// 网络设备状态
					networkDeviceStatus
							.setNetworkStatus(convertNetworkStatus(result,ipAddr));
					continue;
				}else if ("ipAddrTable".equals(deviceName)) {
					// 网络设备状态
					extra(networkDeviceStatus,result);
					continue;
				}
			}
		}
		if (!networkEntityList.isEmpty()) {
			networkDeviceStatus.setActive(true);
			networkDeviceStatus.setNodeid(results.getNodeid());
			networkDeviceStatus.setDomain(SnmpDeviceLocator.getDomainId(results
					.getNodeid()));
			networkDeviceStatus.setIpAddr(results.getIpAddr());
		}
		return networkDeviceStatus;
	}

	// convert network status
	private NetworkStatus convertNetworkStatus(Result result,String ipAddress) {
		NetworkStatus networkStatus = new NetworkStatus();
		int size = result.getListResults().size();
		InterfaceStatus[] interfaceStatus = new InterfaceStatus[size];
		int i = 0;
		for (Map<String, Object> properties : result.getListResults()) {
			InterfaceStatus bean = new InterfaceStatus();
			populate(bean, properties);
			// log().info(bean.toString());
			bean.setIpAddress(ipAddress);
			interfaceStatus[i++] = bean;
			// 加入到历史信息集合，便于后面存入DB
			networkEntityList.add(converHostHistory(properties,
					SnmpDeviceConstants.NETWORK));
		}
		networkStatus.setInterfaceStatus(interfaceStatus);
		return networkStatus;

	}

	// convert memory status
	private MemoryStatus convertMemoryStatus(Result result) {
		MemoryStatus memoryStatus = new MemoryStatus();
		for (Map<String, Object> properties : result.getListResults()) {
			log().info(properties.toString());
			populate(memoryStatus, properties);
			log().info(memoryStatus.toString());
			// 加入到历史信息集合，便于后面存入DB
			networkEntityList.add(converHostHistory(properties,
					SnmpDeviceConstants.MEMORY));
			break;

		}
		return memoryStatus;

	}

	// convert CPU status
	private CPUStatus convertCPUStatus(Result result) {
		CPUStatus cpuStatus = new CPUStatus();
		int[] loads = new int[result.getListResults().size()];
		int i = 0;
		for (Map<String, Object> properties : result.getListResults()) {
			int load = Integer.parseInt(String.valueOf(properties
					.get("cpuLoad")));
			loads[i++] = load;
			log().info(" cpu load " + load);
			// 加入到历史信息集合，便于后面存入DB
			networkEntityList.add(converHostHistory(properties,
					SnmpDeviceConstants.CPU));
		}
		cpuStatus.setLoads(loads);
		return cpuStatus;

	}

	private NetworkHistoryEntity converHostHistory(Map<String, Object> map,
			String type) {
		NetworkHistoryEntity bean = new NetworkHistoryEntity();
		int keyindex = 1;
		for (Entry<String, Object> entry : map.entrySet()) {
			bean.setKey(String.valueOf(entry.getKey()));
			bean.setValue(String.valueOf(entry.getValue()));
			bean.setKeyindex(keyindex++);
			bean.setDeviceType(type);
		}
		bean.setTime(new Date());
		return bean;
	}
	private void extra(NetworkDeviceStatus networkDeviceStatus,Result result){
		for (Map<String, Object> properties : result.getListResults()) {
			log().info(properties.toString());
			String ipAdEntAddr = String.valueOf(properties.get("ipAdEntAddr"));
			ipAdEntAddr = StringUtils.removeStart(ipAdEntAddr,"/");
			String netMask = String.valueOf(properties.get("ipAdEntNetMask"));
			netMask = StringUtils.removeStart(netMask,"/");

			for(InterfaceStatus interfaceStatus : networkDeviceStatus.getNetworkStatus().getInterfaceStatus()){
				if(interfaceStatus.getIpAddress().equals(ipAdEntAddr)){
					interfaceStatus.setNetMask(netMask);
				}
			}
		}
    }
	// 属性赋值
	private void copyProperties(String nodeid, String ipAddr, String brand) {
		m_baseEntity = new SnmpDeviceHistoryBaseEntity();
		m_baseEntity.setNodeid(nodeid);
		m_baseEntity.setIpAddr(ipAddr);
		m_baseEntity.setTime(new Date());
		m_baseEntity.setType(brand);
		m_baseEntity.setDomain(SnmpDeviceLocator.getDomainId(nodeid));
		m_baseEntity.setNetworkHistory(networkEntityList);
	}

	private void populate(Object bean, Map<String, Object> properties) {
		try {
			BeanUtils.populate(bean, properties);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
