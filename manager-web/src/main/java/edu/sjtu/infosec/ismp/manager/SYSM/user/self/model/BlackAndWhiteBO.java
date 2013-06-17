package edu.sjtu.infosec.ismp.manager.SYSM.user.self.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 黑白名单
 * ***/
@Entity
@Table(name = "sysm_user_self_bw_list")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class BlackAndWhiteBO implements Serializable{
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//Ip地址
    @Column(name="ipaddress")
	private String ipaddress;
	
	//标识 （0，1）分别代表（黑名单，白名单）
    @Column(name="marker")
	private Integer marker;

    @Column(name="role")
	private String role;

    @Column(name="domain")
	private Integer domain;

    @Column(name="username")
	private String username; 

    @Column(name="depict")
	private String depict; //描述

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("ipaddress",
				ipaddress).append("marker", marker).append("role", role).append("domain", domain)
				.append("username", username).append("depict", depict)
				.toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof BlackAndWhiteBO))
			return false;
		BlackAndWhiteBO castOther = (BlackAndWhiteBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(ipaddress,
				castOther.ipaddress).append(marker, castOther.marker).append(role, castOther.role)
				.append(domain, castOther.domain).append(username, castOther.username)
				.append(depict, castOther.depict).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(ipaddress)
				.append(marker).append(role).append(domain).append(username).append(depict).toHashCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Integer getMarker() {
		return marker;
	}

	public void setMarker(Integer marker) {
		this.marker = marker;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getDomain() {
		return domain;
	}

	public void setDomain(Integer l) {
		this.domain = l;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
