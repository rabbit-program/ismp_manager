package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于传输的资产设备类
 * 
 * @author wewew
 * 
 */
public class AssetDeviceForComm implements Serializable {
	// 操作的类型
	private String method;
	// 操作的BO类
	private List<AssetDeviceBO> assetDeviceList;

	public AssetDeviceForComm() {
		// TODO Auto-generated constructor stub
	}
   
	public AssetDeviceForComm(List<AssetDeviceBO> assetDeviceList) {
		super();
		this.assetDeviceList = assetDeviceList;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<AssetDeviceBO> getAssetDeviceList() {
		return assetDeviceList;
	}

	public void setAssetDeviceList(List<AssetDeviceBO> assetDeviceList) {
		this.assetDeviceList = assetDeviceList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(final Object other) {
		if (!(other instanceof AssetDeviceForComm))
			return false;
		AssetDeviceForComm castOther = (AssetDeviceForComm) other;
		return new EqualsBuilder().append(method, castOther.method).append(
				assetDeviceList, castOther.assetDeviceList).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(method).append(assetDeviceList)
				.toHashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("method", method).append(
				"assetDeviceBOList", assetDeviceList).toString();
	}

}
