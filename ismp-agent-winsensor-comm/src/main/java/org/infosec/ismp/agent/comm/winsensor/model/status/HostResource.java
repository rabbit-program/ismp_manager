package org.infosec.ismp.agent.comm.winsensor.model.status;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.infosec.ismp.agent.comm.util.ArrayUtil;
import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;

/**
 * @author Rocky
 * @version create time：Oct 12, 2010 7:56:29 PM
 * 
 */
public class HostResource implements Serializable {

	private static final long serialVersionUID = -7322863669569005831L;

	private CommWinsensorDevice device;
	
	private CPUStatus cpuStatus;
	
	private List<HardDiskStatus> hardDiskStatus;
	
	private List<NetworkStatus> networkStatus;
	
	private MemoryStatus memoryStatus;
	
	private List<ProcessStatus> processStatus;
	
	private LocalSystemStatus localSystemlStatus;
	
	private WinsensorClientStatus winsensorClientStatus;

	public String getHostResourceInfo() {
		StringBuffer buffer = new StringBuffer();
		
		//Base info
		buffer.append("HostResource info, device ip: " + getDevice().getIp() + " sensorId: " 
				+ getDevice().getSensorId());
		//Cpu status
		buffer.append(" Cpu status: " );
		CPUStatus cpuStatus = getCpuStatus();
		Integer[] loads = cpuStatus.getLoads();
		for (int i = 0; i < loads.length; i++) {
			buffer.append("load[" + (i + 1) + "]: " + loads[i].toString());
		}
		//HardDisk status
		buffer.append(" HardDisk status: ");
		List<HardDiskStatus> hardDiskStatus = getHardDiskStatus(); 
		for (int i = 0; i < hardDiskStatus.size(); i++) {
			buffer.append(" hardDisk[" + (i + 1) + "], model: " + hardDiskStatus.get(i).getModel());
			buffer.append(" interfaceType: " + hardDiskStatus.get(i).getInterfaceType());
			buffer.append(" size: " + hardDiskStatus.get(i).getSize());
			buffer.append(" used" + hardDiskStatus.get(i).getUsed());
			buffer.append(" partitionStatus: ");
			List<PartitionStatus> partitionStatus = hardDiskStatus.get(i).getPartitionStatus();
			for (int j = 0; j < partitionStatus.size(); j++) {
				buffer.append(" partition[" + (j + 1) + "], name: " + partitionStatus.get(j).getName());
				buffer.append(" size: " + partitionStatus.get(j).getSize());
				buffer.append(" used: " + partitionStatus.get(j).getUsed());
				buffer.append(" fileSystem: " + partitionStatus.get(j).getFileSystem());
			}
		}
		//Network status
		buffer.append(" Network status: ");
		List<NetworkStatus> networkStatus = getNetworkStatus();
		for (int i = 0; i < networkStatus.size(); i++) {
			buffer.append(" network[" + (i + 1) + "], description: " + networkStatus.get(i).getDescription());
			buffer.append(" ipAddress: " + ArrayUtil.mergeAllElements(networkStatus.get(i).getIpAddress()));
			buffer.append(" ipSubnet: " + ArrayUtil.mergeAllElements(networkStatus.get(i).getIpSubnet()));
			buffer.append(" gateway: " + ArrayUtil.mergeAllElements(networkStatus.get(i).getGateway()));
			buffer.append(" mac: " + networkStatus.get(i).getMac());
			buffer.append(" dns: " + ArrayUtil.mergeAllElements(networkStatus.get(i).getDns()));
			buffer.append(" bandWidth: " + networkStatus.get(i).getBandWidth());
			buffer.append(" iPEnabled: " + networkStatus.get(i).getIPEnabled().toString());
			buffer.append(" recPacket: " + networkStatus.get(i).getRecPacket().longValue());
			buffer.append(" sendPacket: " + networkStatus.get(i).getSendPacket().longValue());
			buffer.append(" recBytesPreSec: " + networkStatus.get(i).getRecBytesPreSec().longValue());
			buffer.append(" sendBytesPreSec: " + networkStatus.get(i).getSendBytesPreSec().longValue());
		}
		//Memory status
		buffer.append(" memory status: ");
		MemoryStatus memoryStatus = getMemoryStatus();
		buffer.append(" size: " + memoryStatus.getSize());
		buffer.append(" used: " + memoryStatus.getUsed());
		//Process status
		buffer.append(" process status: ");
		List<ProcessStatus> processStatus = getProcessStatus();
		for (int i = 0; i < processStatus.size(); i++) {
			buffer.append(" process[" + (i + 1) + " ], pid: " + processStatus.get(i).getPid());
			buffer.append(" name: " + processStatus.get(i).getName());
			buffer.append(" runPath: " + processStatus.get(i).getRunPath());
			buffer.append(" description: " + processStatus.get(i).getDescription());
			buffer.append(" allocatedMemorySize: " + processStatus.get(i).getAllocatedMemorySize().longValue());
			buffer.append(" consumedCPUTime: " + processStatus.get(i).getConsumedCPUTime().longValue());
		}
		//Local system status
		buffer.append(" local system status: ");
		LocalSystemStatus localSystemStatus = getLocalSystemlStatus();
		buffer.append(" phyInfo: " + localSystemStatus.getPhyInfo());
		buffer.append(" registry: " + localSystemStatus.getRegistry());
		buffer.append(" description: " + localSystemStatus.getDescription());
		buffer.append(" computerName: " + localSystemStatus.getComputerName());
		buffer.append(" userName: " + localSystemStatus.getUserName());
		buffer.append(" domain: " + localSystemStatus.getDomain());
		buffer.append(" aliveTime: " + localSystemStatus.getAliveTime());
		List<LocalDNS> localDNS = localSystemStatus.getLocalDNS();
		for (int i = 0; i < localDNS.size(); i++) {
			buffer.append(" local DNS[ " + (i + 1) + "], domain: " + localDNS.get(i).getDomain());
			buffer.append(" ip: " + localDNS.get(i).getIp());
		}
		List<LocalARP> localARP = localSystemStatus.getLocalARP();
		for (int i = 0; i < localARP.size(); i++) {
			buffer.append(" local ARP[" + (i + 1) + "], localIp: " + localARP.get(i).getLocalIp());
			buffer.append(" ip: " + localARP.get(i).getIp());
			buffer.append(" mac: " + localARP.get(i).getMac());
			buffer.append(" type: " + localARP.get(i).getType());
		}
		List<LocalRouter> localRouter = localSystemStatus.getLocalRouter();
		for (int i = 0; i < localRouter.size(); i++) {
			buffer.append(" local Router[" + (i + 1) + "], destination: " + localRouter.get(i).getDestination());
			buffer.append(" netMask: " + localRouter.get(i).getNetMask());
			buffer.append(" gateway: " + localRouter.get(i).getGateway());
			buffer.append(" metric: " + localRouter.get(i).getMetric());
		}
		//Winsensor client status
		buffer.append(" winsensor client status: ");
		WinsensorClientStatus clientStatus = getWinsensorClientStatus();
		buffer.append(" sensorId: " + clientStatus.getSensorId());
		buffer.append(" version: " + clientStatus.getVersion());
		buffer.append(" serviceVersion: " + clientStatus.getServiceVersion());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		buffer.append(" lastUpdateTime: " + format.format(clientStatus.getLastUpdateTime()));
		buffer.append(" autoUpdateUrl: " + clientStatus.getAutoUpdateUrl());

		return buffer.toString();
	}
	
