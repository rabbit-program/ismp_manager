package org.infosec.ismp.model.event;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

/**
 * This class holds all OpenNMS events related constants - the UEI's, parm
 * names, the event time format etc.
 * 
 * 
 */
public class EventConstants {

	/**
	 * The string property set on JMS messages to indicate the encoding to be
	 * used
	 */
	public static final String JMS_MSG_PROP_CHAR_ENCODING = "char_encoding";

	/**
	 * The value for the string property set on JMS messages to indicate the
	 * encoding to be used
	 */
	public static final String JMS_MSG_PROP_CHAR_ENCODING_VALUE = "US-ASCII";

	/**
	 * The string property set on JMS messages to indicate the sender service
	 */
	public static final String JMS_MSG_PROP_SENDER = "sender";

	/**
	 * The string property set on JMS messages broadcast from eventd - to use
	 * UEI(s) as a filter
	 */
	public static final String JMS_MSG_PROP_UEI_SELECTOR = "ueiSelector";

	//
	// the eventUEIs used by OpenNMS
	//

	

	//
	// Various event parms sent
	//
	/**
	 * The criticalPathIp used in determining if a node down event is due to a
	 * path outage
	 */
	public final static String PARM_CRITICAL_PATH_IP = "criticalPathIp";

	/**
	 * The criticalPathServiceName used in determining if a node down event is
	 * due to a path outage
	 */
	public final static String PARM_CRITICAL_PATH_SVC = "criticalPathServiceName";

	/**
	 * This parameter is set to true if a critical path outage has resulted in
	 * the supression of a notification
	 */
	public final static String PARM_CRITICAL_PATH_NOTICE_SUPRESSED = "noticeSupressed";

	/**
	 * This parameter is set to indicate the id of the demandPoll object to
	 * store the results of a demandPoll in
	 */
	public final static String PARM_DEMAND_POLL_ID = "demandPollId";

	/**
	 * The nodeSysName from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_SYSNAME = "nodesysname";

	/**
	 * The nodeSysDescription from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_SYSDESCRIPTION = "nodesysdescription";

	/**
	 * The nodeSysOid from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_SYSOID = "nodesysoid";

	/**
	 * The nodeSysLocation from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_SYSLOCATION = "nodesyslocation";

	/**
	 * The nodeSysContact from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_SYSCONTACT = "nodesyscontact";

	/**
	 * The ipHostName from the ipinterface table when sent as an event parm
	 */
	public final static String PARM_IP_HOSTNAME = "iphostname";

	/**
	 * The original ipHostName from the ipinterface table when sent as an event
	 * parm
	 */
	public final static String PARM_OLD_IP_HOSTNAME = "oldiphostname";

	/**
	 * Name of the method of discovery when sent as an event parm
	 */
	public final static String PARM_METHOD = "method";

	/**
	 * The interface sent as a parm of an event
	 */
	public final static String PARM_INTERFACE = "interface";

	/**
	 * The action sent as a parm of an event
	 */
	public final static String PARM_ACTION = "action";

	/**
	 * The DPName sent as a parm of an event
	 */
	public final static String PARM_DPNAME = "dpName";

	/**
	 * The old nodeid sent as a parm of the 'interfaceReparented' event
	 */
	public final static String PARM_OLD_NODEID = "oldNodeID";

	/**
	 * The new nodeid sent as a parm of the 'interfaceReparented' event
	 */
	public final static String PARM_NEW_NODEID = "newNodeID";

	/**
	 * The old ifIndex value sent as a parm of the 'interfaceIndexChanged' event
	 */
	public final static String PARM_OLD_IFINDEX = "oldIfIndex";

	/**
	 * The new ifIndex value sent as a parm of the 'interfaceIndexChanged' event
	 */
	public final static String PARM_NEW_IFINDEX = "newIfIndex";

	/**
	 * The nodeLabel from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_LABEL = "nodelabel";

	/**
	 * The nodeLabelSource from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_LABEL_SOURCE = "nodelabelsource";

	/**
	 * The oldNodeLabel sent as a parm of an event
	 */
	public final static String PARM_OLD_NODE_LABEL = "oldNodeLabel";

	/**
	 * The oldNodeLabelSource sent as a parm of an event
	 */
	public final static String PARM_OLD_NODE_LABEL_SOURCE = "oldNodeLabelSource";

	/**
	 * The newNodeLabel sent as a parm of an event
	 */
	public final static String PARM_NEW_NODE_LABEL = "newNodeLabel";

