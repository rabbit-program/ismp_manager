package org.infosec.ismp.manager.winsensor.history.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.infosec.ismp.agent.comm.util.AlertType;
import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.comm.winsensor.model.status.CPUStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.HardDiskStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.agent.comm.winsensor.model.status.MemoryStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.NetworkStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.PartitionStatus;
import org.infosec.ismp.manager.winsensor.Constants;
import org.infosec.ismp.manager.winsensor.history.dao.HostResourceHistoryDao;
import org.infosec.ismp.manager.winsensor.history.entity.HostResourceHistoryBO;
import org.infosec.ismp.manager.winsensor.history.service.HostResourceHistoryService;

/**
 * @author Rocky
 * @version create time: Dec 31, 2010 1:58:35 PM
 * 
 */
public class HostResourceHistoryServiceImpl implements HostResourceHistoryService {

	private HostResourceHistoryDao dao;
	
	private LinkedList<HostResource> hostResourceList = new LinkedList<HostResource>();
	
	public void init() {
		HostResourceHistoryProcessor historyProcessor = new HostResourceHistoryProcessor();
		new Thread(historyProcessor, "Sensor base info history processor").start();
	}

	public void addHostResource(HostResource hostResource) {
		synchronized (hostResourceList) {
			hostResourceList.add(hostResource);
			hostResourceList.notifyAll();
		}
	}

	private class HostResourceHistoryProcessor implements Runnable {

		private long lastProcessTime;

