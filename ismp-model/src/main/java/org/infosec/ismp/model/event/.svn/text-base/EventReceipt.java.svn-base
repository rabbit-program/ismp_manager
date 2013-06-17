package org.infosec.ismp.model.event;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

public class EventReceipt {

	private final List<String> uuidList = new ArrayList<String>();

	public void addUuid(String uuid) {
		uuidList.add(uuid);
	}

	public String getUuid(final int index) {
		return uuidList.get(index);
	}

	public String[] getUuid() {
		return uuidList.toArray(new String[0]);
	}

	public static void main(String[] args) throws Exception {
		EventReceipt receipt = new EventReceipt();
		receipt.addUuid("test1");
		receipt.addUuid("test2");
		receipt.addUuid("test3");
		StringWriter writer = new StringWriter();
		Marshaller.marshal(receipt, writer);
		System.out.println(writer.toString());

		String xml = writer.toString();

		StringReader reader = new StringReader(xml);

		EventReceipt re = (EventReceipt) Unmarshaller.unmarshal(
				EventReceipt.class, reader);
		System.out.println(ArrayUtils.toString(re.getUuid()));

	}
}
