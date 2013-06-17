package org.infosec.ismp.agent.winsensor.operation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Rocky
 * @version create time: Jan 11, 2011 9:15:02 PM
 *
 */
@Entity
@Table(name="agent_duty_man_sent_his")
public class AgentDutyManagerSentHisBO implements Serializable {

	private static final long serialVersionUID = -6200254098707404522L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="sensor_id", length=100)
	private String sensorId;		//Sensor client unique identify.
	
	@Column(name="duty_manager_id", length=100)
	private String dutyManagerId;		//DutyManager id.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;		//Record create time.
	
	@Column(name="is_sent")
	private Boolean isSent;		//Whether sent.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sent_time")
	private Date sendTime;		//The time DutyManager send to Agent.
	
	@Column(name="expired")
	private Boolean expired;		//The record not sent, but expired. And no longer send.
	
	@Column(name="is_removed")
	private Boolean isRemoved;		//Whether be removed.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="removed_time")
	private Date removedTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getDutyManagerId() {
		return dutyManagerId;
	}

	public void setDutyManagerId(String dutyManagerId) {
		this.dutyManagerId = dutyManagerId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsSent() {
		return isSent;
	}

	public void setIsSent(Boolean isSent) {
		this.isSent = isSent;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Boolean getExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	public Boolean getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(Boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

	public Date getRemovedTime() {
		return removedTime;
	}

	public void setRemovedTime(Date removedTime) {
		this.removedTime = removedTime;
	}
}
