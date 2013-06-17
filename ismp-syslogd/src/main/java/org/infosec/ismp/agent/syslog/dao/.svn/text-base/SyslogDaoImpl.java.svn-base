package org.infosec.ismp.agent.syslog.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.infosec.ismp.agent.syslog.model.SyslogParserConfig;
import org.infosec.ismp.agent.syslog.model.SyslogParserType;
import org.infosec.ismp.model.syslog.UeiMatch;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * @author guoxianwei
 * @date 2010-9-20 下午01:39:07
 * 
 */
@Component
@Transactional
public class SyslogDaoImpl extends HibernateDao<SyslogParserConfig,Integer> implements SyslogDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SyslogParserConfig> loadAllUeiMatch() {
		List<SyslogParserConfig> list = find(" from SyslogParserConfig ");
		if(list.isEmpty())
			list = Collections.emptyList();
		return new ArrayList(list);
	}


	@Override
	public boolean hasUeiMatch(UeiMatch ueiMatch) {
		if (findSyslogParserConfig(ueiMatch.getSyslogType(),ueiMatch.getIpAddr())!=null) {
			return true;
		}else{
			return false;
		}
	}

	private SyslogParserConfig findSyslogParserConfig(String type,String ipAddr){
		List<SyslogParserConfig> list = find(" from SyslogParserConfig s where s.type = ? and s.ipAddr = ?  ",
				new Object[] { type,ipAddr});
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
		
	}
	@Override
	public void deleteUeiMatch(UeiMatch ueiMatch) {
		SyslogParserConfig parserConfig = findSyslogParserConfig(ueiMatch.getSyslogType(),ueiMatch.getIpAddr());
		if(parserConfig != null){
			delete(parserConfig);
		}
	}


	@Override
	public void saveUeiMatch(UeiMatch ueiMatch) {
		if(!hasUeiMatch(ueiMatch)){
			SyslogParserConfig parserConfig = new SyslogParserConfig();
			parserConfig.setIpAddr(ueiMatch.getIpAddr());
			parserConfig.setType(ueiMatch.getSyslogType());
			parserConfig.setSrcId(ueiMatch.getSyslogSrcId());
			parserConfig.setDomainId(ueiMatch.getDomainId());
			save(parserConfig);
		}
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SyslogParserType> loadAllParserTypes() {
		List<SyslogParserType> list = find(" from SyslogParserType s ");
		if(list.isEmpty())
			list = Collections.emptyList();
		return new ArrayList(list);
	}

}

