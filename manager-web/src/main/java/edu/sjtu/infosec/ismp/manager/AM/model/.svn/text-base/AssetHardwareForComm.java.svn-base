package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于通信的硬件信息类
 * 
 * @author wewew
 * 
 */
public class AssetHardwareForComm implements Serializable {
	// 操作方法
	private String method;
	// 操作对象
	private List<AssetHardwareBO> hardwares;

	public AssetHardwareForComm() {
		super();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String vMethod) {
		this.method = vMethod;
	}

	public List<AssetHardwareBO> getHardwares() {
		return hardwares;
	}

	public void setHardwares(List<AssetHardwareBO> vHardwares) {
		this.hardwares = vHardwares;
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetHardwareForComm))
			return false;
		AssetHardwareForComm castOther = (AssetHardwareForComm) other;
		return new EqualsBuilder().append(method, castOther.method).append(
				hardwares, castOther.hardwares).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(method).append(hardwares)
				.toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).append("method", method).append(
				"hardwares", hardwares).toString();
	}

}
