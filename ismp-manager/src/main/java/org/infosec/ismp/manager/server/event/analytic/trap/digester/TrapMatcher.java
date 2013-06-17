/**
 * 
 */
package org.infosec.ismp.manager.server.event.analytic.trap.digester;

import java.util.Vector;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Jianyu Shen
 *
 * 2009-6-1
 */
public class TrapMatcher {

    String tableName; //定义表名

    Vector<TrapBinding> trapBindings;

    /**
     * 
     */
    public TrapMatcher() {
        this.trapBindings = new Vector<TrapBinding>();
    }

    /**
     * method: toString
     */
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * 
     * getTableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 
     * setTableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 
     * addTrapBinding
     */
    public void addTrapBinding(TrapBinding trapBinding) {
        this.trapBindings.add(trapBinding);
    }

    /**
     * 
     * getTrapBindings
     */
    public Vector<TrapBinding> getTrapBindings() {
        return trapBindings;
    }

    /**
     * 
     * setTrapBindings
     */
    public void setTrapBindings(Vector<TrapBinding> trapBindings) {
        this.trapBindings = trapBindings;
    }
    
}
