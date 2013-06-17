package edu.sjtu.infosec.monitor.db.oracle;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import edu.sjtu.infosec.monitor.db.utils.PropertiesUtil;

/**
 * @author Rocky
 * @version create time：Aug 3, 2010 9:27:50 PM
 * 
 */
public class OracleMonitorTaskScheduledExecutor implements Runnable{
	private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
	private ThreadPoolExecutor threadPool = null;
	
	private long initialDelay;
	private long period;
	private int corePoolSize;
	private int maxinumPoolSize;
	private long keepAliveTime;
	
	private List<Runnable> listeners = new CopyOnWriteArrayList<Runnable>();
	
	public void init() {
		loadConfig("application.properties");
		threadPool = new ThreadPoolExecutor(corePoolSize, maxinumPoolSize, keepAliveTime, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(50), new ThreadPoolExecutor.DiscardPolicy());
		service.scheduleAtFixedRate(new Thread(this, "DB Thread"), initialDelay, period, TimeUnit.SECONDS);
	}
	
	private void loadConfig(String configFileName) {
		PropertiesUtil util = new PropertiesUtil();
		Properties prop = util.load(configFileName);
		
		initialDelay = Long.parseLong(prop.getProperty("schedule.initialDelay", "10"));
		period = Long.parseLong(prop.getProperty("schedule.period", "60"));
		
		corePoolSize = Integer.parseInt(prop.getProperty("schedule.corePoolSize", "2"));
		maxinumPoolSize = Integer.parseInt(prop.getProperty("schedule.maxinumPoolSize", "3"));
		keepAliveTime = Long.parseLong(prop.getProperty("schedule.keepAliveTime", "3"));
	}

	public void addListener(Runnable listener) {
		listeners.add(listener);
	}
	
	public void removeListener(Runnable listener) {
		listeners.remove(listener);
	}
	
	public void run() {
		System.out.println(listeners.size());
		if (listeners.size() > 0) {
			for (Runnable listener : listeners) {
				threadPool.execute(listener);
			}
		}
	}
}
