package org.infosec.ismp.collectd.snmp;

/**
 * @author guoxianwei
 * @date 2010-10-12 下午02:43:10
 * 
 */
public final class IpRouteEntry extends SnmpTableEntry {

	public IpRouteEntry() {
		super(ms_elemList);
	}
	public final static String IP_ROUTE_DEST_ALIAS = "ipRouteDest";
	public final static String IP_ROUTE_IFINDEX_ALIAS = "ipRouteIfIndex";
	public final static String IP_ROUTE_METRIC1_ALIAS = "ipRouteMetric1";
	public final static String IP_ROUTE_METRIC2_ALIAS = "ipRouteMetric2";
	public final static String IP_ROUTE_METRIC3_ALIAS = "ipRouteMetric3";
	public final static String IP_ROUTE_METRIC4_ALIAS = "ipRouteMetric4";
	public final static String IP_ROUTE_NEXTHOP_ALIAS = "ipRouteNextHop";
	public final static String IP_ROUTE_TYPE_ALIAS = "ipRouteType";
	public final static String IP_ROUTE_PROTO_ALIAS = "ipRouteProto";
	public final static String IP_ROUTE_AGE_ALIAS = "ipRouteAge";
	public final static String IP_ROUTE_MASK_ALIAS = "ipRouteMask";
	public final static String IP_ROUTE_METRIC5_ALIAS = "ipRouteMetric5";
	public final static String IP_ROUTE_INFO_ALIAS = "ipRouteInfo";

	public final static String IP_ROUTE_DEST = ".1.3.6.1.2.1.4.21.1.1";
	public final static String IP_ROUTE_IFINDEX = ".1.3.6.1.2.1.4.21.1.2";
	public final static String IP_ROUTE_METRIC1 = ".1.3.6.1.2.1.4.21.1.3";
	public final static String IP_ROUTE_METRIC2 = ".1.3.6.1.2.1.4.21.1.4";
	public final static String IP_ROUTE_METRIC3 = ".1.3.6.1.2.1.4.21.1.5";
	public final static String IP_ROUTE_METRIC4 = ".1.3.6.1.2.1.4.21.1.6";
	public final static String IP_ROUTE_NEXTHOP = ".1.3.6.1.2.1.4.21.1.7";
	public final static String IP_ROUTE_TYPE = ".1.3.6.1.2.1.4.21.1.8";
	public final static String IP_ROUTE_PROTO = ".1.3.6.1.2.1.4.21.1.9";
	public final static String IP_ROUTE_AGE = ".1.3.6.1.2.1.4.21.1.10";
	public final static String IP_ROUTE_MASK = ".1.3.6.1.2.1.4.21.1.11";
	public final static String IP_ROUTE_METRIC5 = ".1.3.6.1.2.1.4.21.1.12";
	public final static String IP_ROUTE_INFO = ".1.3.6.1.2.1.4.21.1.13";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	/**
	 * <P>
	 * Initialize the element list for the class. This is class wide data, but
	 * will be used by each instance.
	 * </P>
	 */
	static {
		ms_elemList = new NamedSnmpVar[13];
		int ndx = 0;

		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				IP_ROUTE_DEST_ALIAS, IP_ROUTE_DEST, 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				IP_ROUTE_IFINDEX_ALIAS, IP_ROUTE_IFINDEX, 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				IP_ROUTE_METRIC1_ALIAS, IP_ROUTE_METRIC1, 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				IP_ROUTE_METRIC2_ALIAS, IP_ROUTE_METRIC2, 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				IP_ROUTE_METRIC3_ALIAS, IP_ROUTE_METRIC3, 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				IP_ROUTE_METRIC4_ALIAS, IP_ROUTE_METRIC4, 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				IP_ROUTE_NEXTHOP_ALIAS, IP_ROUTE_NEXTHOP, 7);
		
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				IP_ROUTE_TYPE_ALIAS, IP_ROUTE_TYPE, 8);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,
				IP_ROUTE_PROTO_ALIAS, IP_ROUTE_PROTO, 9);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				IP_ROUTE_AGE_ALIAS, IP_ROUTE_AGE, 10);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOCTETSTRING,
				IP_ROUTE_MASK_ALIAS, IP_ROUTE_MASK, 11);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,
				IP_ROUTE_METRIC5_ALIAS, IP_ROUTE_METRIC5, 12);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPOBJECTID,
				IP_ROUTE_INFO_ALIAS, IP_ROUTE_INFO, 13);

	}
	
	
	/**
	 * <P>
	 * The TABLE_OID is the object identifier that represents the root of the
	 * interface table in the MIB forest.
	 * </P>
	 */
	public static final String TABLE_OID = ".1.3.6.1.2.1.4.21.1"; // start
																		// of
																		// table
																		// (GETNEXT)
	public String getIpRouteDest(){
		return getDisplayString(IP_ROUTE_DEST);
	}
	public int getIpRouteIfIndex() {
		return getInt32(IP_ROUTE_IFINDEX);
	}
	public int getIpRouteMeric1(){
		return getInt32(IP_ROUTE_METRIC1);
	}
	public int getIpRouteMeric2(){
		return getInt32(IP_ROUTE_METRIC2);
	}
	public int getIpRouteMetric3(){
		return getInt32(IP_ROUTE_METRIC3);
	}
	public int getIpRouteMetric4(){
		return getInt32(IP_ROUTE_METRIC4);
	}
	public String getIpRouteNextHop(){
		return getDisplayString(IP_ROUTE_NEXTHOP);
	}
	public int getIpRouteType(){
		return getInt32(IP_ROUTE_TYPE);
	}
	public int getIpRouteProto(){
		return getInt32(IP_ROUTE_PROTO);
	}
	public int getIpRouteAge(){
		return getInt32(IP_ROUTE_AGE);
	}
	public String getIpRouteMask(){
		return getDisplayString(IP_ROUTE_MASK);
	}
	public int getIpRouteMetric5(){
		return getInt32(IP_ROUTE_METRIC5);
	}
	public String getIpRouteInfo(){
		return this.getObjectID(IP_ROUTE_INFO);
	}
	
}

