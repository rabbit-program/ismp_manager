/**
 * 上海交通大学
 */
package org.infosec.ismp.manager.server.event.process;

import java.util.List;

import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;
import org.infosec.ismp.manager.server.event.util.Constants;

/**
 * 测试用
 * @author  <a mailto:shenjianyu@edu.sjtu.cn>沈建宇</a>
 * @date 2009-6-22
 */
public class EventReceiveFromAudit extends Thread{
	
	public final EventGenerator eventGenerator; //事件生成器
	
	public EventReceiveFromAudit(){	
		eventGenerator = new EventGenerator();
	}
	
	/** 
	 * 负责生成并发送事件
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		while(true) {

			List<NormalizedEvent> auditEvents = eventGenerator.generateBatch();
//			System.out.println("uuuuuuuuuuuuuuuuuuuuu " + auditEvents.isEmpty() + " ttttttttt " + auditEvents.size());
		    if(auditEvents.isEmpty()) {
//		    	System.out.println("auditEvents is null!!!");
		    }else {
		    	for(int i = 0; i < auditEvents.size(); i++){
		    		Constants.addAuditEvent(auditEvents.get(i));
		    	}
		    }
//		    System.out.println(auditEvents.size());
		    try {
				Thread.sleep(10*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
