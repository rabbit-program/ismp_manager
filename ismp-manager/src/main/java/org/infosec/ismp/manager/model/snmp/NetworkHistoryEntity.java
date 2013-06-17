package org.infosec.ismp.manager.model.snmp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author guoxianwei
 * @date 2010-12-28 下午04:27:07
 * 
 */
@Embeddable
public class NetworkHistoryEntity implements Serializable {

	private static final long serialVersionUID = -7106922295130422072L;

	@Column(name = "parm_key")
	private String key;
	private String value;
	private Integer keyindex;
	private String deviceType;//设备详细指标项类型

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public Date getTime() {
		return time;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public Integer getKeyindex() {
		return keyindex;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setKeyindex(Integer keyindex) {
		this.keyindex = keyindex;
	}


}

