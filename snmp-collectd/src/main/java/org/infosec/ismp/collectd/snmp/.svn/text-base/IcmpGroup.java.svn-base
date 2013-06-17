package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-10-13 上午09:51:32
 * 
 */
public class IcmpGroup extends AggregateTracker{
	public final static String ICMP_INMSGS_ALIAS = "icmpInMsgs";
	public final static String ICMP_INERRORS_ALIAS = "icmpInErrors";
	public final static String ICMP_IN_DESTUNREACHS_ALIAS = "icmpInDestUnreachs";
	public final static String ICMP_IN_TIMEEXCDS_ALIAS = "icmpInTimeExcds";
	public final static String ICMP_IN_PARMPROBS_ALIAS = "icmpInParmProbs";
	public final static String ICMP_IN_SRCQUENCHS_ALIAS = "icmpInSrcQuenchs";
	public final static String ICMP_IN_REDIRECTS_ALIAS = "icmpInRedirects";
	public final static String ICMP_IN_ECHOS_ALIAS = "icmpInEchos";
	public final static String ICMP_IN_ECHOREPS_ALIAS = "icmpInEchoReps";
	public final static String ICMP_IN_TIMESTAMPS_ALIAS = "icmpInTimestamps";
	public final static String ICMP_IN_TIMESTAMPREPS_ALIAS = "icmpInTimestampReps";
	public final static String ICMP_IN_ADDRMASKS_ALIAS = "icmpInAddrMasks";
	public final static String ICMP_IN_ADDRMASKREPS_ALIAS = "icmpInAddrMaskReps";
	public final static String ICMP_OUT_MSGS_ALIAS = "icmpOutMsgs";
	public final static String ICMP_OUT_ERRORS_ALIAS = "icmpOutErrors";
	public final static String ICMP_OUT_DESTUNREACHS_ALIAS = "icmpOutDestUnreachs";
	public final static String ICMP_OUT_TIMEEXCDS_ALIAS = "icmpOutTimeExcds";
	public final static String ICMP_OUT_PARMPROBS_ALIAS = "icmpOutParmProbs";
	public final static String ICMP_OUT_SRCQUENCHS_ALIAS = "icmpOutSrcQuenchs";
	public final static String ICMP_OUT_REDIRECTS_ALIAS = "icmpOutRedirects";
	public final static String ICMP_OUT_ECHOS_ALIAS = "icmpOutEchos";
	public final static String ICMP_OUT_ECHOREPS_ALIAS = "icmpOutEchoReps";
	public final static String ICMP_OUT_TIMESTAMPS_ALIAS = "icmpOutTimestamps";
	public final static String ICMP_OUT_TIMESTAMPREPS_ALIAS = "icmpOutTimestampReps";
	public final static String ICMP_OUT_ADDRMASKS_ALIAS = "icmpOutAddrMasks";
	public final static String ICMP_OUT_ADDRMASKREPS_ALIAS = "icmpOutAddrMaskReps";

