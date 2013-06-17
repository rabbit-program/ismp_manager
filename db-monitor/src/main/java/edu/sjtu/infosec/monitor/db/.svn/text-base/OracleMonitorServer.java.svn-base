package edu.sjtu.infosec.monitor.db;

import edu.sjtu.infosec.monitor.db.oracle.OracleMonitorTask;
import edu.sjtu.infosec.monitor.db.oracle.OracleMonitorTaskScheduledExecutor;

/**
 * @author Rocky
 * @version create time：Aug 3, 2010 9:29:02 PM
 * 
 */
public class OracleMonitorServer {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OracleMonitorTaskScheduledExecutor os = new OracleMonitorTaskScheduledExecutor();
		os.init();
		System.out.println("初始化完毕！");
		OracleMonitorTask omt = new OracleMonitorTask();
		os.addListener(omt);
	}

}
