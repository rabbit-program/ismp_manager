package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-10-13 下午03:14:47
 * 
 */
public class TcpGroup extends AggregateTracker{

	public static final String TCP_RTOALGORITHM_ALIAS = "tcpRtoAlgorithm";
	public static final String TCP_RTOMIN_ALIAS = "tcpRtoMin";
	public static final String TCP_RTOMAX_ALIAS = "tcpRtoMax";
	public static final String TCP_MAXCONN_ALIAS = "tcpMaxConn";
	public static final String TCP_ACTIVEOPENS_ALIAS = "tcpActiveOpens";
	public static final String TCP_PASSIVEOPENS_ALIAS = "tcpPassiveOpens";
	public static final String TCP_ATTEMPTFAILS_ALIAS = "tcpAttemptFails";
	public static final String TCP_ESTABRESETS_ALIAS = "tcpEstabResets";
	public static final String TCP_CURRESTAB_ALIAS = "tcpCurrEstab";
	public static final String TCP_INSEGS_ALIAS = "tcpInSegs";
	public static final String TCP_OUTSEGS_ALIAS = "tcpOutSegs";
	public static final String TCP_RETRANSSEGS_ALIAS = "tcpRetransSegs";
	public static final String TCP_INERRS_ALIAS = "tcpInErrs";
	public static final String TCP_OUTRSTS_ALIAS = "tcpOutRsts";

	public static final String TCP_RTOALGORITHM = ".1.3.6.1.2.1.6.1";
	public static final String TCP_RTOMIN = ".1.3.6.1.2.1.6.2";
	public static final String TCP_RTOMAX = ".1.3.6.1.2.1.6.3";
	public static final String TCP_MAXCONN = ".1.3.6.1.2.1.6.4";
	public static final String TCP_ACTIVEOPENS = ".1.3.6.1.2.1.6.5";
	public static final String TCP_PASSIVEOPENS = ".1.3.6.1.2.1.6.6";
	public static final String TCP_ATTEMPTFAILS = ".1.3.6.1.2.1.6.7";
	public static final String TCP_ESTABRESETS = ".1.3.6.1.2.1.6.8";
	public static final String TCP_CURRESTAB = ".1.3.6.1.2.1.6.9";
	public static final String TCP_INSEGS = ".1.3.6.1.2.1.6.10";
	public static final String TCP_OUTSEGS = ".1.3.6.1.2.1.6.11";
	public static final String TCP_RETRANSSEGS = ".1.3.6.1.2.1.6.12";
	public static final String TCP_INERRS = ".1.3.6.1.2.1.6.14";
	public static final String TCP_OUTRSTS = ".1.3.6.1.2.1.6.15";
	
    public static NamedSnmpVar[] ms_elemList = null;
    
    static {
		// Changed array size from 7 to 6 because we are no longer going after
		// sysServices...sysServices is not currently being used and it causes
		// the entire SystemGroup collection to fail on at least one version
		// of Linux where it does not exist in the SNMP agent.
		//
		ms_elemList = new NamedSnmpVar[14];
		int ndx = 0;

		/**
		 * <P>
		 * A description of the remote entity. For example this may include
		 * hardware, opererating system, and various version information. This
		 * should be a US-ASCII display string.
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				TCP_RTOALGORITHM_ALIAS, TCP_RTOALGORITHM);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				TCP_RTOMIN_ALIAS, TCP_RTOMIN);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				TCP_RTOMAX_ALIAS, TCP_RTOMAX);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				TCP_MAXCONN_ALIAS, TCP_MAXCONN);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_ACTIVEOPENS_ALIAS, TCP_ACTIVEOPENS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_PASSIVEOPENS_ALIAS, TCP_PASSIVEOPENS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_ATTEMPTFAILS_ALIAS, TCP_ATTEMPTFAILS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_ESTABRESETS_ALIAS, TCP_ESTABRESETS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_CURRESTAB_ALIAS, TCP_CURRESTAB);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_INSEGS_ALIAS, TCP_INSEGS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_OUTSEGS_ALIAS, TCP_OUTSEGS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_RETRANSSEGS_ALIAS, TCP_RETRANSSEGS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_INERRS_ALIAS, TCP_INERRS);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				TCP_OUTRSTS_ALIAS, TCP_OUTRSTS);

	}
    public static final String ICMP_OID = ".1.3.6.1.2.1.6";
    
    private SnmpStore m_store;
    private InetAddress m_address;
    
    public TcpGroup(InetAddress address) {
        super(NamedSnmpVar.getTrackersFor(ms_elemList));
        m_address = address;
        m_store = new SnmpStore(ms_elemList); 
    }
    public int getTcpRtoAlgorithm() {
		return m_store.getInt32(TCP_RTOALGORITHM);
	}

	public int getTcpRtoMin() {
		return m_store.getInt32(TCP_RTOMIN);
	}

	public int getTcpRtoMax() {
		return m_store.getInt32(TCP_RTOMAX);
	}

	public int getTcpMaxConn() {
		return m_store.getInt32(TCP_MAXCONN);
	}

	public int getTcpActiveOpens() {
		return m_store.getInt32(TCP_ACTIVEOPENS);
	}

	public int getTcpPassiveOpens() {
		return m_store.getInt32(TCP_PASSIVEOPENS);
	}

	public int getTcpAttemptFails() {
		return m_store.getInt32(TCP_ATTEMPTFAILS);
	}

	public int getTcpEstabResets() {
		return m_store.getInt32(TCP_ESTABRESETS);
	}

	public int getTcpCurrEstab() {
		return m_store.getInt32(TCP_CURRESTAB);
	}

	public int getTcpInSegs() {
		return m_store.getInt32(TCP_INSEGS);
	}

	public int getTcpOutSegs() {
		return m_store.getInt32(TCP_OUTSEGS);
	}

	public int getTcpRetransSegs() {
		return m_store.getInt32(TCP_RETRANSSEGS);
	}

	public int getTcpInErrs() {
		return m_store.getInt32(TCP_INERRS);
	}

	public int getTcpOutRsts() {
		return m_store.getInt32(TCP_OUTRSTS);
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

