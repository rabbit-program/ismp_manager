package org.infosec.ismp.collectd.snmp.weblogic;

import org.infosec.ismp.collectd.snmp.NamedSnmpVar;
import org.infosec.ismp.collectd.snmp.SnmpTableEntry;

/**
 * @author guoxianwei
 * @date 2010-10-27 下午04:43:52
 * 
 */
public class JvmRuntimeEntry extends SnmpTableEntry {
	
	public JvmRuntimeEntry() {
		super(ms_elemList);
	}
	public static final String JVM_RUNTIME_HEAP_FREE_CURRENT_ALIAS  = "jvmRuntimeHeapFreeCurrent";
	public static final String JVM_RUNTIME_HEAP_SIZE_CURRENT_ALIAS  = "jvmRuntimeHeapSizeCurrent";
	public static final String JVM_RUNTIME_JAVA_VERSION_ALIAS = "jvmRuntimeJavaVersion";

	private static final String JVM_RUNTIME_HEAP_FREE_CURRENT  = ".1.3.6.1.4.1.140.625.340.1.25";
	private static final String JVM_RUNTIME_HEAP_SIZE_CURRENT  = ".1.3.6.1.4.1.140.625.340.1.30";
	private static final String JVM_RUNTIME_JAVA_VERSION      = ".1.3.6.1.4.1.140.625.340.1.35";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		ms_elemList = new NamedSnmpVar[3];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER64,JVM_RUNTIME_HEAP_FREE_CURRENT_ALIAS , JVM_RUNTIME_HEAP_FREE_CURRENT , 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER64,JVM_RUNTIME_HEAP_SIZE_CURRENT_ALIAS , JVM_RUNTIME_HEAP_SIZE_CURRENT , 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,JVM_RUNTIME_JAVA_VERSION_ALIAS , JVM_RUNTIME_JAVA_VERSION , 3);

	}
	public static final String TABLE_OID = ".1.3.6.1.4.1.140.625.340.1"; // start
	
	public long getJvmRuntimeHeapFreeCurrent() {
		
		
		return this.getUInt32(JVM_RUNTIME_HEAP_FREE_CURRENT);
	}

	public long getJvmRuntimeHeapSizeCurrent() {
		return getUInt32(JVM_RUNTIME_HEAP_SIZE_CURRENT);
	}

	public String getJvmRuntimeJavaVersion() {
		return getDisplayString(JVM_RUNTIME_JAVA_VERSION);
	}
}