	public final static String ICMP_INMSGS = ".1.3.6.1.2.1.5.1";
	public final static String ICMP_INERRORS = ".1.3.6.1.2.1.5.2";
	public final static String ICMP_IN_DESTUNREACHS = ".1.3.6.1.2.1.5.3";
	public final static String ICMP_IN_TIMEEXCDS = ".1.3.6.1.2.1.5.4";
	public final static String ICMP_IN_PARMPROBS = ".1.3.6.1.2.1.5.5";
	public final static String ICMP_IN_SRCQUENCHS = ".1.3.6.1.2.1.5.6";
	public final static String ICMP_IN_REDIRECTS = ".1.3.6.1.2.1.5.7";
	public final static String ICMP_IN_ECHOS = ".1.3.6.1.2.1.5.8";
	public final static String ICMP_IN_ECHOREPS = ".1.3.6.1.2.1.5.9";
	public final static String ICMP_IN_TIMESTAMPS = ".1.3.6.1.2.1.5.10";
	public final static String ICMP_IN_TIMESTAMPREPS = ".1.3.6.1.2.1.5.11";
	public final static String ICMP_IN_ADDRMASKS = ".1.3.6.1.2.1.5.12";
	public final static String ICMP_IN_ADDRMASKREPS = ".1.3.6.1.2.1.5.13";
	public final static String ICMP_OUT_MSGS = ".1.3.6.1.2.1.5.14";
	public final static String ICMP_OUT_ERRORS = ".1.3.6.1.2.1.5.15";
	public final static String ICMP_OUT_DESTUNREACHS = ".1.3.6.1.2.1.5.16";
	public final static String ICMP_OUT_TIMEEXCDS = ".1.3.6.1.2.1.5.17";
	public final static String ICMP_OUT_PARMPROBS = ".1.3.6.1.2.1.5.18";
	public final static String ICMP_OUT_SRCQUENCHS = ".1.3.6.1.2.1.5.19";
	public final static String ICMP_OUT_REDIRECTS = ".1.3.6.1.2.1.5.20";
	public final static String ICMP_OUT_ECHOS = ".1.3.6.1.2.1.5.21";
	public final static String ICMP_OUT_ECHOREPS = ".1.3.6.1.2.1.5.22";
	public final static String ICMP_OUT_TIMESTAMPS = ".1.3.6.1.2.1.5.23";
	public final static String ICMP_OUT_TIMESTAMPREPS = ".1.3.6.1.2.1.5.24";
	public final static String ICMP_OUT_ADDRMASKS = ".1.3.6.1.2.1.5.25";
	public final static String ICMP_OUT_ADDRMASKREPS = ".1.3.6.1.2.1.5.26";
	
    public static NamedSnmpVar[] ms_elemList = null;
    
