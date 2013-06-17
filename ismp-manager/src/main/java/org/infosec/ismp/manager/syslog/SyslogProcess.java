package org.infosec.ismp.manager.syslog;

import java.util.List;

import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.model.syslog.SyslogParser;
import org.infosec.ismp.util.ThreadCategory;

/**
 * Syslog处理过程，将一个原始Syslog报文，变成一个标准Syslog，
 * 入库，然后调用对应特殊的Syslog处理器，处理成各种设备不同
 * 的Syslog报文
 * @author lianglin
 * @deprecated
 *
 */
@Deprecated
public class SyslogProcess implements Runnable {
	
	//原始报文信息
	private RawSyslog m_rawSyslog;
	
	private List<SyslogParser> m_parsers;

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	
	
//	protected Syslog processRawSyslog(){
//		byte data[]  = m_rawSyslog.getContents();
//		int len = data.length;
//		Syslog syslog = null;
//		for(SyslogParser parser: m_parsers){
//			try{
//				syslog = parser.parseSyslog(data, len);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//			if(syslog!=null){
//				break;
//			}
//		}
//		if(syslog==null){
//			log().warn("该日志内容无法处理，请检查");
//		}
//		return syslog;
//	}
	
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
