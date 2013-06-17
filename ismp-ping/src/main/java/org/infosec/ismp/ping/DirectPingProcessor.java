package org.infosec.ismp.ping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;

import org.infosec.ismp.eventd.EventIpcManagerFactory;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.EventConstants;
import org.infosec.ismp.model.event.EventListener;
import org.infosec.ismp.util.ThreadCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/**
 * 直接Ping事件接受
 * @author lianglin
 *
 */
@Component
public class DirectPingProcessor implements EventListener {
	
	private DirectPingMessengerSend messenger;

	public final static String STATUS_UP = "UP";
	public final static String STATUS_DOWN = "DOWN";
	
	
	
	@Autowired(required=true)
	@Qualifier(value="directPingSend")
	public void setMessenger(DirectPingMessengerSend messenger) {
		this.messenger = messenger;
	}

	public DirectPingProcessor() {		
		subscribeEvent();
	}
	
	/**
	 * 注册事件
	 */
	private void subscribeEvent() {
		List<String> ueiList = new ArrayList<String>();

		ueiList.add(EventConstants.DIRECTPING_NODE_PING_UEI);

		EventIpcManagerFactory.init();
		EventIpcManagerFactory.getIpcManager().addEventListener(this, ueiList);
	}

	@Override
	public String getName() {
		return "directPing:DirectPingProcessor";
	}

	@Override
	public void onEvent(Event event) {
		ThreadCategory log = ThreadCategory.getInstance(getClass());
		String eventUei = event.getUei();
		String uuid =event.getUuid();
		if (eventUei == null)
			return;

		if (log.isDebugEnabled()) {
			log.debug("event is : "+event);
			log.debug("Received event: " + eventUei);
		}

		if (eventUei.equals(EventConstants.DIRECTPING_NODE_PING_UEI)) {
			String ipAddr = event.getIpAddr();
			InetAddress iaip;
			try {
				iaip = InetAddress.getByName(ipAddr);
			} catch (UnknownHostException e) {
				log().error("IP地址输入不正确！", e);
				return;			
			}
			Long pingtime = null;
			String status ;
			PingdModel model = new PingdModel();
			model.setUuid(uuid);
			model.setIpAddr(ipAddr);
			try {
				pingtime = Pinger.ping(iaip);// 获取PING通时间
			} catch (Exception e) {
				log().fatal(
						"DirectPingProcessor类onEvent()方法Pinger.ping异常！ipAdderss:"
								+ ipAddr, e);
			}
			if (pingtime == null)// 如果ping不通
			{
					log().debug(
							"DirectPingProcessor类onEvent()方法该地址现在无法ping通 ipAdderss:"
									+ ipAddr);				
				
				status = STATUS_DOWN;// 如果不通设置ping状态为1
			} else// 如果ping通
			{
				
					log().debug(
							"DirectPingProcessor类onEvent()方法该地址现在又可以ping通！ipAdderss:"
									+ ipAddr + "pingtime:"
									+ pingtime);				
				
				status = STATUS_UP;
				// 如果不通设置ping状态为0
			}
			model.setPingFlag(status);
			model.setResponseTime(pingtime);
			try {
				messenger.springSend(model);
				log().debug("ipAdderss:"
								+ ipAddr + "发功MQ队列消息成功！");
			} catch (Exception e) {
				log().fatal(
						"DirectPingProcessor类onEvent()方法发送MQ信息失败！ipAdderss:"
								+ ipAddr, e);
			}
			
			if (log.isDebugEnabled()) {
				log.debug("add DirectPing node to pingd : " + ipAddr);
			}

		} 
	}
	
	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

}
