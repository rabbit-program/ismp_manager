package org.infosec.ismp.situation;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 完整类名：org.infosec.ismp.situation.ApplicationContextProvider.java <br>
 * 所在工程：ismp_situation <br>
 * 说明：提供全局访问的ApplicationContext引用
 * 
 * @author $Author$
 * @version $Revision$ $Date$
 * 2010-10-18 13:46:38
 */
public class ApplicationContextProvider implements ApplicationContextAware {

	/**
	 * 变量名称：appContext 变量类型：ApplicationContext <br>
	 * 说明：保存全局的ApplicationContext引用
	 */
	private static ApplicationContext appContext;
	
	private static Logger logger = Logger.getLogger(ApplicationContextProvider.class);
	
	/**
	 * 方法说明：获取全局的ApplicationContext引用
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return appContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		appContext = applicationContext;
		logger.info("application context set.");
	}

}
