package org.infosec.ismp.manager.rmi.threshold;

/**
 * @author guoxianwei
 * @date 2010-12-29 下午05:06:09
 * 
 */
public enum AlertType {
	CUP, MEMORY, HD, TRAFFIC;

	@Override
	public String toString() {
		return this.name();
	}
}

