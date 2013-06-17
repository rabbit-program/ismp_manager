package org.infosec.ismp.manager.threshold;

import java.io.Serializable;

import org.infosec.ismp.manager.rmi.threshold.AlertType;

/**
 * @author guoxianwei
 * @date 2010-12-30 下午12:30:58
 *  阈值信息
 */
public class Threshold implements Serializable {

	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param level
	* @param nodeid
	* @param threshold
	* @param type
	* @param value
	*/
	
	public Threshold(int level, String nodeid, Number threshold,
			AlertType type, String value) {
		super();
		this.level = level;
		this.nodeid = nodeid;
		this.threshold = threshold;
		this.type = type;
		this.value = value;
	}
	public Threshold(){}
	private static final long serialVersionUID = 7985992323002827667L;
	public String getNodeid() {
		return nodeid;
	}
	public AlertType getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	public int getLevel() {
		return level;
	}
	public Number getThreshold() {
		return threshold;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public void setType(AlertType type) {
		this.type = type;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	String nodeid;
	AlertType type;
	String value;
	int level;
	Number threshold;
}

