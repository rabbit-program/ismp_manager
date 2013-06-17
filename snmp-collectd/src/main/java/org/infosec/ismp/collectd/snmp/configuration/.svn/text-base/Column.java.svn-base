package org.infosec.ismp.collectd.snmp.configuration;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.springframework.util.Assert;

/**
 * @author guoxianwei
 * @date 2010-11-2 上午10:53:22
 * 
 */
public class Column {

	public Column() {
	}

	private String m_name;
	private String m_type;
	private String m_value;
	private String m_comments;

	private static final String SNMPINT32 = "SnmpInt32";

	private static final String SNMPUINT32 = "SnmpUInt32";

	private static final String SNMPCOUNTER32 = "SnmpCounter32";

	private static final String SNMPCOUNTER64 = "SnmpCounter64";

	private static final String SNMPGAUGE32 = "SnmpGauge32";

	private static final String SNMPTIMETICKS = "SnmpTimeTicks";

	private static final String SNMPOCTETSTRING = "SnmpOctetString";

	private static final String SNMPOPAQUE = "SnmpOpaque";

	private static final String SNMPIPADDRESS = "SnmpIPAddress";

	private static final String SNMPOBJECTID = "SnmpObjectId";

	private static final String SNMPV2PARTYCLOCK = "SnmpV2PartyClock";

	private static final String SNMPNOSUCHINSTANCE = "SnmpNoSuchInstance";

	private static final String SNMPNOSUCHOBJECT = "SnmpNoSuchObject";

	private static final String SNMPENDOFMIBVIEW = "SnmpEndOfMibView";
	
	private static final String SNMPHEXSTRING = "SnmpHexString";
	
	private static final String SNMPNULL = "SnmpNull";

	public String getName() {
		return m_name;
	}

	public void setName(String name) {
		this.m_name = name;
	}

	public void setType(String type) {
		this.m_type = type;
	}

	public String getValue() {
		return m_value;
	}

	public void setValue(String value) {
		this.m_value = value;
	}

	public String getComments() {
		return m_comments;
	}

	public void setComments(String comments) {
		this.m_comments = comments;
	}

	public String getType() {
		return m_type;
	}

	public static String valueOf(String type) {
		Assert.notNull(type, "type of column must not be null");
		if (SNMPINT32.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPINT32;
		} else if (SNMPUINT32.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPUINT32;
		} else if (SNMPCOUNTER32.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPCOUNTER32;
		} else if (SNMPCOUNTER64.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPCOUNTER64;
		} else if (SNMPGAUGE32.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPGAUGE32;
		} else if (SNMPTIMETICKS.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPTIMETICKS;
		} else if (SNMPOCTETSTRING.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPOCTETSTRING;
		} else if (SNMPOPAQUE.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPOPAQUE;
		} else if (SNMPIPADDRESS.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPIPADDRESS;
		} else if (SNMPOBJECTID.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPOBJECTID;
		} else if (SNMPV2PARTYCLOCK.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPV2PARTYCLOCK;
		} else if (SNMPNOSUCHINSTANCE.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPNOSUCHINSTANCE;
		} else if (SNMPNOSUCHOBJECT.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPNOSUCHOBJECT;
		} else if (SNMPENDOFMIBVIEW.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPENDOFMIBVIEW;
		} else if (SNMPNULL.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPNULL;
		} else if (SNMPHEXSTRING.equalsIgnoreCase(type)) {
			return NamedSnmpVar.SNMPHEXSTRING;
		} else {
			throw new RuntimeException("type is not support!");
		}

	}
	
	public Column clone(){
		return (Column)this.clone();
	}

}

