package org.infosec.ismp.collectd.snmp;

/**
 * @author guoxianwei
 * @date 2010-10-18 下午02:26:35
 * 
 */
public class HrDeviceEntry extends SnmpTableEntry {

	public static final String HR_DEVICE_INDEX_ALIAS = "hrDeviceIndex";
	public static final String HR_DEVICE_TYPE_ALIAS = "hrDeviceType";
	public static final String HR_DEVICE_DESCR_ALIAS = "hrDeviceDescr";
	public static final String HR_DEVICE_ID_ALIAS = "hrDeviceID";
	public static final String HR_DEVICE_STATUS_ALIAS = "hrDeviceStatus";
	public static final String HR_DEVICE_ERRORS_ALIAS = "hrDeviceErrors";

	private static final String HR_DEVICE_INDEX  = ".1.3.6.1.2.1.25.3.2.1.1";
	private static final String HR_DEVICE_TYPE   = ".1.3.6.1.2.1.25.3.2.1.2";
	private static final String HR_DEVICE_DESCR  = ".1.3.6.1.2.1.25.3.2.1.3";
	private static final String HR_DEVICE_ID     = ".1.3.6.1.2.1.25.3.2.1.4";
	private static final String HR_DEVICE_STATUS = ".1.3.6.1.2.1.25.3.2.1.5";
	private static final String HR_DEVICE_ERRORS = ".1.3.6.1.2.1.25.3.2.1.6";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static{
		ms_elemList = new NamedSnmpVar[1];
		int ndx = 0;

//		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
//				HR_PROCESSOR_INDEX, ".1.3.6.1.2.1.25.2.3.1.1", 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_DEVICE_INDEX_ALIAS, HR_DEVICE_INDEX, 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOBJECTID,
				HR_DEVICE_TYPE_ALIAS, HR_DEVICE_TYPE, 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				HR_DEVICE_DESCR_ALIAS, HR_DEVICE_DESCR, 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOBJECTID,
				HR_DEVICE_ID_ALIAS, HR_DEVICE_ID, 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_DEVICE_STATUS_ALIAS, HR_DEVICE_STATUS, 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				HR_DEVICE_ERRORS_ALIAS, HR_DEVICE_ERRORS, 6);
	}
	public HrDeviceEntry() {
		super(ms_elemList);
	}
	
	public static final String TABLE_OID = ".1.3.6.1.2.1.25.3.2.1"; 
	
	public int getHrDeviceIndex() {
		return getInt32(HR_DEVICE_INDEX);
	}

	public String getHrDeviceType() {
		return this.getObjectID(HR_DEVICE_TYPE);
	}

	public String getHrDeviceDescr() {
		return getDisplayString(HR_DEVICE_DESCR);
	}

	public String getHrDeviceID() {
		return getObjectID(HR_DEVICE_ID);
	}

	public int getHrDeviceStatus() {
		return getInt32(HR_DEVICE_STATUS);
	}

	public int getHrDeviceErrors() {
		return getInt32(HR_DEVICE_ERRORS);
	}
}

