package edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import edu.sjtu.infosec.ismp.security.Role;

public class UserUpdateVO implements Serializable {

	private Integer id;
	
	//用户名称
	private String username;
	
	private String loginName;// 真实姓名

	private String phone;// 电话

	private String mobile;// 手机

	private String email;// 邮箱

	private String job;// 职位
	
	private Set<Role> roles = new HashSet<Role>(); //角色
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("loginName",
				loginName).append("phone", phone).append("mobile", mobile)
				.append("email", email).append("job", job).append("roles", roles).append(
						"username", username).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof UserUpdateVO))
			return false;
		UserUpdateVO castOther = (UserUpdateVO) other;
		return new EqualsBuilder().append(id, castOther.id).append(loginName,
				castOther.loginName).append(phone, castOther.phone).append(
				mobile, castOther.mobile).append(email, castOther.email).append(job,
						castOther.job).append(roles, castOther.roles)
				.append(username, castOther.username).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(loginName).append(phone)
				.append(mobile).append(email).append(job)
				.append(roles).append(username).toHashCode();
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
