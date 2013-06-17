package org.infosec.ismp.manager.ping;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.infosec.ismp.manager.model.PingResultEntity;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class pingMessageListener implements MessageListener {

	private final static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private PingResultService m_pingResultService;

	private PingLocator m_pingLocator;

	@Autowired(required = true)
	public void setPingResultService(PingResultService pingResultService) {
		m_pingResultService = pingResultService;
	}

	@Autowired(required = true)
	public void setPingLocator(PingLocator pingLocator) {
		m_pingLocator = pingLocator;
	}

	@Override
	public void onMessage(Message message) {
		MapMessage map = (MapMessage) message;
		try {
			String nodeid = map.getString("nodeid");
			String ipAddr = map.getString("ipAddr");
			Long responseTime = map.getLong("responseTime");
			String pingFlag = map.getString("pingFlag");
			String pingTime = map.getString("pingTime");

			String domain = m_pingLocator.getDomainByNodeid(nodeid);
			if (domain != null) {
				PingResultEntity entity = new PingResultEntity();
				entity.setNodeid(nodeid);
				entity.setIpaddr(ipAddr);
				entity.setResponseTime(responseTime);
				entity.setStatus(pingFlag);
				try {
					Date time = format.parse(pingTime);
					entity.setTime(time);
				} catch (Throwable e) {
					e.printStackTrace();
				}
				m_pingResultService.savePingResult(entity);

				m_pingLocator.setPingResult(nodeid, entity);
			}else{
				log().warn("该ping结果没有找到对应的域，抛弃，该nodeid:"+nodeid);
			}

		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}
	
	ThreadCategory log(){
		return ThreadCategory.getInstance(getClass());
	}

}
