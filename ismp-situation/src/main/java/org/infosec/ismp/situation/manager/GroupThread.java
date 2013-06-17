package org.infosec.ismp.situation.manager;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.infosec.ismp.situation.model.Event;

public class GroupThread extends Thread {
	
	///先入先出队列(线程安全)：这个队列用来存分组前收集到的事件。
	private BlockingQueue<Event> queueEvent;
	
	///先入先出队列(线程安全)：这个队列用来存分组后收集到的事件。
	private BlockingQueue<List<Event>> groupQueue;
	
	public GroupThread(BlockingQueue<Event> queueEvent,BlockingQueue<List<Event>> groupQueue){
		this.queueEvent = queueEvent;
		this.groupQueue = groupQueue;
	}
	
	@Override
	public void run() {
		try {
			queueEvent.take();
			
			
			
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
