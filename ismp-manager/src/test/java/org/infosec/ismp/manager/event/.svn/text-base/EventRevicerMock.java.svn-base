package org.infosec.ismp.manager.event;

import org.infosec.ismp.manager.winsensor.event.SensorEventd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2011-3-9 下午02:03:54
 * 
 */
public class EventRevicerMock {

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
		SensorEventd sensorEventd = (SensorEventd)content.getBean("sensorEventd");
		sensorEventd.start();
	}

}

