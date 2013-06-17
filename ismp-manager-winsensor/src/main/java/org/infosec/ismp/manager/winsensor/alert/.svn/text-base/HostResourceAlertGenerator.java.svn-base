package org.infosec.ismp.manager.winsensor.alert;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.infosec.ismp.agent.comm.util.AlertType;
import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.agent.comm.winsensor.model.status.CPUStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.HardDiskStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.agent.comm.winsensor.model.status.MemoryStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.NetworkStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.PartitionStatus;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.comm.model.SystemModelInfo;
import org.infosec.ismp.manager.winsensor.entity.ThresholdBO;
import org.infosec.ismp.manager.winsensor.service.ThresholdService;

/**
 * @author Rocky
 * @version create time: Jan 4, 2011 3:16:53 PM
 *
 */
public class HostResourceAlertGenerator {

	private Map<String, List<ThresholdBO>> allCurrentThresholds = new HashMap<String, List<ThresholdBO>>();
	
	private ThresholdService thresholdService;		//Loading by Spring.
	
	private int corePoolSize;
	
	private int maximumPoolSize;
	
	private long keepAliveTime;
	
	private int blockingQueueSize;
	
	private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(((getCorePoolSize() > 0) ? getCorePoolSize() : 5), 
			((getMaximumPoolSize() > 0) ? getMaximumPoolSize() : 20), 
			((getKeepAliveTime() > 0) ? getKeepAliveTime() : 3), 
			TimeUnit.SECONDS, 
			new ArrayBlockingQueue<Runnable>((getBlockingQueueSize() > 0) ? getBlockingQueueSize() : 1000), 
			new ThreadPoolExecutor.DiscardPolicy());
	
	public void init() {
		//Load all threshold.
		reloadThresholds();
	}
	
	public void reloadThresholds() {
		List<ThresholdBO> thresholds = thresholdService.getAllThreshold();
		
		synchronized (allCurrentThresholds) {
			allCurrentThresholds.clear();
			
			for (int i = 0; i < thresholds.size(); i++) {
				ThresholdBO threshold = thresholds.get(i);
				String nodeId = threshold.getNodeId();
				
				if (!allCurrentThresholds.containsKey(nodeId)) {
					List<ThresholdBO> temp = new ArrayList<ThresholdBO>();
					temp.add(threshold);
					allCurrentThresholds.put(nodeId, temp);
				} else {
					allCurrentThresholds.get(nodeId).add(threshold);
				}
			}
		}
	}
	
	public void addHostResource(HostResource hostResource) {
		if (allCurrentThresholds.containsKey(hostResource.getDevice().getNodeId())) {
			AlertGeneratorClient client = new AlertGeneratorClient(hostResource);
			threadPool.execute(client);
		}
	}
	
	public void sendAlert(AlertInfoBO alertInfoBO) {
		//TODO
	}
	
	public AlertInfoBO generateAlert(Timestamp time,
														Long nodeId,
														String type,
														Integer level,
														String alertType,
														String alertSubType,
														String alertReason,
														String srcIp,
														String rawContent,
														Integer domainId) {
		AlertInfoBO alertInfoBO = new AlertInfoBO();
		
		alertInfoBO.setTime(time);
		alertInfoBO.setNodeid(nodeId);
		alertInfoBO.setType(type);
		alertInfoBO.setLevel(level);
		alertInfoBO.setAlertType(alertType);
		alertInfoBO.setAlertSubType(alertSubType);
		alertInfoBO.setAlertReason(alertReason);
		alertInfoBO.setSrcIP(srcIp);
		alertInfoBO.setRawContent(rawContent);
		alertInfoBO.setDomain_id(domainId);
		
		return alertInfoBO;
	}
	
	private class AlertGeneratorClient implements Runnable {
		
		private HostResource hostResource;
		
		public AlertGeneratorClient(HostResource vHostResource) {
			hostResource = vHostResource;
		}

