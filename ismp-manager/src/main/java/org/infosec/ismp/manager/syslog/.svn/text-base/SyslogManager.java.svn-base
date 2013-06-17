package org.infosec.ismp.manager.syslog;

import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 负责将收集到原始Syslog报文调用相应的处理器，处理成标准Syslog报文， 然后将各种标准Syslog报文调用专用处理器，生成对应的报文
 * 
 * @author lianglin
 * 
 */
@Component
public class SyslogManager {

	private SyslogLocator m_syslogLocator;

	private SyslogProcessorManager m_spManager;

	@Autowired(required = true)
	public void setSyslogLocator(SyslogLocator syslogLocator) {
		m_syslogLocator = syslogLocator;
	}

	@Autowired(required = true)
	public void setSpManager(SyslogProcessorManager spManager) {
		m_spManager = spManager;
	}

	public void addRawSyslog(RawSyslog rawSyslog) {
		String domain = m_syslogLocator.getSyslogDomain(rawSyslog.getNodeid());
		if (domain != null) {
			String fromIp = rawSyslog.getIpaddr();
			boolean flag = m_syslogLocator.existSyslogType(fromIp);
			if (flag) {// 找到对应类型
				String type = m_syslogLocator.getSyslogType(fromIp);
				m_spManager.processSyslog(rawSyslog, type,domain);
			} else {// 没有找到对应类型
				m_spManager.processSyslog(rawSyslog,domain);
			}
		}
		else{
			log().warn("该日志对应的域没有找到，该日志的nodeid是:"+rawSyslog.getNodeid());
		}

	}
	
	ThreadCategory log(){
		return ThreadCategory.getInstance(getClass());
	}

}
