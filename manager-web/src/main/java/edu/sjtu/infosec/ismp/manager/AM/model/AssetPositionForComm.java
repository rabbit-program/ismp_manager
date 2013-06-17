package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于通信的地理位置类
 * 
 * @author wewew
 * 
 */
public class AssetPositionForComm implements Serializable {
	// 操作方法
	private String method;
	// 操作对象
	private List<AssetPositionBO> positions;

	public AssetPositionForComm() {
		super();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String vMethod) {
		this.method = vMethod;
	}

	public List<AssetPositionBO> getPositions() {
		return positions;
	}

	public void setPositions(List<AssetPositionBO> vPositions) {
		this.positions = vPositions;
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AssetPositionForComm))
			return false;
		AssetPositionForComm castOther = (AssetPositionForComm) other;
		return new EqualsBuilder().append(method, castOther.method).append(
				positions, castOther.positions).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(method).append(positions)
				.toHashCode();
	}

	public String toString() {
		return new ToStringBuilder(this).append("method", method).append(
				"positions", positions).toString();
	}

}
