package org.infosec.ismp.agent.pollable.model;

import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.infosec.ismp.util.BaseObject;
@Embeddable
public class SpServiceParmEntity  extends BaseObject {
	
	private static final long serialVersionUID = 6699267474331013774L;

	
	private String parmName;
	
	private String value;


	public String getParmName() {
		return parmName;
	}

	public String getValue() {
		return value;
	}



	/**
	 * @param parmName the parmName to set
	 */
	public void setParmName(String parmName) {
		this.parmName = parmName;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
