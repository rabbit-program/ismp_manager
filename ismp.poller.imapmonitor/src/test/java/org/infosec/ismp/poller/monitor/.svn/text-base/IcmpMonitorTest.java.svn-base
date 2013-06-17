/**   
* @Title: HttpsMonitorTest.java
* @Package org.infosec.ismp.poller.monitor.test
* @Description: TODO(用一句话描述该文件做什么)
* @author guoxianwei  
* @date 2010-9-14 上午10:51:46
* @version V1.0   
*/


package org.infosec.ismp.poller.monitor;

import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.poller.monitors.test.MonitorTest;

/**
 * @ClassName: HttpsMonitorTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author guoxianwei
 * @date 2010-9-14 上午10:51:46
 * 
 */
public class IcmpMonitorTest {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */

	public static void main(String[] args) {
		MonitorTest test = new MonitorTest();
		test.setIpAddr("127.0.0.1");
		test.setClassName("org.infosec.ismp.poller.monitor.ImapMonitor");
		Map parameters = new HashMap();
		parameters.put("port", "143");
		parameters.put("retry", "3");
		parameters.put("timeout", "3000");
		test.setParameters(parameters);
		test.test();
	}

}

