package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于通信的资产地理位置对应关系类
 * 
 * @author wewew
 * 
 */
public class AssetToPositionForComm implements Serializable {
	// 操作方法
	private String method;
	// 操作对象
	private List<AssetToPositionBO> assetToPositions;

	
	public AssetToPositionForComm() {
		super();
	}

	
	public String getMethod() {
		return method;
	}


	public void setMethod(String vMethod) {
		this.method = vMethod;
	}


	public List<AssetToPositionBO> getAssetToPositions() {
		return assetToPositions;
	}


	public void setAssetToPositions(List<AssetToPositionBO> vAssetToPositions) {
		this.assetToPositions = vAssetToPositions;
	}


	public boolean equals(final Object other) {
		if (!(other instanceof AssetToPositionForComm))
			return false;
		AssetToPositionForComm castOther = (AssetToPositionForComm) other;
		return new EqualsBuilder().append(method, castOther.method).append(
				assetToPositions, castOther.assetToPositions).isEquals();
	}


	public int hashCode() {
		return new HashCodeBuilder().append(method).append(assetToPositions)
				.toHashCode();
	}


	public String toString() {
		return new ToStringBuilder(this).append("method", method).append(
				"assetToPositions", assetToPositions).toString();
	}

}
