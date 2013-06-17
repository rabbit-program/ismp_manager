package edu.sjtu.infosec.ismp.manager.AIM.comm;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import edu.sjtu.infosec.ismp.manager.AM.model.Device;

/**
 * 完整类名：edu.sjtu.infosec.ismp.base.alert.Alert <br>
 * 所在工程：ismp-base <br>
 * 说明：当超过阈值时生成的阈值事件对象
 * 
 * @author $Author$
 * @version $Revision$ $Date$
 * 
 */
public class Alert implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -6796062990107029043L;

    /**
	 * 说明：对应设备
	 */
	private Device device;
	
	/**
	 * 说明：生成日期时间
	 */
	private Date generateDate;
	private String label;
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 说明：事件类型（指CPU、MEMORY、HARDDISK等等）
	 */
	private String alertType;
	
	/**
	 * 说明：阈值，指触发时的状态参数阈值设置值。
	 */
	private Long threshold;
	
	/**
	 * 说明：触发值，指触发时的状态参数实际值
	 */
	private Long alertValue;
	
	/**
	 * 网口的描述（名称）（2010/05/19日新增）
	 */
	private String interfaceName;

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Date getGenerateDate() {
		return generateDate;
	}

	public void setGenerateDate(Date generateDate) {
		this.generateDate = generateDate;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public Long getThreshold() {
		return threshold;
	}

	public void setThreshold(Long threshold) {
		this.threshold = threshold;
	}

	public Long getAlertValue() {
		return alertValue;
	}

	public void setAlertValue(Long alertValue) {
		this.alertValue = alertValue;
	}
	
	public String toString() {
		return new ToStringBuilder(this).append("device", device).append(
				"generateDate", generateDate).append("alertType", alertType)
				.append("threshold", threshold)
				.append("alertValue", alertValue).toString();
	}
}
