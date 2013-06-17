package org.infosec.ismp.manager.rmi.event;

import java.util.List;

public interface IEventReceive {

    /**
     *RMI得到list
     * List<Eventrealdisp>
     */
	public <T> List<T> doNewEvents(String str);
	
	/**
	 * RMI得到实时事件列表
	 * List<Eventrealdisp>
	 */
	public <T> List<T> doRealtimeEvents(String domains);

	
	/**
	 * 获取曲线图所需的list
	 * @return
	 */
	public <T> List<T> getDates();
	
}
