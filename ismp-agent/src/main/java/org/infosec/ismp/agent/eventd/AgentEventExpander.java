package org.infosec.ismp.agent.eventd;

import java.sql.SQLException;

import org.infosec.ismp.eventd.processor.EventProcessor;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.Header;
import org.springframework.beans.factory.InitializingBean;
/**
 * 所有Agent产生的事件回附加相关的信息。
 * @author lianglin
 *
 */
public class AgentEventExpander implements EventProcessor, InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		//do nothing

	}

	@Override
	public void process(Header eventHeader, Event event) throws SQLException {
		//FIXME: 添加相关agent信息
//		event.setFromAgent(true);

	}

}
