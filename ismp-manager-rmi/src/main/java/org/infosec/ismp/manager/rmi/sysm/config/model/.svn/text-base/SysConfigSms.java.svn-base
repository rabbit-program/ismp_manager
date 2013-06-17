package org.infosec.ismp.manager.rmi.sysm.config.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统配置-信息发送
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
@Entity
@Table(name = "sysm_config_sms")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysConfigSms implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 配置命名
	 */
    @Column(name="name")
	private String name;
	/**
	 * 信息发送接口ip
	 */
    @Column(name="send_ip")
	private String sendIp;
	/**
	 * 信息发送接口端口号
	 */
    @Column(name="send_port")
	private String sendPort;
	/**
	 * 邮件收发服务器
	 */
    @Column(name="email_server")
	private String emailServer;
	/**
	 * 发出邮箱地址
	 */
    @Column(name="email")
	private String email;
	/**
	 * 发出邮箱用户名
	 */
    @Column(name="username")
	private String username;
	/**
	 * 发出邮箱用密码
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
	public String getSendIp() {
		return sendIp;
	}
	public void setSendIp(String sendIp) {
		this.sendIp = sendIp;
	}
	public String getSendPort() {
		return sendPort;
	}
	public void setSendPort(String sendPort) {
		this.sendPort = sendPort;
	}
	public String getEmailServer() {
		return emailServer;
	}
	public void setEmailServer(String emailServer) {
		this.emailServer = emailServer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
