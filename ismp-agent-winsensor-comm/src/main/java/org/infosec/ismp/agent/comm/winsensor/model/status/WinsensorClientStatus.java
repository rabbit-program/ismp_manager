package org.infosec.ismp.agent.comm.winsensor.model.status;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Rocky
 * @version create time：Oct 15, 2010 11:14:52 AM
 * 
 */
public class WinsensorClientStatus implements Serializable {

	private static final long serialVersionUID = 1972855436635402322L;

	/*
	 * Sensor client id.
	 */
	private String sensorId;
	
	/*
	 * Sensor client version.
	 */
	private String version;
	
	/*
	 * Sensor client service version.
	 */
	private String serviceVersion;
	
	/*
	 * Sensor client last update time.
	 */
	private Date lastUpdateTime;
	
	/*
	 * Sensor client auto update address.
	 */
	private String autoUpdateUrl;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getAutoUpdateUrl() {
		return autoUpdateUrl;
	}

	public void setAutoUpdateUrl(String autoUpdateUrl) {
		this.autoUpdateUrl = autoUpdateUrl;
	}
}
