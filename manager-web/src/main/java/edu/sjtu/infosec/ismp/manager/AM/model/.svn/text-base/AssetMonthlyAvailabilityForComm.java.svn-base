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
 * 用于传输的AssetMonthlyAvailability类
 * 
 * @author
 * 
 */
public class AssetMonthlyAvailabilityForComm implements Serializable {

    // 操作的类型
    private String method;
    // 操作的BO类
    private List<AssetMonthlyAvailabilityBO> assetMonthlyAvailabilityList;

    public AssetMonthlyAvailabilityForComm() {

    }

    /**
     * @param assetMonthlyAvailabilityList
     */
    public AssetMonthlyAvailabilityForComm(
            List<AssetMonthlyAvailabilityBO> assetMonthlyAvailabilityList) {
        super();
        this.assetMonthlyAvailabilityList = assetMonthlyAvailabilityList;
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
     * @return the assetMonthlyAvailabilityList
     */
    public List<AssetMonthlyAvailabilityBO> getAssetMonthlyAvailabilityList() {
        return assetMonthlyAvailabilityList;
    }

    /**
     * @param assetMonthlyAvailabilityList
     *            the assetMonthlyAvailabilityList to set
     */
    public void setAssetMonthlyAvailabilityList(
            List<AssetMonthlyAvailabilityBO> assetMonthlyAvailabilityList) {
        this.assetMonthlyAvailabilityList = assetMonthlyAvailabilityList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(final Object other) {
        if (!(other instanceof AssetMonthlyAvailabilityForComm))
            return false;
        AssetMonthlyAvailabilityForComm castOther = (AssetMonthlyAvailabilityForComm) other;
        return new EqualsBuilder().append(method, castOther.method).append(
                assetMonthlyAvailabilityList,
                castOther.assetMonthlyAvailabilityList).isEquals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder().append(method).append(
                assetMonthlyAvailabilityList).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("method", method).append(
                "assetMonthlyAvailabilityBOList", assetMonthlyAvailabilityList)
                .toString();
    }

}
