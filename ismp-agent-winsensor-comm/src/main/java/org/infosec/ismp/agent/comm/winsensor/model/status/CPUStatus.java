package org.infosec.ismp.agent.comm.winsensor.model.status;

import java.io.Serializable;

/**
 * @author Rocky
 * @version create time：Oct 12, 2010 8:04:44 PM
 * 
 */
public class CPUStatus implements Serializable {

	private static final long serialVersionUID = -6326042676894751151L;

    /**
     * 变量名称：loads 变量类型：Integer[] <br>
     * 说明：PC设备的CPU负载数组。数组长度代表该台PC的CPU的个数（如双核CPU则为2），每个元素为一个0到100之间的整数，
     * 代表该CPU核心的负载百分比。
     */
	private Integer loads[];

	public Integer[] getLoads() {
		return loads;
	}

	public void setLoads(Integer[] loads) {
		this.loads = loads;
	}
}
