package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-10-13 下午06:47:59
 * 
 */
public class UdpGroup  extends AggregateTracker{
	
	public static final String UDP_INDATAGRAMS_ALIAS ="udpInDatagrams";
	public static final String UDP_NOPORTS_ALIAS ="udpNoPorts";
	public static final String UDP_INERRORS_ALIAS ="udpInErrors";
	public static final String UDP_OUTDATAGRAMS_ALIAS ="udpOutDatagrams";

	private static final String UDP_INDATAGRAMS =".1.3.6.1.2.1.7.1";
	private static final String UDP_NOPORTS =".1.3.6.1.2.1.7.2";
	private static final String UDP_INERRORS =".1.3.6.1.2.1.7.3";
	private static final String UDP_OUTDATAGRAMS =".1.3.6.1.2.1.7.4";
	
    public static NamedSnmpVar[] ms_elemList = null;
    
    static {
		// Changed array size from 7 to 6 because we are no longer going after
		// sysServices...sysServices is not currently being used and it causes
		// the entire SystemGroup collection to fail on at least one version
		// of Linux where it does not exist in the SNMP agent.
		//
		ms_elemList = new NamedSnmpVar[4];
		int ndx = 0;

		/**
		 * <P>
		 * A description of the remote entity. For example this may include
		 * hardware, opererating system, and various version information. This
		 * should be a US-ASCII display string.
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				UDP_INDATAGRAMS_ALIAS, UDP_INDATAGRAMS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				UDP_NOPORTS_ALIAS, UDP_NOPORTS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				UDP_INERRORS_ALIAS, UDP_INERRORS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				UDP_OUTDATAGRAMS_ALIAS, UDP_OUTDATAGRAMS);
	}
    
    public static final String UDP_OID = ".1.3.6.1.2.1.7";
    
    private SnmpStore m_store;
    private InetAddress m_address;
    
    public UdpGroup(InetAddress address) {
        super(NamedSnmpVar.getTrackersFor(ms_elemList));
        m_address = address;
        m_store = new SnmpStore(ms_elemList); 
    }
    
    public int getUdpInDatagrams() {
		return m_store.getInt32(UDP_INDATAGRAMS);
	}

	public int getUdpNoPorts() {
		return m_store.getInt32(UDP_NOPORTS);
	}

	public int getUdpInErrors() {
		return m_store.getInt32(UDP_INERRORS);
	}

	public int getUdpOutDatagrams() {
		return m_store.getInt32(UDP_OUTDATAGRAMS);
	} 
    protected void storeResult(SnmpResult res) {
        m_store.storeResult(res);
    }

    protected void reportGenErr(String msg) {
        log().warn("Error retrie ving systemGroup from "+m_address+". "+msg);
    }

    protected void reportNoSuchNameErr(String msg) {
        log().info("Error retrieving systemGroup from "+m_address+". "+msg);
    }

    private final ThreadCategory log() {
        return ThreadCategory.getInstance(getClass());
    }
}

