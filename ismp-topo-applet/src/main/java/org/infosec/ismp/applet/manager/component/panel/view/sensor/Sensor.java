package org.infosec.ismp.applet.manager.component.panel.view.sensor;

import java.util.LinkedHashMap;
import java.util.Map;
import org.infosec.ismp.applet.manager.component.panel.view.Info;

public class Sensor extends Info{
	/**
	 * sensorID
	 */
	private String sensorId;
	/**
	 * 主机名
	 */
	private String sysName;
	/**
	 * 操作系统信息
	 */
	private String sysInfo;
	/**
	 * 注册到信息
	 */
	private String regInfo;
	/**
	 * 系统配置描述
	 */
	private String sysConfigDesc;
	/**
	 * 工作组名
	 */
	private String workSpaceName;
	/**
	 * 计算机描述
	 */
	private String sysDesc;
	/**
	 * 版本号
	 */
	private String vistion;
	
	/**
	 * sensorIP
	 */
	private String sensorIP;
	
	/**
	 * sensor安装目录
	 */
    private String sensorLocalPath;
    /**
     * 更新目录
     */
    private String updateURL;
	/**
	 * @return the sensorVersion
	 */
    
    /**
	 * sensor service 版本号
	 */
    private String sensorServVersion;
    
	public Sensor() {
		
	}
	private Map clientProperties = new LinkedHashMap();
	public static final String CLIENTPREFIX = "clientprefix";
	
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
	
	/**
	 * @return the sensorId
	 */
	public String getSensorId() {
		return sensorId;
	}

	/**
	 * @param sensorId
	 *            the sensorId to set
	 */
	public void setSensorId(String sensorId) {
		String old = this.sensorId;
		this.sensorId = sensorId;
		this.firePropertyChange("sensorId", old,sensorId);
	}

	/**
	 * @return the sysName
	 */
	public String getSysName() {
		return sysName;
	}

	/**
	 * @param sysName
	 *            the sysName to set
	 */
	public void setSysName(String sysName) {
		String old = this.sysName;
		this.sysName = sysName;
		this.firePropertyChange("sysName", old, sysName);
	}

	/**
	 * @return the sysInfo
	 */
	public String getSysInfo() {
		return sysInfo;
	}

	/**
	 * @param sysInfo
	 *            the sysInfo to set
	 */
	public void setSysInfo(String sysInfo) {
		String old = this.sysInfo;
		this.sysInfo = sysInfo;
		this.firePropertyChange("sysInfo", old, sysInfo);
	}

	/**
	 * @return the regInfo
	 */
	public String getRegInfo() {
		return regInfo;
	}

	/**
	 * @param regInfo
	 *            the regInfo to set
	 */
	public void setRegInfo(String regInfo) {
		String old = this.regInfo;
		this.regInfo = regInfo;
		this.firePropertyChange("regInfo", old, regInfo);
	}

	/**
	 * @return the sysConfigDesc
	 */
	public String getSysConfigDesc() {
		return sysConfigDesc;
	}

	/**
	 * @param sysConfigDesc
	 *            the sysConfigDesc to set
	 */
	public void setSysConfigDesc(String sysConfigDesc) {
		String old = this.sysConfigDesc;
		this.sysConfigDesc = sysConfigDesc;
		this.firePropertyChange("sysConfigDesc", old, sysConfigDesc);
	}

	/**
	 * @return the workSpaceName
	 */
	public String getWorkSpaceName() {
		return workSpaceName;
	}

	/**
	 * @param workSpaceName
	 *            the workSpaceName to set
	 */
	public void setWorkSpaceName(String workSpaceName) {
		String old = this.workSpaceName;
		this.workSpaceName = workSpaceName;
		this.firePropertyChange("workSpaceName", old, workSpaceName);
	}

	/**
	 * @return the sysDesc
	 */
	public String getSysDesc() {
		return sysDesc;
	}

	/**
	 * @param sysDesc
	 *            the sysDesc to set
	 */
	public void setSysDesc(String sysDesc) {
		String old = this.sysDesc;
		this.sysDesc = sysDesc;
		this.firePropertyChange("sysDesc", old, sysDesc);
	}

	public String getVistion() {
		return vistion;
	}

	public void setVistion(String vistion) {
		String old = this.vistion;
		this.vistion = vistion;
		this.firePropertyChange("vistion", old, vistion);
	}

	public String getSensorLocalPath() {
		return sensorLocalPath;
	}

	public void setSensorLocalPath(String sensorLocalPath) {
		String old = this.sensorLocalPath;
		this.sensorLocalPath = sensorLocalPath;
		this.firePropertyChange("sensorLocalPath", old, sensorLocalPath);
	}

	public String getUpdateURL() {
		return updateURL;
	}

	public void setUpdateURL(String updateURL) {
		String old = this.updateURL;
		this.updateURL = updateURL;
		this.firePropertyChange("updateURL", old, updateURL);
		
	}

	public String getSensorServVersion() {
		return sensorServVersion;
	}

	public void setSensorServVersion(String sensorServVersion) {
		String old = this.sensorServVersion;
		this.sensorServVersion = sensorServVersion;
		this.firePropertyChange("sensorServVersion", old, sensorServVersion);
	}

	public String getSensorIP() {
		return sensorIP;
	}

	public void setSensorIP(String sensorIP) {
		this.sensorIP = sensorIP;
	}
		
}
