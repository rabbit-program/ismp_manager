package org.infosec.ismp.collectd.snmp;

import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;

public class SysObjectIdTracker extends ObjIdMonitor {
	/**
     * Object identifier used to retrieve system object id. This is the MIB-II
     * system.sysObjectId value.
     */
    static final String NODE_SYSOBJECTID = ".1.3.6.1.2.1.1.2";
    
    public SysObjectIdTracker() {
        super(SnmpObjId.get(NODE_SYSOBJECTID), SnmpInstId.INST_ZERO);
    }
    
//    boolean isChanged(long savedSysUpTime) {
//        return (savedSysUpTime != -1) && (getLongValue() < savedSysUpTime);
//    }
}
