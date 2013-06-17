package org.infosec.ismp.manager.winsensor.operation.entity;

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
 * @version create time: Jan 6, 2011 5:29:15 PM
 *
 */
@Entity
@Table(name="duty_manager_sent_history")
public class DutyManagerSentHistoryBO implements Serializable {

	private static final long serialVersionUID = 4970270603912315107L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="agent_id", length=100)
	private String agentId;		//Agent unique identify, not id.
	
	@Column(name="duty_manager_id", length=100)
	private String dutyManagerId;		//DutyManager id.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;		//Record create time.
	
	@Column(name="is_sent")
	private Boolean isSent;		//Whether sent.
	
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

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
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
