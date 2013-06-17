package edu.sjtu.infosec.ismp.manager.EM.model;

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
 * Eventmoni entity.
 * 
 * 自选事件表，用于保存事件管理首页用户定义的自选事件。
 * 
 * @author @author 林超
 */
@Entity
@Table(name = "em_event_task_sele")
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class Eventtasksele extends Object implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2211934780962697677L;

	/**
	 * 记录编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	/**
	 * 代表用户自定义事件的编号（自定义一，自定义二）
	 */
	@Column(name = "define_id",length=1, nullable = false)
	private Integer define_id;
	
	/**
	 * 用户名
	 */
	@Column(name = "userName",length=20, nullable = false)
	private String userName;
	
	/**
	 * 设备的ID 表示用户定义的自选事件
	 */
	@Column(name = "faci_ip", length = 50,nullable = false)
	private String faci_ip;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDefine_id() {
		return define_id;
	}

	public void setDefine_id(Integer define_id) {
		this.define_id = define_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFaci_ip() {
		return faci_ip;
	}

	public void setFaci_ip(String faci_ip) {
		this.faci_ip = faci_ip;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Eventtasksele)) {
			return false;
		}
		Eventtasksele evt = (Eventtasksele) other;
		return new EqualsBuilder().append(this.define_id, evt.define_id).append(
				this.faci_ip, evt.faci_ip).append(this.userName, evt.userName).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.define_id).append(this.userName).append(this.faci_ip)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(this.id).append(this.userName).append(this.define_id).append(this.faci_ip).toString();
	}

}
