package org.infosec.ismp.applet.manager.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.infosec.ismp.agent.comm.winsensor.model.status.LocalSystemStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.WinsensorClientStatus;
import org.infosec.ismp.applet.manager.component.panel.info.file.FileElement;
import org.infosec.ismp.applet.manager.component.panel.progress.Process;
import org.infosec.ismp.applet.manager.component.panel.view.asset.AssetDevice;
import org.infosec.ismp.applet.manager.component.panel.view.device.DeviceInfo;
import org.infosec.ismp.applet.manager.component.panel.view.network.NetworkStatus;
import org.infosec.ismp.applet.manager.component.panel.view.sensor.Sensor;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.manager.rmi.snmp.model.host.HardDiskStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.InterfaceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.PartitionStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.ProcessStatus;
import org.infosec.ismp.manager.rmi.snmp.model.host.ProcessesStatus;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;

import twaver.Element;
import twaver.Node;

/**
 * 过滤网络空信息
 */
public class NullFilter{
	
	private NodeModel device;
	private DeviceInformation info;
	
	/**
	 * <p>构造方法: 构造一个一般 信息读取类</p> 
	 * <p>功能描述: 读取一般远程信息</p> 
	 * @param nodeModel 设备的中间模型
	 */
	public NullFilter(NodeModel device,DeviceInformation info) {
		this.device = device;
		this.info = info;
	}
	
	
	/**
	 * 实现资产关联读取信息方法
	 */
	public AssetDevice getAssetDevice() throws Exception {
		org.infosec.ismp.manager.rmi.tm.manager.model.AssetDevice assetInfo = device.getAssetInformation();
		if(assetInfo == null) return null;
		AssetDevice assetDevice = new AssetDevice();
		assetDevice.setDepartment(assetInfo.getDepartment() == null ? "" : assetInfo.getDepartment());
		assetDevice.setRegistrationTime(assetInfo.getRegistrationTime() == null ? new Date() : assetInfo.getRegistrationTime());
		assetDevice.setStatus(assetInfo.getStatus() == null ? 0 : assetInfo.getStatus());
		assetDevice.setStockTime(assetInfo.getStockTime() == null ? new Date() : assetInfo.getStockTime());
		assetDevice.setTelephone(assetInfo.getTelephone() == null ? "" : assetInfo.getTelephone());
		assetDevice.setUnit(assetInfo.getUnit() == null ? "" : assetInfo.getUnit());
		assetDevice.setUser(assetInfo.getUser() == null ? "" : assetInfo.getUser());
		assetDevice.setValidityPeriod(assetInfo.getValidityPeriod() == null ? 0 : assetInfo.getValidityPeriod());
		return assetDevice;
	}

	public boolean isHostActive() throws Exception {
		if(info.getSnmpDeviceStatus() != null && info.getSnmpDeviceStatus().getHostDeviceStatus() != null && info.getSnmpDeviceStatus().getHostDeviceStatus().isActive()) {
			return true;
		}
		return false;
	}
	public boolean isOtherNetworkActive() throws Exception {
		if(info.getSnmpDeviceStatus() != null && info.getSnmpDeviceStatus().getNetworkDeviceStatus() != null && info.getSnmpDeviceStatus().getNetworkDeviceStatus().isActive()) {
			return true;
		}
		return false;
	}
	public boolean isSensorActive() throws Exception {
		if(info.getHostResource() != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 实现读取设备信息方法
	 */
	public DeviceInfo getDeviceInfo() throws Exception {
		DeviceInfo deviceInfo = new DeviceInfo();
//		if(device.getSnmp() == null)return null;
//		deviceInfo.setCompany(device.getSnmp().getCommunity());
		deviceInfo.setDeviceName(device.getName());
		if(device.getModel() != null) {
			deviceInfo.setDeviceModelNum(device.getModel().getName());
		}
		if(device.getBrand() != null) {
			deviceInfo.setDeviceTradeMark(device.getBrand().getMarkName());
		}
		return deviceInfo;
	}
	
	/**
	 * 获得 Host CPUS 对象集合
	 * @return
	 */
	public List<Element> getHostCPUs() {
		List<Element> elements = new ArrayList<Element>();
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus().getCpuStatus() == null) {
			return elements;
		}
		int i=0;
		for(Integer cpuNum:info.getSnmpDeviceStatus().getHostDeviceStatus().getCpuStatus().getLoads()) {
			if(cpuNum == null)continue;
		     Element c1 = new Node();
	          c1.setName("cpu"+i);
		      c1.putChartValue(cpuNum);
		      elements.add(c1);
		      i++;
		}
		return elements;
	}
	/**
	 * 内存已使用数
	 * @return double
	 */
	public double getHostMemoryUsed() {
		double value = 0.0d;
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus() == null
		|| info.getSnmpDeviceStatus().getHostDeviceStatus().getMemoryStatus() == null
		|| info.getSnmpDeviceStatus().getHostDeviceStatus().getMemoryStatus().getUsed() == null) {
			return value;
		}
		return info.getSnmpDeviceStatus().getHostDeviceStatus().getMemoryStatus().getUsed();
	}
	
