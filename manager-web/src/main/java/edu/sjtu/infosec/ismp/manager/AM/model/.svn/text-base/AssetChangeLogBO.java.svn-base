package edu.sjtu.infosec.ismp.manager.AM.model;

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


@Entity
@Table(name = "am_change_log")
@org.hibernate.annotations.Entity(dynamicUpdate = true)
public class AssetChangeLogBO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "device_id")
	private Integer deviceId;
	@Column(name = "status_before")
	private String statusBefore;
	@Column(name = "status_after")
	private String statusAfter;
	@Column(name = "create_time")
	private Timestamp createTime;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		id = id;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getStatusBefore() {
		return statusBefore;
	}

	public void setStatusBefore(String statusBefore) {
		this.statusBefore = statusBefore;
	}

	public String getStatusAfter() {
		return statusAfter;
	}

	public void setStatusAfter(String statusAfter) {
		this.statusAfter = statusAfter;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof AssetChangeLogBO))
			return false;
		AssetChangeLogBO otherCast = (AssetChangeLogBO) other;
		return new EqualsBuilder().append(this.id, otherCast.id).append(
				this.deviceId, otherCast.deviceId).append(this.statusAfter,
				otherCast.statusAfter).append(this.statusBefore,
				otherCast.statusBefore).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(deviceId).append(
				statusAfter).append(statusBefore).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("deviceId",
				deviceId).append("statusAfter", statusAfter).append(
				"statusBefore", statusBefore).toString();
	}

}
