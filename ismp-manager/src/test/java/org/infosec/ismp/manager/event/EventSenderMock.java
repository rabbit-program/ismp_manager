package org.infosec.ismp.manager.event;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.winsensor.event.EventSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2011-3-9 下午02:04:18
 * 
 */
public class EventSenderMock {

	/**
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */

	public static void main(String[] args) {
		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] { 
						"classpath:applicationContext.xml",
						"classpath:winsensor/applicationContext-event.xml" });
		EventSender eventSender = (EventSender)content.getBean("sensorSender");
		AlertInfoBO alertinfo = new AlertInfoBO();
		alertinfo.setNodeid(Long.valueOf("2222222222"));
		alertinfo.setSrcIP("127.0.0.1");
		alertinfo.setDomain_id(Integer.parseInt("22"));
		alertinfo.setLevel(1);
		alertinfo.setAlertType("阈值告警");
		alertinfo.setAlertSubType("pc");
		alertinfo.setAlertReason("超出阈值");
		alertinfo.setTime(long2Timestamp(System.currentTimeMillis()));
		eventSender.send(alertinfo);
	}
	public static java.sql.Timestamp long2Timestamp(long time) {
		java.sql.Timestamp timeTemp = new java.sql.Timestamp(time);
		timeTemp.setNanos(0);
		return timeTemp;
	}
}

