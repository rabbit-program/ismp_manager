package org.infosec.ismp.manager.event;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;

/**
 * 将EventModel对象转换为String对象 用来UDP发送使用
 * 
 * @author jiel
 * 
 */
public class EventModelParse {
	/**
	 * 将NormalizedEvent对象转换为：EventModel
	 * 
	 * @param norEvent
	 * @param srcMod
	 *            事件产生模块信息
	 * @return
	 */
	public static EventModel conventToEventModel(NormalizedEvent norEvent,
			String srcMod) {
		EventModel model = new EventModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		model.setEventTime(sdf.format(norEvent.getTimestamp()));
		String eventTYpe = norEvent.getDevicetype().toLowerCase();
		if (eventTYpe.endsWith("ids")) {
			model.setEventType("ids");
		} else if (eventTYpe.endsWith("firewall")) {
			model.setEventType("firewall");
		} else {
			model.setEventType("antivirus");
		}
		model.setSeverity(norEvent.getThrerank().toString());
		model.setSrcMod(srcMod);
		model.setTargetAddr(norEvent.getDestip());
		return model;
	}

	/**
	 * 将一个事件对象转换为字符串对象
	 * 
	 * @param model
	 * @return
	 */
	public static String getEventModelParseString(EventModel model) {
		StringBuffer temp = new StringBuffer();
//		if (!"".equals(model.getEventId())) {
//			temp.append(model.getEventId());
//		}
//		temp.append(",");
		temp.append(model.getSrcMod());
		temp.append(",");
		temp.append(model.getEventTime());
		temp.append(",");
		temp.append(model.getEventType());
		temp.append(",");
		temp.append(model.getSeverity());
		temp.append(",");
		temp.append(model.getTargetAddr());
		temp.append(";");
		return temp.toString();
	}

	/**
	 * 将多个时间对象转换为字符串对象
	 * 
	 * @param model
	 * @return
	 */
	public static String getEventModelParseString(EventModel[] model) {
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < model.length; i++) {
//			if (!"".equals(model[i].getEventId())) {
//				temp.append(model[i].getEventId());
//			}
//			temp.append(",");
			temp.append(model[i].getSrcMod());
			temp.append(",");
			temp.append(model[i].getEventTime());
			temp.append(",");
			temp.append(model[i].getEventType());
			temp.append(",");
			temp.append(model[i].getSeverity());
			temp.append(",");
			temp.append(model[i].getTargetAddr());
			temp.append(";");

		}
		return temp.toString();
	}

	public static void main(String[] ages) {
		EventModel model = new EventModel();
		model.setEventId("111");
		model.setSrcMod("syslog");
		model.setEventTime("2010/10/10 12:30:23");
		model.setEventType("ids");
		model.setSeverity("3");
		model.setTargetAddr("127.0.0.1");
		EventModel model1 = new EventModel();
		// model1.setEventId("111");
		model1.setSrcMod("syslog");
		model1.setEventTime("2010/10/10 12:30:23");
		model1.setEventType("ids");
		model1.setSeverity("3");
		model1.setTargetAddr("127.0.0.1");
		EventModel[] modelArray = { model, model1 };
		// String eventString = EventModelParse.getEventModelParseString(model);
		String eventString = EventModelParse
				.getEventModelParseString(modelArray);
		System.out.println(eventString);

	}

}
