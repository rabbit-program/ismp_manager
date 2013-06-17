package org.infosec.ismp.model;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class Parm implements java.io.Serializable {

	/**
	 * parm name
	 */
	private java.lang.String _parmName;

	/**
	 * parm value
	 */
	private Value _value;

	// ----------------/
	// - Constructors -/
	// ----------------/

	public Parm() {
		super();
	}

	// -----------/
	// - Methods -/
	// -----------/

	/**
	 * Returns the value of field 'parmName'. The field 'parmName'
	 * has the following description: parm name
	 * 
	 * @return the value of field 'ParmName'.
	 */
	public java.lang.String getParmName() {
		return this._parmName;
	}

	/**
	 * Returns the value of field 'value'. The field 'value' has
	 * the following description: parm value
	 * 
	 * @return the value of field 'Value'.
	 */
	public Value getValue() {
		return this._value;
	}

	/**
	 * 
	 * 
	 * @param out
	 * @throws org.exolab.castor.xml.MarshalException if object is
	 * null or if any SAXException is thrown during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this
	 * object is an invalid instance according to the schema
	 */
	public void marshal(final java.io.Writer out)
			throws org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {
		Marshaller.marshal(this, out);
	}

	/**
	 * 
	 * 
	 * @param handler
	 * @throws java.io.IOException if an IOException occurs during
	 * marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this
	 * object is an invalid instance according to the schema
	 * @throws org.exolab.castor.xml.MarshalException if object is
	 * null or if any SAXException is thrown during marshaling
	 */
	public void marshal(final org.xml.sax.ContentHandler handler)
			throws java.io.IOException, org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {
		Marshaller.marshal(this, handler);
	}

	/**
	 * Sets the value of field 'parmName'. The field 'parmName' has
	 * the following description: parm name
	 * 
	 * @param parmName the value of field 'parmName'.
	 */
	public void setParmName(final java.lang.String parmName) {
		this._parmName = parmName;
	}

	/**
	 * Sets the value of field 'value'. The field 'value' has the
	 * following description: parm value
	 * 
	 * @param value the value of field 'value'.
	 */
	public void setValue(final Value value) {
		this._value = value;
	}

	/**
	 * Method unmarshal.
	 * 
	 * @param reader
	 * @throws org.exolab.castor.xml.MarshalException if object is
	 * null or if any SAXException is thrown during marshaling
	 * @throws org.exolab.castor.xml.ValidationException if this
	 * object is an invalid instance according to the schema
	 * @return the unmarshaled org.opennms.netmgt.xml.event.Parm
	 */
	public static Parm unmarshal(final java.io.Reader reader)
			throws org.exolab.castor.xml.MarshalException,
			org.exolab.castor.xml.ValidationException {
		return (Parm) Unmarshaller.unmarshal(Parm.class, reader);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	

}
