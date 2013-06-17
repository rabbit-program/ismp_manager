package org.infosec.ismp.manager.syslog;

import java.io.UnsupportedEncodingException;

import org.infosec.ismp.manager.syslog.dao.RawSyslogService;
import org.infosec.ismp.manager.syslog.dao.SyslogParserService;
import org.infosec.ismp.model.syslog.MessageDiscardedException;
import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.model.syslog.SyslogDeepParser;
import org.infosec.ismp.model.syslog.SyslogEntity;
import org.infosec.ismp.model.syslog.SyslogParser;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 管理Agent端的syslog处理
 * @author lianglin
 *
 */
@Component
public class SyslogProcessorManager {

	private SyslogParserService m_parserService;
	
	private RawSyslogService m_rawSyslogService;
	
	@Autowired(required=true)
	public void setParserService(SyslogParserService parserService) {
		m_parserService = parserService;
	}
	
	
	@Autowired(required=true)
	public void setRawSyslogService(RawSyslogService rawSyslogService) {
		m_rawSyslogService = rawSyslogService;
	}



	public void processSyslog(RawSyslog rawSyslog, String type,String domain) {
		SyslogParser parser = m_parserService.getRawSyslogParser(type);
		if(parser!=null){
			byte[] data = rawSyslog.getContents();
			int len = data.length;
			try {
				SyslogEntity syslog = parser.parseSyslog(data, len);
				syslog.setNodeid(rawSyslog.getNodeid());
				syslog.setIpaddr(rawSyslog.getIpaddr());
				saveRawSyslog(syslog);
				syslog.setDomain(domain);
				
				SyslogDeepParser deepParser = m_parserService.getSyslogDeepParser(type);
				if(deepParser!=null){
					deepParser.createProcessRunnable(syslog).run();
				}
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MessageDiscardedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void saveRawSyslog(SyslogEntity syslog){
		m_rawSyslogService.saveRawSyslog(syslog);
	}

	public void processSyslog(RawSyslog rawSyslog,String domain) {
		byte[] contents = rawSyslog.getContents();
		int len = contents.length;
		String txt = new String(contents,0,len);
		String type = getSyslogTypeByKeyWord(txt);
		if(!"unknown".equals(type)){
			processSyslog(rawSyslog,type,domain);
		}else{
			log().warn("该日志没有找到对应处理类型，抛弃");
		}
		
	}
	
	
	public String getSyslogTypeByKeyWord(String syslogTxt){
		//FIXME 此处没有完成
		if(syslogTxt.contains("hillstone")){
			return "hillstone";
		}
		return "unknown";
	}
	
	ThreadCategory log(){
		return ThreadCategory.getInstance(getClass());
	}

}
