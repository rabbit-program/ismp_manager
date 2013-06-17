package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-10-14 下午02:09:42
 * 
 */
public class EgpGroup extends AggregateTracker {

	public static final String EGP_INMSGS_ALIAS  = "egpInMsgs";
	public static final String EGP_INERRORS_ALIAS  = "egpInErrors";
	public static final String EGP_OUTMSGS_ALIAS  = "egpOutMsgs";
	public static final String EGP_OUTERRORS_ALIAS  = "egpOutErrors";
	public static final String EGP_AS_ALIAS  = "egpAs";

	private static final String EGP_INMSGS = ".1.3.6.1.2.1.8.1";
	private static final String EGP_INERRORS = ".1.3.6.1.2.1.8.2";
	private static final String EGP_OUTMSGS  = ".1.3.6.1.2.1.8.3";
	private static final String EGP_OUTERRORS  = ".1.3.6.1.2.1.8.4";
	private static final String EGP_AS = ".1.3.6.1.2.1.8.6";
	
    public static NamedSnmpVar[] ms_elemList = null;
    
    static {
        // Changed array size from 7 to 6 because we are no longer going after
        // sysServices...sysServices is not currently being used and it causes
        // the entire SystemGroup collection to fail on at least one version
        // of Linux where it does not exist in the SNMP agent.
        //
        ms_elemList = new NamedSnmpVar[5];
        int ndx = 0;

        /**
         * <P>
         * A description of the remote entity. For example this may include
         * hardware, opererating system, and various version information. This
         * should be a US-ASCII display string.
         * </P>
         */
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, EGP_INMSGS_ALIAS, EGP_INMSGS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, EGP_INERRORS_ALIAS, EGP_INERRORS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, EGP_OUTMSGS_ALIAS, EGP_OUTMSGS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, EGP_OUTERRORS_ALIAS, EGP_OUTERRORS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32, EGP_AS_ALIAS, EGP_AS );
    }
    public static final String EGP_OID = ".1.3.6.1.2.1.8";
    
    private SnmpStore m_store;
    
    private InetAddress m_address;
    
    public EgpGroup(InetAddress address) {
        super(NamedSnmpVar.getTrackersFor(ms_elemList));
        m_address = address;
        m_store = new SnmpStore(ms_elemList); 
    }
    public int getGgp_InMsgs() {
		return m_store.getInt32(EGP_INMSGS);
	}

	public int getGgp_InErrors() {
		return m_store.getInt32(EGP_INERRORS);
	}

	public int getGgp_OutMsgs() {
		return m_store.getInt32(EGP_OUTMSGS);
	}

	public int getGgp_OutErrors() {
		return m_store.getInt32(EGP_OUTERRORS);
	}

	public int getGgp_As() {
		return m_store.getInt32(EGP_AS);
	}
    
    protected void storeResult(SnmpResult res) {
        m_store.storeResult(res);
    }

    protected void reportGenErr(String msg) {
        log().warn("Error retrieving systemGroup from "+m_address+". "+msg);
    }

    protected void reportNoSuchNameErr(String msg) {
        log().info("Error retrieving systemGroup from "+m_address+". "+msg);
    }

    private final ThreadCategory log() {
        return ThreadCategory.getInstance(getClass());
    }
}

