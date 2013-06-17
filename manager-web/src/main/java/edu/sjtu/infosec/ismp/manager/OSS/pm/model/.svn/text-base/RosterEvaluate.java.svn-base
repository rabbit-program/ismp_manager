package edu.sjtu.infosec.ismp.manager.OSS.pm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 值班人员评估记录
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "oss_pm_roster_evaluate")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class RosterEvaluate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -256946339255095258L;
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 评价来源（根据需要可以改成sensor对象）
	 */
    @Column(name="evaluate_source")
	private String evaluateSource;
	/**
	 * 值班人员
	 */
    @ManyToOne 
    @JoinColumn(name="roster_id")
	private Roster roster;
	/**
	 * 服务质量级别
	 * 1：分常好
	 * 2：好
	 * 3：一般
	 * 4：差
	 * 5：特别差
	 */
    @Column(name="service_quality")
	private int serviceQuality;
	/**
	 * 服务评价描述
	 */
    @Column(name="description")
	private String desc;
	/**
	 * 评价时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
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
	public String getEvaluateSource() {
		return evaluateSource;
	}
	public void setEvaluateSource(String evaluateSource) {
		this.evaluateSource = evaluateSource;
	}
	public Roster getRoster() {
		return roster;
	}
	public void setRoster(Roster roster) {
		this.roster = roster;
	}
	public int getServiceQuality() {
		return serviceQuality;
	}
	public void setServiceQuality(int serviceQuality) {
		this.serviceQuality = serviceQuality;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
