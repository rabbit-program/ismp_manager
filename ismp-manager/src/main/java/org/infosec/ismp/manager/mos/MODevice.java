package org.infosec.ismp.manager.mos;
/**
 * 代表被管理设备
 * @author lianglin
 *
 */
public class MODevice extends ManagedObjectComponent {
	/**
	 * 该设备的设备信息
	 */
    protected final MODeviceInfo m_deviceInfo;
    
    /**
     * 用设备信息创建一个设备类
     * @param deviceInfo
     */
    public MODevice(MODeviceInfo deviceInfo){
    	this.m_deviceInfo = deviceInfo;
    }

	public MODeviceInfo getDeviceInfo() {
		return m_deviceInfo;
	}
    
    
    
}
