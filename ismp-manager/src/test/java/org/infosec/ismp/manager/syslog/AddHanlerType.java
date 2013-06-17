package org.infosec.ismp.manager.syslog;

import org.infosec.ismp.manager.model.syslog.SyslogParserEntity;
import org.infosec.ismp.manager.syslog.dao.SyslogParserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddHanlerType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:applicationContext.xml"});

		SyslogParserService s = (SyslogParserService)ctx.getBean("syslogParserService");
		SyslogParserEntity entity = new SyslogParserEntity();
		entity.setHandleType("hillstone");
		entity.setRawParserClass("org.infosec.ismp.manager.syslog.hillstone.HillStoneSyslogParse");
		entity.setSpecialParserClass("org.infosec.ismp.manager.syslog.hillstone.HillstoneFireWallDeepParser");
		s.save(entity);
		
	}

}