	/**
	 * The newNodeLabelSource sent as a parm of an event
	 */
	public final static String PARM_NEW_NODE_LABEL_SOURCE = "newNodeLabelSource";

	/**
	 * The nodeNetbiosName field from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_NETBIOS_NAME = "nodenetbiosname";

	/**
	 * The nodeDomainName field from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_DOMAIN_NAME = "nodedomainname";

	/**
	 * The operatingSystem field from the node table when sent as an event parm
	 */
	public final static String PARM_NODE_OPERATING_SYSTEM = "nodeoperatingsystem";

	/**
	 * The old value of the primarySnmpInterface field of the ipInterface table
	 * when sent as an event parm.
	 */
	public final static String PARM_OLD_PRIMARY_SNMP_ADDRESS = "oldPrimarySnmpAddress";

	/**
	 * The new value of the primarySnmpInterface field of the ipInterface table
	 * when sent as an event parm.
	 */
	public final static String PARM_NEW_PRIMARY_SNMP_ADDRESS = "newPrimarySnmpAddress";

	/**
	 * The first IP address in a range of IP addresses when sent as an event
	 * parm.
	 */
	public final static String PARM_FIRST_IP_ADDRESS = "firstIPAddress";

	/**
	 * The last IP address in a range of IP addresses when sent as an event
	 * parm.
	 */
	public final static String PARM_LAST_IP_ADDRESS = "lastIPAddress";

	/**
	 * The SNMP community string when sent as an event parm.
	 */
	public final static String PARM_COMMUNITY_STRING = "communityString";

	/**
	 * Service monitor qualifier when sent as an event parm
	 */
	public final static String PARM_QUALIFIER = "qualifier";

	/**
	 * The URL to which information is to be sent, sent as a parm to the rtc
	 * subscribe and unsubscribe events
	 */
	public final static String PARM_URL = "url";

	/**
	 * The category for which information is to be sent, sent as a parm to the
	 * rtc subscribe event
	 */
	public final static String PARM_CAT_LABEL = "catlabel";

	/**
	 * The username when sent as a parameter(like for the rtc subscribe)
	 */
	public final static String PARM_USER = "user";

	/**
	 * The passwd when sent as a parameter(like for the rtc subscribe)
	 */
	public final static String PARM_PASSWD = "passwd";

	/**
	 * The status of a service as returned from a service monitor
	 */
	public final static String PARM_SERVICE_STATUS = "serviceStatus";

	/**
	 * The external transaction number of an event to process.
	 */
	public final static String PARM_TRANSACTION_NO = "txno";

	/**
	 * The uei of a source event to report to external xmlrpc server.
	 */
	public final static String PARM_SOURCE_EVENT_UEI = "sourceUei";

	/**
	 * The message to explain a source event.
	 */
	public final static String PARM_SOURCE_EVENT_MESSAGE = "eventMessage";

	/**
	 * The status to indicate which kind of external xmlrpc command to invoke.
	 */
	public final static String PARM_SOURCE_EVENT_STATUS = "eventStatus";

	/**
	 * Used for retaining the reason from a monitor determines
	 * SERVICE_UNAVAILABLE
	 */
	public final static String PARM_LOSTSERVICE_REASON = "eventReason";

	/**
	 * Used for setting the value for PARM_LOSTSERVICE_REASON when the lost
	 * service is due to a critical path outage
	 */
	public final static String PARM_VALUE_PATHOUTAGE = "pathOutage";

	/**
	 * Parms used for passive status events sent to the PassiveServiceKeeper
	 */
	public final static String PARM_PASSIVE_NODE_LABEL = "passiveNodeLabel";
	public final static String PARM_PASSIVE_IPADDR = "passiveIpAddr";
	public final static String PARM_PASSIVE_SERVICE_NAME = "passiveServiceName";
	public final static String PARM_PASSIVE_SERVICE_STATUS = "passiveStatus";
	public final static String PARM_PASSIVE_REASON_CODE = "passiveReasonCode";

	/**
	 * Parm used to importer event
	 */
	public static final String PARM_FOREIGN_SOURCE = "foreignSource";
	public static final String PARM_FOREIGN_ID = "foreignId";

	/**
	 * Parms used for configureSnmp events
	 */
	public static final String PARM_VERSION = "version";
	public static final String PARM_TIMEOUT = "timeout";
	public static final String PARM_RETRY_COUNT = "retryCount";
	public static final String PARM_PORT = "port";

	public final static String PARM_LOCATION_MONITOR_ID = "locationMonitorId";

	/**
	 * Parm use for promoteEnqueuedData event
	 */
	public static final String PARM_FILES_TO_PROMOTE = "filesToPromote";

