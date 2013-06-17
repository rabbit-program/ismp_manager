package org.infosec.ismp.manager.topo;

import org.infosec.ismp.collectd.SnmpGetterModel;
import org.infosec.ismp.manager.rmi.tm.discover.service.agent.SNMPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SNMPServiceImpl implements SNMPService {

	private SnmpGetterLocator locator;

	@Autowired(required=true)
	public void setLocator(SnmpGetterLocator locator) {
		this.locator = locator;
	}
	
	/**
	 * 获取snmp信息
	 * @param ip
	 * IP
	 * @param port
	 * 端口
	 * @param oid
	 * oid
	 * @param community
	 * 团体名
	 * @param outTime
	 * 超时时间
	 * @param agentIp
	 * agent的IP
	 * @param agentPort
	 * agent的端口
	 * @return snmp信息
	 */
	@Override
	public String snmpGet(String ip, int port, String oid, String community,
			int outTime) throws Exception {
		String getType = "String";
		SnmpGetterModel model = locator.snmpGetter(getType,"testDomain", ip, port, oid, community,outTime, 2);	
		if(model!=null){
			return model.getSnmpString();
		}
		return null;
	}

}
