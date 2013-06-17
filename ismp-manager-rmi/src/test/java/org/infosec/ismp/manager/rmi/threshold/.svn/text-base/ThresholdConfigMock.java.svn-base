package org.infosec.ismp.manager.rmi.threshold;

import org.infosec.ismp.manager.rmi.threshold.service.ThresholdConfigRmi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2010-12-30 上午10:16:27
 * 
 */
public class ThresholdConfigMock {

	/**
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */

	public static void main(String[] args) {


		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] { 
						"classpath:applicationContext-threshold.xml" 
						});

		ThresholdConfigRmi threshold = (ThresholdConfigRmi) content
				.getBean("threshold");

		threshold.setThreshConfig("1111", AlertType.CUP, "cpu", 1, 1);
		threshold.setThreshConfig("1111", AlertType.HD, "C", 1, 1000);
		threshold.setThreshConfig("1111", AlertType.MEMORY, "memory", 1, 1000);
		threshold.setThreshConfig("1111", AlertType.TRAFFIC, "traffic", 1, 10);
		
//		threshold.deleteThreshConfig("threshold", AlertType.CUP);
	
	}

}