	public CommWinsensorDevice getDevice() {
		return device;
	}

	public void setDevice(CommWinsensorDevice device) {
		this.device = device;
	}

	public CPUStatus getCpuStatus() {
		return cpuStatus;
	}

	public void setCpuStatus(CPUStatus cpuStatus) {
		this.cpuStatus = cpuStatus;
	}

	public List<HardDiskStatus> getHardDiskStatus() {
		return hardDiskStatus;
	}

	public void setHardDiskStatus(List<HardDiskStatus> hardDiskStatus) {
		this.hardDiskStatus = hardDiskStatus;
	}

	public List<NetworkStatus> getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(List<NetworkStatus> networkStatus) {
		this.networkStatus = networkStatus;
	}

	public MemoryStatus getMemoryStatus() {
		return memoryStatus;
	}

	public void setMemoryStatus(MemoryStatus memoryStatus) {
		this.memoryStatus = memoryStatus;
	}

	public List<ProcessStatus> getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(List<ProcessStatus> processStatus) {
		this.processStatus = processStatus;
	}

	public LocalSystemStatus getLocalSystemlStatus() {
		return localSystemlStatus;
	}

	public void setLocalSystemlStatus(LocalSystemStatus localSystemlStatus) {
		this.localSystemlStatus = localSystemlStatus;
	}

	public WinsensorClientStatus getWinsensorClientStatus() {
		return winsensorClientStatus;
	}

	public void setWinsensorClientStatus(WinsensorClientStatus winsensorClientStatus) {
		this.winsensorClientStatus = winsensorClientStatus;
	}
}
