package org.infosec.ismp.manager.rmi.db;

import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.db.service.DbCollectionServiceMonitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2010-12-28 下午12:59:55
 * 
 */
public class DatabaseResultMock {

	/**
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */

	public static void main(String[] args) {

		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-db.xml"

				});

		DbCollectionServiceMonitor oracle = (DbCollectionServiceMonitor) content
				.getBean("dbCollectd");

		DatabaseResultStatus status = oracle.getDatabaseResult("nodeid111");
		System.out.println(status.toString());

	}

}

