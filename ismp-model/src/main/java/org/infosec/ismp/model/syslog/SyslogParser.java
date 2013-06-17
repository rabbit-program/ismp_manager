package org.infosec.ismp.model.syslog;

import java.io.UnsupportedEncodingException;

import org.infosec.ismp.model.syslog.MessageDiscardedException;


/**
 * 定制syslog在agent端的解析方法
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public interface SyslogParser {
	/**
	 * 将syslog报文解析成Syslog对象。
	 * @param data
	 * @param len
	 * @return
	 */
	public SyslogEntity parseSyslog(byte[] data, int len)
			throws UnsupportedEncodingException, MessageDiscardedException;

//	public boolean isRightSyslog(byte[] data, int len);
	
//	public String createSyslogUei(String ueiPrefix,Syslog syslog);
}
