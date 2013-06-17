package edu.sjtu.infosec.ismp.manager.OSS.pm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OrderBy;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 排班记录
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "oss_pm_duty_schedule")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class DutySchedule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6039273200559338446L;
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属域
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
	/**
	 * 值班人员
	 */
//    @ManyToOne 
//    @JoinColumn(name="roster_id")
	// 多对多
	@ManyToMany
	// 中间表定义,表名采用默认命名规则
	@JoinTable(name = "oss_pm_duty_schedule_roster", joinColumns = { @JoinColumn(name = "duty_schedule_id") }, inverseJoinColumns = { @JoinColumn(name = "roster_id") })
	@OrderBy(clause = "roster_id")
	//非延迟加载
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(FetchMode.SUBSELECT)
	private Set<Roster> roster = new HashSet<Roster>();
	/**
	 * 主要负责人（备用字段）
	 */
    @Column(name="is_leader")
	private int isLeader;
	/**
	 * 是否发布
	 * 0：否
	 * 1：是
	 */
    @Column(name="is_published")
    private int isPublished;
	/**
	 * 值班任务
	 */
    @Column(name="task")
	private String task;
	/**
	 * 值班开始时间
	 */
    @Column(name="start_time")
	private Timestamp startTime;
	/**
	 * 值班结束时间
	 */
    @Column(name="end_time")
	private Timestamp endTime;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 最后修改时间
	 */
    @Column(name="last_update_time")
	private Timestamp lastUpdateTime;
	/**
	 * 备注
	 */
    @Column(name="remark")
	private String remark;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public Set<Roster> getRoster() {
		return roster;
	}
	public void setRoster(Set<Roster> roster) {
		this.roster = roster;
	}
	public int getIsLeader() {
		return isLeader;
	}
	public void setIsLeader(int isLeader) {
		this.isLeader = isLeader;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(int isPublished) {
		this.isPublished = isPublished;
	}
}
