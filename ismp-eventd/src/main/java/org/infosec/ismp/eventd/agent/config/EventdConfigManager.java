package org.infosec.ismp.eventd.agent.config;

public class EventdConfigManager implements EventdConfig {

	@Override
	public int getUDPPort() {
		return 5817;
	}

	@Override
	public String getUDPIpAddress() {
		return "127.0.0.1";
	}
	
	

}
