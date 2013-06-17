package edu.sjtu.infosec.ismp.security;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OrderBy;
import org.springside.modules.utils.ReflectionUtils;

/**
 * 
 * 用户对象，代表了各种用户的共性
 * 
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * 
 */
// JPA Entity基类的标识
// @MappedSuperclass
@Entity
@Table(name = "ismp_user")
public class User extends IdEntity {
	private static final long serialVersionUID = -3072438446567617195L;

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
	private Timestamp expiredTime;
	private Timestamp endLockTime;
    private Timestamp registertime;//注册时间
	private String description;

	public User() {
		super();
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

	public Timestamp getRegistertime() {
		return registertime;
	}

	public void setRegistertime(Timestamp registertime) {
		this.registertime = registertime;
	}

	@Column(nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Hibernate自动维护的Version字段
	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(unique = true, nullable = false)
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Timestamp getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Timestamp expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Timestamp getEndLockTime() {
		return endLockTime;
	}

	public void setEndLockTime(Timestamp endLockTime) {
		this.endLockTime = endLockTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// 多对多
	@ManyToMany
	// 中间表定义,表名采用默认命名规则
	@JoinTable(name = "ISMP_USER_DOMAIN", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "DOMAIN_ID") })
	@OrderBy(clause = "DOMAIN_ID")
	//非延迟加载
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(FetchMode.SUBSELECT)
	public Set<Domain> getDomains() {
		return domains;
	}

	// 多对多定义
	@ManyToMany
	// 中间表定义,表名采用默认命名规则
	@JoinTable(name = "ISMP_USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	//是否延迟加载
	@LazyCollection(LazyCollectionOption.FALSE)
	// 集合中对象id的缓存.
//	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
	 */
	// 非持久化属性.
	@Transient
	public String getRoleNames() {
		return ReflectionUtils.convertElementPropertyToString(roles, "role",
				", ");
	}

	/**
	 * 用户拥有的角色id字符串, 多个角色id用','分隔.
	 */
	// 非持久化属性.
	@Transient
	@SuppressWarnings("unchecked")
	public List<Long> getRoleIds() {
		return ReflectionUtils.convertElementPropertyToList(roles, "id");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public void setDomains(Set<Domain> domains) {
		this.domains = domains;
	}
	
	

}
