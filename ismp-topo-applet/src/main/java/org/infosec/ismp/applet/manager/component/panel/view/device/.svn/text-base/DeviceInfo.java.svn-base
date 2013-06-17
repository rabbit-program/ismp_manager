package org.infosec.ismp.applet.manager.component.panel.view.device;

import java.util.LinkedHashMap;
import java.util.Map;

import org.infosec.ismp.applet.manager.component.panel.view.Info;

/**
 * 设备基本信息 编号 名称 设备厂家 品牌 型号 创建人 数据代理
 */
public class DeviceInfo extends Info {
	private String deviceNumber;
	private String deviceName;
	private String company;
	private String deviceTradeMark;
	private String deviceModelNum;
	private String creater;
	private String agentId;

	private Map clientProperties = new LinkedHashMap();
	public static final String CLIENTPREFIX = "clientprefix";

	public DeviceInfo() {
	}

	public void putClientProperty(Object key, Object value) {
		Object oldValue = clientProperties.get(key);
		if (value != null) {
			clientProperties.put(key, value);
		} else if (oldValue != null) {
			clientProperties.remove(key);
		}
		if (oldValue != value) {
			this.firePropertyChange(CLIENTPREFIX + key.toString(), oldValue, value);
		}
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		String old = this.deviceNumber;
		this.deviceNumber = deviceNumber;
		this.firePropertyChange("deviceNumber", old, deviceNumber);
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		String old = this.deviceName;
		this.deviceName = deviceName;
		this.firePropertyChange("deviceName", old, deviceName);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		String old = this.company;
		this.company = company;
		this.firePropertyChange("company", old, company);
	}

	public String getDeviceTradeMark() {
		return deviceTradeMark;
	}

	public void setDeviceTradeMark(String deviceTradeMark) {
		String old = this.deviceTradeMark;
		this.deviceTradeMark = deviceTradeMark;
		this.firePropertyChange("deviceTradeMark", old, deviceTradeMark);
	}

	public String getDeviceModelNum() {
		return deviceModelNum;
	}

	public void setDeviceModelNum(String deviceModelNum) {
		String old = this.deviceModelNum;
		this.deviceModelNum = deviceModelNum;
		this.firePropertyChange("deviceModelNum", old, deviceModelNum);
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		String old = this.creater;
		this.creater = creater;
		this.firePropertyChange("creater", old, creater);
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		String old = this.agentId;
		this.agentId = agentId;
		this.firePropertyChange("agentId", old, agentId);
	}

	public Map getClientProperties() {
		return clientProperties;
	}

}
