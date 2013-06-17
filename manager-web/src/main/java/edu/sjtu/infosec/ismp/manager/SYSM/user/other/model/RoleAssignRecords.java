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
 * 应用系统权限分配记录
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "sysm_app_sys_role_assign")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class RoleAssignRecords implements Serializable {
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
	 * 用户
	 */
    @Column(name="user_sign")
	private String user;
	/**
	 * 权限
	 */
    @ManyToOne 
    @JoinColumn(name="role_id")
	private AppSysRole role;
	/**
	 * 操作人
	 */
    @Column(name="operator")
	private String operator;
	/**
	 * 记录时间
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public AppSysRole getRole() {
		return role;
	}
	public void setRole(AppSysRole role) {
		this.role = role;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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
