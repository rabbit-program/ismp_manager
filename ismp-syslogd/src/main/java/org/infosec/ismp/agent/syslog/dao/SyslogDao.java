package org.infosec.ismp.agent.syslog.dao;

import java.util.List;

import org.infosec.ismp.agent.syslog.model.SyslogParserConfig;
import org.infosec.ismp.agent.syslog.model.SyslogParserType;
import org.infosec.ismp.model.syslog.UeiMatch;

/**
 * @author guoxianwei
 * @date 2010-9-20 上午10:52:52
 * 
 */


public interface SyslogDao {

	
	abstract List<SyslogParserConfig> loadAllUeiMatch();

	abstract boolean hasUeiMatch(UeiMatch ueiMatch);
	
	abstract void deleteUeiMatch(UeiMatch ueiMatch);
	
	abstract void saveUeiMatch(UeiMatch ueiMatch);
	
	abstract List<SyslogParserType> loadAllParserTypes();

}

