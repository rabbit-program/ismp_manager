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
public class TrapBinding {

    String bindingNumber; //绑定行号

    String regex;

    String columns;

    Vector<TrapTransform> trapTransforms;

    /**
     * 
     */
    public TrapBinding() {
        trapTransforms = new Vector<TrapTransform>();
    }

    /**
     * 
     * getBindingNumber
     */
    public String getBindingNumber() {
        return bindingNumber;
    }

    /**
     * 
     * setBindingNumber
     */
    public void setBindingNumber(String bindingNumber) {
        this.bindingNumber = bindingNumber;
    }

    /**
     * 
     * addTrapTransform
     */
    public void addTrapTransform(TrapTransform trapTransform) {
        this.trapTransforms.add(trapTransform);
    }

    /**
     * 
     */
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * 
     * getColumns
     */
    public String getColumns() {
        return columns;
    }

    /**
     * 
     * setColumns
     */
    public void setColumns(String columns) {
        this.columns = columns;
    }

    /**
     * 
     * getRegex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * 
     * setRegex
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * 
     * getTrapTransforms
     */
    public Vector<TrapTransform> getTrapTransforms() {
        return trapTransforms;
    }

    /**
     * 
     * setTrapTransforms
     */
    public void setTrapTransforms(Vector<TrapTransform> trapTransforms) {
        this.trapTransforms = trapTransforms;
    }
    
}