	/**
	 * Parameter used in event snmp poller definition
	 */
	public final static String PARM_SNMP_INTERFACE_IFINDEX = "snmpifindex";

	public final static String PARM_SNMP_INTERFACE_IP = "ipaddr";

	public final static String PARM_SNMP_INTERFACE_NAME = "snmpifname";

	public final static String PARM_SNMP_INTERFACE_DESC = "snmpifdescr";

	public final static String PARM_SNMP_INTERFACE_ALIAS = "snmpifalias";

	public final static String PARM_SNMP_INTERFACE_MASK = "mask";

	//
	// End event parms
	//

	/**
	 * Status code used to indicate which external xmlrpc command to invoke to
	 * report the occurrence of selected events.
	 */
	public final static int XMLRPC_NOTIFY_RECEIVED = 0;

	public final static int XMLRPC_NOTIFY_SUCCESS = 1;

	public final static int XMLRPC_NOTIFY_FAILURE = 2;

	/**
	 * Enumerated values for severity being indeterminate
	 * 
	 * @deprecated see OnmsSeverity.class
	 */
	@Deprecated
	public static final int SEV_INDETERMINATE = 1;

	/**
	 * Enumerated values for severity being unimplemented at this time
	 * 
	 * @deprecated see OnmsSeverity.class
	 */
	@Deprecated
	public static final int SEV_CLEARED = 2;

	/**
	 * Enumerated values for severity indicates a warning
	 * 
	 * @deprecated see OnmsSeverity.class
	 */
	@Deprecated
	public static final int SEV_NORMAL = 3;

	/**
	 * Enumerated values for severity indicates a warning
	 * 
	 * @deprecated see OnmsSeverity.class
	 */
	@Deprecated
	public static final int SEV_WARNING = 4;

	/**
	 * Enumerated values for severity is minor
	 * 
	 * @deprecated see OnmsSeverity.class
	 */
	@Deprecated
	public static final int SEV_MINOR = 5;

	/**
	 * Enumerated values for severity is major
	 * 
	 * @deprecated see OnmsSeverity.class
	 */
	@Deprecated
	public static final int SEV_MAJOR = 6;

	/**
	 * Enumerated values for severity is critical
	 * 
	 * @deprecated see OnmsSeverity.class
	 */
	@Deprecated
	public static final int SEV_CRITICAL = 7;

	/**
	 * Enumerated value for the state(tticket and forward) when entry is active
	 */
	public static final int STATE_ON = 1;

	/**
	 * Enumerated value for the state(tticket and forward) when entry is not
	 * active
	 */
	static final int STATE_OFF = 0;


	public static final String PARM_REASON = "reason";

	/**
	 * Used for indication the first endpoint to a map link
	 */
	public static final String PARM_ENDPOINT1 = "endPoint1";

	/**
	 * Used for indication the second endpoint to a map link
	 */
	public static final String PARM_ENDPOINT2 = "endPoint2";

	public static final String DISC_START_EVENT_UEI = "edu.sjtu.infosec.ismp";

	public static final String SPECIAL_SERVICE_LOST_EVENT_UEI = "uei.infosec.org/spservices/lostService";

	public static final String SPECIAL_SERVICE_REGAINED_EVENT_UEI = "uei.infosec.org/spservices/regainedService";

	public static final String AGENT_REGIESTER_EVENT_UEI = "uei.infosec.org/agentregister";

	public static final String SPECIAL_SERVICE_ADD_EVENT_UEI = "uei.infosec.org/config/spservices/addService";
	public static final String SPECIAL_SERVICE_DELETE_EVENT_UEI = "uei.infosec.org/config/spservices/deleteService";

	public static final String SYSLOGD_CONFIG_NODE_ADD_EVENT_UEI = "uei.ismp.org/config/syslogd/add";
	public static final String SYSLOGD_CONFIG_NODE_DELETE_EVENT_UEI = "uei.ismp.org/config/syslogd/delete";
	
	public static final String SYSLOG_EVENT_UEI_PRIFIX = "uei.ismp.org/syslogd/";

	public static final String EVENTSCONFIG_CHANGED_EVENT_UEI = "uei.ismp.org/eventd/configchange";

	public static final String PING_NODE_ADD_UEI = "uei.ismp.org/pingd/add";
	
	public static final String DIRECTPING_NODE_PING_UEI = "uei.ismp.org/directping/ping";

	public static final String PING_NODE_DELETE_UEI = "uei.ismp.org/pingd/delete";

	public static final String SITECHECK_NODE_ADD_UEI = "uei.ismp.org/sitecheck/add";
	