		@Override
		public void run() {
			CommWinsensorDevice device = hostResource.getDevice();
			List<ThresholdBO> thresholds = allCurrentThresholds.get(device.getNodeId());
			
			for (int i = 0; i < thresholds.size(); i++) {
				ThresholdBO threshold = thresholds.get(i);
				
				//CPU alert.
				if (threshold.getType().equalsIgnoreCase(AlertType.Cpu.toString())) {
					CPUStatus  cpuStatus = hostResource.getCpuStatus();
					Integer[] loads = cpuStatus.getLoads();
					for (int j = 0; j < loads.length; j++) {
						if (loads[j].longValue() > threshold.getSize()) {
							AlertInfoBO alertInfoBO = generateAlert(new Timestamp(System.currentTimeMillis()), 
									Long.getLong(device.getNodeId()), 
									//TODO Type should be select.
									SystemModelInfo.MOD_TM_manager, 
									threshold.getLevel(), 
									"阈值告警", 
									AlertType.Cpu.toString(), 
									AlertType.Cpu.toString() + "超过阈值", 
									device.getIp(), 
									AlertType.Cpu.toString() + "当前利用率为：" + loads[j].toString() + " 阈值为：" + threshold.getSize(), 
									Integer.valueOf(device.getDomainId()));
							
							sendAlert(alertInfoBO);
							break;
						}
					}
					
					continue;
					//Memory alert.
				} else if (threshold.getType().equalsIgnoreCase(AlertType.Memory.toString())) {
					MemoryStatus memoryStatus = hostResource.getMemoryStatus();
					if (memoryStatus.getUsed() > threshold.getSize()) {
						AlertInfoBO alertInfoBO = generateAlert(new Timestamp(System.currentTimeMillis()), 
								Long.getLong(device.getNodeId()), 
								SystemModelInfo.MOD_TM_manager, 
								threshold.getLevel(), 
								"阈值告警", 
								AlertType.Memory.toString(), 
								AlertType.Memory.toString() + "超过阈值", 
								device.getIp(), 
								AlertType.Memory.toString() + "当前使用：" + memoryStatus.getUsed().toString() + " 阈值为：" + threshold.getSize(), 
								Integer.valueOf(device.getDomainId()));
						
						sendAlert(alertInfoBO);
					}
					
					continue;
				} else if (threshold.getType().equalsIgnoreCase(AlertType.HardDisk.toString())) {
					List<HardDiskStatus> hardDiskStatuses = hostResource.getHardDiskStatus();
					
					if (StringUtils.isBlank(threshold.getSubType())) {
						//HardDisk alert
						for (int j = 0; j < hardDiskStatuses.size(); j++) {
							if (threshold.getIndex().equals(String.valueOf(j))) {
								HardDiskStatus hardDiskStatus = hardDiskStatuses.get(j);
								
								if (hardDiskStatus.getUsed() > threshold.getSize()) {
									AlertInfoBO alertInfoBO = generateAlert(new Timestamp(System.currentTimeMillis()), 
											Long.getLong(device.getNodeId()), 
											SystemModelInfo.MOD_TM_manager, 
											threshold.getLevel(), 
											"阈值告警", 
											AlertType.HardDisk.toString(), 
											AlertType.HardDisk.toString() + "超过阈值", 
											device.getIp(), 
											AlertType.HardDisk.toString() + "当前使用：" + hardDiskStatus.getUsed().toString() + " 阈值为：" + threshold.getSize(), 
											Integer.valueOf(device.getDomainId()));
									
									sendAlert(alertInfoBO);
								}
								
								break;
							}
						}
						
						continue;
					} else if (threshold.getSubType().equalsIgnoreCase(AlertType.Partition.toString())) {
						//Partition alert
						for (int j = 0; j < hardDiskStatuses.size(); j++) {
							List<PartitionStatus> partitionStatuses = hardDiskStatuses.get(j).getPartitionStatus();
							Boolean foundCorrespondingPatition = false;
							
							for (int k = 0; k < partitionStatuses.size(); k++) {
								PartitionStatus partitionStatus = partitionStatuses.get(k);
								
								if (threshold.getIndex().equalsIgnoreCase(partitionStatus.getName())) {
									if (partitionStatus.getUsed() > threshold.getSize()) {
										AlertInfoBO alertInfoBO = generateAlert(new Timestamp(System.currentTimeMillis()), 
												Long.getLong(device.getNodeId()), 
												SystemModelInfo.MOD_TM_manager, 
												threshold.getLevel(), 
												"阈值告警", 
												AlertType.HardDisk.toString(), 
												AlertType.Partition.toString() + "超过阈值", 
												device.getIp(), 
												AlertType.Partition.toString() + "当前使用：" + partitionStatus.getUsed().toString() + " 阈值为：" + threshold.getSize(), 
												Integer.valueOf(device.getDomainId()));
										
										sendAlert(alertInfoBO);
									}
									foundCorrespondingPatition = true;
									
									break;
								}
							}
							
							if (foundCorrespondingPatition == true) {
								break;
							}
						}
						
						continue;
					}
				} else if (threshold.getType().equalsIgnoreCase(AlertType.Network.toString())) {
					List<NetworkStatus> networkStatuses = hostResource.getNetworkStatus();
					
					for (int j = 0; j < networkStatuses.size(); j++) {
						if (threshold.getIndex().equalsIgnoreCase(String.valueOf(j))) {
							NetworkStatus networkStatus = networkStatuses.get(j);
							
							if (threshold.getSubType().equalsIgnoreCase(AlertType.ReceiveBytes.toString())) {
								if (networkStatus.getRecBytesPreSec().longValue() - threshold.getSize() > 0) {
									AlertInfoBO alertInfoBO = generateAlert(new Timestamp(System.currentTimeMillis()), 
											Long.getLong(device.getNodeId()), 
											SystemModelInfo.MOD_TM_manager, 
											threshold.getLevel(), 
											"阈值告警", 
											AlertType.Network.toString(), 
											AlertType.Network.toString() + "超过阈值", 
											device.getIp(), 
											AlertType.ReceiveBytes.toString() + "当前值：" + networkStatus.getRecBytesPreSec().toString() 
												+ " 阈值为：" + threshold.getSize(), 
											Integer.valueOf(device.getDomainId()));
									
									sendAlert(alertInfoBO);
								}
								
								break;
							} else if (threshold.getSubType().equalsIgnoreCase(AlertType.SendBytes.toString())) {
								if (networkStatus.getSendBytesPreSec().longValue() - threshold.getSize() > 0) {
									AlertInfoBO alertInfoBO = generateAlert(new Timestamp(System.currentTimeMillis()), 
											Long.getLong(device.getNodeId()), 
											SystemModelInfo.MOD_TM_manager, 
											threshold.getLevel(), 
											"阈值告警", 
											AlertType.Network.toString(), 
											AlertType.Network.toString() + "超过阈值", 
											device.getIp(), 
											AlertType.SendBytes.toString() + "当前值：" + networkStatus.getRecBytesPreSec().toString() 
												+ " 阈值为：" + threshold.getSize(), 
											Integer.valueOf(device.getDomainId()));
									
									sendAlert(alertInfoBO);
								}
								
								break;
							}
						}
					}
					
					continue;
				}
			}
		}
		
	}

	public ThresholdService getThresholdService() {
		return thresholdService;
	}

	public void setThresholdService(ThresholdService thresholdService) {
		this.thresholdService = thresholdService;
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public long getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public int getBlockingQueueSize() {
		return blockingQueueSize;
	}

	public void setBlockingQueueSize(int blockingQueueSize) {
		this.blockingQueueSize = blockingQueueSize;
	}
}
