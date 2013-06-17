package org.infosec.ismp.eventd.processor;

import java.sql.SQLException;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.Header;

/**
 * Event processor interface.  Classes that want to modify or react to
 * events within eventd implement this interface and are dependency
 * injected into the eventProcessors List in EventHandler.
 */
public interface EventProcessor {
	public void process(Header eventHeader, Event event) throws SQLException;
}