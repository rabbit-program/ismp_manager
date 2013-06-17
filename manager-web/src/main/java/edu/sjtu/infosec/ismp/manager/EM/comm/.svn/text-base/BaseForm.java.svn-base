package edu.sjtu.infosec.ismp.manager.EM.comm;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.struts.action.ActionForm;

/**
 * Base ActionForm bean. Used to give child classes readable
 * representation of their properties using toString() method.
 *
 */
public class BaseForm extends ActionForm{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3257005453799404851L;

    /**
     * toString
     * @return String
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

   /**
     * equals
     * @param o
     * Object
     * @return boolean
     */
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    /**
     * hashCode
     * @return int
     */
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    
}
