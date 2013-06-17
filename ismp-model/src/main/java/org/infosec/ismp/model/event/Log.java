package org.infosec.ismp.model.event;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * Event的集合
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 */
public class Log implements Serializable {

	private Header header;

	private Events events;

	public void setEvents(Events events) {
		this.events = events;

	}

	public Events getEvents() {
		return this.events;
	}

	public Header getHeader() {
		return header;
	}

	public void marshal(final Writer out) throws MarshalException,
			ValidationException {
		Marshaller.marshal(this, out);
	}

	public static void main(String[] args) throws Exception {
		Event event = new Event();
		event.setUuid("ppppppppppp");
		event.setUei("test/xdfdf/dfdf");
		Events events = new Events();
		events.addEvent(event);
		Log log = new Log();
		log.setEvents(events);
		StringWriter writer = new StringWriter();
		Marshaller.marshal(log, writer);
		// System.out.println(writer.toString());
		StringReader reader = new StringReader(writer.toString());
		Log log2 = (Log) Unmarshaller.unmarshal(Log.class, reader);
	}

}
