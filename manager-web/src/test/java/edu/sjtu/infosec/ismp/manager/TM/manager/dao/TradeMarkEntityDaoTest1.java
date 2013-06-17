package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TradeMarkEntityDaoTest1 {
	
	private static ClassPathXmlApplicationContext appContext;

	static {
		try {
			appContext = new ClassPathXmlApplicationContext(new String[] {
					"classpath:applicationContext.xml"
			   });
		} catch (Throwable t) {
			throw new Error(t);
		}
	}
	
	


	public static void main(String[] args) {
		
		
		TradeMarkService dao = (TradeMarkService) appContext.getBean("tradeMarkService");
		
		System.out.println("---------------------");
		dao.save(new TradeMarkEntity());
		
		
		
	}
}
