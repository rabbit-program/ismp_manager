package edu.sjtu.infosec.ismp.manager.TM.discover.comm.attribute;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 全局属性类
 * @author Wu Guojie
 * @date 2009-6-12
 * @version 1.0
 */
public class BaseAttribute {
	/**
	 * 搜索是否正在进行
	 */
	public static boolean TOPO_SEARCH_STATE_RUNNING = false;
	/**
	 * 搜索计数
	 */
	public static int TOPO_SEARCH_RUNNING_COUNT = 0;
	/**
	 * 最后活跃时间
	 */
	public static long lastActiveTime = 0;
	/**
	 * 全局属性
	 */
	private static BaseAttribute baseAttribute = null;
	/**
	 * 构造器
	 */
	private BaseAttribute(){}
	/**
	 * 实例化全局属性
	 * @return 全局属性
	 */
	public static BaseAttribute getInstance(){
		if(baseAttribute == null){
			baseAttribute = new BaseAttribute();
		}
		return baseAttribute;
	}
	/**
	 * 设置最后活跃时间
	 */
	public static void setLastActiveTime() {
		BaseAttribute.lastActiveTime = System.currentTimeMillis();
	}
	
	/**
	 * 运行搜索
	 */
	public static void running(){
		TOPO_SEARCH_STATE_RUNNING = true;
		TOPO_SEARCH_RUNNING_COUNT = TOPO_SEARCH_RUNNING_COUNT + 1;
		setLastActiveTime();
		startTimer();
	}

	/**
	 * 停止搜索
	 */
	public static void stopped(){
		TOPO_SEARCH_STATE_RUNNING = false;
		TOPO_SEARCH_RUNNING_COUNT = TOPO_SEARCH_RUNNING_COUNT - 1;
	}
	
	/**
	 * 启动定时器
	 */
	public static void startTimer(){
		final Timer timer = new Timer();
		timer.schedule(new TimerTask(){
	        @Override
	        public void run() {
	        	checkIsActive(timer);
	        }
	    }, 0, 10*1000);
	}
	
	/**
	 * 检查是否有人占用资源又不进行搜索，如果有，则终止其占用的资源
	 */
	public static void checkIsActive(Timer timer){
    	long currentTime = System.currentTimeMillis();
    	if(TOPO_SEARCH_STATE_RUNNING){
        	if((currentTime-lastActiveTime) > 2*60*1000){
        		stopped();
        		timer.cancel();
        	}
    	}else{
    		timer.cancel();
    	}
	}
}
