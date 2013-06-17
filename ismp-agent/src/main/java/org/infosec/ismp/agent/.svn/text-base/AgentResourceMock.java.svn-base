package org.infosec.ismp.agent;

import java.net.URL;
import java.util.Enumeration;

import org.infosec.ismp.collectd.snmp.config.SnmpConfigFactory;
import org.infosec.ismp.collectd.snmp.configuration.Device;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

public class AgentResourceMock {
	public static void main(String[] args) throws Exception {
		String resolvedLocation = SystemPropertyUtils
				.resolvePlaceholders("classpath:snmpresources");
		URL url = ResourceUtils.getURL(resolvedLocation);
		SnmpConfigFactory.init(url.getFile());
		Enumeration<Device> devices = SnmpConfigFactory.getInstance()
				.enumerateDevice();

		while (devices.hasMoreElements()) {
			Device device = devices.nextElement();
			System.out.println(device.getType());
		}
	}
}
