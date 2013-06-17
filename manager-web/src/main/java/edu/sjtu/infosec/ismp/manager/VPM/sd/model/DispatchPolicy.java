package edu.sjtu.infosec.ismp.manager.VPM.sd.model;
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
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 分发策略信息对象
 * @author liuqing
 */
@Entity
@Table(name = "vpm_sd_dispatch_policy")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
@Transactional
public class DispatchPolicy implements Serializable {

	/**
	* @Fields serialVersionUID : 
	*    TODO
	*/
	private static final long serialVersionUID = 1637909485319810780L;
	
	/**
	 * 主键Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 分发标志，是否需要分发
	 */
	@Column(name="dispatch_check_tag")
	private Boolean dispatchCheckTag;

	/**
	 * 是否需要进行一致性检查标志
	 */
	@Column(name="consistency_check_tag")
	private Boolean consistencyCheckTag;

	/**
	 * rar形态表示标志 true:表示是我们自己打的rar包 false:表示是用户上传的rar包
	 */
	@Column(name="dispatch_form_tag")
	private Boolean dispatchFormTag;

	/**
	 * 并发分发数量
	 */
	@Column(name="dispatch_thread_num")
	private Integer dispatchThreadNum;

	/**
	 * 分发优先级, 0, 1, 2
	 */
	@Column(name="dispatch_priority")
	private Integer dispatchPriority;
	/**
	 * 分发开始日期(如：2009-06-08)
	 */
	@Column(name="dispatch_start_date")
	private Timestamp dispatchStartDate;

	/**
	 * 分发结束日期(如：2009-06-10)
	 */
	@Column(name="dispatch_end_date")
	private Timestamp dispatchEndDate;

	/**
	 * 分发开始时间(单位：毫秒)
	 */
	@Column(name="dispatch_start_time")
	private Long dispatchStartTime;

	/**
	 * 分发结束时间(单位：毫秒)
	 */
	@Column(name="dispatch_end_time")
	private Long dispatchEndTime;

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
	 * @return the dispatchCheckTag
	 */
	public Boolean getDispatchCheckTag() {
		return dispatchCheckTag;
	}

	/**
	 * @return the dispatchFormTag
	 */
	public Boolean getDispatchFormTag() {
		return dispatchFormTag;
	}

	/**
	 * @param vDispatchFormTag
	 *            the dispatchFormTag to set
	 */
	public void setDispatchFormTag(Boolean vDispatchFormTag) {
		dispatchFormTag = vDispatchFormTag;
	}

	/**
	 * @param vDispatchCheckTag
	 *            the dispatchCheckTag to set
	 */
	public void setDispatchCheckTag(Boolean vDispatchCheckTag) {
		dispatchCheckTag = vDispatchCheckTag;
	}

	/**
	 * @return the consistencyCheckTag
	 */
	public Boolean getConsistencyCheckTag() {
		return consistencyCheckTag;
	}

	/**
	 * @param vConsistencyCheckTag
	 *            the consistencyCheckTag to set
	 */
	public void setConsistencyCheckTag(Boolean vConsistencyCheckTag) {
		consistencyCheckTag = vConsistencyCheckTag;
	}

	/**
	 * @return the dispatchThreadNum
	 */
	public Integer getDispatchThreadNum() {
		return dispatchThreadNum;
	}

	/**
	 * @param vDispatchThreadNum
	 *            the dispatchThreadNum to set
	 */
	public void setDispatchThreadNum(Integer vDispatchThreadNum) {
		dispatchThreadNum = vDispatchThreadNum;
	}

	/**
	 * @return the dispatchPriority
	 */
	public Integer getDispatchPriority() {
		return dispatchPriority;
	}

	/**
	 * @param vDispatchPriority
	 *            the dispatchPriority to set
	 */
	public void setDispatchPriority(Integer vDispatchPriority) {
		dispatchPriority = vDispatchPriority;
	}

	/**
	 * @return the dispatchStartDate
	 */
	public Timestamp getDispatchStartDate() {
		return dispatchStartDate;
	}

	/**
	 * @param vDispatchStartDate
	 *            the dispatchStartDate to set
	 */
	public void setDispatchStartDate(Timestamp vDispatchStartDate) {
		dispatchStartDate = vDispatchStartDate;
	}

	/**
	 * @return the dispatchEndDate
	 */
	public Timestamp getDispatchEndDate() {
		return dispatchEndDate;
	}

	/**
	 * @param vDispatchEndDate
	 *            the dispatchEndDate to set
	 */
	public void setDispatchEndDate(Timestamp vDispatchEndDate) {
		dispatchEndDate = vDispatchEndDate;
	}

	/**
	 * @return the dispatchStartTime
	 */
	public Long getDispatchStartTime() {
		return dispatchStartTime;
	}

	/**
	 * @param vDispatchStartTime
	 *            the dispatchStartTime to set
	 */
	public void setDispatchStartTime(Long vDispatchStartTime) {
		dispatchStartTime = vDispatchStartTime;
	}

	/**
	 * @return the dispatchEndTime
	 */
	public Long getDispatchEndTime() {
		return dispatchEndTime;
	}

	/**
	 * @param vDispatchEndTime
	 *            the dispatchEndTime to set
	 */
	public void setDispatchEndTime(Long vDispatchEndTime) {
		dispatchEndTime = vDispatchEndTime;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof DispatchPolicy))
			return false;
		DispatchPolicy castOther = (DispatchPolicy) other;
		return new EqualsBuilder().append(id, castOther.id).append(consistencyCheckTag,
				castOther.consistencyCheckTag).append(dispatchCheckTag,
				castOther.dispatchCheckTag).append(dispatchEndTime,
				castOther.dispatchEndTime).append(dispatchThreadNum,
				castOther.dispatchThreadNum).append(dispatchStartTime,
				castOther.dispatchStartTime).append(dispatchPriority,
				castOther.dispatchPriority).append(dispatchStartDate,
				castOther.dispatchStartDate).append(dispatchEndDate,
				castOther.dispatchEndDate).append(dispatchFormTag,
				castOther.dispatchFormTag).isEquals();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(id).append(consistencyCheckTag).append(
				dispatchCheckTag).append(dispatchEndTime).append(
				dispatchThreadNum).append(dispatchStartTime).append(
				dispatchPriority).append(dispatchStartDate).append(
				dispatchEndDate).append(dispatchFormTag).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new ToStringBuilder(this).append(id).append("consistencyCheckTag",
				consistencyCheckTag).append("dispatchCheckTag",
				dispatchCheckTag).append("dispatchEndTime", dispatchEndTime)
				.append("dispatchThreadNum", dispatchThreadNum).append(
						"dispatchStartTime", dispatchStartTime).append(
						"dispatchPriorityLevel", dispatchPriority).append(
						"dispatchStartDate", dispatchStartDate).append(
						"dispatchEndDate", dispatchEndDate).append(
						"dispatchFormTag", dispatchFormTag).toString();
	}
}
