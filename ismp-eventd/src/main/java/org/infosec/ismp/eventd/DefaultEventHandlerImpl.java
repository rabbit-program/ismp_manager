//
package org.infosec.ismp.eventd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.eventd.processor.EventProcessor;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.Events;
import org.infosec.ismp.model.event.Log;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * The EventHandler builds Runnables that essentially do all the work on an
 * incoming event.
 * 
 * Operations done on an incoming event are handled by the List of injected
 * EventProcessors, in the order in which they are given in the list.  If any
 * of them throw an exception, futher processing of that event Log is stopped.
 * 
 * @author <A HREF="mailto:sowmya@opennms.org">Sowmya Nataraj </A>
 * @author <A HREF="http://www.opennms.org">OpenNMS.org </A>
 */
public final class DefaultEventHandlerImpl implements InitializingBean,
		EventHandler {
	private List<EventProcessor> m_eventProcessors;

	public DefaultEventHandlerImpl() {
	}

	/* (non-Javadoc)
	 * @see org.opennms.netmgt.eventd.EventHandler#createRunnable(org.opennms.netmgt.xml.event.Log)
	 */
	@Override
	public EventHandlerRunnable createRunnable(Log eventLog) {
		return new EventHandlerRunnable(eventLog);
	}

	public class EventHandlerRunnable implements Runnable {
		/**
		 * log of events
		 */
		private final Log m_eventLog;

		public EventHandlerRunnable(Log eventLog) {
			Assert.notNull(eventLog, "eventLog argument must not be null");

			m_eventLog = eventLog;
		}

		/**
		 * Process the received events. For each event, use the EventExpander to
		 * look up matching eventconf entry and load info from that match, expand
		 * event parms, add event to database and send event to appropriate
		 * listeners.
		 */
		@Override
		public void run() {
			Events events = m_eventLog.getEvents();
			if (events == null || events.count() <= 0) {
				// no events to process
				return;
			}

			for (Event event : events.eventColletion()) {
				if (log().isDebugEnabled()) {
					// Log the eui, source, and other important aspects
				}

				for (EventProcessor eventProcessor : m_eventProcessors) {
					try {
						eventProcessor.process(m_eventLog.getHeader(), event);
					} catch (SQLException e) {
						log().warn(
								"Unable to process event using processor "
										+ eventProcessor
										+ "; not processing with any later processors.  Exception: "
										+ e, e);
						break;
					} catch (Throwable t) {
						log().warn(
								"Unknown exception processing event with processor "
										+ eventProcessor
										+ "; not processing with any later processors.  Exception: "
										+ t, t);
						break;
					}
				}
			}
		}

	}

	private ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	@Override
	public void afterPropertiesSet() throws IllegalStateException {
		Assert.state(m_eventProcessors != null,
				"property eventPersisters must be set");
	}

	public List<EventProcessor> getEventProcessors() {
		return m_eventProcessors;
	}

	public void addEventProcessor(EventProcessor eventProcessor) {
		if (m_eventProcessors == null) {
			m_eventProcessors = new ArrayList<EventProcessor>();
		}
		m_eventProcessors.add(eventProcessor);
	}

	public void setEventProcessors(List<EventProcessor> eventProcessors) {
		m_eventProcessors = eventProcessors;
	}
}
