package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**  
 * @Title: SoftwareRecordCenterBO.java
 * @Package edu.sjtu.infosec.ismp.center.virus.software.model
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-9-3 上午11:42:22   
 * @version V1.0  
 */
/**
 * @ClassName: SoftwareRecordManagerBO
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-9-3 上午11:42:22
 * 
 */
@Entity
@Table(name = "vpm_sd_record_manager")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class SoftwareRecordManagerBO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 2927718253459364208L;
	/** 编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * sensor 唯一标示符号
	 */
	@Column(name = "sensor_id")
	private String sensorId;
	/**
	 * 软件名
	 */
	@Column(name = "software_name")
	private String softwareName;

	/**
	 * 软件下载时间
	 */
	@Column(name = "download_time")
	private Timestamp downloadTime;

	/**
	 * 软件安装时间
	 */
	@Column(name = "setup_time")
	private Timestamp setupTime;

	/**
	 * 软件安装状态 0:未安装 1:安装并且安装成功 2:安装了,但未安装成功
	 */
	@Column(name = "setup_status")
	private Integer setupStatus;
	/**
	 * 软件下载状态 0:未下载 1:下载了并且已经成功 2:下载了,但未成功
	 */
	@Column(name = "download_status")
	private Integer downloadStatus;
	/**
	 * 软件安装后的验证状态 0:不需要验证 1:验证成功 2:验证不成功
	 */
	@Column(name = "validation_status")
	private Integer validationStatus;

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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param vId
	 *            the id to set
	 */
	public void setId(Integer vId) {
		id = vId;
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
	public Integer getSetupStatus() {
		return setupStatus;
	}

	/**
	 * @param vSetupStatus
	 *            the setupStatus to set
	 */
	public void setSetupStatus(Integer vSetupStatus) {
		setupStatus = vSetupStatus;
	}

	/**
	 * @return the downloadStatus
	 */
	public Integer getDownloadStatus() {
		return downloadStatus;
	}

	/**
	 * @param vDownloadStatus
	 *            the downloadStatus to set
	 */
	public void setDownloadStatus(Integer vDownloadStatus) {
		downloadStatus = vDownloadStatus;
	}

	/**
	 * @return the validationStatus
	 */
	public Integer getValidationStatus() {
		return validationStatus;
	}

	/**
	 * @param vValidationStatus
	 *            the validationStatus to set
	 */
	public void setValidationStatus(Integer vValidationStatus) {
		validationStatus = vValidationStatus;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		if (!(other instanceof SoftwareRecordManagerBO))
			return false;
		SoftwareRecordManagerBO castOther = (SoftwareRecordManagerBO) other;
		return new EqualsBuilder().append(sensorId, castOther.sensorId).append(
				softwareName, castOther.softwareName).isEquals();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(id).append(sensorId).append(
				downloadStatus).append(downloadTime).append(setupStatus)
				.append(setupTime).append(softwareName)
				.append(validationStatus).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new ToStringBuilder(this).append("id", id).append(
				"downloadStatus", downloadStatus).append("downloadTime",
				downloadTime).append("sensorId", sensorId).append(
				"setupStatus", setupStatus).append("setupTime", setupTime)
				.append("softwareName", softwareName).append(
						"validationStatus", validationStatus).toString();
	}
}
