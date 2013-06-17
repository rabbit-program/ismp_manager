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
public class TrapParser {

    String ip; //监听设备的IP
    
    String type;//标识设备的型号
    
    String deconding;//字符串编码格式

	public String getDeconding() {
		return deconding;
	}

	public void setDeconding(String deconding) {
		this.deconding = deconding;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	Vector<TrapMatcher> trapMatchers;

    /**
     * 
     */
    public TrapParser() {
        this.trapMatchers = new Vector<TrapMatcher>();
    }

    /**
     * 
     * getIp
     */
    public String getIp() {
        return ip;
    }

    /**
     * 
     * setIp
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 
     * addTrapMatcher
     */
    public void addTrapMatcher(TrapMatcher trapMatcher) {
        this.trapMatchers.add(trapMatcher);
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
     * getTrapMatchers
     */
    public Vector<TrapMatcher> getTrapMatchers() {
        return trapMatchers;
    }

    /**
     * 
     * setTrapMatchers
     */
    public void setTrapMatchers(Vector<TrapMatcher> trapMatchers) {
        this.trapMatchers = trapMatchers;
    }    
}
