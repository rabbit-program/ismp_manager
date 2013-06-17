package org.infosec.ismp.manager.rmi.tm.manager.service;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;

/**
 * @author 拓扑管理与后台关联接口
 */
public interface TopoManagerService {
	//添加分配域以后的Sensor
	public void allotSensorDomain(List<DeviceEntity> device) throws Exception;
	//激活设备
	public void activeDevice(DeviceEntity device) throws Exception;
	//激活设备
	public void activeDevice(List<DeviceEntity> devices) throws Exception;
	//激活设备
	public void unActiveDevice(DeviceEntity device) throws Exception;
	//激活设备
	public void unActiveDevice(List<DeviceEntity> devices) throws Exception;
	//删除设备
	public void deleteDevice(DeviceEntity device) throws Exception;
	//删除设备
	public void deleteDevice(List<DeviceEntity> device) throws Exception;
	
	//获取线端口
	public List<String> getDevicePorts(DeviceEntity device) throws Exception;
	//获取线流量
	public List<String> getLinkFlows(DeviceEntity device) throws Exception;
	
	//获取动态信息
	public DeviceInformation getInformation(DeviceEntity device) throws Exception;
	
}
