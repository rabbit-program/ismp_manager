package org.infosec.ismp.manager.rmi.sysm.config.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统配置-数据库
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
@Entity
@Table(name = "sysm_config_db")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysConfigDb implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 配置命名
	 * 病毒 瑞星数据库：rav
	 * 补丁 WSUS数据库：wsus
	 */
    @Column(name="name")
	private String name;
	/**
	 * 数据库连接地址
	 */
    @Column(name="db_url")
	private String dbUrl;
	/**
	 * 数据库驱动
	 */
    @Column(name="db_driver")
	private String dbDriver;
	/**
	 * 数据库访问用户名
	 */
    @Column(name="username")
	private String username;
	/**
	 * 数据库访问密码
	 */
    @Column(name="password")
	private String password;
	/**
	 * 备注
	 */
    @Column(name="remarks")
	private String remarks;
    
    
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbDriver() {
		return dbDriver;
	}
	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
