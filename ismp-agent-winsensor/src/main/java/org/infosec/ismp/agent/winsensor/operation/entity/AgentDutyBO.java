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
 * @version create time: Jan 11, 2011 7:13:09 PM
 *
 */
@Entity
@Table(name="agent_duty")
public class AgentDutyBO implements Serializable {

	private static final long serialVersionUID = -4675061814492294087L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;		
	
	@Column(name="name", length=100)
	private String name;		//Duty name.
	
	@Column(name="sex", length=50)
	private String sex;
	
	@Column(name="responsibility", length=255)
	private String responsibility;		//Duty responsibility.
	
	@Column(name="mobile_phone", length=100)
	private String mobilePhone;	
	
	@Column(name="phone", length=100)
	private String phone;
	
	@Column(name="email", length=100)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="is_manager")
	private Boolean isManager;
	
	@Column(name="remote_duty_id", length=100)
	private String remoteDutyId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(Boolean isManager) {
		this.isManager = isManager;
	}

	public String getRemoteDutyId() {
		return remoteDutyId;
	}

	public void setRemoteDutyId(String remoteDutyId) {
		this.remoteDutyId = remoteDutyId;
	}
}