	/**
	 * 内存大小
	 * @return double
	 */
	public double getHostMemorySize() {
		double value = 0.0d;
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus() == null 
				|| info.getSnmpDeviceStatus().getHostDeviceStatus().getMemoryStatus() == null
				||info.getSnmpDeviceStatus().getHostDeviceStatus().getMemoryStatus().getSize() == null) {
			return value;
		}
		return info.getSnmpDeviceStatus().getHostDeviceStatus().getMemoryStatus().getSize();
	}
	
	/**
	 * 获得 Host CPUS 对象集合
	 * @return
	 */
	public List<Element> getOtherNetworkCPUs() {
		List<Element> elements = new ArrayList<Element>();
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getNetworkDeviceStatus() == null || info.getSnmpDeviceStatus().getNetworkDeviceStatus().getCpuStatus() == null) {
			return elements;
		}
		int i=0;
		for(Integer cpuNum:info.getSnmpDeviceStatus().getNetworkDeviceStatus().getCpuStatus().getLoads()) {
			if(cpuNum == null)continue;
		     Element c1 = new Node();
	          c1.setName("cpu"+i);
		      c1.putChartValue(cpuNum);
		      elements.add(c1);
		      i++;
		}
		return elements;
	}
	/**
	 * 内存已使用数
	 * @return double
	 */
	public double getOtherNetworkMemoryUsed() {
		double value = 0.0d;
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getNetworkDeviceStatus() == null 
				|| info.getSnmpDeviceStatus().getNetworkDeviceStatus().getMemoryStatus() == null
				|| info.getSnmpDeviceStatus().getNetworkDeviceStatus().getMemoryStatus().getUsed() == null) {
			return value;
		}
		return info.getSnmpDeviceStatus().getNetworkDeviceStatus().getMemoryStatus().getUsed();
	}
	
	/**
	 * 内存大小
	 * @return double
	 */
	public double getOtherNetworkMemorySize() {
		double value = 0.0d;
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getNetworkDeviceStatus() == null 
				|| info.getSnmpDeviceStatus().getNetworkDeviceStatus().getMemoryStatus() == null
				||info.getSnmpDeviceStatus().getNetworkDeviceStatus().getMemoryStatus().getSize() == null) {
			return value;
		}
		return info.getSnmpDeviceStatus().getNetworkDeviceStatus().getMemoryStatus().getSize();
	}
	
	/**
	 * 获得 Sensor CPUS 对象集合
	 * @return
	 */
	public List<Element> getSensorCPUs() {
		List<Element> elements = new ArrayList<Element>();
		if(info.getHostResource() == null || info.getHostResource().getCpuStatus() == null || info.getHostResource().getCpuStatus().getLoads() == null) {
			return elements;
		}
		int i=0;
		for(Integer cpuNum:info.getHostResource().getCpuStatus().getLoads()) {
			if(cpuNum == null)continue;
		     Element c1 = new Node();
	          c1.setName("cpu"+i);
		      c1.putChartValue(cpuNum);
		      elements.add(c1);
		      i++;
		}
		return elements;
	}
	/**
	 * 内存已使用数
	 * @return double
	 */
	public double getSensorMemoryUsed() {
		double value = 0.0d;
		if(info.getHostResource() == null || info.getHostResource().getMemoryStatus() == null
		|| info.getHostResource().getMemoryStatus().getUsed() == null) {
			return value;
		}
		return info.getHostResource().getMemoryStatus().getUsed();
	}
	
	/**
	 * 内存大小
	 * @return double
	 */
	public double getSensorMemorySize() {
		double value = 0.0d;
		if(info.getHostResource() == null || info.getHostResource().getMemoryStatus() == null 
				|| info.getHostResource().getMemoryStatus().getSize() == null) {
			return value;
		}
		return info.getHostResource().getMemoryStatus().getSize();
	}
	
	/**
	 * 硬盘使用值
	 * @return double
	 */
	public double getSensorHardDiskUsed() {
		double value = 0.0d;
		if(info.getHostResource() == null || info.getHostResource().getHardDiskStatus() == null 
				|| info.getHostResource().getHardDiskStatus().size() == 0
				|| info.getHostResource().getHardDiskStatus().get(0).getUsed() == null) {
			return value;
		}
		return info.getHostResource().getHardDiskStatus().get(0).getUsed();
	}
	
	/**
	 * 硬盘大小
	 * @return double
	 */
	public double getSensorHardDiskSize() {
		double value = 0.0d;
		if(info.getHostResource() == null || info.getHostResource().getHardDiskStatus() == null 
				|| info.getHostResource().getHardDiskStatus().size() == 0
				|| info.getHostResource().getHardDiskStatus().get(0).getSize() == null) {
			return value;
		}
		return info.getHostResource().getHardDiskStatus().get(0).getSize();
	}
	
	
	/**
	 * 硬盘使用值
	 * @return double
	 */
	public double getHostHardDiskUsed() {
		double value = 0.0d;
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus() == null 
				|| info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus() == null
				|| info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus().getUsed() == null) {
			return value;
		}
		HardDiskStatus hardDiskStatus = info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus();
		return hardDiskStatus.getUsed();
	}
	
	/**
	 * 硬盘大小
	 * @return double
	 */
	public double getHostHardDiskSize() {
		double value = 0.0d;
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus() == null 
				|| info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus() == null
				|| info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus().getSize() == null) {
			return value;
		}
		HardDiskStatus hardDiskStatus = info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus();
		return hardDiskStatus.getSize();
	}
	
		
	/**
	 * 获取硬盘主机分区情况
	 * @return List<FileElement> 
	 */
	public List<FileElement> getHostFileElements() {
		List<FileElement> files = new ArrayList<FileElement>();
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus() == null) {
			return files;
		}
		HardDiskStatus hardDiskStatus = info.getSnmpDeviceStatus().getHostDeviceStatus().getHardDiskStatus();
		PartitionStatus[] partition = null;
		partition = hardDiskStatus.getPartitionStatus();
		if(partition == null) return files;
		for(PartitionStatus p : partition) {
			FileElement fileElement = new FileElement(p.getUsed(), (p.getSize()-p.getUsed()));
			files.add(fileElement);
		}
		return files;
	}
	
	/**
	 * 获取硬盘Sensor分区情况
	 * @return List<FileElement> 
	 */
	public List<FileElement> getSensorFileElements() {
		List<FileElement> files = new ArrayList<FileElement>();
		if(info.getHostResource() == null || info.getHostResource().getHardDiskStatus() == null) {
			return files;
		}
		List<org.infosec.ismp.agent.comm.winsensor.model.status.HardDiskStatus> hardDiskStatus = info.getHostResource().getHardDiskStatus();
		for(org.infosec.ismp.agent.comm.winsensor.model.status.HardDiskStatus p : hardDiskStatus) {
			FileElement fileElement = new FileElement(p.getUsed(), (p.getSize()-p.getUsed()));
			files.add(fileElement);
		}
		return files;
	}
	
