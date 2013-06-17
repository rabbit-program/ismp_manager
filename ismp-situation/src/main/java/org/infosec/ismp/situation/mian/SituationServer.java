package org.infosec.ismp.situation.mian;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.infosec.ismp.situation.calculate.substep.AttackReckon;
import org.infosec.ismp.situation.calculate.substep.IllicitConnectReckom;
import org.infosec.ismp.situation.calculate.substep.VirusReckon;
import org.infosec.ismp.situation.calculate.substep.callable.result.ResultExponential;
import org.infosec.ismp.situation.manager.AcquireExponential;
import org.infosec.ismp.situation.manager.SituationProcess;
import org.infosec.ismp.situation.manager.UdpReceiveThread;
import org.infosec.ismp.situation.model.Event;
import org.infosec.ismp.situation.service.impl.SituationPipe;
import org.infosec.ismp.situation.util.ConstantSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 态势服务主启动类
 * @author cc
 * 2010-10-11 16:48:11
 */
public class SituationServer {
	
	private static Logger logger = Logger.getLogger(SituationServer.class);
	
	///先入先出队列(线程安全)：这个队列用来存分组前收集到的事件。
	private BlockingQueue<Event> eventQueue = new ArrayBlockingQueue<Event>(ConstantSource.CACHEFIRSTSIZE);
	
	///先入先出队列(线程安全)：这个队列用来存分组后收集到的事件。
	private BlockingQueue<List<Event>> groupQueue = new ArrayBlockingQueue<List<Event>>(ConstantSource.CACHESECONDSIZE);
	
	public SituationServer() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{
						"classpath*:applicationContext-resources.xml",
						"classpath*:applicationContext-dao-situation.xml",
						"classpath*:applicationContext-service-situation.xml",
						"classpath*:applicationContext-situation-process-service.xml",
						"classpath*:applicationContext-situation-rmi.xml"
				});
		
		//开启一个单一线程的有序的线程池
		ExecutorService singlePool = Executors.newFixedThreadPool(1);
		
		//开启一个5-10线程的线程池
		ThreadPoolExecutor execPool = new ThreadPoolExecutor(5, 25, 3,
				TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
		CompletionService<ResultExponential> completionService = new ExecutorCompletionService<ResultExponential>(
				execPool);
		///攻击事件指数计算器
		AttackReckon attackReckon = (AttackReckon) context.getBean("attackReckon");
		attackReckon.setCompletionService(completionService);
		
		///病毒事件指数计算器
		VirusReckon virusReckon = (VirusReckon) context.getBean("virusReckon");
		virusReckon.setCompletionService(completionService);
		
		///非法连接指数计算器
		IllicitConnectReckom illicitConnectReckom = (IllicitConnectReckom) context.getBean("illicitConnectReckom");
		illicitConnectReckom.setCompletionService(completionService);
		
		///udp接收事件数据报线程。
		UdpReceiveThread receiveThread = new UdpReceiveThread(eventQueue);
		///启动udp接收事件数据报线程。将接收到的数据报解析成事件，并且将事件放入队列。
		receiveThread.start();
		
		///态势处理。
		SituationProcess situationProcess = (SituationProcess) context.getBean("situationProcess");
		situationProcess.setQueueEvent(eventQueue);
		
		AcquireExponential aeProcess = (AcquireExponential) context.getBean("acquireExponential");
		aeProcess.setCompletionService(completionService);
		aeProcess.setExecPool(singlePool);
		
		SituationPipe situationPipe = (SituationPipe) context.getBean("situationPipe");///保存态势值的管道
		
		situationProcess.start();///启动调度先入先出队列(事件分组)线程。
		aeProcess.start();
		
		try {
			while(true){
//				System.out.println("（主线程）队列大小为：" + eventQueue.size());
//				System.out.println("主机态势：" + situationPipe.getMachineSituation().size());
//				System.out.println("机柜态势：" + situationPipe.getMachineCabinetSituation().size());
//				System.out.println("机房态势：" + situationPipe.getMachineRoomSituation().size());
//				System.out.println("安全域态势：" + situationPipe.getSecurityAreaSituation().size());
//				System.out.println("======================");
				Thread.sleep(1000);///每一秒钟检测队列的大小。
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Author：cchang
	 * @param args
	 * 2010-10-11 16:48:18
	 */
	public static void main(String[] args) {
		new SituationServer();
	}

}
