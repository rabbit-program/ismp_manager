package org.infosec.ismp.syslogd;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

import org.infosec.ismp.model.syslog.MessageDiscardedException;
import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.util.ThreadCategory;

final class ConvertToEvent {

	/**
	 * Constructs a new event encapsulation instance based upon the information
	 * passed to the method. The passed datagram data is decoded into a string
	 * using the <tt>US-ASCII</tt> character encoding.
	 * 
	 * @param packet
	 *            The datagram received from the remote agent.
	 * @throws java.io.UnsupportedEncodingException
	 *             Thrown if the data buffer cannot be decoded using the
	 *             US-ASCII encoding.
	 * @throws MessageDiscardedException
	 */
	static RawSyslog make(final DatagramPacket packet, final List<SyslogNode> ueiList)
			throws  MessageDiscardedException {
		return make(packet.getAddress(), packet.getPort(), packet.getData(),
				packet.getLength(), ueiList);
	}

	/**
	 * Constructs a new event encapsulation instance based upon the information
	 * passed to the method. The passed byte array is decoded into a string
	 * using the <tt>US-ASCII</tt> character encoding.
	 * 
	 * @param addr
	 *            The remote agent's address.
	 * @param port
	 *            The remote agent's port
	 * @param data
	 *            The XML data in US-ASCII encoding.
	 * @param len
	 *            The length of the XML data in the buffer.
	 * @throws java.io.UnsupportedEncodingException
	 *             Thrown if the data buffer cannot be decoded using the
	 *             US-ASCII encoding.
	 * @throws MessageDiscardedException
	 */
	static RawSyslog make(final InetAddress addr, final int port,
			final byte[] data, final int len, final List<SyslogNode> ueiList)
			throws MessageDiscardedException {

		ThreadCategory.setPrefix(Syslogd.LOG4J_CATEGORY);
		ThreadCategory log = ThreadCategory.getInstance();

//		// Build a basic event out of the syslog message
//
//		SyslogWrapper syslogWrapper = null;
////		event.setSource("syslogd");
		
		RawSyslog syslog = null;

		String fromIp = addr.getHostAddress();
		log.debug("the syslog packe if from ip " + fromIp);

		final boolean traceEnabled = log
				.isEnabledFor(ThreadCategory.Level.TRACE);

		
		if (ueiList == null) {
			log.warn("no syslog node match configure,please check");
			throw new MessageDiscardedException();
		}

		for (SyslogNode ueiMatch : ueiList) {
			String matchIp = ueiMatch.getIpAddr();
			if (fromIp.equals(matchIp)) {
				log.debug("find the ip match " + matchIp);
				syslog = new RawSyslog();
				
				syslog.setIpaddr(fromIp);
				syslog.setNodeid(ueiMatch.getNodeid());
				byte[] rdata = Arrays.copyOf(data, len);
				syslog.setContents(rdata);
				//TODO: SET AGENT ID
				break;
                
//				String syslogParserType = ueiMatch.getSyslogType();
//				if (log.isDebugEnabled()) {
//					log.debug("syslog parser type is : " + syslogParserType);
//				}
//				SyslogParser  parser = SyslogdParserMgrFactory.getSyslogdParserMgr().getSyslogParser(syslogParserType);
//				if (parser == null) {
//					throw new MessageDiscardedException();
//				} else {
//					boolean test = parser.isRightSyslog(data, len);
//					if (test) {
//						Syslog syslog = parser.parseSyslog(data, len);
//						syslog.setIpaddr(matchIp);
//						syslogWrapper = new SyslogWrapper();
//						syslogWrapper.setSyslog(syslog);
//						syslogWrapper.setFromIp(matchIp);
//						syslogWrapper.setLogSource(ueiMatch.getSyslogSrcId());
//						syslogWrapper.setDomain(ueiMatch.getDomainId());
////						event.setSyslog(syslogWrapper);
//						syslogWrapper.setUei(parser.createSyslogUei(EventConstants.SYSLOG_EVENT_UEI_PRIFIX, syslog));
//						break;
//					}
//				}
//
			}
		}

//		try {
//			event.setHost(InetAddress.getLocalHost().getHostName());
//		} catch (UnknownHostException uhE) {
//			event.setHost("unresolved.host");
//			log.warn("Failed to resolve local hostname", uhE);
//		}
//
//		syslogWrapper.setFromIp(addr.getHostAddress().replaceAll("/", ""));
//
//		event.setTime(EventConstants.formatToString(new Date()));
//		event.setUuid(UUID.randomUUID().toString());
        if(syslog==null){
        	throw new MessageDiscardedException();
        }
		return syslog;
	}

}
