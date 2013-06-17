package org.infosec.ismp.manager.syslog;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jms接收器的处理器，负责接收jms server中存储的raw syslog，然后将日志转发给日志管理器
 * 
 * @author lianglin
 * 
 */
@Component
public class RawSyslogReceiver implements MessageListener {
	
	private SyslogManager m_syslogManager;

	@Override
	public void onMessage(Message msg) {
		ObjectMessage message = (ObjectMessage) msg;
		try {
			RawSyslog syslog = (RawSyslog) message.getObject();
			if(log().isDebugEnabled()){
				log().debug("从JMS接收的日志内容是： "+syslog);
			}
			// 将syslog转发给syslog日志管理器
			m_syslogManager.addRawSyslog(syslog);

		} catch (JMSException e) {
			log().warn("从JMS接收日志出现异常", e);
		} catch (Throwable t) {
			log().warn("接收日志出现异常", t);
		}

	}
	
	@Autowired(required=true)
	public void setSyslogManager(SyslogManager syslogManager) {
		m_syslogManager = syslogManager;
	}



	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
