package org.infosec.ismp.agent.winsensor;

import org.infosec.ismp.agent.winsensor.communication.services.HelloHandler;
import org.mortbay.jetty.Server;

/**
 * @author Rocky
 * @version create time：Sep 21, 2010 10:15:11 AM
 * 
 */
public class SimplestServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server(8080);
/*		SelectChannelConnector connector0 = new SelectChannelConnector();
		connector0.setPort(8080);
		connector0.setMaxIdleTime(30000);
		connector0.setRequestBufferSize(8192);

		SelectChannelConnector connector1 = new SelectChannelConnector();
		connector1.setHost("127.0.0.1");
		connector1.setPort(8888);
		connector1.setThreadPool(new QueuedThreadPool(20));
		connector1.setName("admin");*/

/*		SslSocketConnector ssl_connector = new SslSocketConnector();
		String jetty_home = System.getProperty("jetty.home",
				"../jetty-distribution/target/distribution");
		System.setProperty("jetty.home", jetty_home);
		ssl_connector.setPort(8443);
		ssl_connector.setKeystore(jetty_home + "/etc/keystore");
		ssl_connector.setPassword("OBF:1vny1zlo1x8e1vnw1vn61x8g1zlu1vn4");
		ssl_connector.setKeyPassword("OBF:1u2u1wml1z7s1z7a1wnl1u2g");
		server.addConnector(ssl_connector);*/

//		server.setConnectors(new Connector[] { connector0, connector1 });

		server.setHandler(new HelloHandler());
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
