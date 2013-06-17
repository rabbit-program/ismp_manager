package org.infosec.ismp.manager.syslog.hillstone;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.infosec.ismp.model.syslog.MessageDiscardedException;
import org.infosec.ismp.model.syslog.Syslog;
import org.infosec.ismp.model.syslog.SyslogDefs;
import org.infosec.ismp.model.syslog.SyslogEntity;
import org.infosec.ismp.model.syslog.SyslogParser;
import org.infosec.ismp.model.syslog.SyslogTimeStamp;
import org.infosec.ismp.util.ThreadCategory;

public class HillStoneSyslogParse implements SyslogParser {

	public SyslogEntity parseSyslog(byte[] data, int len)
			throws UnsupportedEncodingException, MessageDiscardedException {
		String msg = new String(data, 0, len, "utf-8");
		int lbIdx = msg.indexOf('<');
		int rbIdx = msg.indexOf('>');

		if (lbIdx < 0 || rbIdx < 0 || lbIdx >= (rbIdx - 1)) {
			log().warn("Syslogd received an unparsable message!");
		}

		int priCode = 0;
		String priStr = msg.substring(lbIdx + 1, rbIdx);

		try {
			priCode = Integer.parseInt(priStr);
		} catch (final NumberFormatException ex) {
			log().debug("ERROR Bad priority code '" + priStr + "'");

		}

		final int facility = SyslogDefs.extractFacility(priCode);
		final int priority = SyslogDefs.extractPriority(priCode);

		final String priorityTxt = SyslogDefs.getPriorityName(priority);

		final String facilityTxt = SyslogDefs.getFacilityName(facility);

		SyslogEntity syslog = new SyslogEntity();
		syslog.setFacility(facilityTxt);
		syslog.setSeverity(priorityTxt);

		msg = msg.substring(rbIdx + 1, (msg.length()));

		// Check to see if message looks non-standard.
		// In this case, it means that there is not a standard
		// date in the front of the message text.
		boolean stdMsg = true;

		if (msg.length() < 16) {
			stdMsg = false;
		} else if (msg.charAt(3) != ' ' || msg.charAt(6) != ' '
				|| msg.charAt(9) != ':' || msg.charAt(12) != ':'
				|| msg.charAt(15) != ' ') {
			stdMsg = false;
		}

		String timestamp;

		if (!stdMsg) {
			try {
				timestamp = SyslogTimeStamp.getInstance().format(new Date());
			} catch (IllegalArgumentException ex) {
				log().debug("ERROR INTERNAL DATE ERROR!");
				timestamp = "";
			}
		} else {
			timestamp = msg.substring(0, 15);
			msg = msg.substring(16);
		}
		Date date;
		try {
			date = SyslogTimeStamp.getInstance().parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
		syslog.setCreateTime(date);

		msg = msg.trim();

		Pattern pattern = Pattern.compile("^(\\S*)\\s(.*)\\n?$",
				Pattern.MULTILINE);
		Matcher match = pattern.matcher(msg);

		if (match.matches()) {
			String hostName = match.group(1);
//			System.out.println("hostname is : " + hostName);
			String content = match.group(2);
//			System.out.println("content is : " + content);
			syslog.setHostname(hostName);
			syslog.setMsg(content);
		} else {
			log().warn("the regex expression not match");
			throw new MessageDiscardedException();
		}

		return syslog;
	}

	public boolean isRightSyslog(byte[] data, int len) {
		boolean flag = false;

		try {
			String msg = new String(data, 0, len, "utf-8");
			if (msg.contains("hillstone")) {
				flag = true;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return flag;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}


}
