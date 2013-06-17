package org.infosec.ismp.manager.snmp.processor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.infosec.ismp.manager.model.snmp.HostResourceHistoryEntity;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseEntity;
import org.infosec.ismp.manager.model.snmp.SnmpDeviceHistoryBaseStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.CPUStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.HardDiskStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.HostDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.InterfaceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.MemoryStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.PartitionStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.ProcessStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.ProcessesStatus;
import org.infosec.ismp.manager.snmp.SnmpDeviceConstants;
import org.infosec.ismp.manager.snmp.SnmpDeviceLocator;
import org.infosec.ismp.model.snmp.Result;
import org.infosec.ismp.model.snmp.Results;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-12-23 上午09:59:32
 *   
 *   主机信息处理
 *   
 */
public final class HostMessageProcessor {

	//持久化基本信息类
	private SnmpDeviceHistoryBaseEntity m_baseEntity = null;
	//持久化主机信息类
	private List<HostResourceHistoryEntity> m_hostEntityList = new ArrayList<HostResourceHistoryEntity>();

	public SnmpDeviceHistoryBaseStatus process(Results results) {
		SnmpDeviceHistoryBaseStatus baseStatus = null;//保存状态和入库信息
		HostDeviceStatus hostDeviceStatus = new HostDeviceStatus();//状态信息，供前台调用
		if(results!=null && results.getResultList()!=null){
			for (Result result : results.getResultList()) {
				String deviceName = result.getTrackerName();
				if ("ifTable".equals(deviceName)) {
					// 网络设备状态
					NetworkStatus networkStatus = convertNetworkStatus(result);
					hostDeviceStatus.setNetworkStatus(networkStatus);
					continue;
				}
				if ("hrStorageTable".equals(deviceName)) {
					// 内存状态
					hostDeviceStatus.setMemoryStatus(convertMemoryStatus(result));
					// 硬盘状态
					hostDeviceStatus.setHardDiskStatus(convertHardDiskStatus(result));
					continue;
				}
				if ("hrProcessorTable".equals(deviceName)) {
					// CPU状态
					hostDeviceStatus.setCpuStatus(convertCPUStatus(result));
					continue;
				}
				if ("hrSWRunTable".equals(deviceName)) {
					// 进程状态
					hostDeviceStatus.setProcessesStatus(convertProcessesStatus(result));
					continue;
				}
			}
		}
		//入库设置
		if (!m_hostEntityList.isEmpty()) {
			baseStatus = new SnmpDeviceHistoryBaseStatus();
			copyProperties(results.getNodeid(), results.getIpAddr(),results.getBrand());
			baseStatus.setSnmpDeviceHistoryBaseEntity(m_baseEntity);
			hostDeviceStatus.setActive(true);
			hostDeviceStatus.setNodeid(results.getNodeid());
			hostDeviceStatus.setIpAddr(results.getIpAddr());
			hostDeviceStatus.setDomain(SnmpDeviceLocator.getDomainId(results.getNodeid()));
			baseStatus.setHostDeviceStatus(hostDeviceStatus);
		}
		return baseStatus;
	}

	// convert network status
	private NetworkStatus convertNetworkStatus(Result result) {
		NetworkStatus networkStatus = new NetworkStatus();
		int size = result.getListResults().size();
		InterfaceStatus[] interfaceStatus = new InterfaceStatus[size];
		int i = 0;
		for (Map<String, Object> properties : result.getListResults()) {
			InterfaceStatus bean = new InterfaceStatus();
			populate(bean, properties);
//			log().info(bean.toString());
			interfaceStatus[i++] = bean;
			// 加入到历史信息集合，便于后面存入DB
			m_hostEntityList.add(converHostHistory(properties,
					SnmpDeviceConstants.NETWORK));
		}
		networkStatus.setInterfaceStatus(interfaceStatus);
		return networkStatus;

	}

	// convert memory status
	private MemoryStatus convertMemoryStatus(Result result) {
		MemoryStatus memoryStatus = new MemoryStatus();
		for (Map<String, Object> properties : result.getListResults()) {
			//log().info(properties.toString());
			if (Integer.parseInt(String.valueOf(properties.get("index")))== 8 ) {
				populate(memoryStatus, properties);
//				log().info(memoryStatus.toString());
				// 加入到历史信息集合，便于后面存入DB
				m_hostEntityList.add(converHostHistory(properties,
						SnmpDeviceConstants.MEMORY));
				break;
			}
		}
		return memoryStatus;

	}

	// convert hardDisk status
	private HardDiskStatus convertHardDiskStatus(Result result) {
		HardDiskStatus hardDiskStatus = new HardDiskStatus();
		List<PartitionStatus> partitionStatus = new ArrayList<PartitionStatus>();
		long used = 0;
		long size = 0;
		for (Map<String, Object> properties : result.getListResults()) {
			// 根据硬盘盘符类型OID判断 获取各盘符信息
			if (String.valueOf(properties.get("type")).equals(
					".1.3.6.1.2.1.25.2.1.4")) {
				PartitionStatus bean = new PartitionStatus();
				populate(bean, properties);
//				log().info(bean.toString());
				// 加入到历史信息集合，便于后面存入DB
				m_hostEntityList.add(converHostHistory(properties,
						SnmpDeviceConstants.HARDDISK));

				used += bean.getUsed();
				size += bean.getSize();
				System.out.println(bean.getLabel());
				partitionStatus.add(bean);
			}

		}
		hardDiskStatus.setSize(size);
		hardDiskStatus.setUsed(used);
		hardDiskStatus.setPartitionStatus(partitionStatus);
		return hardDiskStatus;

	}

	// convert process status
	private ProcessesStatus convertProcessesStatus(Result result) {
		ProcessesStatus processesStatus = new ProcessesStatus();
		List<ProcessStatus> processStatuses = new ArrayList<ProcessStatus>();
		for (Map<String, Object> properties : result.getListResults()) {
			ProcessStatus bean = new ProcessStatus();
			populate(bean, properties);
//			log().info(bean.toString());
			processStatuses.add(bean);
			// 加入到历史信息集合，便于后面存入DB
//			m_hostHistoryEntity.add(converHostHistory(properties,
//					SnmpDeviceConstants.PROCESS_HOST_RESOURCE));
		}
		processesStatus.setProcessStatus(processStatuses);
		log().info(processesStatus.toString());
		return processesStatus;

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
//			log().info(" cpu load " + load);
			// 加入到历史信息集合，便于后面存入DB
			m_hostEntityList.add(converHostHistory(properties,
					SnmpDeviceConstants.CPU));
		}
		cpuStatus.setLoads(loads);
		return cpuStatus;

	}

	private HostResourceHistoryEntity converHostHistory(
			Map<String, Object> map, String type) {
		HostResourceHistoryEntity bean = new HostResourceHistoryEntity();
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
    //属性赋值
	private void copyProperties(String nodeid, String ipAddr,String brand) {
		m_baseEntity = new SnmpDeviceHistoryBaseEntity();
		m_baseEntity.setHostHistory(m_hostEntityList);
		m_baseEntity.setNodeid(nodeid);
		m_baseEntity.setIpAddr(ipAddr);
		m_baseEntity.setType(brand);
		m_baseEntity.setDomain(SnmpDeviceLocator.getDomainId(nodeid));
		m_baseEntity.setTime(new Date());
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

