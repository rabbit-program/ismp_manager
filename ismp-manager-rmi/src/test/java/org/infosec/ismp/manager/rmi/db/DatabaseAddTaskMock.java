package org.infosec.ismp.manager.rmi.db;

import org.infosec.ismp.manager.rmi.db.model.DbCollectionRmiBean;
import org.infosec.ismp.manager.rmi.db.service.DbCollectionServiceMonitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guoxianwei
 * @date 2010-12-17 下午01:11:56
 *   添加数据库收集任务测试类
 */
public class DatabaseAddTaskMock {


	public static void main(String[] args) {



		ApplicationContext content = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext-db.xml"
						
				});

		
//		DbCollectionServiceMonitor sqlserver = (DbCollectionServiceMonitor) content
//				.getBean("dbCollectd");
//		DbCollectionRmiBean dbBean = new DbCollectionRmiBean();
//		dbBean.setDbname("master");
//		dbBean.setDbtype("sqlserver");
//		dbBean.setDomain("testDomain");
//		dbBean.setInterval(Long.valueOf("3000"));
//		dbBean.setNodeid("111112");
//		dbBean.setUsername("sa");
//		dbBean.setPassword("123456");
//		dbBean.setPort(1433);
//		dbBean.setUrl("192.168.9.146");
//		dbBean.setVersion("2005");
//		sqlserver.addDatabaseColletor(dbBean);
		
		DbCollectionServiceMonitor oracle = (DbCollectionServiceMonitor) content
		                    .getBean("dbCollectd");
		DbCollectionRmiBean odbBean = new DbCollectionRmiBean();
		odbBean.setDbname("ORCL");
		odbBean.setDbtype("oracle");
		odbBean.setDomain("testDomain");
		odbBean.setInterval(Long.valueOf("30000"));
		odbBean.setNodeid("nodeid111");
		odbBean.setUsername("guoxianwei");
		odbBean.setPassword("123456");
		odbBean.setPort(1521);
		odbBean.setUrl("192.168.9.85");
		odbBean.setVersion("9i");
		oracle.addDatabaseColletor(odbBean);

		System.out.println("ssssssssssssss");
	
	}

}

