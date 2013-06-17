import org.infosec.ismp.manager.rmi.scm.service.OnLineServiceMonitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟Web端调用manager
 * 
 * @author lianglin
 * 
 */
public class MockPingWebClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:ping/applicationContext-ping-rmi-client.xml");
		OnLineServiceMonitor checker =(OnLineServiceMonitor)context.getBean("pingServiceControllerClient");
		checker.addDevice("testDomain", "11111", "192.168.9.254", 1000, false);
	}
}
