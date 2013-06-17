package org.infosec.ismp.syslogd.agent.config;

import org.infosec.ismp.model.syslog.SyslogParser;
import org.springframework.orm.ObjectRetrievalFailureException;

/**
 * @author guoxianwei
 * @date 2010-9-21 上午10:28:17
 * 
 */
public class DefaultSyslogParserLocator {
//implements SyslogParserLocator {
	

    String m_parserType;
    
    Class<? extends SyslogParser> m_parserClass;
    
    public DefaultSyslogParserLocator(String parserType, Class<? extends SyslogParser> parserClass) {
    	m_parserType = parserType;
    	m_parserClass = parserClass;
    }
    
//	@Override
//	public String getParserLocatorKey() {
//
//		return m_parserClass.getName();
//	}
//
//	@Override
//	public String getParserType() {
//
//		return m_parserType;
//	}

//	@Override
//	public SyslogParser getSyslogParser() {
//        try {
//        	SyslogParser mon = m_parserClass.newInstance();
//
//            return mon;
//        } catch (InstantiationException e) {
//            throw new ObjectRetrievalFailureException("Unable to instantiate monitor for service "
//                    +m_parserType+" with class-name "+m_parserClass.getName(), e);
//        } catch (IllegalAccessException e) {
//            throw new ObjectRetrievalFailureException("Illegal access trying to instantiate monitor for service "
//                    +m_parserType+" with class-name "+m_parserClass.getName(), e);
//        }
//    }

}

