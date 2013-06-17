package org.infosec.ismp.manager.topo;

import org.infosec.ismp.manager.ping.PingLocator;
import org.infosec.ismp.manager.ping.WindowsPinger;
import org.infosec.ismp.manager.rmi.tm.discover.service.agent.ICMPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ICMPServiceImpl implements ICMPService {
	

	/**
	 * ping方法
	 * @param ip
	 * IP
	 * @param outTime
	 * 超时时间
	 * @param agentIp
	 * agent的IP
	 * @param agentPort
	 * agent的端口
	 * @return ping结果
	 */
	@Override
	public String ping(String ip, int outTime) throws Exception {
		return WindowsPinger.ping(ip);
	}

}
