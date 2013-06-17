/**
 * 上海交通大学
 */
package org.infosec.ismp.manager.server.event.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;


/**
 * 静态参数存取
 * 
 * @author 沈建宇
 * @date 2009-6-22
 */
public class Constants {

	/**
	 * 从日志模块接收事件的vector
	 */
	public static List<NormalizedEvent> AUDITEVENT = new ArrayList<NormalizedEvent>();

	public static Vector<Eventmoni> MONIEVENT = new Vector<Eventmoni>();

	public static List<Object> totalValues = new ArrayList<Object>();

	public static synchronized List<NormalizedEvent> getAuditEventBatch() {
		List<NormalizedEvent> vBatch = new ArrayList<NormalizedEvent>();

		int i = AUDITEVENT.size();
		if (!AUDITEVENT.isEmpty()) {
			for (int j = 0; j < i; j++) {
				vBatch.add(AUDITEVENT.get(j));
			}
			AUDITEVENT.clear();
		}
		return vBatch;
	}

	/**
	 * 添加拓扑统计计算事件 addStatisticsEvent void
	 */
	public static synchronized void addAuditEvent(NormalizedEvent vEvent) {
		if (AUDITEVENT.size()>6000) {
			AUDITEVENT.clear();
		}
		AUDITEVENT.add(vEvent);
//		System.out.println("audit event size are " + AUDITEVENT.size());
	}


	public static synchronized Vector<Eventmoni> getMoniEventBatch() {
		Vector<Eventmoni> vMoni = new Vector<Eventmoni>();

		int i = MONIEVENT.size();
		if (!MONIEVENT.isEmpty()) {
			for (int j = 0; j < i; j++) {
				vMoni.add(MONIEVENT.get(j));
			}
			MONIEVENT.removeAllElements();
		}
//		System.out.println("---getMoniEventBatch()---" + vMoni);
		return vMoni;
	}

	/**
	 * 添加拓扑统计计算事件 addStatisticsEvent void
	 */
	public static synchronized void addMoniEvent(Eventmoni vEvent) {
		MONIEVENT.add(vEvent);
//		System.out.println("---addMoniEvent(Eventmoni vEvent)---" + MONIEVENT + "<--->" + vEvent);
	}

	public static synchronized List<Object> getTotalValueObject() {
		List<Object> total = new ArrayList<Object>();

		if (!totalValues.isEmpty()) {
			for (int j = 0; j < totalValues.size(); j++) {
				total.add(totalValues.get(j));
			}
			totalValues.clear();
		}
		return total;
	}

	public static synchronized void addTotalValue(List<Object> vTotalValue) {
		if (vTotalValue != null) {
			totalValues = vTotalValue;
		}
	}
}
