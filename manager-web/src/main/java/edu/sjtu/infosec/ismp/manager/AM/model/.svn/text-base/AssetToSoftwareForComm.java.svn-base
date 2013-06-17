package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于通信的设备软件对应关系类
 * 
 * @author wewew
 * 
 */
public class AssetToSoftwareForComm  implements Serializable {
	// 操作方法
	private String method;

	// 操作对象
	private List<AssetToSoftwareBO> assetToSoftwares;

	public AssetToSoftwareForComm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String vMethod) {
		this.method = vMethod;
	}

	public List<AssetToSoftwareBO> getAssetToSoftwares() {
		return assetToSoftwares;
	}

	public void setAssetToSoftwares(List<AssetToSoftwareBO> vAssetToSoftwares) {
		this.assetToSoftwares = vAssetToSoftwares;
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetToSoftwareForComm))
			return false;
		AssetToSoftwareForComm castOther = (AssetToSoftwareForComm) other;
		return new EqualsBuilder().append(method, castOther.method).append(
				assetToSoftwares, castOther.assetToSoftwares).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(method).append(assetToSoftwares)
				.toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).append("method", method).append(
				"assetToSoftwares", assetToSoftwares).toString();
	}

}
