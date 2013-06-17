package org.infosec.ismp.collectd.snmp;

import java.net.InetAddress;

/**
 * @author guoxianwei
 * @date 2010-10-14 下午02:19:52
 * 
 */
public class EgpNeighEntry extends SnmpTableEntry{
	
	public EgpNeighEntry() {
		super(ms_elemList);
	}
	public static final String EGP_NEIGH_STATE_ALIAS  =  "egpNeighState";
	public static final String EGP_NEIGH_ADDR_ALIAS  =  "egpNeighAddr";
	public static final String EGP_NEIGH_AS_ALIAS  =  "egpNeighAs";
	public static final String EGP_NEIGH_INMSGS_ALIAS  =  "egpNeighInMsgs";
	public static final String EGP_NEIGH_INERRS_ALIAS  =  "egpNeighInErrs";
	public static final String EGP_NEIGH_OUTMSGS_ALIAS  =  "egpNeighOutMsgs";
	public static final String EGP_NEIGH_OUTERRS_ALIAS  =  "egpNeighOutErrs";
	public static final String EGP_NEIGH_INERRMSGS_ALIAS  =  "egpNeighInErrMsgs";
	public static final String EGP_NEIGH_OUTERRMSGS_ALIAS  =  "egpNeighOutErrMsgs";
	public static final String EGP_NEIGH_STATEUPS_ALIAS  =  "egpNeighStateUps";
	public static final String EGP_NEIGH_STATEDOWNS_ALIAS  =  "egpNeighStateDowns";
	public static final String EGP_NEIGH_INTERVALHELLO_ALIAS  =  "egpNeighIntervalHello";
	public static final String EGP_NEIGH_INTERVALPOLL_ALIAS  =  "egpNeighIntervalPoll";
	public static final String EGP_NEIGH_MODE_ALIAS  =  "egpNeighMode";
	public static final String EGP_NEIGH_EVENTTRIGGER_ALIAS  =  "egpNeighEventTrigger";

	private static final String EGP_NEIGH_STATE = ".1.3.6.1.2.1.8.5.1.1";
	private static final String EGP_NEIGH_ADDR  =  ".1.3.6.1.2.1.8.5.1.2";
	private static final String EGP_NEIGH_AS = ".1.3.6.1.2.1.8.5.1.3";
	private static final String EGP_NEIGH_INMSGS   =  ".1.3.6.1.2.1.8.5.1.4";
	private static final String EGP_NEIGH_INERRS   =  ".1.3.6.1.2.1.8.5.1.5";
	private static final String EGP_NEIGH_OUTMSGS  =  ".1.3.6.1.2.1.8.5.1.6";
	private static final String EGP_NEIGH_OUTERRS  =  ".1.3.6.1.2.1.8.5.1.7";
	private static final String EGP_NEIGH_INERRMSGS   =  ".1.3.6.1.2.1.8.5.1.8";
	private static final String EGP_NEIGH_OUTERRMSGS  =  ".1.3.6.1.2.1.8.5.1.9";
	private static final String EGP_NEIGH_STATEUPS = ".1.3.6.1.2.1.8.5.1.10";
	private static final String EGP_NEIGH_STATEDOWNS  =  ".1.3.6.1.2.1.8.5.1.11";
	private static final String EGP_NEIGH_INTERVALHELLO  =  ".1.3.6.1.2.1.8.5.1.12";
	private static final String EGP_NEIGH_INTERVALPOLL   =  ".1.3.6.1.2.1.8.5.1.13";
	private static final String EGP_NEIGH_MODE  =  ".1.3.6.1.2.1.8.5.1.14";
	private static final String EGP_NEIGH_EVENTTRIGGER   =  ".1.3.6.1.2.1.8.5.1.15";
	
	public static NamedSnmpVar[] ms_elemList = null;
	
	static {
		// Changed array size from 7 to 6 because we are no longer going after
		// sysServices...sysServices is not currently being used and it causes
		// the entire SystemGroup collection to fail on at least one version
		// of Linux where it does not exist in the SNMP agent.
		//
		ms_elemList = new NamedSnmpVar[3];
		int ndx = 0;

		/**
		 * <P>
		 * </P>
		 */
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,EGP_NEIGH_STATE_ALIAS, EGP_NEIGH_STATE  , 1);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPIPADDRESS,EGP_NEIGH_ADDR_ALIAS, EGP_NEIGH_ADDR, 2);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,EGP_NEIGH_AS_ALIAS, EGP_NEIGH_AS  , 3);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_INMSGS_ALIAS, EGP_NEIGH_INMSGS , 4);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_INERRS_ALIAS, EGP_NEIGH_INERRS , 5);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_OUTMSGS_ALIAS, EGP_NEIGH_OUTMSGS, 6);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_OUTERRS_ALIAS, EGP_NEIGH_OUTERRS, 7);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_INERRMSGS_ALIAS, EGP_NEIGH_INERRMSGS , 8);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_OUTERRMSGS_ALIAS, EGP_NEIGH_OUTERRMSGS, 9);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_STATEUPS_ALIAS, EGP_NEIGH_STATEUPS  , 10);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPCOUNTER32,EGP_NEIGH_STATEDOWNS_ALIAS, EGP_NEIGH_STATEDOWNS, 11);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,EGP_NEIGH_INTERVALHELLO_ALIAS, EGP_NEIGH_INTERVALHELLO, 12);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,EGP_NEIGH_INTERVALPOLL_ALIAS, EGP_NEIGH_INTERVALPOLL , 13);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,EGP_NEIGH_MODE_ALIAS, EGP_NEIGH_MODE, 14);
		ms_elemList[ndx++] = new NamedSnmpVar(NamedSnmpVar.SNMPINT32,EGP_NEIGH_EVENTTRIGGER_ALIAS, EGP_NEIGH_EVENTTRIGGER , 15);
	}
	public static final String TABLE_OID = ".1.3.6.1.2.1.8.5.1";
	
	public int getEgpNeighState() {
		return getInt32(EGP_NEIGH_STATE);
	}

	public InetAddress getEgpNeighAddr() {
		return getIPAddress(EGP_NEIGH_ADDR);
	}

	public int getEgpNeighAs() {
		return getInt32(EGP_NEIGH_AS);
	}

	public int getEgpNeighInMsgs() {
		return getInt32(EGP_NEIGH_INMSGS);
	}

	public int getEgpNeighInErrs() {
		return getInt32(EGP_NEIGH_INERRS);
	}

	public int getEgpNeighOutMsgs() {
		return getInt32(EGP_NEIGH_OUTMSGS);
	}

	public int getEgpNeighOutErrs() {
		return getInt32(EGP_NEIGH_OUTERRS);
	}

	public int getEgpNeighInErrMsgs() {
		return getInt32(EGP_NEIGH_INERRMSGS);
	}

	public int getEgpNeighOutErrMsgs() {
		return getInt32(EGP_NEIGH_OUTERRMSGS);
	}

	public int getEgpNeighStateUps() {
		return getInt32(EGP_NEIGH_STATEUPS);
	}

	public int getEgpNeighStateDowns() {
		return getInt32(EGP_NEIGH_STATEDOWNS);
	}

	public int getEgpNeighIntervalHello() {
		return getInt32(EGP_NEIGH_INTERVALHELLO);
	}

	public int getEgpNeighIntervalPoll() {
		return getInt32(EGP_NEIGH_INTERVALPOLL);
	}

	public int getEgpNeighMode() {
		return getInt32(EGP_NEIGH_MODE);
	}

	public int getEgpNeighEventTrigger() {
		return getInt32(EGP_NEIGH_EVENTTRIGGER);
	}
}
