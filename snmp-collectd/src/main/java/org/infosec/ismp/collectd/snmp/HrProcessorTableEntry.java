package org.infosec.ismp.collectd.snmp;

public class HrProcessorTableEntry extends SnmpTableEntry {
	public final static String HR_PROCESSOR_INDEX = "hrProcessorIndex";

	public final static String HR_PROCESSOR_LOAD = "hrProcessorLoad";

	public static NamedSnmpVar[] ms_elemList = null;
	
	static{
		ms_elemList = new NamedSnmpVar[1];
		int ndx = 0;

//		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
//				HR_PROCESSOR_INDEX, ".1.3.6.1.2.1.25.2.3.1.1", 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOBJECTID,
				HR_PROCESSOR_LOAD, ".1.3.6.1.2.1.25.3.3.1.2", 2);
	}
	public HrProcessorTableEntry() {
		super(ms_elemList);
	}
	public int getProcessorLoad() {
		return getInt32(HR_PROCESSOR_LOAD);
	}

}