		@Override
		public void run() {
			lastProcessTime = System.currentTimeMillis();
			while (true) {
				synchronized (hostResourceList) {
					if ((hostResourceList.size() < Constants.HOST_RESOURCE_HISTORY_BATCH_SAVE_MEMORY_SIZE)
							&& ((System.currentTimeMillis() - lastProcessTime) < Constants.HOST_RESOURCE_HISTORY_BATCH_SAVE_INTERVAL)) {
						try {
							hostResourceList.wait(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						List<HostResourceHistoryBO> histories = new LinkedList<HostResourceHistoryBO>();
						for (int i = 0; i < hostResourceList.size(); i++) {
							HostResource hostResource = hostResourceList.get(i);
							CommWinsensorDevice device = hostResource.getDevice();
							String nodeId = device.getNodeId();
							String domainId = device.getDomainId();
							String ip = device.getIp();
							// Process CPU info.
							CPUStatus cpuStatus = hostResource.getCpuStatus();
							HostResourceHistoryBO cpuHistory = new HostResourceHistoryBO();
							cpuHistory.setNodeId(nodeId);
							cpuHistory.setDomainID(domainId);
							cpuHistory.setIp(ip);
							cpuHistory.setType(AlertType.Cpu.toString());
							// Here has no subType and index.
							Integer[] loads = cpuStatus.getLoads();
							long currentUsedSize = 0;
							for (int j = 0; j < loads.length; j++) {
								currentUsedSize += loads[j].longValue();
								if (j == (loads.length - 1)) {
									currentUsedSize = currentUsedSize / loads.length;
								}
							}
							cpuHistory.setTotalSize(100);
							cpuHistory.setCurrentUsedSize(currentUsedSize);
							cpuHistory.setCreateTime(new Date());
							histories.add(cpuHistory);

							// Process Memory info.
							MemoryStatus memoryStatus = hostResource.getMemoryStatus();
							HostResourceHistoryBO memoryHistory = new HostResourceHistoryBO();
							memoryHistory.setNodeId(nodeId);
							memoryHistory.setDomainID(domainId);
							memoryHistory.setIp(ip);
							memoryHistory.setType(AlertType.Memory.toString());
							// Here has no subType and index.
							memoryHistory.setTotalSize(memoryStatus.getSize());
							memoryHistory.setCurrentUsedSize(memoryStatus.getUsed().longValue());
							memoryHistory.setCreateTime(new Date());
							histories.add(memoryHistory);

							// Process HardDisk info.
							List<HardDiskStatus> hardDiskStatuses = hostResource.getHardDiskStatus();
							for (int j = 0; j < hardDiskStatuses.size(); j++) {
								HardDiskStatus hardDiskStatus = hardDiskStatuses.get(j);
								HostResourceHistoryBO hardDiskHistory = new HostResourceHistoryBO();
								hardDiskHistory.setNodeId(nodeId);
								hardDiskHistory.setDomainID(domainId);
								hardDiskHistory.setIp(ip);
								hardDiskHistory.setType(AlertType.HardDisk.toString());
								// Here has no subType.
								hardDiskHistory.setIndex(String.valueOf(j));
								hardDiskHistory.setTotalSize(hardDiskStatus.getSize());
								hardDiskHistory.setCurrentUsedSize(hardDiskStatus.getUsed().longValue());
								hardDiskHistory.setCreateTime(new Date());
								histories.add(hardDiskHistory);

								List<PartitionStatus> partitionStatuses = hardDiskStatus.getPartitionStatus();
								for (int k = 0; k < partitionStatuses.size(); k++) {
									PartitionStatus partitionStatus = partitionStatuses.get(k);
									HostResourceHistoryBO partitionHistory = new HostResourceHistoryBO();
									partitionHistory.setNodeId(nodeId);
									partitionHistory.setDomainID(domainId);
									partitionHistory.setIp(ip);
									partitionHistory.setType(AlertType.HardDisk.toString());
									partitionHistory.setSubType(AlertType.Partition.toString());
									partitionHistory.setIndex(partitionStatus.getName());
									partitionHistory.setTotalSize(partitionStatus.getSize());
									partitionHistory.setCurrentUsedSize(partitionStatus.getUsed());
									partitionHistory.setCreateTime(new Date());
									histories.add(partitionHistory);
								}
							}

							// Process Network info.
							List<NetworkStatus> networkStatuses = hostResource.getNetworkStatus();
							for (int j = 0; j < networkStatuses.size(); j++) {
								NetworkStatus networkStatus = networkStatuses.get(j);
								//Receive bytes history.
								HostResourceHistoryBO networkReceiveBytesHistory = new HostResourceHistoryBO();
								networkReceiveBytesHistory.setNodeId(nodeId);
								networkReceiveBytesHistory.setDomainID(domainId);
								networkReceiveBytesHistory.setIp(ip);
								networkReceiveBytesHistory.setType(AlertType.Network.toString());
								networkReceiveBytesHistory.setSubType(AlertType.ReceiveBytes.toString());
								networkReceiveBytesHistory.setIndex(String.valueOf(j));
								networkReceiveBytesHistory.setTotalSize(networkStatus.getBandWidth().longValue());
								networkReceiveBytesHistory.setCurrentUsedSize(networkStatus.getRecBytesPreSec());
								networkReceiveBytesHistory.setCreateTime(new Date());
								histories.add(networkReceiveBytesHistory);
								
								//Send bytes history.
								HostResourceHistoryBO networkSendBytesHistory = new HostResourceHistoryBO();
								networkSendBytesHistory.setNodeId(nodeId);
								networkSendBytesHistory.setDomainID(domainId);
								networkSendBytesHistory.setIp(ip);
								networkSendBytesHistory.setType(AlertType.Network.toString());
								networkSendBytesHistory.setSubType(AlertType.SendBytes.toString());
								networkSendBytesHistory.setIndex(String.valueOf(j));
								networkSendBytesHistory.setTotalSize(networkStatus.getBandWidth().longValue());
								networkSendBytesHistory.setCurrentUsedSize(networkStatus.getSendBytesPreSec());
								networkSendBytesHistory.setCreateTime(new Date());
								histories.add(networkSendBytesHistory);
							}
						}
						
						addHistory(histories);
					}
					
					hostResourceList.clear();
					lastProcessTime = System.currentTimeMillis();
				}
			}
		}

	}

	@Override
	public void addHistory(HostResourceHistoryBO history) {
		dao.addHistory(history);
	}

	@Override
	public void addHistory(List<HostResourceHistoryBO> histories) {
		dao.addHistory(histories);
	}

	public void setDao(HostResourceHistoryDao dao) {
		this.dao = dao;
	}
}
