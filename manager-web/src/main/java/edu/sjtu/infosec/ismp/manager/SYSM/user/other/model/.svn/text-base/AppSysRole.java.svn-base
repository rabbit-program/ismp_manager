package edu.sjtu.infosec.ismp.manager.SYSM.user.other.model;

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
 * 应用系统权限
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "sysm_app_sys_role")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class AppSysRole implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属应用系统
	 */
    @ManyToOne 
    @JoinColumn(name="appSys_id")
	private AppSysInfo appSys;
	/**
	 * 名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 描述
	 */
    @Column(name="description")
	private String desc;
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
	public AppSysInfo getAppSys() {
		return appSys;
	}
	public void setAppSys(AppSysInfo appSys) {
		this.appSys = appSys;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
