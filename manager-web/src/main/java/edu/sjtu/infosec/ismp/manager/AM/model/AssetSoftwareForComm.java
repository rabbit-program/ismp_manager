package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于通信的软件类
 * 
 * @author wewew
 * 
 */
public class AssetSoftwareForComm implements Serializable {
	// 操作方法
	private String method;
	// 操作对象
	private List<AssetSoftwareBO> softwares;

	public AssetSoftwareForComm() {
		super();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String vMethod) {
		this.method = vMethod;
	}

	public List<AssetSoftwareBO> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<AssetSoftwareBO> vSoftwares) {
		this.softwares = vSoftwares;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	public boolean equals(final Object other) {
		if (!(other instanceof AssetSoftwareForComm))
			return false;
		AssetSoftwareForComm castOther = (AssetSoftwareForComm) other;
		return new EqualsBuilder().append(method, castOther.method).append(
				softwares, castOther.softwares).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(method).append(softwares)
				.toHashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("method", method).append(
				"softwares", softwares).toString();
	}

}
