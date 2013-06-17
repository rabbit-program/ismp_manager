import org.infosec.ismp.manager.rmi.scm.model.PollStatus;
import org.infosec.ismp.manager.rmi.scm.service.OnLineServiceMonitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockPingGetWebclient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:ping/applicationContext-ping-rmi-client.xml");
		OnLineServiceMonitor checker = (OnLineServiceMonitor) context
				.getBean("pingServiceControllerClient");
		while (true) {
			PollStatus status = checker.getPingStatus("11111");
			System.out.println("status is : " + status);
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
