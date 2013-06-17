package org.infosec;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
 * @author lianglin
 *
 */
public class JmsSubscribeListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created");
		
		se.getSession().setMaxInactiveInterval(60*3);
		
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destroyed");
		
	}

}
