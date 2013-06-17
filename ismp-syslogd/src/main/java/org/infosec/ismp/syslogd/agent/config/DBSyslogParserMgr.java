package org.infosec.ismp.syslogd.agent.config;

import org.infosec.ismp.syslogd.SyslogdParserMgr;

/**
 * @author guoxianwei
 * @date 2010-9-21 上午09:12:13
 * 
 */

public class DBSyslogParserMgr implements SyslogdParserMgr {

//	private static Map<String, SyslogParser> m_parsers = Collections
//	.synchronizedMap(new TreeMap<String, SyslogParser>());
//	
//	private SyslogDao syslogDao;
//	
//	public DBSyslogParserMgr(){
//	}
//	public void init(){
//		createSyslogParsers();
//	
//	}
//	@Override
//	public SyslogParser getSyslogParser(String syslogParserType) {
//
//		return m_parsers.get(syslogParserType);
//	}
//	
//	private synchronized void createSyslogParsers() {
//		ThreadCategory log = ThreadCategory.getInstance(getClass());
//
//		// Load up an instance of each monitor from the config
//		// so that the event processor will have them for
//		// new incomming events to create pollable service objects.
//		//
//		log.debug("start: Loading monitors");
//
//		Collection<SyslogParserLocator> locators = getSyslogParserLocators();
//
//		for (SyslogParserLocator locator : locators) {
//			try {
//				m_parsers.put(locator.getParserType(), locator
//						.getSyslogParser());
//			} catch (Throwable t) {
//				if (log.isEnabledFor(ThreadCategory.Level.WARN)) {
//					log.warn("start: Failed to create monitor "
//							+ locator.getParserLocatorKey() + " for service "
//							+ locator.getParserType(), t);
//				}
//			}
//		}
//
//	}
//	
//	public synchronized Collection<SyslogParserLocator> getSyslogParserLocators() {
//		List<SyslogParserLocator> locators = new ArrayList<SyslogParserLocator>();
//		for (SyslogParserType syslogParserType : parserTypes()) {
//			try {
//				Class<? extends SyslogParser> mc = findSyslogParserClass(syslogParserType);
//				// if (isDistributableToContext(mc, context)) {
//				SyslogParserLocator locator = new DefaultSyslogParserLocator(
//						syslogParserType.getType(), mc);
//				locators.add(locator);
//				// }
//			} catch (ClassNotFoundException e) {
//				log().warn(
//						"Unable to location Parser for Syslog: "
//								+ syslogParserType.getType() + " class-name: "
//								+ syslogParserType.getClassName(), e);
//			} catch (ObjectRetrievalFailureException e) {
//				log().warn(e.getMessage(), e.getRootCause());
//			}
//
//		}
//
//		return locators;
//
//	}
//	private Class<? extends SyslogParser> findSyslogParserClass(
//			SyslogParserType syslogParserType) throws ClassNotFoundException {
//		Class<? extends SyslogParser> mc = Class.forName(
//				syslogParserType.getClassName()).asSubclass(SyslogParser.class);
//		if (!SyslogParser.class.isAssignableFrom(mc)) {
//			throw new CastorDataAccessFailureException(
//					"The Parser for Syslog: " + syslogParserType.getType()
//							+ " class-name: " + syslogParserType.getClassName()
//							+ " must implement SyslogParser");
//		}
//		return mc;
//	}
//    protected List<SyslogParserType> parserTypes(){
//    	
//		return syslogDao.loadAllParserTypes();
//    }
//    
//	public SyslogDao getSyslogDao() {
//		return syslogDao;
//	}
//	@Autowired(required=true)
//	public void setSyslogDao(SyslogDao syslogDao) {
//		this.syslogDao = syslogDao;
//	}
//	private ThreadCategory log() {
//		return ThreadCategory.getInstance(this.getClass());
//	}
}

