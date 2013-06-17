/**   
* @Title: MonitorEntity.java
* @Package org.infosec.ismp.agent.pollable.model
* @Description: TODO(用一句话描述该文件做什么)
* @author guoxianwei  
* @date 2010-9-3 下午04:22:23
* @version V1.0   
*/


package org.infosec.ismp.agent.pollable.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.infosec.ismp.util.BaseObject;

/**
 * @ClassName: MonitorEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author guoxianwei
 * @date 2010-9-3 下午04:22:23
 * 
 */

@Entity
@Table(name="monitor")
public class MonitorEntity extends BaseObject {
	

	private static final long serialVersionUID = -3248831242874942962L;

	private long id;
	
	private String serviceType;
	
	private String className;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
	public long getId() {
		return id;
	}


    @Column(name="servicetype", length=128)
	public String getServiceType() {
		return serviceType;
	}


    @Column(name="classname", length=512)
	public String getClassName() {
		return className;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @param servicetype the servicetype to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	/**
	 * @param classname the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}

