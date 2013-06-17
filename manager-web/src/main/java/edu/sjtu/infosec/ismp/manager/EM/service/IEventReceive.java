/**
 * IEventReceiveImpl.java
 */
package edu.sjtu.infosec.ismp.manager.EM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.EM.model.Eventmoni;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventrealdisp;



/**
 * @author Jianyu Shen
 *
 * 2009-6-11 下午07:01:02
 * 
 * 提供被管理对象的控制接口
 * 有添加，删除和取出
 * 
 */
public interface IEventReceive {

    
    /**
     *RMI得到list
     * List<Eventrealdisp>
     */
	public List<Eventmoni> doNewEvents(String str);
	
	/**
	 * RMI得到实时事件列表
	 * List<Eventrealdisp>
	 */
	public List<Eventrealdisp> doRealtimeEvents(String str);

	
	/**
	 * 获取曲线图所需的list
	 * @return
	 */
	public List<Object> getDates();
	
	/**
	 * web向server传递告警参数
	 * @param mailAddress
	 * @param mailFrom
	 * @param mailPassword
	 * @param mmsIp
	 * @param mmsPort
	 */
	public void sendAlert(String mailAddress,String mailFrom,String mailPassword,String mmsIp,Integer mmsPort);
    
}
