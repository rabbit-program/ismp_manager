package org.infosec.ismp.applet.manager.application.dynamicInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.task.GetDeviceInfoTask;

public class DynamicInfo {
	private static Map<String,List<Timer>> dynameMap = new HashMap<String,List<Timer>>();
	/**
	 * 添加一个Timer
	 * @param device 所属的Device
	 * @param timer
	 */
	@SuppressWarnings("unchecked")
	public static void addDynameTimer(String nodeId,Timer timer) {
		if(nodeId ==null || timer == null)return;
		if(!dynameMap.containsKey(nodeId)) {
			List<Timer> timerList = new ArrayList();
			timerList.add(timer);
			dynameMap.put(nodeId, timerList);
		} else {
			for(Object o : dynameMap.keySet()){
				if(o.equals(nodeId)) {
					List<Timer> list = dynameMap.get(o);
					list.add(timer);
					dynameMap.put(nodeId, list);
				}
		    }
		}
		
	}
	/**
	 * 停止一个设备所有的Timer
	 * @param device 该设备
	 */
	public static void stopDynameTimer(String nodeId) {
		for(Object o : dynameMap.keySet()){
			if(o.equals(nodeId)) {
				List<Timer> list = dynameMap.get(o);
				for(Timer timer:list) {
					timer.stop();
				}
				dynameMap.remove(nodeId);
			}
	    }
	}
	
	public static void startGetDynamicInfo(final NodeModel node) {
		new GetDeviceInfoTask(node).execute();
	}
	public static void stopGetDynamicInfo(NodeModel node) {
		stopDynameTimer(node.getNodeId());
	}
}
