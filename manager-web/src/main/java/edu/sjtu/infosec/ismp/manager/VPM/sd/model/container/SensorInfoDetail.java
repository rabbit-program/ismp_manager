package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName: SensorInfoDetail
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-12-29 上午03:14:00
 * 
 */
public class SensorInfoDetail implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * add,update,delete
	 */
	private String operateTag;
	private String sensorSequence;
	private String sensorName;
	private String ip;
	private String mac;
	private String deviceSingleCode;
	private String deviceName;
	private String departmentSequence;
	private String departmentName;
	private Timestamp createDate;
	private Long sensorId;

	/**
	 * @return the operateTag
	 */
	public String getOperateTag() {
		return operateTag;
	}

	/**
	 * @param operateTag
	 *            the operateTag to set
	 */
	public void setOperateTag(String operateTag) {
		this.operateTag = operateTag;
	}

	/**
	 * @return the sensorSequence
	 */
	public String getSensorSequence() {
		return sensorSequence;
	}

	/**
	 * @param sensorSequence
	 *            the sensorSequence to set
	 */
	public void setSensorSequence(String sensorSequence) {
		this.sensorSequence = sensorSequence;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * @param mac
	 *            the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return the deviceSingleCode
	 */
	public String getDeviceSingleCode() {
		return deviceSingleCode;
	}

	/**
	 * @param deviceSingleCode
	 *            the deviceSingleCode to set
	 */
	public void setDeviceSingleCode(String deviceSingleCode) {
		this.deviceSingleCode = deviceSingleCode;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the departmentSequence
	 */
	public String getDepartmentSequence() {
		return departmentSequence;
	}

	/**
	 * @param departmentSequence
	 *            the departmentSequence to set
	 */
	public void setDepartmentSequence(String departmentSequence) {
		this.departmentSequence = departmentSequence;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName
	 *            the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the createDate
	 */
	public Timestamp getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the sensorName
	 */
	public String getSensorName() {
		return sensorName;
	}

	/**
	 * @param sensorName
	 *            the sensorName to set
	 */
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	/**
	 * @return the sensorId
	 */
	public Long getSensorId() {
		return sensorId;
	}

	/**
	 * @param sensorId
	 *            the sensorId to set
	 */
	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}

}
