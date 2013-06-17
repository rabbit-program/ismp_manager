package org.infosec.ismp.eventd.adaptors.jms;

import java.io.StringReader;

import javax.jms.Destination;
import javax.jms.Message;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.model.event.Log;

public class JmsReceivedEvent {
	private String m_eventXml;

	private Log m_log;

	private Destination m_destination;

	static JmsReceivedEvent make(Message msg) {
		JmsReceivedEvent event = new JmsReceivedEvent();

		//TODO

		return event;
	}

	public Destination getDestination() {
		return m_destination;
	}

	public void setDestination(Destination destination) {
		m_destination = destination;
	}

	/**
	 * Returns the raw XML data as a string.
	 */
	String getXmlData() {
		return m_eventXml;
	}

	/**
	 * Decodes the XML package from the remote agent. If an error occurs or the
	 * datagram had malformed XML then an exception is generated.
	 * 
	 * @return The toplevel <code>Log</code> element of the XML document.
	 * 
	 * @throws org.exolab.castor.xml.ValidationException
	 *             Throws if the documents data does not match the defined XML
	 *             Schema Definition.
	 * @throws org.exolab.castor.xml.MarshalException
	 *             Thrown if the XML is malformed and cannot be converted.
	 */
	@SuppressWarnings("deprecation")
	Log unmarshal() throws MarshalException, ValidationException {

		if (m_log == null) {
			StringReader rdr = new StringReader(m_eventXml);
			m_log = (Log) Unmarshaller.unmarshal(Log.class, rdr);
		}
		return m_log;
	}
}
