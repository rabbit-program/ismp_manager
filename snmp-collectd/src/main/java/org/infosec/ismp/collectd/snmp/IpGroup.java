package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;

/**
 * @author guoxianwei
 * @date 2010-10-12 下午01:27:07
 * 
 */
public class IpGroup extends AggregateTracker {
	
    /**
     * <P>
     * The class constructor is used to initialize the collector and send out
     * the initial SNMP packet requesting data. The data is then received and
     * store by the object. When all the data has been collected the passed
     * signaler object is <EM>notified</em> using the notifyAll() method.
     * </P>
     * @param address TODO
     * 
     */
    public IpGroup(InetAddress address) {
        super(NamedSnmpVar.getTrackersFor(ms_elemList));
        m_address = address;
        m_store = new SnmpStore(ms_elemList); 
    }
    
	public final static String IP_FORWARDING_ALIAS = "ipForwarding";
	public final static String IP_FORWARDING = ".1.3.6.1.2.1.4.1";
	public final static String IP_DEFAULT_TTL_ALIAS = "ipDefaultTTL";
	public final static String IP_DEFAULT_TTL = ".1.3.6.1.2.1.4.2";
	public final static String IP_IN_RECEIVES_ALIAS = "ipInReceives";
	public final static String IP_IN_RECEIVES = ".1.3.6.1.2.1.4.3";
	public final static String IP_IN_HDR_ERRORS_ALIAS = "ipInHdrErrors";
	public final static String IP_IN_HDR_ERRORS = ".1.3.6.1.2.1.4.4";
	public final static String IP_IN_ADDR_ERRORS_ALIAS = "ipInAddrErrors";
	public final static String IP_IN_ADDR_ERRORS = ".1.3.6.1.2.1.4.5";
	public final static String IP_FORW_DATAGRAMS_ALIAS = "ipForwDatagrams ";
	public final static String IP_FORW_DATAGRAMS = ".1.3.6.1.2.1.4.6";
	public final static String IP_IN_UNKNOWN_PROTOS_ALIAS = "ipInUnknownProtos";
	public final static String IP_IN_UNKNOWN_PROTOS = ".1.3.6.1.2.1.4.7";
	public final static String IP_IN_DISCARDS_ALIAS = "ipInDiscards";
	public final static String IP_IN_DISCARDS = ".1.3.6.1.2.1.4.8";
	public final static String IP_IN_DELIVERS_ALIAS = "ipInDelivers";
	public final static String IP_IN_DELIVERS = ".1.3.6.1.2.1.4.9";
	public final static String IP_OUT_REQUESTS_ALIAS = "ipOutRequests";
	public final static String IP_OUT_REQUESTS = ".1.3.6.1.2.1.4.10";
	public final static String IP_OUT_DISCARDS_ALIAS = "ipOutDiscards";
	public final static String IP_OUT_DISCARDS = ".1.3.6.1.2.1.4.11";
	public final static String IP_OUT_NOROUTES_ALIAS = "ipOutNoRoutes";
	public final static String IP_OUT_NOROUTES = ".1.3.6.1.2.1.4.12";
	public final static String IP_REASM_TIMEOUT_ALIAS = "ipReasmTimeout";
	public final static String IP_REASM_TIMEOUT = ".1.3.6.1.2.1.4.13";
	public final static String IP_REASM_REQDS_ALIAS = "ipReasmReqds";
	public final static String IP_REASM_REQDS = ".1.3.6.1.2.1.4.14";
	public final static String IP_REASM_OKS_ALIAS = "ipReasmOKs";
	public final static String IP_REASM_OKS = ".1.3.6.1.2.1.4.15";
	public final static String IP_REASM_FAILS_ALIAS = "ipReasmFails";
	public final static String IP_REASM_FAILS = ".1.3.6.1.2.1.4.16";
	public final static String IP_FRAG_OKS_ALIAS = "ipFragOKs";
	public final static String IP_FRAG_OKS = ".1.3.6.1.2.1.4.17";
	public final static String IP_FRAG_FAILS_ALIAS = "ipFragFails";
	public final static String IP_FRAG_FAILS = ".1.3.6.1.2.1.4.18";
	public final static String IP_FRAG_CREATES_ALIAS = "ipFragCreates";
	public final static String IP_FRAG_CREATES = ".1.3.6.1.2.1.4.19";
	public final static String IP_ROUTING_DISCARDS_ALIAS = "ipRoutingDiscards";
	public final static String IP_ROUTING_DISCARDS = ".1.3.6.1.2.1.4.23";
    /**
     * <P>
     * The keys that will be supported by default from the TreeMap base class.
     * Each of the elements in the list are an instance of the SNMP Interface
     * table. Objects in this list should be used by multiple instances of this
     * class.
     * </P>
     */
    public static NamedSnmpVar[] ms_elemList = null;
    /**
     * <P>
     * Initialize the element list for the class. This is class wide data, but
     * will be used by each instance.
     * </P>
     */
    static {
        // Changed array size from 7 to 6 because we are no longer going after
        // sysServices...sysServices is not currently being used and it causes
        // the entire SystemGroup collection to fail on at least one version
        // of Linux where it does not exist in the SNMP agent.
        //
        ms_elemList = new NamedSnmpVar[20];
        int ndx = 0;

        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32, IP_FORWARDING_ALIAS, IP_FORWARDING);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32, IP_DEFAULT_TTL_ALIAS, IP_DEFAULT_TTL);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_IN_RECEIVES_ALIAS, IP_IN_RECEIVES);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_IN_HDR_ERRORS_ALIAS, IP_IN_HDR_ERRORS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_IN_ADDR_ERRORS_ALIAS, IP_IN_ADDR_ERRORS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_FORW_DATAGRAMS_ALIAS, IP_FORW_DATAGRAMS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_IN_UNKNOWN_PROTOS_ALIAS, IP_IN_UNKNOWN_PROTOS);  
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_IN_DISCARDS_ALIAS, IP_IN_DISCARDS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_IN_DELIVERS_ALIAS, IP_IN_DELIVERS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_OUT_REQUESTS_ALIAS, IP_OUT_REQUESTS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_OUT_DISCARDS_ALIAS, IP_OUT_DISCARDS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_OUT_NOROUTES_ALIAS, IP_OUT_NOROUTES);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32, IP_REASM_TIMEOUT_ALIAS, IP_REASM_TIMEOUT);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_REASM_REQDS_ALIAS, IP_REASM_REQDS);
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_REASM_OKS_ALIAS, IP_REASM_OKS);            
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_REASM_FAILS_ALIAS, IP_REASM_FAILS);            
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_FRAG_OKS_ALIAS, IP_FRAG_OKS);            
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_FRAG_FAILS_ALIAS, IP_FRAG_FAILS);           
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_FRAG_CREATES_ALIAS, IP_FRAG_CREATES);   
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32, IP_ROUTING_DISCARDS_ALIAS, IP_ROUTING_DISCARDS);    

    }
    /**
     * <P>
     * The SYSTEM_OID is the object identifier that represents the root of the
     * system information in the MIB forest. Each of the system elements can be
     * retreived by adding their specific index to the string, and an additional
     * Zero(0) to signify the single instance item.
     * </P>
     */
    public static final String IP_TABLE_OID = ".1.3.6.1.2.1.4";
    
    private SnmpStore m_store;
    
    private InetAddress m_address;
    public int getIpForwarding(){
    	return m_store.getInt32(IP_FORWARDING);
    }
    public int getIpDefaultTtl(){
    	return m_store.getInt32(IP_DEFAULT_TTL);
    }
    public int getIpInReceives(){
    	return m_store.getInt32(IP_IN_RECEIVES);
    }
    public int getIpInHdrErrors(){
    	return m_store.getInt32(IP_IN_HDR_ERRORS);
    }
    public int getIpInAddrErrors(){
    	return m_store.getInt32(IP_IN_ADDR_ERRORS);
    }
    public int getIpInUnknowProtos(){
    	return m_store.getInt32(IP_IN_UNKNOWN_PROTOS);
    }
    public int getIpInDiscards(){
    	return m_store.getInt32(IP_IN_DISCARDS);
    }
    public int getIpInDelivers(){
    	return m_store.getInt32(IP_IN_DELIVERS);
    }
    public int getIpOutRequests(){
    	return m_store.getInt32(IP_OUT_REQUESTS);
    }
    public int getIpOutDiscards(){
    	return m_store.getInt32(IP_OUT_DISCARDS);
    }
    public int getIpOutNoroutes(){
    	return m_store.getInt32(IP_OUT_NOROUTES);
    }
    public int getIpReasmTimeout(){
    	return m_store.getInt32(IP_REASM_TIMEOUT);
    }
    public int getIpReasmReqds(){
    	return m_store.getInt32(IP_REASM_REQDS);
    }
    public int getIpReasmOks(){
    	return m_store.getInt32(IP_REASM_OKS);
    }
    public int getIpReasmFaits(){
    	return m_store.getInt32(IP_REASM_FAILS);
    }
    public int getIpFragOks(){
    	return m_store.getInt32(IP_FRAG_OKS);
    }
    public int getIpFragFaits(){
    	return m_store.getInt32(IP_FRAG_FAILS);
    }
    public int getIpFragCreates(){
    	return m_store.getInt32(IP_FRAG_CREATES);
    }
    public int getIpRoutingDiscards(){
    	return m_store.getInt32(IP_ROUTING_DISCARDS);
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

