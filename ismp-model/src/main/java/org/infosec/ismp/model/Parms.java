package org.infosec.ismp.model;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * 参数集合
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class Parms implements Serializable {
	private final List<Parm> paramList = new ArrayList<Parm>();

	public Parms() {
		super();
	}

	public void addParm(Parm param) {
		paramList.add(param);
	}

	public Parm[] getParm() {
		return paramList.toArray(new Parm[0]);
	}
	

	public Collection<Parm> parmCollection() {
		return new ArrayList<Parm>(paramList);
	}
	
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public static void main(String[] args) throws Exception {
		Parm param = new Parm();
		param.setParmName("ddd");
		Value value = new Value();
		value.setContent("dddd");
		param.setValue(value);
		Parms params = new Parms();
		params.addParm(param);

		StringWriter writer = new StringWriter();
		Marshaller.marshal(params, writer);
		System.out.println(writer.toString());
		
		String p = writer.toString();
		
		Parms pp = (Parms)Unmarshaller.unmarshal(Parms.class, new StringReader(p));
		System.out.println("pp is : "+pp);
	}

}
