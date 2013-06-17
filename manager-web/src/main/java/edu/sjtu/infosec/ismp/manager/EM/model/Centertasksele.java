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
 * @author wudengke 2009-6-2
 */
@Entity
@Table(name = "em_center_task_sele")
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class Centertasksele extends Object implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3181297218820197072L;

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
	private String defineId;
	
	/**
	 * 用户名
	 */
	@Column(name = "userName",length=20, nullable = false)
	private String userName;
	
	/**
	 * 设备的ID 表示用户定义的自选事件
	 */
	@Column(name = "bureau_id", length = 20,nullable = false)
	private String bureauId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDefineId() {
		return defineId;
	}

	public void setDefineId(String defineId) {
		this.defineId = defineId;
	}
	
	public String getBureauId() {
		return bureauId;
	}

	public void setBureauId(String bureauId) {
		this.bureauId = bureauId;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Centertasksele)) {
			return false;
		}
		Centertasksele evt = (Centertasksele) other;
		return new EqualsBuilder().append(this.defineId, evt.defineId).append(
				this.bureauId, evt.bureauId).append(this.userName, evt.userName).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.defineId).append(this.bureauId).append(this.userName)
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(userName).append(defineId).append(bureauId).toString();
	}

}
