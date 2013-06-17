package org.infosec.ismp.manager.server.event;

import org.infosec.ismp.manager.rmi.event.modle.TrapEvent;

public interface EventTrapReceive {
	
	public void trapAnalytic(TrapEvent trap,String domainId,String nodeId,String ip);
}
