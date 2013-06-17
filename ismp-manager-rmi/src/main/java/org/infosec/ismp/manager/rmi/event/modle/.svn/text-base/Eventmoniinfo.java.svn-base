package org.infosec.ismp.manager.rmi.event.modle;

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


/**
 * Eventmoni entity.
 * 
 * 设备监控信息表，表中记录来自设备监控发现的安全事件
 * 
 * @author @author 林超
 */
@Entity
@Table(name = "em_event_moni_info")
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class Eventmoniinfo extends Object implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6360113449762924429L;

	/**
	 * 记录编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 事件生成日期时间
	 */
	@Column(name = "time", nullable = false)
	private Date time;

	/**
	 * 事件类型（指CPU、MEMORY、HARDDISK等等
	 */
	@Column(name = "event_type", length = 50, nullable = false)
	private String eventType;

	/**
	 * 说明：触发值，指触发时的状态参数实际值
	 */
	@Column(name = "alert_value")
	private Long alertValue;

	/**
	 * 触发时的状态参数阈值设置值。
	 */
	@Column(name = "threshold")
	private Long threshold;

	/**
	 * 设备IP地址
	 */
	@Column(name = "ipaddress", nullable = false)
	private String ipAddress;

	/**
	 * 事件描述
	 */
	@Column(name = "descrip", length = 1024)
	private String descrip;
	
	/**
	 * 委办局ID
	 */
	@Column(name = "bureau_id", length = 20)
	private Integer bureauId; 

	public Integer getBureauId() {
		return bureauId;
	}

	public void setBureauId(Integer bureauId) {
		this.bureauId = bureauId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Long getAlertValue() {
		return alertValue;
	}

	public void setAlertValue(Long alertValue) {
		this.alertValue = alertValue;
	}

	public Long getThreshold() {
		return threshold;
	}

	public void setThreshold(Long threshold) {
		this.threshold = threshold;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Eventmoniinfo)) {
			return false;
		}
		Eventmoniinfo evt = (Eventmoniinfo) other;
		return new EqualsBuilder().append(this.time, evt.time).append(
				this.eventType, evt.eventType).append(this.alertValue,
				evt.alertValue).append(this.threshold, evt.threshold).append(
				this.ipAddress, evt.ipAddress)
				.append(this.descrip, evt.descrip).append(this.bureauId, evt.bureauId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.time).append(this.eventType)
				.append(this.alertValue).append(this.threshold).append(
						this.ipAddress).append(this.descrip).append(this.bureauId).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(this.id).append(this.time)
				.append(this.eventType).append(this.alertValue).append(
						this.threshold).append(this.ipAddress).append(
						this.descrip).append(this.bureauId).toString();
	}

}
