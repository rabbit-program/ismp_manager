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
 * 黑白名
 * 单状态表 
 * **/
@Entity
@Table(name="sysm_user_self_bw_status")
public class BlackAndWhiteStatusBO implements Serializable{

	
	//主键ID
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	//黑白名单启用状态(0,1,2)(分别标示启用黑名或者启用白名单或者全部不启用)
    @Column(name="status")
	private Integer status;

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("status",
				status).toString();
	}
	public boolean equals(final Object other) {
		if (!(other instanceof BlackAndWhiteStatusBO))
			return false;
		BlackAndWhiteStatusBO castOther = (BlackAndWhiteStatusBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(status,
				castOther.status).isEquals();
	}
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(status).toHashCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
