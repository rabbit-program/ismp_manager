package org.infosec.ismp.model.event;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.exolab.castor.xml.Marshaller;

public class Events {

	private final List<Event> eventList = new ArrayList<Event>();

	public void addEvent(Event event) {
		eventList.add(event);

	}

	public int count() {
		return eventList.size();
	}

	public Collection<Event> eventColletion() {
		return new ArrayList<Event>(eventList);
	}

	public Event[] getEvent() {
		return eventList.toArray(new Event[0]);
	}

	public static void main(String[] args) throws Exception {
		Event event = new Event();
		event.setUuid("ppppppppppp");
		event.setUei("test/xdfdf/dfdf");
		Events events = new Events();
		events.addEvent(event);
		StringWriter writer = new StringWriter();
		Marshaller.marshal(events, writer);
		System.out.println(writer.toString());
	}

}
