package org.infosec.ismp.manager.syslog.hillstone;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.infosec.ismp.manager.model.HillStoneFireWall;
import org.infosec.ismp.model.event.EventNormalizationFilter;
import org.infosec.ismp.model.syslog.SyslogDeepParser;
import org.infosec.ismp.model.syslog.SyslogDefs;
import org.infosec.ismp.model.syslog.SyslogEntity;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HillstoneFireWallDeepParser implements SyslogDeepParser {

	private HillStoneFireWallService hillService;
	private EventNormalizationFilter eventNormalizationFilter;

	@Autowired(required=true)
	public void setHillService(HillStoneFireWallService hillService) {
		this.hillService = hillService;
	}

	@Autowired(required=true)
	public void setEventNormalizationFilter(
			EventNormalizationFilter eventNormalizationFilter) {
		this.eventNormalizationFilter = eventNormalizationFilter;
	}

	@Override
	public Runnable createProcessRunnable(final SyslogEntity syslog) {
		return new Runnable() {

			@Override
			public void run() {
				HillStoneFireWall hillstone = new HillStoneFireWall();

				String msg = syslog.getMsg();
//				String timestamp = syslog.getCreateTime();
				String hostname = syslog.getHostname();

				String ipaddr = syslog.getIpaddr();

				String facility = syslog.getFacility();
				String severity = syslog.getSeverity();
				String domain = syslog.getDomain();
				String logSource = syslog.getNodeid();

				// String msg =
				// "46083603 Traffic@FLOW: srcip 222.72.248.170, srcport 54645, dstip 202.120.200.7, dstport 443, protocol TCP, vr trust-vr, nattype dnat, transip 192.168.16.1, transport 443, ruleid 11";
				// 对msg做解析...并封装为HillStoneFireWall对象入库

				// String msg1 =
				// "44243602 Traffic@SECURITY: srcip 192.168.17.88, srcport 2043, dstip 202.120.200.7, dstport 443, protocol TCP, interface ethernet0/1, policyid 3, action: policy session start";
				Pattern pattern = Pattern
						.compile("^[^@]*@([^:]*):\\ssrcip\\s([^,]*),\\ssrcport\\s([^,]*),\\sdstip\\s([^,]*),\\sdstport\\s([^,]*),\\sprotocol\\s([^,]*),\\s(.*)");

				Matcher matcher = pattern.matcher(msg);
				if (matcher.find()) {
					String[] parsedMessage = new String[matcher.groupCount()];

					for (int k = 0; k < matcher.groupCount(); k++) {
						parsedMessage[k] = matcher.group(k + 1);

						// System.out.println(parsedMessage[k]);
					}

					hillstone.setMessageType(parsedMessage[0]);
					hillstone.setSrcip(parsedMessage[1]);
					hillstone.setSrcport(parsedMessage[2]);
					hillstone.setDestip(parsedMessage[3]);
					hillstone.setDestport(parsedMessage[4]);
					hillstone.setProtocol(parsedMessage[5]);
					hillstone.setMsg(parsedMessage[6]);

				}

				try {
					hillstone.setTimestamp(new Timestamp(syslog.getCreateTime().getTime()));
					hillstone.setHostname(hostname);
					hillstone.setIpaddr(ipaddr);
					hillstone.setLogSourceseQuence(logSource);
					hillstone.setFacility(SyslogDefs.getFacility(facility));
					hillstone.setSeverity(Integer.valueOf(SyslogDefs.getPriority(severity)));
					hillstone.setDomain(domain);

					hillService.saveHillstone(hillstone);
					eventNormalizationFilter.eventFilter(hillstone);
				} catch (Throwable e) {
					log().warn("",e);
				}
			}
		};
	}
	
	ThreadCategory log(){
		return ThreadCategory.getInstance(getClass());
	}
}
