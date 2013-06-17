package org.infosec.ismp.model.event;

/**
 * The interface to be implemented by all services that wish to receive events
 * from Eventd.
 * 
 */
public interface EventListener {
	/**
	 * Return the id of the listener
	 */
	public String getName();

	/**
	 * Process a sent event.
	 */
	public void onEvent(Event e);
}
