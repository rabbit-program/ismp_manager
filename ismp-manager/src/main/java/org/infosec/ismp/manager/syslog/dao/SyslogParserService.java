package org.infosec.ismp.manager.syslog.dao;

import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.manager.model.syslog.SyslogParserEntity;
import org.infosec.ismp.model.syslog.SyslogDeepParser;
import org.infosec.ismp.model.syslog.SyslogParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.utils.SpringContextHolder;

/**
 *  管理SyslogParser
 * @author lianglin
 *
 */
@Component
public class SyslogParserService {
    private SyslogParserEntityDao m_parserDao;
    
    /**
     * type<->syslogParser
     */
    private Map<String,SyslogParser> m_rawSyslogParsers = new HashMap<String, SyslogParser>();
    
    private Map<String,SyslogDeepParser> m_rawSyslogDeepParsers = new HashMap<String, SyslogDeepParser>();

    @Autowired(required=true)
	public void setParserDao(SyslogParserEntityDao parserDao) {
		m_parserDao = parserDao;
	}
    
    
    /**
     * 找到对应的raw syslog parser
     * @param type
     * @return
     */
    @Transactional(readOnly=true)
    public SyslogParser getRawSyslogParser(String type){
    	SyslogParser parser = m_rawSyslogParsers.get(type);
    	if(parser==null){
    		String parserClass = m_parserDao.getRawSyslogParserClass(type);
    		if(parserClass!=null){
    			try {
					parser =(SyslogParser)(Class.forName(parserClass).newInstance());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				if(parser!=null){
					m_rawSyslogParsers.put(type, parser);
				}
    		}
    	}
    	return parser;
    	
    }
    @Transactional
    public void save(SyslogParserEntity entity){
    	m_parserDao.save(entity);
    }
    
    
    public SyslogDeepParser getSyslogDeepParser(String type){
    	SyslogDeepParser parser = m_rawSyslogDeepParsers.get(type);
    	if(parser==null){
    		String parserClass = m_parserDao.getSpecialSyslogParserClass(type);
    		if(parserClass!=null){
    			try {
//					parser =(SyslogParser)(Class.forName(parserClass).newInstance());
    				Class c = Class.forName(parserClass);
    				parser = (SyslogDeepParser)SpringContextHolder.getBean(c);
				} catch (Throwable e) {
					e.printStackTrace();
				}
				if(parser!=null){
					m_rawSyslogDeepParsers.put(type, parser);
				}
    		}
    	}
    	return parser;
    }
}
