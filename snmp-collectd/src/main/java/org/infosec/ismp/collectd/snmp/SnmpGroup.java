package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-10-14 上午10:34:38
 * 
 */
public final class SnmpGroup extends AggregateTracker {


	public static final String SNMP_INPKTS_ALIAS ="snmpInPkts";
	public static final String SNMP_OUTPKTS_ALIAS ="snmpOutPkts";
	public static final String SNMP_INBADVERSIONS_ALIAS ="snmpInBadVersions";
	public static final String SNMP_INBADCOMMUNITYNAMES_ALIAS ="snmpInBadCommunityNames";
	public static final String SNMP_INBADCOMMUNITYUSES_ALIAS ="snmpInBadCommunityUses";
	public static final String SNMP_INASNPARSEERRS_ALIAS ="snmpInASNParseErrs";
	public static final String SNMP_INTOOBIGS_ALIAS ="snmpInTooBigs";
	public static final String SNMP_INNOSUCHNAMES_ALIAS ="snmpInNoSuchNames";
	public static final String SNMP_INBADVALUES_ALIAS ="snmpInBadValues";
	public static final String SNMP_INREADONLYS_ALIAS ="snmpInReadOnlys";
	public static final String SNMP_INGENERRS_ALIAS ="snmpInGenErrs";
	public static final String SNMP_INTOTALREQVARS_ALIAS ="snmpInTotalReqVars";
	public static final String SNMP_INTOTALSETVARS_ALIAS ="snmpInTotalSetVars";
	public static final String SNMP_INGETREQUESTS_ALIAS ="snmpInGetRequests";
	public static final String SNMP_INGETNEXTS_ALIAS ="snmpInGetNexts";
	public static final String SNMP_INSETREQUESTS_ALIAS ="snmpInSetRequests";
	public static final String SNMP_INGETRESPONSES_ALIAS ="snmpInGetResponses";
	public static final String SNMP_INTRAPS_ALIAS ="snmpInTraps";
	public static final String SNMP_OUTTOOBIGS_ALIAS ="snmpOutTooBigs";
	public static final String SNMP_OUTNOSUCHNAMES_ALIAS ="snmpOutNoSuchNames";
	public static final String SNMP_OUTBADVALUES_ALIAS ="snmpOutBadValues";
	public static final String SNMP_OUTGENERRS_ALIAS ="snmpOutGenErrs";
	public static final String SNMP_OUTGETREQUESTS_ALIAS ="snmpOutGetRequests";
	public static final String SNMP_OUTGETNEXTS_ALIAS ="snmpOutGetNexts";
	public static final String SNMP_OUTSETREQUESTS_ALIAS ="snmpOutSetRequests";
	public static final String SNMP_OUTGETRESPONSES_ALIAS ="snmpOutGetResponses";
	public static final String SNMP_OUTTRAPS_ALIAS ="snmpOutTraps";
	public static final String SNMP_ENABLEAUTHENTRAPS_ALIAS ="snmpEnableAuthenTraps";
	
