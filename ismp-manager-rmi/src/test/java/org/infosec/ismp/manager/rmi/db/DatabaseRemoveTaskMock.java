package org.infosec.ismp.manager.rmi.db;

import org.infosec.ismp.manager.rmi.db.service.DbCollectionServiceMonitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2010-12-17 下午01:09:53
 * 
 *  删除数据库收集任务测试类
 */
public class DatabaseRemoveTaskMock {

	public static void main(String[] args) {

		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-db.xml"

				});

		DbCollectionServiceMonitor dbTask = (DbCollectionServiceMonitor) content
				.getBean("dbCollectd");
		dbTask.removeDatabaseColletor("nodeid111");

		System.out.println("ssssssssssssss");

	}

}

