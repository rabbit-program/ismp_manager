package org.infosec.ismp.manager.model;

import javax.persistence.Embeddable;

@Embeddable
public class ServiceCheckNodeParamEntity {
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
}
