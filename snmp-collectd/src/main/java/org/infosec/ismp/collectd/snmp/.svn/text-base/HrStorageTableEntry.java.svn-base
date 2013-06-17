package org.infosec.ismp.collectd.snmp;

public class HrStorageTableEntry extends SnmpTableEntry {

	public final static String HR_STORAGE_INDEX = "hrStorageIndex";

	public final static String HR_STORAGE_TYPE = "hrStorageType";

	public final static String HR_STORAGE_DESCR = "hrStorageDescr";
	public final static String HR_STORAGE_ALLOCATION_UNITS = "hrStorageAllocationUnits";
	public final static String HR_STORAGE_SIZE = "hrStorageSize";
	public final static String HR_STORAGE_USED = "hrStorageUsed";

	public final static String HR_STORAGE_FIXEDDISK = ".1.3.6.1.2.1.25.2.1.4";// 硬盘分区
	public final static String HR_STORAGE_COMPACT_DISC = ".1.3.6.1.2.1.25.2.1.7";// COMPACT
																					// DISC
	public final static String HR_STORAGE_RAM = ".1.3.6.1.2.1.25.2.1.2";// Physical
																		// memory
	public final static String HR_STORAGE_VIRTUAL_MEMORY = ".1.3.6.1.2.1.25.2.1.3";// virtual
																					// memory

	public static NamedSnmpVar[] ms_elemList = null;

	/**
	 * <P>
	 * Initialize the element list for the class. This is class wide data, but
	 * will be used by each instance.
	 * </P>
	 */
	static {
		ms_elemList = new NamedSnmpVar[6];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_STORAGE_INDEX, ".1.3.6.1.2.1.25.2.3.1.1", 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOBJECTID,
				HR_STORAGE_TYPE, ".1.3.6.1.2.1.25.2.3.1.2", 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				HR_STORAGE_DESCR, ".1.3.6.1.2.1.25.2.3.1.3", 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_STORAGE_ALLOCATION_UNITS, ".1.3.6.1.2.1.25.2.3.1.4", 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				HR_STORAGE_SIZE, ".1.3.6.1.2.1.25.2.3.1.5", 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				HR_STORAGE_USED, ".1.3.6.1.2.1.25.2.3.1.6", 6);

	}
	/**
	 * <P>
	 * The TABLE_OID is the object identifier that represents the root of the
	 * interface table in the MIB forest.
	 * </P>
	 */
	public static final String TABLE_OID = ".1.3.6.1.2.1.25.2.3.1.1"; // start
																		// of
																		// table
																		// (GETNEXT)

	public HrStorageTableEntry() {
		super(ms_elemList);
	}

	public int getHrStorageIndex(){
		return getInt32(HR_STORAGE_INDEX);
	}
	public String getHrStorageType() {
		return getObjectID(HR_STORAGE_TYPE);
	}

	public String getHrStorageDescr() {
		return getDisplayString(HR_STORAGE_DESCR);
	}

	public boolean isFixedDisk() {
		return HR_STORAGE_FIXEDDISK.equals(getHrStorageType());
	}

	public int getHrStorageAllocationUnits() {
		return getInt32(HR_STORAGE_ALLOCATION_UNITS);
	}

	public int getHrStorageSize() {
		return getInt32(HR_STORAGE_SIZE);
	}

	public int getHrStorageUsed() {
		return getInt32(HR_STORAGE_USED);
	}

	public boolean isPhysicalMemory() {
		return HR_STORAGE_RAM.equals(getHrStorageType());
	}

	public int getPercentUsage() {
		return (int) (getHrStorageUsed() * 100.0 / getHrStorageSize());
	}
	
	public long getTotalUsed(){
		return 1L*getHrStorageUsed()*getHrStorageAllocationUnits();
	}

	public long getTotalCapacity() {
		return 1L * getHrStorageSize() * getHrStorageAllocationUnits();
	}

	public String getDiskPrefix() {
		String descr = getHrStorageDescr();
		int index = descr.indexOf(":");
		if (index != -1)
			return descr.substring(0, index);
		else
			return descr;
	}

}
