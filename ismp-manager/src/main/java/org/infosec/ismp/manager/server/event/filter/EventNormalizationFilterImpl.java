package org.infosec.ismp.manager.server.event.filter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.infosec.ismp.manager.model.HillStoneFireWall;
import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;
import org.infosec.ismp.manager.server.event.util.Constants;
import org.infosec.ismp.model.event.EventNormalizationFilter;
import org.springframework.stereotype.Component;

@Component
public class EventNormalizationFilterImpl implements EventNormalizationFilter {

	public <T> void eventFilter(T t) {
		if(t instanceof HillStoneFireWall){
			HillStoneFireWall hillStoneFireWall = (HillStoneFireWall)t;
			
			if(hillStoneFireWall.getSrcip()!=null && hillStoneFireWall.getDestip()!=null){
				NormalizedEvent normalizedEvent = new NormalizedEvent();
				try {
					BeanUtils.copyProperties(normalizedEvent, hillStoneFireWall);
					
					normalizedEvent.setDevicetype("HillStone_FIREWALL");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				//FIXME 发送给态势模块
				Constants.addAuditEvent(normalizedEvent);
			}
			
		}
		//FIXME 新设备，添加一个if判断
	}
	
	public static void main(String[] args) {
		String message = "HillStone_FIREWALL";
		System.out.println(message.indexOf("FIREWALL"));
	}
}