//	
//	/**
//	 * 实现读取阈值信息方法
//	 */
//	public List<Monitor> getMonitorsAll() throws Exception {
//		MonitorManager monitor = new MonitorManager();
//		return monitor.getRows(device.getDeviceId());
//	}
	
	/**
	 * 实现读取主机网络接口信息方法
	 */
	public List<NetworkStatus> getHostNetworkStatusAll() throws Exception {
		List<NetworkStatus> statusList = new Vector<NetworkStatus>();
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus() == null || info.getSnmpDeviceStatus().getHostDeviceStatus().getNetworkStatus() == null) return statusList;
		org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus networkStatus = info.getSnmpDeviceStatus().getHostDeviceStatus().getNetworkStatus();
		if(networkStatus == null || networkStatus.getInterfaceStatus() == null) return statusList;
		InterfaceStatus[] interfacestatus = networkStatus.getInterfaceStatus();
		for(int i = 0;  interfacestatus != null && i < interfacestatus.length; i++) {
			if(interfacestatus[i] == null) continue;
			//NetworkStatus networkStatu = new NetworkStatus("接口 "+(i+1));
			NetworkStatus networkStatu = new NetworkStatus(interfacestatus[i].getDescription());
			networkStatu.setDescription(interfacestatus[i].getDescription() == null ? "" : interfacestatus[i].getDescription());
			networkStatu.setInBytes(interfacestatus[i].getInBytes() == null ? 0L : interfacestatus[i].getInBytes());
			networkStatu.setInPackets(interfacestatus[i].getInPackets() == null ? 0L : interfacestatus[i].getInPackets());
			networkStatu.setIpAddress(interfacestatus[i].getIpAddress() == null ? "" : interfacestatus[i].getIpAddress());
			networkStatu.setNetMask(interfacestatus[i].getNetMask() == null ? "" : interfacestatus[i].getNetMask());
			networkStatu.setOutBytes(interfacestatus[i].getOutBytes() == null ? 0L : interfacestatus[i].getOutBytes());
			networkStatu.setOutPackets(interfacestatus[i].getOutPackets() == null ? 0L : interfacestatus[i].getOutPackets());
			networkStatu.setPhysicalAddress(interfacestatus[i].getPhysicalAddress() == null ? "" : interfacestatus[i].getPhysicalAddress());
			networkStatu.setSpeed(interfacestatus[i].getSpeed() == null ? 0L : interfacestatus[i].getSpeed());
			statusList.add(networkStatu);
		}
		return statusList;
	}
	
	/**
	 * 实现读取其它网络接口信息方法
	 */
	public List<NetworkStatus> getOtherNetworkStatusAll() throws Exception {
		List<NetworkStatus> statusList = new Vector<NetworkStatus>();
		if(info.getSnmpDeviceStatus() == null || info.getSnmpDeviceStatus().getNetworkDeviceStatus() == null || info.getSnmpDeviceStatus().getNetworkDeviceStatus().getNetworkStatus() == null) return statusList;
		org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus networkStatus = info.getSnmpDeviceStatus().getNetworkDeviceStatus().getNetworkStatus();
		if(networkStatus == null || networkStatus.getInterfaceStatus() == null) return statusList;
		InterfaceStatus[] interfacestatus = networkStatus.getInterfaceStatus();
		for(int i = 0;  interfacestatus != null && i < interfacestatus.length; i++) {
			if(interfacestatus[i] == null) continue;
			//NetworkStatus networkStatu = new NetworkStatus("接口 "+(i+1));
			NetworkStatus networkStatu = new NetworkStatus(interfacestatus[i].getDescription());
			networkStatu.setDescription(interfacestatus[i].getDescription() == null ? "" : interfacestatus[i].getDescription());
			networkStatu.setInBytes(interfacestatus[i].getInBytes() == null ? 0L : interfacestatus[i].getInBytes());
			networkStatu.setInPackets(interfacestatus[i].getInPackets() == null ? 0L : interfacestatus[i].getInPackets());
			networkStatu.setIpAddress(interfacestatus[i].getIpAddress() == null ? "" : interfacestatus[i].getIpAddress());
			networkStatu.setNetMask(interfacestatus[i].getNetMask() == null ? "" : interfacestatus[i].getNetMask());
			networkStatu.setOutBytes(interfacestatus[i].getOutBytes() == null ? 0L : interfacestatus[i].getOutBytes());
			networkStatu.setOutPackets(interfacestatus[i].getOutPackets() == null ? 0L : interfacestatus[i].getOutPackets());
			networkStatu.setPhysicalAddress(interfacestatus[i].getPhysicalAddress() == null ? "" : interfacestatus[i].getPhysicalAddress());
			networkStatu.setSpeed(interfacestatus[i].getSpeed() == null ? 0L : interfacestatus[i].getSpeed());
			statusList.add(networkStatu);
		}
		return statusList;
	}
	
	/**
	 * 实现读取Sensor网络接口信息方法
	 */
	public List<NetworkStatus> getSensorNetworkStatusAll() throws Exception {
		List<NetworkStatus> statusList = new Vector<NetworkStatus>();
		if(info.getHostResource() == null || info.getHostResource().getNetworkStatus() == null ) return statusList;
		List<org.infosec.ismp.agent.comm.winsensor.model.status.NetworkStatus> networkStatus = info.getHostResource().getNetworkStatus();
		for(org.infosec.ismp.agent.comm.winsensor.model.status.NetworkStatus interfacestatus:networkStatus) {
			if(interfacestatus == null) continue;
			//NetworkStatus networkStatu = new NetworkStatus("接口 "+(i+1));
			NetworkStatus networkStatu = new NetworkStatus(interfacestatus.getDescription());
			networkStatu.setDescription(interfacestatus.getDescription() == null ? "" : interfacestatus.getDescription());
			networkStatu.setInBytes(interfacestatus.getRecBytesPreSec() == null ? 0L : interfacestatus.getRecBytesPreSec());
			networkStatu.setInPackets(interfacestatus.getRecPacket() == null ? 0L : interfacestatus.getRecPacket());
			networkStatu.setIpAddress(interfacestatus.getIpAddress() == null ? "" : interfacestatus.getIpAddress().toString());
			networkStatu.setNetMask(interfacestatus.getMac() == null ? "" : interfacestatus.getMac());
			networkStatu.setOutBytes(interfacestatus.getSendBytesPreSec() == null ? 0L : interfacestatus.getSendBytesPreSec());
			networkStatu.setOutPackets(interfacestatus.getSendPacket() == null ? 0L : interfacestatus.getSendPacket());
			statusList.add(networkStatu);
		}
		return statusList;
	}
	
	/**
	 * 实现读主机取线程信息方法
	 */
	public List<Process> getHostProcessAll() throws Exception {
		List<Process> processList = new ArrayList<Process>();
		if(info.getSnmpDeviceStatus() == null ||info.getSnmpDeviceStatus().getHostDeviceStatus()==null) return processList;
		if(info.getSnmpDeviceStatus().getHostDeviceStatus().getProcessesStatus() == null) return processList;
		ProcessesStatus processes = info.getSnmpDeviceStatus().getHostDeviceStatus().getProcessesStatus();
		if(processes == null) return processList;
		 for (ProcessStatus statu:processes.getProcessStatus()) {
			 Process process = new Process();
				process.setProcessName(statu.getName() == null ? "" : statu.getName());
				process.setProcessDesciption(statu.getDescription() == null ? "" : statu.getDescription());
				process.setProcessRunPath(statu.getRunPath() == null ? "" : statu.getRunPath());
				process.setProcessMemory(statu.getAllocatedMemorySize() == null ? 0L : statu.getAllocatedMemorySize());
				process.setProcessCpuTime(statu.getConsumedCPUTime() == null ? 0L : statu.getConsumedCPUTime());
				processList.add(process);
	 	}		 
		return processList;
	}
	/**
	 * 实现读主机取线程信息方法
	 */
	public List<Process> getSensorProcessAll() throws Exception {
		List<Process> processList = new ArrayList<Process>();
		if(info.getHostResource() == null ||info.getHostResource().getProcessStatus()==null) return processList;
		List<org.infosec.ismp.agent.comm.winsensor.model.status.ProcessStatus> processes = info.getHostResource().getProcessStatus();
		if(processes == null) return processList;
		 for (org.infosec.ismp.agent.comm.winsensor.model.status.ProcessStatus statu:processes) {
			 Process process = new Process();//statu.getPid()
				process.setProcessName(statu.getName() == null ? "" : statu.getName());
				process.setProcessDesciption(statu.getDescription() == null ? "" : statu.getDescription());
				process.setProcessRunPath(statu.getRunPath() == null ? "" : statu.getRunPath());
				process.setProcessMemory(statu.getAllocatedMemorySize() == null ? 0L : statu.getAllocatedMemorySize());
				process.setProcessCpuTime(statu.getConsumedCPUTime() == null ? 0L : statu.getConsumedCPUTime());
				processList.add(process);
	 	}		 
		return processList;
	}
	
	/**
	 * 实现读取Sensor信息方法
	 */
	public Sensor getSensor() throws Exception {
		Sensor sensor = new Sensor();
		if(info == null || device.getSensor() == null || info.getHostResource()== null ) return sensor;
		LocalSystemStatus local = info.getHostResource().getLocalSystemlStatus();
		WinsensorClientStatus client = info.getHostResource().getWinsensorClientStatus();
		sensor.setSensorIP(device.getIpAddress());
		sensor.setSensorId(device.getSensor().getSensorId() == null ? "" : device.getSensor().getSensorId());
		if(local != null) {
			sensor.setSysConfigDesc(local.getPhyInfo());
			sensor.setSysDesc(local.getDescription());
			sensor.setSysName(local.getComputerName());
			sensor.setSysInfo(local.getOsInfo());
			sensor.setRegInfo(local.getRegistry());
			sensor.setWorkSpaceName(local.getDomain());
		}
		if(client != null) {
			sensor.setUpdateURL(client.getAutoUpdateUrl());
			sensor.setSensorLocalPath(client.getAutoUpdateUrl());
			sensor.setSensorServVersion(client.getServiceVersion());
			sensor.setVistion(client.getVersion());
		}
		return sensor;
	}
	
	


	public NodeModel getDevice() {
		return device;
	}


	public void setInfo(DeviceInformation info) {
		this.info = info;
	}
}
