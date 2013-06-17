package org.infosec.ismp.syslogd.manager;

import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.Parms;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventHelper;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.model.syslog.Syslog;
import org.infosec.ismp.model.syslog.SyslogDeepParser;
import org.infosec.ismp.model.syslog.SyslogWrapper;
import org.infosec.ismp.util.concurrent.RunnableConsumerThreadPool;
import org.infosec.ismp.util.queue.FifoQueueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * @author root
 *
 */
//@Component
public class SyslogEventProcessor {
//implements EventListener {
	
//	/**
//	 * The thread pool handling the events
//	 */
//	private RunnableConsumerThreadPool m_eventHandlerPool;
//	
//	private List<SyslogDeepParser> m_deepParsers = new ArrayList<SyslogDeepParser>();
//	
//	private SyslogPersister m_persister;
//
//	@Override
//	public String getName() {
//		return "manager_syslogd:processor";
//	}
//
//	@Override
//	public void onEvent(final Event e) {
//
//		try {
//			m_eventHandlerPool.getRunQueue().add(new Runnable(){
//
//				@Override
//				public void run() {
//					
//					m_persister.saveSyslsog(convertWrapper(e));
//				}
//				
//			});
//		} catch (FifoQueueException e2) {
//			e2.printStackTrace();
//		} catch (InterruptedException e2) {
//			e2.printStackTrace();
//		}
//		
//		String uei = e.getUei();
//		
//        String type = getSyslogType(uei);
//        
//        for(SyslogDeepParser parser:m_deepParsers){
//        	String parserType = parser.getType();
//        	if(type.equalsIgnoreCase(parserType)){
//        		//TODO:
//        		Runnable r = parser.createRunnable(convertWrapper(e));
//        		try {
//					m_eventHandlerPool.getRunQueue().add(r);
//				} catch (FifoQueueException e1) {
//					e1.printStackTrace();
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//        	}
//        	break;
//        }
//	}
//	
//	private void createSelectorAndSubscribe(){
//		List<String> ueis = new ArrayList<String>();
//		
//		ueis.add(EventConstants.SYSLOG_EVENT_UEI_PRIFIX);
//		
//		EventIpcManagerFactory.getIpcManager().addEventListener(this,ueis);
//	}
//
//	public SyslogEventProcessor() {
//		createSelectorAndSubscribe();
//		initThreadPool();
//	}
//	
//	private String getSyslogType(String uei){
//		uei = uei.replace(EventConstants.SYSLOG_EVENT_UEI_PRIFIX, "");
////		System.out.println("uei is : "+uei);
//		int index = uei.indexOf("/");
//		String type = uei.substring(0,index);
//		return type;
//	}
//	
//	private void initThreadPool(){
//		m_eventHandlerPool = new RunnableConsumerThreadPool("syslog event parse",0.6f,1.0f,5);
//		m_eventHandlerPool.start();
//	}
//
//	public void setDeepParsers(List<SyslogDeepParser> deepParsers) {
//		m_deepParsers = deepParsers;
//	}
//
//	@Autowired(required=true)
//	public void setPersister(SyslogPersister persister) {
//		m_persister = persister;
//	}
//	
//	SyslogWrapper convertWrapper(Event event){
//		SyslogWrapper wrapper = new SyslogWrapper();
//		Parms parms = event.getParms();
//		wrapper.setDomain(EventHelper.getValue(parms, "domainid"));
//		wrapper.setLogSource(EventHelper.getValue(parms, "logsource"));
//		
//		Syslog log = new Syslog();
//		log.setFacility(EventHelper.getValue(parms, "facility"));
//		log.setSeverity(EventHelper.getValue(parms, "severity"));
//		log.setHostname(EventHelper.getValue(parms, "hostname"));
//		log.setIpaddr(EventHelper.getValue(parms, "ipaddr"));
//		log.setMsg(EventHelper.getValue(parms, "message"));
//		log.setTimestamp(EventHelper.getValue(parms, "timestamp"));
//		wrapper.setSyslog(log);
//		
//		return wrapper;
//	}
//	
//	

}
