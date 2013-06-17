package org.infosec.ismp.manager.rmi.lm.pfLog.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统日志类，定义了系统日志格式。
 * 
 * @author linleung
 * 
 */
@Entity
@Table(name = "lm_pflog_oplog")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SystemLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8818380189560385220L;
	/**
	 * 唯一标识
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	/**
	 * 操作时间
	 */
	@Column(name="op_time",nullable=false)
	private Timestamp time;
	/**
	 * 用户名
	 */
	@Column(name="user_name",nullable=false)
	private String username;
	/**
	 * 用户角色名
	 */
	@Column(name = "role_name")
	private String roleName;
	/**
	 * 模块名
	 */
	@Column(name="module_name")
	private String moduleName;
	/**
	 * 操作描述
	 */
	@Column(name="op_desc")
	private String operationDesc;
	/**
	 * 操作结果
	 */
	@Column(name="op_result")
	private String control;

	public SystemLog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getOperationDesc() {
		return operationDesc;
	}

	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

}
