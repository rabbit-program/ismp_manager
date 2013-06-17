package edu.sjtu.infosec.ismp.manager.AIM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="aim_rule")
@org.hibernate.annotations.Entity(dynamicUpdate=true)
public class AlertRuleBO implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	//优先级
	@Column(name="priority")
	private Integer priority;
	//类型
	@Column(name="type")
	private String type;
	
	//sub类型
	@Column(name="sub_type")
	private String subType;
	
	//是否发送桌面消息
	@Column(name="send_msg")
	private Integer sendMsg;
	
	//桌面消息地址
	@Column(name="msg_target")
	private String msgTarget;
	
	//是否发送邮件
	@Column(name="send_email")
	private Integer sendEmail;
     
	//邮件地址
	@Column(name="email_target")
	private String emailTarget;
	
	//是否发送短消息
	@Column(name="send_sms")
	private Integer sendSms;
	
	//短消息地址
	@Column(name="sms_target")
	private String smsTarget;
	
	//是否启用规则
	@Column(name="enabled")
	private Integer enabled;
	
	//是否废弃规则
	@Column(name="deprecated")
	private Integer deprecated;
	
	//区分部门的规则，普通管理员用
	@Column(name="domain_id")
	private Integer deparmentId;

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("priority",
				priority).append("type", type).append("subType", subType)
				.append("sendMsg", sendMsg).append("msgTarget", msgTarget)
				.append("sendEmail", sendEmail).append("emailTarget",
						emailTarget).append("sendSms", sendSms).append(
						"smsTarget", smsTarget).append("enabled", enabled)
				.append("deprecated", deprecated).append("deparmentId",deparmentId).toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Integer getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(Integer sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getMsgTarget() {
		return msgTarget;
	}

	public void setMsgTarget(String msgTarget) {
		this.msgTarget = msgTarget;
	}

	public Integer getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(Integer sendEmail) {
		this.sendEmail = sendEmail;
	}

	public String getEmailTarget() {
		return emailTarget;
	}

	public void setEmailTarget(String emailTarget) {
		this.emailTarget = emailTarget;
	}

	public Integer getSendSms() {
		return sendSms;
	}

	public void setSendSms(Integer sendSms) {
		this.sendSms = sendSms;
	}

	public String getSmsTarget() {
		return smsTarget;
	}

	public void setSmsTarget(String smsTarget) {
		this.smsTarget = smsTarget;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getDeprecated() {
		return deprecated;
	}

	public void setDeprecated(Integer deprecated) {
		this.deprecated = deprecated;
	}
	
	
	public Integer getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(Integer deparmentId) {
		this.deparmentId = deparmentId;
	}
	public boolean equals(final Object other) {
		if (!(other instanceof AlertRuleBO))
			return false;
		AlertRuleBO castOther = (AlertRuleBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(priority,
				castOther.priority).append(type, castOther.type).append(
				subType, castOther.subType).append(sendMsg, castOther.sendMsg)
				.append(msgTarget, castOther.msgTarget).append(sendEmail,
						castOther.sendEmail).append(emailTarget,
						castOther.emailTarget).append(sendSms,
						castOther.sendSms).append(smsTarget,
						castOther.smsTarget).append(enabled, castOther.enabled)
				.append(deprecated, castOther.deprecated).append(deparmentId, castOther.deparmentId).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(priority).append(type)
				.append(subType).append(sendMsg).append(msgTarget).append(
						sendEmail).append(emailTarget).append(sendSms).append(
						smsTarget).append(enabled).append(deprecated).append(deparmentId)
				.toHashCode();
	}

}