	private static final String SNMP_INPKTS =".1.3.6.1.2.1.11.1";
	private static final String SNMP_OUTPKTS =".1.3.6.1.2.1.11.2";
	private static final String SNMP_INBADVERSIONS =".1.3.6.1.2.1.11.3";
	private static final String SNMP_INBADCOMMUNITYNAMES =".1.3.6.1.2.1.11.4";
	private static final String SNMP_INBADCOMMUNITYUSES =".1.3.6.1.2.1.11.5";
	private static final String SNMP_INASNPARSEERRS=".1.3.6.1.2.1.11.6";
	private static final String SNMP_INTOOBIGS =".1.3.6.1.2.1.11.8";
	private static final String SNMP_INNOSUCHNAMES =".1.3.6.1.2.1.11.9";
	private static final String SNMP_INBADVALUES=".1.3.6.1.2.1.11.10";
	private static final String SNMP_INREADONLYS=".1.3.6.1.2.1.11.11";
	private static final String SNMP_INGENERRS =".1.3.6.1.2.1.11.12";
	private static final String SNMP_INTOTALREQVARS=".1.3.6.1.2.1.11.13";
	private static final String SNMP_INTOTALSETVARS=".1.3.6.1.2.1.11.14";
	private static final String SNMP_INGETREQUESTS =".1.3.6.1.2.1.11.15";
	private static final String SNMP_INGETNEXTS =".1.3.6.1.2.1.11.16";
	private static final String SNMP_INSETREQUESTS =".1.3.6.1.2.1.11.17";
	private static final String SNMP_INGETRESPONSES=".1.3.6.1.2.1.11.18";
	private static final String SNMP_INTRAPS =".1.3.6.1.2.1.11.19";
	private static final String SNMP_OUTTOOBIGS =".1.3.6.1.2.1.11.20";
	private static final String SNMP_OUTNOSUCHNAMES=".1.3.6.1.2.1.11.21";
	private static final String SNMP_OUTBADVALUES =".1.3.6.1.2.1.11.22";
	private static final String SNMP_OUTGENERRS =".1.3.6.1.2.1.11.24";
	private static final String SNMP_OUTGETREQUESTS=".1.3.6.1.2.1.11.25";
	private static final String SNMP_OUTGETNEXTS=".1.3.6.1.2.1.11.26";
	private static final String SNMP_OUTSETREQUESTS=".1.3.6.1.2.1.11.27";
	private static final String SNMP_OUTGETRESPONSES =".1.3.6.1.2.1.11.28";
	private static final String SNMP_OUTTRAPS=".1.3.6.1.2.1.11.29";
	private static final String SNMP_ENABLEAUTHENTRAPS=".1.3.6.1.2.1.11.30";
	
    public static NamedSnmpVar[] ms_elemList = null;
    
