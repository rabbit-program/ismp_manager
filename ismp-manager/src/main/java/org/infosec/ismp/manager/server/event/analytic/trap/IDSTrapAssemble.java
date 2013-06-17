package org.infosec.ismp.manager.server.event.analytic.trap;

import java.sql.Timestamp;

import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;

public class IDSTrapAssemble {

	/**
	 * @param 对启明星辰的数据进行装配
	 * @return
	 */
	public NormalizedEvent assemble(String[] parsedMessage) {
		NormalizedEvent event = new NormalizedEvent();
		event.setMessageType(parsedMessage[0]);
		event.setDevicetype("VenusTech_IDS");
		
		//其中40代表启明星辰威胁划分共40级
		event.setThrerank((Integer) (5 * Integer.parseInt(parsedMessage[1]) / 40));
		event.setSrcip(parsedMessage[2]);
		event.setSrcport(parsedMessage[3]);
		event.setDestip(parsedMessage[4]);
		event.setDestport(parsedMessage[5]);
		event.setProtocol(parsedMessage[6]);
		event.setMsg(parsedMessage[7]);
		if (!(parsedMessage[8].equals(""))) {
			// System.out.println(
			// parsedMessage[8
			// ]);
			event.setTimestamp(Timestamp.valueOf(parsedMessage[8] + ".0"));
		} else {
			event.setTimestamp(null);
		}
		return event;
	}
	
	/**
	 * 对三零鹰眼的IDS数据格式进行装配
	 * 
	 * @param parsedMessage
	 * @return
	 */
	public NormalizedEvent yingYanAssemble(String[] parsedMessage) {
		NormalizedEvent event = new NormalizedEvent();
		event.setTimestamp(Timestamp.valueOf(parsedMessage[0] + ".0"));
		event.setMessageType(parsedMessage[2].trim());
		event.setThrerank(Integer.parseInt(parsedMessage[3].trim()));
		String[] strs = parsedMessage[4].trim().split(":");
		event.setSrcip(strs[0].trim());
		if (strs.length>1 && strs[1]!=null && strs[1].trim().length()>0) {
			event.setSrcport(strs[1].trim());
		}
		strs = parsedMessage[5].trim().split(":");
		event.setDestip(strs[0].trim());
		if (strs.length>1 && strs[1]!=null && strs[1].trim().length()>0) {
			event.setDestport(strs[1].trim());
		}
		event.setProtocol(parsedMessage[6].trim());
		event.setDevicetype("HAWKEYE_IDS");
		return event;
	}
	
	/**
	 * 对绿盟的IDS数据进行装配
	 * 
	 * @param parsedMessage
	 * @return
	 */
	public NormalizedEvent iceyeAssemble(String[] parsedMessage) {
		NormalizedEvent event = new NormalizedEvent();
		event.setDevicetype("ICEYE_IDS");
		event.setSrcip(parsedMessage[4].trim());
		event.setDestip(parsedMessage[5].trim());
		int sport = Integer.parseInt(parsedMessage[6].trim());
		if (sport>0) {
			event.setSrcport(sport+"");
		}
		int dport = Integer.parseInt(parsedMessage[7].trim());
		if (dport>0) {
			event.setDestport(dport+"");
		}
		event.setTimestamp(new Timestamp(Long.parseLong(parsedMessage[12].trim())*1000));
		event.setMsg(parsedMessage[13].trim());
		event.setMessageType(parsedMessage[16].trim());
		event.setThrerank(Integer.parseInt(parsedMessage[18].trim()));
		return event;
	}

}
