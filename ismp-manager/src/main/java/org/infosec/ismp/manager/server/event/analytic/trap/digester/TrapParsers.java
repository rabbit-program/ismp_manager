/**
 * 
 */
package org.infosec.ismp.manager.server.event.analytic.trap.digester;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Jianyu Shen
 *
 * 2009-6-1
 */
public class TrapParsers {

    Map<String, TrapParser> trapParsers;

    public TrapParsers() {
        trapParsers = new HashMap<String, TrapParser>();
    }

    /**
     * 
     * getTrapParsers
     */
    public Map<String, TrapParser> getTrapParsers() {
        return trapParsers;
    }

    /**
     * 
     * setTrapParsers
     */
    public void setTrapParsers(Map<String, TrapParser> trapParsers) {
        this.trapParsers = trapParsers;
    }

    /**
     * 
     * addTrapParser
     */
    public void addTrapParser(TrapParser trapParser) {
        this.trapParsers.put(trapParser.getIp(), trapParser);
    }

    /**
     * method: toString
     */
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }
    
}
