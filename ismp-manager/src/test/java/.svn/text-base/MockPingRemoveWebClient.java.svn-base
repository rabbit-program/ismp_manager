import org.infosec.ismp.manager.rmi.scm.service.OnLineServiceMonitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MockPingRemoveWebClient {
   public static void main(String[] args) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:ping/applicationContext-ping-rmi-client.xml");
			OnLineServiceMonitor checker =(OnLineServiceMonitor)context.getBean("pingServiceControllerClient");
			checker.removeDevice("11111");
		}
}
