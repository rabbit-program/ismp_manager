package org.infosec.ismp.trapd;

import java.lang.reflect.UndeclaredThrowableException;

import org.infosec.ismp.daemon.AbstractServiceDaemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
/**
 * snmp trap的主程序
 * @author lianglin
 *
 */
@Component
public class Trapd extends AbstractServiceDaemon{
	/**
	 * The name of the logging category for Syslogd.
	 */
	static final String LOG4J_CATEGORY = "ISMP.Trapd";
	
	private TrapNodeManager m_trapNodeManager;
	
	private SnmpTrapHandler m_handler;
	
	public Trapd() {
		super(LOG4J_CATEGORY);
	}


	@Override
	protected void onInit() {
		Assert.notNull(m_trapNodeManager, "m_trapNodeManager is null,please check");
	}
	
	@Override
	protected void onStart() {
		m_handler.setTrapNodeManager(m_trapNodeManager);
		m_handler.run();

		try {
			BroadcastEventProcessor m_eventReader = new BroadcastEventProcessor(m_trapNodeManager);
		} catch (Exception ex) {
			log().error("Failed to setup event reader", ex);
			throw new UndeclaredThrowableException(ex);
		}
	}

	@Autowired(required=true)
	public void setTrapNodeManager(TrapNodeManager trapNodeManager) {
		m_trapNodeManager = trapNodeManager;
	}

	@Autowired(required=true)
	public void setHandler(SnmpTrapHandler handler) {
		m_handler = handler;
	}

	
}
