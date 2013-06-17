import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.infosec.ismp.servicecheck.ServiceCheck;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ServiceCheckTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
		ServiceCheck serviceCheck=(ServiceCheck)context.getBean("serviceCheck");
		serviceCheck.start();
		Map dnsparameters = new HashMap();
		dnsparameters.put("port", "53");
		dnsparameters.put("lookup", "202.96.199.133");
		serviceCheck.addServiceCheck("001", "dns",30000,"202.96.199.133", dnsparameters);
//		
//		Map ftpparameters = new HashMap();
//		ftpparameters.put("port", "21");
//		ftpparameters.put("userid", "guoxw");
//		ftpparameters.put("password", "123456");
//		serviceCheck.addServiceCheck("002", "ftp",30000,"127.0.0.1", ftpparameters);
//		
		Map httpparameters = new HashMap();
		httpparameters.put("port", "80");
		httpparameters.put("url", "http://www.pudong.gov.cn");
		serviceCheck.addServiceCheck("003", "http",30000,"www.pudong.gov.cn", httpparameters);
		
//		Map httpsparameters = new HashMap();
//		httpsparameters.put("port", "8443");
//		httpsparameters.put("url", "https://localhost");
//		serviceCheck.addServiceCheck("004", "https",30000,"127.0.0.1",  httpsparameters);
		
//		Map icmpparameters = new HashMap();
//		icmpparameters.put("retry", "3");
//		icmpparameters.put("timeout", "3000");
//		serviceCheck.addServiceCheck("005", "icmp",30000,"127.0.0.1",  icmpparameters);
		
//		Map imapparameters = new HashMap();
//		imapparameters.put("port", "143");
//		imapparameters.put("retry", "3");
//		imapparameters.put("timeout", "3000");
//		serviceCheck.addServiceCheck("006", "imap",30000,"127.0.0.1",  imapparameters);
		
//		Map smtpparameters = new HashMap();
//		smtpparameters.put("port", "25");
//		smtpparameters.put("retry", "3");
//		smtpparameters.put("timeout", "3000");
//		serviceCheck.addServiceCheck("007", "smtp",30000,"smtp.163.com",  smtpparameters);
//		
//		Map smtpparameters = new HashMap();
//		smtpparameters.put("port", "25");
//		smtpparameters.put("retry", "3");
//		smtpparameters.put("timeout", "3000");
//		serviceCheck.addServiceCheck("008", "pop3",30000,"pop.163.com",  smtpparameters);
//		

	}

}
