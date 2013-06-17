package org.infosec.ismp.model.poller.config;

import java.io.Serializable;
/**
 * 代表服务检测相关参数。
 * @author lianglin
 *
 */
public class ServiceParameter implements Serializable {
	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

}
