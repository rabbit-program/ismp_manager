package org.infosec.ismp.manager.alert;

import org.infosec.ismp.manager.rmi.aim.service.NewAlertService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetAlertRmiClientMock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml","alert/applicationContext-alert.xml");
		NewAlertService newAlert = (NewAlertService)con.getBean("alertControllerClient");
//		Map map = newAlert.getNewAlert(0L);
	}

}
