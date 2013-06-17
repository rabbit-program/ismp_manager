/**
 * 
 */
package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 用于传输的AssetDailyAvailability类
 * 
 * @author
 * 
 */
public class AssetDailyAvailabilityForComm implements Serializable {

    // 操作的类型
    private String method;
    // 操作的BO类
    private List<AssetDailyAvailabilityBO> assetDailyAvailabilityList;

    public AssetDailyAvailabilityForComm() {

    }

    public AssetDailyAvailabilityForComm(
            List<AssetDailyAvailabilityBO> assetDailyAvailabilityList) {
        super();
        this.assetDailyAvailabilityList = assetDailyAvailabilityList;
    }

    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method
     *            the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the assetDailyAvailabilityList
     */
    public List<AssetDailyAvailabilityBO> getAssetDailyAvailabilityList() {
        return assetDailyAvailabilityList;
    }

    /**
     * @param assetDailyAvailabilityList
     *            the assetDailyAvailabilityList to set
     */
    public void setAssetDailyAvailabilityList(
            List<AssetDailyAvailabilityBO> assetDailyAvailabilityList) {
        this.assetDailyAvailabilityList = assetDailyAvailabilityList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(final Object other) {
        if (!(other instanceof AssetDailyAvailabilityForComm))
            return false;
        AssetDailyAvailabilityForComm castOther = (AssetDailyAvailabilityForComm) other;
        return new EqualsBuilder().append(method, castOther.method).append(
                assetDailyAvailabilityList,
                castOther.assetDailyAvailabilityList).isEquals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(method).append(
                assetDailyAvailabilityList).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("method", method).append(
                "assetDailyAvailabilityBOList", assetDailyAvailabilityList)
                .toString();
    }

}
