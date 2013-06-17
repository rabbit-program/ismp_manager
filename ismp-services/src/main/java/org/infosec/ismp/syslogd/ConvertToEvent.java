//
// This file is part of the OpenNMS(R) Application.
//
// OpenNMS(R) is Copyright (C) 2002-2009 The OpenNMS Group, Inc. All rights
// reserved.
// OpenNMS(R) is a derivative work, containing both original code, included
// code and modified
// code that was published under the GNU General Public License. Copyrights
// for modified
// and included code are below.
//
// OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
//
// Modifications:
//
// 2003 Jan 31: Cleaned up some unused imports.
// 2009 Mar 23: Add support for discarding messages. - jeffg@opennms.org
//
// Original code base Copyright (C) 1999-2001 Oculan Corp. All rights
// reserved.
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
//       
// For more information contact:
// OpenNMS Licensing <license@opennms.org>
// http://www.opennms.org/
// http://www.opennms.com/
//

package org.infosec.ismp.syslogd;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;

final class ConvertToEvent {

	/**
	 * Constructs a new event encapsulation instance based upon the
	 * information passed to the method. The passed datagram data is decoded
	 * into a string using the <tt>US-ASCII</tt> character encoding.
	 *
	 * @param packet The datagram received from the remote agent.
	 * @throws java.io.UnsupportedEncodingException
	 *          Thrown if the data buffer cannot be decoded using the
	 *          US-ASCII encoding.
	 * @throws MessageDiscardedException 
	 */
	static Event make(final DatagramPacket packet, final UeiList ueiList)
			throws UnsupportedEncodingException, MessageDiscardedException {
		return make(packet.getAddress(), packet.getPort(), packet.getData(),
				packet.getLength(), ueiList);
	}

	/**
	 * Constructs a new event encapsulation instance based upon the
	 * information passed to the method. The passed byte array is decoded into
	 * a string using the <tt>US-ASCII</tt> character encoding.
	 *
	 * @param addr The remote agent's address.
	 * @param port The remote agent's port
	 * @param data The XML data in US-ASCII encoding.
	 * @param len  The length of the XML data in the buffer.
	 * @throws java.io.UnsupportedEncodingException
	 *          Thrown if the data buffer cannot be decoded using the
	 *          US-ASCII encoding.
	 * @throws MessageDiscardedException 
	 */
	static Event make(final InetAddress addr, final int port,
			final byte[] data, final int len, final UeiList ueiList)
			throws UnsupportedEncodingException, MessageDiscardedException {

		ThreadCategory.setPrefix(Syslogd.LOG4J_CATEGORY);
		ThreadCategory log = ThreadCategory.getInstance();

		// Build a basic event out of the syslog message

		final Event event = new Event();
		event.setSource("syslogd");

		// Set nodeId

		// Set event host
		try {
			event.setHost(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException uhE) {
			event.setHost("unresolved.host");
			log.warn("Failed to resolve local hostname", uhE);
		}

		event.setNetInterface(addr.getHostAddress().replaceAll("/", ""));

		event.setTime(new Date());

		// FIXME

		final boolean traceEnabled = log
				.isEnabledFor(ThreadCategory.Level.TRACE);

		Pattern msgPat;
		Matcher msgMat;

		// Time to verify UEI matching.

		final List<UeiMatch> ueiMatch = ueiList.getUeiMatchCollection();
		if (ueiMatch == null) {
			log.warn("No ueiList configured.");
		} else {
			for (final UeiMatch uei : ueiMatch) {
				// 如果地址与配置中相同
				String ipAddr = uei.getIpAddr();
				if (!ipAddr.equals(addr.getHostAddress())) {
					continue;
				}

				String encoding = uei.getEncoding();
				if (encoding == null) {
					encoding = "utf-8";
				}

				String message = new String(data, 0, len, encoding);

				if (uei.getMatch().getType().equals("substr")) {
					if (traceEnabled) {
						log.trace("Attempting substring match for text of a Syslogd event to :"
								+ uei.getMatch().getExpression());
					}
					if (message.contains(uei.getMatch().getExpression())) {

						// We can pass a new UEI on this
						if (traceEnabled) {
							log.trace("Changed the UEI of a Syslogd event, based on substring match, to :"
									+ uei.getUei());
						}
						event.setUei(uei.getUei());
						// I think we want to stop processing here so the first
						// ueiMatch wins, right?
						break;
					}
				} else if (uei.getMatch().getType().equals("regex")) {
					if (traceEnabled) {
						log.trace("Attempting regex match for text of a Syslogd event to :"
								+ uei.getMatch().getExpression());
					}
					try {
						msgPat = Pattern.compile(
								uei.getMatch().getExpression(),
								Pattern.MULTILINE);
						msgMat = msgPat.matcher(message);
					} catch (PatternSyntaxException pse) {
						log.warn("Failed to compile regex pattern '"
								+ uei.getMatch().getExpression() + "'", pse);
						msgMat = null;
					}
					if ((msgMat != null) && (msgMat.matches())) {

						// We matched a UEI
						if (traceEnabled) {
							log.trace("Changed the UEI of a Syslogd event, based on regex match, to :"
									+ uei.getUei());
						}
						event.setUei(uei.getUei());
						if (msgMat.groupCount() > 0
								&& uei.getParameterAssignmentCount() > 0) {
							log.trace("Doing user-specified parameter assignments for this regex match.");
							for (ParameterAssignment assignment : uei
									.getParameterAssignmentCollection()) {

								String vettedValue = msgMat.group(assignment
										.getMatchingGroup());
								if (vettedValue == null)
									vettedValue = "";

								event.addParam(assignment.getParameterName(),
										vettedValue);

								if (traceEnabled) {
									log.trace("Added parm '"
											+ assignment.getParameterName()
											+ "' with value '"
											+ vettedValue
											+ "' to Syslogd event based on user-specified parameter assignment");
								}
							}
						}
						// I think we want to stop processing here so the first
						// ueiMatch wins, right?
						break;
					}
				}
			}
		}

		return event;
	}
}
