package edu.sjtu.infosec.ismp.manager.TM.manager;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicTest extends TestCase{
	
	protected static ClassPathXmlApplicationContext appContext;

	static {
		try {
			appContext = new ClassPathXmlApplicationContext(new String[] {
					"classpath:applicationContext.xml",
					"classpath:applicationContext-managerweb.xml"
			   });
		} catch (Throwable t) {
			throw new Error(t);
		}
	}

}
