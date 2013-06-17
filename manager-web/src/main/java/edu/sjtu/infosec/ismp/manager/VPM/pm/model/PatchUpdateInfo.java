package edu.sjtu.infosec.ismp.manager.VPM.pm.model;

import java.io.Serializable;

/**
 * 补丁更新信息
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class PatchUpdateInfo implements Serializable {
//	private Integer id;
	private PatchInfo patchInfo;
	private SensorClients sensorClients;
	private String updateId;
	private String computerTargetId;
	private int state;
//	private String remarks;



	public PatchInfo getPatchInfo() {
		return patchInfo;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getComputerTargetId() {
		return computerTargetId;
	}

	public void setComputerTargetId(String computerTargetId) {
		this.computerTargetId = computerTargetId;
	}

	public void setPatchInfo(PatchInfo patchInfo) {
		this.patchInfo = patchInfo;
	}

	public SensorClients getSensorClients() {
		return sensorClients;
	}

	public void setSensorClients(SensorClients sensorClients) {
		this.sensorClients = sensorClients;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
