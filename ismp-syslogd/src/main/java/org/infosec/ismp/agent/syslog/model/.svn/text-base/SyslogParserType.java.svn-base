

package org.infosec.ismp.agent.syslog.model;

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
@Entity
@Table(name="syslog_parser_type")
public class SyslogParserType extends BaseObject{
	

	private static final long serialVersionUID = 4313168671871661961L;
	
	private int id;
	private String type;
	private String className;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)   
	public int getId() {
		return id;
	}
	@Column(name="type",length=128)
	public String getType() {
		return type;
	}
	@Column(name="class_name",length=256)
	public String getClassName() {
		return className;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

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

