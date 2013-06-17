/**
 * 上海交通大学
 */
package org.infosec.ismp.manager.server.event.listener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.FastHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.infosec.ismp.manager.rmi.aim.service.AlertManager;
import org.infosec.ismp.manager.rmi.aim.service.SendAlertService;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.server.event.process.EventSaveToDB;
import org.infosec.ismp.manager.server.event.util.ConfigContent;

import com.espertech.esper.client.EventBean;

/**
 * 
 * @author <a mailto:xxxx@edu.sjtu.cn>沈建宇</a>
 * @date 2009-7-7
 */
public class AlertEventListener extends BaseEventListener {

	// IOC注入，发告警
	private AlertManager sendAlertService;

	// IOC注入，发应急
	// private ContiEventService contiEventService;
	private EventSaveToDB eventSaveToDB;
	Eventrealdisp eventrealdisp;

	// ContiEvent contiEvent;

	List<Eventrealdisp> alertEvents = new ArrayList<Eventrealdisp>();

	// List<ContiEvent> contiEvents = new ArrayList<ContiEvent>();

	List<AlertInfoBO> alerts = new ArrayList<AlertInfoBO>();

	Object[] date = new Object[] {};
	FastHashMap map = new FastHashMap();
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * @param vComplexEventListener
	 */
	public AlertEventListener(ComplexEventListener vComplexEventListener,
			AlertManager sendAlertService,EventSaveToDB eventSaveToDB) {
		super(vComplexEventListener);
		map.setFast(true);
		this.sendAlertService = sendAlertService;
		map = eventSaveToDB.getTopoToMap();
//		map = new EventSaveToDB().getTopoToMap();
		// TODO Auto-generated constructor stub
	}

	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		// System.out.println("test alert events");
		if (newEvents != null) {
			// System.out.println("test alert events is or not null");
			
			eventrealdisp = new Eventrealdisp();
			for (int i = 0; i < newEvents.length; i++) {
				alerts.clear();
				AlertInfoBO alertBO = new AlertInfoBO();
				eventrealdisp.setDestIp((String) newEvents[i].get("destip"));
				eventrealdisp.setEventType((String) newEvents[i]
						.get("messageType"));
				eventrealdisp.setFaciType((String) newEvents[i]
						.get("devicetype"));
				eventrealdisp.setSrcIp((String) newEvents[i].get("srcip"));
				eventrealdisp.setDomain(newEvents[i].get("domain").toString());
				if (newEvents[i].get("srcport") != null) {
					eventrealdisp.setSrcPort(Integer.valueOf(newEvents[i].get(
							"srcport").toString()));
				}
				if (newEvents[i].get("destport") != null) {
					eventrealdisp.setDestPort(Integer.valueOf(newEvents[i].get(
							"destport").toString()));
				}
				eventrealdisp.setThreRank((Integer) newEvents[i]
						.get("threrank"));
				eventrealdisp.setFaciIp((String) newEvents[i].get("ipaddr"));
				eventrealdisp.setEventTime((Timestamp) newEvents[i]
						.get("timestamp"));
				eventrealdisp.setDescrip((String) newEvents[i].get("msg"));
				eventrealdisp
						.setProtType((String) newEvents[i].get("protocol"));

				// TODO Auto-generated constructor stub

				String srcstr = newEvents[i].get("srcip") + ":1";
				
//				System.out.println("--newEvents-size-" + newEvents.length + "---srcstr---" + srcstr);

				if (map.containsKey(srcstr)) {
					Object[] obj = (Object[]) map.get(srcstr);
					// if (obj[5] != null && obj[6] != null) {
					String alert = newEvents[i].get("devicetype")
							+ "设备:发现有威胁等级为"
							+ newEvents[i].get("threrank").toString().trim()
							+ "的"
							+ newEvents[i].get("messageType").toString().trim()
							+ "事件产生！其源地址IP为：" + newEvents[i].get("srcip")
							+ "; 目的地址的IP是：" + newEvents[i].get("destip") + "．";
					if (newEvents[i].get("msg") != null
							&& newEvents[i].get("msg").toString().trim()
									.length() > 0) {
						alert = alert + "事件描述：" + newEvents[i].get("msg");
					}

					if (newEvents[i].get("devicetype").toString().trim()
							.contains("IDS")) {
						alertBO.setDomain_id((Integer) newEvents[i].get("domain"));
						alertBO.setAlertReason("事件安全级别高于 3 级");
						alertBO.setAlertType("事件告警");
						alertBO.setAlertSubType("IDS事件");
						alertBO.setIfnew(1);
						alertBO.setRawContent(alert);
						alertBO.setTime(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()))));
						alertBO.setSrcIP(newEvents[i].get("srcip").toString());
						alertBO.setType("事件管理");
						

						alerts.add(alertBO);
					} else if (newEvents[i].get("devicetype").toString().trim()
							.contains("FIREWALL")) {
						alertBO.setDomain_id((Integer) newEvents[i].get("domain"));
						alertBO.setAlertReason("事件安全级别高于 3 级");
						alertBO.setAlertType("事件告警");
						alertBO.setAlertSubType("防火墙事件");
						alertBO.setIfnew(1);
						alertBO.setRawContent(alert);
						alertBO.setTime(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()))));
						alertBO.setSrcIP(newEvents[i].get("srcip").toString());
						alertBO.setType("事件管理");
					
						alerts.add(alertBO);
					}
				}
				if (alerts != null && alerts.size() > 0) {
					try {
						sendAlertService.addAlertInfo(alerts.get(0));

						System.out
								.println("--------------发送告警！！！！----------------");
						log.debug("发送告警！！！！");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		}

	}

}
