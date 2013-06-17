package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

import org.infosec.ismp.snmp.AggregateTracker;
import org.infosec.ismp.snmp.SnmpResult;
import org.infosec.ismp.util.ThreadCategory;


/**
 * @author guoxianwei
 * @date 2010-10-11 上午09:58:44
 * 
 */
public class HrSystem extends AggregateTracker{
    //
    // Lookup strings for specific table entries
    //

    public final static String HR_SYS_UPTIME_ALIAS = "hrSystemUptime";
    private static final String HR_SYS_UPTIME = ".1.3.6.1.2.1.25.1.1";

    public final static String HR_SYS_DATE_ALIAS = "hrSystemDate";
    private static final String HR_SYS_DATE = ".1.3.6.1.2.1.25.1.2";

    public final static String HR_SYS_INIT_LOAD_DEVICE_ALIAS = "hrSystemInitialLoadDevice";
    private static final String HR_SYS_INIT_LOAD_DEVICE = ".1.3.6.1.2.1.25.1.3";

    public final static String HR_SYS_INIT_LOAD_PARAM_ALIAS = "hrSystemInitialLoadParameters";
    private static final String HR_SYS_INIT_LOAD_PARAM = ".1.3.6.1.2.1.25.1.4";

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
        ms_elemList = new NamedSnmpVar[4];
        int ndx = 0;

        /**
         * <P>
         * </P>
         */
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPTIMETICKS, HR_SYS_UPTIME_ALIAS, HR_SYS_UPTIME);

        /**
         * <P>
         * </P>
         */
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING, HR_SYS_DATE_ALIAS, HR_SYS_DATE);

        /**
         * <P>
         * The time since the network management portion of the system was last
         * initialized. This will be in 1/100th of a second increments.
         * </P>
         */
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32, HR_SYS_INIT_LOAD_DEVICE_ALIAS, HR_SYS_INIT_LOAD_DEVICE);

        /**
         * <P>

         * </P>
         */
        ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING, HR_SYS_INIT_LOAD_PARAM_ALIAS, HR_SYS_INIT_LOAD_PARAM);

 
    }
    
    /**
     * <P>
     * The SYSTEM_OID is the object identifier that represents the root of the
     * system information in the MIB forest. Each of the system elements can be
     * retreived by adding their specific index to the string, and an additional
     * Zero(0) to signify the single instance item.
     * </P>
     */
    public static final String SYSTEM_OID = ".1.3.6.1.2.1.25.1";

    private SnmpStore m_store;
    
    private InetAddress m_address;
    
	public HrSystem(InetAddress address) {
		super(NamedSnmpVar.getTrackersFor(ms_elemList));
        m_address = address;
        m_store = new SnmpStore(ms_elemList); 
	}


    public String getHrSysInitLoadParam() {
        return m_store.getDisplayString(HR_SYS_INIT_LOAD_PARAM);
    }

    public int getHrSysInitLoadDevice() {
        return m_store.getInt32(HR_SYS_INIT_LOAD_DEVICE);
    }
    
    public String getHrSysDate(){
    	return m_store.getDisplayString(HR_SYS_DATE);
    }
    
    public long getHrSysupTime(){
    	return m_store.getUInt32(HR_SYS_UPTIME);
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

