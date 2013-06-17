package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "vpm_sd_sensor_info")
public class SensorInfoBO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * sensor name
     */
    @Column(name = "sensor_name")
    private String sensorName;
    
    /**
     * sensor sequence
     */
    @Column(name = "sensor_sequence")
    private String sensorSequence;
    
    
    /**
     * department_sequence
     */
    @Column(name = "dep_sequence")
    private String departmentSequence;
    
    /**
     * device_single_code
     */
    @Column(name = "device_single_code")
    private String deviceSingleCode;

    /**
     * creat_date
     */
    @Column(name = "create_date")
    private Date createDate;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the sensorName
	 */
	public String getSensorName() {
		return sensorName;
	}

	/**
	 * @param sensorName the sensorName to set
	 */
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	/**
	 * @return the sensorSequence
	 */
	public String getSensorSequence() {
		return sensorSequence;
	}

	/**
	 * @param sensorSequence the sensorSequence to set
	 */
	public void setSensorSequence(String sensorSequence) {
		this.sensorSequence = sensorSequence;
	}

	/**
	 * @return the departmentSequence
	 */
	public String getDepartmentSequence() {
		return departmentSequence;
	}

	/**
	 * @param departmentSequence the departmentSequence to set
	 */
	public void setDepartmentSequence(String departmentSequence) {
		this.departmentSequence = departmentSequence;
	}

	/**
	 * @return the deviceSingleCode
	 */
	public String getDeviceSingleCode() {
		return deviceSingleCode;
	}

	/**
	 * @param deviceSingleCode the deviceSingleCode to set
	 */
	public void setDeviceSingleCode(String deviceSingleCode) {
		this.deviceSingleCode = deviceSingleCode;
	}


	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(final Object other) {
		if (!(other instanceof SensorInfoBO))
			return false;
		SensorInfoBO castOther = (SensorInfoBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(sensorName,
				castOther.sensorName).append(sensorSequence,
				castOther.sensorSequence).append(departmentSequence,
				castOther.departmentSequence).append(deviceSingleCode,
				castOther.deviceSingleCode).append(createDate,
				castOther.createDate).isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(sensorName).append(
				sensorSequence).append(departmentSequence).append(
				deviceSingleCode).append(createDate).toHashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("sensorName",
				sensorName).append("sensorSequence", sensorSequence).append(
				"departmentSequence", departmentSequence).append(
				"deviceSingleCode", deviceSingleCode).append("createDate",
				createDate).toString();
	}
	
}