	public static final String SITECHECK_NODE_RESET_UEI = "uei.ismp.org/sitecheck/reset";

	public static final String SITECHECK_NODE_DELETE_UEI = "uei.ismp.org/sitecheck/delete";
	
	public static final String SNMPCOLLECTD_NODE_DELETE_UEI = "uei.ismp.org/snmpcollectd/delete";
	
	public static final String SNMPCOLLECTD_NODE_ADD_UEI = "uei.ismp.org/snmpcollectd/add";


	public static final String DB_COLLECT_NODE_ADD_UEI = "uei.ismp.org/dbcollectd/add";

	public static final String SERVICECHECK_NODE_ADD_UEI = "uei.ismp.org/servicecheck/add";

	public static final String DB_COLLECT_NODE_DELETE_UEI = "uei.ismp.org/dbcollectd/delete";

	public static final String SERVICECHECK_NODE_DELETE_UEI = "uei.ismp.org/servicecheck/delete";

	public static final String DIRECTSNMP_NODE_AVAILABLE_UEI = "uei.ismp.org/snmp/available";
	
	public static final String SNMPGETTER_NODE_GETSTRING_UEI = "uei.ismp.org/snmp/getstring";
	
	public static final String SNMPGETTER_NODE_GETCOLUMN_UEI = "uei.ismp.org/snmp/getcolumn";
	
	public static final String SNMPGETTER_NODE_GETTABLE_UEI = "uei.ismp.org/snmp/gettable";

	public static final String SNMPTRAP_NODE_ADD_UEI = "uei.ismp.org/snmptrap/add";

	public static final String SNMPTRAP_NODE_DELETE_UEI = "uei.ismp.org/snmptrap/delete";
	/**
	 * An utility method to parse a string into a 'Date' instance. Note that the
	 * string should be in the locale specific DateFormat.FULL style for both
	 * the date and time.
	 * 
	 * @see java.text.DateFormat
	 */
	public static final Date parseToDate(String timeString)
			throws ParseException {
		return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL)
				.parse(timeString);
	}

	/**
	 * An utility method to format a 'Date' into a string in the local specific
	 * FULL DateFormat style for both the date and time.
	 * 
	 * @see java.text.DateFormat
	 */
	public static final String formatToString(Date date) {
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL);
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		return df.format(date);
	}

	/**
	 * An utility method to format a 'Date' into a string in the local specific
	 * DEFALUT DateFormat style for both the date and time. This is used by the
	 * webui and a change here should get all time display in the webui changed.
	 * 
	 * @see java.text.DateFormat
	 * @deprecated This is no longer used by the UI. All WebUI-specific code
	 *             should under the org.opennms.web packages.
	 * @see org.opennms.web.Util.formatDateToUIString
	 */
	@Deprecated
	public static final String formatToUIString(Date date) {
		return DateFormat.getDateTimeInstance(DateFormat.SHORT,
				DateFormat.MEDIUM).format(date);
	}

	/**
	 * Converts the severity to an integer
	 * 
	 * @return integer equivalent for the severity
	 */
	public static int getSeverity(String sev) {
		int rc = SEV_INDETERMINATE;
		if (sev != null) {
			sev = sev.trim();
			if (sev.equalsIgnoreCase("normal")) {
				rc = SEV_NORMAL;
			} else if (sev.equalsIgnoreCase("warning")) {
				rc = SEV_WARNING;
			} else if (sev.equalsIgnoreCase("minor")) {
				rc = SEV_MINOR;
			} else if (sev.equalsIgnoreCase("major")) {
				rc = SEV_MAJOR;
			} else if (sev.equalsIgnoreCase("critical")) {
				rc = SEV_CRITICAL;
			} else if (sev.equalsIgnoreCase("cleared")) {
				rc = SEV_CLEARED;
			}
		}
		return rc;
	}

	/**
	 * Returns a severity constant as a printable string.
	 * 
	 * @param sev
	 * @return A capitalized String representing severity.
	 */
	public static String getSeverityString(int sev) {
		String retString = null;
		switch (sev) {
		case SEV_CLEARED:
			retString = "Cleared";
			break;
		case SEV_CRITICAL:
			retString = "Critical";
			break;
		case SEV_MAJOR:
			retString = "Major";
			break;
		case SEV_MINOR:
			retString = "Minor";
			break;
		case SEV_NORMAL:
			retString = "Normal";
			break;
		case SEV_WARNING:
			retString = "Warning";
			break;
		default:
			retString = "Indeterminate";
		}
		return retString;
	}

}
