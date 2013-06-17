package org.infosec.ismp.collectd.snmp;

/**
 * @author guoxianwei
 * @date 2010-10-11 上午10:48:47
 * 
 */
public class HrSWRunTableEntry extends SnmpTableEntry {

	
	public HrSWRunTableEntry() {
		super(ms_elemList);
	}
	public final static String HR_SW_RUN_INDEX_ALIAS = "hrSWRunIndex";
	
	public final static String HR_SW_RUN_INDEX = ".1.3.6.1.2.1.25.4.2.1.1";
	
	public final static String HR_SW_RUN_NAME_ALIAS = "hrSWRunName";
	
	public final static String HR_SW_RUN_NAME = ".1.3.6.1.2.1.25.4.2.1.2";
	
	public final static String HR_SW_RUN_ID_ALIAS = "hrSWRunID";
	
	public final static String HR_SW_RUN_ID = ".1.3.6.1.2.1.25.4.2.1.3";
	
	public final static String HR_SW_RUN_PATH_ALIAS = "hrSWRunPath";
	
	public final static String HR_SW_RUN_PATH = ".1.3.6.1.2.1.25.4.2.1.4";
	
	public final static String HR_SW_RUN_PARAM_ALIAS = "hrSWRunParameters";
	
	public final static String HR_SW_RUN_PARAM = ".1.3.6.1.2.1.25.4.2.1.5";
	
	public final static String HR_SW_RUN_TYPE_ALIAS = "hrSWRunType";
	
	public final static String HR_SW_RUN_TYPE = ".1.3.6.1.2.1.25.4.2.1.6";

	public final static String HR_SW_RUN_STATUS_ALIAS = "hrSWRunStatus";
	
	public final static String HR_SW_RUN_STATUS = ".1.3.6.1.2.1.25.4.2.1.7";


	public static NamedSnmpVar[] ms_elemList = null;
	
	/**
	 * <P>
	 * Initialize the element list for the class. This is class wide data, but
	 * will be used by each instance.
	 * </P>
	 */
	static {
		ms_elemList = new NamedSnmpVar[7];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_SW_RUN_INDEX_ALIAS, HR_SW_RUN_INDEX, 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				HR_SW_RUN_NAME_ALIAS, HR_SW_RUN_NAME, 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOBJECTID,
				HR_SW_RUN_ID_ALIAS, HR_SW_RUN_ID, 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				HR_SW_RUN_PATH_ALIAS, HR_SW_RUN_PATH, 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				HR_SW_RUN_PARAM_ALIAS, HR_SW_RUN_PARAM, 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_SW_RUN_TYPE_ALIAS, HR_SW_RUN_TYPE, 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_SW_RUN_STATUS_ALIAS, HR_SW_RUN_STATUS, 7);

	}
	
	/**
	 * <P>
	 * The TABLE_OID is the object identifier that represents the root of the
	 * interface table in the MIB forest.
	 * </P>
	 */
	public static final String TABLE_OID = ".1.3.6.1.2.1.25.4.2.1"; // start
																		// of
																		// table
																		// (GETNEXT)
	
	public int getHrSWRunIndex(){
		return getInt32(HR_SW_RUN_INDEX);
	}
	public String getHrSWRunName() {
		return getDisplayString(HR_SW_RUN_NAME);
	}

	public String getHrSWRunId() {
		return getObjectID(HR_SW_RUN_ID);
	}
	public String getHrSWRunPath() {
		return getDisplayString(HR_SW_RUN_PATH);
	}

	public String getHrSWRunParameter() {
		return getDisplayString(HR_SW_RUN_PARAM);
	}

	public int getHrSWRunType() {
		return getInt32(HR_SW_RUN_TYPE);
	}
	public int getHrSWRunStatus() {
		return getInt32(HR_SW_RUN_STATUS);
	}
}

