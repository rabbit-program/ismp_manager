package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于通信的设备硬件对应关系类
 * 
 * @author wewew
 * 
 */
public class AssetToHardwareForComm implements Serializable {

	// 操作方法
	private String method;
	// 操作对象
	private List<AssetToHardwareBO> assetToHardwares;

	public AssetToHardwareForComm() {
		super();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String vMethod) {
		this.method = vMethod;
	}

	public List<AssetToHardwareBO> getAssetToHardwares() {
		return assetToHardwares;
	}

	public void setAssetToHardwares(List<AssetToHardwareBO> vAssetToHardwares) {
		this.assetToHardwares = vAssetToHardwares;
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetToHardwareForComm))
			return false;
		AssetToHardwareForComm castOther = (AssetToHardwareForComm) other;
		return new EqualsBuilder().append(method, castOther.method).append(
				assetToHardwares, castOther.assetToHardwares).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(method).append(assetToHardwares)
				.toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).append("method", method).append(
				"assetToHardwares", assetToHardwares).toString();
	}

}
