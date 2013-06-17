package edu.sjtu.infosec.ismp.manager.TM.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.CommWinsensorDevice;
import org.infosec.ismp.manager.rmi.db.model.DbCollectionRmiBean;
import org.infosec.ismp.manager.rmi.db.service.DbCollectionServiceMonitor;
import org.infosec.ismp.manager.rmi.sensor.service.WinsensorBasicInfoService;
import org.infosec.ismp.manager.rmi.sensor.service.WinsensorTopoManagerService;
import org.infosec.ismp.manager.rmi.snmp.model.SnmpDeviceRmiBean;
import org.infosec.ismp.manager.rmi.snmp.service.SnmpDeviceMonitorRmi;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoManagerService;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TopoManagerServiceImpl implements TopoManagerService{
	private WinsensorTopoManagerService winsensorTopoManagerService;
	private WinsensorBasicInfoService winsensorBasicInfoService;
	private DbCollectionServiceMonitor dbCollectionServiceMonitor;
	private SnmpDeviceMonitorRmi snmpDeviceMonitorRmi;
	private TopoWebService topoWebService;
	
	public void setWinsensorTopoManagerService(
			WinsensorTopoManagerService winsensorTopoManagerService) {
		this.winsensorTopoManagerService = winsensorTopoManagerService;
	}

	public void setWinsensorBasicInfoService(
			WinsensorBasicInfoService winsensorBasicInfoService) {
		this.winsensorBasicInfoService = winsensorBasicInfoService;
	}

	public void setDbCollectionServiceMonitor(
			DbCollectionServiceMonitor dbCollectionServiceMonitor) {
		this.dbCollectionServiceMonitor = dbCollectionServiceMonitor;
	}

	public void setSnmpDeviceMonitorRmi(SnmpDeviceMonitorRmi snmpDeviceMonitorRmi) {
		this.snmpDeviceMonitorRmi = snmpDeviceMonitorRmi;
	}
	

	public void setTopoWebService(TopoWebService topoWebService) {
		this.topoWebService = topoWebService;
	}

	@Transactional(readOnly=false)
	public void activeDevice(DeviceEntity device) throws Exception{
		if(device == null || device.getNode() == null 
				||device.getNode().getType()==null 
				|| device.getNode().getType().getEnglishTag() == null) {
			return ;
		}
		String deviceType = device.getNode().getType().getEnglishTag();
		if(deviceType.equals("pc")) {
			winsensorTopoManagerService.startMonitorSensorDevice(device.getNode().getNodeId());
		} else if(deviceType.equals("database") && device.getDatabase() != null) {
			DbCollectionRmiBean dbCollectionRmiBean = new DbCollectionRmiBean();
//			if(device.getNode().getParentDomain() != null) {
//				dbCollectionRmiBean.setDomain(device.getNode().getParentDomain().getId()+"");
//			}
			dbCollectionRmiBean.setDomain(device.getNode().getParentDomain() == null ? "":device.getNode().getParentDomain().getDomainName());
			dbCollectionRmiBean.setNodeid(device.getNode().getNodeId());
			dbCollectionRmiBean.setUrl(device.getDatabase().getUrl());
			dbCollectionRmiBean.setPort(1521);
			dbCollectionRmiBean.setUsername(device.getDatabase().getUsername());
			dbCollectionRmiBean.setPassword(device.getDatabase().getPassword());
			dbCollectionRmiBean.setDbtype(device.getDatabase().getType());
			dbCollectionRmiBean.setVersion(device.getDatabase().getVersion());
			dbCollectionRmiBean.setInterval(device.getDatabase().getUpInterval());
			dbCollectionRmiBean.setDbname(device.getDatabase().getDatabaseName());
			dbCollectionServiceMonitor.addDatabaseColletor(dbCollectionRmiBean);
		} else if(device.getSnmp() != null){
			SnmpDeviceRmiBean snmpDeviceRmiBean = new SnmpDeviceRmiBean();
//			if(device.getNode().getParentDomain() != null) {
//				snmpDeviceRmiBean.setDomain(device.getNode().getParentDomain().getId()+"");
//			}
			snmpDeviceRmiBean.setDomain(device.getNode().getParentDomain() == null ? "":device.getNode().getParentDomain().getDomainName());
			snmpDeviceRmiBean.setNodeid(device.getNode().getNodeId());
			snmpDeviceRmiBean.setIpAddr(device.getNode().getIpAddress());
			snmpDeviceRmiBean.setPort(Integer.parseInt(device.getSnmp().getPort()));
			snmpDeviceRmiBean.setVersion(device.getSnmp().getVersion());
			snmpDeviceRmiBean.setCommunity(device.getSnmp().getCommunity());
			if(deviceType.equals("server")) {
				snmpDeviceRmiBean.setDeviceType("server");
				snmpDeviceRmiBean.setBrand("server");
			} else if(deviceType.equals("weblogic")) {
				snmpDeviceRmiBean.setDeviceType("weblogic");
				snmpDeviceRmiBean.setBrand("weblogic");
			} else {
				snmpDeviceRmiBean.setDeviceType(deviceType);
				if(device.getNode().getBrand() != null)
				snmpDeviceRmiBean.setBrand(device.getNode().getBrand().getEnName());
			}
			snmpDeviceMonitorRmi.addSnmpDeviceMonitor(snmpDeviceRmiBean);
		}
		topoWebService.saveOrUpdateNode(device.getNode());
	}
	
	@Transactional(readOnly=false)
	public void activeDevice(List<DeviceEntity> devices) throws Exception{
		for(DeviceEntity device:devices) {
			activeDevice(device);
		}
	}
	
	@Transactional(readOnly=false)
	public void deleteDevice(DeviceEntity device) throws Exception{
		if(device == null || device.getNode() == null 
				||device.getNode().getType()==null 
				|| device.getNode().getType().getEnglishTag() == null) {
			return ;
		}
		String deviceType = device.getNode().getType().getEnglishTag();
		if(deviceType.equals("pc")) {
			winsensorTopoManagerService.deleteSensorDevice(device.getNode().getNodeId());
		} else if(deviceType.equals("database")) {
			dbCollectionServiceMonitor.removeDatabaseColletor(device.getNode().getNodeId());
		} else {
			snmpDeviceMonitorRmi.removeSnmpDeviceMonitor(device.getNode().getNodeId());
		}
		topoWebService.deleteNode(device.getNode());
	}
	
	@Transactional(readOnly=false)
	public void deleteDevice(List<DeviceEntity> devices) throws Exception{
		for(DeviceEntity device:devices) {
			deleteDevice(device);
		}
	}
	
	@Transactional(readOnly=false)
	public List<String> getDevicePorts(DeviceEntity device) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(readOnly=false)
	public DeviceInformation getInformation(DeviceEntity device) throws Exception{
		DeviceInformation deviceInformation = new DeviceInformation();
		if(device == null || device.getNode() == null 
				||device.getNode().getType()==null 
				|| device.getNode().getType().getEnglishTag() == null) {
			return null;
		}
		String deviceType = device.getNode().getType().getEnglishTag();
		if(deviceType.equals("pc")) {
			deviceInformation.setHostResource(winsensorBasicInfoService.getHostResource(device.getNode().getNodeId()));
		} else if(deviceType.equals("database")) {
			deviceInformation.setDatabaseResultStatus(dbCollectionServiceMonitor.getDatabaseResult(device.getNode().getNodeId()));
		} else {
			deviceInformation.setSnmpDeviceStatus(snmpDeviceMonitorRmi.getSnmpDeviceStatus(device.getNode().getNodeId()));
		}
		return deviceInformation;
	}
	
	@Transactional(readOnly=false)
	public List<String> getLinkFlows(DeviceEntity device) throws Exception{
		//TODO
		return null;
	}
	
	@Transactional(readOnly=false)
	public void unActiveDevice(DeviceEntity device) throws Exception{
		if(device == null || device.getNode() == null 
				||device.getNode().getType()==null 
				|| device.getNode().getType().getEnglishTag() == null) {
			return ;
		}
		
		String deviceType = device.getNode().getType().getEnglishTag();
		if(deviceType.equals("pc")) {
			winsensorTopoManagerService.pauseMonitorSensorDevice(device.getNode().getNodeId());
		} else if(deviceType.equals("database")) {
			dbCollectionServiceMonitor.removeDatabaseColletor(device.getNode().getNodeId());
		} else {
			snmpDeviceMonitorRmi.removeSnmpDeviceMonitor(device.getNode().getNodeId());
		}
		topoWebService.saveOrUpdateNode(device.getNode());
	}
	
	@Transactional(readOnly=false)
	public void unActiveDevice(List<DeviceEntity> devices) throws Exception{
		for(DeviceEntity device:devices) {
			unActiveDevice(device);
		}
	}
	
	@Transactional(readOnly=false)
	public void allotSensorDomain(List<DeviceEntity> devices) throws Exception {
		if(devices ==null || devices.size() == 0) return;
		List<CommWinsensorDevice> sensorList = new ArrayList<CommWinsensorDevice>();
		for(DeviceEntity device:devices) {
			if(device.getSensor() != null) {
				CommWinsensorDevice commWinsensorDevice = new CommWinsensorDevice();
				commWinsensorDevice.setIp(device.getNode().getIpAddress());
				commWinsensorDevice.setMac(device.getSensor().getMac());
				commWinsensorDevice.setSensorId(device.getSensor().getSensorId());
				commWinsensorDevice.setNodeId(device.getNode().getNodeId());
				if(device.getNode().getParentDomain() != null) {
					commWinsensorDevice.setDomainId(device.getNode().getParentDomain().getId()+"");
				}
				sensorList.add(commWinsensorDevice);
				topoWebService.saveOrUpdateNode(device.getNode());
			} 
		}
		winsensorTopoManagerService.addSensorDevices(sensorList);
	}
}
