package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;
import java.sql.Timestamp;

/**  
 * @Title: SoftwareRecordManagerContainer.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.container
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-9-7 上午10:25:43   
 * @version V1.0  
 */
/**
 * @ClassName: SoftwareRecordManagerContainer
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-9-7 上午10:25:43
 * 
 */
public class SoftwareRecordManagerContainer implements Serializable {
	
	/**
	* @Fields serialVersionUID : 
	*    TODO
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * sensor 唯一标示符号
	 */
	private String sensorId;
	/**
	 * 软件名
	 */
	private String softwareName;

	/**
	 * 软件下载时间
	 */
	private Timestamp downloadTime;

	/**
	 * 软件安装时间
	 */
	private Timestamp setupTime;

	/**
	 * 软件安装状态 0:未安装 1:安装并且安装成功 2:安装了,但未安装成功
	 */
	private int setupStatus;
	/**
	 * 软件下载状态 0:未下载 1:下载了并且已经成功 2:下载了,但未成功
	 */
	private int downloadStatus;
	/**
	 * 软件安装后的验证状态 0:不需要验证 1:验证成功 2:验证不成功
	 */
	private int validationStatus;

	/**
	 * @return the sensorId
	 */
	public String getSensorId() {
		return sensorId;
	}

	/**
	 * @param vSensorId
	 *            the sensorId to set
	 */
	public void setSensorId(String vSensorId) {
		sensorId = vSensorId;
	}

	/**
	 * @return the softwareName
	 */
	public String getSoftwareName() {
		return softwareName;
	}

	/**
	 * @param vSoftwareName
	 *            the softwareName to set
	 */
	public void setSoftwareName(String vSoftwareName) {
		softwareName = vSoftwareName;
	}

	/**
	 * @return the downloadTime
	 */
	public Timestamp getDownloadTime() {
		return downloadTime;
	}

	/**
	 * @param vDownloadTime
	 *            the downloadTime to set
	 */
	public void setDownloadTime(Timestamp vDownloadTime) {
		downloadTime = vDownloadTime;
	}

	/**
	 * @return the setupTime
	 */
	public Timestamp getSetupTime() {
		return setupTime;
	}

	/**
	 * @param vSetupTime
	 *            the setupTime to set
	 */
	public void setSetupTime(Timestamp vSetupTime) {
		setupTime = vSetupTime;
	}

	/**
	 * @return the setupStatus
	 */
	public int getSetupStatus() {
		return setupStatus;
	}

	/**
	 * @param vSetupStatus
	 *            the setupStatus to set
	 */
	public void setSetupStatus(int vSetupStatus) {
		setupStatus = vSetupStatus;
	}

	/**
	 * @return the downloadStatus
	 */
	public int getDownloadStatus() {
		return downloadStatus;
	}

	/**
	 * @param vDownloadStatus
	 *            the downloadStatus to set
	 */
	public void setDownloadStatus(int vDownloadStatus) {
		downloadStatus = vDownloadStatus;
	}

	/**
	 * @return the validationStatus
	 */
	public int getValidationStatus() {
		return validationStatus;
	}

	/**
	 * @param vValidationStatus
	 *            the validationStatus to set
	 */
	public void setValidationStatus(int vValidationStatus) {
		validationStatus = vValidationStatus;
	}
}