    static {
        // Changed array size from 7 to 6 because we are no longer going after
        // sysServices...sysServices is not currently being used and it causes
        // the entire SystemGroup collection to fail on at least one version
        // of Linux where it does not exist in the SNMP agent.
        //
        ms_elemList = new NamedSnmpVar[26];
        int ndx = 0;

        /**
         * <P>
         * A description of the remote entity. For example this may include
         * hardware, opererating system, and various version information. This
         * should be a US-ASCII display string.
         * </P>
         */


        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_INMSGS_ALIAS, ICMP_INMSGS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_INERRORS_ALIAS, ICMP_INERRORS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_DESTUNREACHS_ALIAS, ICMP_IN_DESTUNREACHS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_TIMEEXCDS_ALIAS, ICMP_IN_TIMEEXCDS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_PARMPROBS_ALIAS, ICMP_IN_PARMPROBS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_SRCQUENCHS_ALIAS, ICMP_IN_SRCQUENCHS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_REDIRECTS_ALIAS, ICMP_IN_REDIRECTS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_ECHOS_ALIAS, ICMP_IN_ECHOS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_ECHOREPS_ALIAS, ICMP_IN_ECHOREPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_TIMESTAMPS_ALIAS, ICMP_IN_TIMESTAMPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_TIMESTAMPREPS_ALIAS, ICMP_IN_TIMESTAMPREPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_ADDRMASKS_ALIAS, ICMP_IN_ADDRMASKS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_IN_ADDRMASKREPS_ALIAS, ICMP_IN_ADDRMASKREPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_MSGS_ALIAS, ICMP_OUT_MSGS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_ERRORS_ALIAS, ICMP_OUT_ERRORS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_DESTUNREACHS_ALIAS, ICMP_OUT_DESTUNREACHS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_TIMEEXCDS_ALIAS, ICMP_OUT_TIMEEXCDS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_PARMPROBS_ALIAS, ICMP_OUT_PARMPROBS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_SRCQUENCHS_ALIAS, ICMP_OUT_SRCQUENCHS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_REDIRECTS_ALIAS, ICMP_OUT_REDIRECTS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_ECHOS_ALIAS, ICMP_OUT_ECHOS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_ECHOREPS_ALIAS, ICMP_OUT_ECHOREPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_TIMESTAMPS_ALIAS, ICMP_OUT_TIMESTAMPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_TIMESTAMPREPS_ALIAS, ICMP_OUT_TIMESTAMPREPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_ADDRMASKS_ALIAS, ICMP_OUT_ADDRMASKS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, ICMP_OUT_ADDRMASKREPS_ALIAS, ICMP_OUT_ADDRMASKREPS);
    }
    
    public static final String ICMP_OID = ".1.3.6.1.2.1.5";

    private SnmpStore m_store;
    private InetAddress m_address;
    
    public IcmpGroup(InetAddress address) {
        super(NamedSnmpVar.getTrackersFor(ms_elemList));
        m_address = address;
        m_store = new SnmpStore(ms_elemList); 
    }
    
    public int getIcmpInMsgs() {
		return m_store.getInt32(ICMP_INMSGS);
	}

	public int getIcmpInErrors() {
		return m_store.getInt32(ICMP_INERRORS);
	}

	public int getIcmpInDestUnreachs() {
		return m_store.getInt32(ICMP_IN_DESTUNREACHS);
	}

	public int getIcmpInTimeExcds() {
		return m_store.getInt32(ICMP_IN_TIMEEXCDS);
	}

	public int getIcmpInParmProbs() {
		return m_store.getInt32(ICMP_IN_PARMPROBS);
	}

	public int getIcmpInSrcQuenchs() {
		return m_store.getInt32(ICMP_IN_SRCQUENCHS);
	}

	public int getIcmpInRedirects() {
		return m_store.getInt32(ICMP_IN_REDIRECTS);
	}

	public int getIcmpInEchos() {
		return m_store.getInt32(ICMP_IN_ECHOS);
	}

	public int getIcmpInEchoReps() {
		return m_store.getInt32(ICMP_IN_ECHOREPS);
	}

	public int getIcmpInTimestamps() {
		return m_store.getInt32(ICMP_IN_TIMESTAMPS);
	}

	public int getIcmpInTimestampReps() {
		return m_store.getInt32(ICMP_IN_TIMESTAMPREPS);
	}

	public int getIcmpInAddrMasks() {
		return m_store.getInt32(ICMP_IN_ADDRMASKS);
	}

	public int getIcmpInAddrMaskReps() {
		return m_store.getInt32(ICMP_IN_ADDRMASKREPS);
	}

	public int getIcmpOutMsgs() {
		return m_store.getInt32(ICMP_OUT_MSGS);
	}

	public int getIcmpOutErrors() {
		return m_store.getInt32(ICMP_OUT_ERRORS);
	}

	public int getIcmpOutDestUnreachs() {
		return m_store.getInt32(ICMP_OUT_DESTUNREACHS);
	}

	public int getIcmpOutTimeExcds() {
		return m_store.getInt32(ICMP_OUT_TIMEEXCDS);
	}

	public int getIcmpOutParmProbs() {
		return m_store.getInt32(ICMP_OUT_PARMPROBS);
	}

	public int getIcmpOutSrcQuenchs() {
		return m_store.getInt32(ICMP_OUT_SRCQUENCHS);
	}

	public int getIcmpOutRedirects() {
		return m_store.getInt32(ICMP_OUT_REDIRECTS);
	}

	public int getIcmpOutEchos() {
		return m_store.getInt32(ICMP_OUT_ECHOS);
	}

	public int getIcmpOutEchoReps() {
		return m_store.getInt32(ICMP_OUT_ECHOREPS);
	}

	public int getIcmpOutTimestamps() {
		return m_store.getInt32(ICMP_OUT_TIMESTAMPS);
	}

	public int getIcmpOutTimestampReps() {
		return m_store.getInt32(ICMP_OUT_TIMESTAMPREPS);
	}

	public int getIcmpOutAddrMasks() {
		return m_store.getInt32(ICMP_OUT_ADDRMASKS);
	}

	public int getIcmpOutAddrMaskReps() {
		return m_store.getInt32(ICMP_OUT_ADDRMASKREPS);
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

