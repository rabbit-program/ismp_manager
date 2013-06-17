package org.infosec.ismp.collectd.snmp;

import org.infosec.ismp.snmp.SingleInstanceTracker;
import org.infosec.ismp.snmp.SnmpInstId;
import org.infosec.ismp.snmp.SnmpObjId;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.snmp.SnmpValue;

public class ObjIdMonitor extends SingleInstanceTracker {
    SnmpValue value;

    public ObjIdMonitor(SnmpObjId base, SnmpInstId inst) {
        super(base, inst);
        value = null;
    }
    
    public SnmpValue getValue() {
        return value;
    }
    
    int getIntValue() {
        return (value == null ? -1 : value.toInt());
    }
    
    long getLongValue() {
        return (value == null ? -1L : value.toLong());
    }

    @Override
    protected void storeResult(SnmpResult res) {
        value = res.getValue();
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append(getClass().getName());
        buffer.append("@");
        buffer.append(Integer.toHexString(hashCode()));
        buffer.append(": value: " + getValue());
        
        return buffer.toString();
    }

}
