/**
 * EventReceiveImpl.java
 */
package org.infosec.ismp.manager.server.event.eventRmiImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.manager.rmi.event.IEventReceive;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;
import org.infosec.ismp.manager.rmi.event.modle.Eventrealdisp;
import org.infosec.ismp.manager.server.event.util.ConfigContent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * RMI通信接口实现
 * 
 * @author Jianyu Shen
 * 
 *         2009-6-12 上午08:50:10
 */
public class EventReceiveImpl implements IEventReceive {

	private List<Eventrealdisp> date = new ArrayList<Eventrealdisp>();

	private EventRecivePipe eventRecivePipe;

	public void setEventRecivePipe(EventRecivePipe eventRecivePipe) {
		this.eventRecivePipe = eventRecivePipe;
	}
	
	
	List begin = new ArrayList();
	List temp = new ArrayList();
	List old = new ArrayList();
	
	// 作为服务端收到统计事件数据后写入 pipe容器
	public List<Eventmoni> doNewEvents(String str) {
		
		begin = eventRecivePipe.getNewEvents();
//		System.out.println("doNewEvents:--------" + begin.size());
		temp.addAll(begin);

		for (int i = 0; i < old.size(); i++) {
			for (int j = 0; j < begin.size(); j++) {
				if (!(((Eventmoni)(old.get(i))).getFaciIp()).equals(((Eventmoni)(begin.get(j))).getFaciIp())) {
					if (j == (begin.size() - 1)) {
						{
							temp.add(old.get(i));
						}
					} else {
						while(true){
						break;}
					}
				}else{break;}
			}
		}
			
		old.clear();
		old.addAll(temp);
		temp.clear();
		begin.clear();
//		System.out.println("doNewEvents:-old-------" + old.size());
		return old;
	}

	// 作为服务端收到实时事件数据后写入 pipe容器
	public List<Eventrealdisp> doRealtimeEvents(String str) {
		String[] ids = str.split(",");
		
		List<Eventrealdisp> list = eventRecivePipe.getRealtimeEvents();
		List<Eventrealdisp> res = new ArrayList<Eventrealdisp>();
		for (Eventrealdisp ev : list) {
			for (int i = 0; i < ids.length; i++) {
				if (ev.getDomain().equals(ids[i].trim())) {
					res.add(ev);
				}
			}

		}
//		System.out.println("RMI:--------" + list.size());
		if (date != null && date.size() > 0 && res != null && res.size() > 0) {
			if ((date.get(0).getEventTime()).equals(res.get(0).getEventTime())) {
				res.clear();
			}
		}

		if (res.size() > 0) {
			date = res;
		}
		return res;
	}

	public List<Object> getDates() {
//		System.out.println("RMI:-------List<Object> getDates()-");
		return eventRecivePipe.getDates();
	}
	
	public void sendAlert(String mailAddress,String mailFrom,String mailPassword,String mmsIp,Integer mmsPort){
		ConfigContent.mailAddress = mailAddress;
		ConfigContent.mailFrom = mailFrom;
		ConfigContent.mailPassword = mailPassword;
		ConfigContent.mmsIp = mmsIp;
		ConfigContent.mmsPort = mmsPort;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/applicationContext-resources.xml",
						"classpath:/applicationContext-resources-event.xml" });
		// System.out.println("dddddddddddddd");
	}

}
