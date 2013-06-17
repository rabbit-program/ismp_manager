package org.infosec.ismp.agent.winsensor;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Rocky
 * @version create time：Nov 24, 2010 4:35:37 PM
 * 
 */
public class Log4jTest {
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("D:\\RockyWorkSpace\\ismp-agent-winsensor\\src\\main\\resources\\log4j.properties");
		
		Logger logger = Logger.getLogger(Log4jTest.class);
		
		logger.info("test");
	}
}
