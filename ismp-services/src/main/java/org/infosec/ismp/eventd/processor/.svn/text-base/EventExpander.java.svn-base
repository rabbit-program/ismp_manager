package org.infosec.ismp.eventd.processor;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.Header;
import org.springframework.beans.factory.InitializingBean;

/**
 * 对事件的完整性进行检查，补充应该有的数据。
 * TODO
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public final class EventExpander implements EventProcessor, InitializingBean {

	/**
	 * The default event UEI - if the event lookup into the 'event.conf' fails,
	 * the event is loaded with information from this default UEI
	 */
	private final static String DEFAULT_EVENT_UEI = "uei.opennms.org/default/event";

	public EventExpander() {
	}

	@Override
	public void afterPropertiesSet() {

	}

	@Override
	public void process(Header eventHeader, Event event) {
		// do nothing
	}

}
