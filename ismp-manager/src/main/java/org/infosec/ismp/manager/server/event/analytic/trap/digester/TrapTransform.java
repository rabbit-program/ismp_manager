/**
 * 
 */
package org.infosec.ismp.manager.server.event.analytic.trap.digester;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Jianyu Shen
 *
 * 2009-6-1
 */
public class TrapTransform {

    String method;

    String serialNumber;

    /**
     * 
     * getMethod
     */
    public String getMethod() {
        return method;
    }

    /**
     * 
     * setMethod
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 
     * getSerialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * 
     * setSerialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * method: toString
     */
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }
    
}