    static {
        // Changed array size from 7 to 6 because we are no longer going after
        // sysServices...sysServices is not currently being used and it causes
        // the entire SystemGroup collection to fail on at least one version
        // of Linux where it does not exist in the SNMP agent.
        //
        ms_elemList = new NamedSnmpVar[28];
        int ndx = 0;

        /**
         * <P>
         * A description of the remote entity. For example this may include
         * hardware, opererating system, and various version information. This
         * should be a US-ASCII display string.
         * </P>
         */
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INPKTS_ALIAS, SNMP_INPKTS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTPKTS_ALIAS, SNMP_OUTPKTS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INBADVERSIONS_ALIAS, SNMP_INBADVERSIONS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INBADCOMMUNITYNAMES_ALIAS, SNMP_INBADCOMMUNITYNAMES);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INBADCOMMUNITYUSES_ALIAS, SNMP_INBADCOMMUNITYUSES );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INASNPARSEERRS_ALIAS, SNMP_INASNPARSEERRS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INTOOBIGS_ALIAS, SNMP_INTOOBIGS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INNOSUCHNAMES_ALIAS, SNMP_INNOSUCHNAMES);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INBADVALUES_ALIAS, SNMP_INBADVALUES );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INREADONLYS_ALIAS, SNMP_INREADONLYS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INGENERRS_ALIAS, SNMP_INGENERRS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INTOTALREQVARS_ALIAS, SNMP_INTOTALREQVARS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INTOTALSETVARS_ALIAS, SNMP_INTOTALSETVARS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INGETREQUESTS_ALIAS, SNMP_INGETREQUESTS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INGETNEXTS_ALIAS, SNMP_INGETNEXTS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INSETREQUESTS_ALIAS, SNMP_INSETREQUESTS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INGETRESPONSES_ALIAS, SNMP_INGETRESPONSES );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_INTRAPS_ALIAS, SNMP_INTRAPS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTTOOBIGS_ALIAS, SNMP_OUTTOOBIGS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTNOSUCHNAMES_ALIAS, SNMP_OUTNOSUCHNAMES );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTBADVALUES_ALIAS, SNMP_OUTBADVALUES );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTGENERRS_ALIAS, SNMP_OUTGENERRS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTGETREQUESTS_ALIAS, SNMP_OUTGETREQUESTS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTGETNEXTS_ALIAS, SNMP_OUTGETNEXTS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTSETREQUESTS_ALIAS, SNMP_OUTSETREQUESTS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTGETRESPONSES_ALIAS, SNMP_OUTGETRESPONSES );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, SNMP_OUTTRAPS_ALIAS, SNMP_OUTTRAPS );
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32, SNMP_ENABLEAUTHENTRAPS_ALIAS, SNMP_ENABLEAUTHENTRAPS );
    }
    public static final String SNMP_OID = ".1.3.6.1.2.1.11";
    
    private SnmpStore m_store;
    
    private InetAddress m_address;
    
    public SnmpGroup(InetAddress address) {
        super(NamedSnmpVar.getTrackersFor(ms_elemList));
        m_address = address;
        m_store = new SnmpStore(ms_elemList); 
    }
    public int getSnmpInPkts() {
		return m_store.getInt32(SNMP_INPKTS);
	}

	public int getSnmpOutPkts() {
		return m_store.getInt32(SNMP_OUTPKTS);
	}

	public int getSnmpInBadVersions() {
		return m_store.getInt32(SNMP_INBADVERSIONS);
	}

	public int getSnmpInBadCommunityNames() {
		return m_store.getInt32(SNMP_INBADCOMMUNITYNAMES);
	}

	public int getSnmpInBadCommunityUses() {
		return m_store.getInt32(SNMP_INBADCOMMUNITYUSES);
	}

	public int getSnmpInASNParseErrs() {
		return m_store.getInt32(SNMP_INASNPARSEERRS);
	}

	public int getSnmpInTooBigs() {
		return m_store.getInt32(SNMP_INTOOBIGS);
	}

	public int getSnmpInNoSuchNames() {
		return m_store.getInt32(SNMP_INNOSUCHNAMES);
	}

	public int getSnmpInBadValues() {
		return m_store.getInt32(SNMP_INBADVALUES);
	}

	public int getSnmpInReadOnlys() {
		return m_store.getInt32(SNMP_INREADONLYS);
	}

	public int getSnmpInGenErrs() {
		return m_store.getInt32(SNMP_INGENERRS);
	}

	public int getSnmpInTotalReqVars() {
		return m_store.getInt32(SNMP_INTOTALREQVARS);
	}

	public int getSnmpInTotalSetVars() {
		return m_store.getInt32(SNMP_INTOTALSETVARS);
	}

	public int getSnmpInGetRequests() {
		return m_store.getInt32(SNMP_INGETREQUESTS);
	}

	public int getSnmpInGetNexts() {
		return m_store.getInt32(SNMP_INGETNEXTS);
	}

	public int getSnmpInSetRequests() {
		return m_store.getInt32(SNMP_INSETREQUESTS);
	}

	public int getSnmpInGetResponses() {
		return m_store.getInt32(SNMP_INGETRESPONSES);
	}

	public int getSnmpInTraps() {
		return m_store.getInt32(SNMP_INTRAPS);
	}

	public int getSnmpOutTooBigs() {
		return m_store.getInt32(SNMP_OUTTOOBIGS);
	}

	public int getSnmpOutNoSuchNames() {
		return m_store.getInt32(SNMP_OUTNOSUCHNAMES);
	}

	public int getSnmpOutBadValues() {
		return m_store.getInt32(SNMP_OUTBADVALUES);
	}

	public int getSnmpOutGenErrs() {
		return m_store.getInt32(SNMP_OUTGENERRS);
	}

	public int getSnmpOutGetRequests() {
		return m_store.getInt32(SNMP_OUTGETREQUESTS);
	}

	public int getSnmpOutGetNexts() {
		return m_store.getInt32(SNMP_OUTGETNEXTS);
	}

	public int getSnmpOutSetRequests() {
		return m_store.getInt32(SNMP_OUTSETREQUESTS);
	}

	public int getSnmpOutGetResponses() {
		return m_store.getInt32(SNMP_OUTGETRESPONSES);
	}

	public int getSnmpOutTraps() {
		return m_store.getInt32(SNMP_OUTTRAPS);
	}

	public int getSnmpEnableAuthenTraps() {
		return m_store.getInt32(SNMP_ENABLEAUTHENTRAPS);
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

