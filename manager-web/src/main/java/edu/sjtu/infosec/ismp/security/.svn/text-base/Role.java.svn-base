package edu.sjtu.infosec.ismp.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用户角色
 * 
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * 
 */
@Entity
@Table(name = "ismp_role")
public class Role extends IdEntity implements Serializable {
	private static final long serialVersionUID = 6733753367206985687L;
	private String name;

	private String role;

	@Column(nullable = false, unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false, unique = true)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
