package edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.vo;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.Role;


public class UserVO implements Serializable {
      

	/**
	 * 用户名
	 */
	private String username;
	private String loginName;
	private String password;
	private String email;
	private String phone;
    private String mobile;//手机
    private String job;//职位

	private Set<Role> roles = new HashSet<Role>();

	private Set<Domain> domains = new HashSet<Domain>();
	private Integer version;
	private Boolean enabled;
//	private Timestamp expiredTime;
//	private Timestamp endLockTime;
//    private Timestamp registertime;//注册时间
	private String description;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Domain> getDomains() {
		return domains;
	}
	public void setDomains(Set<Domain> domains) {
		this.domains = domains;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
//	public Timestamp getExpiredTime() {
//		return expiredTime;
//	}
//	public void setExpiredTime(Timestamp expiredTime) {
//		this.expiredTime = expiredTime;
//	}
//	public Timestamp getEndLockTime() {
//		return endLockTime;
//	}
//	public void setEndLockTime(Timestamp endLockTime) {
//		this.endLockTime = endLockTime;
//	}
//	public Timestamp getRegistertime() {
//		return registertime;
//	}
//	public void setRegistertime(Timestamp registertime) {
//		this.registertime = registertime;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	
   
}
