package org.infosec.ismp.syslogd;

import org.springframework.util.Assert;

public final class SyslogdParserMgrFactory {
	private static SyslogdParserMgr m_syslogdParserMgr;

	public static SyslogdParserMgr getSyslogdParserMgr() {
		Assert.state(m_syslogdParserMgr!=null);
		return m_syslogdParserMgr;
	}

	public static void setSyslogdParserMgr(SyslogdParserMgr syslogdParserMgr) {
		
		m_syslogdParserMgr = syslogdParserMgr;
	}

	/**
	 * This is here for unit testing so we can reset this class before every
	 * test.
	 */
	protected static void reset() {
		m_syslogdParserMgr = null;
	}

}
