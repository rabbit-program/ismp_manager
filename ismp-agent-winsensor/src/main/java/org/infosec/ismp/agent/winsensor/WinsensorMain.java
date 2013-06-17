package org.infosec.ismp.agent.winsensor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.agent.winsensor.communication.services.WinsensorHttpServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

/**
 * @author Rocky
 * @version create time：Sep 16, 2010 2:56:35 PM
 * 
 */
public class WinsensorMain {

	private static Log log = LogFactory.getLog(WinsensorMain.class);
	
	private WinsensorHttpServices services = null;
	private ApplicationContext context;
	
	public void init() {
		context = new ClassPathXmlApplicationContext(
				new String[] {
						"classpath:applicationContext-resources.xml",
						"classpath:applicationContext-requestHandler.xml",
						"classpath:applicationContext-dao.xml",
						"classpath:applicationContext-service.xml",
						"classpath:applicationContext-winsensor.xml",
						"classpath:applicationContext-jms.xml",
						"classpath:applicationContext-rmi.xml"
				}
		);
		log.info("Load all bean configuration files over.");
	}
	
	public void start() {
		init();
//		loadProperties(new String[] {"classpath:application.properties"});
		
		startRequestHandlerServices();
	}
	
	public void loadProperties(String[] propertyLocations) {
		Properties prop = new Properties();
		
		//Load all property file
		for (String propertyLocation : propertyLocations) {
			String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(propertyLocation);
			URL url;
			FileReader reader = null;
			try {
				url = ResourceUtils.getURL(resolvedLocation);
				reader = new FileReader(url.getFile());
				prop.load(reader);
			} catch (FileNotFoundException e) {
				log.error("Error, could not find configuration file. path: " + resolvedLocation + ". " + e.getMessage());
				Thread.currentThread().interrupt();
			} catch (IOException e) {
				log.error("Error, could not read configuration file. path: " + resolvedLocation + ". " + e.getMessage());
				Thread.currentThread().interrupt();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//Set all key-value into system's property.
		Iterator<Object> iterator = prop.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String value = prop.getProperty(key);
			System.setProperty(key, value);
		}
		
		log.info("Load all property configuration files over.");
	}
	
	public void startRequestHandlerServices() {
		log.info("Http server is starting.");
		services = (WinsensorHttpServices) context.getBean("httpServices");
		services.start();
	}
	
	public static void main(String[] args) {
		WinsensorMain winsensorMain = new WinsensorMain();
		winsensorMain.start();
	}
}
