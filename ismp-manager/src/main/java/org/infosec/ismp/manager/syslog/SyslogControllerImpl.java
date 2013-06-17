package org.infosec.ismp.manager.syslog;

import org.infosec.ismp.manager.rmi.syslog.SyslogController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * syslog操作，manager上的实现接口
 * @author lianglin
 *
 */
@Component
public class SyslogControllerImpl implements SyslogController{
	
	private SyslogLocator m_syslogLocator;

	@Override
	public void addSyslogSource(String domain, String nodeId,
			String syslogType, String syslogAddress) {
		m_syslogLocator.addSyslogNode(domain,nodeId,syslogType,syslogAddress);
	}

	@Override
	public void removeSyslogSource(String nodeid) {
		m_syslogLocator.removeSyslogNode(nodeid);
		
	}
	
	@Autowired(required=true)
	public void setSyslogLocator(SyslogLocator syslogLocator) {
		m_syslogLocator = syslogLocator;
	}
	
	

}
