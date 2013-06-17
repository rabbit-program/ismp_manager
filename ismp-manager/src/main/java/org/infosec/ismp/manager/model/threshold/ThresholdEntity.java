package org.infosec.ismp.manager.model.threshold;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author guoxianwei
 * @date 2010-12-29 下午05:16:06
 * 
 */
@Entity
@Table(name="threshold_entity")
public class ThresholdEntity implements Serializable {
	private static final long serialVersionUID = -2909635998347926503L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nodeid;
	private String alertType;
	private String value;
	private Integer level;
	private Number threshold;

	public Integer getId() {
		return id;
	}

	public String getNodeid() {
		return nodeid;
	}

	public String getAlertType() {
		return alertType;
	}

	public Integer getLevel() {
		return level;
	}

	public String getValue() {
		return value;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Number getThreshold() {
		return threshold;
	}

	public void setThreshold(Number threshold) {
		this.threshold = threshold;
	}
}

